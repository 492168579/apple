package com.yzy.apple.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.dao.SysMenuDao;
import com.yzy.apple.auth.entity.SysMenuEntity;
import com.yzy.apple.auth.service.SysMenuService;
import com.yzy.apple.auth.vo.SysMenuVO;
import com.yzy.apple.common.utils.ParameterVo;


@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	
	@Autowired
    private SysMenuDao sysMenuDao;

	@Override
	public PageInfo<SysMenuVO> queryPage(ParameterVo<SysMenuVO> params) {
		PageHelper.startPage(params.getPageIndex(), params.getPageSize());
		List<SysMenuVO> list = sysMenuDao.selectAll(params.getObject());
		PageInfo<SysMenuVO> pageInfo = new PageInfo<SysMenuVO>(list);
		return pageInfo;
	}

	@Override
	public void insert(SysMenuEntity SysMenuEntity) {
		sysMenuDao.insertSelective(SysMenuEntity);
	}

	@Override
	public void deleteBatch(Long[] menuIds) {
		sysMenuDao.bathDelete(menuIds);
	}

	@Override
	public void updateById(SysMenuEntity SysMenuEntity) {
		sysMenuDao.updateByPrimaryKey(SysMenuEntity);

	}

	@Override
	public SysMenuVO selectById(Long menuId) {
		return sysMenuDao.selectByPrimaryKey(menuId);
	}

	@Override
	public List<SysMenuVO> list(SysMenuVO sysMenuVO) {
		return sysMenuDao.selectAll(sysMenuVO);
	}

}
