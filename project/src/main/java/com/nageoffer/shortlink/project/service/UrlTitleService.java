package com.nageoffer.shortlink.project.service;

/**
 * URL 标题接口层
 */
public interface UrlTitleService {

    /**
     * 根据URL获取标题
     *
     * @param url URL
     * @return 标题
     */
    String getTitleByUrl(String url);
}
