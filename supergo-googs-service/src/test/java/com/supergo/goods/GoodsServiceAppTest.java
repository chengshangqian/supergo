package com.supergo.goods;

import static org.junit.jupiter.api.Assertions.*;

import com.supergo.common.page.PageResult;
import com.supergo.goods.service.GoodsService;
import com.supergo.goods.service.ItemService;
import com.supergo.mapper.ItemMapper;
import com.supergo.mapper.TUserMapper;
import com.supergo.pojo.Goods;
import com.supergo.pojo.Item;
import com.supergo.pojo.TUser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// @SpringBootTest(classes = GoodsServiceApp.class) // 测试主类和和源码主类的包路径相同，可以不需要指定，除非多个配置源
@SpringBootTest
class GoodsServiceAppTest {

    // 打印日志
    public static final Logger LOGGER = LoggerFactory.getLogger(GoodsServiceAppTest.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private GoodsService goodsService;

    @Test
    void testQuery(){
        Goods goods = new Goods();
        goods.setIsDelete("0");
        goods.setIsMarketable("1");
        goods.setGoodsName("华为");
        // 分页组件从第1页开始
        PageResult pageResult = goodsService.query(1, 10, goods);
        LOGGER.debug("testQuery : {}",pageResult);
    }

    @Test
    void contextLoads() {
        testItemServiceFindPage();
        testTUserMapperSelectAll();
        testTUserMapperTotalCount();
        testTUserMapperGetOneUser();
        testItemMapperSelectByPrimaryKey();
    }

    void testItemServiceFindPage() {
        PageResult pageResult = itemService.findPage(1, 10);
        LOGGER.debug("testItemServiceFindPage : {}",pageResult);
    }

    void testTUserMapperSelectAll() {
        List<TUser> tUserList = tUserMapper.selectAll();
        LOGGER.debug("testTUserMapperSelectAll : {}",tUserList);
    }

    void testTUserMapperTotalCount() {
        int totalCount = tUserMapper.totalCount();
        assertTrue(totalCount >= 0);
        LOGGER.debug("testTUserMapperTotalCount : {}",totalCount);
    }

    void testTUserMapperGetOneUser() {
        int oneUser = tUserMapper.getOneUser(1);
        assertTrue(oneUser >= 0);
        LOGGER.debug("testTUserMapperGetOneUser : {}",oneUser);
    }

    void testItemMapperSelectByPrimaryKey() {
        Item item = itemMapper.selectByPrimaryKey(917460);
        LOGGER.debug("testItemMapperSelectByPrimaryKey : {}",item);
    }
}