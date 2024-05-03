package com.controller.admin;

import com.entity.Category;
import com.response.ResponseResult;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类别管理
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView goods(@RequestParam(value = "name", defaultValue = "") String name, ModelAndView modelAndView) {
        List<Category> categoryList = categoryService.findLikeName(name);
        modelAndView.setViewName("/admin/category/category");
        modelAndView.addObject("list", categoryList);
        return modelAndView;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        categoryService.deleteById(id);
        return "redirect:/admin/category/category";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return categoryService.deleteBatch(ids);
    }

    /**
     * 添加或修改
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Category category = categoryService.findById(id);
        modelAndView.setViewName("/admin/category/addOrEdit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("op", "类别管理/编辑");
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/category/addOrEdit");
        modelAndView.addObject("op", "类别管理/新增");
        return modelAndView;
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(Category category) {
        categoryService.saveOrUpdate(category);
        return "redirect:/admin/category/category";
    }



}
