package com.yzy.apple.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.dao.SysRoleDao;
import com.yzy.apple.auth.entity.SysRoleEntity;
import com.yzy.apple.auth.service.SysRoleService;
import com.yzy.apple.auth.vo.SysRoleVO;
import com.yzy.apple.common.utils.ParameterVo;


@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
    private SysRoleDao sysRoleDao;

	@Override
	public PageInfo<SysRoleVO> queryPage(ParameterVo<SysRoleVO> params) {
		PageHelper.startPage(params.getPageIndex(), params.getPageSize());
		List<SysRoleVO> list = sysRoleDao.selectAll(params.getObject());
		PageInfo<SysRoleVO> pageInfo = new PageInfo<SysRoleVO>(list);
		return pageInfo;
	}

	@Override
	public void insert(SysRoleEntity SysRoleEntity) {
		sysRoleDao.insertSelective(SysRoleEntity);
	}

	@Override
	public void deleteBatch(Long[] roleIds) {
		sysRoleDao.bathDelete(roleIds);
	}

	@Override
	public void updateById(SysRoleEntity SysRoleEntity) {
		sysRoleDao.updateByPrimaryKey(SysRoleEntity);

	}

	@Override
	public SysRoleVO selectById(Long roleId) {
		return sysRoleDao.selectByPrimaryKey(roleId);
	}

	@Override
	public List<SysRoleVO> list(SysRoleVO sysRoleVO) {
		return sysRoleDao.selectAll(sysRoleVO);
	}

}
