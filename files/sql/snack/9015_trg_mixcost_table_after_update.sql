CREATE TRIGGER MixCost_rlau_trigger
AFTER UPDATE ON Mix
REFERENCING NEW AS new
FOR EACH ROW
WHEN (new.MixCost > 0.0)
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.DnMixResult_delete(new.mixid);
CALL public.fill_DnMixResult(new.mixid);
--
END;
/
