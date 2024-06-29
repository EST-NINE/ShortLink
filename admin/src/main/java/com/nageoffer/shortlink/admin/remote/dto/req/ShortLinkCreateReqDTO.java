package com.nageoffer.shortlink.admin.remote.dto.req;

import lombok.Data;

import java.util.Date;

/**
 * 短链接创建请求对象
 */
@Data
public class ShortLinkCreateReqDTO {

    /**
     * 域名
     */
    private String domain;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 网站图标
     */
    private String favicon;

    /**
     * 创建类型 0：控制台 1：接口
     */
    private int createdType;

    /**
     * 有效期类型 0：永久有效 1：用户自定义
     */
    private int validDateType;

    /**
     * 有效期
     */
    private Date validDate;

    /**
     * 描述
     */
    private String describe;
}
