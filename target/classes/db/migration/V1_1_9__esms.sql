/**删除黑臭水标准**/
drop table if exists `t_black_smelly_water_standard`;

CREATE TABLE `t_black_smelly_water_standard` (
  `id` char(32) NOT NULL,
  `create_timestamp` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `last_change_timestamp` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `factor_index` char(32) DEFAULT NULL COMMENT '监测因子',
  `limit_type` int(1) DEFAULT NULL COMMENT '限值类别,0:区间,1:<=,2:>=',
  `unit` char(32) DEFAULT NULL COMMENT '计量单位',
  `up_value` float DEFAULT NULL COMMENT '项目标准区间上限值',
  `value` float DEFAULT NULL COMMENT '项目标准限值',
  `down_value` float DEFAULT NULL COMMENT '项目标准区间下限值',
  `quality_grade` char(32)  DEFAULT NULL COMMENT '黑臭水等级',
  PRIMARY KEY (`id`),
  KEY `fk_bsws_fi` (`factor_index`),
  KEY `fk_bsws_mu` (`unit`),
  CONSTRAINT `uq_bsws_fi_qg` UNIQUE (`factor_index`,`quality_grade`),
  CONSTRAINT `fk_bsws_fi` FOREIGN KEY (`factor_index`) REFERENCES `t_factor_index` (`id`),
  CONSTRAINT `fk_bsws_mu` FOREIGN KEY (`unit`) REFERENCES `t_measure_unit` (`id`)
) ENGINE=InnoDB;