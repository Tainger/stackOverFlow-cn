/*Table structure for table `t_factor_category` */
CREATE TABLE `t_factor_category` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT NULL COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT NULL COMMENT '更新时间',
  `code` varchar(100)  DEFAULT NULL COMMENT '编码',  
  `description` varchar(255)  DEFAULT NULL COMMENT '描述信息',
  `edit_flag` int(11) DEFAULT '1' COMMENT '是否可编辑',
  `name` varchar(100)  DEFAULT NULL COMMENT '名称',
  `pos` int(11) DEFAULT NULL COMMENT '索引号/位置',
  `pos_code` varchar(100)  DEFAULT NULL COMMENT '位置编码',
  `parent_id` char(32)  DEFAULT NULL COMMENT '父级类别',
  PRIMARY KEY (`id`),
  KEY `FK1pck0qkmwoql8kg2dv56tml4r` (`parent_id`),
  CONSTRAINT `FK1pck0qkmwoql8kg2dv56tml4r` FOREIGN KEY (`parent_id`) REFERENCES `t_factor_category` (`id`)
) ENGINE=InnoDB;

/*Table structure for table `t_unit_type` */
CREATE TABLE `t_unit_type` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT NULL COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT NULL COMMENT '更新时间',
  `code` varchar(100)  DEFAULT NULL COMMENT '编码',
  `name` varchar(100)  DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

/*Table structure for table `t_measure_unit` */
CREATE TABLE `t_measure_unit` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT NULL COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT NULL COMMENT '更新时间',
  `code` varchar(100)  DEFAULT NULL COMMENT '编码/单位符号',
  `name` varchar(100)  DEFAULT NULL COMMENT '名称',
  `standard_flag` int(11) DEFAULT '1' COMMENT '是否标准单位',
  `trans_formula` varchar(100)  DEFAULT NULL COMMENT '单位转换表达式',
  `unit_type` char(32)  DEFAULT NULL COMMENT '单位类型',
  PRIMARY KEY (`id`),
  KEY `FK1956fdtedylcsggg3nsxqta8m` (`unit_type`),
  CONSTRAINT `FK1956fdtedylcsggg3nsxqta8m` FOREIGN KEY (`unit_type`) REFERENCES `t_unit_type` (`id`)
) ENGINE=InnoDB;

/*Table structure for table `t_factor_index` */
CREATE TABLE `t_factor_index` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT NULL COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT NULL COMMENT '更新时间',
  `alias_name` varchar(100)  DEFAULT NULL COMMENT '别名',
  `cas_symbol` varchar(100)  DEFAULT NULL COMMENT 'CAS号',
  `chemical_symbol` varchar(100)  DEFAULT NULL COMMENT '化学符号',
  `code` varchar(100)  DEFAULT NULL COMMENT '因子编码',
  `description` varchar(255)  DEFAULT NULL COMMENT '描述信息',
  `edit_flag` int(11) DEFAULT '1' COMMENT '是否可编辑',
  `ext_code_1` varchar(100)  DEFAULT NULL COMMENT '扩展编码1',
  `ext_code_2` varchar(100)  DEFAULT NULL COMMENT '扩展编码2',
  `name` varchar(100)  DEFAULT NULL COMMENT '因子名称',
  `e_name` varchar(100)  DEFAULT NULL COMMENT '因子英文名称',
  `default_unit` char(32)  DEFAULT NULL COMMENT '默认单位',
  `factor_category` char(32)  DEFAULT NULL COMMENT '因子类别',
  PRIMARY KEY (`id`),
  KEY `FKjpt2beqwbwst68a6df7bj14b7` (`default_unit`),
  KEY `FKx2gxwvcu0jk227m18qoecwka` (`factor_category`),
  CONSTRAINT `FKjpt2beqwbwst68a6df7bj14b7` FOREIGN KEY (`default_unit`) REFERENCES `t_measure_unit` (`id`),
  CONSTRAINT `FKx2gxwvcu0jk227m18qoecwka` FOREIGN KEY (`factor_category`) REFERENCES `t_factor_category` (`id`)
) ENGINE=InnoDB;


/*Table structure for table `t_surface_water_standard` */
CREATE TABLE `t_surface_water_standard` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT NULL COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT NULL COMMENT '更新时间',
  `down_value` float DEFAULT NULL COMMENT '项目标准区间下限值',
  `limit_type` int(11) DEFAULT NULL COMMENT '限值类别,0:区间,1:<=,2:>=',
  `name` varchar(100)  DEFAULT NULL COMMENT '名称',
  `up_value` float DEFAULT NULL COMMENT '项目标准区间上限值',
  `value` float DEFAULT NULL COMMENT '项目标准限值',
  `factor_index` char(32)  DEFAULT NULL COMMENT '监测指标',
  `quality_grade` char(32)  DEFAULT NULL COMMENT '地表水质等级',
  `unit` char(32)  DEFAULT NULL COMMENT '计量单位',
  PRIMARY KEY (`id`),
  KEY `FKba3kmf1c017966mqkgan4ar88` (`factor_index`),
  KEY `FKgnfmevwu8sw6cluocyw73ogwt` (`quality_grade`),
  KEY `FK1o4p43ij0p2u1idm53in4q1gd` (`unit`),
  CONSTRAINT `FK1o4p43ij0p2u1idm53in4q1gd` FOREIGN KEY (`unit`) REFERENCES `t_measure_unit` (`id`),
  CONSTRAINT `FKba3kmf1c017966mqkgan4ar88` FOREIGN KEY (`factor_index`) REFERENCES `t_factor_index` (`id`),
  CONSTRAINT `FKgnfmevwu8sw6cluocyw73ogwt` FOREIGN KEY (`quality_grade`) REFERENCES `t_surface_water_quality_grade` (`id`)
) ENGINE=InnoDB;

ALTER TABLE t_surface_water_standard ADD UNIQUE (factor_index, quality_grade);
