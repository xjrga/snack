CREATE TABLE CategoryLink
(
        FoodCategoryId LONGVARCHAR,
        FoodId LONGVARCHAR,
        CONSTRAINT CategoryLink_primary_key PRIMARY KEY (FoodCategoryId,FoodId)
);
/
CREATE TABLE Food
(
        FoodId LONGVARCHAR,
        Name LONGVARCHAR,
        CONSTRAINT Food_primary_key PRIMARY KEY (FoodId)
);
/
CREATE TABLE FoodCategory
(
        FoodCategoryId LONGVARCHAR,
        Name LONGVARCHAR,
        CONSTRAINT FoodCategory_primary_key PRIMARY KEY (FoodCategoryId)
);
/
CREATE TABLE FoodFact
(
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        q DOUBLE DEFAULT CAST(0 AS DOUBLE),
        CONSTRAINT FoodFact_primary_key PRIMARY KEY (FoodId,NutrientId)
);
/
CREATE TABLE FoodFactCoefficient
(
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        c DOUBLE,
        CONSTRAINT FoodFactCoefficient_primary_key PRIMARY KEY (FoodId,NutrientId)
);
/
CREATE TABLE FoodNutrientConstraint
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DOUBLE,
        CONSTRAINT FoodNutrientConstraint_primary_key PRIMARY KEY (MixId,FoodId,NutrientId,RelationshipId)
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
        A DOUBLE,
        B DOUBLE,
        CONSTRAINT FoodNutrientRatio_primary_key PRIMARY KEY (MixId,Food_Id_1,Nutrient_Id_1,Food_Id_2,Nutrient_Id_2,RelationshipId)
);
/
CREATE TABLE GlycemicIndex
(
        FoodId LONGVARCHAR,
        q DOUBLE,
        CONSTRAINT GlycemicIndex_primary_key PRIMARY KEY (FoodId)
);
/
CREATE TABLE Meal
(
        MixId LONGVARCHAR,
        MealId IDENTITY,
        Name LONGVARCHAR,
        MealOrder INTEGER,
        CONSTRAINT Meal_primary_key PRIMARY KEY (MixId,MealId)
);
/
CREATE TABLE MealFoodPortion
(
        MixId LONGVARCHAR,
        MealId INTEGER,
        FoodId LONGVARCHAR,
        Pct DOUBLE,
        ExpectedWt DOUBLE,
        ActualWt DOUBLE,
        CONSTRAINT MealFoodPortion_primary_key PRIMARY KEY (MixId,MealId,FoodId)
);
/
CREATE TABLE Mix
(
        MixId LONGVARCHAR,
        Name LONGVARCHAR,
        ADate DATE,
        ATime TIME,
        Status INTEGER,
        NutrientId LONGVARCHAR,
        Model LONGVARCHAR,
        CONSTRAINT Mix_primary_key PRIMARY KEY (MixId)
);
/
CREATE TABLE MixFood
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        x DOUBLE,
        CONSTRAINT MixFood_primary_key PRIMARY KEY (MixId,FoodId)
);
/
CREATE TABLE MixResult
(
        MixId LONGVARCHAR,
        FoodId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        q DOUBLE,
        CONSTRAINT MixResult_primary_key PRIMARY KEY (MixId,FoodId,NutrientId)
);
/
CREATE TABLE Nutrient
(
        NutrientId LONGVARCHAR,
        Name LONGVARCHAR,
        Visible INTEGER DEFAULT 1,
        NutrientCategoryId LONGVARCHAR,
        Label LONGVARCHAR,
        CONSTRAINT Nutrient_primary_key PRIMARY KEY (NutrientId)
);
/
CREATE TABLE NutrientCategory
(
        NutrientCategoryId LONGVARCHAR,
        Name LONGVARCHAR,
        CONSTRAINT NutrientCategory_primary_key PRIMARY KEY (NutrientCategoryId)
);
/
CREATE TABLE NutrientConstraint
(
        MixId LONGVARCHAR,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DOUBLE,
        CONSTRAINT NutrientConstraint_primary_key PRIMARY KEY (MixId,NutrientId,RelationshipId)
);
/
CREATE TABLE NutrientRatio
(
        MixId LONGVARCHAR,
        Nutrient_Id_1 LONGVARCHAR,
        Nutrient_Id_2 LONGVARCHAR,
        RelationshipId INTEGER,
        A DOUBLE,
        B DOUBLE,
        CONSTRAINT NutrientRatio_primary_key PRIMARY KEY (MixId,Nutrient_Id_1,Nutrient_Id_2,RelationshipId)
);
/
CREATE TABLE PercentConstraint
(
        MixId LONGVARCHAR,
        Foodid LONGVARCHAR,
        NutrientId LONGVARCHAR,
        RelationshipId INTEGER,
        b DOUBLE,
        CONSTRAINT PercentConstraint_primary_key PRIMARY KEY (MixId,Foodid,NutrientId,RelationshipId)
);
/
CREATE TABLE Rda
(
        NutrientId LONGVARCHAR,
        LifeStageId INTEGER,
        q DOUBLE DEFAULT CAST(0 AS DOUBLE),
        UL DOUBLE DEFAULT CAST(0 AS DOUBLE),
        CONSTRAINT Rda_primary_key PRIMARY KEY (NutrientId,LifeStageId)
);
/
CREATE TABLE RdaLifeStage
(
        LifeStageId INTEGER,
        Label LONGVARCHAR,
        CONSTRAINT RdaLifeStage_primary_key PRIMARY KEY (LifeStageId)
);
/
CREATE TABLE Relationship
(
        RelationshipId IDENTITY,
        Name LONGVARCHAR,
        CONSTRAINT Relationship_primary_key PRIMARY KEY (RelationshipId)
);
/
CREATE TABLE mixresultdn
(
        mixid LONGVARCHAR,
        foodid LONGVARCHAR,
        name LONGVARCHAR,
        weight DOUBLE,
        completeprotein DOUBLE,
        digestiblecarbohydrate DOUBLE,
        cost DOUBLE,
        protein DOUBLE,
        fat DOUBLE,
        carbsbydiff DOUBLE,
        energygross DOUBLE,
        alcohol DOUBLE,
        water DOUBLE,
        fiber DOUBLE,
        calcium DOUBLE,
        iron DOUBLE,
        magnesium DOUBLE,
        phosphorus DOUBLE,
        potassium DOUBLE,
        sodium DOUBLE,
        zinc DOUBLE,
        copper DOUBLE,
        fluoride DOUBLE,
        manganese DOUBLE,
        selenium DOUBLE,
        vitamina DOUBLE,
        vitamine DOUBLE,
        vitamind DOUBLE,
        vitaminc DOUBLE,
        thiamin DOUBLE,
        riboflavin DOUBLE,
        niacin DOUBLE,
        pantothenicacid DOUBLE,
        vitaminb6 DOUBLE,
        vitaminb12 DOUBLE,
        choline DOUBLE,
        vitamink DOUBLE,
        folate DOUBLE,
        cholesterol DOUBLE,
        sfa DOUBLE,
        dha DOUBLE,
        epa DOUBLE,
        mufa DOUBLE,
        pufa DOUBLE,
        linoleicacid DOUBLE,
        alphalinolenicacid DOUBLE,
        glycemicload DOUBLE,
        energydigestible DOUBLE,
        energycarbohydrate DOUBLE,
        energyprotein DOUBLE,
        energyfat DOUBLE,
        energyalcohol DOUBLE,
        energyfatcarbohydrate DOUBLE,
        lauric DOUBLE,
        myristic DOUBLE,
        palmitic DOUBLE,
        stearic DOUBLE,
        hcsfa DOUBLE,
        CONSTRAINT mixresultdn_primary_key PRIMARY KEY (mixid,foodid)
);
/
CREATE TABLE ZFC
(
   mixid LONGVARCHAR,
   foodid LONGVARCHAR,
   ROW     INTEGER,
   N10000  DOUBLE,
   N10001  DOUBLE,
   N10003  DOUBLE,
   N10005  DOUBLE,
   N10006  DOUBLE,
   N10009  DOUBLE,
   N10010  DOUBLE,
   N10011  DOUBLE,
   N10012  DOUBLE,
   N10013  DOUBLE,
   N10014  DOUBLE,
   N10015  DOUBLE,
   N203    DOUBLE,
   N204    DOUBLE,
   N205    DOUBLE,
   N208    DOUBLE,
   N221    DOUBLE,
   N255    DOUBLE,
   N291    DOUBLE,
   N301    DOUBLE,
   N303    DOUBLE,
   N304    DOUBLE,
   N305    DOUBLE,
   N306    DOUBLE,
   N307    DOUBLE,
   N309    DOUBLE,
   N312    DOUBLE,
   N315    DOUBLE,
   N317    DOUBLE,
   N320    DOUBLE,
   N323    DOUBLE,
   N328    DOUBLE,
   N401    DOUBLE,
   N404    DOUBLE,
   N405    DOUBLE,
   N406    DOUBLE,
   N410    DOUBLE,
   N415    DOUBLE,
   N418    DOUBLE,
   N421    DOUBLE,
   N430    DOUBLE,
   N435    DOUBLE,
   N601    DOUBLE,
   N606    DOUBLE,
   N611    DOUBLE,
   N612    DOUBLE,
   N613    DOUBLE,
   N614    DOUBLE,
   N618    DOUBLE,
   N619    DOUBLE,
   N621    DOUBLE,
   N629    DOUBLE,
   N645    DOUBLE,
   N646    DOUBLE
);
/
CREATE TABLE ZFF
(
   mixid LONGVARCHAR,
   foodid LONGVARCHAR,
   ROW     INTEGER,
   N10000  DOUBLE,
   N10001  DOUBLE,
   N10003  DOUBLE,
   N10005  DOUBLE,
   N10006  DOUBLE,
   N10009  DOUBLE,
   N10010  DOUBLE,
   N10011  DOUBLE,
   N10012  DOUBLE,
   N10013  DOUBLE,
   N10014  DOUBLE,
   N10015  DOUBLE,
   N203    DOUBLE,
   N204    DOUBLE,
   N205    DOUBLE,
   N208    DOUBLE,
   N221    DOUBLE,
   N255    DOUBLE,
   N291    DOUBLE,
   N301    DOUBLE,
   N303    DOUBLE,
   N304    DOUBLE,
   N305    DOUBLE,
   N306    DOUBLE,
   N307    DOUBLE,
   N309    DOUBLE,
   N312    DOUBLE,
   N315    DOUBLE,
   N317    DOUBLE,
   N320    DOUBLE,
   N323    DOUBLE,
   N328    DOUBLE,
   N401    DOUBLE,
   N404    DOUBLE,
   N405    DOUBLE,
   N406    DOUBLE,
   N410    DOUBLE,
   N415    DOUBLE,
   N418    DOUBLE,
   N421    DOUBLE,
   N430    DOUBLE,
   N435    DOUBLE,
   N601    DOUBLE,
   N606    DOUBLE,
   N611    DOUBLE,
   N612    DOUBLE,
   N613    DOUBLE,
   N614    DOUBLE,
   N618    DOUBLE,
   N619    DOUBLE,
   N621    DOUBLE,
   N629    DOUBLE,
   N645    DOUBLE,
   N646    DOUBLE
);
/
ALTER TABLE Nutrient ADD CONSTRAINT R0_NutrientCategory_Nutrient FOREIGN KEY (NutrientCategoryId) REFERENCES NutrientCategory (NutrientCategoryId) ON DELETE SET NULL;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R1_Nutrient_NutrientRatio FOREIGN KEY (Nutrient_Id_2) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R2_Nutrient_NutrientRatio FOREIGN KEY (Nutrient_Id_1) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R3_Nutrient_FoodFact FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R4_Nutrient_NutrientConstraint FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE Mix ADD CONSTRAINT R5_Nutrient_Mix FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE SET NULL;
/
ALTER TABLE PercentConstraint ADD CONSTRAINT R6_Nutrient_PercentConstraint FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE Rda ADD CONSTRAINT R7_Nutrient_Rda FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R8_Nutrient_FoodNutrientRatio FOREIGN KEY (Nutrient_Id_1) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R9_Nutrient_FoodNutrientRatio FOREIGN KEY (Nutrient_Id_2) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R10_Nutrient_FoodNutrientConstraint FOREIGN KEY (NutrientId) REFERENCES Nutrient (NutrientId) ON DELETE CASCADE;
/
ALTER TABLE FoodFactCoefficient ADD CONSTRAINT R11_FoodFact_FoodFactCoefficient FOREIGN KEY (FoodId, NutrientId) REFERENCES FoodFact (FoodId, NutrientId) ON DELETE CASCADE;
/
ALTER TABLE MealFoodPortion ADD CONSTRAINT R12_Meal_MealFoodPortion FOREIGN KEY (MealId, MixId) REFERENCES Meal (MealId, MixId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R13_Relationship_NutrientRatio FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R14_Relationship_NutrientConstraint FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE PercentConstraint ADD CONSTRAINT R15_Relationship_PercentConstraint FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R16_Relationship_FoodNutrientRatio FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R17_Relationship_FoodNutrientConstraint FOREIGN KEY (RelationshipId) REFERENCES Relationship (RelationshipId) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R18_Mix_NutrientRatio FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE Meal ADD CONSTRAINT R19_Mix_Meal FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R20_Mix_NutrientConstraint FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R21_Mix_MixFood FOREIGN KEY (MixId) REFERENCES Mix (MixId) ON DELETE CASCADE;
/
ALTER TABLE MealFoodPortion ADD CONSTRAINT R22_MixFood_MealFoodPortion FOREIGN KEY (MixId, FoodId) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE PercentConstraint ADD CONSTRAINT R23_MixFood_PercentConstraint FOREIGN KEY (MixId, Foodid) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R24_MixFood_FoodNutrientRatio FOREIGN KEY (MixId, Food_Id_1) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R25_MixFood_FoodNutrientRatio FOREIGN KEY (MixId, Food_Id_2) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R26_MixFood_FoodNutrientConstraint FOREIGN KEY (MixId, FoodId) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE mixresultdn ADD CONSTRAINT R27_MixFood_mixresultdn FOREIGN KEY (mixid, foodid) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R28_MixFood_MixResult FOREIGN KEY (MixId, FoodId) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE Rda ADD CONSTRAINT R29_RdaLifeStage_Rda FOREIGN KEY (LifeStageId) REFERENCES RdaLifeStage (LifeStageId) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R30_FoodFactCoefficient_MixResult FOREIGN KEY (FoodId, NutrientId) REFERENCES FoodFactCoefficient (FoodId, NutrientId) ON DELETE CASCADE;
/
ALTER TABLE CategoryLink ADD CONSTRAINT R31_Food_CategoryLink FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R32_Food_FoodFact FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE GlycemicIndex ADD CONSTRAINT R33_Food_GlycemicIndex FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R34_Food_MixFood FOREIGN KEY (FoodId) REFERENCES Food (FoodId) ON DELETE CASCADE;
/
ALTER TABLE CategoryLink ADD CONSTRAINT R35_FoodCategory_CategoryLink FOREIGN KEY (FoodCategoryId) REFERENCES FoodCategory (FoodCategoryId) ON DELETE CASCADE;
/
ALTER TABLE zff ADD CONSTRAINT R36_MixFood_Zff FOREIGN KEY (mixid, foodid) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/
ALTER TABLE zfc ADD CONSTRAINT R37_MixFood_Zfc FOREIGN KEY (mixid, foodid) REFERENCES MixFood (MixId, FoodId) ON DELETE CASCADE;
/


