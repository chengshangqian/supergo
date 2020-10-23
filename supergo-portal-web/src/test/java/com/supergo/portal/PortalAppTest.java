package com.supergo.portal;

import com.supergo.portal.dao.GoodsRepository;
import com.supergo.portal.entity.Goods;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PortalAppTest {

    // 打印日志
    private static final Logger LOGGER = LoggerFactory.getLogger(PortalAppTest.class);

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private GoodsRepository goodsRepository;

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
        goods.setGoodsDesc("华为2020年最新5G手机");
        goods.setGoodsPrice(new BigDecimal(2999.99D));

        //保存对象 -> 保存到ES中
        Goods saveGoods = goodsRepository.save(goods);
        assertNotNull(saveGoods);
        LOGGER.debug("创建文档成功？ : {}", saveGoods);
    }

    @Test
    void addDocumentAll() {
        //创建对象
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setGoodsName("华为Nova7");
        goods.setGoodsDesc("华为2020年最新5G手机");
        goods.setGoodsPrice(new BigDecimal(2999.99D));
        //保存对象 -> 保存到ES中
        Goods saveGoods = goodsRepository.save(goods);
        assertNotNull(saveGoods);

        Goods sumsang = new Goods();
        sumsang.setId(2L);
        sumsang.setGoodsName("三星Galaxy10");
        sumsang.setGoodsDesc("三星折叠手机之王");
        sumsang.setGoodsPrice(new BigDecimal(4999.99D));
        goodsRepository.save(sumsang);

        Goods apple = new Goods();
        apple.setId(3L);
        apple.setGoodsName("苹果Iphone12");
        apple.setGoodsDesc("苹果新一代手机力作");
        apple.setGoodsPrice(new BigDecimal(6999.99D));
        goodsRepository.save(apple);
    }

    @Test
    //查询
    void findDocument() {
        //springData的单体查询,结果会封装到Optional对象
        Optional<Goods> result = goodsRepository.findById( 1L);
        //取出封装的查询结果
        if(result.isPresent()){
            Goods goods = result.get();
            LOGGER.debug("查询文档成功？ : {}", goods);
        }
    }

    @Test
    void updateDocument() {
        Optional<Goods> result = goodsRepository.findById( 1L);
        if(result.isPresent()){
            Goods goods = result.get();
            LOGGER.debug("查询文档成功？ : {}", goods);
            LOGGER.debug("查询文档成功？ : {}", goods);

            goods.setGoodsName("华为Nova7pro");
            goods.setGoodsPrice(new BigDecimal(3999.99D));

            //记录存在就是修改, 不存在就是添加
            Goods updateGoods = goodsRepository.save(goods);
            LOGGER.debug("更新文档成功？ : {}", updateGoods);
        }
    }

    @Test
    void deleteDocument() {
        goodsRepository.deleteById(1L);
        LOGGER.debug("删除文档成功");
    }

    @Test
    void findByGoodsNameOrGoodsDesc() {
        String keywords = "5G";
        // 排序字段
        String searchGoodsId = "goods_id";
        Pageable pageable = PageRequest.of(0,10, Sort.by(Sort.Direction.ASC,searchGoodsId));
        Page<Goods> results = goodsRepository.findByGoodsNameOrGoodsDesc(keywords,keywords, pageable);
        results.getContent().forEach(goods -> {
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("searchGoods => {}", goods);
            }
        });
    }
}