package com.ali.edu.stackoverflow;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/9/7 8:59
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages={
        "com.alibaba.ais.feds.mapper",
        "com.alibaba.ais.feds.service"})
public class StackOverFlowMain {

    /*
     * 入门练习，请求网页接口
     * */
    @Test
    public void test() throws IOException {
        //创建一个httpclient请求客户端
      HttpClient httpClient = HttpClients.createDefault();
        //请求url
        HttpGet httpGet = new HttpGet("https://www.v2ex.com/t/461541");
        //请求
        HttpResponse response = httpClient.execute(httpGet);
        //如果请求成功
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, "utf-8");
            System.out.println(s);
        }
    }

    /*
     * get的请求方式
     * */
    @Test
    public void requestGet()  {
        //创建一个httpclient请求客户端
        HttpClient httpClient = HttpClients.createDefault();
        //请求url
        HttpGet httpGet = new HttpGet("https://www.v2ex.com/t/461541");
        //请求
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            //如果请求成功
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                String s = EntityUtils.toString(entity, "utf-8");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * get带参数的请求方式
     * */
    @Test
    public void requestGetWithParam() throws URISyntaxException {
        //创建一个httpclient请求客户端
        HttpClient httpClient = HttpClients.createDefault();

        //设置url
        URIBuilder uriBuilder = new URIBuilder("https://www.v2ex.com/t/461541");
        //此处链式调用？
        uriBuilder.setParameter("name","jiazhiyuan");
        //创建get请求
        HttpGet httpGet = new HttpGet(uriBuilder.toString());

        //请求
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            //如果请求成功
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                String s = EntityUtils.toString(entity, "utf-8");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * post请求方式
     * */
    @Test
    public void requestPost() throws URISyntaxException {
        //创建一个httpclient请求客户端
        HttpClient httpClient = HttpClients.createDefault();

        //设置url
        URIBuilder uriBuilder = new URIBuilder("https://www.v2ex.com/t/461541");

        //创建post请求
        HttpPost httpPost = new HttpPost(uriBuilder.build());

        //请求
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            //如果请求成功
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                String s = EntityUtils.toString(entity, "utf-8");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * post带参数请求方式
     * */
    @Test
    public void requestPostWithParam() throws URISyntaxException, UnsupportedEncodingException {
        //创建一个httpclient请求客户端
        HttpClient httpClient = HttpClients.createDefault();

        //封装paramList
        List<NameValuePair> paramList = new ArrayList<>();

        //把参数放进去
        paramList.add(new BasicNameValuePair("keys","what?"));

        //创建表单的Entity对象
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramList,"utf8");

        //创建post请求
        HttpPost httpPost = new HttpPost("https://www.v2ex.com/t/461541");

        httpPost.setEntity(formEntity);

        //请求
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            //如果请求成功
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                String s = EntityUtils.toString(entity, "utf-8");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * post带参数请求方式,带连接池
     * */
    @Test
    public void testPoolingManager(){

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置一共有多少个连接
        cm.setMaxTotal(100);
        //每个路由链接数
        cm.setDefaultMaxPerRoute(10);

        doGet(cm);
    }

    private void doGet(PoolingHttpClientConnectionManager cm) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpPost httpPost = new HttpPost("https://www.v2ex.com/t/461541");
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new BasicNameValuePair("key","value"));
        CloseableHttpResponse response = null;
        try {
            UrlEncodedFormEntity encodedFormEntity= new UrlEncodedFormEntity(nameValuePairList,"utf8");
            httpPost.setEntity(encodedFormEntity);
            response = httpClient.execute(httpPost);
            //此处response为null该怎么处理啊呢
            if(response.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = response.getEntity();
                String message = EntityUtils.toString(entity, "utf8");
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(response != null){
                try {
                    response.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            //此时不需要关闭httpClient
        }

    }

    /*
     * post带参数请求方式,带连接池
     * */
    @Test
    public void testRequestConfig(){

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置一共有多少个连接
        cm.setMaxTotal(100);
        //每个路由链接数
        cm.setDefaultMaxPerRoute(10);

        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
                                                            //设置获取连接的时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(1000)
                //设置连接时间
                .setConnectTimeout(1000)
                //设置传输文件时间
                .setSocketTimeout(10 * 1000).build();

        HttpPost httpPost = new HttpPost("https://www.v2ex.com/t/461541");
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200){
                String message = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }
}
