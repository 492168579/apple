package com.yzy.apple.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.dao.SysUserDao;
import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.service.SysUserService;
import com.yzy.apple.auth.vo.SysUserVO;
import com.yzy.apple.common.utils.ParameterVo;


@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
    private SysUserDao sysUserDao;

	@Override
	public PageInfo<SysUserVO> queryPage(ParameterVo<SysUserVO> params) {
		PageHelper.startPage(params.getPageIndex(), params.getPageSize());
		List<SysUserVO> list = sysUserDao.selectAll(params.getObject());
		PageInfo<SysUserVO> pageInfo = new PageInfo<SysUserVO>(list);
		return pageInfo;
	}

	@Override
	public void insert(SysUserEntity SysUserEntity) {
		sysUserDao.insertSelective(SysUserEntity);
	}

	@Override
	public void deleteBatch(Long[] userIds) {
		sysUserDao.bathDelete(userIds);
	}

	@Override
	public void updateById(SysUserEntity SysUserEntity) {
		sysUserDao.updateByPrimaryKey(SysUserEntity);

	}

	@Override
	public SysUserVO selectById(Long userId) {
		return sysUserDao.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUserVO> list(SysUserVO sysUserVO) {
		return sysUserDao.selectAll(sysUserVO);
	}

}
