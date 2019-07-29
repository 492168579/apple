package com.yzy.apple.auth.service;

import java.util.Map;

import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.vo.SysUserVO;

public interface LoginService {

	void register(SysUserEntity sysUserEntity);

	 Map<String, Object> login(SysUserVO sysUserVO);

}
