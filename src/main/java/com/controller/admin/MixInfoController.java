package com.controller.admin;

import com.entity.MixInfo;
import com.service.MixInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 网站综合信息
 */
@Controller
@RequestMapping("/admin/mixInfo")
public class MixInfoController {

    @Autowired
    private MixInfoService mixInfoService;


    /**
     * 滚动图片管理
     * @param title
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/rollingImg", method = RequestMethod.GET)
    public ModelAndView rollingImg(@RequestParam(value = "title", defaultValue = "") String title, ModelAndView modelAndView) {
        List<MixInfo> mixInfoList = mixInfoService.findRollingImgLikeTitle(title);
        modelAndView.setViewName("/admin/rollingImg/rollingImg");
        modelAndView.addObject("list", mixInfoList);
        return modelAndView;
    }


    @RequestMapping(value = "/rollingImg/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        MixInfo mixInfo = mixInfoService.findById(id);
        modelAndView.setViewName("/admin/rollingImg/edit");
        modelAndView.addObject("mixInfo", mixInfo);
        modelAndView.addObject("op", "信息修改");
        return modelAndView;
    }


    @RequestMapping(value = "/rollingImg/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(MixInfo mixInfo) {
        mixInfoService.saveOrUpdate(mixInfo);
        return "redirect:/admin/mixInfo/rollingImg";
    }

    /**
     * 网站基础信息
     * @param title
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/basis", method = RequestMethod.GET)
    public ModelAndView basis(@RequestParam(value = "title", defaultValue = "") String title, ModelAndView modelAndView) {
        List<MixInfo> mixInfoList = mixInfoService.findBasisLikeTitle(title);
        modelAndView.setViewName("/admin/basis/basis");
        modelAndView.addObject("list", mixInfoList);
        return modelAndView;
    }

    @RequestMapping(value = "/basis/edit/{id}", method = RequestMethod.GET)
    public ModelAndView basisEdit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        MixInfo mixInfo = mixInfoService.findById(id);
        modelAndView.setViewName("/admin/basis/edit");
        modelAndView.addObject("mixInfo", mixInfo);
        modelAndView.addObject("op", "信息修改");
        return modelAndView;
    }

    @RequestMapping(value = "/basis/saveOrUpdate", method = RequestMethod.POST)
    public String basisSaveOrUpdate(MixInfo mixInfo) {
        mixInfoService.saveOrUpdate(mixInfo);
        return "redirect:/admin/mixInfo/basis";
    }


}
