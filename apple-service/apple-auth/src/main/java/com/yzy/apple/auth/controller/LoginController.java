package com.yzy.apple.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzy.apple.auth.controller.vo.SysLoginForm;
import com.yzy.apple.common.utils.R;

@RestController
@RequestMapping("auth/login")
public class LoginController {
	@PostMapping("/login")
	public R login(@RequestBody SysLoginForm form) {
		return R.ok();
	}

}
