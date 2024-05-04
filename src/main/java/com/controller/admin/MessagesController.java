package com.controller.admin;

import com.entity.Messages;
import com.response.ResponseResult;
import com.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/messages")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ModelAndView messages(@RequestParam(value = "cont", defaultValue = "") String cont, ModelAndView modelAndView) {
        List<Messages> messagesList = messagesService.findByContLike(cont);
        modelAndView.setViewName("/admin/messages/messages");
        modelAndView.addObject("list", messagesList);
        return modelAndView;
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        messagesService.deleteById(id);
        return "redirect:/admin/messages/messages";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return messagesService.deleteBatch(ids);
    }

    /**
     * 回复
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public ResponseResult reply(Messages messages) {
        return messagesService.reply(messages);
    }

}
