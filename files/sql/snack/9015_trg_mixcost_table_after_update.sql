CREATE TRIGGER Mix_rlau_trigger
AFTER UPDATE ON Mix
REFERENCING NEW AS new
FOR EACH ROW
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.DnMixResult_delete(new.mixid);
CALL public.fill_DnMixResult(new.mixid);
CALL public.adjustExpectedWeight(new.mixid);
--
END;
/
