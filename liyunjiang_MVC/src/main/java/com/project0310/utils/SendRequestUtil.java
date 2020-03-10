package com.project0310.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SendRequestUtil {

    public static String sendGeneralParamRequest(String uri,String requestMethod) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpRequestBase httpRequestBase=null;
        if ("get".equalsIgnoreCase(requestMethod)){
            httpRequestBase=new HttpGet(uri);
        }else{
           httpRequestBase= new HttpPost(uri);
        }
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpRequestBase);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            String json = "";
            if (responseEntity != null) {
                json = EntityUtils.toString(responseEntity);
                return json;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    ((CloseableHttpClient) httpClient).close();
                }
                if (response != null) {
                    ((CloseableHttpResponse) response).close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    public static String sendObjectParamRequest(String uri,Object obj){
        HttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost= new HttpPost(uri);
        String jsonString = JSON.toJSONString(obj);
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
        return null;
    }
}
