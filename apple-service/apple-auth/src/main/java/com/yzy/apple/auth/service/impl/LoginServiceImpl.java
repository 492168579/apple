package com.yzy.apple.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yzy.apple.auth.dao.SysUserDao;
import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.entity.UserDetailsImpl;
import com.yzy.apple.auth.service.LoginService;
import com.yzy.apple.auth.util.JwtTokenUtil;
import com.yzy.apple.auth.vo.SysUserVO;

import io.jsonwebtoken.lang.Collections;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public void register(SysUserEntity sysUserEntity) {
		String username = sysUserEntity.getUsername();
		SysUserVO reqSysUser = new SysUserVO();
		reqSysUser.setUsername(username);
		List<SysUserVO> resSysUsers = sysUserDao.selectAll(reqSysUser);
		if (!Collections.isEmpty(resSysUsers)) {
			throw new RuntimeException("对不起，该用户已经存在");
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = sysUserEntity.getPassword();
		sysUserEntity.setPassword(encoder.encode(rawPassword));
		sysUserDao.insertSelective(sysUserEntity);
	}

	@Override
	public String login(SysUserVO sysUserVO) {
		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(sysUserVO.getUsername(), sysUserVO.getPassword());
	    Authentication authentication = authenticationManager.authenticate(upToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = userDetailsService.loadUserByUsername(sysUserVO.getUsername());
		String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

}
