CREATE PROCEDURE fill_mixresult(
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
FOR SELECT mixid,foodid FROM mixfood WHERE mixid = v_MixId DO
FOR SELECT nutrientid FROM nutrient DO
CALL MixResult_Merge (mixid,foodid,nutrientid,getMixResultValue(mixid,foodid,nutrientid));
END FOR;
END FOR;
--
END;
/
