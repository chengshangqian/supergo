package com.supergo.goods;

import static org.junit.jupiter.api.Assertions.*;

import com.supergo.common.page.PageResult;
import com.supergo.goods.dao.GoodsSearchRepository;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private GoodsSearchRepository goodsSearchRepository;

    @Test
    void createIndex(){
        LOGGER.debug("准备创建索引...");
        LOGGER.debug("获取IndexOperations...");
        IndexOperations ops = elasticsearchRestTemplate.indexOps(Goods.class);
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
    void addDocument() {
        //创建对象
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setGoodsName("华为Nova7");
        goods.setCaption("华为2020年最新5G手机");
        goods.setPrice(new BigDecimal(2999.99D));

        //保存对象 -> 保存到ES中
        Goods saveGoods = goodsSearchRepository.save(goods);
        assertNotNull(saveGoods);
        LOGGER.debug("创建文档成功？ : {}", saveGoods);
    }

    @Test
    void addDocumentAll() {
        //创建对象
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setGoodsName("华为Nova7");
        goods.setCaption("华为2020年最新5G手机");
        goods.setPrice(new BigDecimal(2999.99D));
        //保存对象 -> 保存到ES中
        Goods saveGoods = goodsSearchRepository.save(goods);
        assertNotNull(saveGoods);

        Goods sumsang = new Goods();
        sumsang.setId(2L);
        sumsang.setGoodsName("三星Galaxy10");
        sumsang.setCaption("三星折叠手机之王");
        sumsang.setPrice(new BigDecimal(4999.99D));
        goodsSearchRepository.save(sumsang);

        Goods apple = new Goods();
        apple.setId(3L);
        apple.setGoodsName("苹果Iphone12");
        apple.setCaption("苹果新一代手机力作");
        apple.setPrice(new BigDecimal(6999.99D));
        goodsSearchRepository.save(apple);
    }

    @Test
        //查询
    void findDocument() {
        //springData的单体查询,结果会封装到Optional对象
        Optional<Goods> result = goodsSearchRepository.findById( 1L);
        //取出封装的查询结果
        if(result.isPresent()){
            Goods goods = result.get();
            LOGGER.debug("查询文档成功？ : {}", goods);
        }
    }

    @Test
    void updateDocument() {
        Optional<Goods> result = goodsSearchRepository.findById( 1L);
        if(result.isPresent()){
            Goods goods = result.get();
            LOGGER.debug("查询文档成功？ : {}", goods);
            LOGGER.debug("查询文档成功？ : {}", goods);

            goods.setGoodsName("华为Nova7pro");
            goods.setPrice(new BigDecimal(3999.99D));

            //记录存在就是修改, 不存在就是添加
            Goods updateGoods = goodsSearchRepository.save(goods);
            LOGGER.debug("更新文档成功？ : {}", updateGoods);
        }
    }

    @Test
    void deleteDocument() {
        goodsSearchRepository.deleteById(1L);
        LOGGER.debug("删除文档成功");
    }

    @Test
    void findByGoodsNameOrGoodsDesc() {
        String keyword = "5G";
        // 排序字段
        String id = "id";
        // ES的分页组件从第0页开始
        Pageable pageable = PageRequest.of(0,10, Sort.by(Sort.Direction.ASC,id));
        Page<Goods> results = goodsSearchRepository.findByGoodsNameOrCaption(keyword,keyword, pageable);
        results.getContent().forEach(goods -> {
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("goods => {}", goods);
            }
        });
    }

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