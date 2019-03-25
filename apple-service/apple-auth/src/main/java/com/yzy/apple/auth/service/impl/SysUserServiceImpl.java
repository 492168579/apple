package com.yzy.apple.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.dao.SysUserMapper;
import com.yzy.apple.auth.entity.SysUser;
import com.yzy.apple.auth.service.SysUserService;
import com.yzy.apple.auth.vo.SysUserVO;
import com.yzy.apple.common.utils.ParameterVo;

public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public PageInfo<SysUserVO> queryPage(ParameterVo<SysUserVO> params) {
		SysUserVO entityVo = params.getParameter();
		PageHelper.startPage(params.getPageIndex(), params.getPageSize());
		List<SysUserVO> list = sysUserMapper.selectAll(entityVo);
		PageInfo<SysUserVO> pageInfo = new PageInfo<SysUserVO>(list);
		return pageInfo;
	}

	@Override
	public void insert(SysUser sysUser) {
		sysUserMapper.insert(sysUser);
	}

	@Override
	public void deleteBatch(Long[] userIds) {
		sysUserMapper.bathDelete(userIds);
	}

	@Override
	public void update(SysUser sysUser) {
		sysUserMapper.updateByPrimaryKey(sysUser);

	}

	@Override
	public SysUserVO selectById(Long userId) {
		return sysUserMapper.selectByPrimaryKey(userId);
	}

}
