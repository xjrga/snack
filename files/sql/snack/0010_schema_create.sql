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
        carbohydrates_carbs_by_diff DECIMAL(16,10),
        carbohydrates_fiber_insoluble DECIMAL(16,10),
        carbohydrates_fiber_soluble DECIMAL(16,10),
        carbohydrates_fiber DECIMAL(16,10),
        carbohydrates_fructose DECIMAL(16,10),
        carbohydrates_glucose DECIMAL(16,10),
        carbohydrates_glycemic_load DECIMAL(16,10),
        carbohydrates_lactose DECIMAL(16,10),
        carbohydrates_starch DECIMAL(16,10),
        carbohydrates_sucrose DECIMAL(16,10),
        carbohydrates_sugars DECIMAL(16,10),
        energy_gross DECIMAL(16,10),
        fats_cholesterol DECIMAL(16,10),
        fats_dha DECIMAL(16,10),
        fats_epa DECIMAL(16,10),
        fats_lauric DECIMAL(16,10),
        fats_linoleic DECIMAL(16,10),
        fats_linolenic DECIMAL(16,10),
        fats_monounsaturated DECIMAL(16,10),
        fats_myristic DECIMAL(16,10),
        fats_palmitic DECIMAL(16,10),
        fats_polyunsaturated DECIMAL(16,10),
        fats_saturated DECIMAL(16,10),
        fats_stearic DECIMAL(16,10),
        fats_total DECIMAL(16,10),
        minerals_calcium DECIMAL(16,10),
        minerals_copper DECIMAL(16,10),
        minerals_iron DECIMAL(16,10),
        minerals_magnesium DECIMAL(16,10),
        minerals_manganese DECIMAL(16,10),
        minerals_phosphorus DECIMAL(16,10),
        minerals_potassium DECIMAL(16,10),
        minerals_selenium DECIMAL(16,10),
        minerals_sodium DECIMAL(16,10),
        minerals_zinc DECIMAL(16,10),
        other_alcohol DECIMAL(16,10),
        other_cost DECIMAL(16,10),
        other_water DECIMAL(16,10),
        other_weight DECIMAL(16,10),
        phytonutrients_anthocyanins DECIMAL(16,10),
        phytonutrients_caffeine DECIMAL(16,10),
        phytonutrients_beta_carotene DECIMAL(16,10),
        phytonutrients_carotenoids DECIMAL(16,10),
        phytonutrients_flavanols DECIMAL(16,10),
        phytonutrients_flavanones DECIMAL(16,10),
        phytonutrients_flavones DECIMAL(16,10),
        phytonutrients_flavonoids DECIMAL(16,10),
        phytonutrients_flavonols DECIMAL(16,10),
        phytonutrients_isoflavones DECIMAL(16,10),
        phytonutrients_lutein_zeaxanthin DECIMAL(16,10),
        phytonutrients_lycopene DECIMAL(16,10),
        phytonutrients_phytosterols DECIMAL(16,10),
        phytonutrients_theobromine DECIMAL(16,10),
        protein_complete DECIMAL(16,10),
        protein_total DECIMAL(16,10),
        vitamins_vitamin_a DECIMAL(16,10),
        vitamins_vitamin_b12 DECIMAL(16,10),
        vitamins_vitamin_b6 DECIMAL(16,10),
        vitamins_vitamin_c DECIMAL(16,10),
        vitamins_choline DECIMAL(16,10),
        vitamins_vitamin_d DECIMAL(16,10),
        vitamins_vitamin_e DECIMAL(16,10),
        vitamins_folate DECIMAL(16,10),
        vitamins_vitamin_k DECIMAL(16,10),
        vitamins_niacin DECIMAL(16,10),
        vitamins_pantothenic_acid DECIMAL(16,10),
        vitamins_riboflavin DECIMAL(16,10),
        vitamins_thiamin DECIMAL(16,10),
        carbohydrates_digestible DECIMAL(16,10),
        energy_carbohydrate DECIMAL(16,10),
        energy_fat DECIMAL(16,10),
        energy_fat_and_carbohydrate DECIMAL(16,10),
        energy_protein DECIMAL(16,10),
        energy_alcohol DECIMAL(16,10),
        energy_digestible DECIMAL(16,10),
        fats_hcsfa DECIMAL(16,10),
        fats_lcn3pufa DECIMAL(16,10),
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
        carbohydrates_carbs_by_diff DECIMAL(16,10),
        carbohydrates_fiber_insoluble DECIMAL(16,10),
        carbohydrates_fiber_soluble DECIMAL(16,10),
        carbohydrates_fiber DECIMAL(16,10),
        carbohydrates_fructose DECIMAL(16,10),
        carbohydrates_glucose DECIMAL(16,10),
        carbohydrates_glycemic_load DECIMAL(16,10),
        carbohydrates_lactose DECIMAL(16,10),
        carbohydrates_starch DECIMAL(16,10),
        carbohydrates_sucrose DECIMAL(16,10),
        carbohydrates_sugars DECIMAL(16,10),
        energy_gross DECIMAL(16,10),
        fats_cholesterol DECIMAL(16,10),
        fats_dha DECIMAL(16,10),
        fats_epa DECIMAL(16,10),
        fats_lauric DECIMAL(16,10),
        fats_linoleic DECIMAL(16,10),
        fats_linolenic DECIMAL(16,10),
        fats_monounsaturated DECIMAL(16,10),
        fats_myristic DECIMAL(16,10),
        fats_palmitic DECIMAL(16,10),
        fats_polyunsaturated DECIMAL(16,10),
        fats_saturated DECIMAL(16,10),
        fats_stearic DECIMAL(16,10),
        fats_total DECIMAL(16,10),
        minerals_calcium DECIMAL(16,10),
        minerals_copper DECIMAL(16,10),
        minerals_iron DECIMAL(16,10),
        minerals_magnesium DECIMAL(16,10),
        minerals_manganese DECIMAL(16,10),
        minerals_phosphorus DECIMAL(16,10),
        minerals_potassium DECIMAL(16,10),
        minerals_selenium DECIMAL(16,10),
        minerals_sodium DECIMAL(16,10),
        minerals_zinc DECIMAL(16,10),
        other_alcohol DECIMAL(16,10),
        other_cost DECIMAL(16,10),
        other_water DECIMAL(16,10),
        other_weight DECIMAL(16,10),
        phytonutrients_anthocyanins DECIMAL(16,10),
        phytonutrients_caffeine DECIMAL(16,10),
        phytonutrients_beta_carotene DECIMAL(16,10),
        phytonutrients_carotenoids DECIMAL(16,10),
        phytonutrients_flavanols DECIMAL(16,10),
        phytonutrients_flavanones DECIMAL(16,10),
        phytonutrients_flavones DECIMAL(16,10),
        phytonutrients_flavonoids DECIMAL(16,10),
        phytonutrients_flavonols DECIMAL(16,10),
        phytonutrients_isoflavones DECIMAL(16,10),
        phytonutrients_lutein_zeaxanthin DECIMAL(16,10),
        phytonutrients_lycopene DECIMAL(16,10),
        phytonutrients_phytosterols DECIMAL(16,10),
        phytonutrients_theobromine DECIMAL(16,10),
        protein_complete DECIMAL(16,10),
        protein_total DECIMAL(16,10),
        vitamins_vitamin_a DECIMAL(16,10),
        vitamins_vitamin_b12 DECIMAL(16,10),
        vitamins_vitamin_b6 DECIMAL(16,10),
        vitamins_vitamin_c DECIMAL(16,10),
        vitamins_choline DECIMAL(16,10),
        vitamins_vitamin_d DECIMAL(16,10),
        vitamins_vitamin_e DECIMAL(16,10),
        vitamins_folate DECIMAL(16,10),
        vitamins_vitamin_k DECIMAL(16,10),
        vitamins_niacin DECIMAL(16,10),
        vitamins_pantothenic_acid DECIMAL(16,10),
        vitamins_riboflavin DECIMAL(16,10),
        vitamins_thiamin DECIMAL(16,10),
        carbohydrates_digestible DECIMAL(16,10),
        energy_carbohydrate DECIMAL(16,10),
        energy_fat DECIMAL(16,10),
        energy_fat_and_carbohydrate DECIMAL(16,10),
        energy_protein DECIMAL(16,10),
        energy_alcohol DECIMAL(16,10),
        energy_digestible DECIMAL(16,10),
        fats_hcsfa DECIMAL(16,10),
        fats_lcn3pufa DECIMAL(16,10),
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
        q DECIMAL(16,10),
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
        c DECIMAL(16,10),
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
        b DECIMAL(16,10),
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
        A DECIMAL(16,10),
        B DECIMAL(16,10),
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
        Pct DECIMAL(16,10),
        ExpectedWt DECIMAL(16,10),
        ActualWt DECIMAL(16,10),
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
        NutrientId LONGVARCHAR,
        Model LONGVARCHAR,
        MixCost DECIMAL(16,10),
        MixDeficiency DECIMAL(16,10),
        MixExcess DECIMAL(16,10),
        CONSTRAINT Mix_primary_key PRIMARY KEY (
        MixId
        )
);
/
CREATE TABLE MixFood
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        x DECIMAL(16,10),
        CONSTRAINT MixFood_primary_key PRIMARY KEY (
        MixId,
        FoodId
        )
);
/
CREATE TABLE MixInventory
(
        MixId LONGVARCHAR,
        Days DECIMAL(16,10),
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
        q DECIMAL(16,10),
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
        b DECIMAL(16,10),
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
        A DECIMAL(16,10),
        B DECIMAL(16,10),
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
        q DECIMAL(16,10) DEFAULT 0.0,
        UL DECIMAL(16,10) DEFAULT 0.0,
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
        Factor DECIMAL(16,10),
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
ALTER TABLE Mix ADD CONSTRAINT R18_Mix FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE SET NULL;
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
