package com.controller.admin;


import com.entity.Category;
import com.entity.ZreSources;
import com.response.ResponseResult;
import com.service.ZreSourceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/zreSources")
public class ZreSourcesController {

    @Autowired
    private ZreSourceServices zreSourcesService;

    /**
     * 站内咨询列表
     * @param title
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/zreSources", method = RequestMethod.GET)
    public ModelAndView zresources(@RequestParam(value = "title", defaultValue = "") String title, ModelAndView modelAndView) {
        List<ZreSources> categoryList = zreSourcesService.findLikeTitle(title);
        modelAndView.setViewName("/admin/zreSources/zreSources");
        modelAndView.addObject("list", categoryList);
        return modelAndView;
    }


    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        zreSourcesService.deleteById(id);
        return "redirect:/admin/zreSources/zreSources";
    }


    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return zreSourcesService.deleteBatch(ids);
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        ZreSources zreSources = zreSourcesService.findById(id);
        modelAndView.setViewName("/admin/zreSources/addOrEdit");
        modelAndView.addObject("zreSources", zreSources);
        modelAndView.addObject("op", "站内咨询管理/编辑");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/zreSources/addOrEdit");
        modelAndView.addObject("op", "站内咨询管理/新增");
        return modelAndView;
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(ZreSources zreSources, @RequestParam("ztypeid") Long ztypeid) {
        zreSourcesService.saveOrUpdate(zreSources, ztypeid);
        return "redirect:/admin/zreSources/zreSources";
    }


}
