package com.project.controller;

import com.alibaba.fastjson.JSON;
import com.project.VO.UserVO;
import com.project.utils.SendRequestUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserAction {

    @RequestMapping("findUser/{userName}")
    @ResponseBody
    public String findUser(@PathVariable("userName") String userName){
        HttpClient httpClient= HttpClients.createDefault();
        // 参数
        StringBuffer params = new StringBuffer();
        params.append("userName=" +userName);

        HttpPost httpPost=new HttpPost("http://localhost:8080/liyunjiang/user/findByUserName"+ "?" + params);
        HttpResponse response=null;
        try {
            response=httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            String json="";
            if (responseEntity != null) {
                json=EntityUtils.toString(responseEntity);
                return json;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    ((CloseableHttpClient) httpClient).close();
                }
                if (response != null) {
                    ((CloseableHttpResponse)response).close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "no";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(UserVO user){
        System.out.println(user);
        HttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost("http://localhost:8080/liyunjiang/user/addUser");
        String jsonString = JSON.toJSONString(user);
        StringEntity entity = new StringEntity(jsonString, "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        // 响应模型
        HttpResponse response = null;
        try {
            response=httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            String json="";
            if (responseEntity != null) {
                json=EntityUtils.toString(responseEntity);
                return json;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    ((CloseableHttpClient) httpClient).close();
                }
                if (response != null) {
                    ((CloseableHttpResponse)response).close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "no";
    }
}
