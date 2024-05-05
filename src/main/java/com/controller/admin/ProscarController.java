package com.controller.admin;

import com.entity.Proscar;
import com.entity.ReceiveInfo;
import com.entity.User;
import com.response.ResponseResult;
import com.service.ProscarService;
import com.service.ReceiveInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 购物车
 */
@Controller
@RequestMapping("/admin/proscar")
public class ProscarController {


    @Autowired
    private ProscarService proscarService;

    @Autowired
    private ReceiveInfoService receiveInfoService;


    @RequestMapping(value = "/proscar", method = RequestMethod.GET)
    public ModelAndView proscar(HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<Proscar> proscars = proscarService.findMyProscar(loginUser);
        List<ReceiveInfo> receiveInfos = receiveInfoService.findMyByNameLike(loginUser.getId(), null);
        modelAndView.setViewName("/admin/proscar/proscar");
        modelAndView.addObject("list", proscars);
        modelAndView.addObject("receiveInfos", receiveInfos);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        proscarService.deleteById(id);
        return "redirect:/admin/proscar/proscar";
    }


    @ResponseBody
    @RequestMapping(value = "/numeric", method = RequestMethod.POST)
    public ResponseResult numeric(Proscar proscar) {
        return proscarService.numeric(proscar);
    }


    /**
     * 购买
     * @param id 购物车商品
     * @param addressId 地址
     * @param paytype 支付方式
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/diamond", method = RequestMethod.POST)
    public ResponseResult diamond(@RequestParam(name = "id") Long id, @RequestParam("addressId") Long addressId, @RequestParam("paytype") String paytype) {
        return proscarService.diamond(id,addressId,paytype);
    }




}
