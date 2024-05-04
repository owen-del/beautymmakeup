package com.controller.admin;


import com.entity.ZrType;
import com.entity.ZreSources;
import com.response.ResponseResult;
import com.service.ZrTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 信息类别管理
 */
@Controller
@RequestMapping("/admin/ZrType")
public class ZrTypeController {

    @Autowired
    private ZrTypeService zrTypeService;

    @RequestMapping(value = "/ZrType", method = RequestMethod.GET)
    public ModelAndView ZrType(@RequestParam(value = "name", defaultValue = "") String name, ModelAndView modelAndView) {
        List<ZrType> zrTypeList = zrTypeService.findLikeName(name);
        modelAndView.setViewName("/admin/ZrType/ZrType");
        modelAndView.addObject("list", zrTypeList);
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        ZrType zrType = zrTypeService.findById(id);
        modelAndView.setViewName("/admin/ZrType/addOrEdit");
        modelAndView.addObject("zrType", zrType);
        modelAndView.addObject("op", "信息类别/编辑");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/ZrType/addOrEdit");
        modelAndView.addObject("op", "信息类别管理/新增");
        return modelAndView;
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(ZrType zrType) {
        zrTypeService.saveOrUpdate(zrType);
        return "redirect:/admin/ZrType/ZrType";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        zrTypeService.deleteById(id);
        return "redirect:/admin/ZrType/ZrType";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return zrTypeService.deleteBatch(ids);
    }


}
