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
        GroupId LONGVARCHAR,
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
        GroupId LONGVARCHAR,
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
        Group_Id_1 LONGVARCHAR,
        Nutrient_Id_1 LONGVARCHAR,
        Group_Id_2 LONGVARCHAR,
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
        GroupId LONGVARCHAR,
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
