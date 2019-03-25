package com.yzy.apple.auth.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysUser;
import com.yzy.apple.auth.service.SysUserService;
import com.yzy.apple.auth.vo.SysUserVO;
import com.yzy.apple.common.controller.AbstractController;
import com.yzy.apple.common.utils.ParameterVo;
import com.yzy.apple.common.utils.R;

@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;

	@PostMapping("/page")
	public R list(@RequestBody ParameterVo<SysUserVO> params) {
		PageInfo<SysUserVO> page = sysUserService.queryPage(params);
		return R.ok().put("page", page);
	}

	@PostMapping("/insert")
	public R insert(@RequestBody SysUser sysUser) {
		sysUserService.insert(sysUser);
		return R.ok();
	}

	@PostMapping("/delete")
	public R delete(@RequestBody Long[] userIds) {
		if (ArrayUtils.contains(userIds, 1L)) {
			return R.error("系统管理员不能删除");
		}
		sysUserService.deleteBatch(userIds);
		return R.ok();
	}

	@PostMapping("/update")
	public R update(@RequestBody SysUser sysUser) {
		sysUserService.update(sysUser);
		return R.ok();
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	public R info(@PathVariable("userId") Long userId) {

		SysUser sysUser = sysUserService.selectById(userId);
		return R.ok().put("sysUser", sysUser);
	}

}
