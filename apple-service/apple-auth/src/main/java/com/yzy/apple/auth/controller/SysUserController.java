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
import com.yzy.apple.auth.entity.SysUserEntity;
import com.yzy.apple.auth.service.SysUserService;
import com.yzy.apple.auth.vo.SysUserVO;
import com.yzy.apple.common.utils.ParameterVo;
import com.yzy.apple.common.utils.R;
import com.github.pagehelper.PageInfo;



/**
 * 系统用户
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:14
 */
@RestController
@RequestMapping("auth/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    
	/**
	 * 分页
	 */
	@PostMapping("/page")
	public R page(@RequestBody ParameterVo<SysUserVO> params) {
		PageInfo<SysUserVO> page = sysUserService.queryPage(params);
		return R.ok().put("data", page);
	}

	/**
	 * 列表
	 */
	@PostMapping("/list")
	public R list(@RequestBody SysUserVO sysUserVO) {
		List<SysUserVO> list = sysUserService.list(sysUserVO);
		return R.ok().put("data", list);
	}
	
	
	/**
	 * 保存
	 */
    @RequestMapping("/save")
    public R save(@RequestBody SysUserEntity sysUser){
		sysUserService.insert(sysUser);
        return R.ok();
    }
    
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] userIds){
		sysUserService.deleteBatch(userIds);
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId){
		SysUserEntity sysUser = sysUserService.selectById(userId);
        return R.ok().put("data", sysUser);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysUserEntity sysUser){
	    sysUserService.updateById(sysUser);
        return R.ok();
    }



}
