CREATE TABLE `t_surface_water_quality_grade` (
  `id` char(32)  NOT NULL COMMENT '主键',
  `create_timestamp` datetime DEFAULT NULL COMMENT '创建时间',
  `last_change_timestamp` datetime DEFAULT NULL COMMENT '更新时间',
  `code` varchar(100)  DEFAULT NULL COMMENT '编码',
  `color` varchar(100)  DEFAULT NULL COMMENT '表征颜色',
  `description` varchar(255)  DEFAULT NULL COMMENT '描述信息',
  `level` int(11) DEFAULT NULL COMMENT '级别值',
  `name` varchar(100)  DEFAULT NULL COMMENT '名称',
  `quality_state` varchar(100)  DEFAULT NULL COMMENT '水质状况',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

/**插入初始化水质类别数据**/
insert into t_surface_water_quality_grade (name, description, level, create_timestamp, last_change_timestamp, id, quality_state, color) values ('Ⅰ', '主要适用于源头水、国家自然保护区', '1', '2013-12-5 23:39:42', '2015-10-16 16:49:09', '1c70ae2734d64bbe8b598af6c6612423', '优', '#5ab1ef');
insert into t_surface_water_quality_grade (name, description, level, create_timestamp, last_change_timestamp, id, quality_state, color) values ('Ⅱ', '主要适用于集中式生活饮用水地表水源地一级保护区、珍稀水生生物栖息地、鱼虾类产卵场、仔稚幼鱼的索饵汤等', '2', '2013-12-5 23:39:42', '2015-8-5 14:25:39', '2c70ae2734d64bbe8b598af6c6612423', '优', '#5ab1ef');
insert into t_surface_water_quality_grade (name, description, level, create_timestamp, last_change_timestamp, id, quality_state, color) values ('Ⅲ', '主要适用于集中式生活饮用水地表水源地二级保护区、鱼虾类越冬场、洄游通道、水产养殖区等渔业水域及游泳区', '3', '2013-12-5 23:39:42', '2015-8-5 14:25:50', '3c70ae2734d64bbe8b598af6c6612423', '良好', '#42cc70');
insert into t_surface_water_quality_grade (name, description, level, create_timestamp, last_change_timestamp, id, quality_state, color) values ('Ⅳ', '主要适用于一般工业用水区及人体非直接接触的娱乐用水区', '4', '2013-12-5 23:39:42', '2015-8-5 14:32:12', '5c70ae2734d64bbe8b598af6c6612423', '轻度污染', '#e8dd3e');
insert into t_surface_water_quality_grade (name, description, level, create_timestamp, last_change_timestamp, id, quality_state, color) values ('Ⅴ', '主要适用于农业用水区及一般景观要求水域', '5', '2013-12-5 23:39:42', '2015-8-5 14:32:27', '6c70ae2734d64bbe8b598af6c6612423', '中度污染', '#f5a524');
insert into t_surface_water_quality_grade (name, description, level, create_timestamp, last_change_timestamp, id, quality_state, color) values ('劣Ⅴ', '', '6', '2013-12-5 23:39:42', '2015-8-5 14:32:37', '7c70ae2734d64bbe8b598af6c6612423', '重度污染', '#ed5466');
