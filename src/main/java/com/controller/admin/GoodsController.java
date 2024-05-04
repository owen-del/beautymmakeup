package com.controller.admin;

import com.entity.Goods;
import com.response.ResponseResult;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品管理
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public ModelAndView goods(@RequestParam(value = "name", defaultValue = "") String name, ModelAndView modelAndView) {
        List<Goods> goodsList = goodsService.findByNameLike(name);
        modelAndView.setViewName("/admin/goods/goods");
        modelAndView.addObject("list", goodsList);
        return modelAndView;
    }

    /**
     * 删除商品
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        goodsService.deleteById(id);
        return "redirect:/admin/goods/goods";
    }


    /**
     * 订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Goods goods = goodsService.findById(id);
        modelAndView.setViewName("/admin/goods/details");
        modelAndView.addObject("goods", goods);
        modelAndView.addObject("op", "商品详情");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return goodsService.deleteBatch(ids);
    }

}
