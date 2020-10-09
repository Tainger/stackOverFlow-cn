

ALTER TABLE t_basin_water_quality  ADD unique(id);
ALTER TABLE t_basin_water_quality DROP PRIMARY KEY;
ALTER TABLE t_basin_water_quality ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_black_smelly_water_grade  ADD unique(id);
ALTER TABLE t_black_smelly_water_grade DROP PRIMARY KEY;
ALTER TABLE t_black_smelly_water_grade ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_black_smelly_water_standard  ADD unique(id);
ALTER TABLE t_black_smelly_water_standard DROP PRIMARY KEY;
ALTER TABLE t_black_smelly_water_standard ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_drinking_water_standard  ADD unique(id);
ALTER TABLE t_drinking_water_standard DROP PRIMARY KEY;
ALTER TABLE t_drinking_water_standard ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;

ALTER TABLE t_factor_category  ADD unique(id);
ALTER TABLE t_factor_category DROP PRIMARY KEY;
ALTER TABLE t_factor_category ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_factor_index  ADD unique(id);
ALTER TABLE t_factor_index DROP PRIMARY KEY;
ALTER TABLE t_factor_index ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;



ALTER TABLE t_ground_water_quality_category  ADD unique(id);
ALTER TABLE t_ground_water_quality_category DROP PRIMARY KEY;
ALTER TABLE t_ground_water_quality_category ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_ground_water_quality_grade  ADD unique(id);
ALTER TABLE t_ground_water_quality_grade DROP PRIMARY KEY;
ALTER TABLE t_ground_water_quality_grade ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_ground_water_standard  ADD unique(id);
ALTER TABLE t_ground_water_standard DROP PRIMARY KEY;
ALTER TABLE t_ground_water_standard ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;

ALTER TABLE t_industry_category  ADD unique(id);
ALTER TABLE t_industry_category DROP PRIMARY KEY;
ALTER TABLE t_industry_category ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;




ALTER TABLE t_measure_unit  ADD unique(id);
ALTER TABLE t_measure_unit DROP PRIMARY KEY;
ALTER TABLE t_measure_unit ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_sea_water_quality_category  ADD unique(id);
ALTER TABLE t_sea_water_quality_category DROP PRIMARY KEY;
ALTER TABLE t_sea_water_quality_category ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_sea_water_quality_grade  ADD unique(id);
ALTER TABLE t_sea_water_quality_grade DROP PRIMARY KEY;
ALTER TABLE t_sea_water_quality_grade ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_sea_water_standard  ADD unique(id);
ALTER TABLE t_sea_water_standard DROP PRIMARY KEY;
ALTER TABLE t_sea_water_standard ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_surface_water_quality_grade  ADD unique(id);
ALTER TABLE t_surface_water_quality_grade DROP PRIMARY KEY;
ALTER TABLE t_surface_water_quality_grade ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_surface_water_standard  ADD unique(id);
ALTER TABLE t_surface_water_standard DROP PRIMARY KEY;
ALTER TABLE t_surface_water_standard ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;


ALTER TABLE t_unit_type  ADD unique(id);
ALTER TABLE t_unit_type DROP PRIMARY KEY;
ALTER TABLE t_unit_type ADD bmp_id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;
