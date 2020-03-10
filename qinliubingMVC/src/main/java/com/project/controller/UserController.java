package com.project.controller;


import com.alibaba.fastjson.JSON;
import com.project.entity.UserEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
@RestController
public class UserController {
    @RequestMapping("find/{userName}")
    public String  find(@PathVariable("userName") String userName){
        //调用服务器数据，所以它对于浏览器属于后端，对于后端服务器属于客户端
        //1、创建httpclient 对象
        HttpClient httpClient= HttpClients.createDefault();
        //创建get对象
        HttpGet httpGet =new HttpGet("http:localhost:8080/qinliubing/find/"+userName);
        try {
            //执行get请求,并获取返回
            HttpResponse httpResponse = httpClient.execute(httpGet);
            //获取返回的实体
            HttpEntity httpEntity = httpResponse.getEntity();
            //获取实体对象中的字符，也就是后端返回的json
            String json = EntityUtils.toString(httpEntity, "utf-8");

            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @RequestMapping("add")
    public String add(UserEntity userEntity) {
        //1、创建httpclient 对象
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/qinliubing/add");

        // 这里利用阿里的fastjson，将Object转换为json字符串;
        String jsonString = JSON.toJSONString(userEntity);
        StringEntity entity = new StringEntity(jsonString, "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        try {
            //执行post请求,并获取返回
            HttpResponse httpResponse = httpClient.execute(httpPost);
            //获取返回的实体
            HttpEntity httpEntity = httpResponse.getEntity();
            //获取实体对象中的字符，也就是后端返回的json
            String json = EntityUtils.toString(httpEntity, "utf-8");
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
