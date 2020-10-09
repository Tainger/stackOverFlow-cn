alter table t_surface_water_standard add river_or_lake int default 0 comment '0.河流 1.湖库';
alter table t_surface_water_standard drop index factor_index;
alter table t_surface_water_standard add unique (factor_index, quality_grade, river_or_lake);