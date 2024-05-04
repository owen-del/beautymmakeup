package com.controller.admin;

import com.entity.Category;
import com.entity.ReceiveInfo;
import com.entity.User;
import com.response.ResponseResult;
import com.service.ReceiveInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/receiveInfo")
public class ReceiveInfoController {

    @Autowired
    private ReceiveInfoService receiveInfoService;

    @RequestMapping(value = "/receiveInfo", method = RequestMethod.GET)
    public ModelAndView goods(@RequestParam(value = "name", defaultValue = "") String name, HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        List<ReceiveInfo> receiveInfoList = receiveInfoService.findMyByNameLike(loginUser.getId(), name);
        modelAndView.setViewName("/admin/receiveInfo/receiveInfo");
        modelAndView.addObject("list", receiveInfoList);
        return modelAndView;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        receiveInfoService.deleteById(id);
        return "redirect:/admin/receiveInfo/receiveInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return receiveInfoService.deleteBatch(ids);
    }

    /**
     * 添加或修改
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        ReceiveInfo receiveInfo = receiveInfoService.findById(id);
        modelAndView.setViewName("/admin/receiveInfo/addOrEdit");
        modelAndView.addObject("receiveInfo", receiveInfo);
        modelAndView.addObject("op", "收货地址编辑");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/receiveInfo/addOrEdit");
        modelAndView.addObject("op", "收货地址添加");
        return modelAndView;
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(ReceiveInfo receiveInfo, HttpServletRequest request) {
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        receiveInfo.setUser(loginUser);
        receiveInfoService.saveOrUpdate(receiveInfo);
        return "redirect:/admin/receiveInfo/receiveInfo";
    }

}
