/**修改描述字段限制*/
alter table t_surface_water_quality_grade modify column description varchar(350);
alter table t_factor_category modify column description varchar(350);
alter table t_factor_index modify column description varchar(350);
alter table t_ground_water_quality_category modify column description varchar(350);
alter table t_black_smelly_water_grade modify column description varchar(350);
alter table t_ground_water_quality_grade modify column description varchar(350);
alter table t_sea_water_quality_category modify column description varchar(350);
alter table t_sea_water_quality_grade modify column basis varchar(350);

