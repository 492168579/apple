package com.yzy.apple.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.service.LoginService;
import com.yzy.apple.auth.vo.SysUserVO;
import com.yzy.apple.common.utils.R;

@RestController
@RequestMapping("/authentication")
public class LoginController {

	@Autowired
	private LoginService loginService;

	// 登录
	@PostMapping(value = "/login")
	public R login(@RequestBody SysUserVO sysUserVO) {
		try {
			String token = loginService.login(sysUserVO);
			return R.ok().put("token", token);
		}catch (Exception e) {
			e.printStackTrace();
			return R.error(e.getMessage());
		}
		
	}

	// 注册
	@PostMapping(value = "/register")
	public R register(@RequestBody SysUserEntity sysUserEntity) {
		loginService.register(sysUserEntity);
		return R.ok();
	}

}
