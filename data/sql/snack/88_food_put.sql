CREATE PROCEDURE Food_Put (
--
IN v_MixId INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodId LONGVARCHAR;
DECLARE v_FoodName LONGVARCHAR;
--
SELECT Name INTO v_FoodName FROM Mix WHERE MixId = v_MixId;
--
CALL Food_Add_Details (
v_FoodId,
v_FoodName,
getMixResultSumValue(v_MixId,'10000'),
getMixResultSumValue(v_MixId,'10001'),
getMixResultSumValue(v_MixId,'10002'),
getMixResultSumValue(v_MixId,'10003'),
getMixResultSumValue(v_MixId,'10005'),
getMixResultSumValue(v_MixId,'203'),
getMixResultSumValue(v_MixId,'204'),
getMixResultSumValue(v_MixId,'205'),
getMixResultSumValue(v_MixId,'208'),
getMixResultSumValue(v_MixId,'210'),
getMixResultSumValue(v_MixId,'212'),
getMixResultSumValue(v_MixId,'213'),
getMixResultSumValue(v_MixId,'221'),
getMixResultSumValue(v_MixId,'255'),
getMixResultSumValue(v_MixId,'291'),
getMixResultSumValue(v_MixId,'301'),
getMixResultSumValue(v_MixId,'303'),
getMixResultSumValue(v_MixId,'304'),
getMixResultSumValue(v_MixId,'305'),
getMixResultSumValue(v_MixId,'306'),
getMixResultSumValue(v_MixId,'307'),
getMixResultSumValue(v_MixId,'309'),
getMixResultSumValue(v_MixId,'312'),
getMixResultSumValue(v_MixId,'313'),
getMixResultSumValue(v_MixId,'315'),
getMixResultSumValue(v_MixId,'317'),
getMixResultSumValue(v_MixId,'320'),
getMixResultSumValue(v_MixId,'323'),
getMixResultSumValue(v_MixId,'328'),
getMixResultSumValue(v_MixId,'401'),
getMixResultSumValue(v_MixId,'404'),
getMixResultSumValue(v_MixId,'405'),
getMixResultSumValue(v_MixId,'406'),
getMixResultSumValue(v_MixId,'410'),
getMixResultSumValue(v_MixId,'415'),
getMixResultSumValue(v_MixId,'418'),
getMixResultSumValue(v_MixId,'421'),
getMixResultSumValue(v_MixId,'430'),
getMixResultSumValue(v_MixId,'435'),
getMixResultSumValue(v_MixId,'601'),
getMixResultSumValue(v_MixId,'606'),
getMixResultSumValue(v_MixId,'621'),
getMixResultSumValue(v_MixId,'629'),
getMixResultSumValue(v_MixId,'645'),
getMixResultSumValue(v_MixId,'646'),
getMixResultSumValue(v_MixId,'675'),
getMixResultSumValue(v_MixId,'851')
);
CALL CategoryLink_Insert(v_FoodId,'5000');
--
END;
/