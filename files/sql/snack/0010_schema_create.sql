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
        carbohydrates_carbs_by_diff DECIMAL(24,18),
        carbohydrates_fiber_insoluble DECIMAL(24,18),
        carbohydrates_fiber_soluble DECIMAL(24,18),
        carbohydrates_fiber DECIMAL(24,18),
        carbohydrates_fructose DECIMAL(24,18),
        carbohydrates_glucose DECIMAL(24,18),
        carbohydrates_glycemic_load DECIMAL(24,18),
        carbohydrates_lactose DECIMAL(24,18),
        carbohydrates_starch DECIMAL(24,18),
        carbohydrates_sucrose DECIMAL(24,18),
        carbohydrates_sugars DECIMAL(24,18),
        energy_gross DECIMAL(24,18),
        fats_cholesterol DECIMAL(24,18),
        fats_dha DECIMAL(24,18),
        fats_epa DECIMAL(24,18),
        fats_lauric DECIMAL(24,18),
        fats_linoleic DECIMAL(24,18),
        fats_linolenic DECIMAL(24,18),
        fats_monounsaturated DECIMAL(24,18),
        fats_myristic DECIMAL(24,18),
        fats_palmitic DECIMAL(24,18),
        fats_polyunsaturated DECIMAL(24,18),
        fats_saturated DECIMAL(24,18),
        fats_stearic DECIMAL(24,18),
        fats_total DECIMAL(24,18),
        minerals_calcium DECIMAL(24,18),
        minerals_copper DECIMAL(24,18),
        minerals_iron DECIMAL(24,18),
        minerals_magnesium DECIMAL(24,18),
        minerals_manganese DECIMAL(24,18),
        minerals_phosphorus DECIMAL(24,18),
        minerals_potassium DECIMAL(24,18),
        minerals_selenium DECIMAL(24,18),
        minerals_sodium DECIMAL(24,18),
        minerals_zinc DECIMAL(24,18),
        other_alcohol DECIMAL(24,18),
        other_cost DECIMAL(24,18),
        other_water DECIMAL(24,18),
        other_weight DECIMAL(24,18),
        phytonutrients_anthocyanins DECIMAL(24,18),
        phytonutrients_caffeine DECIMAL(24,18),
        phytonutrients_beta_carotene DECIMAL(24,18),
        phytonutrients_carotenoids DECIMAL(24,18),
        phytonutrients_flavanols DECIMAL(24,18),
        phytonutrients_flavanones DECIMAL(24,18),
        phytonutrients_flavones DECIMAL(24,18),
        phytonutrients_flavonoids DECIMAL(24,18),
        phytonutrients_flavonols DECIMAL(24,18),
        phytonutrients_isoflavones DECIMAL(24,18),
        phytonutrients_lutein_zeaxanthin DECIMAL(24,18),
        phytonutrients_lycopene DECIMAL(24,18),
        phytonutrients_phytosterols DECIMAL(24,18),
        phytonutrients_theobromine DECIMAL(24,18),
        protein_complete DECIMAL(24,18),
        protein_total DECIMAL(24,18),
        vitamins_vitamin_a DECIMAL(24,18),
        vitamins_vitamin_b12 DECIMAL(24,18),
        vitamins_vitamin_b6 DECIMAL(24,18),
        vitamins_vitamin_c DECIMAL(24,18),
        vitamins_choline DECIMAL(24,18),
        vitamins_vitamin_d DECIMAL(24,18),
        vitamins_vitamin_e DECIMAL(24,18),
        vitamins_folate DECIMAL(24,18),
        vitamins_vitamin_k DECIMAL(24,18),
        vitamins_niacin DECIMAL(24,18),
        vitamins_pantothenic_acid DECIMAL(24,18),
        vitamins_riboflavin DECIMAL(24,18),
        vitamins_thiamin DECIMAL(24,18),
        carbohydrates_digestible DECIMAL(24,18),
        energy_carbohydrate DECIMAL(24,18),
        energy_fat DECIMAL(24,18),
        energy_fat_and_carbohydrate DECIMAL(24,18),
        energy_protein DECIMAL(24,18),
        energy_alcohol DECIMAL(24,18),
        energy_digestible DECIMAL(24,18),
        fats_hcsfa DECIMAL(24,18),
        fats_lcn3pufa DECIMAL(24,18),
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
        carbohydrates_carbs_by_diff DECIMAL(24,18),
        carbohydrates_fiber_insoluble DECIMAL(24,18),
        carbohydrates_fiber_soluble DECIMAL(24,18),
        carbohydrates_fiber DECIMAL(24,18),
        carbohydrates_fructose DECIMAL(24,18),
        carbohydrates_glucose DECIMAL(24,18),
        carbohydrates_glycemic_load DECIMAL(24,18),
        carbohydrates_lactose DECIMAL(24,18),
        carbohydrates_starch DECIMAL(24,18),
        carbohydrates_sucrose DECIMAL(24,18),
        carbohydrates_sugars DECIMAL(24,18),
        energy_gross DECIMAL(24,18),
        fats_cholesterol DECIMAL(24,18),
        fats_dha DECIMAL(24,18),
        fats_epa DECIMAL(24,18),
        fats_lauric DECIMAL(24,18),
        fats_linoleic DECIMAL(24,18),
        fats_linolenic DECIMAL(24,18),
        fats_monounsaturated DECIMAL(24,18),
        fats_myristic DECIMAL(24,18),
        fats_palmitic DECIMAL(24,18),
        fats_polyunsaturated DECIMAL(24,18),
        fats_saturated DECIMAL(24,18),
        fats_stearic DECIMAL(24,18),
        fats_total DECIMAL(24,18),
        minerals_calcium DECIMAL(24,18),
        minerals_copper DECIMAL(24,18),
        minerals_iron DECIMAL(24,18),
        minerals_magnesium DECIMAL(24,18),
        minerals_manganese DECIMAL(24,18),
        minerals_phosphorus DECIMAL(24,18),
        minerals_potassium DECIMAL(24,18),
        minerals_selenium DECIMAL(24,18),
        minerals_sodium DECIMAL(24,18),
        minerals_zinc DECIMAL(24,18),
        other_alcohol DECIMAL(24,18),
        other_cost DECIMAL(24,18),
        other_water DECIMAL(24,18),
        other_weight DECIMAL(24,18),
        phytonutrients_anthocyanins DECIMAL(24,18),
        phytonutrients_caffeine DECIMAL(24,18),
        phytonutrients_beta_carotene DECIMAL(24,18),
        phytonutrients_carotenoids DECIMAL(24,18),
        phytonutrients_flavanols DECIMAL(24,18),
        phytonutrients_flavanones DECIMAL(24,18),
        phytonutrients_flavones DECIMAL(24,18),
        phytonutrients_flavonoids DECIMAL(24,18),
        phytonutrients_flavonols DECIMAL(24,18),
        phytonutrients_isoflavones DECIMAL(24,18),
        phytonutrients_lutein_zeaxanthin DECIMAL(24,18),
        phytonutrients_lycopene DECIMAL(24,18),
        phytonutrients_phytosterols DECIMAL(24,18),
        phytonutrients_theobromine DECIMAL(24,18),
        protein_complete DECIMAL(24,18),
        protein_total DECIMAL(24,18),
        vitamins_vitamin_a DECIMAL(24,18),
        vitamins_vitamin_b12 DECIMAL(24,18),
        vitamins_vitamin_b6 DECIMAL(24,18),
        vitamins_vitamin_c DECIMAL(24,18),
        vitamins_choline DECIMAL(24,18),
        vitamins_vitamin_d DECIMAL(24,18),
        vitamins_vitamin_e DECIMAL(24,18),
        vitamins_folate DECIMAL(24,18),
        vitamins_vitamin_k DECIMAL(24,18),
        vitamins_niacin DECIMAL(24,18),
        vitamins_pantothenic_acid DECIMAL(24,18),
        vitamins_riboflavin DECIMAL(24,18),
        vitamins_thiamin DECIMAL(24,18),
        carbohydrates_digestible DECIMAL(24,18),
        energy_carbohydrate DECIMAL(24,18),
        energy_fat DECIMAL(24,18),
        energy_fat_and_carbohydrate DECIMAL(24,18),
        energy_protein DECIMAL(24,18),
        energy_alcohol DECIMAL(24,18),
        energy_digestible DECIMAL(24,18),
        fats_hcsfa DECIMAL(24,18),
        fats_lcn3pufa DECIMAL(24,18),
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
        q DECIMAL(24,18),
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
        c DECIMAL(24,18),
        CONSTRAINT FoodFactCoefficient_primary_key PRIMARY KEY (
        FoodId,
        NutrientId
        )
);
/
CREATE TABLE FoodNutrientConstraint
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DECIMAL(24,18),
        CONSTRAINT FoodNutrientConstraint_primary_key PRIMARY KEY (
        MixId,
        FoodId,
        NutrientId,
        RelationshipId
        )
);
/
CREATE TABLE FoodNutrientRatio
(
        MixId LONGVARCHAR,
        Food_Id_1 LONGVARCHAR,
        Nutrient_Id_1 LONGVARCHAR,
        Food_Id_2 LONGVARCHAR,
        Nutrient_Id_2 LONGVARCHAR,
        RelationshipId INTEGER,
        A DECIMAL(24,18),
        B DECIMAL(24,18),
        CONSTRAINT FoodNutrientRatio_primary_key PRIMARY KEY (
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
        Pct DECIMAL(24,18),
        ExpectedWt DECIMAL(24,18),
        ActualWt DECIMAL(24,18),
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
        MixCost DECIMAL(24,18),
        MixDeficiency DECIMAL(24,18),
        MixExcess DECIMAL(24,18),
        CONSTRAINT Mix_primary_key PRIMARY KEY (
        MixId
        )
);
/
CREATE TABLE MixFood
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        x DECIMAL(24,18),
        CONSTRAINT MixFood_primary_key PRIMARY KEY (
        MixId,
        FoodId
        )
);
/
CREATE TABLE MixInventory
(
        MixId LONGVARCHAR,
        Days DECIMAL(24,18),
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
        q DECIMAL(24,18),
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
CREATE TABLE NutrientConstraint
(
        MixId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DECIMAL(24,18),
        CONSTRAINT NutrientConstraint_primary_key PRIMARY KEY (
        MixId,
        NutrientId,
        RelationshipId
        )
);
/
CREATE TABLE NutrientRatio
(
        MixId LONGVARCHAR,
        Nutrient_Id_1 LONGVARCHAR,
        Nutrient_Id_2 LONGVARCHAR,
        RelationshipId INTEGER,
        A DECIMAL(24,18),
        B DECIMAL(24,18),
        CONSTRAINT NutrientRatio_primary_key PRIMARY KEY (
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
        q DECIMAL(24,18) DEFAULT 0.0,
        UL DECIMAL(24,18) DEFAULT 0.0,
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
        Factor DECIMAL(24,18),
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
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R7_FoodNutrientConstraint FOREIGN KEY (FoodId,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R8_FoodNutrientConstraint FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R9_FoodNutrientConstraint FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R10_FoodNutrientRatio FOREIGN KEY (Food_Id_1,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R11_FoodNutrientRatio FOREIGN KEY (Food_Id_2,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R12_FoodNutrientRatio FOREIGN KEY (Nutrient_Id_2) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R13_FoodNutrientRatio FOREIGN KEY (Nutrient_Id_1) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R14_FoodNutrientRatio FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE Meal ADD CONSTRAINT R15_Meal FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MealFoodPortion ADD CONSTRAINT R16_MealFoodPortion FOREIGN KEY (MealId,MixId) REFERENCES Meal (MealId,MixId) ON DELETE CASCADE;
/
ALTER TABLE MealFoodPortion ADD CONSTRAINT R17_MealFoodPortion FOREIGN KEY (FoodId,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE Mix ADD CONSTRAINT R18_Mix FOREIGN KEY (LifeStageId) REFERENCES RdaLifeStage (LifeStageId) ON DELETE SET NULL;
/
ALTER TABLE MixFood ADD CONSTRAINT R19_MixFood FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R20_MixFood FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MixInventory ADD CONSTRAINT R21_MixInventory FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R22_MixResult FOREIGN KEY (FoodId,NutrientId) REFERENCES FoodFactCoefficient (FoodId,NutrientId) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R23_MixResult FOREIGN KEY (FoodId,MixId) REFERENCES MixFood (FoodId,MixId) ON DELETE CASCADE;
/
ALTER TABLE Nutrient ADD CONSTRAINT R24_Nutrient FOREIGN KEY (NutrientCategoryId) REFERENCES NutrientCategory (NutrientCategoryId) ON DELETE SET NULL;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R25_NutrientConstraint FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R26_NutrientConstraint FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R27_NutrientConstraint FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R28_NutrientRatio FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R29_NutrientRatio FOREIGN KEY (Nutrient_Id_1) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R30_NutrientRatio FOREIGN KEY (Nutrient_Id_2) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R31_NutrientRatio FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE Rda ADD CONSTRAINT R32_Rda FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE Rda ADD CONSTRAINT R33_Rda FOREIGN KEY (LifeStageId) REFERENCES RdaLifeStage (LifeStageId) ON DELETE CASCADE;
/
