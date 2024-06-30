package com.nageoffer.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接跳转实体
 */
@TableName("t_link_goto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkGotoDO {

    /**
     *  ID
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短连接
     */
    private String fullShortUrl;
}
