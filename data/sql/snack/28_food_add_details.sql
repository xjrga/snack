CREATE PROCEDURE Food_Add_Details (
--
IN v_foodnom VARCHAR(8000),
--
IN v_serving_size DOUBLE,
--
IN v_calories DOUBLE,
--
IN v_protein DOUBLE,
--
IN v_fat DOUBLE,
--
IN v_carbohydrates DOUBLE,
--
IN v_fiber DOUBLE,
--
IN v_saturated_fat DOUBLE,
--
IN v_monounsaturated_fat DOUBLE,
--
IN v_polyunsaturated_fat DOUBLE,
--
IN v_cholesterol DOUBLE,
--
IN v_sodium DOUBLE,
--
IN v_potassium DOUBLE,
--
IN v_calcium DOUBLE,
--
IN v_magnesium DOUBLE,
--
IN v_cost DOUBLE,
--
IN v_complete_protein DOUBLE,
--
IN v_incomplete_protein DOUBLE,
--
IN v_alcohol DOUBLE
--
)
--
modifies sql data BEGIN atomic
--
DECLARE v_FoodId VARCHAR(8000);
--
SET v_FoodId = generateId('f','');
--
call Food_Insert (v_FoodId,v_foodnom,v_serving_size);
--
call FoodFact_Insert(v_FoodId,'10000',v_serving_size);
--
call FoodFact_Insert(v_FoodId,'208',v_calories);
--
call FoodFact_Insert(v_FoodId,'203',v_protein);
--
call FoodFact_Insert(v_FoodId,'204',v_fat);
--
call FoodFact_Insert(v_FoodId,'10003',v_carbohydrates);
--
call FoodFact_Insert(v_FoodId,'291',v_fiber);
--
call FoodFact_Insert(v_FoodId,'606',v_saturated_fat);
--
call FoodFact_Insert(v_FoodId,'645',v_monounsaturated_fat);
--
call FoodFact_Insert(v_FoodId,'646',v_polyunsaturated_fat);
--
call FoodFact_Insert(v_FoodId,'601',v_cholesterol);
--
call FoodFact_Insert(v_FoodId,'307',v_sodium);
--
call FoodFact_Insert(v_FoodId,'306',v_potassium);
--
call FoodFact_Insert(v_FoodId,'301',v_calcium);
--
call FoodFact_Insert(v_FoodId,'304',v_magnesium);
--
call FoodFact_Insert(v_FoodId,'10005',v_cost);
--
call FoodFact_Insert(v_FoodId,'10001',v_complete_protein);
--
call FoodFact_Insert(v_FoodId,'10002',v_incomplete_protein);
--
call FoodFact_Insert(v_FoodId,'221',v_alcohol);
--
END;
/