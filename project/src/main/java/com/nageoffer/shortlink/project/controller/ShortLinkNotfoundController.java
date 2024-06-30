package com.nageoffer.shortlink.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 短链接不存在跳转控制器
 */
@Controller // 这里不用 RestController，这个时返回 json 的，而我们只用返回前端视图
public class ShortLinkNotfoundController {

    /**
     * 短链接不存在时的跳转页面
     */
    @RequestMapping("/page/notfound")
    public String notfound() {
        return "notfound";
    }
}
