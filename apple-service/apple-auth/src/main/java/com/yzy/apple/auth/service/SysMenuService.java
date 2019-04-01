package com.yzy.apple.auth.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysMenuEntity;
import com.yzy.apple.auth.vo.SysMenuVO;
import com.yzy.apple.common.utils.ParameterVo;

/**
 * 菜单管理
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
public interface SysMenuService {

    
	PageInfo<SysMenuVO> queryPage(ParameterVo<SysMenuVO> params);

	void insert(SysMenuEntity sysMenuEntity);

	void deleteBatch(Long[] menuIds);

	SysMenuVO selectById(Long menuId);

	List<SysMenuVO> list(SysMenuVO sysMenuVO);
    
    void updateById(SysMenuEntity sysMenuEntity);
}

