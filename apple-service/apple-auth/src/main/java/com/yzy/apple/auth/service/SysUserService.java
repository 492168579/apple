package com.yzy.apple.auth.service;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysUser;
import com.yzy.apple.auth.vo.SysUserVO;
import com.yzy.apple.common.utils.ParameterVo;

public interface SysUserService {

	PageInfo<SysUserVO> queryPage(ParameterVo<SysUserVO> params);

	void insert(SysUser sysUser);

	void deleteBatch(Long[] userIds);

	void update(SysUser sysUser);

	SysUser selectById(Long userId);

}
