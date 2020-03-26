package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/repertory")
public class RepertoryController {

    @RequestMapping("/add")
    @ResponseBody
    public String addRepertory(){
        return "进入添加库存操作";
    }
    @RequestMapping("/out")
    @ResponseBody
    public String outRepertory(){
        return "进入出库库存操作";
    }
    @RequestMapping("/find")
    @ResponseBody
    public String findRepertory(){
        return "进入查看库存操作";
    }
}
