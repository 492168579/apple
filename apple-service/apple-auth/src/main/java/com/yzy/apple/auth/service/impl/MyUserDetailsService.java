package com.yzy.apple.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yzy.apple.auth.dao.SysUserDao;
import com.yzy.apple.auth.dao.SysUserRoleDao;
import com.yzy.apple.auth.entity.UserDetailsImpl;
import com.yzy.apple.auth.vo.SysUserRoleVO;
import com.yzy.apple.auth.vo.SysUserVO;

import io.jsonwebtoken.lang.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 获取当前用户
		SysUserVO reqSysUser = new SysUserVO();
		reqSysUser.setUsername(username);
		List<SysUserVO> resSysUsers = sysUserDao.selectAll(reqSysUser);
		if (Collections.isEmpty(resSysUsers)) {
			throw new UsernameNotFoundException("对不起，该用户不存在");
		}
		// 获取用户角色
		SysUserVO resSysUser = resSysUsers.get(0);
		Long userId = resSysUser.getUserId();
		SysUserRoleVO sysUserRoleVO = new SysUserRoleVO();
		sysUserRoleVO.setUserId(userId);
		List<SysUserRoleVO> sysUserRoleVOs = sysUserRoleDao.selectAll(sysUserRoleVO);
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority simpleGrantedAuthority = null;
		if (Collections.isEmpty(sysUserRoleVOs)) {
			for (SysUserRoleVO userRoleVO : sysUserRoleVOs) {
				simpleGrantedAuthority = new SimpleGrantedAuthority(userRoleVO.getRoleId().toString());
				authorities.add(simpleGrantedAuthority);
			}
		}
		return new UserDetailsImpl(resSysUser, authorities);
	}

}
