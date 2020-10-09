-- 修改大气因子
-- 删除HNO₃离子、HNO₂离子、SO₂离子、NH₃离子
delete from t_factor_index where code = 'a99772';
delete from t_factor_index where code = 'a99773';
delete from t_factor_index where code = 'a99914';
delete from t_factor_index where code = 'a99915';
-- NO₃离子、F离子、气压编码修改
update t_factor_index set code = 'a06006' where code = 'a99916';
update t_factor_index set code = 'a06007' where code = 'a99775';
update t_factor_index set code = 'a01006' where code = 'a99701';