package com.yzy.apple.auth.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysRoleMenuEntity;
import com.yzy.apple.auth.vo.SysRoleMenuVO;
import com.yzy.apple.common.utils.ParameterVo;

/**
 * 角色与菜单对应关系
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
public interface SysRoleMenuService {

    
	PageInfo<SysRoleMenuVO> queryPage(ParameterVo<SysRoleMenuVO> params);

	void insert(SysRoleMenuEntity sysRoleMenuEntity);

	void deleteBatch(Long[] ids);

	SysRoleMenuVO selectById(Long id);

	List<SysRoleMenuVO> list(SysRoleMenuVO sysRoleMenuVO);
    
    void updateById(SysRoleMenuEntity sysRoleMenuEntity);
}

