package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 标记为控制器，返回Thymeleaf视图（不是接口）
@Controller
public class MessageController {

    // 自动注入Repository（不用自己new）
    @Autowired
    private MessageRepository messageRepository;

    // 1. 展示所有留言（访问首页时触发）
    @GetMapping("/")
    public String showMessages(Model model) {
        // 把所有留言放到Model里，传给前端页面
        model.addAttribute("messages", messageRepository.findAll());
        return "index"; // 返回templates下的index.html页面
    }

    // 2. 添加新留言（表单提交时触发）
    @PostMapping("/add")
    public String addMessage(@RequestParam("content") String content) {
        // 新建Message对象，保存到数据库
        messageRepository.save(new Message(content));
        return "redirect:/"; // 重定向到首页，刷新留言列表
    }

    // 3. 删除留言（点击删除按钮时触发）
    @GetMapping("/delete")
    public String deleteMessage(@RequestParam("id") Long id) {
        messageRepository.deleteById(id);
        return "redirect:/"; // 重定向到首页
    }
}