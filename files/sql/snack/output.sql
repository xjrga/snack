DROP SCHEMA PUBLIC CASCADE;
/

CREATE TABLE CategoryLink
(
        FoodCategoryId LONGVARCHAR,
        FoodId LONGVARCHAR,
        CONSTRAINT CategoryLink_primary_key PRIMARY KEY (
        FoodCategoryId,
        FoodId
        )
);
/
CREATE TABLE DnFoodFact
(
        food_id LONGVARCHAR,
        food_name LONGVARCHAR,
        carbohydrates_carbs_by_diff DECIMAL(25,18),
        carbohydrates_fiber_insoluble DECIMAL(25,18),
        carbohydrates_fiber_soluble DECIMAL(25,18),
        carbohydrates_fiber DECIMAL(25,18),
        carbohydrates_fructose DECIMAL(25,18),
        carbohydrates_glucose DECIMAL(25,18),
        carbohydrates_glycemic_load DECIMAL(25,18),
        carbohydrates_lactose DECIMAL(25,18),
        carbohydrates_starch DECIMAL(25,18),
        carbohydrates_sucrose DECIMAL(25,18),
        carbohydrates_sugars DECIMAL(25,18),
        energy_gross DECIMAL(25,18),
        fats_cholesterol DECIMAL(25,18),
        fats_dha DECIMAL(25,18),
        fats_epa DECIMAL(25,18),
        fats_lauric DECIMAL(25,18),
        fats_linoleic DECIMAL(25,18),
        fats_linolenic DECIMAL(25,18),
        fats_monounsaturated DECIMAL(25,18),
        fats_myristic DECIMAL(25,18),
        fats_palmitic DECIMAL(25,18),
        fats_polyunsaturated DECIMAL(25,18),
        fats_saturated DECIMAL(25,18),
        fats_stearic DECIMAL(25,18),
        fats_total DECIMAL(25,18),
        minerals_calcium DECIMAL(25,18),
        minerals_copper DECIMAL(25,18),
        minerals_iron DECIMAL(25,18),
        minerals_magnesium DECIMAL(25,18),
        minerals_manganese DECIMAL(25,18),
        minerals_phosphorus DECIMAL(25,18),
        minerals_potassium DECIMAL(25,18),
        minerals_selenium DECIMAL(25,18),
        minerals_sodium DECIMAL(25,18),
        minerals_zinc DECIMAL(25,18),
        other_alcohol DECIMAL(25,18),
        other_cost DECIMAL(25,18),
        other_water DECIMAL(25,18),
        other_weight DECIMAL(25,18),
        phytonutrients_anthocyanins DECIMAL(25,18),
        phytonutrients_caffeine DECIMAL(25,18),
        phytonutrients_beta_carotene DECIMAL(25,18),
        phytonutrients_carotenoids DECIMAL(25,18),
        phytonutrients_flavanols DECIMAL(25,18),
        phytonutrients_flavanones DECIMAL(25,18),
        phytonutrients_flavones DECIMAL(25,18),
        phytonutrients_flavonoids DECIMAL(25,18),
        phytonutrients_flavonols DECIMAL(25,18),
        phytonutrients_isoflavones DECIMAL(25,18),
        phytonutrients_lutein_zeaxanthin DECIMAL(25,18),
        phytonutrients_lycopene DECIMAL(25,18),
        phytonutrients_phytosterols DECIMAL(25,18),
        phytonutrients_theobromine DECIMAL(25,18),
        phytonutrients_gamma_tocopherol DECIMAL(25,18),
        protein_complete DECIMAL(25,18),
        protein_total DECIMAL(25,18),
        vitamins_vitamin_a DECIMAL(25,18),
        vitamins_vitamin_b12 DECIMAL(25,18),
        vitamins_vitamin_b6 DECIMAL(25,18),
        vitamins_vitamin_c DECIMAL(25,18),
        vitamins_choline DECIMAL(25,18),
        vitamins_vitamin_d DECIMAL(25,18),
        vitamins_vitamin_e DECIMAL(25,18),
        vitamins_folate DECIMAL(25,18),
        vitamins_vitamin_k DECIMAL(25,18),
        vitamins_niacin DECIMAL(25,18),
        vitamins_pantothenic_acid DECIMAL(25,18),
        vitamins_riboflavin DECIMAL(25,18),
        vitamins_thiamin DECIMAL(25,18),
        carbohydrates_digestible DECIMAL(25,18),
        energy_carbohydrate DECIMAL(25,18),
        energy_fat DECIMAL(25,18),
        energy_fat_and_carbohydrate DECIMAL(25,18),
        energy_protein DECIMAL(25,18),
        energy_alcohol DECIMAL(25,18),
        energy_digestible DECIMAL(25,18),
        fats_hcsfa DECIMAL(25,18),
        fats_lcn3pufa DECIMAL(25,18),
        CONSTRAINT DnFoodFact_primary_key PRIMARY KEY (
        food_id
        )
);
/
CREATE TABLE DnMixResult
(
        mix_id LONGVARCHAR,
        food_id LONGVARCHAR,
        food_name LONGVARCHAR,
        carbohydrates_carbs_by_diff DECIMAL(25,18),
        carbohydrates_fiber_insoluble DECIMAL(25,18),
        carbohydrates_fiber_soluble DECIMAL(25,18),
        carbohydrates_fiber DECIMAL(25,18),
        carbohydrates_fructose DECIMAL(25,18),
        carbohydrates_glucose DECIMAL(25,18),
        carbohydrates_glycemic_load DECIMAL(25,18),
        carbohydrates_lactose DECIMAL(25,18),
        carbohydrates_starch DECIMAL(25,18),
        carbohydrates_sucrose DECIMAL(25,18),
        carbohydrates_sugars DECIMAL(25,18),
        energy_gross DECIMAL(25,18),
        fats_cholesterol DECIMAL(25,18),
        fats_dha DECIMAL(25,18),
        fats_epa DECIMAL(25,18),
        fats_lauric DECIMAL(25,18),
        fats_linoleic DECIMAL(25,18),
        fats_linolenic DECIMAL(25,18),
        fats_monounsaturated DECIMAL(25,18),
        fats_myristic DECIMAL(25,18),
        fats_palmitic DECIMAL(25,18),
        fats_polyunsaturated DECIMAL(25,18),
        fats_saturated DECIMAL(25,18),
        fats_stearic DECIMAL(25,18),
        fats_total DECIMAL(25,18),
        minerals_calcium DECIMAL(25,18),
        minerals_copper DECIMAL(25,18),
        minerals_iron DECIMAL(25,18),
        minerals_magnesium DECIMAL(25,18),
        minerals_manganese DECIMAL(25,18),
        minerals_phosphorus DECIMAL(25,18),
        minerals_potassium DECIMAL(25,18),
        minerals_selenium DECIMAL(25,18),
        minerals_sodium DECIMAL(25,18),
        minerals_zinc DECIMAL(25,18),
        other_alcohol DECIMAL(25,18),
        other_cost DECIMAL(25,18),
        other_water DECIMAL(25,18),
        other_weight DECIMAL(25,18),
        phytonutrients_anthocyanins DECIMAL(25,18),
        phytonutrients_caffeine DECIMAL(25,18),
        phytonutrients_beta_carotene DECIMAL(25,18),
        phytonutrients_carotenoids DECIMAL(25,18),
        phytonutrients_flavanols DECIMAL(25,18),
        phytonutrients_flavanones DECIMAL(25,18),
        phytonutrients_flavones DECIMAL(25,18),
        phytonutrients_flavonoids DECIMAL(25,18),
        phytonutrients_flavonols DECIMAL(25,18),
        phytonutrients_isoflavones DECIMAL(25,18),
        phytonutrients_lutein_zeaxanthin DECIMAL(25,18),
        phytonutrients_lycopene DECIMAL(25,18),
        phytonutrients_phytosterols DECIMAL(25,18),
        phytonutrients_theobromine DECIMAL(25,18),
        phytonutrients_gamma_tocopherol DECIMAL(25,18),
        protein_complete DECIMAL(25,18),
        protein_total DECIMAL(25,18),
        vitamins_vitamin_a DECIMAL(25,18),
        vitamins_vitamin_b12 DECIMAL(25,18),
        vitamins_vitamin_b6 DECIMAL(25,18),
        vitamins_vitamin_c DECIMAL(25,18),
        vitamins_choline DECIMAL(25,18),
        vitamins_vitamin_d DECIMAL(25,18),
        vitamins_vitamin_e DECIMAL(25,18),
        vitamins_folate DECIMAL(25,18),
        vitamins_vitamin_k DECIMAL(25,18),
        vitamins_niacin DECIMAL(25,18),
        vitamins_pantothenic_acid DECIMAL(25,18),
        vitamins_riboflavin DECIMAL(25,18),
        vitamins_thiamin DECIMAL(25,18),
        carbohydrates_digestible DECIMAL(25,18),
        energy_carbohydrate DECIMAL(25,18),
        energy_fat DECIMAL(25,18),
        energy_fat_and_carbohydrate DECIMAL(25,18),
        energy_protein DECIMAL(25,18),
        energy_alcohol DECIMAL(25,18),
        energy_digestible DECIMAL(25,18),
        fats_hcsfa DECIMAL(25,18),
        fats_lcn3pufa DECIMAL(25,18),
        CONSTRAINT DnMixResult_primary_key PRIMARY KEY (
        mix_id,
        food_id
        )
);
/
CREATE TABLE Food
(
        FoodId LONGVARCHAR,
        Name LONGVARCHAR,
        CONSTRAINT Food_primary_key PRIMARY KEY (
        FoodId
        )
);
/
CREATE TABLE FoodCategory
(
        FoodCategoryId LONGVARCHAR,
        Name LONGVARCHAR,
        CONSTRAINT FoodCategory_primary_key PRIMARY KEY (
        FoodCategoryId
        )
);
/
CREATE TABLE FoodFact
(
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        q DECIMAL(25,18),
        CONSTRAINT FoodFact_primary_key PRIMARY KEY (
        FoodId,
        NutrientId
        )
);
/
CREATE TABLE FoodFactCoefficient
(
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        c DECIMAL(25,18),
        CONSTRAINT FoodFactCoefficient_primary_key PRIMARY KEY (
        FoodId,
        NutrientId
        )
);
/
CREATE TABLE FoodGroupList
(
        GroupId INTEGER,
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        CONSTRAINT FoodGroupList_primary_key PRIMARY KEY (
        GroupId,
        MixId,
        FoodId
        )
);
/
CREATE TABLE FoodGroupQuantityC
(
        MixId LONGVARCHAR,
        GroupId INTEGER,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DECIMAL(25,18),
        CONSTRAINT FoodGroupQuantityC_primary_key PRIMARY KEY (
        MixId,
        GroupId,
        NutrientId,
        RelationshipId
        )
);
/
CREATE TABLE FoodGroupRatioC
(
        MixId LONGVARCHAR,
        Group_Id_1 INTEGER,
        Nutrient_Id_1 LONGVARCHAR,
        Group_Id_2 INTEGER,
        Nutrient_Id_2 LONGVARCHAR,
        RelationshipId INTEGER,
        A DECIMAL(25,18),
        B DECIMAL(25,18),
        CONSTRAINT FoodGroupRatioC_primary_key PRIMARY KEY (
        MixId,
        Group_Id_1,
        Nutrient_Id_1,
        Group_Id_2,
        Nutrient_Id_2,
        RelationshipId
        )
);
/
CREATE TABLE FoodQuantityC
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DECIMAL(25,18),
        CONSTRAINT FoodQuantityC_primary_key PRIMARY KEY (
        MixId,
        FoodId,
        NutrientId,
        RelationshipId
        )
);
/
CREATE TABLE FoodRatioC
(
        MixId LONGVARCHAR,
        Food_Id_1 LONGVARCHAR,
        Nutrient_Id_1 LONGVARCHAR,
        Food_Id_2 LONGVARCHAR,
        Nutrient_Id_2 LONGVARCHAR,
        RelationshipId INTEGER,
        A DECIMAL(25,18),
        B DECIMAL(25,18),
        CONSTRAINT FoodRatioC_primary_key PRIMARY KEY (
        MixId,
        Food_Id_1,
        Nutrient_Id_1,
        Food_Id_2,
        Nutrient_Id_2,
        RelationshipId
        )
);
/
CREATE TABLE Meal
(
        MixId LONGVARCHAR,
        MealId IDENTITY,
        Name LONGVARCHAR,
        MealOrder INTEGER,
        CONSTRAINT Meal_primary_key PRIMARY KEY (
        MixId,
        MealId
        )
);
/
CREATE TABLE MealFoodPortion
(
        MixId LONGVARCHAR,
        MealId INTEGER,
        FoodId LONGVARCHAR,
        Pct DECIMAL(25,18),
        ExpectedWt DECIMAL(25,18),
        ActualWt DECIMAL(25,18),
        CONSTRAINT MealFoodPortion_primary_key PRIMARY KEY (
        MixId,
        MealId,
        FoodId
        )
);
/
CREATE TABLE Mix
(
        MixId LONGVARCHAR,
        Name LONGVARCHAR,
        LifeStageId INTEGER,
        Model LONGVARCHAR,
        MixCost DECIMAL(25,18),
        MixDeficiency DECIMAL(25,18),
        MixExcess DECIMAL(25,18),
        CONSTRAINT Mix_primary_key PRIMARY KEY (
        MixId
        )
);
/
CREATE TABLE MixFood
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        x DECIMAL(25,18),
        CONSTRAINT MixFood_primary_key PRIMARY KEY (
        MixId,
        FoodId
        )
);
/
CREATE TABLE MixFoodGroup
(
        MixId LONGVARCHAR,
        GroupId INTEGER,
        Name LONGVARCHAR,
        CONSTRAINT MixFoodGroup_primary_key PRIMARY KEY (
        MixId,
        GroupId
        )
);
/
CREATE TABLE MixInventory
(
        MixId LONGVARCHAR,
        Days DECIMAL(25,18),
        CONSTRAINT MixInventory_primary_key PRIMARY KEY (
        MixId
        )
);
/
CREATE TABLE MixResult
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        q DECIMAL(25,18),
        CONSTRAINT MixResult_primary_key PRIMARY KEY (
        MixId,
        FoodId,
        NutrientId
        )
);
/
CREATE TABLE Nutrient
(
        NutrientId LONGVARCHAR,
        Name LONGVARCHAR,
        Visible INTEGER DEFAULT 1,
        NutrientCategoryId LONGVARCHAR,
        Label LONGVARCHAR,
        Units LONGVARCHAR,
        Dri INTEGER,
        CONSTRAINT Nutrient_primary_key PRIMARY KEY (
        NutrientId
        )
);
/
CREATE TABLE NutrientCategory
(
        NutrientCategoryId LONGVARCHAR,
        Name LONGVARCHAR,
        CONSTRAINT NutrientCategory_primary_key PRIMARY KEY (
        NutrientCategoryId
        )
);
/
CREATE TABLE NutrientQuantityC
(
        MixId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DECIMAL(25,18),
        CONSTRAINT NutrientQuantityC_primary_key PRIMARY KEY (
        MixId,
        NutrientId,
        RelationshipId
        )
);
/
CREATE TABLE NutrientRatioC
(
        MixId LONGVARCHAR,
        Nutrient_Id_1 LONGVARCHAR,
        Nutrient_Id_2 LONGVARCHAR,
        RelationshipId INTEGER,
        A DECIMAL(25,18),
        B DECIMAL(25,18),
        CONSTRAINT NutrientRatioC_primary_key PRIMARY KEY (
        MixId,
        Nutrient_Id_1,
        Nutrient_Id_2,
        RelationshipId
        )
);
/
CREATE TABLE Rda
(
        NutrientId LONGVARCHAR,
        LifeStageId INTEGER,
        q DECIMAL(25,18) DEFAULT 0.0,
        UL DECIMAL(25,18) DEFAULT 0.0,
        CONSTRAINT Rda_primary_key PRIMARY KEY (
        NutrientId,
        LifeStageId
        )
);
/
CREATE TABLE RdaLifeStage
(
        LifeStageId INTEGER,
        Label LONGVARCHAR,
        CONSTRAINT RdaLifeStage_primary_key PRIMARY KEY (
        LifeStageId
        )
);
/
CREATE TABLE Relationship
(
        RelationshipId IDENTITY,
        Name LONGVARCHAR,
        CONSTRAINT Relationship_primary_key PRIMARY KEY (
        RelationshipId
        )
);
/
CREATE TABLE Units
(
        UnitId INTEGER,
        Name LONGVARCHAR,
        Factor DECIMAL(25,18),
        CONSTRAINT Units_primary_key PRIMARY KEY (
        UnitId
        )
);
/
ALTER TABLE CategoryLink ADD CONSTRAINT R0_CategoryLink FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE CategoryLink ADD CONSTRAINT R1_CategoryLink FOREIGN KEY (FoodCategoryId) REFERENCES FoodCategory (FoodCategoryId) ON DELETE CASCADE;
/
ALTER TABLE DnFoodFact ADD CONSTRAINT R2_DnFoodFact FOREIGN KEY (food_id) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE DnMixResult ADD CONSTRAINT R3_DnMixResult FOREIGN KEY (food_id,mix_id) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R4_FoodFact FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R5_FoodFact FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodFactCoefficient ADD CONSTRAINT R6_FoodFactCoefficient FOREIGN KEY (FoodId,NutrientId) REFERENCES FoodFact (FoodId,NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupList ADD CONSTRAINT R7_FoodGroupList FOREIGN KEY (FoodId,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupList ADD CONSTRAINT R8_FoodGroupList FOREIGN KEY (GroupId,MixId) REFERENCES MixFoodGroup (GroupId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupQuantityC ADD CONSTRAINT R9_FoodGroupQuantityC FOREIGN KEY (GroupId,MixId) REFERENCES MixFoodGroup (GroupId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupQuantityC ADD CONSTRAINT R10_FoodGroupQuantityC FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupQuantityC ADD CONSTRAINT R11_FoodGroupQuantityC FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupRatioC ADD CONSTRAINT R12_FoodGroupRatioC FOREIGN KEY (Group_Id_2,MixId) REFERENCES MixFoodGroup (GroupId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupRatioC ADD CONSTRAINT R13_FoodGroupRatioC FOREIGN KEY (Group_Id_1,MixId) REFERENCES MixFoodGroup (GroupId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupRatioC ADD CONSTRAINT R14_FoodGroupRatioC FOREIGN KEY (Nutrient_Id_1) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupRatioC ADD CONSTRAINT R15_FoodGroupRatioC FOREIGN KEY (Nutrient_Id_2) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodGroupRatioC ADD CONSTRAINT R16_FoodGroupRatioC FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE FoodQuantityC ADD CONSTRAINT R17_FoodQuantityC FOREIGN KEY (FoodId,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodQuantityC ADD CONSTRAINT R18_FoodQuantityC FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodQuantityC ADD CONSTRAINT R19_FoodQuantityC FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE FoodRatioC ADD CONSTRAINT R20_FoodRatioC FOREIGN KEY (Food_Id_2,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodRatioC ADD CONSTRAINT R21_FoodRatioC FOREIGN KEY (Food_Id_1,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodRatioC ADD CONSTRAINT R22_FoodRatioC FOREIGN KEY (Nutrient_Id_2) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodRatioC ADD CONSTRAINT R23_FoodRatioC FOREIGN KEY (Nutrient_Id_1) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodRatioC ADD CONSTRAINT R24_FoodRatioC FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE Meal ADD CONSTRAINT R25_Meal FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MealFoodPortion ADD CONSTRAINT R26_MealFoodPortion FOREIGN KEY (MealId,MixId) REFERENCES Meal (MealId,MixId) ON DELETE CASCADE;
/
ALTER TABLE MealFoodPortion ADD CONSTRAINT R27_MealFoodPortion FOREIGN KEY (FoodId,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE Mix ADD CONSTRAINT R28_Mix FOREIGN KEY (LifeStageId) REFERENCES RdaLifeStage (LifeStageId) ON DELETE SET NULL;
/
ALTER TABLE MixFood ADD CONSTRAINT R29_MixFood FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R30_MixFood FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MixFoodGroup ADD CONSTRAINT R31_MixFoodGroup FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MixInventory ADD CONSTRAINT R32_MixInventory FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R33_MixResult FOREIGN KEY (FoodId,NutrientId) REFERENCES FoodFactCoefficient (FoodId,NutrientId) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R34_MixResult FOREIGN KEY (FoodId,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE Nutrient ADD CONSTRAINT R35_Nutrient FOREIGN KEY (NutrientCategoryId) REFERENCES NutrientCategory (NutrientCategoryId) ON DELETE SET NULL;
/
ALTER TABLE NutrientQuantityC ADD CONSTRAINT R36_NutrientQuantityC FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE NutrientQuantityC ADD CONSTRAINT R37_NutrientQuantityC FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientQuantityC ADD CONSTRAINT R38_NutrientQuantityC FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatioC ADD CONSTRAINT R39_NutrientRatioC FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatioC ADD CONSTRAINT R40_NutrientRatioC FOREIGN KEY (Nutrient_Id_1) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatioC ADD CONSTRAINT R41_NutrientRatioC FOREIGN KEY (Nutrient_Id_2) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatioC ADD CONSTRAINT R42_NutrientRatioC FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE Rda ADD CONSTRAINT R43_Rda FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE Rda ADD CONSTRAINT R44_Rda FOREIGN KEY (LifeStageId) REFERENCES RdaLifeStage (LifeStageId) ON DELETE CASCADE;
/


CREATE FUNCTION getFoodQuotient(
IN v_MixId LONGVARCHAR
) RETURNS DECIMAL(25, 18)
READS SQL DATA BEGIN ATOMIC
DECLARE fq DECIMAL(25, 18);
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       CASE WHEN SUM(energy_digestible) <= 0 OR SUM(energy_digestible) IS NULL THEN 0 ELSE SUM(energy_carbohydrate) /SUM(energy_digestible)*1.00 +SUM(energy_fat) /SUM(energy_digestible)*0.71 +SUM(energy_protein) /SUM(energy_digestible)*0.81 +SUM(energy_alcohol) /SUM(energy_digestible)*0.667 END into fq
FROM DnMixResult
WHERE mix_id = v_MixId;
RETURN fq;
END;
/


CREATE FUNCTION get_essential_fat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(25, 18);
--
SELECT CASEWHEN(sum(fats_linolenic) <= 0,0,sum(fats_linoleic)/sum(fats_linolenic)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/


CREATE FUNCTION get_electrolyte_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(25, 18);
--
SELECT CASEWHEN(sum(minerals_sodium) <= 0,0,sum(minerals_potassium)/sum(minerals_sodium)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/


CREATE FUNCTION get_polyufat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(25, 18);
--
SELECT CASEWHEN (SUM(fats_saturated) <= 0,0,SUM(fats_polyunsaturated) / SUM(fats_saturated)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/


CREATE FUNCTION get_monoufat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(25, 18);
--
SELECT CASEWHEN (SUM(fats_saturated) <= 0,0,SUM(fats_monounsaturated) / SUM(fats_saturated)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/


CREATE FUNCTION getGIFromGL (
--
IN v_FoodId LONGVARCHAR
--
)
--
RETURNS DOUBLE READS SQL DATA BEGIN ATOMIC
--
DECLARE v_gi DOUBLE;
--
SELECT CASE WHEN b.q <= 0 OR b.q IS NULL THEN 0 ELSE (a.q*100) / b.q END INTO v_gi
FROM (SELECT *
      FROM foodfact
      WHERE foodid = v_FoodId
      AND   nutrientid = '10006') a,
     (SELECT *
      FROM foodfact
      WHERE foodid = v_FoodId
      AND   nutrientid = '10003') b
WHERE a.foodid = b.foodid;
--
RETURN v_gi;
--
END;
/

CREATE FUNCTION getMealGI (IN v_MixId LONGVARCHAR) RETURNS DECIMAL(25, 18)
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE mealGI DECIMAL(25, 18);
--
SET mealGI = 0;
--
SELECT SUM(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END * getGIFromGL (food_id)) INTO mealGI
FROM (SELECT mix_id,
             food_id,
             other_weight,
             carbohydrates_digestible AS carbs,
             (SELECT SUM(carbohydrates_digestible)
              FROM DnMixResult
              WHERE mix_id = v_MixId) AS tcarbs,
             carbohydrates_glycemic_load AS gl
      FROM DnMixResult
      WHERE mix_id = v_MixId)
GROUP BY mix_id;
--
RETURN mealGI;
--
END;
/


CREATE FUNCTION generateLargeRandomNumber() RETURNS NUMERIC
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_count NUMERIC;
--
SELECT substring(replace(replace('' +replace('' + rand (),'-',''),'.',''),'E',''),0,11) INTO v_count FROM (VALUES (0));
--
RETURN v_count;
--
END;
/

CREATE FUNCTION CategoryLink_Count (
--
IN v_FoodCategoryId LONGVARCHAR,
--
IN v_FoodId LONGVARCHAR
--
) RETURNS INTEGER
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_count INTEGER;

--
SELECT COUNT(*) INTO v_count
FROM CategoryLink
WHERE FoodCategoryId = v_FoodCategoryId
AND   FoodId = v_FoodId;
--
RETURN v_count;

--
END;
/

CREATE FUNCTION countCategories (
--
IN v_FoodId LONGVARCHAR
--
) RETURNS INTEGER
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_count INTEGER;

--
SELECT COUNT(*) INTO v_count
FROM CategoryLink
WHERE FoodId = v_FoodId;
--
RETURN v_count;

--
END;
/

CREATE FUNCTION escape_xml_element_data (IN v_text LONGVARCHAR) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_clean LONGVARCHAR;
--
SET v_clean = REGEXP_REPLACE (v_text,'&','&amp;');
SET v_clean = REGEXP_REPLACE (v_clean,'<','&lt;');
SET v_clean = REGEXP_REPLACE (v_clean,'>','&gt;');
--
RETURN v_clean;

--
END;
/


CREATE FUNCTION calculate_remaining_percentage (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR
) RETURNS DECIMAL(25,18)

--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE v_c DECIMAL(25,18)
;
--
SELECT SUM(pct) INTO v_c FROM MealFoodPortion WHERE MixId = v_MixId AND FoodId = v_FoodId;
--
RETURN IFNULL(v_c,0.0) * 100;
--
END;
/


CREATE FUNCTION get_dri (
--
IN v_LifeStageId INTEGER,
--
IN v_NutrientId LONGVARCHAR
--
)
--
RETURNS DOUBLE READS SQL DATA BEGIN ATOMIC
--
DECLARE v_c DOUBLE;

--
SELECT q INTO v_c  FROM rda WHERE lifestageid = v_LifeStageId AND nutrientid = v_NutrientId;
--
RETURN v_c;

END;
/


CREATE FUNCTION generateId(
--
) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_id LONGVARCHAR;
--
SELECT generateLargeRandomNumber() INTO v_id FROM (VALUES(0));
--
RETURN v_id;
--
END;
/

CREATE FUNCTION getFoodCoefficient(IN v_FoodId LONGVARCHAR,IN v_NutrientId LONGVARCHAR ) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE v_c DECIMAL(25, 18)
;
SELECT CASE WHEN a.q > 0 THEN b.q / a.q ELSE 0 END INTO v_c
FROM (SELECT foodid,
             q
      FROM foodfact
      WHERE foodid = v_FoodId
      --Check Weight "serving size" is inserted before other nutrientids
      AND   nutrientid = '10000') a,
     foodfact b
WHERE a.foodid = b.foodid
AND   a.foodid = v_FoodId
AND   b.nutrientid = v_NutrientId;
RETURN v_c;
END;
/


CREATE FUNCTION getFoodName (IN v_FoodId LONGVARCHAR) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC 
--
DECLARE v_name LONGVARCHAR;
--
SELECT name INTO v_name
FROM food
WHERE foodid = v_FoodId;
--
RETURN v_name;
--
END;
/


CREATE FUNCTION getMixResultValue (
--
IN v_MixId LONGVARCHAR,
--
IN v_FoodId LONGVARCHAR,
--
IN v_NutrientId LONGVARCHAR
--
)
--
RETURNS DOUBLE READS SQL DATA BEGIN ATOMIC
--
DECLARE v_c DOUBLE;

--
SELECT a.x * b.c INTO v_c
FROM mixfood a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND a.mixid = v_MixId
AND a.foodid = v_FoodId
AND b.nutrientid = v_NutrientId;
--
RETURN v_c;

END;
/

CREATE FUNCTION get_foodfact (
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR
--

) RETURNS DECIMAL(25,18)
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_q DECIMAL(25,18);
--
SELECT q INTO v_q FROM FoodFact WHERE foodid = v_foodid AND nutrientid = v_nutrientid;
--
RETURN IFNULL(v_q,0);
--
END;
/


CREATE FUNCTION get_food_fq(
--
IN v_foodid LONGVARCHAR
--
) RETURNS DOUBLE
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE fq DOUBLE;
--
SET fq = 0;
--
IF get_foodfact(v_foodid,'10009') > 0 THEN
--
SELECT
--eCarbs
get_foodfact(v_foodid,'10011') / get_foodfact(v_foodid,'10009') * 1.00 +
--eFat
get_foodfact(v_foodid,'10013') / get_foodfact(v_foodid,'10009') * 0.71 +
--eProtein
get_foodfact(v_foodid,'10012') / get_foodfact(v_foodid,'10009') * 0.81 +
--eAlcohol
get_foodfact(v_foodid,'10014') / get_foodfact(v_foodid,'10009') * 0.667
--
INTO fq
--
FROM (VALUES(0));
--
END IF;
--
RETURN fq;
--
END;
/


CREATE FUNCTION getCategoryId (
--
IN v_foodid LONGVARCHAR
--
) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC 
--
DECLARE v_categoryid LONGVARCHAR;
--
SELECT a.foodcategoryid INTO v_categoryid
FROM foodcategory a,
     categorylink b
WHERE a.foodcategoryid = b.foodcategoryid
AND b.foodid = v_foodid;
--
RETURN v_categoryid;
--
END;
/

CREATE PROCEDURE get_food_statistics (
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
--eFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10013') / get_foodfact (v_foodid,'10009'))*100) AS efatpct,
--eCarbsPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10011') / get_foodfact (v_foodid,'10009'))*100) AS ecarbspct,
--eProteinPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10012') / get_foodfact (v_foodid,'10009'))*100) AS eproteinpct,
--eAlcoholPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10014') / get_foodfact (v_foodid,'10009'))*100) AS ealcoholpct,
--eSaturatedFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'606')*9 / get_foodfact (v_foodid,'10009'))*100) AS esfapct,
--ePolyunsaturatedFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'646')*9 / get_foodfact (v_foodid,'10009'))*100) AS epufapct,
--eMonounsaturatedFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'645')*9 / get_foodfact (v_foodid,'10009'))*100) AS emufapct,
--eLinoleicAcidPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'618')*9 / get_foodfact (v_foodid,'10009'))*100) AS elapct,
--eAlphaLinolenicAcidPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'619')*9 / get_foodfact (v_foodid,'10009'))*100) AS ealapct,
--pufa/sfa
CASEWHEN(get_foodfact (v_foodid,'606') <= 0,0,get_foodfact (v_foodid,'646') / get_foodfact (v_foodid,'606')) AS pufa_sfa,
--mufa/sfa
CASEWHEN(get_foodfact (v_foodid,'606') <= 0,0,get_foodfact (v_foodid,'645') / get_foodfact (v_foodid,'606')) AS mufa_sfa,
--la/ala
CASEWHEN(get_foodfact (v_foodid,'619') <= 0,0,get_foodfact (v_foodid,'618') / get_foodfact (v_foodid,'619')) AS la_ala,
--k/na
CASEWHEN(get_foodfact (v_foodid,'307') <= 0,0,get_foodfact (v_foodid,'306') / get_foodfact (v_foodid,'307')) AS k_na,
--fq
get_food_fq(v_foodid) AS fq
--
FROM (VALUES (0));
--
OPEN result;
--
END;
/


CREATE PROCEDURE Rda_Update_UL (
IN v_NutrientId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_ul DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Rda
SET
ul = v_ul
WHERE
NutrientId = v_NutrientId
AND
LifeStageId = v_LifeStageId;
END;
/


CREATE PROCEDURE CategoryLink_Insert (
IN v_FoodId LONGVARCHAR,
IN v_FoodCategoryId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO CategoryLink (
FoodCategoryId,
FoodId
) VALUES (
v_FoodCategoryId,
v_FoodId
);
END;
/

CREATE FUNCTION countFood(
--
IN v_FoodId LONGVARCHAR
--
) RETURNS INTEGER
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE v_count INTEGER;
--
SELECT COUNT(1) INTO v_count
FROM food
WHERE foodid = v_FoodId;
--
RETURN v_count;
--
END;
/


CREATE PROCEDURE FoodFact_Merge (
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_q DECIMAL(25,18)

)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO FoodFact USING ( VALUES (
v_FoodId,
v_NutrientId,
v_q
) ) ON (
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
)
WHEN MATCHED THEN UPDATE SET
q = v_q
WHEN NOT MATCHED THEN INSERT VALUES
v_FoodId,
v_NutrientId,
v_q;
END;
/


CREATE PROCEDURE FoodFact_insert (
--
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_q DECIMAL(25,18)

--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO FoodFact (
FoodId,
NutrientId,
q
) VALUES (
v_FoodId,
v_NutrientId,
v_q
);
--
END;
/


CREATE PROCEDURE FoodFact_Update (
--
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_q DOUBLE
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
FoodFact
SET
q = v_q
WHERE
FoodId = v_FoodId AND
NutrientId = v_NutrientId;
END;
--
/


CREATE PROCEDURE Food_Insert (
IN v_FoodId LONGVARCHAR,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Food (
FoodId,
Name
) VALUES (
v_FoodId,
v_Name
);
END;
/


CREATE PROCEDURE getFoodFactsForDerivedItem(
IN v_FoodId LONGVARCHAR
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name AS Category,
       b.Name AS Nutrient,
       c.q
FROM NutrientCategory a,
     Nutrient b,
     FoodFact c
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   b.NutrientId = c.NutrientId
AND c.FoodId = v_FoodId
AND (b.NutrientId != '10003' AND b.NutrientId != '10009' AND b.NutrientId != '10010' AND b.NutrientId != '10011' AND b.NutrientId != '10012' AND b.NutrientId != '10013' AND b.NutrientId != '10014' AND b.NutrientId != '10015' AND b.NutrientId != '10016')
ORDER BY a.Name,b.Name;
OPEN result;
END;
/

CREATE PROCEDURE getFoodFactsForNewItem()
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name AS Category,
       b.Name AS Nutrient,
       CAST(0.0 AS DECIMAL(25,18)
) AS q
FROM NutrientCategory a,
     Nutrient b
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   (b.NutrientId != '10003' AND b.NutrientId != '10009' AND b.NutrientId != '10010' AND b.NutrientId != '10011' AND b.NutrientId != '10012' AND b.NutrientId != '10013' AND b.NutrientId != '10014' AND b.NutrientId != '10015' AND b.NutrientId != '10016')
ORDER BY a.Name,
         b.Name;
--
OPEN result;
--
END;
/

CREATE PROCEDURE DuplicateFoodFact (IN v_FoodId LONGVARCHAR,IN v_FoodIdNew LONGVARCHAR)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO FoodFact
(
         FoodId,
         NutrientId,
         q
)
SELECT v_FoodIdNew,
       NutrientId,
       q
FROM FoodFact
WHERE FoodId = v_FoodId;
--
END;
/

CREATE PROCEDURE foodnutrient_rhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT mixid,
       foodid,
       nutrientid,
       relationshipid,
       b,
       b.name as food,
       c.name as nutrient,
       d.name as eq
FROM FoodQuantityC a, food b, nutrient c, relationship d
WHERE mixid = v_mixid
AND a.foodid = b.foodid
AND a.nutrientid = c.nutrientid
AND a.relationshipid = d.relationshipid
ORDER BY foodid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE CopyFoodFactsToDenormalizedTable (
--
IN v_foodId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
DELETE FROM DnFoodFact
WHERE food_id = v_FoodId;
--
INSERT INTO DnFoodFact (
food_id,
food_name,
carbohydrates_carbs_by_diff,
carbohydrates_fiber_insoluble,
carbohydrates_fiber_soluble,
carbohydrates_fiber,
carbohydrates_fructose,
carbohydrates_glucose,
carbohydrates_glycemic_load,
carbohydrates_lactose,
carbohydrates_starch,
carbohydrates_sucrose,
carbohydrates_sugars,
energy_gross,
fats_cholesterol,
fats_dha,
fats_epa,
fats_lauric,
fats_linoleic,
fats_linolenic,
fats_monounsaturated,
fats_myristic,
fats_palmitic,
fats_polyunsaturated,
fats_saturated,
fats_stearic,
fats_total,
minerals_calcium,
minerals_copper,
minerals_iron,
minerals_magnesium,
minerals_manganese,
minerals_phosphorus,
minerals_potassium,
minerals_selenium,
minerals_sodium,
minerals_zinc,
other_alcohol,
other_cost,
other_water,
other_weight,
phytonutrients_anthocyanins,
phytonutrients_caffeine,
phytonutrients_beta_carotene,
phytonutrients_carotenoids,
phytonutrients_flavanols,
phytonutrients_flavanones,
phytonutrients_flavones,
phytonutrients_flavonoids,
phytonutrients_flavonols,
phytonutrients_isoflavones,
phytonutrients_lutein_zeaxanthin,
phytonutrients_lycopene,
phytonutrients_phytosterols,
phytonutrients_theobromine,
phytonutrients_gamma_tocopherol,
protein_complete,
protein_total,
vitamins_vitamin_a,
vitamins_vitamin_b12,
vitamins_vitamin_b6,
vitamins_vitamin_c,
vitamins_choline,
vitamins_vitamin_d,
vitamins_vitamin_e,
vitamins_folate,
vitamins_vitamin_k,
vitamins_niacin,
vitamins_pantothenic_acid,
vitamins_riboflavin,
vitamins_thiamin,
carbohydrates_digestible,
energy_carbohydrate,
energy_fat,
energy_fat_and_carbohydrate,
energy_protein,
energy_alcohol,
energy_digestible,
fats_hcsfa,
fats_lcn3pufa
)
SELECT x0.foodid,
       x0.name,
       x205.q AS carbohydrates_carbs_by_diff,
       x10018.q AS carbohydrates_fiber_insoluble,
       x10017.q AS carbohydrates_fiber_soluble,
       x291.q AS carbohydrates_fiber,
       x212.q AS carbohydrates_fructose,
       x211.q AS carbohydrates_glucose,
       x10006.q AS carbohydrates_glycemic_load,
       x213.q AS carbohydrates_lactose,
       x209.q AS carbohydrates_starch,
       x210.q AS carbohydrates_sucrose,
       x269.q AS carbohydrates_sugars,
       x208.q AS energy_gross,
       x601.q AS fats_cholesterol,
       x621.q AS fats_dha,
       x629.q AS fats_epa,
       x611.q AS fats_lauric,
       x618.q AS fats_linoleic,
       x619.q AS fats_linolenic,
       x645.q AS fats_monounsaturated,
       x612.q AS fats_myristic,
       x613.q AS fats_palmitic,
       x646.q AS fats_polyunsaturated,
       x606.q AS fats_saturated,
       x614.q AS fats_stearic,
       x204.q AS fats_total,
       x301.q AS minerals_calcium,
       x312.q AS minerals_copper,
       x303.q AS minerals_iron,
       x304.q AS minerals_magnesium,
       x315.q AS minerals_manganese,
       x305.q AS minerals_phosphorus,
       x306.q AS minerals_potassium,
       x317.q AS minerals_selenium,
       x307.q AS minerals_sodium,
       x309.q AS minerals_zinc,
       x221.q AS other_alcohol,
       x10005.q AS other_cost,
       x255.q AS other_water,
       x10000.q AS other_weight,
       x10024.q AS phytonutrients_anthocyanins,
       x262.q AS phytonutrients_caffeine,
       x321.q AS phytonutrients_beta_carotene,
       x10019.q AS phytonutrients_carotenoids,
       x10022.q AS phytonutrients_flavanols,
       x10023.q AS phytonutrients_flavanones,
       x10021.q AS phytonutrients_flavones,
       x10026.q AS phytonutrients_flavonoids,
       x10020.q AS phytonutrients_flavonols,
       x10025.q AS phytonutrients_isoflavones,
       x338.q AS phytonutrients_lutein_zeaxanthin,
       x337.q AS phytonutrients_lycopene,
       x636.q AS phytonutrients_phytosterols,
       x263.q AS phytonutrients_theobromine,
       x342.q AS phytonutrients_gamma_tocopherol,
       x10001.q AS protein_complete,
       x203.q AS protein_total,
       x320.q AS vitamins_vitamin_a,
       x418.q AS vitamins_vitamin_b12,
       x415.q AS vitamins_vitamin_b6,
       x401.q AS vitamins_vitamin_c,
       x421.q AS vitamins_choline,
       x328.q AS vitamins_vitamin_d,
       x323.q AS vitamins_vitamin_e,
       x435.q AS vitamins_folate,
       x430.q AS vitamins_vitamin_k,
       x406.q AS vitamins_niacin,
       x410.q AS vitamins_pantothenic_acid,
       x405.q AS vitamins_riboflavin,
       x404.q AS vitamins_thiamin,
       x10003.q AS carbohydrates_digestible,
       x10011.q AS energy_carbohydrate,
       x10013.q AS energy_fat,
       x10010.q AS energy_fat_and_carbohydrate,
       x10012.q AS energy_protein,
       x10014.q AS energy_alcohol,
       x10009.q AS energy_digestible,
       x10015.q AS fats_hcsfa,
       x10016.q AS fats_lcn3pufa
FROM
--foodid , name
(SELECT foodid, name FROM food WHERE foodid = v_foodId) x0,
     --205, carbohydrates-carbs_by_diff
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '205'
 AND   foodid = v_foodId) x205,
     --10018, carbohydrates-fiber_insoluble
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10018'
 AND   foodid = v_foodId) x10018,
     --10017, carbohydrates-fiber_soluble
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10017'
 AND   foodid = v_foodId) x10017,
     --291, carbohydrates-fiber
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '291'
 AND   foodid = v_foodId) x291,
     --212, carbohydrates-fructose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '212'
 AND   foodid = v_foodId) x212,
     --211, carbohydrates-glucose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '211'
 AND   foodid = v_foodId) x211,
     --10006, carbohydrates-glycemic_load
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10006'
 AND   foodid = v_foodId) x10006,
     --213, carbohydrates-lactose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '213'
 AND   foodid = v_foodId) x213,
     --209, carbohydrates-starch
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '209'
 AND   foodid = v_foodId) x209,
     --210, carbohydrates-sucrose
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '210'
 AND   foodid = v_foodId) x210,
     --269, carbohydrates-sugars
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '269'
 AND   foodid = v_foodId) x269,
     --208, energy-gross
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '208'
 AND   foodid = v_foodId) x208,
     --601, fats-cholesterol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '601'
 AND   foodid = v_foodId) x601,
     --621, fats-dha
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '621'
 AND   foodid = v_foodId) x621,
     --629, fats-epa
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '629'
 AND   foodid = v_foodId) x629,
     --611, fats-lauric
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '611'
 AND   foodid = v_foodId) x611,
     --618, fats-linoleic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '618'
 AND   foodid = v_foodId) x618,
     --619, fats-linolenic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '619'
 AND   foodid = v_foodId) x619,
     --645, fats-monounsaturated
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '645'
 AND   foodid = v_foodId) x645,
     --612, fats-myristic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '612'
 AND   foodid = v_foodId) x612,
     --613, fats-palmitic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '613'
 AND   foodid = v_foodId) x613,
     --646, fats-polyunsaturated
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '646'
 AND   foodid = v_foodId) x646,
     --606, fats-saturated
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '606'
 AND   foodid = v_foodId) x606,
     --614, fats-stearic
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '614'
 AND   foodid = v_foodId) x614,
     --204, fats-total
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '204'
 AND   foodid = v_foodId) x204,
     --301, minerals-calcium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '301'
 AND   foodid = v_foodId) x301,
     --312, minerals-copper
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '312'
 AND   foodid = v_foodId) x312,
     --303, minerals-iron
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '303'
 AND   foodid = v_foodId) x303,
     --304, minerals-magnesium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '304'
 AND   foodid = v_foodId) x304,
     --315, minerals-manganese
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '315'
 AND   foodid = v_foodId) x315,
     --305, minerals-phosphorus
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '305'
 AND   foodid = v_foodId) x305,
     --306, minerals-potassium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '306'
 AND   foodid = v_foodId) x306,
     --317, minerals-selenium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '317'
 AND   foodid = v_foodId) x317,
     --307, minerals-sodium
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '307'
 AND   foodid = v_foodId) x307,
     --309, minerals-zinc
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '309'
 AND   foodid = v_foodId) x309,
     --221, other-alcohol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '221'
 AND   foodid = v_foodId) x221,
     --10005, other-cost
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10005'
 AND   foodid = v_foodId) x10005,
     --255, other-water
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '255'
 AND   foodid = v_foodId) x255,
     --10000, other-weight
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10000'
 AND   foodid = v_foodId) x10000,
     --10024, phytonutrients-anthocyanins
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10024'
 AND   foodid = v_foodId) x10024,
     --262, phytonutrients-caffeine
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '262'
 AND   foodid = v_foodId) x262,
     --321, phytonutrients-beta_carotene
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '321'
 AND   foodid = v_foodId) x321,
     --10019, phytonutrients-carotenoids
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10019'
 AND   foodid = v_foodId) x10019,
     --10022, phytonutrients-flavanols
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10022'
 AND   foodid = v_foodId) x10022,
     --10023, phytonutrients-flavanones
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10023'
 AND   foodid = v_foodId) x10023,
     --10021, phytonutrients-flavones
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10021'
 AND   foodid = v_foodId) x10021,
     --10026, phytonutrients-flavonoids
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10026'
 AND   foodid = v_foodId) x10026,
     --10020, phytonutrients-flavonols
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10020'
 AND   foodid = v_foodId) x10020,
     --10025, phytonutrients-isoflavones
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10025'
 AND   foodid = v_foodId) x10025,
     --338, phytonutrients-lutein_zeaxanthin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '338'
 AND   foodid = v_foodId) x338,
     --337, phytonutrients-lycopene
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '337'
 AND   foodid = v_foodId) x337,
     --636, phytonutrients-phytosterols
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '636'
 AND   foodid = v_foodId) x636,
     --263, phytonutrients-theobromine
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '263'
 AND   foodid = v_foodId) x263,
     --342, phytonutrients-gamma_tocopherol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '342'
 AND   foodid = v_foodId) x342,
     --10001, protein-complete
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10001'
 AND   foodid = v_foodId) x10001,
     --203, protein-total
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '203'
 AND   foodid = v_foodId) x203,
     --320, vitamins-vitamin_a
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '320'
 AND   foodid = v_foodId) x320,
     --418, vitamins-vitamin_b12
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '418'
 AND   foodid = v_foodId) x418,
     --415, vitamins-vitamin_b6
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '415'
 AND   foodid = v_foodId) x415,
     --401, vitamins-vitamin_c
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '401'
 AND   foodid = v_foodId) x401,
     --421, vitamins-choline
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '421'
 AND   foodid = v_foodId) x421,
     --328, vitamins-vitamin_d
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '328'
 AND   foodid = v_foodId) x328,
     --323, vitamins-vitamin_e
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '323'
 AND   foodid = v_foodId) x323,
     --435, vitamins-folate
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '435'
 AND   foodid = v_foodId) x435,
     --430, vitamins-vitamin_k
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '430'
 AND   foodid = v_foodId) x430,
     --406, vitamins-niacin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '406'
 AND   foodid = v_foodId) x406,
     --410, vitamins-pantothenic_acid
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '410'
 AND   foodid = v_foodId) x410,
     --405, vitamins-riboflavin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '405'
 AND   foodid = v_foodId) x405,
     --404, vitamins-thiamin
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '404'
 AND   foodid = v_foodId) x404,
     --10003, carbohydrates-digestible
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10003'
 AND   foodid = v_foodId) x10003,
     --10011, energy-carbohydrate
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10011'
 AND   foodid = v_foodId) x10011,
     --10013, energy-fat
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10013'
 AND   foodid = v_foodId) x10013,
     --10010, energy-fat_and_carbohydrate
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10010'
 AND   foodid = v_foodId) x10010,
     --10012, energy-protein
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10012'
 AND   foodid = v_foodId) x10012,
     --10014, energy-alcohol
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10014'
 AND   foodid = v_foodId) x10014,
     --10009, energy-digestible
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10009'
 AND   foodid = v_foodId) x10009,
     --10015, fats-hcsfa
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10015'
 AND   foodid = v_foodId) x10015,
     --10016, fats-lcn3pufa
(SELECT foodid,
        q
 FROM foodfact
 WHERE nutrientid = '10016'
 AND   foodid = v_foodId) x10016;
--
END;
/


CREATE PROCEDURE MixResult_Merge (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO MixResult USING ( VALUES (
v_MixId,
v_FoodId,
v_NutrientId,
v_q
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
)
WHEN MATCHED THEN UPDATE SET
q = v_q
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_NutrientId,
v_q;
END;
/

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


CREATE PROCEDURE FoodFact_EnergyFat ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
--Total lipid (Fat) (g)
SET v_NutrientIdA = '204';
--Energy, fat (kcal)
SET v_NutrientIdB = '10013';
--
FOR SELECT FOODID, Q*9 AS ENERGY FROM FOODFACT WHERE NUTRIENTID = v_NutrientIdA DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,ENERGY);
--
END FOR;
--
END;
/


CREATE PROCEDURE CategoryLink_Delete (
--
IN v_FoodCategoryId LONGVARCHAR,
--
IN v_FoodId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
CategoryLink
WHERE
FoodCategoryId = v_FoodCategoryId
AND
FoodId = v_FoodId;
--
END;
/


CREATE PROCEDURE FoodNutrientConstraint_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO FoodQuantityC
(
  mixid,
  foodid,
  nutrientid,
  relationshipid,
  b
)
SELECT v_MixId_New,
       foodid,
       nutrientid,
       relationshipid,
       b
FROM FoodQuantityC
WHERE mixid = v_MixId_Old;

--
END;
/


CREATE PROCEDURE FoodFact_EnergyAlcohol ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
--Alcohol, ethyl (g)
SET v_NutrientIdA = '221';
--Energy, alcohol (kcal)
SET v_NutrientIdB = '10014';
--
FOR SELECT FOODID, Q*6.93 AS ENERGY FROM FOODFACT WHERE NUTRIENTID = v_NutrientIdA DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,ENERGY);
--
END FOR;
--
END;
/


CREATE PROCEDURE FoodFact_EnergyProtein ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
--Protein (g)
SET v_NutrientIdA = '203';
--Energy, protein (kcal)
SET v_NutrientIdB = '10012';
--
FOR SELECT FOODID, Q * 4.7 AS ENERGY FROM FOODFACT WHERE NUTRIENTID = v_NutrientIdA DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,ENERGY);
--
END FOR;
--
END;
/


CREATE PROCEDURE FoodFact_EnergyCarbohydrate()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
--Digestible Carbs (g)
SET v_NutrientIdA = '10003';
--Energy, carbohydrate (kcal)
SET v_NutrientIdB = '10011';
--
FOR SELECT FOODID, Q*4 AS ENERGY FROM FOODFACT WHERE NUTRIENTID = v_NutrientIdA DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,ENERGY);
--
END FOR;
--
END;
/


CREATE PROCEDURE FoodFact_EnergyFatCarbs()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdB LONGVARCHAR;
--Energy, fat and carbohydrate (kcal)
SET v_NutrientIdB = '10010';
--
FOR SELECT a.foodid,energyfat + energycarbs AS energy
--
FROM (SELECT FOODID,Q AS ENERGYFAT
      FROM FOODFACT
      WHERE NUTRIENTID = '10013') a,
     (SELECT FOODID, Q AS ENERGYCARBS
      FROM FOODFACT
      WHERE NUTRIENTID = '10011') b
WHERE a.foodid = b.foodid DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,ENERGY);
--
END FOR;
--
END;
/


CREATE PROCEDURE FoodFact_DigestibleCarbohydrate ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
DECLARE v_NutrientIdC LONGVARCHAR;
--Carbohydrate, by difference (g)
SET v_NutrientIdA = '205';
--Fiber, total dietary (g
SET v_NutrientIdB = '291';
----Digestible Carbs (g)
SET v_NutrientIdC = '10003';
--
FOR SELECT FOODID, DIGESTIBLECARBOHYDRATE FROM (SELECT A.FOODID, A.CARBSBYDIFF - B.FIBER AS DIGESTIBLECARBOHYDRATE FROM (SELECT FOODID, Q AS CARBSBYDIFF FROM FOODFACT WHERE NUTRIENTID = '205') A, (SELECT FOODID, Q AS FIBER FROM FOODFACT WHERE NUTRIENTID = '291') B WHERE A.FOODID = B.FOODID) DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdC,DIGESTIBLECARBOHYDRATE);
--
END FOR;
--
END;
/


CREATE PROCEDURE FoodFact_EnergyDigestible ()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdA LONGVARCHAR;
DECLARE v_NutrientIdB LONGVARCHAR;
DECLARE v_NutrientIdC LONGVARCHAR;
DECLARE v_NutrientIdD LONGVARCHAR;
DECLARE v_NutrientIdE LONGVARCHAR;
DECLARE v_NutrientIdF LONGVARCHAR;
--Energy, fat (kcal)
SET v_NutrientIdA = '10013';
--Energy, carbohydrate (kcal)
SET v_NutrientIdB = '10011';
--Energy, protein (kcal)
SET v_NutrientIdC = '10012';
--Energy, alcohol (kcal)
SET v_NutrientIdD = '10014';
--Energy, digestible (kcal)
SET v_NutrientIdE = '10009';
--
FOR 
--
SELECT
--
       A.FOODID,
       A.ENERGYFAT + B.ENERGYCARBOHYDRATE + C.ENERGYPROTEIN + D.ENERGYALCOHOL AS ENERGYDIGESTIBLE,       
       A.ENERGYFAT,
       B.ENERGYCARBOHYDRATE,
       C.ENERGYPROTEIN,
       D.ENERGYALCOHOL
--
       FROM (SELECT FOODID,
                    Q AS ENERGYFAT
             FROM FOODFACT
             WHERE NUTRIENTID = '10013') A,
     (SELECT FOODID,
             Q AS ENERGYCARBOHYDRATE
      FROM FOODFACT
      WHERE NUTRIENTID = '10011') B,
     (SELECT FOODID,
             Q AS ENERGYPROTEIN
      FROM FOODFACT
      WHERE NUTRIENTID = '10012') C,
     (SELECT FOODID,
             Q AS ENERGYALCOHOL
      FROM FOODFACT
      WHERE NUTRIENTID = '10014') D
--
WHERE
--
A.FOODID = B.FOODID
AND   A.FOODID = C.FOODID
AND   A.FOODID = D.FOODID
--
DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdE,ENERGYDIGESTIBLE);
--
END FOR;
--
END;
/


CREATE PROCEDURE FoodFact_HCSFA()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdB LONGVARCHAR;
--Fats, Saturated Fatty Acids, HC (g)
SET v_NutrientIdB = '10015';
--
FOR SELECT a.foodid,
       a.lauric + b.myristic + c.palmitic AS hcsfa
FROM (SELECT FOODID,Q AS lauric
      FROM FOODFACT
      WHERE NUTRIENTID = '611') a,
     (SELECT FOODID, Q AS myristic
      FROM FOODFACT
      WHERE NUTRIENTID = '612') b,
     (SELECT FOODID, Q AS palmitic
      FROM FOODFACT
      WHERE NUTRIENTID = '613') c
WHERE a.foodid = b.foodid
AND a.foodid = c.foodid
--
DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,hcsfa);
--
END FOR;
--
END;
/


CREATE PROCEDURE Food_Delete (
--
IN v_FoodId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
Food
WHERE
FoodId = v_FoodId;
--
END;
/


CREATE PROCEDURE FoodNutrientConstraint_Delete (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
FoodQuantityC
WHERE
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId;
END;
/


CREATE PROCEDURE FoodNutrientConstraint_Merge (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER,
IN v_b DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO FoodQuantityC USING ( VALUES (
v_MixId,
v_FoodId,
v_NutrientId,
v_RelationshipId,
v_b
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId
)
WHEN MATCHED THEN UPDATE SET
b = v_b
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_NutrientId,
v_RelationshipId,
v_b;
END;
/


CREATE PROCEDURE Food_Select_All ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT c.name AS category,
       a.foodid,
       b.name AS food,
       c.foodcategoryid
FROM categorylink a,
     food b,
     foodcategory c
WHERE a.foodid = b.foodid
AND   a.foodcategoryid = c.foodcategoryid
ORDER BY category,
         food;
--
OPEN result;
--
END;
/


CREATE PROCEDURE FoodNutrientConstraint_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.FoodId,
a.NutrientId,
a.RelationshipId,
b.Name as Food,
c.Name as Nutrient,
d.Name as Relationship,
CASE WHEN a.b IS NULL THEN 0 ELSE a.b END
FROM
FoodQuantityC a, Food b, Nutrient c, Relationship d
WHERE
a.MixId = v_MixId
AND
a.FoodId = b.FoodId
AND
a.NutrientId = c.NutrientId
AND
a.RelationshipId = d.RelationshipId
ORDER BY a.MixId,b.Name,c.Name,d.Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE FoodNutrientRatio_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO FoodRatioC
(
  mixid,
  food_id_1,
  nutrient_id_1,
  food_id_2,
  nutrient_id_2,
  relationshipid,
  a,
  b
)
SELECT v_MixId_New,
       food_id_1,
       nutrient_id_1,
       food_id_2,
       nutrient_id_2,
       relationshipid,
       a,
       b
FROM FoodRatioC
WHERE mixid = v_MixId_Old;

--
END;
/


CREATE PROCEDURE Food_Select_By_Category (
--
IN v_FoodCategoryId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.foodid,
       b.name
FROM FoodCategory a,
     Food b,
     CategoryLink c
WHERE a.FoodCategoryId = v_FoodCategoryId
AND   a.foodcategoryid = c.foodcategoryid
AND   b.foodid = c.foodid
ORDER BY b.name;
--
         OPEN result;

--
END;
/

CREATE PROCEDURE FoodNutrientRatio_Delete (
IN v_MixId LONGVARCHAR,
IN v_Food_Id_1 LONGVARCHAR,
IN v_Nutrient_Id_1 LONGVARCHAR,
IN v_Food_Id_2 LONGVARCHAR,
IN v_Nutrient_Id_2 LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
FoodRatioC
WHERE
MixId = v_MixId
AND
Food_Id_1 = v_Food_Id_1
AND
Nutrient_Id_1 = v_Nutrient_Id_1
AND
Food_Id_2 = v_Food_Id_2
AND
Nutrient_Id_2 = v_Nutrient_Id_2
AND
RelationshipId = v_RelationshipId;
END;
/


CREATE PROCEDURE foodnutrientratio_lhs (
--
IN v_MixId LONGVARCHAR,
--
IN v_foodid1 LONGVARCHAR,
--
IN v_nutrientid1 LONGVARCHAR,
--
IN v_foodid2 LONGVARCHAR,
--
IN v_nutrientid2 LONGVARCHAR,
--
IN v_relationshipid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT foodid,
       c
FROM (SELECT a.mixid,
       a.food_id_1,
       a.nutrient_id_1,
       a.food_id_2,
       a.nutrient_id_2,
       a.relationshipid,
       b.foodid,
       CASE
         WHEN b.foodid = a.food_id_1 THEN (select c from foodfactcoefficient where foodid = a.food_id_1 and nutrientid = a.nutrient_id_1)
         ELSE 0
       END * a.b - CASE
         WHEN b.foodid = a.food_id_2 THEN (select c from foodfactcoefficient where foodid = a.food_id_2 and nutrientid = a.nutrient_id_2)
         ELSE 0
       END * a.a AS c
FROM FoodRatioC a,
     mixfood b
WHERE a.mixid = b.mixid
AND mixid = v_mixid
AND   a.food_id_1 = v_foodid1
AND   a.nutrient_id_1 = v_nutrientid1
AND   a.food_id_2 = v_foodid2
AND   a.nutrient_id_2 = v_nutrientid2
AND   a.relationshipid = v_relationshipid
ORDER BY mixid,
         food_id_1,
         nutrient_id_1,
         food_id_2,
         nutrient_id_2,
         relationshipid,
         foodid
);
--	    
OPEN result;
--
END;
/


CREATE PROCEDURE Food_Select_Details ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT  food_id,
        food_name,
        other_weight,
        energy_gross,
        energy_digestible,
        energy_fat,
        energy_carbohydrate,
        energy_fat_and_carbohydrate,
        energy_protein,
        energy_alcohol,
        fats_total,
        carbohydrates_digestible,
        protein_total,
        other_alcohol,
        energy_protein,
        protein_total,
        protein_complete,
        energy_fat,
        fats_total,
        fats_monounsaturated,
        fats_polyunsaturated,
        fats_saturated,
        fats_cholesterol,
        fats_saturated,
        fats_hcsfa,
        fats_lauric,
        fats_myristic,
        fats_palmitic,
        fats_stearic,
        fats_polyunsaturated,
        fats_linoleic,
        fats_linolenic,
        fats_epa,
        fats_dha,
        fats_lcn3pufa,
        energy_carbohydrate,
        carbohydrates_carbs_by_diff,
        carbohydrates_fiber,
        carbohydrates_fiber_insoluble,
        carbohydrates_fiber_soluble,
        carbohydrates_digestible,
        carbohydrates_starch,
        carbohydrates_sugars,
        carbohydrates_sucrose,
        carbohydrates_lactose,
        carbohydrates_fructose,
        carbohydrates_glucose,
        carbohydrates_glycemic_load,
        vitamins_vitamin_a,
        vitamins_vitamin_d,
        vitamins_vitamin_e,
        vitamins_vitamin_c,
        vitamins_thiamin,
        vitamins_riboflavin,
        vitamins_niacin,
        vitamins_vitamin_b6,
        vitamins_folate,
        vitamins_vitamin_b12,
        vitamins_vitamin_k,
        vitamins_pantothenic_acid,
        vitamins_choline,
        minerals_calcium,
        minerals_phosphorus,
        minerals_magnesium,
        minerals_iron,
        minerals_zinc,
        minerals_copper,
        minerals_manganese,
        minerals_selenium,
        minerals_potassium,
        minerals_sodium,
        phytonutrients_flavonoids,
        phytonutrients_anthocyanins,
        phytonutrients_carotenoids,
        phytonutrients_flavanols,
        phytonutrients_flavanones,
        phytonutrients_flavones,
        phytonutrients_flavonols,
        phytonutrients_isoflavones,
        phytonutrients_phytosterols,
        phytonutrients_beta_carotene,
        phytonutrients_lutein_zeaxanthin,
        phytonutrients_lycopene,
        phytonutrients_caffeine,
        phytonutrients_theobromine,
        phytonutrients_gamma_tocopherol,
        other_cost,
        other_water
FROM DnFoodFact
ORDER BY food_name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Food_Select_Details (
--
IN v_txt LONGVARCHAR
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT food_id,
       food_name,
       carbohydrates_carbs_by_diff,
       carbohydrates_fiber_insoluble,
       carbohydrates_fiber_soluble,
       carbohydrates_fiber,
       carbohydrates_fructose,
       carbohydrates_glucose,
       carbohydrates_glycemic_load,
       carbohydrates_lactose,
       carbohydrates_starch,
       carbohydrates_sucrose,
       carbohydrates_sugars,
       energy_gross,
       fats_cholesterol,
       fats_dha,
       fats_epa,
       fats_lauric,
       fats_linoleic,
       fats_linolenic,
       fats_monounsaturated,
       fats_myristic,
       fats_palmitic,
       fats_polyunsaturated,
       fats_saturated,
       fats_stearic,
       fats_total,
       minerals_calcium,
       minerals_copper,
       minerals_iron,
       minerals_magnesium,
       minerals_manganese,
       minerals_phosphorus,
       minerals_potassium,
       minerals_selenium,
       minerals_sodium,
       minerals_zinc,
       other_alcohol,
       other_cost,
       other_water,
       other_weight,
       phytonutrients_anthocyanins,
       phytonutrients_caffeine,
       phytonutrients_beta_carotene,
       phytonutrients_carotenoids,
       phytonutrients_flavanols,
       phytonutrients_flavanones,
       phytonutrients_flavones,
       phytonutrients_flavonoids,
       phytonutrients_flavonols,
       phytonutrients_isoflavones,
       phytonutrients_lutein_zeaxanthin,
       phytonutrients_lycopene,
       phytonutrients_phytosterols,
       phytonutrients_theobromine,
       protein_complete,
       protein_total,
       vitamins_vitamin_a,
       vitamins_vitamin_b12,
       vitamins_vitamin_b6,
       vitamins_vitamin_c,
       vitamins_choline,
       vitamins_vitamin_d,
       vitamins_vitamin_e,
       vitamins_folate,
       vitamins_vitamin_k,
       vitamins_niacin,
       vitamins_pantothenic_acid,
       vitamins_riboflavin,
       vitamins_thiamin,
       carbohydrates_digestible,
       energy_carbohydrate,
       energy_fat,
       energy_fat_and_carbohydrate,
       energy_protein,
       energy_alcohol,
       energy_digestible,
       fats_hcsfa,
       fats_lcn3pufa
FROM DnFoodFact
--WHERE food_name LIKE CONCAT('%',v_txt,'%');
WHERE food_name LIKE v_txt;
--WHERE REGEXP_MATCHES(food_name,CONCAT('.*',v_txt,'.*')) = TRUE;
--WHERE REGEXP_MATCHES(food_name,v_txt) = TRUE;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Food_Update (
IN v_FoodId LONGVARCHAR,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Food
SET
Name = v_Name
WHERE
FoodId = v_FoodId;
END;
/

CREATE PROCEDURE FoodNutrientRatio_Merge (
IN v_MixId LONGVARCHAR,
IN v_Food_Id_1 LONGVARCHAR,
IN v_Nutrient_Id_1 LONGVARCHAR,
IN v_Food_Id_2 LONGVARCHAR,
IN v_Nutrient_Id_2 LONGVARCHAR,
IN v_RelationshipId INTEGER,
IN v_A DOUBLE,
IN v_B DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO FoodRatioC USING ( VALUES (
v_MixId,
v_Food_Id_1,
v_Nutrient_Id_1,
v_Food_Id_2,
v_Nutrient_Id_2,
v_RelationshipId,
v_A,
v_B
) ) ON (
MixId = v_MixId
AND
Food_Id_1 = v_Food_Id_1
AND
Nutrient_Id_1 = v_Nutrient_Id_1
AND
Food_Id_2 = v_Food_Id_2
AND
Nutrient_Id_2 = v_Nutrient_Id_2
AND
RelationshipId = v_RelationshipId
)
WHEN MATCHED THEN UPDATE SET
A = v_A,
B = v_B
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_Food_Id_1,
v_Nutrient_Id_1,
v_Food_Id_2,
v_Nutrient_Id_2,
v_RelationshipId,
v_A,
v_B;
END;
/


CREATE PROCEDURE FoodCategory_Delete (
--
IN v_FoodCategoryId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
FoodCategory
WHERE
FoodCategoryId = v_FoodCategoryId;
--
END;
/

CREATE PROCEDURE foodnutrientratio_rhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT mixid,
       food_id_1,
       nutrient_id_1,
       food_id_2,
       nutrient_id_2,
       relationshipid,
       a,
       b,
       b.name as food1,
       c.name as nutrient1,
       d.name as food2,
       e.name as nutrient2,
       f.name as eq
FROM FoodRatioC a, food b, nutrient c, food d, nutrient e, relationship f
WHERE mixid = v_mixid
AND a.food_id_1 = b.foodid
AND a.nutrient_id_1 = c.nutrientid
AND a.food_id_2 = d.foodid
AND a.nutrient_id_2 = e.nutrientid
AND a.relationshipid = f.relationshipid
ORDER BY mixid,
         food_id_1,
         nutrient_id_1,
         food_id_2,
         nutrient_id_2;
--
OPEN result;
--
END;
/


CREATE PROCEDURE FoodCategory_Insert (
IN v_FoodCategoryId LONGVARCHAR,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO FoodCategory (
FoodCategoryId,
Name
) VALUES (
v_FoodCategoryId,
v_Name
);
END;
/


CREATE PROCEDURE FoodCategory_Insert_2 (
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO FoodCategory (
FoodCategoryId,
Name
) VALUES (
generateId(),
v_Name
);
--
END;
/

CREATE PROCEDURE FoodCategory_Select_All ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
FoodCategoryId,
Name 
FROM
FoodCategory
Order by Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE FoodCategory_Update (
--
IN v_FoodCategoryId LONGVARCHAR,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
UPDATE
FoodCategory
SET
Name = v_Name
WHERE
FoodCategoryId = v_FoodCategoryId;
--
END;
/

CREATE PROCEDURE foodnutrient_lhs (
--
IN v_MixId LONGVARCHAR,
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR,
--
IN v_relationshipid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT food_id_b,
       nutrientid,
       c
FROM (SELECT a.mixid,
       a.foodid as food_id_a,
       a.relationshipid,
       b.foodid as food_id_b,
       a.nutrientid,
       CASE
         WHEN b.foodid = a.foodid THEN (select c from foodfactcoefficient where foodid = a.foodid and nutrientid = a.nutrientid)
         ELSE 0
       END AS c
FROM FoodQuantityC a,
     mixfood b
WHERE a.mixid = b.mixid
AND a.mixid = v_mixid
ORDER BY a.mixid,
         a.foodid,
         a.relationshipid,
         b.foodid
)
WHERE mixid = v_mixid
AND   food_id_a = v_foodid
AND   nutrientid = v_nutrientid
AND   relationshipid = v_relationshipid
ORDER BY mixid,
         food_id_a,
         relationshipid,
         food_id_b,
         nutrientid;
--	    
OPEN result;
--
END
/

CREATE PROCEDURE FoodNutrientRatio_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.Food_Id_1,
a.Nutrient_Id_1,
a.Food_Id_2,
a.Nutrient_Id_2,
a.RelationshipId,
b.Name as FoodA,
c.Name as NutrientA,
d.Name as FoodB,
e.Name as NutrientB,
a.A,
a.B,
f.Name as Relationship
FROM
FoodRatioC a, Food b, Nutrient c, Food d, Nutrient e, Relationship f
WHERE
a.MixId = v_MixId
AND
a.Food_Id_1 = b.FoodId
AND
a.Nutrient_Id_1 = c.NutrientId
AND
a.Food_Id_2 = d.FoodId
AND
a.Nutrient_Id_2 = e.NutrientId
AND
a.relationshipid = f.relationshipid
ORDER BY a.MixId,b.Name,d.Name,c.Name,c.Name,e.Name,f.Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Mix_Copy (
--
OUT newid LONGVARCHAR,
--
IN v_MixId_Old LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_Name_Old LONGVARCHAR;
DECLARE v_LifeStageId INTEGER;
DECLARE v_Model LONGVARCHAR;
DECLARE v_MixCost LONGVARCHAR;
DECLARE v_MixDeficiency LONGVARCHAR;
DECLARE v_MixExcess LONGVARCHAR;
DECLARE newid2 LONGVARCHAR;
--
SELECT Name,
       LifeStageId,
       Model,
       MixCost,
       MixDeficiency,
       MixExcess
INTO
       v_Name_Old,
       v_LifeStageId,
       v_Model,
       v_MixCost,
       v_MixDeficiency,
       v_MixExcess
       
FROM Mix
WHERE MixId = v_MixId_Old;
--
SELECT generateId() INTO newid2 FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
LifeStageId,
Model,
MixCost,
MixDeficiency,
MixExcess
) VALUES (
newid2,
v_Name_Old||'_duplicate',
v_LifeStageId,
v_Model,
v_MixCost,
v_MixDeficiency,
v_MixExcess 
);
--
SET newid = newid2;
--
END;
/

CREATE PROCEDURE Mix_Delete (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
Mix
WHERE
MixId = v_MixId;
END;
/


CREATE PROCEDURE deleteAllMixes()
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM Mix;
END;
/


CREATE PROCEDURE deleteAllFoods()
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM Food;
END;
/


CREATE PROCEDURE deleteAllFoodCategories()
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM FoodCategory;
END;
/


CREATE PROCEDURE compareMixes (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT category, nutrient, mixa, mixb, diff
FROM
(
SELECT a.name as category,
       b.name as nutrient,
       b.mixa,
       b.mixb,
       b.diff
FROM (SELECT nutrientcategoryid, name FROM nutrientcategory) A,
     (SELECT b.nutrientcategoryid,
             b.nutrientid,
             b.name,
             a.mix1 AS mixa,
             a.mix2 AS mixb,
             a.diff AS diff
      FROM (SELECT a.nutrientid,
                   a.value AS mix1,
                   b.value AS mix2,
                   a.value - b.value AS diff
            FROM (SELECT nutrientid,
                         SUM(q) AS value
                  FROM mixresult
                  WHERE mixid = v_MixId_1
                  GROUP BY nutrientid) a,
                 (SELECT nutrientid,
                         SUM(q) AS value
                  FROM mixresult
                  WHERE mixid = v_MixId_2
                  GROUP BY nutrientid) b
            WHERE a.nutrientid = b.nutrientid) a,
           (SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
      WHERE a.nutrientid = b.nutrientid) B
WHERE a.nutrientcategoryid = b.nutrientcategoryid
UNION
SELECT 'Dietary Index'
       AS name,
       'Total Nutrient Index Score' AS name,
       a.mixa,
       b.mixb,
       a.mixa - b.mixb as diff
FROM (SELECT IFNULL((1 - mixdeficiency)*100.0,0) AS mixa
      FROM mix
      WHERE mixid = v_MixId_1) a,
     (SELECT IFNULL((1 - mixdeficiency)*100.0,0) AS mixb
      FROM mix
      WHERE mixid = v_MixId_2) b
UNION      
SELECT 'Energy' AS category,
       'Energy, Food Quotient' AS name,
       getFoodQuotient(v_MixId_1) * 100.0 AS mixa,
       getFoodQuotient(v_MixId_2) * 100.0 AS mixb,
       (getFoodQuotient(v_MixId_1) - getFoodQuotient(v_MixId_2)) * 100 as diff
FROM (
     VALUES (0))
UNION
SELECT 'Energy' AS category,
       'Energy, Protein (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_protein) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_protein) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Fat and Carbohydrate (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0, (SUM(energy_carbohydrate) + SUM(energy_fat)) / SUM(energy_digestible) *100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0, (SUM(energy_carbohydrate) + SUM(energy_fat)) / SUM(energy_digestible) *100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Fat (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0,SUM(energy_fat) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0,SUM(energy_fat) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Carbohydrate (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_carbohydrate) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_carbohydrate) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Alcohol (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0,SUM(energy_alcohol) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_alcohol) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
)      
ORDER BY nutrient ASC;
--
OPEN result;
--
END;
/

CREATE PROCEDURE snack_mix_insertmix (
--
IN v_mixid LONGVARCHAR,
--
IN v_name LONGVARCHAR,
--
IN v_LifeStageId INTEGER,
--
IN v_model LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO mix (
mixid,
name,
lifestageid,
model
) VALUES (
v_mixid,
v_name,
v_LifeStageId,
v_model
);
--
END;
/



CREATE PROCEDURE Mix_Insert (
--
OUT newid LONGVARCHAR,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE newid2 LONGVARCHAR;
--
SELECT generateId() INTO newid2 FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
LifeStageId,
Model,
MixCost,
MixDeficiency,
MixExcess
) VALUES (
newid2,
v_Name,
8,
'',
1.0,
1.0,
1.0
);
--
SET newid = newid2;
--
END;
/

CREATE PROCEDURE Mix_Select_All()
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT MixId,
       Name,
       LifeStageId,
       Model,
       MixCost,
       MixDeficiency,
       MixExcess
FROM Mix
ORDER BY Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Mix_Update_Name (
IN v_MixId LONGVARCHAR,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Mix
SET
Name = v_Name
WHERE
MixId = v_MixId;
END;
/


CREATE PROCEDURE updateMix (
--
IN v_MixId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_Model LONGVARCHAR,
IN v_MixCost DECIMAL(25,18)
,
IN v_MixDeficiency DECIMAL(25,18)
,
IN v_MixExcess DECIMAL(25,18)

--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
Mix
SET
LifeStageId = v_LifeStageId,
Model = v_Model,
MixCost = v_MixCost,
MixDeficiency = v_MixDeficiency,
MixExcess = v_MixExcess
WHERE
MixId = v_MixId;
END;
--
/


CREATE PROCEDURE MixFood_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO mixfood
(
  mixid,
  foodid,
  x
)
SELECT v_MixId_New,
       foodid,
       x
FROM mixfood
WHERE mixid = v_MixId_Old;
--
END;
/



CREATE PROCEDURE MixFood_Delete (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
MixFood
WHERE
MixId = v_MixId
AND
FoodId = v_FoodId;
END;
/


CREATE PROCEDURE MixFood_Insert (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO MixFood (
MixId,
FoodId
) VALUES (
v_MixId,
v_FoodId
);
END;
/


CREATE PROCEDURE MixFood_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
MixId,
FoodId,
x
FROM
MixFood
WHERE
MixId = v_MixId
ORDER BY
MixId,
FoodId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE MixFood_Select_All_By_FoodId (IN v_MixId LONGVARCHAR)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.FoodId,
b.Name
FROM
MixFood a, Food b
WHERE
a.foodid = b.foodid
AND
a.mixid = v_mixid
ORDER BY a.FoodId;
OPEN result;
END;
/


CREATE PROCEDURE MixFood_Select_All_By_Name (IN v_MixId LONGVARCHAR)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.FoodId,
b.Name
FROM
MixFood a, Food b
WHERE
a.foodid = b.foodid
AND
a.mixid = v_mixid
ORDER BY b.Name;
OPEN result;
END;
/


CREATE PROCEDURE MixFood_Update (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR,
IN v_x DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
MixFood
SET
x = v_x
WHERE
MixId = v_MixId
AND
FoodId = v_FoodId;
END;
/


CREATE PROCEDURE MixResult_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO MixResult
(
  MixId,
  FoodId,
  NutrientId,
  q
)
SELECT v_MixId_New,
       FoodId,
       NutrientId,
       q
FROM MixResult
WHERE mixid = v_MixId_Old;
--
END;
/

CREATE PROCEDURE DnMixResult_copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO DnMixResult
(
mix_id,
food_id,
food_name,
carbohydrates_carbs_by_diff,
carbohydrates_fiber_insoluble,
carbohydrates_fiber_soluble,
carbohydrates_fiber,
carbohydrates_fructose,
carbohydrates_glucose,
carbohydrates_glycemic_load,
carbohydrates_lactose,
carbohydrates_starch,
carbohydrates_sucrose,
carbohydrates_sugars,
energy_gross,
fats_cholesterol,
fats_dha,
fats_epa,
fats_lauric,
fats_linoleic,
fats_linolenic,
fats_monounsaturated,
fats_myristic,
fats_palmitic,
fats_polyunsaturated,
fats_saturated,
fats_stearic,
fats_total,
minerals_calcium,
minerals_copper,
minerals_iron,
minerals_magnesium,
minerals_manganese,
minerals_phosphorus,
minerals_potassium,
minerals_selenium,
minerals_sodium,
minerals_zinc,
other_alcohol,
other_cost,
other_water,
other_weight,
phytonutrients_anthocyanins,
phytonutrients_caffeine,
phytonutrients_beta_carotene,
phytonutrients_carotenoids,
phytonutrients_flavanols,
phytonutrients_flavanones,
phytonutrients_flavones,
phytonutrients_flavonoids,
phytonutrients_flavonols,
phytonutrients_isoflavones,
phytonutrients_lutein_zeaxanthin,
phytonutrients_lycopene,
phytonutrients_phytosterols,
phytonutrients_theobromine,
protein_complete,
protein_total,
vitamins_vitamin_a,
vitamins_vitamin_b12,
vitamins_vitamin_b6,
vitamins_vitamin_c,
vitamins_choline,
vitamins_vitamin_d,
vitamins_vitamin_e,
vitamins_folate,
vitamins_vitamin_k,
vitamins_niacin,
vitamins_pantothenic_acid,
vitamins_riboflavin,
vitamins_thiamin,
carbohydrates_digestible,
energy_carbohydrate,
energy_fat,
energy_fat_and_carbohydrate,
energy_protein,
energy_alcohol,
energy_digestible,
fats_hcsfa,
fats_lcn3pufa
)
SELECT
v_MixId_New,        
food_id,
food_name,
carbohydrates_carbs_by_diff,
carbohydrates_fiber_insoluble,
carbohydrates_fiber_soluble,
carbohydrates_fiber,
carbohydrates_fructose,
carbohydrates_glucose,
carbohydrates_glycemic_load,
carbohydrates_lactose,
carbohydrates_starch,
carbohydrates_sucrose,
carbohydrates_sugars,
energy_gross,
fats_cholesterol,
fats_dha,
fats_epa,
fats_lauric,
fats_linoleic,
fats_linolenic,
fats_monounsaturated,
fats_myristic,
fats_palmitic,
fats_polyunsaturated,
fats_saturated,
fats_stearic,
fats_total,
minerals_calcium,
minerals_copper,
minerals_iron,
minerals_magnesium,
minerals_manganese,
minerals_phosphorus,
minerals_potassium,
minerals_selenium,
minerals_sodium,
minerals_zinc,
other_alcohol,
other_cost,
other_water,
other_weight,
phytonutrients_anthocyanins,
phytonutrients_caffeine,
phytonutrients_beta_carotene,
phytonutrients_carotenoids,
phytonutrients_flavanols,
phytonutrients_flavanones,
phytonutrients_flavones,
phytonutrients_flavonoids,
phytonutrients_flavonols,
phytonutrients_isoflavones,
phytonutrients_lutein_zeaxanthin,
phytonutrients_lycopene,
phytonutrients_phytosterols,
phytonutrients_theobromine,
protein_complete,
protein_total,
vitamins_vitamin_a,
vitamins_vitamin_b12,
vitamins_vitamin_b6,
vitamins_vitamin_c,
vitamins_choline,
vitamins_vitamin_d,
vitamins_vitamin_e,
vitamins_folate,
vitamins_vitamin_k,
vitamins_niacin,
vitamins_pantothenic_acid,
vitamins_riboflavin,
vitamins_thiamin,
carbohydrates_digestible,
energy_carbohydrate,
energy_fat,
energy_fat_and_carbohydrate,
energy_protein,
energy_alcohol,
energy_digestible,
fats_hcsfa,
fats_lcn3pufa
FROM DnMixResult
WHERE mix_id = v_MixId_Old;
--
END;
/

CREATE PROCEDURE MixResult_Select (IN v_MixId LONGVARCHAR) MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC DECLARE result CURSOR
FOR
--
SELECT mix_id,
       food_id,
       food_name,
       other_weight,
       energy_gross,
       energy_digestible,
       energy_fat,
       energy_carbohydrate,
       energy_fat_and_carbohydrate,
       energy_protein,
       energy_alcohol,
       fats_total,
       carbohydrates_digestible,
       protein_total,
       other_alcohol,
       energy_protein,
       protein_total,
       protein_complete,
       energy_fat,
       fats_total,
       fats_monounsaturated,
       fats_polyunsaturated,
       fats_saturated,
       fats_cholesterol,
       fats_saturated,
       fats_hcsfa,
       fats_lauric,
       fats_myristic,
       fats_palmitic,
       fats_stearic,
       fats_polyunsaturated,
       fats_linoleic,
       fats_linolenic,
       fats_epa,
       fats_dha,
       fats_lcn3pufa,
       energy_carbohydrate,
       carbohydrates_carbs_by_diff,
       carbohydrates_fiber,
       carbohydrates_fiber_insoluble,
       carbohydrates_fiber_soluble,
       carbohydrates_digestible,
       carbohydrates_starch,
       carbohydrates_sugars,
       carbohydrates_sucrose,
       carbohydrates_lactose,
       carbohydrates_fructose,
       carbohydrates_glucose,
       carbohydrates_glycemic_load,
       vitamins_vitamin_a,
       vitamins_vitamin_d,
       vitamins_vitamin_e,
       vitamins_vitamin_c,
       vitamins_thiamin,
       vitamins_riboflavin,
       vitamins_niacin,
       vitamins_vitamin_b6,
       vitamins_folate,
       vitamins_vitamin_b12,
       vitamins_vitamin_k,
       vitamins_pantothenic_acid,
       vitamins_choline,
       minerals_calcium,
       minerals_phosphorus,
       minerals_magnesium,
       minerals_iron,
       minerals_zinc,
       minerals_copper,
       minerals_manganese,
       minerals_selenium,
       minerals_potassium,
       minerals_sodium,
       phytonutrients_flavonoids,
       phytonutrients_anthocyanins,
       phytonutrients_carotenoids,
       phytonutrients_flavanols,
       phytonutrients_flavanones,
       phytonutrients_flavones,
       phytonutrients_flavonols,
       phytonutrients_isoflavones,
       phytonutrients_phytosterols,
       phytonutrients_beta_carotene,
       phytonutrients_lutein_zeaxanthin,
       phytonutrients_lycopene,
       phytonutrients_caffeine,
       phytonutrients_theobromine,
       phytonutrients_gamma_tocopherol,
       other_cost,
       other_water
FROM DnMixResult a,
     food b
WHERE a.mix_id = v_MixId
AND   a.food_id = b.foodid
UNION
SELECT a.mix_id,
       '',
       'Total',
       SUM(other_weight),
       SUM(energy_gross),
       SUM(energy_digestible),
       SUM(energy_fat),
       SUM(energy_carbohydrate),
       SUM(energy_fat_and_carbohydrate),
       SUM(energy_protein),
       SUM(energy_alcohol),
       SUM(fats_total),
       SUM(carbohydrates_digestible),
       SUM(protein_total),
       SUM(other_alcohol),
       SUM(energy_protein),
       SUM(protein_total),
       SUM(protein_complete),
       SUM(energy_fat),
       SUM(fats_total),
       SUM(fats_monounsaturated),
       SUM(fats_polyunsaturated),
       SUM(fats_saturated),
       SUM(fats_cholesterol),
       SUM(fats_saturated),
       SUM(fats_hcsfa),
       SUM(fats_lauric),
       SUM(fats_myristic),
       SUM(fats_palmitic),
       SUM(fats_stearic),
       SUM(fats_polyunsaturated),
       SUM(fats_linoleic),
       SUM(fats_linolenic),
       SUM(fats_epa),
       SUM(fats_dha),
       SUM(fats_lcn3pufa),
       SUM(energy_carbohydrate),
       SUM(carbohydrates_carbs_by_diff),
       SUM(carbohydrates_fiber),
       SUM(carbohydrates_fiber_insoluble),
       SUM(carbohydrates_fiber_soluble),
       SUM(carbohydrates_digestible),
       SUM(carbohydrates_starch),
       SUM(carbohydrates_sugars),
       SUM(carbohydrates_sucrose),
       SUM(carbohydrates_lactose),
       SUM(carbohydrates_fructose),
       SUM(carbohydrates_glucose),
       SUM(carbohydrates_glycemic_load),
       SUM(vitamins_vitamin_a),
       SUM(vitamins_vitamin_d),
       SUM(vitamins_vitamin_e),
       SUM(vitamins_vitamin_c),
       SUM(vitamins_thiamin),
       SUM(vitamins_riboflavin),
       SUM(vitamins_niacin),
       SUM(vitamins_vitamin_b6),
       SUM(vitamins_folate),
       SUM(vitamins_vitamin_b12),
       SUM(vitamins_vitamin_k),
       SUM(vitamins_pantothenic_acid),
       SUM(vitamins_choline),
       SUM(minerals_calcium),
       SUM(minerals_phosphorus),
       SUM(minerals_magnesium),
       SUM(minerals_iron),
       SUM(minerals_zinc),
       SUM(minerals_copper),
       SUM(minerals_manganese),
       SUM(minerals_selenium),
       SUM(minerals_potassium),
       SUM(minerals_sodium),
       SUM(phytonutrients_flavonoids),
       SUM(phytonutrients_anthocyanins),
       SUM(phytonutrients_carotenoids),
       SUM(phytonutrients_flavanols),
       SUM(phytonutrients_flavanones),
       SUM(phytonutrients_flavones),
       SUM(phytonutrients_flavonols),
       SUM(phytonutrients_isoflavones),
       SUM(phytonutrients_phytosterols),
       SUM(phytonutrients_beta_carotene),
       SUM(phytonutrients_lutein_zeaxanthin),
       SUM(phytonutrients_lycopene),
       SUM(phytonutrients_caffeine),
       SUM(phytonutrients_theobromine),
       SUM(phytonutrients_gamma_tocopherol),
       SUM(other_cost),
       SUM(other_water)
FROM DnMixResult a,
     food b
WHERE a.mix_id = v_MixId
AND   a.food_id = b.foodid
GROUP BY a.mix_id
ORDER BY energy_digestible, food_id desc;

--
OPEN result;

END;
/


CREATE PROCEDURE MixResult_Select_Pct (
--
IN v_MixId LONGVARCHAR
--
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_digestible)) AS calories,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_fat) / SUM(energy_digestible)*100) AS fatpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_carbohydrate) / SUM(energy_digestible)*100) AS carbpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_protein) / SUM(energy_digestible)*100) AS proteinpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_alcohol) / SUM(energy_digestible)*100) AS alcoholpct,
       getFoodQuotient (v_MixId) AS fq,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_saturated*9) / SUM(energy_digestible)*100) AS satfatpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_monounsaturated*9) / SUM(energy_digestible)*100) AS monoufatpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_polyunsaturated*9) / SUM(energy_digestible)*100) AS polyufatpct,
       get_essential_fat_ratio(v_MixId) AS essentialfatratio,
       get_electrolyte_ratio(v_MixId) AS electrolyteratio,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_linoleic*9) / SUM(energy_digestible)*100) AS linoleicacidpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_linolenic*9) / SUM(energy_digestible)*100) AS alphalinolenicacidpct,
       get_polyufat_ratio(v_MixId) AS psratio,
       get_monoufat_ratio(v_MixId) AS msratio
FROM DnMixResult
WHERE mix_id = v_MixId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Nutrient_Insert (
--
IN v_NutrientId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_NutrientCategoryId LONGVARCHAR,
IN v_Label LONGVARCHAR,
IN v_Units LONGVARCHAR,
IN v_Dri INTEGER
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO Nutrient (
NutrientId,
Name,
NutrientCategoryId,
Label,
Units,
Dri
) VALUES (
v_NutrientId,
v_Name,
v_NutrientCategoryId,
v_Label,
v_Units,
v_Dri
);
--
END;
/

CREATE PROCEDURE nutrient_lhs (
--
IN v_MixId LONGVARCHAR,
IN v_nutrientid LONGVARCHAR,
IN v_relationshipid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT foodid,
       c
FROM
(
SELECT a.mixid,
       a.nutrientid,
       a.relationshipid,
       b.foodid,
       c.c
FROM NutrientQuantityC a,
     mixfood b,
     foodfactcoefficient c
WHERE a.mixid = b.mixid
AND   b.foodid = c.foodid
AND   a.nutrientid = c.nutrientid
AND   a.mixid = v_mixid
AND   a.nutrientid = v_nutrientid
AND   a.relationshipid = v_relationshipid
ORDER BY a.mixid,
         a.nutrientid,
         a.relationshipid,
         b.foodid
); 
--	    
OPEN result;
--
END;
/


CREATE PROCEDURE nutrient_rhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT mixid,
       nutrientid,
       relationshipid,
       b,
       b.name as nutrient,
       c.name as eq
FROM NutrientQuantityC a, nutrient b, relationship c
WHERE mixid = v_MixId
AND a.nutrientid = b.nutrientid
AND a.relationshipid = c.relationshipid
ORDER BY nutrientid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE selectDriNutrients()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name
FROM
Nutrient a
WHERE
a.NutrientId = '301' OR
a.NutrientId = '303' OR
a.NutrientId = '304' OR
a.NutrientId = '305' OR
a.NutrientId = '306' OR
a.NutrientId = '307' OR
a.NutrientId = '309' OR
a.NutrientId = '312' OR
a.NutrientId = '315' OR
a.NutrientId = '317' OR
a.NutrientId = '320' OR
a.NutrientId = '323' OR
a.NutrientId = '328' OR
a.NutrientId = '401' OR
a.NutrientId = '404' OR
a.NutrientId = '405' OR
a.NutrientId = '406' OR
a.NutrientId = '410' OR
a.NutrientId = '415' OR
a.NutrientId = '418' OR
a.NutrientId = '421' OR
a.NutrientId = '430' OR
a.NutrientId = '435'
ORDER BY Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE getDri(
--
IN vNutrientid LONGVARCHAR,
--
IN vLifestageid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT a.nutrientid,
       a.name,
       a.units,
       b.lifestageid,
       c.label,
       b.q
FROM nutrient a,
     rda b,
     rdalifestage c
WHERE a.nutrientid = b.nutrientid
AND b.lifestageid = c.lifestageid
AND   c.lifestageid = vLifestageid
AND a.nutrientid = vNutrientid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Nutrient_Select_All ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name,
Visible
FROM
Nutrient
WHERE
NutrientId != '205'
ORDER BY Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE NutrientConstraint_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO NutrientQuantityC
(
  mixid,
  nutrientid,
  relationshipid,
  b
)
SELECT v_MixId_New,
       nutrientid,
       relationshipid,
       b
FROM NutrientQuantityC
WHERE mixid = v_MixId_Old;

--
END;
/

CREATE PROCEDURE NutrientConstraint_Delete (
IN v_MixId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
NutrientQuantityC
WHERE
MixId = v_MixId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId;
END;
/


CREATE PROCEDURE NutrientConstraint_Merge (
IN v_MixId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER,
IN v_b DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO NutrientQuantityC USING ( VALUES (
v_MixId,
v_NutrientId,
v_RelationshipId,
v_b
) ) ON (
MixId = v_MixId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId
)
WHEN MATCHED THEN UPDATE SET
b = v_b
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_NutrientId,
v_RelationshipId,
v_b;
END;
/


CREATE PROCEDURE NutrientConstraint_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.NutrientId,
a.RelationshipId,
b.Name as Nutrient,
c.Name as Relationship,
a.b
FROM
NutrientQuantityC a, Nutrient b, Relationship c
WHERE
a.MixId = v_MixId
AND
a.nutrientid = b.nutrientid
AND
a.relationshipid = c.relationshipid
ORDER BY a.MixId,b.Name,c.Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE NutrientRatio_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO NutrientRatioC
(
  mixid,
  nutrient_id_1,
  nutrient_id_2,
  relationshipid,
  a,
  b
)
SELECT v_MixId_New,
       nutrient_id_1,
       nutrient_id_2,
       relationshipid,
       a,
       b
FROM NutrientRatioC
WHERE mixid = v_MixId_Old;

--
END;
/

CREATE PROCEDURE NutrientRatio_Delete (
IN v_MixId LONGVARCHAR,
IN v_Nutrient_Id_1 LONGVARCHAR,
IN v_Nutrient_Id_2 LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
NutrientRatioC
WHERE
MixId = v_MixId
AND
Nutrient_Id_1 = v_Nutrient_Id_1
AND
Nutrient_Id_2 = v_Nutrient_Id_2
AND
RelationshipId = v_RelationshipId;
END;
/


CREATE PROCEDURE nutrientratio_lhs (
--
IN v_MixId LONGVARCHAR,
--
IN v_nutrientid1 LONGVARCHAR,
--
IN v_nutrientid2 LONGVARCHAR,
--
IN v_relationshipid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT food_id_1 AS foodid,
       c
FROM (SELECT a.mixid,
             a.food_id_1,
             a.nutrient_id_1,
             b.food_id_2,
             b.nutrient_id_2,
             a.relationshipid,
             a.c*b.b - b.c*a.a AS c
      FROM (SELECT a.mixid,
                   b,
                   foodid AS food_id_1,
                   a.nutrient_id_1,
                   a.relationshipid,
                   a.a,
                   a.b,
                   b.c
            FROM NutrientRatioC a,
                 (SELECT a.mixid,
                         a.foodid,
                         b.nutrientid,
                         b.c
                  FROM mixfood a,
                       foodfactcoefficient b
                  WHERE a.foodid = b.foodid
                  AND   a.mixid = v_mixid
                  ORDER BY a.mixid,
                           a.foodid,
                           b.nutrientid) b
            WHERE a.mixid = b.mixid
            AND   a.mixid = v_mixid
            AND   a.nutrient_id_1 = b.nutrientid
            AND   a.nutrient_id_1 = v_nutrientid1
            AND   a.relationshipid = v_relationshipid) a,
           (SELECT a.mixid,
                   b.foodid AS food_id_2,
                   a.nutrient_id_2,
                   a.relationshipid,
                   a.a,
                   a.b,
                   b.c
            FROM NutrientRatioC a,
                 (SELECT a.mixid,
                         a.foodid,
                         b.nutrientid,
                         b.c
                  FROM mixfood a,
                       foodfactcoefficient b
                  WHERE a.foodid = b.foodid
                  AND   a.mixid = v_mixid
                  ORDER BY a.mixid,
                           a.foodid,
                           b.nutrientid) b
            WHERE a.mixid = b.mixid
            AND   a.mixid = v_mixid
            AND   a.nutrient_id_2 = b.nutrientid
            AND   a.nutrient_id_2 = v_nutrientid2
            AND   a.relationshipid = v_relationshipid) b
      WHERE a.mixid = b.mixid
      AND   a.food_id_1 = b.food_id_2
      AND   a.relationshipid = b.relationshipid
      AND   a.mixid = v_mixid
      AND   a.relationshipid = v_relationshipid
      ORDER BY a.mixid,
               a.food_id_1,
               a.nutrient_id_1,
               b.food_id_2,
               b.nutrient_id_2,
               a.relationshipid);

--	    
OPEN result;

--
END;
/


CREATE PROCEDURE NutrientRatio_Merge (
IN v_MixId LONGVARCHAR,
IN v_Nutrient_Id_1 LONGVARCHAR,
IN v_Nutrient_Id_2 LONGVARCHAR,
IN v_RelationshipId INTEGER,
IN v_A DOUBLE,
IN v_B DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO NutrientRatioC USING ( VALUES (
v_MixId,
v_Nutrient_Id_1,
v_Nutrient_Id_2,
v_RelationshipId,
v_A,
v_B
) ) ON (
MixId = v_MixId
AND
Nutrient_Id_1 = v_Nutrient_Id_1
AND
Nutrient_Id_2 = v_Nutrient_Id_2
AND
RelationshipId = v_RelationshipId
)
WHEN MATCHED THEN UPDATE SET
A = v_A,
B = v_B
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_Nutrient_Id_1,
v_Nutrient_Id_2,
v_RelationshipId,
v_A,
v_B;
END;
/


CREATE PROCEDURE nutrientratio_rhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT mixid,
       nutrient_id_1,
       nutrient_id_2,
       relationshipid,
       a,
       b,       
       b.name as nutrient1,
       c.name as nutrient2,
       d.name as eq
FROM NutrientRatioC a, nutrient b, nutrient c, relationship d
WHERE mixid = v_mixid
AND a.nutrient_id_1 = b.nutrientid
AND a.nutrient_id_2 = c.nutrientid
AND a.relationshipid = d.relationshipid
ORDER BY mixid,
         nutrient_id_1,
         nutrient_id_2,
         relationshipid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE NutrientRatio_Select (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.Nutrient_Id_1,
a.Nutrient_Id_2,
a.RelationshipId,
b.Name as NutrientA,
c.Name as NutrientB,
a.A,
a.B,
d.Name as Relationship
FROM
NutrientRatioC a, Nutrient b, Nutrient c, Relationship d
WHERE
a.MixId = v_MixId
AND
a.Nutrient_Id_1 = b.NutrientId
AND
a.Nutrient_Id_2 = c.NutrientId
AND
a.relationshipid = d.relationshipid
ORDER BY a.MixId,b.Name,c.Name,d.Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Relationship_Insert (
IN v_RelationshipId INTEGER,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Relationship (
RelationshipId,
Name
) VALUES (
v_RelationshipId,
v_Name
);
END;
/


CREATE PROCEDURE Relationship_Select_All ()
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
RelationshipId,
Name 
FROM
Relationship;
OPEN result;
END;
/


CREATE PROCEDURE Nutrient_Lookup_List (
--
IN v_nutrientid LONGVARCHAR,
IN v_q DECIMAL(25,18)

--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT a.foodcategoryid as categoryid,
       b.foodid as foodid,
       a.name as category,
       b.name as food,
       a.calories,
       a.weight
FROM (SELECT b.name,
             b.foodcategoryid,
             a.foodid,
             a.weight,
             a.calories
      FROM (SELECT b.foodcategoryid,
                   b.foodid,
                   a.weight,
                   a.calories
            FROM (SELECT a.foodid,
                         a.q AS weight,
                         b.c*a.q AS calories
                  FROM (SELECT foodid,
                               v_q / c AS q
                        FROM (SELECT foodid,
                                     c
                              FROM foodfactcoefficient a
                              WHERE nutrientid = v_nutrientid
                              AND   c > 0)) a,
                       (SELECT foodid,
                               c
                        FROM foodfactcoefficient a
                        WHERE nutrientid = '10009') b
                  WHERE a.foodid = b.foodid) a,
                 CategoryLink b
            WHERE a.foodid = b.foodid) a,
           foodcategory b
      WHERE a.foodcategoryid = b.foodcategoryid) a,
     food b
WHERE a.foodid = b.foodid
ORDER BY a.name, a.calories;
--
OPEN result;
--
END
/


CREATE PROCEDURE FoodFactCoefficient_Merge (
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_c DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO FoodFactCoefficient USING ( VALUES (
v_FoodId,
v_NutrientId,
v_c
) ) ON (
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
)
WHEN MATCHED THEN UPDATE SET
c = v_c
WHEN NOT MATCHED THEN INSERT VALUES
v_FoodId,
v_NutrientId,
v_c;
END;
/

CREATE PROCEDURE Nutrient_Update (
IN v_NutrientId LONGVARCHAR,
IN v_Visible INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Nutrient
SET
Visible = v_Visible
WHERE
NutrientId = v_NutrientId;
END;
/


CREATE PROCEDURE NutrientCategory_Insert (
IN v_NutrientCategoryId LONGVARCHAR,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO NutrientCategory (
NutrientCategoryId,
Name
) VALUES (
v_NutrientCategoryId,
v_Name
);
END;
/


CREATE PROCEDURE Nutrient_Select_All_Visible ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name,
Visible
FROM
Nutrient
WHERE
Visible = 1 AND
NutrientId != '205'
ORDER BY Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE getNutrients()
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.foodid,
       a.nutrientid,
       c.name AS food,
       b.name AS nutrient,
       a.q,
       b.units,
       b.dri
FROM foodfact a,
     nutrient b,
     food c
WHERE a.nutrientid = b.nutrientid
AND   a.foodid = c.foodid
ORDER BY a.foodid,
         b.dri DESC,
         b.name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Rda_Insert_q (
IN v_NutrientId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Rda (
NutrientId,
LifeStageId,
q,
ul
) VALUES (
v_NutrientId,
v_LifeStageId,
v_q,
DEFAULT
);
END;
/

CREATE PROCEDURE Mix_getDriDiff (
--
IN v_MixId LONGVARCHAR,
IN v_LifeStageId INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.nutrientid,
       b.name,
       a.mix AS Mix,
       a.rda AS Dri,
       CASE WHEN a.rda <= 0 THEN 0 ELSE (a.mix / a.rda)*100 END AS PctDri,
       a.ul AS UL,
       CASE WHEN a.ul <= 0 THEN 0 ELSE (a.mix / a.ul)*100 END AS PctUL
FROM (SELECT a.nutrientid,
             a.mix,
             b.rda,
             b.ul
      FROM (SELECT nutrientid,
                   SUM(a.q) AS mix
            FROM mixresult a
            WHERE a.mixid = v_MixId
            AND   (
            --vitamin A
            nutrientid = '320' OR
            --Vitamin D
            nutrientid = '328' OR
            --E
            nutrientid = '323' OR
            --K
            nutrientid = '430' OR
            --C
            nutrientid = '401' OR
            --Thiamin
            nutrientid = '404' OR
            --Riboflavin
            nutrientid = '405' OR
            --Niacin
            nutrientid = '406' OR
            --B6
            nutrientid = '415' OR
            --Folate
            nutrientid = '435' OR
            --B12
            nutrientid = '418' OR
            --Choline
            nutrientid = '421' OR
            --Calcium
            nutrientid = '301' OR
            --Phosphorus
            nutrientid = '305' OR
            --Magnesium
            nutrientid = '304' OR
            --Iron
            nutrientid = '303' OR
            --Potassium
            nutrientid = '306' OR
            --Sodium
            nutrientid = '307' OR
            --Zinc
            nutrientid = '309' OR
            --Selenium
            nutrientid = '317' OR
            --Copper
            nutrientid = '312' OR
            --Manganese
            nutrientid = '315' OR
            --Panthotenic Acid
            nutrientid = '410' OR
            --Water (g)
            nutrientid = '255' OR
            --Digestible Carbohydrate (g)
            nutrientid = '10003' OR
            --Fiber, total dietary (g)
            nutrientid = '291' OR
            --Total lipid (Fat) (g)
            nutrientid = '204' OR
            --18:2 undifferentiated (Linoleic) (g)
            nutrientid = '618' OR
            --18:3 undifferentiated (Linolenic) (g)
            nutrientid = '619' OR
            --Complete Protein (g)
            nutrientid = '10001')
            GROUP BY nutrientid) a,
           (SELECT nutrientid, q AS rda, ul FROM rda WHERE lifestageid = v_LifeStageId) b
      WHERE a.nutrientid = b.nutrientid) a,
     (SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
WHERE a.nutrientid = b.nutrientid
ORDER BY b.name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE RdaLifeStage_Merge (
IN v_LifeStageId INTEGER,
IN v_Label LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO RdaLifeStage USING ( VALUES (
v_LifeStageId,
v_Label
) ) ON (
LifeStageId = v_LifeStageId
)
WHEN MATCHED THEN UPDATE SET
Label = v_Label
WHEN NOT MATCHED THEN INSERT VALUES
v_LifeStageId,
v_Label;
END;
/

CREATE PROCEDURE RdaLifeStage_Select_All()
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
LifeStageId,
Label
FROM
RdaLifeStage;
OPEN result;
END;
/

CREATE PROCEDURE Select_mix_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
--
BEGIN ATOMIC
--
DECLARE doc LONGVARCHAR;
--
SET doc = '';
--
SELECT  '<mix>' +CHAR(10) + '<mix-id>' + mixid + '</mix-id>' +CHAR(10) + '<mix-name>' + escape_xml_element_data(Name) + '</mix-name>' + CHAR(10) + '<lifestage-id>' + lifestageid + '</lifestage-id>' + CHAR(10)  + '</mix>'  INTO doc FROM Mix WHERE mixid = v_MixId;
--
SET v_doc = doc + CHAR (10);
--
END
/

CREATE PROCEDURE Select_mixfood_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
--
SET doc = '';
SET doc2 = '';
--
SET doc2 = '<food_list>' + CHAR(10) ;
------------------------------------------------------------
FOR SELECT a.foodid as id ,name FROM mixfood a, food b WHERE a.foodid = b.foodid  AND a.mixid = v_MixId  DO
--
SET doc = '<food>' +CHAR(10)+'<food-id>'+id +'</food-id>' +CHAR (10) + '<food-name>'+ escape_xml_element_data(name) +'</food-name>' +CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT * FROM (SELECT NUTRIENTID, LABEL, UNITS, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = id AND   Y.NUTRIENTID = Z.NUTRIENTID AND   (Y.NUTRIENTID != '10003' AND Y.NUTRIENTID != '10009' AND Y.NUTRIENTID != '10010' AND Y.NUTRIENTID != '10011' AND Y.NUTRIENTID != '10012' AND Y.NUTRIENTID != '10013' AND Y.NUTRIENTID != '10014' AND Y.NUTRIENTID != '10015' AND Y.NUTRIENTID != '10016')) ORDER BY LABEL DO
--
SET doc = '<'+label +' '+'units="'+units+'" '+'nutr_no="'+nutrientid+'" '+'>'+ q +'</'+label +'>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc2 = doc2 + '<category-list>'+ CHAR (10);
--
FOR SELECT c.foodcategoryid as categoryid, b.name as categoryname FROM mixfood a, foodcategory b, categorylink c WHERE a.mixid = v_MixId AND a.foodid = id AND b.foodcategoryid = c.foodcategoryid AND a.foodid = c.foodid DO
--
SET doc = '<category>'+ CHAR (10) + '<category-id>' + categoryid + '</category-id>' + CHAR (10) + '<category-name>' + categoryname + '</category-name>' + CHAR (10) + '</category>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc2 = doc2 + '</category-list>'+ CHAR (10);
--
SET doc2 = doc2 + '</food>' + CHAR (10);
--
END FOR;
--
SET v_doc = doc2 + '</food_list>';
--
END
/


CREATE PROCEDURE Select_category_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
--
SET doc = '';
SET doc2 = '';
--
SELECT '<category_list>' INTO doc FROM (VALUES (0));
--
SET doc2 = doc2 + doc + CHAR(10) ;
--
SET doc = '';
--
FOR SELECT DISTINCT c.foodcategoryid as id, c.name as name FROM mixfood a, categorylink b, foodcategory c WHERE a.foodid = b.foodid AND   b.foodcategoryid = c.foodcategoryid AND a.mixid = v_MixId  DO
--
SET doc = '<category>' + CHAR(10) + '<category-id>' + id + '</category-id>' + CHAR(10) + '<categoryname>' + escape_xml_element_data(name) + '</categoryname>'  + CHAR(10)  + '</category>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc = '</category_list>';
--
SET v_doc = doc2 + doc;
--
END
/


CREATE PROCEDURE Select_category_link_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
--
SET doc = '';
SET doc2 = '';
--
SELECT '<category_link_list>' INTO doc FROM (VALUES (0));
--
SET doc2 = doc2 + doc + CHAR(10) ;
--
SET doc = '';
--
FOR select a.foodid as foodid, a.foodcategoryid as categoryid from categorylink a, mixfood b where a.foodid = b.foodid and b.mixid = v_MixId  DO 
--
SET doc =  '<category_link>' + CHAR(10) + '<food-id>' + foodid + '</food-id>' + CHAR(10) + '<category-id>' + categoryid + '</category-id>'  + CHAR(10) + '</category_link>'  + CHAR(10) ;
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc = '</category_link_list>';
--
SET v_doc = doc2 + doc;
--
END
/

CREATE PROCEDURE Select_nutrient_constraint_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_mixid LONGVARCHAR
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
--
DECLARE counter INTEGER;
--
SET doc = '';
--
SET counter = 0;
--
SELECT count(nutrientid, relationshipid, b) INTO counter FROM NutrientQuantityC WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<nutrient_quantity_list>' + CHAR (10);
--
FOR select nutrientid, relationshipid, b from NutrientQuantityC  WHERE mixid = v_mixid DO
--
SET doc = doc + '<nutrient_quantity>' + CHAR (10) + '<nutrient-id>' + nutrientid + '</nutrient-id>' + CHAR (10) + '<relationship-id>'+relationshipid +'</relationship-id>' + CHAR (10) + '<b>'+ b +'</b>' + CHAR (10) + '</nutrient_quantity>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</nutrient_quantity_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/

CREATE PROCEDURE Select_foodnutrient_constraint_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
--
DECLARE counter INTEGER;
--
SET doc = '';
--
SET counter = 0;
--
SELECT count(foodid , nutrientid, relationshipid, b) INTO counter FROM FoodQuantityC a WHERE a.mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<food_quantity_list>' + CHAR (10);
--
FOR select foodid , nutrientid, relationshipid, b from FoodQuantityC a WHERE a.mixid = v_mixid DO
--
SET doc = doc + '<food_quantity>' + CHAR (10) + '<food-id>' + foodid + '</food-id>' + CHAR (10) + '<nutrient-id>' + nutrientid + '</nutrient-id>' + CHAR (10) + '<relationship-id>'+relationshipid +'</relationship-id>' + CHAR (10) + '<b>'+ b +'</b>' + CHAR (10) + '</food_quantity>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</food_quantity_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/


CREATE PROCEDURE Select_foodnutrient_ratio_constraint_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_mixid LONGVARCHAR
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
--
DECLARE counter INTEGER;
--
SET doc = '';
--
SET counter = 0;
--
SELECT count(food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b) INTO counter FROM FoodRatioC WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<food_ratio_list>' + CHAR (10);
--
FOR select food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b from FoodRatioC WHERE mixid = v_mixid DO
--
SET doc = doc + '<food_ratio>' + CHAR (10) + '<food-id_a>' + food_id_1 + '</food-id_a>' + CHAR (10) + '<nutrient-id_a>' + nutrient_id_1 + '</nutrient-id_a>' + CHAR (10) + '<food-id_b>' + food_id_2 + '</food-id_b>' + CHAR (10) + '<nutrient-id_b>' + nutrient_id_2 + '</nutrient-id_b>' + CHAR (10) + '<relationship-id>' + relationshipid  + '</relationship-id>' + CHAR (10) + '<a>' + a  + '</a>' +CHAR (10) + '<b>'+ b  + '</b>' +CHAR (10) + '</food_ratio>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</food_ratio_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/


CREATE PROCEDURE Select_nutrient_ratio_constraint_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
--
DECLARE counter INTEGER;
--
SET doc = '';
--
SET counter = 0;
--
SELECT count(nutrient_id_1, nutrient_id_2, relationshipid, a, b) INTO counter FROM NutrientRatioC WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<nutrient_ratio_list>' + CHAR (10);
--
FOR select nutrient_id_1, nutrient_id_2, relationshipid, a, b from NutrientRatioC WHERE mixid = v_mixid DO
--
SET doc = doc + '<nutrient_ratio>' + CHAR (10)  + '<nutrient-id_a>' + nutrient_id_1 + '</nutrient-id_a>' + CHAR (10)  + '<nutrient-id_b>' + nutrient_id_2 + '</nutrient-id_b>' + CHAR (10) + '<relationship-id>' + relationshipid  + '</relationship-id>' + CHAR (10) + '<a>' + a  + '</a>' +CHAR (10) + '<b>'+ b  + '</b>' +CHAR (10) + '</nutrient_ratio>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</nutrient_ratio_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/


CREATE PROCEDURE fill_DnMixResult (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
INSERT INTO DnMixResult
(
mix_id,
food_id,
food_name,
carbohydrates_carbs_by_diff,
carbohydrates_fiber_insoluble,
carbohydrates_fiber_soluble,
carbohydrates_fiber,
carbohydrates_fructose,
carbohydrates_glucose,
carbohydrates_glycemic_load,
carbohydrates_lactose,
carbohydrates_starch,
carbohydrates_sucrose,
carbohydrates_sugars,
energy_gross,
fats_cholesterol,
fats_dha,
fats_epa,
fats_lauric,
fats_linoleic,
fats_linolenic,
fats_monounsaturated,
fats_myristic,
fats_palmitic,
fats_polyunsaturated,
fats_saturated,
fats_stearic,
fats_total,
minerals_calcium,
minerals_copper,
minerals_iron,
minerals_magnesium,
minerals_manganese,
minerals_phosphorus,
minerals_potassium,
minerals_selenium,
minerals_sodium,
minerals_zinc,
other_alcohol,
other_cost,
other_water,
other_weight,
phytonutrients_anthocyanins,
phytonutrients_caffeine,
phytonutrients_beta_carotene,
phytonutrients_carotenoids,
phytonutrients_flavanols,
phytonutrients_flavanones,
phytonutrients_flavones,
phytonutrients_flavonoids,
phytonutrients_flavonols,
phytonutrients_isoflavones,
phytonutrients_lutein_zeaxanthin,
phytonutrients_lycopene,
phytonutrients_phytosterols,
phytonutrients_theobromine,
phytonutrients_gamma_tocopherol,
protein_complete,
protein_total,
vitamins_vitamin_a,
vitamins_vitamin_b12,
vitamins_vitamin_b6,
vitamins_vitamin_c,
vitamins_choline,
vitamins_vitamin_d,
vitamins_vitamin_e,
vitamins_folate,
vitamins_vitamin_k,
vitamins_niacin,
vitamins_pantothenic_acid,
vitamins_riboflavin,
vitamins_thiamin,
carbohydrates_digestible,
energy_carbohydrate,
energy_fat,
energy_fat_and_carbohydrate,
energy_protein,
energy_alcohol,
energy_digestible,
fats_hcsfa,
fats_lcn3pufa
)
SELECT 
a.mixid,
a.foodid,
b.food_name,
carbohydrates_carbs_by_diff,
carbohydrates_fiber_insoluble,
carbohydrates_fiber_soluble,
carbohydrates_fiber,
carbohydrates_fructose,
carbohydrates_glucose,
carbohydrates_glycemic_load,
carbohydrates_lactose,
carbohydrates_starch,
carbohydrates_sucrose,
carbohydrates_sugars,
energy_gross,
fats_cholesterol,
fats_dha,
fats_epa,
fats_lauric,
fats_linoleic,
fats_linolenic,
fats_monounsaturated,
fats_myristic,
fats_palmitic,
fats_polyunsaturated,
fats_saturated,
fats_stearic,
fats_total,
minerals_calcium,
minerals_copper,
minerals_iron,
minerals_magnesium,
minerals_manganese,
minerals_phosphorus,
minerals_potassium,
minerals_selenium,
minerals_sodium,
minerals_zinc,
other_alcohol,
other_cost,
other_water,
other_weight,
phytonutrients_anthocyanins,
phytonutrients_caffeine,
phytonutrients_beta_carotene,
phytonutrients_carotenoids,
phytonutrients_flavanols,
phytonutrients_flavanones,
phytonutrients_flavones,
phytonutrients_flavonoids,
phytonutrients_flavonols,
phytonutrients_isoflavones,
phytonutrients_lutein_zeaxanthin,
phytonutrients_lycopene,
phytonutrients_phytosterols,
phytonutrients_theobromine,
phytonutrients_gamma_tocopherol,
protein_complete,
protein_total,
vitamins_vitamin_a,
vitamins_vitamin_b12,
vitamins_vitamin_b6,
vitamins_vitamin_c,
vitamins_choline,
vitamins_vitamin_d,
vitamins_vitamin_e,
vitamins_folate,
vitamins_vitamin_k,
vitamins_niacin,
vitamins_pantothenic_acid,
vitamins_riboflavin,
vitamins_thiamin,
carbohydrates_digestible,
energy_carbohydrate,
energy_fat,
energy_fat_and_carbohydrate,
energy_protein,
energy_alcohol,
energy_digestible,
fats_hcsfa,
fats_lcn3pufa
FROM (SELECT 
x0.Mixid,
x0.Foodid,
x205.q AS carbohydrates_carbs_by_diff,
x10018.q AS carbohydrates_fiber_insoluble,
x10017.q AS carbohydrates_fiber_soluble,
x291.q AS carbohydrates_fiber,
x212.q AS carbohydrates_fructose,
x211.q AS carbohydrates_glucose,
x10006.q AS carbohydrates_glycemic_load,
x213.q AS carbohydrates_lactose,
x209.q AS carbohydrates_starch,
x210.q AS carbohydrates_sucrose,
x269.q AS carbohydrates_sugars,
x208.q AS energy_gross,
x601.q AS fats_cholesterol,
x621.q AS fats_dha,
x629.q AS fats_epa,
x611.q AS fats_lauric,
x618.q AS fats_linoleic,
x619.q AS fats_linolenic,
x645.q AS fats_monounsaturated,
x612.q AS fats_myristic,
x613.q AS fats_palmitic,
x646.q AS fats_polyunsaturated,
x606.q AS fats_saturated,
x614.q AS fats_stearic,
x204.q AS fats_total,
x301.q AS minerals_calcium,
x312.q AS minerals_copper,
x303.q AS minerals_iron,
x304.q AS minerals_magnesium,
x315.q AS minerals_manganese,
x305.q AS minerals_phosphorus,
x306.q AS minerals_potassium,
x317.q AS minerals_selenium,
x307.q AS minerals_sodium,
x309.q AS minerals_zinc,
x221.q AS other_alcohol,
x10005.q AS other_cost,
x255.q AS other_water,
x10000.q AS other_weight,
x10024.q AS phytonutrients_anthocyanins,
x262.q AS phytonutrients_caffeine,
x321.q AS phytonutrients_beta_carotene,
x10019.q AS phytonutrients_carotenoids,
x10022.q AS phytonutrients_flavanols,
x10023.q AS phytonutrients_flavanones,
x10021.q AS phytonutrients_flavones,
x10026.q AS phytonutrients_flavonoids,
x10020.q AS phytonutrients_flavonols,
x10025.q AS phytonutrients_isoflavones,
x338.q AS phytonutrients_lutein_zeaxanthin,
x337.q AS phytonutrients_lycopene,
x636.q AS phytonutrients_phytosterols,
x263.q AS phytonutrients_theobromine,
x342.q AS phytonutrients_gamma_tocopherol,
x10001.q AS protein_complete,
x203.q AS protein_total,
x320.q AS vitamins_vitamin_a,
x418.q AS vitamins_vitamin_b12,
x415.q AS vitamins_vitamin_b6,
x401.q AS vitamins_vitamin_c,
x421.q AS vitamins_choline,
x328.q AS vitamins_vitamin_d,
x323.q AS vitamins_vitamin_e,
x435.q AS vitamins_folate,
x430.q AS vitamins_vitamin_k,
x406.q AS vitamins_niacin,
x410.q AS vitamins_pantothenic_acid,
x405.q AS vitamins_riboflavin,
x404.q AS vitamins_thiamin,
x10003.q AS carbohydrates_digestible,
x10011.q AS energy_carbohydrate,
x10013.q AS energy_fat,
x10010.q AS energy_fat_and_carbohydrate,
x10012.q AS energy_protein,
x10014.q AS energy_alcohol,
x10009.q AS energy_digestible,
x10015.q AS fats_hcsfa,
x10016.q AS fats_lcn3pufa
      FROM
      --
(SELECT mixid, foodid FROM mixfood WHERE mixid = v_MixId) x0,
           --      
--205, carbohydrates-carbs_by_diff
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '205') x205,
--10018, carbohydrates-fiber_insoluble
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10018') x10018,
--10017, carbohydrates-fiber_soluble
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10017') x10017,
--291, carbohydrates-fiber
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '291') x291,
--212, carbohydrates-fructose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '212') x212,
--211, carbohydrates-glucose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '211') x211,
--10006, carbohydrates-glycemic_load
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10006') x10006,
--213, carbohydrates-lactose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '213') x213,
--209, carbohydrates-starch
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '209') x209,
--210, carbohydrates-sucrose
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '210') x210,
--269, carbohydrates-sugars
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '269') x269,
--208, energy-gross
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '208') x208,
--601, fats-cholesterol
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '601') x601,
--621, fats-dha
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '621') x621,
--629, fats-epa
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '629') x629,
--611, fats-lauric
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '611') x611,
--618, fats-linoleic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '618') x618,
--619, fats-linolenic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '619') x619,
--645, fats-monounsaturated
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '645') x645,
--612, fats-myristic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '612') x612,
--613, fats-palmitic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '613') x613,
--646, fats-polyunsaturated
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '646') x646,
--606, fats-saturated
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '606') x606,
--614, fats-stearic
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '614') x614,
--204, fats-total
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '204') x204,
--301, minerals-calcium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '301') x301,
--312, minerals-copper
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '312') x312,
--303, minerals-iron
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '303') x303,
--304, minerals-magnesium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '304') x304,
--315, minerals-manganese
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '315') x315,
--305, minerals-phosphorus
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '305') x305,
--306, minerals-potassium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '306') x306,
--317, minerals-selenium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '317') x317,
--307, minerals-sodium
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '307') x307,
--309, minerals-zinc
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '309') x309,
--221, other-alcohol
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '221') x221,
--10005, other-cost
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10005') x10005,
--255, other-water
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '255') x255,
--10000, other-weight
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10000') x10000,
--10024, phytonutrients-anthocyanins
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10024') x10024,
--262, phytonutrients-caffeine
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '262') x262,
--321, phytonutrients-beta_carotene
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '321') x321,
--10019, phytonutrients-carotenoids
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10019') x10019,
--10022, phytonutrients-flavanols
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10022') x10022,
--10023, phytonutrients-flavanones
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10023') x10023,
--10021, phytonutrients-flavones
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10021') x10021,
--10026, phytonutrients-flavonoids
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10026') x10026,
--10020, phytonutrients-flavonols
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10020') x10020,
--10025, phytonutrients-isoflavones
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10025') x10025,
--338, phytonutrients-lutein_zeaxanthin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '338') x338,
--337, phytonutrients-lycopene
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '337') x337,
--636, phytonutrients-phytosterols
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '636') x636,
--263, phytonutrients-theobromine
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '263') x263,
--342, phytonutrients-gamma_tocopherol
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '342') x342,
--10001, protein-complete
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10001') x10001,
--203, protein-total
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '203') x203,
--320, vitamins-vitamin_a
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '320') x320,
--418, vitamins-vitamin_b12
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '418') x418,
--415, vitamins-vitamin_b6
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '415') x415,
--401, vitamins-vitamin_c
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '401') x401,
--421, vitamins-choline
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '421') x421,
--328, vitamins-vitamin_d
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '328') x328,
--323, vitamins-vitamin_e
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '323') x323,
--435, vitamins-folate
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '435') x435,
--430, vitamins-vitamin_k
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '430') x430,
--406, vitamins-niacin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '406') x406,
--410, vitamins-pantothenic_acid
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '410') x410,
--405, vitamins-riboflavin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '405') x405,
--404, vitamins-thiamin
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '404') x404,
--10003, carbohydrates-digestible
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10003') x10003,
--10011, energy-carbohydrate
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10011') x10011,
--10013, energy-fat
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10013') x10013,
--10010, energy-fat_and_carbohydrate
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10010') x10010,
--10012, energy-protein
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10012') x10012,
--10014, energy-alcohol
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10014') x10014,
--10009, energy-digestible
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10009') x10009,
--10015, fats-hcsfa
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10015') x10015,
--10016, fats-lcn3pufa
(SELECT mixid,
        foodid,
        q
FROM mixresult
WHERE mixid = v_MixId
AND   nutrientid = '10016') x10016
      --      
WHERE x0.mixid = x205.mixid
AND x0.foodid = x205.foodid
AND x0.mixid = x10018.mixid
AND x0.foodid = x10018.foodid
AND x0.mixid = x10017.mixid
AND x0.foodid = x10017.foodid
AND x0.mixid = x291.mixid
AND x0.foodid = x291.foodid
AND x0.mixid = x212.mixid
AND x0.foodid = x212.foodid
AND x0.mixid = x211.mixid
AND x0.foodid = x211.foodid
AND x0.mixid = x10006.mixid
AND x0.foodid = x10006.foodid
AND x0.mixid = x213.mixid
AND x0.foodid = x213.foodid
AND x0.mixid = x209.mixid
AND x0.foodid = x209.foodid
AND x0.mixid = x210.mixid
AND x0.foodid = x210.foodid
AND x0.mixid = x269.mixid
AND x0.foodid = x269.foodid
AND x0.mixid = x208.mixid
AND x0.foodid = x208.foodid
AND x0.mixid = x601.mixid
AND x0.foodid = x601.foodid
AND x0.mixid = x621.mixid
AND x0.foodid = x621.foodid
AND x0.mixid = x629.mixid
AND x0.foodid = x629.foodid
AND x0.mixid = x611.mixid
AND x0.foodid = x611.foodid
AND x0.mixid = x618.mixid
AND x0.foodid = x618.foodid
AND x0.mixid = x619.mixid
AND x0.foodid = x619.foodid
AND x0.mixid = x645.mixid
AND x0.foodid = x645.foodid
AND x0.mixid = x612.mixid
AND x0.foodid = x612.foodid
AND x0.mixid = x613.mixid
AND x0.foodid = x613.foodid
AND x0.mixid = x646.mixid
AND x0.foodid = x646.foodid
AND x0.mixid = x606.mixid
AND x0.foodid = x606.foodid
AND x0.mixid = x614.mixid
AND x0.foodid = x614.foodid
AND x0.mixid = x204.mixid
AND x0.foodid = x204.foodid
AND x0.mixid = x301.mixid
AND x0.foodid = x301.foodid
AND x0.mixid = x312.mixid
AND x0.foodid = x312.foodid
AND x0.mixid = x303.mixid
AND x0.foodid = x303.foodid
AND x0.mixid = x304.mixid
AND x0.foodid = x304.foodid
AND x0.mixid = x315.mixid
AND x0.foodid = x315.foodid
AND x0.mixid = x305.mixid
AND x0.foodid = x305.foodid
AND x0.mixid = x306.mixid
AND x0.foodid = x306.foodid
AND x0.mixid = x317.mixid
AND x0.foodid = x317.foodid
AND x0.mixid = x307.mixid
AND x0.foodid = x307.foodid
AND x0.mixid = x309.mixid
AND x0.foodid = x309.foodid
AND x0.mixid = x221.mixid
AND x0.foodid = x221.foodid
AND x0.mixid = x10005.mixid
AND x0.foodid = x10005.foodid
AND x0.mixid = x255.mixid
AND x0.foodid = x255.foodid
AND x0.mixid = x10000.mixid
AND x0.foodid = x10000.foodid
AND x0.mixid = x10024.mixid
AND x0.foodid = x10024.foodid
AND x0.mixid = x262.mixid
AND x0.foodid = x262.foodid
AND x0.mixid = x321.mixid
AND x0.foodid = x321.foodid
AND x0.mixid = x10019.mixid
AND x0.foodid = x10019.foodid
AND x0.mixid = x10022.mixid
AND x0.foodid = x10022.foodid
AND x0.mixid = x10023.mixid
AND x0.foodid = x10023.foodid
AND x0.mixid = x10021.mixid
AND x0.foodid = x10021.foodid
AND x0.mixid = x10026.mixid
AND x0.foodid = x10026.foodid
AND x0.mixid = x10020.mixid
AND x0.foodid = x10020.foodid
AND x0.mixid = x10025.mixid
AND x0.foodid = x10025.foodid
AND x0.mixid = x338.mixid
AND x0.foodid = x338.foodid
AND x0.mixid = x337.mixid
AND x0.foodid = x337.foodid
AND x0.mixid = x636.mixid
AND x0.foodid = x636.foodid
AND x0.mixid = x263.mixid
AND x0.foodid = x263.foodid
AND x0.mixid = x342.mixid
AND x0.foodid = x342.foodid
AND x0.mixid = x10001.mixid
AND x0.foodid = x10001.foodid
AND x0.mixid = x203.mixid
AND x0.foodid = x203.foodid
AND x0.mixid = x320.mixid
AND x0.foodid = x320.foodid
AND x0.mixid = x418.mixid
AND x0.foodid = x418.foodid
AND x0.mixid = x415.mixid
AND x0.foodid = x415.foodid
AND x0.mixid = x401.mixid
AND x0.foodid = x401.foodid
AND x0.mixid = x421.mixid
AND x0.foodid = x421.foodid
AND x0.mixid = x328.mixid
AND x0.foodid = x328.foodid
AND x0.mixid = x323.mixid
AND x0.foodid = x323.foodid
AND x0.mixid = x435.mixid
AND x0.foodid = x435.foodid
AND x0.mixid = x430.mixid
AND x0.foodid = x430.foodid
AND x0.mixid = x406.mixid
AND x0.foodid = x406.foodid
AND x0.mixid = x410.mixid
AND x0.foodid = x410.foodid
AND x0.mixid = x405.mixid
AND x0.foodid = x405.foodid
AND x0.mixid = x404.mixid
AND x0.foodid = x404.foodid
AND x0.mixid = x10003.mixid
AND x0.foodid = x10003.foodid
AND x0.mixid = x10011.mixid
AND x0.foodid = x10011.foodid
AND x0.mixid = x10013.mixid
AND x0.foodid = x10013.foodid
AND x0.mixid = x10010.mixid
AND x0.foodid = x10010.foodid
AND x0.mixid = x10012.mixid
AND x0.foodid = x10012.foodid
AND x0.mixid = x10014.mixid
AND x0.foodid = x10014.foodid
AND x0.mixid = x10009.mixid
AND x0.foodid = x10009.foodid
AND x0.mixid = x10015.mixid
AND x0.foodid = x10015.foodid
AND x0.mixid = x10016.mixid
AND x0.foodid = x10016.foodid) a,
(SELECT foodid, name as food_name FROM food) b
WHERE a.foodid = b.foodid;
--
END;
/


CREATE PROCEDURE DnMixResult_delete (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
delete from DnMixResult where mix_id = v_MixId;
--
END;
/


--Compare Two 100 Kcal servings
CREATE PROCEDURE compareFoodItems (
--
IN v_food_a LONGVARCHAR,
IN v_food_b LONGVARCHAR
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.name,b.name,b.food_a,b.food_b,b.diff
FROM
(
SELECT nutrientcategoryid, name
FROM nutrientcategory) A,
(
SELECT
       b.nutrientcategoryid,
       b.nutrientid,
       b.name,
       a.food_a as food_a,
       a.food_b as food_b,
       a.diff as diff
FROM (
--
SELECT a.nutrientid,
       a.value AS food_a,
       b.value AS food_b,
       a.value - b.value AS diff
FROM (SELECT nutrientid, CASE WHEN get_foodfact(v_food_a,'10009') <= 0 THEN 0 ELSE q / get_foodfact(v_food_a,'10009') * 100 END AS value
      FROM foodfact
      WHERE foodid = v_food_a) a,
     (SELECT nutrientid, CASE WHEN get_foodfact(v_food_b,'10009') <= 0 THEN 0 ELSE q / get_foodfact(v_food_b,'10009') * 100 END AS value
      FROM foodfact
      WHERE foodid = v_food_b) b
WHERE a.nutrientid = b.nutrientid
--
) a,
(SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
WHERE a.nutrientid = b.nutrientid) B
WHERE a.nutrientcategoryid = b.nutrientcategoryid
ORDER BY a.name, b.name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE pin_and_keep_constraints (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA  BEGIN ATOMIC
--
DELETE FROM FoodQuantityC WHERE MixId = v_mixid AND relationshipid = 3;
INSERT INTO FoodQuantityC
SELECT mixid,foodid,'10000' as nutrientid,3 as relationshipid,x as b
FROM mixfood
WHERE mixid = v_mixid;

--
END;
/


CREATE PROCEDURE pin_and_delete_constraints (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA  BEGIN ATOMIC
--
DELETE FROM NutrientQuantityC WHERE MixId = v_mixid;
DELETE FROM FoodQuantityC WHERE MixId = v_mixid;
DELETE FROM FoodRatioC WHERE MixId = v_mixid;
DELETE FROM NutrientRatioC WHERE MixId = v_mixid;
INSERT INTO FoodQuantityC
SELECT mixid,foodid,'10000' as nutrientid,3 as relationshipid,x as b
FROM mixfood
WHERE mixid = v_mixid;

--
END;
/


CREATE PROCEDURE Meal_insert (
OUT NEWID INTEGER,
IN v_MixId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_MealOrder INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Meal (
MixId,
MealId,
Name,
MealOrder
) VALUES (
v_MixId,
DEFAULT,
v_Name,
v_MealOrder
);
SET NEWID=IDENTITY();
END;
/

CREATE PROCEDURE MealFoodPortion_insert (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE,
IN v_ExpectedWt DOUBLE,
IN v_ActualWt DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO MealFoodPortion (
MixId,
MealId,
FoodId,
Pct,
ExpectedWt,
ActualWt
) VALUES (
v_MixId,
v_MealId,
v_FoodId,
v_Pct,
v_ExpectedWt,
v_ActualWt
);
END;
/


CREATE PROCEDURE MealFoodPortion_merge_01 (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE,
IN v_ExpectedWt DOUBLE,
IN v_ActualWt DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO MealFoodPortion USING ( VALUES (
v_MixId,
v_MealId,
v_FoodId,
v_Pct,
v_ExpectedWt,
v_ActualWt
) ) ON (
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
Pct = v_Pct
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_MealId,
v_FoodId,
v_Pct,
v_ExpectedWt,
v_ActualWt;
END;
/

CREATE PROCEDURE MealFoodPortion_update_expectedwt (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE MealFoodPortion
SET
ExpectedWt = (SELECT b.x*a.pct
                     FROM mealfoodportion a,
                          mixfood b
                     WHERE a.mixid = v_MixId
                     AND   a.mealid = v_MealId
                     AND  a.mixid = b.mixid
                     AND   a.foodid = b.foodid
                     AND   a.foodid = v_FoodId)
WHERE
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId;
END;
/

CREATE PROCEDURE allocate (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
FOR SELECT mixid,foodid FROM mixfood WHERE mixid = v_MixId DO
FOR SELECT mealid FROM meal DO
CALL MealFoodPortion_update_expectedwt(mixid,mealid, foodid);
END FOR;
END FOR;
--
END;
/


CREATE PROCEDURE Meal_select_all 
(
  IN V_MixId LONGVARCHAR
) 
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 
BEGIN ATOMIC 
DECLARE result CURSOR
FOR
SELECT MixId,
       MealId,
       Name,       
       MealOrder
FROM Meal
WHERE MixId = V_MixId
ORDER BY MealOrder;

OPEN result;

END;
/

CREATE PROCEDURE Meal_delete (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM Meal
WHERE
MixId = v_MixId AND
MealId = v_MealId;
END;
/

CREATE PROCEDURE MealFoodPortion_select_all (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT MixId,
       c.MealId,
       b.FoodId,
       c.Name,
       b.Name,
       a.Pct * 100,
       a.ExpectedWt,
       a.ActualWt,
       c.MealOrder
FROM MealFoodPortion a,
     Food b, Meal c
WHERE a.foodid = b.foodid
AND a.mealid = c.mealid
AND a.mixid = c.mixid
AND   a.MixId = v_MixId
ORDER BY c.MealOrder,b.Name;
OPEN result;
END;
/

CREATE PROCEDURE MealFoodPortion_insert_and_calculate (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
DECLARE v_Pct_d DOUBLE;
SET v_Pct_d = v_Pct/100;
CALL MealFoodPortion_merge_01(v_MixId,v_MealId,v_FoodId,v_Pct_d,null,0);
CALL MealFoodPortion_update_expectedwt(v_MixId,v_MealId,v_FoodId);
END;
/


CREATE PROCEDURE MealFoodPortion_delete (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM MealFoodPortion
WHERE
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId;
END;
/

CREATE PROCEDURE MealFoodPortion_update_actualwt (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_ActualWt DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE MealFoodPortion
SET
ActualWt = v_ActualWt
WHERE
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId;
END;
/

CREATE PROCEDURE Meal_update (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_Name LONGVARCHAR,
IN v_MealOrder INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE Meal
SET
Name = v_Name,
MealOrder = v_MealOrder
WHERE
MixId = v_MixId AND
MealId = v_MealId;
END;
/

CREATE PROCEDURE Select_meal_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
--
BEGIN ATOMIC
--
DECLARE doc LONGVARCHAR;
--
SET doc = CHAR(10) + '<meal_list>' + CHAR(10);
--
FOR SELECT mixid, mealid, name, mealorder FROM meal WHERE mixid = v_MixId ORDER BY mealorder DO
--
SET doc = doc +  '<meal>' + CHAR(10) + '<mix-id>' + mixid + '</mix-id>' + CHAR(10)  + '<meal-id>' + mealid + '</meal-id>' + CHAR(10) + '<meal-name>' + escape_xml_element_data(name) + '</meal-name>' + CHAR(10)  + '<meal-order>'  + mealorder + '</meal-order>' + CHAR(10) + '</meal>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</meal_list>';
--
SET v_doc = doc;
--
END
/


CREATE PROCEDURE Select_meal_food_portion_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
--
SET doc = CHAR(10) + '<meal_food_portion_list>' + CHAR(10) ;
--
FOR SELECT mixid, mealid, foodid, pct, expectedwt, actualwt FROM mealfoodportion WHERE mixid = v_MixId ORDER BY mealid, foodid DO
--
SET doc = doc +  '<meal_food_portion>' + CHAR (10) + '<mix-id>' + mixid + '</mix-id>' + CHAR (10) + '<meal-id>' + mealid + '</meal-id>' + CHAR (10) + '<food-id>' + foodid + '</food-id>' + CHAR (10) + '<pct>' + pct + '</pct>' + CHAR (10) + '<expected-wt>' + expectedwt + '</expected-wt>' + CHAR (10) + '<actual-wt>' + actualwt + '</actual-wt>'  + CHAR (10) + '</meal_food_portion>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</meal_food_portion_list>';
--
SET v_doc = doc;
--
END
/

CREATE PROCEDURE exportMixModel (IN v_MixId LONGVARCHAR)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE TABLE temp ( txt LONGVARCHAR);
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
--
SET doc = '';
--SET doc2 = '<snack' + CHAR(10) + 'xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''' + CHAR(10) + 'xsi:noNamespaceSchemaLocation=''https://xjrga.github.io/schemas/snack_v8.xsd''>' + CHAR (10);
SET doc2 = '<snack' + CHAR(10) + 'xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''' + CHAR(10) + '>';
--
call Select_mix_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_mixfood_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_nutrient_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_nutrient_ratio_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
call Select_foodnutrient_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_foodnutrient_ratio_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_meal_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
call Select_meal_food_portion_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
SET doc2 = doc2 + CHAR(10) + '</snack>';
--
INSERT INTO temp (txt) VALUES (doc2);
--
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT *
FROM temp;
--
OPEN result;
--
END;
--
END
/


CREATE PROCEDURE Meal_insert_02 (
IN v_MixId LONGVARCHAR,
--TODO - Fix, should be integer
IN v_MealId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_MealOrder INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Meal (
MixId,
MealId,
Name,
MealOrder
) VALUES (
v_MixId,
v_MealId,
v_Name,
v_MealOrder
);
END;
/

CREATE PROCEDURE meal_copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO meal
(
  mixid,
  mealid,  
  name,
  mealorder
)
SELECT v_MixId_New,
       mealid,  
       name,
       mealorder
FROM Meal
WHERE mixid = v_MixId_Old;
--
END;
/



CREATE PROCEDURE meal_food_portion_copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO mealfoodportion
(
  mixid,
  mealid,  
  foodid,
  pct,
  expectedwt,
  actualwt
)
SELECT v_MixId_New,
       mealid,  
       foodid,
       pct,
       expectedwt,
       actualwt
FROM mealfoodportion
WHERE mixid = v_MixId_Old;
--
END;
/



CREATE PROCEDURE Mix_Duplicate (
--
OUT newid LONGVARCHAR,
--
IN v_MixId_Old LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_MixId_New LONGVARCHAR;
--
call mix_copy(v_MixId_New,v_MixId_Old);
--
call mixfood_copy(v_MixId_Old,v_MixId_New);
--
CALL MixResult_Copy(v_MixId_Old,v_MixId_New);
--
CALL NutrientConstraint_Copy(v_MixId_Old,v_MixId_New);
--
CALL NutrientRatio_Copy(v_MixId_Old,v_MixId_New);
--
CALL FoodNutrientConstraint_Copy(v_MixId_Old,v_MixId_New);
--
CALL FoodNutrientRatio_Copy(v_MixId_Old,v_MixId_New);
--
CALL DnMixResult_copy(v_MixId_Old,v_MixId_New);
--
CALL meal_copy(v_MixId_Old,v_MixId_New);
--
CALL meal_food_portion_copy(v_MixId_Old,v_MixId_New);
--
SET newid = v_MixId_New;
--
END;
/

CREATE PROCEDURE results_by_meal_select (IN v_MixId LONGVARCHAR)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR
FOR
--
SELECT a.name,
       a.amt AS weight,
       b.amt AS egross,
       c.amt AS edigest,
       d.amt AS efat,
       e.amt AS ecarbs,
       m.amt AS efatcarbs,
       f.amt AS eprotein,
       g.amt AS ealcohol,
       h.amt AS fat,
       i.amt AS carbs,
       j.amt AS protein,
       k.amt AS complete,
       l.amt AS alcohol,
       n.amt AS fiber,
       o.amt AS sodium,
       p.amt AS potassium
FROM
--
(SELECT a.name,
        a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10000'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) A,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '208'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) B,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10009'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) C,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10013'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) D,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10011'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) E,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10012'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) F,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10014'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) G,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '204'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) H,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10003'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) I,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '203'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) J,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10001'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) K,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '221'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) L,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10010'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) M,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '291'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) N,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '307'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) O,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '306'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) P
--
WHERE a.mealorder = b.mealorder
AND   a.mealorder = c.mealorder
AND   a.mealorder = d.mealorder
AND   a.mealorder = e.mealorder
AND   a.mealorder = f.mealorder
AND   a.mealorder = g.mealorder
AND   a.mealorder = h.mealorder
AND   a.mealorder = i.mealorder
AND   a.mealorder = j.mealorder
AND   a.mealorder = k.mealorder
AND   a.mealorder = l.mealorder
AND   a.mealorder = m.mealorder
AND   a.mealorder = n.mealorder
AND   a.mealorder = o.mealorder
AND   a.mealorder = p.mealorder
--
UNION
--
SELECT 'Total' AS name,
       a.amt AS weight,
       b.amt AS egross,
       c.amt AS edigest,
       d.amt AS efat,
       e.amt AS ecarbs,
       m.amt AS efatcarbs,
       f.amt AS eprotein,
       g.amt AS ealcohol,
       h.amt AS fat,
       i.amt AS carbs,
       j.amt AS protein,
       k.amt AS complete,
       l.amt AS alcohol,
       n.amt AS fiber,
       o.amt AS sodium,
       p.amt AS potassium
FROM
--
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10000') A,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '208') B,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10009') C,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10013') D,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10011') E,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10012') F,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10014') G,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '204') H,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10003') I,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '203') J,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10001') K,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '221') L,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10010') M,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '291') N,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '307') O,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '306') P;
--
OPEN result;
--
END;
/


CREATE PROCEDURE foodfact_calculated_quantities_update (
IN v_foodid LONGVARCHAR
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE v_carbsbydiff DECIMAL(25,18)
;
DECLARE v_fiber DECIMAL(25,18)
;
DECLARE v_digestible_carbohydrate DECIMAL(25,18)
;
DECLARE v_energy_alcohol DECIMAL(25,18)
;
DECLARE v_energy_carbohydrate DECIMAL(25,18)
;
DECLARE v_energy_fat DECIMAL(25,18)
;
DECLARE v_energy_protein DECIMAL(25,18)
;
DECLARE v_gi DECIMAL(25,18)
;
DECLARE v_lauric DECIMAL(25,18)
;
DECLARE v_myristic DECIMAL(25,18)
;
DECLARE v_palmitic DECIMAL(25,18)
;
DECLARE v_hcsfa DECIMAL(25,18)
;
DECLARE v_dha DECIMAL(25,18)
;
DECLARE v_epa DECIMAL(25,18)
;
DECLARE v_lcn3pufa DECIMAL(25,18)
;
--
--digestible_carbohydrate
SELECT q INTO v_carbsbydiff FROM foodfact WHERE nutrientid = '205' AND foodid = v_foodid;
SELECT q INTO v_fiber FROM foodfact  WHERE nutrientid = '291' AND foodid = v_foodid;
SET v_digestible_carbohydrate = v_carbsbydiff - v_fiber;
CALL foodfact_merge (v_foodid,'10003',v_digestible_carbohydrate);
--
-- energy_alcohol
SELECT q * 6.93 INTO v_energy_alcohol FROM foodfact  WHERE nutrientid = '221' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10014',v_energy_alcohol);
--
-- energy_carbohydrate
SELECT q * 4 INTO v_energy_carbohydrate FROM foodfact  WHERE nutrientid = '10003' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10011',v_energy_carbohydrate);
--
-- energy_fat
SELECT q * 9 INTO v_energy_fat FROM foodfact  WHERE nutrientid = '204' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10013',v_energy_fat);
--
-- energy_protein
SELECT q * 4.7 INTO v_energy_protein FROM foodfact  WHERE nutrientid = '203' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10012',v_energy_protein);
--
-- energy_fat_and_carbohydrate
CALL foodfact_merge (v_foodid,'10010',v_energy_carbohydrate+v_energy_fat);
--
-- energy_digestible
CALL foodfact_merge (v_foodid,'10009',v_energy_carbohydrate+v_energy_fat+v_energy_protein+v_energy_alcohol);
--
--hcsfa
SELECT q INTO v_lauric FROM foodfact WHERE nutrientid = '611' AND foodid = v_foodid;
SELECT q INTO v_myristic FROM foodfact  WHERE nutrientid = '612' AND foodid = v_foodid;
SELECT q INTO v_palmitic FROM foodfact  WHERE nutrientid = '613' AND foodid = v_foodid;
SET v_hcsfa = v_lauric + v_myristic + v_palmitic;
CALL foodfact_merge (v_foodid,'10015',v_hcsfa);
--
--lcn3pufa
SELECT q INTO v_dha FROM foodfact WHERE nutrientid = '621' AND foodid = v_foodid;
SELECT q INTO v_epa FROM foodfact  WHERE nutrientid = '629' AND foodid = v_foodid;
SET v_lcn3pufa = v_dha + v_epa;
CALL foodfact_merge (v_foodid,'10016',v_lcn3pufa);
--
--
END;
/

CREATE PROCEDURE exportCategoryToXml(
--
IN vFoodCategoryId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE TABLE temp ( txt LONGVARCHAR);
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
--
SET doc = '';
SET doc2 = '';
--
SET doc2 = '<foods xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''>' + CHAR(10);
------------------------------------------------------------
FOR SELECT a.foodid AS id, a.name, c.foodcategoryid as categoryid, c.name as categoryname FROM food a, categorylink b, foodcategory c WHERE a.foodid = b.foodid AND b.foodcategoryid = c.foodcategoryid AND c.foodcategoryid = vFoodCategoryId DO
--
SET doc = '<food>' +CHAR(10)+'<food-id>'+id +'</food-id>' +CHAR (10) + '<food-name>'+ escape_xml_element_data(name) +'</food-name>' +CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT * FROM (SELECT NUTRIENTID, LABEL, UNITS, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = id AND   Y.NUTRIENTID = Z.NUTRIENTID AND   (Y.NUTRIENTID != '10003' AND Y.NUTRIENTID != '10009' AND Y.NUTRIENTID != '10010' AND Y.NUTRIENTID != '10011' AND Y.NUTRIENTID != '10012' AND Y.NUTRIENTID != '10013' AND Y.NUTRIENTID != '10014' AND Y.NUTRIENTID != '10015' AND Y.NUTRIENTID != '10016')) ORDER BY LABEL DO
--
SET doc = '<'+label +' '+'units="'+units+'" '+'nutr_no="'+nutrientid+'" '+'>'+ q +'</'+label +'>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc2 = doc2 + '<category-list>'+ CHAR (10);
--
SET doc = '<category>'+ CHAR (10) + '<category-id>' + categoryid + '</category-id>' + CHAR (10) + '<category-name>' + categoryname + '</category-name>' + CHAR (10) + '</category>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
SET doc2 = doc2 + '</category-list>'+ CHAR (10);
--
SET doc2 = doc2 + '</food>' + CHAR (10);
--
END FOR;
--
SET doc2 = doc2 + '</foods>';
--
INSERT INTO temp (txt) VALUES (doc2);
--
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT *
FROM temp;
--
OPEN result;
--
END;
--
END
/


CREATE PROCEDURE getMixNutrients (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT DISTINCT nutrientid
FROM (SELECT nutrientid
      FROM NutrientQuantityC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM NutrientRatioC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM NutrientRatioC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrientid
      FROM FoodQuantityC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM FoodRatioC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM FoodRatioC
      WHERE mixid = v_mixid)
ORDER BY nutrientid;
--
OPEN result;

--
END;
/


CREATE PROCEDURE getMixFoods(IN v_MixId LONGVARCHAR)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT FoodId
FROM MixFood
WHERE MixId = v_MixId
ORDER BY FoodId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE getMixCoefficientsAll (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT b.foodid,
       b.nutrientid,
       getfoodcoefficient(b.foodid,b.nutrientid) AS c
FROM mixfood a,
     foodfactcoefficient b,
     nutrient c
WHERE a.foodid = b.foodid
AND   b.nutrientid = c.nutrientid
AND   a.mixid = v_mixid
ORDER BY b.foodid,
         b.nutrientid;
--
OPEN result;

--
END;
/


CREATE PROCEDURE getMixNutrientsAll (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT
NutrientId,
Name
FROM
Nutrient
ORDER BY nutrientid;
--
OPEN result;

--
END;
/


--TODO - fix - nutrients are missing
CREATE PROCEDURE getDriDn()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT -1 AS row,
       1 AS n10000,
       2 AS n10001,
       3 AS n10003,
       4 AS n10005,
       5 AS n10006,
       6 AS n10009,
       7 AS n10010,
       8 AS n10011,
       9 AS n10012,
       10 AS n10013,
       11 AS n10014,
       12 AS n10015,
       13 AS n10016,
       14 AS n203,
       15 AS n204,
       16 AS n205,
       17 AS n208,
       18 AS n221,
       19 AS n255,
       20 AS n291,
       21 AS n301,
       22 AS n303,
       23 AS n304,
       24 AS n305,
       25 AS n306,
       26 AS n307,
       27 AS n309,
       28 AS n312,
       29 AS n315,
       30 AS n317,
       31 AS n320,
       32 AS n323,
       33 AS n328,
       34 AS n401,
       35 AS n404,
       36 AS n405,
       37 AS n406,
       38 AS n410,
       39 AS n415,
       40 AS n418,
       41 AS n421,
       42 AS n430,
       43 AS n435,
       44 AS n601,
       45 AS n606,
       46 AS n611,
       47 AS n612,
       48 AS n613,
       49 AS n614,
       50 AS n618,
       51 AS n619,
       52 AS n621,
       53 AS n629,
       54 AS n645,
       55 AS n646
FROM (
     VALUES (0))
UNION
SELECT a.lifestageid+1,
       0.0 AS "n10000",
       a.q AS "n10001",
       b.q AS "n10003",
       0.0 AS "n10005",
       0.0 AS "n10006",
       0.0 AS "n10009",
       0.0 AS "n10010",
       0.0 AS "n10011",
       0.0 AS "n10012",
       0.0 AS "n10013",
       0.0 AS "n10014",
       0.0 AS "n10015",
       0.0 AS "n10016",
       0.0 AS "n203",
       c.q AS "n204",
       0.0 AS "n205",
       0.0 AS "n208",
       0.0 AS "n221",
       d.q AS "n255",
       e.q AS "n291",
       f.q AS "n301",
       g.q AS "n303",
       h.q AS "n304",
       i.q AS "n305",
       j.q AS "n306",
       k.q AS "n307",
       l.q AS "n309",
       m.q AS "n312",
       n.q AS "n315",
       o.q AS "n317",
       p.q AS "n320",
       q.q AS "n323",
       r.q AS "n328",
       s.q AS "n401",
       t.q AS "n404",
       u.q AS "n405",
       v.q AS "n406",
       w.q AS "n410",
       x.q AS "n415",
       y.q AS "n418",
       z.q AS "n421",
       aa.q AS "n430",
       ab.q AS "n435",
       0.0 AS "n601",
       0.0 AS "n606",
       0.0 AS "n611",
       0.0 AS "n612",
       0.0 AS "n613",
       0.0 AS "n614",
       ac.q AS "n618",
       ad.q AS "n619",
       0.0 AS "n621",
       0.0 AS "n629",
       0.0 AS "n645",
       0.0 AS "n646"
FROM (SELECT lifestageid, q FROM Rda WHERE nutrientid = '10001') a,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '10003') b,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '204') c,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '255') d,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '291') e,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '301') f,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '303') g,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '304') h,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '305') i,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '306') j,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '307') k,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '309') l,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '312') m,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '315') n,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '317') o,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '320') p,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '323') q,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '328') r,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '401') s,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '404') t,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '405') u,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '406') v,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '410') w,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '415') x,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '418') y,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '421') z,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '430') aa,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '435') ab,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '618') ac,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '619') ad
WHERE a.lifestageid = a.lifestageid
AND   a.lifestageid = b.lifestageid
AND   a.lifestageid = c.lifestageid
AND   a.lifestageid = d.lifestageid
AND   a.lifestageid = e.lifestageid
AND   a.lifestageid = f.lifestageid
AND   a.lifestageid = g.lifestageid
AND   a.lifestageid = h.lifestageid
AND   a.lifestageid = i.lifestageid
AND   a.lifestageid = j.lifestageid
AND   a.lifestageid = k.lifestageid
AND   a.lifestageid = l.lifestageid
AND   a.lifestageid = m.lifestageid
AND   a.lifestageid = n.lifestageid
AND   a.lifestageid = o.lifestageid
AND   a.lifestageid = p.lifestageid
AND   a.lifestageid = q.lifestageid
AND   a.lifestageid = r.lifestageid
AND   a.lifestageid = s.lifestageid
AND   a.lifestageid = t.lifestageid
AND   a.lifestageid = u.lifestageid
AND   a.lifestageid = v.lifestageid
AND   a.lifestageid = w.lifestageid
AND   a.lifestageid = x.lifestageid
AND   a.lifestageid = y.lifestageid
AND   a.lifestageid = z.lifestageid
AND   a.lifestageid = aa.lifestageid
AND   a.lifestageid = ab.lifestageid
AND   a.lifestageid = ac.lifestageid
AND   a.lifestageid = ad.lifestageid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE MixCost_update (
--
IN v_MixId LONGVARCHAR,
--IN v_Name LONGVARCHAR,
--IN v_NutrientId LONGVARCHAR,
--IN v_Model LONGVARCHAR,
IN v_MixCost DECIMAL(25,18)
,
IN v_MixDeficiency DECIMAL(25,18)
,
IN v_MixExcess DECIMAL(25,18)

--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
Mix
SET
--Name = v_Name,
--NutrientId = v_NutrientId,
--Model = v_Model,
MixCost = v_MixCost,
MixDeficiency = v_MixDeficiency,
MixExcess = v_MixExcess
WHERE
MixId = v_MixId;
END;
--
/

CREATE PROCEDURE Units_insert (
--
IN v_UnitId INTEGER,
IN v_Name LONGVARCHAR,
IN v_Factor DOUBLE
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO Units (
UnitId,
Name,
Factor
) VALUES (
v_UnitId,
v_Name,
v_Factor
);
--
END;
/


CREATE PROCEDURE MixInventory_merge (
--
IN v_MixId LONGVARCHAR,
IN v_Days DOUBLE
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
MERGE INTO MixInventory USING ( VALUES (
v_MixId,
v_Days
) ) ON (
MixId = v_MixId
)
WHEN MATCHED THEN UPDATE SET
Days = v_Days
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_Days;
--
END;
/


CREATE PROCEDURE MixInventory_delete (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
MixInventory
WHERE
MixId = v_MixId;
--
END;
/


CREATE PROCEDURE MixInventorySum_select ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.foodid,
       a.name,
       a.grams AS g,
       b.ouncefactor*a.grams AS oz,
       c.lbfactor*a.grams AS lb,
       d.kgfactor*a.grams AS kg
FROM (SELECT b.foodid,
             c.name,
             SUM(b.x*a.days) AS grams
      FROM mixinventory a,
           mixfood b,
           food c
      WHERE a.mixid = b.mixid
      AND   b.foodid = c.foodid
      GROUP BY b.foodid,
               c.name
      ORDER BY c.name) a,
     (SELECT factor AS ouncefactor FROM units WHERE unitid = 2) b,
     (SELECT factor AS lbfactor FROM units WHERE unitid = 3) c,
     (SELECT factor AS kgfactor FROM units WHERE unitid = 4) d;
--
OPEN result;
--
END;
/


CREATE PROCEDURE FoodFact_N3LCPUFA()
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_NutrientIdB LONGVARCHAR;
--Fats, Long Chain n-3 PUFA (g)
SET v_NutrientIdB = '10016';
--
FOR SELECT a.foodid,
       a.epa + b.dha AS n3lcpufa
FROM (SELECT FOODID,Q AS epa
      FROM FOODFACT
      WHERE NUTRIENTID = '629') a,
     (SELECT FOODID, Q AS dha
      FROM FOODFACT
      WHERE NUTRIENTID = '621') b
WHERE a.foodid = b.foodid
--
DO
--
CALL FoodFact_Merge (FOODID,v_NutrientIdB,n3lcpufa);
--
END FOR;
--
END;
/


CREATE PROCEDURE getFoodFactsForMixItem(
IN v_MixId LONGVARCHAR
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name AS Category,
       b.Name AS Nutrient,
       sum(c.q) AS q
FROM NutrientCategory a,
     Nutrient b,
     MixResult c
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   b.NutrientId = c.NutrientId
AND c.MixId = v_MixId
AND (b.NutrientId != '10003' AND b.NutrientId != '10009' AND b.NutrientId != '10010' AND b.NutrientId != '10011' AND b.NutrientId != '10012' AND b.NutrientId != '10013' AND b.NutrientId != '10014' AND b.NutrientId != '10015' AND b.NutrientId != '10016')
GROUP BY NutrientId, Category, Nutrient
ORDER BY Category,Nutrient;
--
OPEN result;
--
END;
/

CREATE PROCEDURE MergeFoodCoefficients(
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
DECLARE v_c DECIMAL(25,18)
;
--
FOR SELECT nutrientid FROM nutrient DO
--
SET v_c = getFoodCoefficient(v_foodid,nutrientid);
--
call FoodFactCoefficient_Merge(v_foodid,nutrientid,v_c);
--
END FOR;
--
END;
/


CREATE PROCEDURE PrepareFoodData(
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
CALL foodfact_calculated_quantities_update(v_foodid);
CALL MergeFoodCoefficients(v_foodid);
CALL CopyFoodFactsToDenormalizedTable(v_foodid);
--
END;
/


CREATE VIEW tninutrients 
(
  nutrientid,
  name,
  label,
  units
)
AS
SELECT nutrientid,
       name,
       label,
       units
FROM public.nutrient
WHERE (nutrientid = '301' OR nutrientid = '304' OR nutrientid = '306' OR nutrientid = '320' OR nutrientid = '323' OR nutrientid = '328' OR nutrientid = '401' OR nutrientid = '421');
/


CREATE VIEW public.rdacoefficients 
(
  nutrientid,
  lifestageid,
  cq,
  cul
)
AS
SELECT nutrientid,
       lifestageid,
       casewhen(q <= 0.0,0.0,1.0 / q) AS cq,
       casewhen(ul <= 0.0,0.0,1.0 / ul) AS cul
FROM public.rda;
/


CREATE PROCEDURE dridev_objective_deficiency_lhs (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name,
             c
      FROM (SELECT foodid AS name,
                   0 AS c
            FROM mixfood
            WHERE mixid = v_mixid
            ORDER BY foodid)
      UNION ALL
      SELECT name,
             deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name,
             excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   0 AS excess
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             1 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             0 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE dridev_objective_lhs (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name,
             c
      FROM (SELECT foodid AS name,
                   0 AS c
            FROM mixfood
            WHERE mixid = v_mixid
            ORDER BY foodid)
      UNION ALL
      SELECT name,
             deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name,
             excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   0 AS excess
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             1 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             1 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE dridev_tni_rhs (
--
IN v_mixid LONGVARCHAR,
IN v_lifestageid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--Total Nutrient Index (Ca,Mg,K, VitA, VitE, VitD, VitC, Choline)
SELECT v_mixid AS mixid,
       nutrientid,
       relationshipid,
       d.q AS b,
       b.name AS nutrient,
       b.label AS nutrientlabel,
       c.name AS eq
FROM nutrient b,
     relationship c,
     rda d
WHERE relationshipid = 3
AND   (b.nutrientid = '301' OR b.nutrientid = '304' OR b.nutrientid = '306' OR b.nutrientid = '320' OR b.nutrientid = '323' OR b.nutrientid = '328' OR b.nutrientid = '401' OR b.nutrientid = '421')
AND b.nutrientid = d.nutrientid
AND d.lifestageid = v_lifestageid
ORDER BY nutrientid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE dridev_tni_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name, c
      FROM (SELECT a.foodid AS name,
                   b.c AS c
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE mixid = v_mixid
            AND   b.nutrientid = v_nutrientid
            AND   a.foodid = b.foodid
            ORDER BY foodid)
      UNION ALL
      SELECT name, deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   CASEWHEN(nutrientid = v_nutrientid,1.0,0) AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name, excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   CASEWHEN(nutrientid = v_nutrientid,-1.0,0) AS excess
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             0 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             0 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE dridev_nutrientquantity_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name, c
      FROM (SELECT a.foodid AS name,
                   b.c AS c
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE mixid = v_mixid
            AND   b.nutrientid = v_nutrientid
            AND   a.foodid = b.foodid
            ORDER BY foodid)
      UNION ALL
      SELECT name, deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name, excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   0 AS excess
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             0 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             0 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE dridev_nutrientratio_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_nutrientid1 LONGVARCHAR,
--
IN v_nutrientid2 LONGVARCHAR,
--
IN v_a DECIMAL,
--
IN v_b DECIMAL
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (SELECT a.foodid AS name,
             a.c*v_b - b.c*v_a AS c
      FROM (SELECT a.mixid,
                   a.foodid,
                   b.nutrientid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid) a,
           (SELECT a.mixid,
                   a.foodid,
                   b.nutrientid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid) b
      WHERE a.mixid = b.mixid
      AND   a.foodid = b.foodid
      AND   a.nutrientid = v_nutrientid1
      AND   b.nutrientid = v_nutrientid2
      AND   a.mixid = v_mixid
      UNION ALL
      SELECT name,
             deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name,
             excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   0 AS excess
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             0 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             0 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/           


CREATE PROCEDURE dridev_foodquantity_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (
SELECT a.foodid as name, 
       IFNULL(b.c,0) AS c
FROM
(SELECT foodid
FROM mixfood
WHERE mixid = v_mixid) a
LEFT JOIN 
(SELECT foodid,
        c
FROM foodfactcoefficient a
WHERE nutrientid = v_nutrientid
AND foodid = v_foodid
ORDER BY foodid
) b
ON a.foodid = b.foodid
UNION ALL
SELECT name, 
       deficiency
FROM (SELECT concat('deficiency_',nutrientid) AS name,
             0 AS deficiency
      FROM tninutrients
      ORDER BY nutrientid)
UNION ALL
SELECT name,
       excess
FROM (SELECT concat('excess_',nutrientid) AS name,
             0 AS excess
     FROM tninutrients
     ORDER BY nutrientid)
UNION ALL
SELECT 'avg_deficiency',
        0 AS avg_deficiency
FROM (VALUES (0))
UNION ALL
SELECT 'avg_excess',
        0 AS avg_excess
FROM (VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE dridev_foodratio_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_foodid1 LONGVARCHAR,
--
IN v_nutrientid1 LONGVARCHAR,
--
IN v_a DECIMAL,
--
IN v_foodid2 LONGVARCHAR,
--
IN v_nutrientid2 LONGVARCHAR,
--
IN v_b DECIMAL
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT rownum() AS x,
       name,
       c
FROM (SELECT foodid AS name,
             CASE
               WHEN foodid = v_foodid1 THEN (SELECT c
                                             FROM foodfactcoefficient
                                             WHERE foodid = v_foodid1
                                             AND   nutrientid = v_nutrientid1)
               ELSE 0
             END * v_b -
             CASE
               WHEN foodid = v_foodid2 THEN (SELECT c
                                             FROM foodfactcoefficient
                                             WHERE foodid = v_foodid2
                                             AND   nutrientid = v_nutrientid2)
               ELSE 0
             END * v_a AS c
      FROM mixfood
      WHERE mixid = v_mixid
      UNION ALL
      SELECT name,
             deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name,
             excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   0 AS excess
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             0 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             0 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/

CREATE PROCEDURE dridev_sum_deficiency_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_lifestageid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name, c
      FROM (SELECT a.foodid AS name,
                   0 AS c
            FROM mixfood a
            WHERE mixid = v_mixid
            ORDER BY foodid)
      UNION ALL
      SELECT name, deficiency
      FROM (SELECT concat('deficiency_',nutrientid) as name,
                   b.cq AS deficiency
            FROM tninutrients a,
                 rdacoefficients b
            WHERE a.nutrientid = b.nutrientid
            AND   b.lifestageid = v_lifestageid
            ORDER BY nutrientid)
      UNION ALL
      SELECT name, excess
      FROM (SELECT concat('excess_',nutrientid) as name,
                   0 AS excess
            FROM tninutrients a
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             -8 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             0 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE dridev_sum_excess_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_lifestageid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name, c
      FROM (SELECT a.foodid AS name,
                   0 AS c
            FROM mixfood a
            WHERE mixid = v_mixid
            ORDER BY foodid)
      UNION ALL
      SELECT name, deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients a
            ORDER BY nutrientid)
      UNION ALL
      SELECT name, excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   b.cq AS excess
            FROM tninutrients a,
                 rdacoefficients b
            WHERE a.nutrientid = b.nutrientid
            AND   b.lifestageid = v_lifestageid
            ORDER BY nutrientid            
)
      UNION ALL
      SELECT 'avg_deficiency',
             0 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             -8 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE uldev_sum_excess_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_lifestageid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name, c
      FROM (SELECT a.foodid AS name,
                   0 AS c
            FROM mixfood a
            WHERE mixid = v_mixid
            ORDER BY foodid)
      UNION ALL
      SELECT name, deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients a
            ORDER BY nutrientid)
      UNION ALL
      SELECT name, excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   b.cul AS excess
            FROM tninutrients a,
                 rdacoefficients b
            WHERE a.nutrientid = b.nutrientid
            AND   b.lifestageid = v_lifestageid
            ORDER BY nutrientid            
)
      UNION ALL
      SELECT 'avg_deficiency',
             0 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             -8 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/


CREATE PROCEDURE MixTotals (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1 
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT a.mix_id AS id,
       b.name AS name,
       now() AS date,
       SUM(other_weight) AS other_weight,
       SUM(energy_gross) AS energy_gross,
       SUM(energy_digestible) AS energy_digestible,
       SUM(energy_fat) AS energy_fat,
       SUM(energy_carbohydrate) AS energy_carbohydrate,
       SUM(energy_fat_and_carbohydrate) AS energy_fat_and_carbohydrate,
       SUM(energy_protein) AS energy_protein,
       SUM(energy_alcohol) AS energy_alcohol,
       SUM(fats_total) AS fats_total,
       SUM(carbohydrates_digestible) AS carbohydrates_digestible,
       SUM(protein_total) AS protein_total,
       SUM(other_alcohol) AS other_alcohol,
       SUM(energy_protein) AS energy_protein,
       SUM(protein_total) AS protein_total,
       SUM(protein_complete) AS protein_complete,
       SUM(energy_fat) AS energy_fat,
       SUM(fats_total) AS fats_total,
       SUM(fats_monounsaturated) AS fats_monounsaturated,
       SUM(fats_polyunsaturated) AS fats_polyunsaturated,
       SUM(fats_saturated) AS fats_saturated,
       SUM(fats_cholesterol) AS fats_cholesterol,
       SUM(fats_saturated) AS fats_saturated,
       SUM(fats_hcsfa) AS fats_hcsfa,
       SUM(fats_lauric) AS fats_lauric,
       SUM(fats_myristic) AS fats_myristic,
       SUM(fats_palmitic) AS fats_palmitic,
       SUM(fats_stearic) AS fats_stearic,
       SUM(fats_polyunsaturated) AS fats_polyunsaturated,
       SUM(fats_linoleic) AS fats_linoleic,
       SUM(fats_linolenic) AS fats_linolenic,
       SUM(fats_epa) AS fats_epa,
       SUM(fats_dha) AS fats_dha,
       SUM(fats_lcn3pufa) AS fats_lcn3pufa,
       SUM(energy_carbohydrate) AS energy_carbohydrate,
       SUM(carbohydrates_carbs_by_diff) AS carbohydrates_carbs_by_diff,
       SUM(carbohydrates_fiber) AS carbohydrates_fiber,
       SUM(carbohydrates_fiber_insoluble) AS carbohydrates_fiber_insoluble,
       SUM(carbohydrates_fiber_soluble) AS carbohydrates_fiber_soluble,
       SUM(carbohydrates_digestible) AS carbohydrates_digestible,
       SUM(carbohydrates_starch) AS carbohydrates_starch,
       SUM(carbohydrates_sugars) AS carbohydrates_sugars,
       SUM(carbohydrates_sucrose) AS carbohydrates_sucrose,
       SUM(carbohydrates_lactose) AS carbohydrates_lactose,
       SUM(carbohydrates_fructose) AS carbohydrates_fructose,
       SUM(carbohydrates_glucose) AS carbohydrates_glucose,
       SUM(carbohydrates_glycemic_load) AS carbohydrates_glycemic_load,
       SUM(vitamins_vitamin_a) AS vitamins_vitamin_a,
       SUM(vitamins_vitamin_d) AS vitamins_vitamin_d,
       SUM(vitamins_vitamin_e) AS vitamins_vitamin_e,
       SUM(vitamins_vitamin_c) AS vitamins_vitamin_c,
       SUM(vitamins_thiamin) AS vitamins_thiamin,
       SUM(vitamins_riboflavin) AS vitamins_riboflavin,
       SUM(vitamins_niacin) AS vitamins_niacin,
       SUM(vitamins_vitamin_b6) AS vitamins_vitamin_b6,
       SUM(vitamins_folate) AS vitamins_folate,
       SUM(vitamins_vitamin_b12) AS vitamins_vitamin_b12,
       SUM(vitamins_vitamin_k) AS vitamins_vitamin_k,
       SUM(vitamins_pantothenic_acid) AS vitamins_pantothenic_acid,
       SUM(vitamins_choline) AS vitamins_choline,
       SUM(minerals_calcium) AS minerals_calcium,
       SUM(minerals_phosphorus) AS minerals_phosphorus,
       SUM(minerals_magnesium) AS minerals_magnesium,
       SUM(minerals_iron) AS minerals_iron,
       SUM(minerals_zinc) AS minerals_zinc,
       SUM(minerals_copper) AS minerals_copper,
       SUM(minerals_manganese) AS minerals_manganese,
       SUM(minerals_selenium) AS minerals_selenium,
       SUM(minerals_potassium) AS minerals_potassium,
       SUM(minerals_sodium) AS minerals_sodium,
       SUM(phytonutrients_flavonoids) AS phytonutrients_flavonoids,
       SUM(phytonutrients_anthocyanins) AS phytonutrients_anthocyanins,
       SUM(phytonutrients_carotenoids) AS phytonutrients_carotenoids,
       SUM(phytonutrients_flavanols) AS phytonutrients_flavanols,
       SUM(phytonutrients_flavanones) AS phytonutrients_flavanones,
       SUM(phytonutrients_flavones) AS phytonutrients_flavones,
       SUM(phytonutrients_flavonols) AS phytonutrients_flavonols,
       SUM(phytonutrients_isoflavones) AS phytonutrients_isoflavones,
       SUM(phytonutrients_phytosterols) AS phytonutrients_phytosterols,
       SUM(phytonutrients_beta_carotene) AS phytonutrients_beta_carotene,
       SUM(phytonutrients_lutein_zeaxanthin) AS phytonutrients_lutein_zeaxanthin,
       SUM(phytonutrients_lycopene) AS phytonutrients_lycopene,
       SUM(phytonutrients_caffeine) AS phytonutrients_caffeine,
       SUM(phytonutrients_theobromine) AS phytonutrients_theobromine,
       SUM(phytonutrients_gamma_tocopherol) AS phytonutrients_gamma_tocopherol,
       SUM(other_cost) AS other_cost,
       SUM(other_water) AS other_water
FROM DnMixResult a,
     mix b
WHERE a.mix_id = v_MixId
AND   a.mix_id = b.mixid
GROUP BY a.mix_id,
         b.name;
--
OPEN result;
--
END;
/


CREATE VIEW MixInventoryDays
AS
SELECT a.mixid,
       b.name,
       a.days
FROM MixInventory a,
     Mix b
WHERE a.mixid = b.mixid
ORDER BY b.name
/



CREATE TRIGGER MixCost_rlau_trigger
AFTER UPDATE ON Mix
REFERENCING NEW AS new
FOR EACH ROW
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.DnMixResult_delete(new.mixid);
CALL public.fill_DnMixResult(new.mixid);
--
END;
/


CREATE TRIGGER MixCost_rlai_trigger
AFTER INSERT ON Mix
REFERENCING NEW AS new
FOR EACH ROW
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.DnMixResult_delete(new.mixid);
CALL public.fill_DnMixResult(new.mixid);
--
END;
/


