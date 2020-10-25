package com.supergo.portal.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.portal.service.SearchGoodsService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "商品搜索")
@RequestMapping("/goods")
public class SearchGoodsController {
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchGoodsController.class);

    @Autowired
    private SearchGoodsService searchGoodsService;

    @ApiOperation(value = "导入商品信息到ES", notes = "将数据库中的商品初始化到ES中，为后续搜索建立查询基础")
    @GetMapping("/import")
    public void importAllGoods() {
        searchGoodsService.importAllGoods();
    }

    @ApiOperation(value = "搜索商品", notes = "根据关键字和过滤条件搜索商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "搜索关键字"),
            @ApiImplicitParam(name = "filters", value = "查询过滤条件，将被转化为ES的布尔查询过滤条件", required = false),
            @ApiImplicitParam(name = "page", value = "分页页数", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "分页大小", defaultValue = "10")
    })
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

        return HttpResult.ok(searchGoodsService.search(keyword, filters, PageRequest.of(page, size)));
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

            if(keyValues.length > 0) {
                filters = new HashMap<>(keyValues.length);
            }

            for (String keyValue : keyValues) {
                String[] kv = keyValue.split(keyValueSeparator);
                // 如果存在过滤查询条件关键字
                if(kv.length > 0 && !StringUtils.isEmpty(kv[0])){
                    if(kv.length > 1 && null != kv[1]){
                        filters.put(kv[0], kv[1]);
                    }
                    else {
                        filters.put(kv[0], "");
                    }
                }
            }
        }

        return filters;
    }
}
