package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data")
public class DataController {

    @RequestMapping("/add")
    @ResponseBody
    public String addRepertory(){
        return "进入添加资料操作";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String outRepertory(){
        return "进入删除资料操作";
    }
    @RequestMapping("/find")
    @ResponseBody
    public String findRepertory(){
        return "进入查看资料操作";
    }
}
