package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    /**
     * 商品管理
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public String goods() {
        return "/admin/goods/goods";
    }

}
