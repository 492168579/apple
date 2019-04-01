package com.yzy.apple.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yzy.apple.auth.entity.SysRoleMenuEntity;
import com.yzy.apple.auth.vo.SysRoleMenuVO;

/**
 * 角色与菜单对应关系
 * 
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
@Mapper
public interface SysRoleMenuDao {
     

	int deleteByPrimaryKey(Long id);

	int insert(SysRoleMenuEntity sysRoleMenuEntity);

	int insertSelective(SysRoleMenuEntity sysRoleMenuEntity);
	
	int updateByPrimaryKey(SysRoleMenuEntity sysRoleMenuEntity);

	SysRoleMenuVO selectByPrimaryKey(Long id);

	List<SysRoleMenuVO> selectAll(SysRoleMenuVO sysRoleMenuVO);

	boolean bathDelete(Long[] ids);

}
