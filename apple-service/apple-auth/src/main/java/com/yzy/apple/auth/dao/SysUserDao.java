package com.yzy.apple.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.vo.SysUserVO;

/**
 * 系统用户
 * 
 * @author 
 * @email 
 * @date 2019-03-30 23:40:14
 */
@Mapper
public interface SysUserDao {
     

	int deleteByPrimaryKey(Long userId);

	int insert(SysUserEntity sysUserEntity);

	int insertSelective(SysUserEntity sysUserEntity);
	
	int updateByPrimaryKey(SysUserEntity sysUserEntity);

	SysUserVO selectByPrimaryKey(Long userId);

	List<SysUserVO> selectAll(SysUserVO sysUserVO);

	boolean bathDelete(Long[] userIds);

}
