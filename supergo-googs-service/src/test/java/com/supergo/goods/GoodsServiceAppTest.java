package com.supergo.goods;

import static org.junit.jupiter.api.Assertions.*;

import com.supergo.common.page.PageResult;
import com.supergo.goods.dao.ProductRepository;
import com.supergo.goods.entity.Product;
import com.supergo.goods.service.ItemService;
import com.supergo.mapper.ItemMapper;
import com.supergo.mapper.TUserMapper;
import com.supergo.pojo.Item;
import com.supergo.pojo.TUser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    void contextLoads() {
        testItemServiceFindPage();
        testTUserMapperSelectAll();
        testTUserMapperTotalCount();
        testTUserMapperGetOneUser();
        testItemMapperSelectByPrimaryKey();
    }

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ProductRepository productRepository;

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
        Product product = new Product();
        product.setId(1L);
        product.setProductName("华为Nova7");
        product.setProductDesc("华为2020年最新5G手机");
        product.setProductPrice(new BigDecimal(2999.99D));

        //保存对象 -> 保存到ES中
        Product saveProduct = productRepository.save(product);
        assertTrue(null != saveProduct);
        LOGGER.debug("创建文档成功？ : {}", saveProduct);
    }

    @Test
    //查询
    public void findDocument() {
        //springData的单体查询,结果会封装到Optional对象
        Optional<Product> result = productRepository.findById( 1l);
        //取出封装的查询结果
        Product product = result.get();
        LOGGER.debug("查询文档成功？ : {}", product);
    }

    @Test
    public void updateDocument() {
        Optional<Product> result = productRepository.findById( 1l);
        Product product = result.get();

        LOGGER.debug("查询文档成功？ : {}", product);

        product.setProductName("华为Nova7pro");
        product.setProductPrice(new BigDecimal(3999.99D));

        //记录存在就是修改, 不存在就是添加
        Product updateProduct = productRepository.save(product);
        LOGGER.debug("更新文档成功？ : {}", updateProduct);
    }

    @Test
    public void deleteDocument() {
        productRepository.deleteById(1l);
        LOGGER.debug("删除文档成功");
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