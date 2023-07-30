package com.knowns.rss.generator.utils.result;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 返回给客户端执行结果的消息类，带单个数据
 *
 * @author liying22923
 * @since 2020/6/24
 */
public class PlainResult extends BaseResult {

    private static final long serialVersionUID = -6673395649748859992L;

    private JSONObject data;

    public PlainResult(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        if (map != null) {
            for (String key : map.keySet()) {
                jsonObject.put(key, map.get(key));
            }
        }
        data = jsonObject;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
