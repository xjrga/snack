CREATE TRIGGER MixCost_rlai_trigger AFTER INSERT ON MixCost REFERENCING NEW AS new FOR EACH ROW
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.mixresultdn_delete(new.mixid);
CALL public.fill_mixresultdn(new.mixid);
CALL public.save_zff (new.mixid);
CALL public.save_zfc (new.mixid);
--
END;
/
