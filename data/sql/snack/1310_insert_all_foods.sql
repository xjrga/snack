CREATE PROCEDURE Insert_all_foods (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
FOR SELECT foodid FROM food  DO
--
CALL MixFood_Insert(v_Mixid, foodid);
--
END FOR;
--
END
/

