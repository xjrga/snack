CREATE PROCEDURE pin_mix (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA  BEGIN ATOMIC
--
DELETE FROM NUTRIENTCONSTRAINT WHERE MixId = v_mixid;
DELETE FROM FOODNUTRIENTCONSTRAINT WHERE MixId = v_mixid;
DELETE FROM FOODNUTRIENTRATIO WHERE MixId = v_mixid;
DELETE FROM NUTRIENTRATIO WHERE MixId = v_mixid;
INSERT INTO FOODNUTRIENTCONSTRAINT
SELECT mixid,foodid,'10000' as nutrientid,3 as relationshipid,x as b
FROM mixfood
WHERE mixid = v_mixid;

--
END;
/
