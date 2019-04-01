package com.yzy.apple.auth.vo;

import java.util.Date;
import com.yzy.apple.auth.entity.SysUserEntity;

/**
 * 系统用户
 * 
 * @author
 * @email
 * @date 2019-03-30 23:40:14
 */
public class SysUserVO extends SysUserEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 创建时间查询开始时间
	 */
	private String createTimeStart;
	/**
	 * 创建时间查询结束时间
	 */
	private String createTimeEnd;

	/**
	 * 设置：创建时间查询开始时间
	 */
	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	/**
	 * 获取：创建时间查询开始时间
	 */
	public String getCreateTimeStart() {
		return createTimeStart;
	}

	/**
	 * 设置：创建时间查询结束时间
	 */
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	/**
	 * 获取：创建时间查询结束时间
	 */
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

}
