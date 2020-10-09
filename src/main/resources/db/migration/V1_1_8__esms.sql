/**修改行业类别描述字段长度**/
alter table t_industry_category modify column description varchar(350) comment '描述信息';