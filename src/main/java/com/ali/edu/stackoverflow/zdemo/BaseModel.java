package com.ali.edu.stackoverflow.zdemo;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 实体基础类
 * 
 * @author yunjie_zhu
 * @created 2019年4月18日
 */
@MappedSuperclass
public class BaseModel {

	@Id
	@Column(name = "bmp_id")
	private Long bmpId;

	@Column(name = "id")
	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(updatable = false, name = "create_timestamp", columnDefinition = "datetime comment '创建时间'")
	private Date createTimestamp;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "last_change_timestamp", columnDefinition = "datetime comment '更新时间'")
	private Date lastChangeTimestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Date getLastChangeTimestamp() {
		return lastChangeTimestamp;
	}

	public void setLastChangeTimestamp(Date lastChangeTimestamp) {
		this.lastChangeTimestamp = lastChangeTimestamp;
	}

	public Long getBmpId() {
		return bmpId;
	}

	public void setBmpId(Long bmpId) {
		this.bmpId = bmpId;
	}

	/**
	 * 入库前初始化,设置uuid,时间信息
	 */
	public void initialize() {
		this.setCreateTimestamp(new Date());
		this.setLastChangeTimestamp(new Date());
	}

	@Override
	public String toString() {
		return "BaseModel{" +
				"bmpId=" + bmpId +
				", id='" + id + '\'' +
				", createTimestamp=" + createTimestamp +
				", lastChangeTimestamp=" + lastChangeTimestamp +
				'}';
	}
}
