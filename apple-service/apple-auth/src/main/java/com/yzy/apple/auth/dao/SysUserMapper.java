package com.yzy.apple.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yzy.apple.auth.entity.SysUser;
import com.yzy.apple.auth.vo.SysUserVO;

@Mapper
public interface SysUserMapper {

	int selectCount(SysUser sysUser);

	int deleteByPrimaryKey(Long userId);

	int insert(SysUser sysUser);

	SysUser selectObj(SysUser sysUser);

	SysUserVO selectByPrimaryKey(Long userId);

	List<SysUserVO> selectAll(SysUserVO sysUser);

	int updateByPrimaryKey(SysUser sysUser);

	public boolean bathDelete(Long[] userIds);
}