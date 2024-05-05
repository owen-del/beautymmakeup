package com.controller.assets;

import com.entity.*;
import com.response.ResponseResult;
import com.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 页面Controller
 */
@Controller
@RequestMapping("/assets")
public class AssetsController {

    // 滚动图
    @Autowired
    private MixInfoService mixInfoService;

    // 商品
    @Autowired
    private GoodsService goodsService;

    // 购物车
    @Autowired
    private ReceiveInfoService receiveInfoService;

    // 站内咨询
    @Autowired
    private ZreSourceServices zreSourceServices;


    // 留言板服务类
    @Autowired
    private MessagesService messagesService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        // 获取滚动图
        List<MixInfo> mixInfoList = mixInfoService.findRollingImgLikeTitle(null);
        // 取前8个商品
        List<Goods> goods = goodsService.findAll().stream().limit(8).toList();
        modelAndView.addObject("mixInfoList", mixInfoList);
        modelAndView.addObject("goods", goods);
        modelAndView.setViewName("assets/index");
        return modelAndView;
    }


    @RequestMapping(value = "/shopping", method = RequestMethod.GET)
    public ModelAndView shopping(ModelAndView modelAndView) {
        // 全部商品
        List<Goods> goods = goodsService.findAll();
        modelAndView.addObject("goods", goods);
        modelAndView.setViewName("assets/shopping");
        return modelAndView;
    }


    /**
     * 订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/goodsDetails/{id}", method = RequestMethod.GET)
    public ModelAndView goodsDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Goods goods = goodsService.findById(id);
        modelAndView.setViewName("/assets/product-details");
        modelAndView.addObject("goods", goods);
        return modelAndView;
    }

    /**
     * 加入购物车
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addCat/{id}", method = RequestMethod.POST)
    public ResponseResult addCat(@PathVariable("id") Long id, HttpServletRequest request) {
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        receiveInfoService.addCat(id,loginUser);
        return ResponseResult.SUCCESS("添加成功");
    }


    @RequestMapping(value = "/zreSources", method = RequestMethod.GET)
    public ModelAndView zreSources(ModelAndView modelAndView) {
        // 全部商品
        List<ZreSources> zreSources = zreSourceServices.findAll();
        modelAndView.addObject("zreSources", zreSources);
        modelAndView.setViewName("assets/zreSources");
        return modelAndView;
    }

    @RequestMapping(value = "/zreSourcesDetails/{id}", method = RequestMethod.GET)
    public ModelAndView zreSourcesDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        ZreSources zreSources = zreSourceServices.findById(id);
        modelAndView.setViewName("/assets/zreSourcesDetails");
        modelAndView.addObject("zreSources", zreSources);
        return modelAndView;
    }


    /**
     * 网站简介
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/brief", method = RequestMethod.GET)
    public ModelAndView zreSourcesDetails(ModelAndView modelAndView) {
        MixInfo mixInfo = mixInfoService.findById(3L);
        modelAndView.setViewName("/assets/brief");
        modelAndView.addObject("mixInfo", mixInfo);
        return modelAndView;
    }

    /**
     * 联系我们
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contact(ModelAndView modelAndView) {
        MixInfo mixInfo = mixInfoService.findById(4L);
        modelAndView.setViewName("/assets/brief");
        modelAndView.addObject("mixInfo", mixInfo);
        return modelAndView;
    }


    /**
     * 留言板
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ModelAndView message(ModelAndView modelAndView) {
        List<Messages> messages = messagesService.findAll();
        modelAndView.setViewName("/assets/message");
        modelAndView.addObject("messages", messages);
        return modelAndView;
    }

    @RequestMapping(value = "/saveMessave", method = RequestMethod.POST)
    public String saveMessave(Messages messages, HttpServletRequest request) {
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        messages.setCreateTime(new Date());
        messages.setUser(loginUser);
        messages.setRecont("");
        messagesService.save(messages);
        return "redirect:/assets/message";
    }


}
