package com.yzy.apple.auth.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.vo.SysUserVO;
import com.yzy.apple.common.utils.ParameterVo;

/**
 * 系统用户
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:14
 */
public interface SysUserService {

    
	PageInfo<SysUserVO> queryPage(ParameterVo<SysUserVO> params);

	void insert(SysUserEntity sysUserEntity);

	void deleteBatch(Long[] userIds);

	SysUserVO selectById(Long userId);

	List<SysUserVO> list(SysUserVO sysUserVO);
    
    void updateById(SysUserEntity sysUserEntity);
}

