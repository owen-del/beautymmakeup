package com.controller.admin;

import cn.hutool.core.lang.Console;
import com.entity.Category;
import com.entity.Goods;
import com.entity.User;
import com.response.ResponseResult;
import com.service.CategoryService;
import com.service.GoodsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    // 商品类别
    @Autowired
    private CategoryService categoryService;

    /**
     * 商品管理
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public ModelAndView goods(@RequestParam(value = "name", defaultValue = "") String name, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        List<Goods> goodsList = goodsService.findByNameLike(loginUser,name);
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

    @RequestMapping(value = "/lockOrUpGoods/{id}", method = RequestMethod.GET)
    public String lockOrUpGoods(@PathVariable("id") Long id) {
        // 删除
        goodsService.lockOrUpGoods(id);
        return "redirect:/admin/goods/goods";
    }


    /**
     * 订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ModelAndView details(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Goods goods = goodsService.findById(id);
        modelAndView.setViewName("/admin/goods/details");
        modelAndView.addObject("goods", goods);
        modelAndView.addObject("op", "商品详情");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Goods goods = goodsService.findById(id);
        List<Category> categories = categoryService.findLikeName(null);
        modelAndView.setViewName("/admin/goods/addOrEdit");
        modelAndView.addObject("goods", goods);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("op", "商品修改");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        List<Category> categories = categoryService.findLikeName(null);
        modelAndView.setViewName("/admin/goods/addOrEdit");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("op", "商品添加");
        return modelAndView;
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(Goods goods, @RequestParam(value = "categoryId") Long categoryId, HttpServletRequest request) {
        Category category = categoryService.findById(categoryId);
        goods.setCategory(category);
        goods.setCreateTime(new Date());

        User loginUser = (User)request.getSession().getAttribute("loginUser");
        goods.setUser(loginUser);
        goodsService.saveOrUpdate(goods);

        return "redirect:/admin/goods/goods";
    }



    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return goodsService.deleteBatch(ids);
    }

}
