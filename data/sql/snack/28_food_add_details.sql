CREATE PROCEDURE Food_Add_Details (
OUT v_OutFoodId LONGVARCHAR,
IN v_FoodNom LONGVARCHAR,
IN v_Weight DOUBLE,
IN v_CompleteProtein DOUBLE,
IN v_IncompleteProtein DOUBLE,
IN v_DigestibleCarbs DOUBLE,
IN v_Cost DOUBLE,
IN v_Protein DOUBLE,
IN v_Fat DOUBLE,
IN v_CarbsByDiff DOUBLE,
IN v_Energy DOUBLE,
IN v_Sucrose DOUBLE,
IN v_Fructose DOUBLE,
IN v_Lactose DOUBLE,
IN v_Alcohol DOUBLE,
IN v_Water DOUBLE,
IN v_Fiber DOUBLE,
IN v_Calcium DOUBLE,
IN v_Iron DOUBLE,
IN v_Magnesium DOUBLE,
IN v_Phosphorus DOUBLE,
IN v_Potassium DOUBLE,
IN v_Sodium DOUBLE,
IN v_Zinc DOUBLE,
IN v_Copper DOUBLE,
IN v_Fluoride DOUBLE,
IN v_Manganese DOUBLE,
IN v_Selenium DOUBLE,
IN v_VitaminA DOUBLE,
IN v_VitaminE DOUBLE,
IN v_VitaminD DOUBLE,
IN v_VitaminC DOUBLE,
IN v_Thiamin DOUBLE,
IN v_Riboflavin DOUBLE,
IN v_Niacin DOUBLE,
IN v_Pantothenic DOUBLE,
IN v_VitaminB6 DOUBLE,
IN v_VitaminB12 DOUBLE,
IN v_Choline DOUBLE,
IN v_VitaminK DOUBLE,
IN v_Folate DOUBLE,
IN v_Cholesterol DOUBLE,
IN v_Saturated DOUBLE,
IN v_DHA DOUBLE,
IN v_EPA DOUBLE,
IN v_Monounsaturated DOUBLE,
IN v_Polyunsaturated DOUBLE,
IN v_Linoleic DOUBLE,
IN v_AlphaLinolenic DOUBLE
)
--
modifies sql data BEGIN atomic
--
DECLARE v_FoodId LONGVARCHAR;
--
SET v_FoodId = generateId('f','');
SET v_OutFoodId = v_FoodId;
--
call Food_Insert(v_FoodId,v_FoodNom);
--
call FoodFact_Insert(v_FoodId,'10000',v_Weight);
call FoodFact_Insert(v_FoodId,'10001',v_CompleteProtein);
call FoodFact_Insert(v_FoodId,'10002',v_IncompleteProtein);
call FoodFact_Insert(v_FoodId,'10003',v_DigestibleCarbs);
call FoodFact_Insert(v_FoodId,'10005',v_Cost);
call FoodFact_Insert(v_FoodId,'203',v_Protein);
call FoodFact_Insert(v_FoodId,'204',v_Fat);
call FoodFact_Insert(v_FoodId,'205',v_CarbsByDiff);
call FoodFact_Insert(v_FoodId,'208',v_Energy);
call FoodFact_Insert(v_FoodId,'210',v_Sucrose);
call FoodFact_Insert(v_FoodId,'212',v_Fructose);
call FoodFact_Insert(v_FoodId,'213',v_Lactose);
call FoodFact_Insert(v_FoodId,'221',v_Alcohol);
call FoodFact_Insert(v_FoodId,'255',v_Water);
call FoodFact_Insert(v_FoodId,'291',v_Fiber);
call FoodFact_Insert(v_FoodId,'301',v_Calcium);
call FoodFact_Insert(v_FoodId,'303',v_Iron);
call FoodFact_Insert(v_FoodId,'304',v_Magnesium);
call FoodFact_Insert(v_FoodId,'305',v_Phosphorus);
call FoodFact_Insert(v_FoodId,'306',v_Potassium);
call FoodFact_Insert(v_FoodId,'307',v_Sodium);
call FoodFact_Insert(v_FoodId,'309',v_Zinc);
call FoodFact_Insert(v_FoodId,'312',v_Copper);
call FoodFact_Insert(v_FoodId,'313',v_Fluoride);
call FoodFact_Insert(v_FoodId,'315',v_Manganese);
call FoodFact_Insert(v_FoodId,'317',v_Selenium);
call FoodFact_Insert(v_FoodId,'320',v_VitaminA);
call FoodFact_Insert(v_FoodId,'323',v_VitaminE);
call FoodFact_Insert(v_FoodId,'328',v_VitaminD);
call FoodFact_Insert(v_FoodId,'401',v_VitaminC);
call FoodFact_Insert(v_FoodId,'404',v_Thiamin);
call FoodFact_Insert(v_FoodId,'405',v_Riboflavin);
call FoodFact_Insert(v_FoodId,'406',v_Niacin);
call FoodFact_Insert(v_FoodId,'410',v_Pantothenic);
call FoodFact_Insert(v_FoodId,'415',v_VitaminB6);
call FoodFact_Insert(v_FoodId,'418',v_VitaminB12);
call FoodFact_Insert(v_FoodId,'421',v_Choline);
call FoodFact_Insert(v_FoodId,'430',v_VitaminK);
call FoodFact_Insert(v_FoodId,'435',v_Folate);
call FoodFact_Insert(v_FoodId,'601',v_Cholesterol);
call FoodFact_Insert(v_FoodId,'606',v_Saturated);
call FoodFact_Insert(v_FoodId,'621',v_DHA);
call FoodFact_Insert(v_FoodId,'629',v_EPA);
call FoodFact_Insert(v_FoodId,'645',v_Monounsaturated);
call FoodFact_Insert(v_FoodId,'646',v_Polyunsaturated);
call FoodFact_Insert(v_FoodId,'675',v_Linoleic);
call FoodFact_Insert(v_FoodId,'851',v_AlphaLinolenic);
--
END;
/