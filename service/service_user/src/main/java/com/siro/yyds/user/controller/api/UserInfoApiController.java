package com.siro.yyds.user.controller.api;

import com.siro.yyds.common.result.Result;
import com.siro.yyds.common.util.AuthContextHolder;
import com.siro.yyds.common.util.IpUtil;
import com.siro.yyds.model.user.UserInfo;
import com.siro.yyds.user.service.UserInfoService;
import com.siro.yyds.vo.user.LoginVo;
import com.siro.yyds.vo.user.UserAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-03
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/user")
public class UserInfoApiController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户手机号验证码登录
     * @param loginVo
     * @param request
     * @return
     */
    @ApiOperation(value = "用户手机号验证码登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
        loginVo.setIp(IpUtil.getIpAddr(request));
        Map<String, Object> info = userInfoService.loginUser(loginVo);
        return Result.ok(info);
    }

    /**
     * 用户认证接口
     * @param userAuthVo
     * @param request
     * @return
     */
    @ApiOperation(value = "用户认证接口")
    @PostMapping("/auth/userAuth")
    public Result userAuth(@RequestBody UserAuthVo userAuthVo, HttpServletRequest request) {
        //传递两个参数，第一个参数用户id，第二个参数认证数据vo对象
        userInfoService.userAuth(AuthContextHolder.getUserId(request), userAuthVo);
        return Result.ok();
    }

    /**
     * 获取用户id信息接口
     * @param request
     * @return
     */
    @ApiOperation(value = "获取用户id信息接口")
    @GetMapping("/auth/getUserInfo")
    public Result getUserInfo(HttpServletRequest request) {
        Long userId = AuthContextHolder.getUserId(request);
        UserInfo userInfo = userInfoService.getById(userId);
        return Result.ok(userInfo);
    }
}
