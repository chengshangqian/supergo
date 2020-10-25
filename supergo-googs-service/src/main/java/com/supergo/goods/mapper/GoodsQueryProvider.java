package com.supergo.goods.mapper;

import com.supergo.pojo.Goods;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityField;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class GoodsQueryProvider {

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsQueryProvider.class);

    public String query(Goods goods) {
        Class<Goods> goodsClass = Goods.class; // 实体类
        EntityTable goodsEntityTable = EntityHelper.getEntityTable(goodsClass); // 实体-表对象
        Map<String, EntityColumn> propertyEntityColumns = goodsEntityTable.getPropertyMap(); // 属性-列对象集合

        SQL sql = new SQL();

        sql.SELECT(SqlHelper.getAllColumns(goodsClass));
        sql.FROM(goodsEntityTable.getName());

        // 遍历所有的属性-列，检测当前查询对象对应属性是否有赋值，如果有赋值，则将对应属性字段将拼装到SQL语句中
        propertyEntityColumns.forEach((property, column) -> {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("开始尝试拼装{}属性...", property);
            }

            EntityField field = column.getEntityField();
            try {
                // TODO 反射效率低
                if (null != field.getValue(goods)) {
                    String condition = "";
                    // 产品名称和副标题使用模糊查询 TODO 注入风险
                    if (property.equals("goodsName") || property.equals("caption")) {
                        condition = String.format("%s like concat(concat('%%',#{%s}), '%%')", column.getColumn(), property);
                    } else {
                        condition = String.format("%s = #{%s}", column.getColumn(), property);
                    }
                    sql.WHERE(condition);
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("{}属性拼装成功...", property);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException ex) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn("尝试使用属性[{}]的getter方法获取属性值时出错 ： {}，将放弃此属性字段的拼装...", property, ex.getMessage());
                }
            }
        });

        if (!StringUtils.isEmpty(EntityHelper.getOrderByClause(goodsClass))) {
            sql.ORDER_BY(EntityHelper.getOrderByClause(goodsClass));
        }

        return sql.toString();
    }
}
