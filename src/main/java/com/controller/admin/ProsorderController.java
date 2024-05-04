package com.controller.admin;


import com.entity.Category;
import com.entity.Prosorder;
import com.service.ProsorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/prosorder")
public class ProsorderController {


    @Autowired
    private ProsorderService prosorderService;

    @RequestMapping(value = "/prosorder", method = RequestMethod.GET)
    public ModelAndView prosorder(@RequestParam(value = "orderno", defaultValue = "") String orderno, ModelAndView modelAndView) {
        List<Prosorder> prosorderList = prosorderService.findLikeByOrderno(orderno);
        modelAndView.setViewName("/admin/prosorder/prosorder");
        modelAndView.addObject("list", prosorderList);
        return modelAndView;
    }

    /**
     * 订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/prosorder/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }

}
