CREATE PROCEDURE Food_Put (
--
IN v_MixId INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodName VARCHAR(8000);
--
SELECT Name INTO v_FoodName FROM Mix WHERE MixId = v_MixId;
--
CALL Food_Add_Details (
--food name
v_FoodName,
--serving_size
getMixResultSumValue (v_MixId,'10000'),
--calories
getMixResultSumValue (v_MixId,'208'),
--protein
getMixResultSumValue (v_MixId,'203'),
--fat
getMixResultSumValue (v_MixId,'204'),
--carbohydrates
getMixResultSumValue (v_MixId,'10003'),
--fiber
getMixResultSumValue (v_MixId,'291'),
--saturated fat
getMixResultSumValue (v_MixId,'606'),
--monounsaturated fat
getMixResultSumValue (v_MixId,'645'),
--polyunsaturated fat
getMixResultSumValue (v_MixId,'646'),
--cholesterol
getMixResultSumValue (v_MixId,'601'),
--sodium
getMixResultSumValue (v_MixId,'307'),
--potassium
getMixResultSumValue (v_MixId,'306'),
--calcium
getMixResultSumValue (v_MixId,'301'),
--magnesium
getMixResultSumValue (v_MixId,'304'),
--cost
getMixResultSumValue (v_MixId,'10005'),
--complete protein
getMixResultSumValue (v_MixId,'10001'),
--incomplete protein
getMixResultSumValue (v_MixId,'10002'),
--alcohol
getMixResultSumValue (v_MixId,'221')
);
--
END;
/