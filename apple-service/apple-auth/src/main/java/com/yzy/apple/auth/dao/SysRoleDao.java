package com.yzy.apple.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yzy.apple.auth.entity.SysRoleEntity;
import com.yzy.apple.auth.vo.SysRoleVO;

/**
 * 角色
 * 
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
@Mapper
public interface SysRoleDao {
     

	int deleteByPrimaryKey(Long roleId);

	int insert(SysRoleEntity sysRoleEntity);

	int insertSelective(SysRoleEntity sysRoleEntity);
	
	int updateByPrimaryKey(SysRoleEntity sysRoleEntity);

	SysRoleVO selectByPrimaryKey(Long roleId);

	List<SysRoleVO> selectAll(SysRoleVO sysRoleVO);

	boolean bathDelete(Long[] roleIds);

}
