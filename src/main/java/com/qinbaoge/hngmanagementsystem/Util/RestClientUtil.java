package com.qinbaoge.hngmanagementsystem.Util;

import org.springframework.web.client.RestTemplate;

public final class RestClientUtil {

    private static RestTemplate template = new RestTemplate();

    /**

     * 发送POST请求

     * @param url 接口地址

     * @param request 接口请求参数

     * @param responseType 接口响应类型

     * @return 接口响应

     */

    public static <T> T doPost(String url, Object request, Class<T> responseType) {

        return template.postForObject(url, request, responseType);

    }

    /**

     * 发送PUT请求

     * @param url 接口地址

     * @param request 接口请求参数

     */

    public static void doPut(String url, Object request) {

        template.put(url, request);

    }

    /**

     * 发送GET请求

     * @param url 接口地址

     * @param responseType 接口响应类型

     * @return 接口响应

     */

    public static <T> T doGet(String url, Class<T> responseType) {

        return template.getForObject(url, responseType);

    }

    /**

     * 发送DELETE请求

     * @param url 接口地址

     */

    public static void doDelete(String url) {

        template.delete(url);

    }

}