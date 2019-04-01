package com.yzy.apple.auth.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysUserRoleEntity;
import com.yzy.apple.auth.vo.SysUserRoleVO;
import com.yzy.apple.common.utils.ParameterVo;

/**
 * 用户与角色对应关系
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:14
 */
public interface SysUserRoleService {

    
	PageInfo<SysUserRoleVO> queryPage(ParameterVo<SysUserRoleVO> params);

	void insert(SysUserRoleEntity sysUserRoleEntity);

	void deleteBatch(Long[] ids);

	SysUserRoleVO selectById(Long id);

	List<SysUserRoleVO> list(SysUserRoleVO sysUserRoleVO);
    
    void updateById(SysUserRoleEntity sysUserRoleEntity);
}

