package com.nageoffer.shortlink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 有效期类型
 */
@Getter
@RequiredArgsConstructor
public enum VailDateTypeEnum {

    /**
     * 永久有效
     */
    PERMANENT(0),


    /**
     * 自定义有效期
     */
    CUSTOM(1);

    private final int type;
}
