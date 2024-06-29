package com.nageoffer.shortlink.project.dto.resp;

import lombok.Data;

/**
 * 短链接分组查询返回参数
 */
@Data
public class ShortLinkCountQueryRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 对应分组下的短链接数量
     */
    private Integer shortLinkCount;
}
