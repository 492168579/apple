package com.yzy.apple.auth.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yzy.apple.auth.dao.SysUserMapper;
import com.yzy.apple.auth.entity.SysUser;
import com.yzy.apple.auth.entity.UserDetailsImpl;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//获取当前用户
		SysUser reqSysUser = new SysUser();
		SysUser resSysUser = sysUserMapper.selectObj(reqSysUser);
		if (resSysUser == null) {
			throw new UsernameNotFoundException("对不起，该用户不存在");
		}
		//获取用户角色
		Long userId = resSysUser.getUserId();
		
		
		
		return new UserDetailsImpl(resSysUser);
	}

	private Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authList;
	}

}
