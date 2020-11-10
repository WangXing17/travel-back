package com.xw.travelback.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author xingwang
 * @date 2020/11/10 21:04
 * @description
 */
@Slf4j
public class HttpUtil {

    private static OkHttpClient client = new OkHttpClient();

    /**
     * 同步get方式请求
     * @param url
     */
    public static String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        String response = "";
        try {
            Response exe = client.newCall(request).execute();
            if (exe != null && !StringUtils.isEmpty(exe.body())) {
                response = exe.body().toString();
            }
        } catch (Exception e) {
            log.warn("OkHttp get method exception: ", e);
            return "";
        }
        return response;
    }

    /**
     * 同步post方式请求-form表单提交参数
     * @param url
     * @param paramsMap
     */
    public static String doPost(String url, Map<String, String> paramsMap) throws Exception {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            builder.add(key, paramsMap.get(key));
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        String response = "";
        try {
            Response exe = client.newCall(request).execute();
            if (exe != null && !StringUtils.isEmpty(exe.body())) {
                response = exe.body().toString();
            }
        } catch (Exception e) {
            log.warn("OkHttp get method exception: ", e);
            return "";
        }
        return response;
    }

}
