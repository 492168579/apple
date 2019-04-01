package com.yzy.apple.auth.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.yzy.apple.auth.entity.SysRoleEntity;
import com.yzy.apple.auth.service.SysRoleService;
import com.yzy.apple.auth.vo.SysRoleVO;
import com.yzy.apple.common.utils.ParameterVo;
import com.yzy.apple.common.utils.R;
import com.github.pagehelper.PageInfo;



/**
 * 角色
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
@RestController
@RequestMapping("auth/sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    
	/**
	 * 分页
	 */
	@PostMapping("/page")
	public R page(@RequestBody ParameterVo<SysRoleVO> params) {
		PageInfo<SysRoleVO> page = sysRoleService.queryPage(params);
		return R.ok().put("data", page);
	}

	/**
	 * 列表
	 */
	@PostMapping("/list")
	public R list(@RequestBody SysRoleVO sysRoleVO) {
		List<SysRoleVO> list = sysRoleService.list(sysRoleVO);
		return R.ok().put("data", list);
	}
	
	
	/**
	 * 保存
	 */
    @RequestMapping("/save")
    public R save(@RequestBody SysRoleEntity sysRole){
		sysRoleService.insert(sysRole);
        return R.ok();
    }
    
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] roleIds){
		sysRoleService.deleteBatch(roleIds);
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    public R info(@PathVariable("roleId") Long roleId){
		SysRoleEntity sysRole = sysRoleService.selectById(roleId);
        return R.ok().put("data", sysRole);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysRoleEntity sysRole){
	    sysRoleService.updateById(sysRole);
        return R.ok();
    }



}
