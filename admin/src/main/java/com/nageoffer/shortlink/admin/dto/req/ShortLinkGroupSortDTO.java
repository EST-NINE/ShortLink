package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 短链接分组排序
 */
@Data
public class ShortLinkGroupSortDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序
     */
    private Integer sortOrder;
}
