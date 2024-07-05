package com.nageoffer.shortlink.admin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 实现 BaseDO 的自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 严格插入，如果字段为空，则填充默认值
        this.strictInsertFill(metaObject, "createTime", Date::new ,Date.class);
        this.strictInsertFill(metaObject, "updateTime", Date::new ,Date.class);
        this.strictInsertFill(metaObject,"delFlag",() -> 0,Integer.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 严格插入，如果字段为空，则填充默认值
        this.strictInsertFill(metaObject, "updateTime", Date::new ,Date.class);
    }
}
