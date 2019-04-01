package com.yzy.apple.auth.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysRoleEntity;
import com.yzy.apple.auth.vo.SysRoleVO;
import com.yzy.apple.common.utils.ParameterVo;

/**
 * 角色
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
public interface SysRoleService {

    
	PageInfo<SysRoleVO> queryPage(ParameterVo<SysRoleVO> params);

	void insert(SysRoleEntity sysRoleEntity);

	void deleteBatch(Long[] roleIds);

	SysRoleVO selectById(Long roleId);

	List<SysRoleVO> list(SysRoleVO sysRoleVO);
    
    void updateById(SysRoleEntity sysRoleEntity);
}

