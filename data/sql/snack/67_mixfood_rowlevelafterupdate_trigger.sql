CREATE TRIGGER MixFood_RowLevelAfterUpdate_Trigger
AFTER UPDATE ON MixFood REFERENCING NEW ROW AS row OLD as oldrow
FOR EACH ROW
BEGIN ATOMIC
--
CALL MixResultDW_Merge(row.mixid,row.foodid);
--
END;
/
