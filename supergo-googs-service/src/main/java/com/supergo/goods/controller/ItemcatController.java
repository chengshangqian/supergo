package com.supergo.goods.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.goods.service.ItemcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemcats")
public class ItemcatController {

    @Autowired
    private ItemcatService itemcatService;

    @GetMapping
    public HttpResult categories() {
        return HttpResult.ok(itemcatService.categories());
    }
}
