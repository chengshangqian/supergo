package com.supergo.goods.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.goods.service.BrandService;
import com.supergo.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public HttpResult post(@RequestBody Brand brand) {
        brandService.add(brand);
        return HttpResult.ok();
    }

    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable("id") Long id) {
        brandService.deleteByIds(new Long[]{id});
        return HttpResult.ok();
    }

    @PutMapping("/{id}")
    public HttpResult put(@PathVariable("id") Long id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.add(brand);
        return HttpResult.ok();
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Long id) {
        return HttpResult.ok(brandService.findOne(id));
    }

    @PostMapping("/query/{page}/{size}")
    public HttpResult query(@PathVariable(value = "page") Integer page,
                            @PathVariable(value = "size") Integer size,
                            @RequestBody Brand brand) {
        return HttpResult.ok(brandService.findPage(page, size, brand));
    }
}
