package com.controller.admin;


import com.entity.Prosorder;
import com.entity.User;
import com.response.ResponseResult;
import com.service.ProsorderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/prosorder")
public class ProsorderController {


    @Autowired
    private ProsorderService prosorderService;

    @RequestMapping(value = "/prosorder", method = RequestMethod.GET)
    public ModelAndView prosorder(@RequestParam(value = "orderno", defaultValue = "") String orderno, HttpServletRequest request, ModelAndView modelAndView) {
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
    public ModelAndView details(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/prosorder/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }

    /**
     * 历史订单列表
     * @param orderno
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/historyOrder", method = RequestMethod.GET)
    public ModelAndView historyOrder(@RequestParam(value = "orderno", defaultValue = "") String orderno, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<String> fshstatus = new ArrayList<>();
        fshstatus.add("已签收");
        fshstatus.add("已拒绝");
        fshstatus.add("已取消");
        List<Prosorder> prosorderList = prosorderService.findLikeByOrderno(loginUser, fshstatus, orderno);
        modelAndView.setViewName("/admin/history/history");
        modelAndView.addObject("list", prosorderList);
        return modelAndView;
    }

    /**
     * 历史订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/historyDetails/{id}", method = RequestMethod.GET)
    public ModelAndView historyDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/history/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }


    /**
     * 待受理订单
     * @param orderno
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/waitAcceptance", method = RequestMethod.GET)
    public ModelAndView waitAcceptance(@RequestParam(value = "orderno", defaultValue = "") String orderno, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<String> fshstatus = new ArrayList<>();
        fshstatus.add("待受理");
        List<Prosorder> prosorderList = prosorderService.findLikeByOrderno(loginUser, fshstatus,orderno);
        modelAndView.setViewName("/admin/waitAcceptance/waitAcceptance");
        modelAndView.addObject("list", prosorderList);
        return modelAndView;
    }

    /**
     * 待受理订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/waitAcceptanceDetails/{id}", method = RequestMethod.GET)
    public ModelAndView waitAcceptanceDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/waitAcceptance/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/waitAcceptancehandle", method = RequestMethod.POST)
    public ResponseResult waitAcceptancehandle(Prosorder prosorder, HttpServletRequest request) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        prosorder.setFgname(loginUser.getName());
        return prosorderService.waitAcceptancehandle(prosorder);
    }


    /**
     * 待签收订单
     * @param orderno
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/waitSign", method = RequestMethod.GET)
    public ModelAndView waitSign(@RequestParam(value = "orderno", defaultValue = "") String orderno, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<String> fshstatus = new ArrayList<>();
        fshstatus.add("已发货");
        List<Prosorder> prosorderList = prosorderService.findLikeByOrderno(loginUser, fshstatus,orderno);
        modelAndView.setViewName("/admin/waitSign/waitSign");
        modelAndView.addObject("list", prosorderList);
        return modelAndView;
    }

    /**
     * 待签收订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/waitSignDetails/{id}", method = RequestMethod.GET)
    public ModelAndView waitSignDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/waitSign/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }


    /**
     * 买方待签收订单
     * @param orderno
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/sellWaitSign", method = RequestMethod.GET)
    public ModelAndView sellWaitSign(@RequestParam(value = "orderno", defaultValue = "") String orderno, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<String> fshstatus = new ArrayList<>();
        fshstatus.add("已发货");
        List<Prosorder> prosorderList = prosorderService.findLikeByOrderno(loginUser, fshstatus,orderno);
        modelAndView.setViewName("/admin/sellWaitSign/sellWaitSign");
        modelAndView.addObject("list", prosorderList);
        return modelAndView;
    }

    /**
     * 买方待签收订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/sellDetails/{id}", method = RequestMethod.GET)
    public ModelAndView sellDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/sellWaitSign/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }


    /**
     * 买方签收
     * @param prosorder
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sellSign", method = RequestMethod.POST)
    public ResponseResult sellSign(Prosorder prosorder) {
        return prosorderService.sellSign(prosorder);
    }

    /**
     * 卖方待受理订单
     * @param orderno
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/sellAcceptance", method = RequestMethod.GET)
    public ModelAndView sellAcceptance(@RequestParam(value = "orderno", defaultValue = "") String orderno, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<String> fshstatus = new ArrayList<>();
        fshstatus.add("待受理");
        List<Prosorder> prosorderList = prosorderService.findLikeByOrderno(loginUser, fshstatus,orderno);
        modelAndView.setViewName("/admin/sellAcceptance/sellAcceptance");
        modelAndView.addObject("list", prosorderList);
        return modelAndView;
    }

    /**
     * 买方待受理订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/sellAcceptanceDetails/{id}", method = RequestMethod.GET)
    public ModelAndView sellAcceptanceDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/sellAcceptance/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }

    /**
     * 买方取消订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/sellCancel/{id}", method = RequestMethod.GET)
    public String sellCancel(@PathVariable("id") Long id) {
        prosorderService.sellCancel(id);
        return "redirect:/admin/prosorder/sellAcceptance";
    }



    /**
     * 买方历史订单列表
     * @param orderno
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/sellHistory", method = RequestMethod.GET)
    public ModelAndView sellHistory(@RequestParam(value = "orderno", defaultValue = "") String orderno, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<String> fshstatus = new ArrayList<>();
        fshstatus.add("已签收");
        fshstatus.add("已拒绝");
        fshstatus.add("已取消");
        List<Prosorder> prosorderList = prosorderService.findLikeByOrderno(loginUser, fshstatus, orderno);
        modelAndView.setViewName("/admin/sellHistory/sellHistory");
        modelAndView.addObject("list", prosorderList);
        return modelAndView;
    }

    /**
     * 买方历史订单详情
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/sellHistoryDetails/{id}", method = RequestMethod.GET)
    public ModelAndView sellHistoryDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {
        Prosorder prosorder = prosorderService.findById(id);
        modelAndView.setViewName("/admin/sellHistory/details");
        modelAndView.addObject("prosorder", prosorder);
        modelAndView.addObject("op", "订单详情");
        return modelAndView;
    }


}
