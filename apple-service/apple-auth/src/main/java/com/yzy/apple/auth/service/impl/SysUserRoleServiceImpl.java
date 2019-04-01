package com.yzy.apple.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.dao.SysUserRoleDao;
import com.yzy.apple.auth.entity.SysUserRoleEntity;
import com.yzy.apple.auth.service.SysUserRoleService;
import com.yzy.apple.auth.vo.SysUserRoleVO;
import com.yzy.apple.common.utils.ParameterVo;


@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
	
	@Autowired
    private SysUserRoleDao sysUserRoleDao;

	@Override
	public PageInfo<SysUserRoleVO> queryPage(ParameterVo<SysUserRoleVO> params) {
		PageHelper.startPage(params.getPageIndex(), params.getPageSize());
		List<SysUserRoleVO> list = sysUserRoleDao.selectAll(params.getObject());
		PageInfo<SysUserRoleVO> pageInfo = new PageInfo<SysUserRoleVO>(list);
		return pageInfo;
	}

	@Override
	public void insert(SysUserRoleEntity SysUserRoleEntity) {
		sysUserRoleDao.insertSelective(SysUserRoleEntity);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		sysUserRoleDao.bathDelete(ids);
	}

	@Override
	public void updateById(SysUserRoleEntity SysUserRoleEntity) {
		sysUserRoleDao.updateByPrimaryKey(SysUserRoleEntity);

	}

	@Override
	public SysUserRoleVO selectById(Long id) {
		return sysUserRoleDao.selectByPrimaryKey(id);
	}

	@Override
	public List<SysUserRoleVO> list(SysUserRoleVO sysUserRoleVO) {
		return sysUserRoleDao.selectAll(sysUserRoleVO);
	}

}
