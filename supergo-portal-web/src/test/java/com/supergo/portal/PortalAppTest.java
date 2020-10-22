package com.supergo.portal;

import com.supergo.portal.dao.ItemRepository;
import com.supergo.portal.entity.Item;
import org.apache.commons.math.stat.descriptive.summary.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PortalAppTest {

    // 打印日志
    public static final Logger LOGGER = LoggerFactory.getLogger(PortalAppTest.class);

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void createIndex(){
        LOGGER.debug("准备创建索引...");
        LOGGER.debug("获取IndexOperations...");
        IndexOperations ops = elasticsearchRestTemplate.indexOps(Product.class);
        boolean exists = ops.exists();
        LOGGER.debug("索引是否已存在？ : {}",exists);
        if(!exists){
            boolean result = ops.create();//创建索引
            assertTrue(result);
            LOGGER.debug("创建索引成功？ : {}",result);
            //ops.createMapping(Product.class);//创建映射
        }
    }

    @Test
    public void addDocument() {
        //创建对象
        Item item = new Item();
        item.setId(1L);
        item.setItemName("华为Nova7");
        item.setItemDesc("华为2020年最新5G手机");
        item.setItemPrice(new BigDecimal(2999.99D));

        //保存对象 -> 保存到ES中
        Item saveItem = itemRepository.save(item);
        assertTrue(null != saveItem);
        LOGGER.debug("创建文档成功？ : {}", saveItem);
    }

    @Test
    //查询
    public void findDocument() {
        //springData的单体查询,结果会封装到Optional对象
        Optional<Item> result = itemRepository.findById( 1l);
        //取出封装的查询结果
        Item item = result.get();
        LOGGER.debug("查询文档成功？ : {}", item);
    }

    @Test
    public void updateDocument() {
        Optional<Item> result = itemRepository.findById( 1l);
        Item item = result.get();

        LOGGER.debug("查询文档成功？ : {}", item);

        item.setItemName("华为Nova7pro");
        item.setItemPrice(new BigDecimal(3999.99D));

        //记录存在就是修改, 不存在就是添加
        Item updateItem = itemRepository.save(item);
        LOGGER.debug("更新文档成功？ : {}", updateItem);
    }

    @Test
    public void deleteDocument() {
        itemRepository.deleteById(1l);
        LOGGER.debug("删除文档成功");
    }
}