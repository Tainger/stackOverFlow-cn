/**增加流域水质状况**/
create table t_basin_water_quality (
    id char(32) primary key COMMENT '主键',
    quality_state varchar(50) COMMENT '水质状况',
    level int(2) COMMENT '级别值',
    color varchar(50) COMMENT '表征颜色',
    description varchar(350) COMMENT '描述'
) ENGINE=InnoDB;

insert into t_basin_water_quality(id,quality_state,level,color,description) values ('97b2fd17ef8244f9a67f8d31211a24d6','优',1,'#5AB1EF','Ⅰ～Ⅲ类水质比例≥90%');
insert into t_basin_water_quality(id,quality_state,level,color,description) values ('5065c6de82f84a6d91e9c045e8445cf2','良好',2,'#42cc70','75％≤Ⅰ～Ⅲ类水质比例＜90％');
insert into t_basin_water_quality(id,quality_state,level,color,description) values ('d22d41719eb34b9b96ef735d82ea30d5','轻度污染',3,'#e8dd3e','Ⅰ～Ⅲ类水质比例＜75％，且劣Ⅴ类比例＜20％');
insert into t_basin_water_quality(id,quality_state,level,color,description) values ('0fdba169b935452f85dfa7f6afa85e89','中度污染',4,'#f5a524','Ⅰ～Ⅲ类水质比例＜75％，且 20％≤劣Ⅴ类比例＜40％');
insert into t_basin_water_quality(id,quality_state,level,color,description) values ('0c162842aa9649beb201425739ca5a7e','重度污染',5,'#5AB1EF','Ⅰ～Ⅲ类水质比例＜60％，且劣Ⅴ类比例≥40％');

