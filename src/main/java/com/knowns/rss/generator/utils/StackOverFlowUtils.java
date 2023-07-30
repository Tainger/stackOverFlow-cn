package com.knowns.rss.generator.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.UUID;

/**
 * @author rocky
 */
public class StackOverFlowUtils {

    /**
     * 生成随机的字符串
     * @return
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 返回Md5加密字符串
     * @param key
     * @return
     */
    public static  String md5(String key){
        if(StringUtils.isEmpty(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    /**
     * 获得json数据
     * @param code
     * @param msg
     * @param map
     * @return
     */
    public static  String  getJsonString(int code, String msg, Map<String,Object> map){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        if(map!=null) {
            for (String key : map.keySet()) {
                jsonObject.put(key, map.get(key));
            }
        }
        return jsonObject.toString();
    }

    /**
     * 获得数据
     * @param code
     * @return
     */
    public static  String  getJsonString(int code){
        return getJsonString(code,null,null);
    }

    /**
     * 获得json数据
     * @param code
     * @param message
     * @return
     */
    public static  String  getJsonString(int code,String message){

        return getJsonString(code,message,null);
    }
}
