package com.supergo.goods.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.goods.service.GoodsSearchService;
import com.supergo.goods.service.GoodsService;
import com.supergo.pojo.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsSearchService goodsSearchService;

    @PostMapping
    public HttpResult post(@RequestBody Goods goods) {
        goodsService.add(goods);
        return HttpResult.ok();
    }

    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable("id") Long id) {
        goodsService.deleteByIds(new Long[]{id});
        return HttpResult.ok();
    }

    @PutMapping("/{id}")
    public HttpResult put(@PathVariable("id") Long id, @RequestBody Goods goods) {
        goods.setId(id);
        goodsService.add(goods);
        return HttpResult.ok();
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Long id) {
        return HttpResult.ok(goodsService.findOne(id));
    }

    @PostMapping("/query/{page}/{size}")
    public HttpResult query(@PathVariable(value = "page") Integer page,
                            @PathVariable(value = "size") Integer size,
                            @RequestBody Goods goods) {
        // 添加必要条件
        goods.setIsDelete("0");
        goods.setIsMarketable("1");

        return HttpResult.ok(goodsService.query(page, size, goods));
    }

    /**
     * 构建商品搜索索引和文档
     */
    @GetMapping("/documents/build")
    public HttpResult buildAllSearchDocuments() {
        goodsSearchService.buildAllSearchDocuments();
        return HttpResult.ok();
    }

    /**
     * 重建商品搜索索引和文档
     */
    @GetMapping("/documents/rebuild")
    public HttpResult rebuildSearchDocuments() {
        goodsSearchService.rebuildAllSearchDocuments();
        return HttpResult.ok();
    }

    /**
     * 创建、更新商品搜索索引
     */
    @PutMapping("/index")
    public HttpResult putSearchIndex() {
        goodsSearchService.putSearchIndex();
        return HttpResult.ok();
    }

    /**
     * 删除商品搜索索引
     */
    @DeleteMapping("/index")
    public HttpResult deleteSearchIndex() {
        goodsSearchService.deleteSearchIndex();
        return HttpResult.ok();
    }

    /**
     * 查看商品搜索索引
     */
    @GetMapping("/index")
    public HttpResult getSearchIndex() {
        return HttpResult.ok(goodsSearchService.getSearchIndex());
    }

    /**
     * 创建指定商品搜索文档
     *
     * @param id 商品id，也是搜索文档id
     */
    @PostMapping("/documents/{id}")
    public HttpResult createSearchDocument(@PathVariable("id") Long id) {
        return HttpResult.ok(goodsSearchService.createSearchDocument(id));
    }

    /**
     * 删除指定商品搜索文档
     *
     * @param id 商品id
     */
    @DeleteMapping("/documents/{id}")
    public HttpResult deleteSearchDocument(@PathVariable("id") String id) {
        return HttpResult.ok(goodsSearchService.deleteSearchDocument(id));
    }

    /**
     * 创建或更新指定商品搜索文档
     *
     * @param id 商品id
     */
    @PutMapping("/documents/{id}")
    public HttpResult putSearchDocument(@PathVariable("id") Long id) {
        return HttpResult.ok(goodsSearchService.putSearchDocument(id));
    }

    /**
     * 查看指定商品搜索文档
     *
     * @param id 商品id
     */
    @GetMapping("/documents/{id}")
    public HttpResult getSearchDocument(@PathVariable("id") String id) {
        return HttpResult.ok(goodsSearchService.getSearchDocument(id));
    }

    /**
     * 使用关键字搜索商品
     *
     * @param keyword 搜索关键字
     * @param filterKeyValues 其它过滤条件，格式为[字段:内容],多个用过滤条件用@分隔，比如brandName:华为@category3Name:5G
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public HttpResult search(@RequestParam("keyword") String keyword,
                             @RequestParam(value = "filters", required = false) String filterKeyValues,
                             @RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size) {

        // filterKeyValues = "brand_name:华为@cname3:5G"; // 测试
        Map<String, String> filters = getFilters(filterKeyValues);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("搜索关键字keyword: {}", keyword);
            LOGGER.debug("搜索过滤条件filters: {} -> {}", filterKeyValues, filters);
            LOGGER.debug("搜索结果页数page: {}", page);
            LOGGER.debug("搜索结果页大小size: {}", size);
        }

        return HttpResult.ok(goodsSearchService.search(keyword, filters, page, size));
    }

    /**
     * 从String参数中的过滤查询条件封装到Map<String,String>中
     *
     * @param filterKeyValues String类型查询过滤条件参数
     * @return
     */
    private Map<String, String> getFilters(String filterKeyValues) {

        Map<String, String> filters = null;

        if (!StringUtils.isEmpty(filterKeyValues)) {
            String filterSeparator = "@"; // 过滤条件之间的分隔符
            String keyValueSeparator = ":"; // 键值分隔符

            String[] keyValues = filterKeyValues.split(filterSeparator);

            if (keyValues.length > 0) {
                filters = new HashMap<>(keyValues.length);
            }

            for (String keyValue : keyValues) {
                String[] kv = keyValue.split(keyValueSeparator);
                // 如果存在过滤查询条件关键字
                if (kv.length > 0 && !StringUtils.isEmpty(kv[0])) {
                    if (kv.length > 1 && null != kv[1]) {
                        filters.put(kv[0], kv[1]);
                    } else {
                        filters.put(kv[0], "");
                    }
                }
            }
        }

        return filters;
    }
}
