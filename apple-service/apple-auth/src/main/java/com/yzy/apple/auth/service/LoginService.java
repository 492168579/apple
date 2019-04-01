package com.yzy.apple.auth.service;

import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.vo.SysUserVO;

public interface LoginService {

	void register(SysUserEntity sysUserEntity);

	String login(SysUserVO sysUserVO);

}
