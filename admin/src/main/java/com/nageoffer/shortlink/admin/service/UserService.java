package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dto.req.UserLoginReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;

/**
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户返回实体
     */
    UserRespDTO getUserByUsername(String username);


    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 用户名存在返回 true:存在，false:不存在
     */
    Boolean hasUsername(String username);


    /**
     * 注册用户
     *
     * @param requestParam 注册用户请求参数
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 更新用户信息
     *
     * @param requestParam 更新用户信息请求参数
     */
    void update(UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     * @param requestParam 用户登录请求参数
     * @return 用户登录返回参数 Token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 校验用户是否登录
     * @param token 用户登录返回参数 Token
     * @return 用户是否登录
     */
    Boolean checkLogin(String username,String token);


    /**
     * 用户退出登录
     * @param username 用户名
     * @param token 用户登录返回参数 Token
     */
    void logout(String username, String token);
}
