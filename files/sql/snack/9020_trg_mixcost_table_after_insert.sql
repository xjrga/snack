CREATE TRIGGER MixCost_rlai_trigger
AFTER INSERT ON Mix
REFERENCING NEW AS new
FOR EACH ROW
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.DnMixResult_delete(new.mixid);
CALL public.fill_DnMixResult(new.mixid);
--
END;
/
