package com.project0310.controller;

import com.alibaba.fastjson.JSON;
import com.project0310.entity.UserEntity0310;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    @RequestMapping("register")
    public String register(@RequestBody UserEntity0310 user) {
        //1、创建httpclient 对象
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8090/lixiangyu/register");

        // 这里利用阿里的fastjson，将Object转换为json字符串;
        String jsonString = JSON.toJSONString(user);
        StringEntity entity = new StringEntity(jsonString, "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        try {
            //执行post请求,并获取返回
            HttpResponse httpResponse = httpClient.execute(httpPost);
            //获取返回的实体
            HttpEntity httpEntity = httpResponse.getEntity();
            //获取实体对象中的字符
            String result = EntityUtils.toString(httpEntity, "utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    @RequestMapping("findAllUser")
    public String findAllUser() {
        //1、创建httpclient 对象
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8090/lixiangyu/findAllUser");

        try {
            //执行post请求,并获取返回
            HttpResponse httpResponse = httpClient.execute(httpPost);
            //获取返回的实体
            HttpEntity httpEntity = httpResponse.getEntity();
            //获取实体对象中的字符
            String result = EntityUtils.toString(httpEntity, "utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    @RequestMapping("getUserInfo/{id}")
    public String getUserInfo(@PathVariable("id") int userId) {
        //1、创建httpclient 对象
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8090/lixiangyu/getUserInfo/" + userId);

        try {
            //执行post请求,并获取返回
            HttpResponse httpResponse = httpClient.execute(httpPost);
            //获取返回的实体
            HttpEntity httpEntity = httpResponse.getEntity();
            //获取实体对象中的字符
            String result = EntityUtils.toString(httpEntity, "utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
