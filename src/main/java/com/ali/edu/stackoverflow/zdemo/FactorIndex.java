package com.ali.edu.stackoverflow.zdemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 因子与指标
 * 
 * @author yunjie_zhu
 * @created 2019年4月18日
 */
@Table(name = "t_factor_index")
@Getter
@Setter
@ToString
public class FactorIndex extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1327608009416082111L;

	@Column(columnDefinition = "varchar(100) comment '因子名称'")
	private String name;
	
	@Column(name = "e_name",columnDefinition = "varchar(100) comment '因子英文名称'")
	private String ename;

	@Column(name = "code",columnDefinition = "varchar(100) comment '因子编码'")
	private String code;

	@Column(name = "edit_flag", columnDefinition = "int default 1 comment '是否可编辑'")
	private Integer editFlag;

	@Column(name = "factor_category", columnDefinition = "char(32) comment '因子类别'")
	private String factorCategoryId;

	@Column(name = "chemical_symbol", columnDefinition = "varchar(100) comment '化学符号'")
	private String chemicalSymbol;

	@Column(name = "cas_symbol", columnDefinition = "varchar(100) comment 'CAS号'")
	private String casSymbol;

	@Column(name = "alias_name", columnDefinition = "varchar(100) comment '别名'")
	private String aliasName;

	@Column(columnDefinition = "varchar(255) comment '描述信息'")
	private String description;

	@Column(name = "default_unit", columnDefinition = "char(32) comment '默认单位'")
	private String defaultUnitId;

	@Column(name = "ext_code_1", columnDefinition = "varchar(100) comment '扩展编码1'")
	private String extCode1;

	@Column(name = "ext_code_2", columnDefinition = "varchar(100) comment '扩展编码2'")
	private String extCode2;
}