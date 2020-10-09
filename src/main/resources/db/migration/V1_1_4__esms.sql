CREATE TABLE `t_drinking_water_standard` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `down_value` float DEFAULT NULL COMMENT '项目标准区间下限值',
  `limit_type` int(1) DEFAULT NULL COMMENT '限值类别,0:区间,1:<=,2:>=',
  `up_value` float DEFAULT NULL COMMENT '项目标准区间上限值',
  `value` float DEFAULT NULL COMMENT '项目标准限值',
  `factor_index` char(32) DEFAULT NULL COMMENT '监测指标',
  `unit` char(32) DEFAULT NULL COMMENT '计量单位',
  PRIMARY KEY (`id`),
  KEY `fk_dws_fi` (`factor_index`),
  KEY `fk_dws_mu` (`unit`),
  CONSTRAINT `fk_dws_fi` FOREIGN KEY (`factor_index`) REFERENCES `t_factor_index` (`id`),
  CONSTRAINT `fk_dws_mu` FOREIGN KEY (`unit`) REFERENCES `t_measure_unit` (`id`)
) ENGINE=InnoDB;
alter table t_drinking_water_standard add unique (factor_index);

CREATE TABLE `t_black_smelly_water_grade` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '级别名称',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `value` int(11) DEFAULT NULL COMMENT '级别值',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `t_black_smelly_water_grade` VALUES ('3333ae2734d64bbe8b598af6c6610001', '2019-06-06 16:33:48', '2019-06-06 17:22:13', '无黑臭','#5AB1EF', '1', null);
INSERT INTO `t_black_smelly_water_grade` VALUES ('3333ae2734d64bbe8b598af6c6610002', '2019-06-06 16:33:48', '2019-06-06 17:22:13', '轻度黑臭','#CCCCCC', '2', null);
INSERT INTO `t_black_smelly_water_grade` VALUES ('3333ae2734d64bbe8b598af6c6610003', '2019-06-06 16:33:48', '2019-06-06 17:22:13', '重度黑臭','#333333', '3', null);


CREATE TABLE `t_ground_water_quality_category` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '类别名称',
  `value` int(11) DEFAULT NULL COMMENT '级别值',
  `water_quality` varchar(50) DEFAULT NULL COMMENT '水质状况',
  `evaluation_score` float DEFAULT NULL COMMENT '评价分值Fi',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `t_ground_water_quality_category` VALUES ('3333ae2734d64bbe8b598af6c6610001', '2019-06-06 16:33:48', '2019-06-06 17:22:13', 'I', '1', '优良', '0', '#03A9F4', '主要反映地下水化学组分的天然低背景含量。适用于各种用途。');
INSERT INTO `t_ground_water_quality_category` VALUES ('3333ae2734d64bbe8b598af6c6610002', '2019-06-06 16:34:09', '2019-06-06 16:34:33', 'II', '2', '良好', '1', '#85C940', '主要反映地下水化学组分的天然背景含量。适用于各种用途。');
INSERT INTO `t_ground_water_quality_category` VALUES ('3333ae2734d64bbe8b598af6c6610003', '2019-06-06 16:35:33', '2019-06-06 16:46:11', 'III', '3', '较好', '3', '#D9CD4C', '以人体健康基准值为依据。主要适用于集中式生活饮用水水源及工农业用水。');
INSERT INTO `t_ground_water_quality_category` VALUES ('3333ae2734d64bbe8b598af6c6610004', '2019-06-06 16:36:53', '2019-06-06 16:36:53', 'IV', '4', '较差', '6', '#EF8E00', '以农业和工业用水要求为依据。除适用于农业和部分工业用水外，适当处理后可作生活饮用水。');
INSERT INTO `t_ground_water_quality_category` VALUES ('3333ae2734d64bbe8b598af6c6610005', '2019-06-06 16:37:25', '2019-06-06 16:37:25', 'V', '5', '极差', '10', '#E12234', '不宜饮用，其他用水可根据使用目的选用。');

CREATE TABLE `t_ground_water_quality_grade` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '类别名称',
  `value` int(11) DEFAULT NULL COMMENT '级别值',
  `down_value` float DEFAULT NULL COMMENT 'F下限值（含）',
  `up_value` float DEFAULT NULL COMMENT 'F上限值（不含）',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `t_ground_water_quality_grade` VALUES ('3333ae2734d64bbe8b578af6c6610008', '2019-06-06 16:41:45', '2019-06-06 16:41:45', '良好', '2', '0.8', '2.5', '#85C940', null);
INSERT INTO `t_ground_water_quality_grade` VALUES ('3333ae2734d64bbe8b578af6c6610109', '2019-06-06 16:42:06', '2019-06-06 16:42:14', '较好', '3', '2.5', '4.25', '#D9CD4C', null);
INSERT INTO `t_ground_water_quality_grade` VALUES ('3333ae2734d64bbe8b578af6c6610110', '2019-06-06 16:42:39', '2019-06-06 16:42:39', '较差', '4', '4.25', '7.2', '#EF8E00 ', null);
INSERT INTO `t_ground_water_quality_grade` VALUES ('3333ae2734d64bbe8b578af6c6610211', '2019-06-06 16:42:59', '2019-06-06 16:42:59', '极差', '5', '7.2', null, '#E12234', null);
INSERT INTO `t_ground_water_quality_grade` VALUES ('3333ae2734d64bbe8b598af6c6610007', '2019-06-06 16:41:10', '2019-06-06 16:41:10', '优良', '1', null, '0.8', '#03A9F4', null);

CREATE TABLE `t_sea_water_quality_category` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `name` varchar(100) DEFAULT NULL COMMENT '类别名称',
  `value` int(11) DEFAULT NULL COMMENT '级别值',
  `water_quality` varchar(50) DEFAULT NULL COMMENT '水质状况',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `t_sea_water_quality_category`(id,name,value,water_quality,color,description) VALUES ('3332ae2734d64bbe8b578af6c6610001','第一类','1','优','#03A9F4','适用于海洋渔业水域，海上自然保护区和珍稀濒危海洋生物保护区');
INSERT INTO `t_sea_water_quality_category`(id,name,value,water_quality,color,description) VALUES ('3322ar2734d64bbe8b578af6c6610001','第二类','2','良','#85C940','适用于水产养殖区，海水浴场，人体直接接触海水的海上运动或娱乐区，以及与人类食用直接有关的工业用水区。');
INSERT INTO `t_sea_water_quality_category`(id,name,value,water_quality,color,description) VALUES ('3232ae2534d64bbe8b578af6c6610001','第三类','3','轻度污染','#D9CD4C','适用于一般工业用水区，滨海风景旅游区。');
INSERT INTO `t_sea_water_quality_category`(id,name,value,water_quality,color,description) VALUES ('3d32re2734d64bbe8b578af6c6610001','第四类','4','中度污染','#EF8E00','适用于海洋港口水域，海洋开发作业区。');
INSERT INTO `t_sea_water_quality_category`(id,name,value,water_quality,color,description) VALUES ('333dae2344d64bbe8b578af6c6610001','第五类','5','重度污染','#E12234','主要适用于农业用水区及一般景观要求水域');


CREATE TABLE `t_sea_water_quality_grade` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `water_quality_level` varchar(50) DEFAULT NULL COMMENT '水质状况级别',
  `value` int(11) DEFAULT NULL COMMENT '级别值',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `basis` varchar(255) DEFAULT NULL COMMENT '确定依据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `t_sea_water_quality_grade`(id,water_quality_level,value,color,basis) VALUES ('3332ae2734d64bbe8b578af6c6610001','优','1','#03A9F4','一类≥60%且一类、二类≥90%');
INSERT INTO `t_sea_water_quality_grade`(id,water_quality_level,value,color,basis) VALUES ('3332ae2734d64bbe8b578af6c6610002','良好','2','#85C940','一类、二类≥80%');
INSERT INTO `t_sea_water_quality_grade`(id,water_quality_level,value,color,basis) VALUES ('3332ae2734d64bbe8b578af6c6610003','一般','3','#D9CD4C','一类、二类≥60%且劣四类≤30%；或一类、二类<60%且一至三类≥90%');
INSERT INTO `t_sea_water_quality_grade`(id,water_quality_level,value,color,basis) VALUES ('3332ae2734d64bbe8b578af6c6610004','差','4','#EF8E00','一类、二类<60%且劣四类≤30%；或30%<劣四类≤40%；或一类、二类<60%且一至四类≥90%');
INSERT INTO `t_sea_water_quality_grade`(id,water_quality_level,value,color,basis) VALUES ('3332ae2734d64bbe8b578af6c6610005','极差','5','#E12234','劣四类>60%');

CREATE TABLE `t_black_smelly_water_standard` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `factor_index` char(32) DEFAULT NULL COMMENT '监测因子',
  `limit_type` int(1) DEFAULT NULL COMMENT '限值类别,0:区间,1:<=,2:>=',
  `unit` char(32) DEFAULT NULL COMMENT '计量单位',
  `no_black_smelly` float DEFAULT NULL COMMENT '无黑臭',
  `down_no_black_smelly` float DEFAULT NULL COMMENT '无黑臭下限',
  `up_no_black_smelly` float DEFAULT NULL COMMENT '无黑臭上限',
  `mild_black_smelly` float DEFAULT NULL COMMENT '轻度黑臭',
  `down_mild_black_smelly` float DEFAULT NULL COMMENT '轻度黑臭下限',
  `up_mild_black_smelly` float DEFAULT NULL COMMENT '轻度黑臭上限',
  PRIMARY KEY (`id`),
  KEY `fk_bsws_fi` (`factor_index`),
  KEY `fk_bsws_mu` (`unit`),
  CONSTRAINT `fk_bsws_fi` FOREIGN KEY (`factor_index`) REFERENCES `t_factor_index` (`id`),
  CONSTRAINT `fk_bsws_mu` FOREIGN KEY (`unit`) REFERENCES `t_measure_unit` (`id`)
) ENGINE=InnoDB;
alter table t_black_smelly_water_standard add unique (factor_index);

CREATE TABLE `t_ground_water_standard` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `down_value` float DEFAULT NULL COMMENT '项目标准区间下限值',
  `limit_type` int(1) DEFAULT NULL COMMENT '限值类别,0:区间,1:<=,2:>=',
  `up_value` float DEFAULT NULL COMMENT '项目标准区间上限值',
  `value` float DEFAULT NULL COMMENT '项目标准限值',
  `factor_index` char(32)  DEFAULT NULL COMMENT '监测指标',
  `quality_grade` char(32)  DEFAULT NULL COMMENT '地下水水质等级',
  `unit` char(32)  DEFAULT NULL COMMENT '计量单位',
  PRIMARY KEY (`id`),
  KEY `fk_gws_fi` (`factor_index`),
  KEY `fk_gws_gwqc` (`quality_grade`),
  KEY `fk_gws_mu` (`unit`),
  CONSTRAINT `fk_gws_mu` FOREIGN KEY (`unit`) REFERENCES `t_measure_unit` (`id`),
  CONSTRAINT `fk_gws_fi` FOREIGN KEY (`factor_index`) REFERENCES `t_factor_index` (`id`),
  CONSTRAINT `fk_gws_gwqc` FOREIGN KEY (`quality_grade`) REFERENCES `t_ground_water_quality_category` (`id`)
) ENGINE=InnoDB;
alter table t_ground_water_standard add unique (factor_index,quality_grade);

CREATE TABLE `t_sea_water_standard` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `down_value` float DEFAULT NULL COMMENT '项目标准区间下限值',
  `limit_type` int(1) DEFAULT NULL COMMENT '限值类别,0:区间,1:<=,2:>=',
  `up_value` float DEFAULT NULL COMMENT '项目标准区间上限值',
  `value` float DEFAULT NULL COMMENT '项目标准限值',
  `factor_index` char(32)  DEFAULT NULL COMMENT '监测指标',
  `quality_grade` char(32)  DEFAULT NULL COMMENT '地下水水质等级',
  `unit` char(32)  DEFAULT NULL COMMENT '计量单位',
  PRIMARY KEY (`id`),
  KEY `fk_sws_fi` (`factor_index`),
  KEY `fk_sws_swqc` (`quality_grade`),
  KEY `fk_sws_mu` (`unit`),
  CONSTRAINT `fk_sws_mu` FOREIGN KEY (`unit`) REFERENCES `t_measure_unit` (`id`),
  CONSTRAINT `fk_sws_fi` FOREIGN KEY (`factor_index`) REFERENCES `t_factor_index` (`id`),
  CONSTRAINT `fk_sws_swqc` FOREIGN KEY (`quality_grade`) REFERENCES `t_sea_water_quality_category` (`id`)
) ENGINE=InnoDB;
alter table t_sea_water_standard add unique (factor_index,quality_grade);


