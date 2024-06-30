package com.nageoffer.shortlink.project.toolkit;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Optional;

import static com.nageoffer.shortlink.project.common.constant.ShortLinkConstant.DEFAULT_CACHE_VALID_TIME;

/**
 * 短链接工具类
 */
public class LinkUtil {

    /**
     * 获取短链接缓存的有效时间
     *
     * @param validData 有效期
     * @return 有效时间戳
     */
    public static long getShortLinkCacheValidTime(Date validData) {
       return Optional.ofNullable(validData)
               .map(each -> DateUtil.between(new Date(),each, DateUnit.MS))
               .orElse(DEFAULT_CACHE_VALID_TIME);
    }
}
