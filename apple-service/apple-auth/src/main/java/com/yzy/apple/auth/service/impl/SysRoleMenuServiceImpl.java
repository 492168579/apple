package com.yzy.apple.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.dao.SysRoleMenuDao;
import com.yzy.apple.auth.entity.SysRoleMenuEntity;
import com.yzy.apple.auth.service.SysRoleMenuService;
import com.yzy.apple.auth.vo.SysRoleMenuVO;
import com.yzy.apple.common.utils.ParameterVo;


@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	
	@Autowired
    private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public PageInfo<SysRoleMenuVO> queryPage(ParameterVo<SysRoleMenuVO> params) {
		PageHelper.startPage(params.getPageIndex(), params.getPageSize());
		List<SysRoleMenuVO> list = sysRoleMenuDao.selectAll(params.getObject());
		PageInfo<SysRoleMenuVO> pageInfo = new PageInfo<SysRoleMenuVO>(list);
		return pageInfo;
	}

	@Override
	public void insert(SysRoleMenuEntity SysRoleMenuEntity) {
		sysRoleMenuDao.insertSelective(SysRoleMenuEntity);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		sysRoleMenuDao.bathDelete(ids);
	}

	@Override
	public void updateById(SysRoleMenuEntity SysRoleMenuEntity) {
		sysRoleMenuDao.updateByPrimaryKey(SysRoleMenuEntity);

	}

	@Override
	public SysRoleMenuVO selectById(Long id) {
		return sysRoleMenuDao.selectByPrimaryKey(id);
	}

	@Override
	public List<SysRoleMenuVO> list(SysRoleMenuVO sysRoleMenuVO) {
		return sysRoleMenuDao.selectAll(sysRoleMenuVO);
	}

}
