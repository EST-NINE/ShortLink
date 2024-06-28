package com.nageoffer.shortlink.project.dto.resp;

import lombok.Data;

/**
 * 短链接分组信息响应对象
 */
@Data
public class ShortLinkGroupDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;
}
