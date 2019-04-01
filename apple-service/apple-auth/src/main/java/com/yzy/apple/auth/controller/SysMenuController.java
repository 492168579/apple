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
import com.yzy.apple.auth.entity.SysMenuEntity;
import com.yzy.apple.auth.service.SysMenuService;
import com.yzy.apple.auth.vo.SysMenuVO;
import com.yzy.apple.common.utils.ParameterVo;
import com.yzy.apple.common.utils.R;
import com.github.pagehelper.PageInfo;



/**
 * 菜单管理
 *
 * @author 
 * @email 
 * @date 2019-03-30 23:40:15
 */
@RestController
@RequestMapping("auth/sysmenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    
	/**
	 * 分页
	 */
	@PostMapping("/page")
	public R page(@RequestBody ParameterVo<SysMenuVO> params) {
		PageInfo<SysMenuVO> page = sysMenuService.queryPage(params);
		return R.ok().put("data", page);
	}

	/**
	 * 列表
	 */
	@PostMapping("/list")
	public R list(@RequestBody SysMenuVO sysMenuVO) {
		List<SysMenuVO> list = sysMenuService.list(sysMenuVO);
		return R.ok().put("data", list);
	}
	
	
	/**
	 * 保存
	 */
    @RequestMapping("/save")
    public R save(@RequestBody SysMenuEntity sysMenu){
		sysMenuService.insert(sysMenu);
        return R.ok();
    }
    
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] menuIds){
		sysMenuService.deleteBatch(menuIds);
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    public R info(@PathVariable("menuId") Long menuId){
		SysMenuEntity sysMenu = sysMenuService.selectById(menuId);
        return R.ok().put("data", sysMenu);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysMenuEntity sysMenu){
	    sysMenuService.updateById(sysMenu);
        return R.ok();
    }



}
