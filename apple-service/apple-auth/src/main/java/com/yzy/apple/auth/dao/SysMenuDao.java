package com.yzy.apple.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yzy.apple.auth.entity.SysMenuEntity;
import com.yzy.apple.auth.vo.SysMenuVO;

/**
 * 菜单管理
 * 
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
@Mapper
public interface SysMenuDao {
     

	int deleteByPrimaryKey(Long menuId);

	int insert(SysMenuEntity sysMenuEntity);

	int insertSelective(SysMenuEntity sysMenuEntity);
	
	int updateByPrimaryKey(SysMenuEntity sysMenuEntity);

	SysMenuVO selectByPrimaryKey(Long menuId);

	List<SysMenuVO> selectAll(SysMenuVO sysMenuVO);

	boolean bathDelete(Long[] menuIds);

}
