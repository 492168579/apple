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
import com.yzy.apple.auth.entity.SysRoleMenuEntity;
import com.yzy.apple.auth.service.SysRoleMenuService;
import com.yzy.apple.auth.vo.SysRoleMenuVO;
import com.yzy.apple.common.utils.ParameterVo;
import com.yzy.apple.common.utils.R;
import com.github.pagehelper.PageInfo;



/**
 * 角色与菜单对应关系
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
@RestController
@RequestMapping("auth/sysrolemenu")
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    
	/**
	 * 分页
	 */
	@PostMapping("/page")
	public R page(@RequestBody ParameterVo<SysRoleMenuVO> params) {
		PageInfo<SysRoleMenuVO> page = sysRoleMenuService.queryPage(params);
		return R.ok().put("data", page);
	}

	/**
	 * 列表
	 */
	@PostMapping("/list")
	public R list(@RequestBody SysRoleMenuVO sysRoleMenuVO) {
		List<SysRoleMenuVO> list = sysRoleMenuService.list(sysRoleMenuVO);
		return R.ok().put("data", list);
	}
	
	
	/**
	 * 保存
	 */
    @RequestMapping("/save")
    public R save(@RequestBody SysRoleMenuEntity sysRoleMenu){
		sysRoleMenuService.insert(sysRoleMenu);
        return R.ok();
    }
    
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		sysRoleMenuService.deleteBatch(ids);
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SysRoleMenuEntity sysRoleMenu = sysRoleMenuService.selectById(id);
        return R.ok().put("data", sysRoleMenu);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysRoleMenuEntity sysRoleMenu){
	    sysRoleMenuService.updateById(sysRoleMenu);
        return R.ok();
    }



}
