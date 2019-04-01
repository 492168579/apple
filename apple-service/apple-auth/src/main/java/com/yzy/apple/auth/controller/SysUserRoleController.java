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
import com.yzy.apple.auth.entity.SysUserRoleEntity;
import com.yzy.apple.auth.service.SysUserRoleService;
import com.yzy.apple.auth.vo.SysUserRoleVO;
import com.yzy.apple.common.utils.ParameterVo;
import com.yzy.apple.common.utils.R;
import com.github.pagehelper.PageInfo;



/**
 * 用户与角色对应关系
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:14
 */
@RestController
@RequestMapping("auth/sysuserrole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;
    
	/**
	 * 分页
	 */
	@PostMapping("/page")
	public R page(@RequestBody ParameterVo<SysUserRoleVO> params) {
		PageInfo<SysUserRoleVO> page = sysUserRoleService.queryPage(params);
		return R.ok().put("data", page);
	}

	/**
	 * 列表
	 */
	@PostMapping("/list")
	public R list(@RequestBody SysUserRoleVO sysUserRoleVO) {
		List<SysUserRoleVO> list = sysUserRoleService.list(sysUserRoleVO);
		return R.ok().put("data", list);
	}
	
	
	/**
	 * 保存
	 */
    @RequestMapping("/save")
    public R save(@RequestBody SysUserRoleEntity sysUserRole){
		sysUserRoleService.insert(sysUserRole);
        return R.ok();
    }
    
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		sysUserRoleService.deleteBatch(ids);
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SysUserRoleEntity sysUserRole = sysUserRoleService.selectById(id);
        return R.ok().put("data", sysUserRole);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysUserRoleEntity sysUserRole){
	    sysUserRoleService.updateById(sysUserRole);
        return R.ok();
    }



}
