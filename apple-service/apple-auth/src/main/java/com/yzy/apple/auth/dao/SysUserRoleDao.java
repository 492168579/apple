package com.yzy.apple.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yzy.apple.auth.entity.SysUserRoleEntity;
import com.yzy.apple.auth.vo.SysUserRoleVO;

/**
 * 用户与角色对应关系
 * 
 * @author 
 * @email 
 * @date 2019-03-30 23:40:14
 */
@Mapper
public interface SysUserRoleDao {
     

	int deleteByPrimaryKey(Long id);

	int insert(SysUserRoleEntity sysUserRoleEntity);

	int insertSelective(SysUserRoleEntity sysUserRoleEntity);
	
	int updateByPrimaryKey(SysUserRoleEntity sysUserRoleEntity);

	SysUserRoleVO selectByPrimaryKey(Long id);

	List<SysUserRoleVO> selectAll(SysUserRoleVO sysUserRoleVO);

	boolean bathDelete(Long[] ids);

}
