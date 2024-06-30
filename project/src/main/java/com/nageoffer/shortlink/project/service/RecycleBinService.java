package com.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import com.nageoffer.shortlink.project.dto.req.RecycleBinSavaReqDTO;

/**
 * 回收站管理接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {


    /**
     * 保存回收站数据
     *
     * @param requestParam 保存回收站参数
     */
    void savRecycleBin(RecycleBinSavaReqDTO requestParam);
}
