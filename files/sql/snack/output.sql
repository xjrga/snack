DROP SCHEMA PUBLIC CASCADE;
/

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
   N646    DOUBLE,
   CONSTRAINT zfc_primary_key PRIMARY KEY (mixid,foodid)
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
   N646    DOUBLE,
   CONSTRAINT zff_primary_key PRIMARY KEY (mixid,foodid)
);
/
CREATE TABLE MixCost
(
        mixid LONGVARCHAR,
        mixcost DOUBLE,
        CONSTRAINT mixcost_primary_key PRIMARY KEY (mixid)
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
ALTER TABLE MixCost ADD CONSTRAINT R38_Mix_MixCost FOREIGN KEY (mixid) REFERENCES Mix (MixId) ON DELETE CASCADE;
/



CREATE FUNCTION getFoodQuotient(
IN v_MixId LONGVARCHAR
) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE fq DOUBLE;
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       CASE WHEN SUM(energydigestible) <= 0 OR SUM(energydigestible) IS NULL THEN 0 ELSE SUM(energycarbohydrate) /SUM(energydigestible)*1.00 +SUM(energyfat) /SUM(energydigestible)*0.71 +SUM(energyprotein) /SUM(energydigestible)*0.81 +SUM(energyalcohol) /SUM(energydigestible)*0.667 END into fq
FROM mixresultdn
WHERE mixid = v_MixId;
RETURN fq;
END;
/


CREATE FUNCTION get_essential_fat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN(sum(alphalinolenicacid) <= 0,0,sum(linoleicacid)/sum(alphalinolenicacid)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
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
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN(sum(sodium) <= 0,0,sum(potassium)/sum(sodium)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
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
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN (SUM(sfa) <= 0,0,SUM(pufa) / SUM(sfa)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
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
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN (SUM(sfa) <= 0,0,SUM(mufa) / SUM(sfa)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
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

CREATE FUNCTION getMealGI (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE mealGI DOUBLE;
--
SET mealGI = 0;
--
SELECT SUM(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END * getGIFromGL (foodid)) INTO mealGI
FROM (SELECT mixid,
             foodid,
             weight,
             digestiblecarbohydrate AS carbs,
             (SELECT SUM(digestiblecarbohydrate)
              FROM mixresultdn
              WHERE mixid = v_MixId) AS tcarbs,
             glycemicload AS gl
      FROM mixresultdn
      WHERE mixid = v_MixId)
GROUP BY mixid;
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


CREATE FUNCTION pick_food_gi(
IN v_foodid LONGVARCHAR
) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE v_gi DOUBLE;
SET v_gi = 0;
SELECT CASE WHEN q IS NULL THEN 0 ELSE q END INTO v_gi FROM glycemicindex WHERE foodid = v_foodid;
RETURN v_gi;
END;
/


CREATE FUNCTION calculate_remaining_percentage (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR,
IN v_Precision INTEGER) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
SELECT SUM(pct) INTO v_c FROM MealFoodPortion WHERE MixId = v_MixId AND FoodId = v_FoodId;
--
RETURN ROUND(v_c * 100,v_Precision);
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
DECLARE v_c DOUBLE;
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

) RETURNS DOUBLE
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_q DOUBLE;
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

CREATE PROCEDURE FoodFact_Merge (
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_q DOUBLE
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


CREATE PROCEDURE FoodFact_ZeroOut_FoodId (
--
IN v_FoodId LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
FOR SELECT nutrientid FROM nutrient DO
--
call FoodFact_Merge (v_FoodId,nutrientid,0);
--
END FOR;
--
END;
/

CREATE PROCEDURE Food_Insert_Temp (OUT v_OutFoodId LONGVARCHAR,IN v_FoodNom LONGVARCHAR)
--
modifies sql data BEGIN atomic
--
DECLARE v_FoodId LONGVARCHAR;
--
SET v_FoodId = generateId();
SET v_OutFoodId = v_FoodId;
--
call Food_Insert(v_FoodId,v_FoodNom);
call CategoryLink_Insert(v_FoodId,'5000');
call FoodFact_ZeroOut_FoodId(v_FoodId);
--
END;
/

CREATE PROCEDURE snack_food_insertfood (IN v_foodid LONGVARCHAR,IN v_foodnom LONGVARCHAR)
--
modifies sql data BEGIN atomic
--
call food_insert(v_foodid,v_foodnom);
call FoodFact_ZeroOut_FoodId(v_foodid);
--
END;
/


CREATE PROCEDURE FoodFact_ZeroOut ()
--
modifies sql data BEGIN atomic
--
FOR SELECT foodid FROM food DO
--
call FoodFact_ZeroOut_FoodId(foodid);
--
END FOR;
--
END;
/

CREATE PROCEDURE Food_Select (
IN v_FoodId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
FoodId,
Name
FROM
Food
WHERE
FoodId = v_FoodId;
OPEN result;
END;
/

CREATE PROCEDURE FoodFact_Select_ForDataInput (
IN v_FoodId LONGVARCHAR,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name,
       b.Name,
       Round(c.q,v_Precision)
FROM NutrientCategory a,
     Nutrient b,
     FoodFact c
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   b.NutrientId = c.NutrientId
AND c.FoodId = v_FoodId
AND (b.NutrientId != '10003' AND b.NutrientId != '10006' AND b.NutrientId != '10009' AND b.NutrientId != '10010' AND b.NutrientId != '10011' AND b.NutrientId != '10012' AND b.NutrientId != '10013' AND b.NutrientId != '10014' AND b.NutrientId != '10015')
ORDER BY a.Name,b.Name;
OPEN result;
END;
/

CREATE PROCEDURE FoodFact_Select_ForCheckCoefficient (
IN v_FoodId LONGVARCHAR,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name,
       b.Name,
       Round(c.q,v_Precision) as Fact,
       Round(d.c,v_Precision) as Coefficient
FROM NutrientCategory a,
     Nutrient b,
     FoodFact c,
     FoodFactCoefficient d
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   b.NutrientId = c.NutrientId
AND   b.NutrientId = d.NutrientId
AND   c.FoodId = d.FoodId
AND c.FoodId = v_FoodId;
OPEN result;
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
       b
FROM foodnutrientconstraint
WHERE mixid = v_mixid
ORDER BY foodid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE DuplicateFoodItem (IN v_FoodId LONGVARCHAR)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodIdNew LONGVARCHAR;
DECLARE v_FoodNom LONGVARCHAR;
DECLARE v_CategoryId LONGVARCHAR;
--
SET v_FoodNom = getFoodName(v_FoodId);
SET v_FoodIdNew = generateId();
-- Other category is 5000
SET v_CategoryId = '5000';
--
call Food_Insert(v_FoodIdNew,v_FoodNom||'_duplicate');
call CategoryLink_Insert(v_FoodIdNew,v_CategoryId);
call DuplicateFoodFact(v_FoodId,v_FoodIdNew);
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


CREATE PROCEDURE Mix_getMealGi (
--
IN v_MixId LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT CASE WHEN b.name IS NULL THEN 'Total' ELSE b.name END as name,
       ROUND(a.weight, v_Precision) AS weight,
       ROUND(a.carbs, v_Precision) AS carbs,
       ROUND(a.pct*100, v_Precision) AS pct,
       ROUND(a.gl, v_Precision) AS gl,
       ROUND(a.gi, v_Precision) AS gi,
       ROUND(a.mealgi, v_Precision) AS mealgi,
       ROUND(a.energycarbohydrate, v_Precision) as ecarbs
FROM
(
SELECT mixid,
       foodid,
       weight,
       carbs,
       CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END AS Pct,
       gl,
       getGIFromGL(foodid) as gi,
       CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END *getGIFromGL(foodid) AS MealGI,
       energycarbohydrate
FROM (
SELECT mixid,
       foodid,
       weight,
       digestiblecarbohydrate AS carbs,
       (SELECT SUM(digestiblecarbohydrate) FROM mixresultdn WHERE mixid = v_MixId) AS tcarbs,
       glycemicload AS gl,
       energycarbohydrate
FROM mixresultdn
WHERE mixid = v_MixId
)
--
UNION
--
SELECT mixid,
       'Total',
       sum(weight),
       sum(carbs),
       sum(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END),
       sum(gl),
       -1,
       sum(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END *getGIFromGL(foodid)),
       sum(energycarbohydrate)
FROM
(
SELECT mixid,
       foodid,
       weight,
       digestiblecarbohydrate AS carbs,
       (SELECT SUM(digestiblecarbohydrate) FROM mixresultdn WHERE mixid = v_MixId) AS tcarbs,
       glycemicload AS gl,
       energycarbohydrate
FROM mixresultdn
WHERE mixid = v_MixId
)
GROUP BY mixid
) a
--
LEFT JOIN
--
(
SELECT foodid,
       name
       FROM food
) b
ON a.foodid = b.foodid
ORDER BY weight,name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Mix_getMealGIDiff (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'MealGI' AS nutrient,
       ROUND(a.mealgi,v_Precision) AS mix1,
       ROUND(b.mealgi,v_Precision) AS mix2,
       ROUND(a.mealgi - b.mealgi,v_Precision) AS diff       
FROM (SELECT getMealGI(v_MixId_1) AS mealgi FROM ( VALUES (0))) a,
     (SELECT getMealGI(v_MixId_2) AS mealgi FROM ( VALUES (0))) b;
--
OPEN result;
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
INSERT INTO FoodNutrientConstraint
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
FROM FoodNutrientConstraint
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
FoodNutrientConstraint
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
MERGE INTO FoodNutrientConstraint USING ( VALUES (
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
       b.name AS food
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
FoodNutrientConstraint a, Food b, Nutrient c, Relationship d
WHERE
a.MixId = v_MixId
AND
a.FoodId = b.FoodId
AND
a.NutrientId = c.NutrientId
AND
a.RelationshipId = d.RelationshipId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Food_Select_All_2 ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT foodid,
       name
FROM Food
ORDER BY name;
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
INSERT INTO FoodNutrientRatio
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
FROM FoodNutrientRatio
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
FoodNutrientRatio
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
FROM foodnutrientratio a,
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


CREATE PROCEDURE Food_Select_Details (
IN v_Precision INTEGER
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT
       --Name
       a.name AS "Name",
       --Mass
       ROUND(x0.q,v_Precision) AS "Weight",
       --Energy
       ROUND(x8.q,v_Precision) AS "EnergyGross",
       ROUND(x53.q,v_Precision) AS "EnergyDigestible",
       ROUND(x55.q,v_Precision) AS "EnergyCarbohydrate",
       ROUND(x56.q,v_Precision) AS "EnergyProtein",
       ROUND(x57.q,v_Precision) AS "EnergyFat",
       ROUND(x58.q,v_Precision) AS "EnergyAlcohol",
       ROUND(x59.q,v_Precision) AS "EnergyFatCarbohydrate",
       --Macronutrient
       ROUND(x6.q,v_Precision) AS "Fat",
       ROUND(x3.q,v_Precision) AS "DigestibleCarbs",
       ROUND(x5.q,v_Precision) AS "Protein",
       ROUND(x12.q,v_Precision) AS "Alcohol",
       --Protein
       ROUND(x1.q,v_Precision) AS "CompleteProtein",
       --Fiber
       ROUND(x7.q,v_Precision) AS "CarbsByDiff",
       ROUND(x16.q,v_Precision) AS "Fiber",
       --Minerals
       ROUND(x17.q,v_Precision) AS "Calcium",
       ROUND(x18.q,v_Precision) AS "Iron",
       ROUND(x19.q,v_Precision) AS "Magnesium",
       ROUND(x20.q,v_Precision) AS "Phosphorus",
       ROUND(x21.q,v_Precision) AS "Potassium",
       ROUND(x22.q,v_Precision) AS "Sodium",
       ROUND(x23.q,v_Precision) AS "Zinc",
       ROUND(x24.q,v_Precision) AS "Copper",
       ROUND(x26.q,v_Precision) AS "Manganese",
       ROUND(x27.q,v_Precision) AS "Selenium",
       --Vitamins
       ROUND(x28.q,v_Precision) AS "VitaminA",
       ROUND(x29.q,v_Precision) AS "VitaminE",
       ROUND(x30.q,v_Precision) AS "VitaminD",
       ROUND(x33.q,v_Precision) AS "VitaminC",
       ROUND(x34.q,v_Precision) AS "Thiamin",
       ROUND(x35.q,v_Precision) AS "Riboflavin",
       ROUND(x36.q,v_Precision) AS "Niacin",
       ROUND(x37.q,v_Precision) AS "Pantothenic",
       ROUND(x38.q,v_Precision) AS "VitaminB6",
       ROUND(x39.q,v_Precision) AS "VitaminB12",
       ROUND(x14.q,v_Precision) AS "Choline",
       ROUND(x40.q,v_Precision) AS "VitaminK",
       ROUND(x41.q,v_Precision) AS "Folate",
       --Fatty Acids
       ROUND(x42.q,v_Precision) AS "Cholesterol",
       ROUND(x43.q,v_Precision) AS "Saturated",
       ROUND(x44.q,v_Precision) AS "DHA",
       ROUND(x45.q,v_Precision) AS "EPA",
       ROUND(x46.q,v_Precision) AS "Monounsaturated",
       ROUND(x47.q,v_Precision) AS "Polyunsaturated",
       ROUND(x48.q,v_Precision) AS "Linoleic",
       ROUND(x49.q,v_Precision) AS "AlphaLinolenic",
       ROUND(x60.q,v_Precision) AS "Lauric",
       ROUND(x61.q,v_Precision) AS "Myristic",
       ROUND(x62.q,v_Precision) AS "Palmitic",
       ROUND(x63.q,v_Precision) AS "Stearic",
       ROUND(x64.q,v_Precision) AS "SaturatedHC",
       --Glycemic
       ROUND(x50.q,v_Precision) AS "GlycemicLoad",
       --Other
       ROUND(x13.q,v_Precision) AS "Water",
       ROUND(x4.q,v_Precision) AS "Cost",
       --Ids
       a.foodid AS "FoodId"
FROM food a,
     foodfact x0,
     foodfact x1,
     foodfact x3,
     foodfact x4,
     foodfact x5,
     foodfact x6,
     foodfact x7,
     foodfact x8,
     foodfact x12,
     foodfact x13,
     foodfact x16,
     foodfact x17,
     foodfact x18,
     foodfact x19,
     foodfact x20,
     foodfact x21,
     foodfact x22,
     foodfact x23,
     foodfact x24,
     foodfact x26,
     foodfact x27,
     foodfact x28,
     foodfact x29,
     foodfact x30,
     foodfact x33,
     foodfact x34,
     foodfact x35,
     foodfact x36,
     foodfact x37,
     foodfact x38,
     foodfact x39,
     foodfact x14,
     foodfact x40,
     foodfact x41,
     foodfact x42,
     foodfact x43,
     foodfact x44,
     foodfact x45,
     foodfact x46,
     foodfact x47,
     foodfact x48,
     foodfact x49,
     foodfact x50,
     foodfact x53,
     foodfact x55,
     foodfact x56,
     foodfact x57,
     foodfact x58,
     foodfact x59,
     foodfact x60,
     foodfact x61,
     foodfact x62,
     foodfact x63,
     foodfact x64
WHERE
(
     a.foodid = x0.foodid AND
     a.foodid = x1.foodid AND
     a.foodid = x3.foodid AND
     a.foodid = x4.foodid AND
     a.foodid = x5.foodid AND
     a.foodid = x6.foodid AND
     a.foodid = x7.foodid AND
     a.foodid = x8.foodid AND
     a.foodid = x12.foodid AND
     a.foodid = x13.foodid AND
     a.foodid = x16.foodid AND
     a.foodid = x17.foodid AND
     a.foodid = x18.foodid AND
     a.foodid = x19.foodid AND
     a.foodid = x20.foodid AND
     a.foodid = x21.foodid AND
     a.foodid = x22.foodid AND
     a.foodid = x23.foodid AND
     a.foodid = x24.foodid AND
     a.foodid = x26.foodid AND
     a.foodid = x27.foodid AND
     a.foodid = x28.foodid AND
     a.foodid = x29.foodid AND
     a.foodid = x30.foodid AND
     a.foodid = x33.foodid AND
     a.foodid = x34.foodid AND
     a.foodid = x35.foodid AND
     a.foodid = x36.foodid AND
     a.foodid = x37.foodid AND
     a.foodid = x38.foodid AND
     a.foodid = x39.foodid AND
     a.foodid = x14.foodid AND
     a.foodid = x40.foodid AND
     a.foodid = x41.foodid AND
     a.foodid = x42.foodid AND
     a.foodid = x43.foodid AND
     a.foodid = x44.foodid AND
     a.foodid = x45.foodid AND
     a.foodid = x46.foodid AND
     a.foodid = x47.foodid AND
     a.foodid = x48.foodid AND
     a.foodid = x49.foodid AND
     a.foodid = x50.foodid AND
     a.foodid = x53.foodid AND
     a.foodid = x55.foodid AND
     a.foodid = x56.foodid AND
     a.foodid = x57.foodid AND
     a.foodid = x58.foodid AND
     a.foodid = x59.foodid AND
     a.foodid = x60.foodid AND
     a.foodid = x61.foodid AND
     a.foodid = x62.foodid AND
     a.foodid = x63.foodid AND
     a.foodid = x64.foodid
)
AND
(
     x0.nutrientid = '10000' AND
     x1.nutrientid = '10001' AND
     x3.nutrientid = '10003' AND
     x4.nutrientid = '10005' AND
     x5.nutrientid = '203' AND
     x6.nutrientid = '204' AND
     x7.nutrientid = '205' AND
     x8.nutrientid = '208' AND
     x12.nutrientid = '221' AND
     x13.nutrientid = '255' AND
     x16.nutrientid = '291' AND
     x17.nutrientid = '301' AND
     x18.nutrientid = '303' AND
     x19.nutrientid = '304' AND
     x20.nutrientid = '305' AND
     x21.nutrientid = '306' AND
     x22.nutrientid = '307' AND
     x23.nutrientid = '309' AND
     x24.nutrientid = '312' AND
     x26.nutrientid = '315' AND
     x27.nutrientid = '317' AND
     x28.nutrientid = '320' AND
     x29.nutrientid = '323' AND
     x30.nutrientid = '328' AND
     x33.nutrientid = '401' AND
     x34.nutrientid = '404' AND
     x35.nutrientid = '405' AND
     x36.nutrientid = '406' AND
     x37.nutrientid = '410' AND
     x38.nutrientid = '415' AND
     x39.nutrientid = '418' AND
     x14.nutrientid = '421' AND
     x40.nutrientid = '430' AND
     x41.nutrientid = '435' AND
     x42.nutrientid = '601' AND
     x43.nutrientid = '606' AND
     x44.nutrientid = '621' AND
     x45.nutrientid = '629' AND
     x46.nutrientid = '645' AND
     x47.nutrientid = '646' AND
     x48.nutrientid = '618' AND
     x49.nutrientid = '619' AND
     x50.nutrientid = '10006' AND
     x53.nutrientid = '10009' AND
     x55.nutrientid = '10011' AND
     x56.nutrientid = '10012' AND
     x57.nutrientid = '10013' AND
     x58.nutrientid = '10014' AND
     x59.nutrientid = '10010' AND
     x60.nutrientid = '611' AND
     x61.nutrientid = '612' AND
     x62.nutrientid = '613' AND
     x63.nutrientid = '614' AND
     x64.nutrientid = '10015'
);
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
MERGE INTO FoodNutrientRatio USING ( VALUES (
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
       0 AS b
       --foodratio_b1,
       --foodratio_b2
       FROM foodnutrientratio
WHERE mixid = v_mixid
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
FROM foodnutrientconstraint a,
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
FoodNutrientRatio a, Food b, Nutrient c, Food d, Nutrient e, Relationship f
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
a.relationshipid = f.relationshipid;
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
DECLARE v_NutrientId LONGVARCHAR;
DECLARE v_Model LONGVARCHAR;
DECLARE newid2 LONGVARCHAR;
--
SELECT Name,
       Nutrientid,
       Model       
INTO
       v_Name_Old,
       v_NutrientId,
       v_Model       
FROM Mix
WHERE MixId = v_MixId_Old;
--
SELECT generateId() INTO newid2 FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
Nutrientid,
Model
) VALUES (
newid2,
v_Name_Old||'_copy',
v_NutrientId,
v_Model
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


CREATE PROCEDURE Mix_getDiff (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.name,b.name,b.mixa,b.mixb,b.diff
FROM
(
SELECT nutrientcategoryid, name
FROM nutrientcategory) A,
(
SELECT
       b.nutrientcategoryid,
       b.nutrientid,
       b.name,
       round(a.mix1,v_Precision) as mixa,
       round(a.mix2,v_Precision) as mixb,
       round(a.diff,v_Precision) as diff
FROM (SELECT a.nutrientid,
             a.value AS mix1,
             b.value AS mix2,
             b.value - a.value AS diff
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
ORDER BY a.name, b.name;
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
IN v_nutrientid LONGVARCHAR,
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
nutrientid,
model
) VALUES (
v_mixid,
v_name,
v_nutrientid,
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
Name
) VALUES (
newid2,
v_Name
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
       NutrientId,
       Model
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


CREATE PROCEDURE Mix_Update_NutrientId (
IN v_MixId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Mix
SET
NutrientId = v_NutrientId
WHERE
MixId = v_MixId;
END;
/


CREATE PROCEDURE Mix_Update_Other (
IN v_MixId LONGVARCHAR,
IN v_Model LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Mix
SET
Model = v_Model
WHERE
MixId = v_MixId;
END;
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

CREATE PROCEDURE mixresultdn_copy (
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
INSERT INTO mixresultdn
(
    mixid,
    foodid,
    name,
    weight,
    completeprotein,
    digestiblecarbohydrate,
    cost,
    protein,
    fat,
    carbsbydiff,
    energygross,
    alcohol,
    water,
    fiber,
    calcium,
    iron,
    magnesium,
    phosphorus,
    potassium,
    sodium,
    zinc,
    copper,
    manganese,
    selenium,
    vitamina,
    vitamine,
    vitamind,
    vitaminc,
    thiamin,
    riboflavin,
    niacin,
    pantothenicacid,
    vitaminb6,
    vitaminb12,
    choline,
    vitamink,
    folate,
    cholesterol,
    sfa,
    dha,
    epa,
    mufa,
    pufa,
    linoleicacid,
    alphalinolenicacid,
    glycemicload,
    energydigestible,
    energycarbohydrate,
    energyprotein,
    energyfat,
    energyalcohol,
    energyfatcarbohydrate,
    lauric,
    myristic,
    palmitic,
    stearic,
    hcsfa
)
SELECT  v_MixId_New,
        foodid,
        name,
        weight,
        completeprotein,
        digestiblecarbohydrate,
        cost,
        protein,
        fat,
        carbsbydiff,
        energygross,
        alcohol,
        water,
        fiber,
        calcium,
        iron,
        magnesium,
        phosphorus,
        potassium,
        sodium,
        zinc,
        copper,
        manganese,
        selenium,
        vitamina,
        vitamine,
        vitamind,
        vitaminc,
        thiamin,
        riboflavin,
        niacin,
        pantothenicacid,
        vitaminb6,
        vitaminb12,
        choline,
        vitamink,
        folate,
        cholesterol,
        sfa,
        dha,
        epa,
        mufa,
        pufa,
        linoleicacid,
        alphalinolenicacid,
        glycemicload,
        energydigestible,
        energycarbohydrate,
        energyprotein,
        energyfat,
        energyalcohol,
        energyfatcarbohydrate,
        lauric,
        myristic,
        palmitic,
        stearic,
        hcsfa
FROM mixresultdn
WHERE mixid = v_MixId_Old;
--
END;
/

CREATE PROCEDURE MixResult_Select (
IN v_MixId LONGVARCHAR,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT a.MixId,
       a.FoodId,
       b.Name,
       ROUND(a.Weight,v_Precision) AS Weight,
       ROUND(CompleteProtein,v_Precision) AS CompleteProtein,
       ROUND(DigestibleCarbohydrate,v_Precision) AS DigestibleCarbohydrate,
       ROUND(Cost,v_Precision) AS Cost,
       ROUND(Protein,v_Precision) AS Protein,
       ROUND(Fat,v_Precision) AS Fat,
       ROUND(CarbsByDiff,v_Precision) AS CarbsByDiff,
       ROUND(energygross,v_Precision) AS EnergyGross,
       ROUND(Alcohol,v_Precision) AS Alcohol,
       ROUND(Water,v_Precision) AS Water,
       ROUND(Fiber,v_Precision) AS Fiber,
       ROUND(Calcium,v_Precision) AS Calcium,
       ROUND(Iron,v_Precision) AS Iron,
       ROUND(Magnesium,v_Precision) AS Magnesium,
       ROUND(Phosphorus,v_Precision) AS Phosphorus,
       ROUND(Potassium,v_Precision) AS Potassium,
       ROUND(Sodium,v_Precision) AS Sodium,
       ROUND(Zinc,v_Precision) AS Zinc,
       ROUND(Copper,v_Precision) AS Copper,
       ROUND(Manganese,v_Precision) AS Manganese,
       ROUND(Selenium,v_Precision) AS Selenium,
       ROUND(VitaminA,v_Precision) AS VitaminA,
       ROUND(VitaminE,v_Precision) AS VitaminE,
       ROUND(VitaminD,v_Precision) AS VitaminD,
       ROUND(VitaminC,v_Precision) AS VitaminC,
       ROUND(Thiamin,v_Precision) AS Thiamin,
       ROUND(Riboflavin,v_Precision) AS Riboflavin,
       ROUND(Niacin,v_Precision) AS Niacin,
       ROUND(pantothenicacid,v_Precision) AS Pantothenic,
       ROUND(VitaminB6,v_Precision) AS VitaminB6,
       ROUND(VitaminB12,v_Precision) AS VitaminB12,
       ROUND(Choline,v_Precision) AS Choline,
       ROUND(VitaminK,v_Precision) AS VitaminK,
       ROUND(Folate,v_Precision) AS Folate,
       ROUND(Cholesterol,v_Precision) AS Cholesterol,
       ROUND(sfa,v_Precision) AS Saturated,
       ROUND(DHA,v_Precision) AS DHA,
       ROUND(EPA,v_Precision) AS EPA,
       ROUND(mufa,v_Precision) AS Monounsaturated,
       ROUND(pufa,v_Precision) AS Polyunsaturated,
       ROUND(linoleicacid,v_Precision) AS Linoleic,
       ROUND(alphalinolenicacid,v_Precision) AS AlphaLinolenic,
       ROUND(GlycemicLoad,v_Precision) AS GlycemicLoad,
       ROUND(EnergyDigestible,v_Precision) AS EnergyDigestible,
       ROUND(EnergyCarbohydrate,v_Precision) AS EnergyCarbohydrate,
       ROUND(EnergyProtein,v_Precision) AS EnergyProtein,
       ROUND(EnergyFat,v_Precision) AS EnergyFat,
       ROUND(EnergyAlcohol,v_Precision) AS EnergyAlcohol,
       ROUND(EnergyFatCarbohydrate,v_Precision) AS EnergyFatCarbohydrate,
       ROUND(Lauric,v_Precision) AS Lauric,
       ROUND(Myristic,v_Precision) AS Myristic,
       ROUND(Palmitic,v_Precision) AS Palmitic,
       ROUND(Stearic,v_Precision) AS Stearic,
       ROUND(Hcsfa,v_Precision) AS Hcsfa
FROM mixresultdn a,
     food b
WHERE a.mixid = v_mixid
AND   a.foodid = b.foodid
--
union
--
select a.MixId,
       '',
       'Total',
       Round(sum(a.Weight),v_Precision),
       Round(sum(CompleteProtein),v_Precision),
       Round(sum(DigestibleCarbohydrate),v_Precision),
       Round(sum(Cost),v_Precision),
       Round(sum(Protein),v_Precision),
       Round(sum(Fat),v_Precision),
       Round(sum(CarbsByDiff),v_Precision),
       Round(sum(energygross),v_Precision),
       Round(sum(Alcohol),v_Precision),
       Round(sum(Water),v_Precision),
       Round(sum(Fiber),v_Precision),
       Round(sum(Calcium),v_Precision),
       Round(sum(Iron),v_Precision),
       Round(sum(Magnesium),v_Precision),
       Round(sum(Phosphorus),v_Precision),
       Round(sum(Potassium),v_Precision),
       Round(sum(Sodium),v_Precision),
       Round(sum(Zinc),v_Precision),
       Round(sum(Copper),v_Precision),
       Round(sum(Manganese),v_Precision),
       Round(sum(Selenium),v_Precision),
       Round(sum(VitaminA),v_Precision),
       Round(sum(VitaminE),v_Precision),
       Round(sum(VitaminD),v_Precision),
       Round(sum(VitaminC),v_Precision),
       Round(sum(Thiamin),v_Precision),
       Round(sum(Riboflavin),v_Precision),
       Round(sum(Niacin),v_Precision),
       Round(sum(pantothenicacid),v_Precision),
       Round(sum(VitaminB6),v_Precision),
       Round(sum(VitaminB12),v_Precision),
       Round(sum(Choline),v_Precision),
       Round(sum(VitaminK),v_Precision),
       Round(sum(Folate),v_Precision),
       Round(sum(Cholesterol),v_Precision),
       Round(sum(sfa),v_Precision),
       Round(sum(DHA),v_Precision),
       Round(sum(EPA),v_Precision),
       Round(sum(mufa),v_Precision),
       Round(sum(pufa),v_Precision),
       Round(sum(linoleicacid),v_Precision),
       Round(sum(alphalinolenicacid),v_Precision),
       Round(sum(GlycemicLoad),v_Precision),
       Round(sum(EnergyDigestible),v_Precision),
       Round(sum(EnergyCarbohydrate),v_Precision),
       Round(sum(EnergyProtein),v_Precision),
       Round(sum(EnergyFat),v_Precision),
       Round(sum(EnergyAlcohol),v_Precision),
       ROUND(sum(EnergyFatCarbohydrate),v_Precision),
       ROUND(sum(Lauric),v_Precision) AS Lauric,
       ROUND(sum(Myristic),v_Precision) AS Myristic,
       ROUND(sum(Palmitic),v_Precision) AS Palmitic,
       ROUND(sum(Stearic),v_Precision) AS Stearic,
       ROUND(sum(Hcsfa),v_Precision)
FROM mixresultdn a,
     food b
WHERE a.mixid = v_mixid
AND   a.foodid = b.foodid
group by a.MixId
order by a.EnergyDigestible,a.Weight,b.Name;
--
OPEN result;
END;
/

CREATE PROCEDURE MixResult_Select_Pct (
--
IN v_MixId LONGVARCHAR,
IN v_Precision INTEGER
--
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energydigestible)),v_Precision) AS calories,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energyfat) / SUM(energydigestible)*100),v_Precision) AS fatpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energycarbohydrate) / SUM(energydigestible)*100),v_Precision) AS carbpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energyprotein) / SUM(energydigestible)*100),v_Precision) AS proteinpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energyalcohol) / SUM(energydigestible)*100),v_Precision) AS alcoholpct,
       ROUND(getFoodQuotient (v_MixId),3) AS fq,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(sfa*9) / SUM(energydigestible)*100),v_Precision) AS satfatpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(mufa*9) / SUM(energydigestible)*100),v_Precision) AS monoufatpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(pufa*9) / SUM(energydigestible)*100),v_Precision) AS polyufatpct,
       ROUND(get_essential_fat_ratio(v_MixId),v_Precision) AS essentialfatratio,
       ROUND(get_electrolyte_ratio(v_MixId),v_Precision) AS electrolyteratio,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(linoleicacid*9) / SUM(energydigestible)*100),v_Precision) AS linoleicacidpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(alphalinolenicacid*9) / SUM(energydigestible)*100),v_Precision) AS alphalinolenicacidpct,
       ROUND(get_polyufat_ratio(v_MixId),v_Precision) AS psratio,
       ROUND(get_monoufat_ratio(v_MixId),v_Precision) AS msratio
FROM mixresultdn
WHERE mixid = v_MixId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Nutrient_Insert (
IN v_NutrientId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_NutrientCategoryId LONGVARCHAR,
IN v_Label LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Nutrient (
NutrientId,
Name,
NutrientCategoryId,
Label
) VALUES (
v_NutrientId,
v_Name,
v_NutrientCategoryId,
v_Label
);
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
FROM nutrientconstraint a,
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
       b
FROM nutrientconstraint
WHERE mixid = v_mixid
ORDER BY nutrientid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Nutrient_To_Pct_Select ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name,
q
FROM
Nutrient a, Rda b
WHERE
a.NutrientId = b.NutrientId AND
b.LifeStageId = 22 AND
a.NutrientId != '204' AND
a.NutrientId != '255' AND
a.NutrientId != '291' AND
a.NutrientId != '313' AND
a.NutrientId != '618' AND
a.NutrientId != '619' AND
a.NutrientId != '10001' AND
a.NutrientId != '10003'
ORDER BY Name;
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
INSERT INTO NutrientConstraint
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
FROM NutrientConstraint
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
NutrientConstraint
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
MERGE INTO NutrientConstraint USING ( VALUES (
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
NutrientConstraint a, Nutrient b, Relationship c
WHERE
a.MixId = v_MixId
AND
a.nutrientid = b.nutrientid
AND
a.relationshipid = c.relationshipid;
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
INSERT INTO NutrientRatio
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
FROM NutrientRatio
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
NutrientRatio
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
            FROM nutrientratio a,
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
            FROM nutrientratio a,
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
MERGE INTO NutrientRatio USING ( VALUES (
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
       0 AS b
       FROM nutrientratio
WHERE mixid = v_mixid
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
NutrientRatio a, Nutrient b, Nutrient c, Relationship d
WHERE
a.MixId = v_MixId
AND
a.Nutrient_Id_1 = b.NutrientId
AND
a.Nutrient_Id_2 = c.NutrientId
AND
a.relationshipid = d.relationshipid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE objective_lhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT foodid,
       c
FROM mixfood a, foodfactcoefficient b
WHERE mixid = v_mixid
AND
a.foodid = b.foodid
AND
b.nutrientid = (SELECT a.nutrientid FROM mix a WHERE a.mixid = v_mixid)
ORDER BY foodid;
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
IN v_q DOUBLE,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT a.name,
       ROUND(a.weight*b.c,v_Precision) AS calories,
       ROUND(a.weight,v_Precision) AS weight
FROM (SELECT a.name,
             a.foodid,
             v_q / b.c AS weight
      FROM food a,
           foodfactcoefficient b
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = v_nutrientid
      AND   b.c > 0) a,
     (SELECT foodid,
             c
      FROM foodfactcoefficient
      WHERE nutrientid = '10009'
      AND   c >= 0) b
WHERE a.foodid = b.foodid
ORDER BY calories,weight;
--
OPEN result;
--
END
/


CREATE PROCEDURE GlycemicIndex_merge (
IN v_FoodId LONGVARCHAR,
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO GlycemicIndex USING ( VALUES (
v_FoodId,
v_q
) ) ON (
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
q = v_q
WHEN NOT MATCHED THEN INSERT VALUES
v_FoodId,
v_q;
END;
/

CREATE PROCEDURE Food_Put (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodId LONGVARCHAR;
DECLARE v_FoodName LONGVARCHAR;
DECLARE v_gi DOUBLE;
--
SET v_gi = 0;
--
SELECT Name INTO v_FoodName
FROM Mix
WHERE MixId = v_MixId;
SET v_FoodId = generateId();
--
CALL Food_Insert (v_FoodId,v_FoodName);
--
FOR
SELECT mixid,
       nutrientid,
       SUM(q) AS q
FROM mixresult
WHERE mixid = v_MixId
GROUP BY mixid,nutrientid DO
CALL FoodFact_Merge(v_FoodId,nutrientid,q);
END FOR;
--
SELECT getMealGI(v_MixId) INTO v_gi FROM (VALUES(0));
CALL GlycemicIndex_merge(v_FoodId,v_gi);
--
CALL CategoryLink_Insert (v_FoodId,'5000');
--
END;
/


CREATE PROCEDURE Food_Select_All_Like (
--
IN v_txt LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT foodid,
       name
FROM Food
WHERE LCASE(Name) LIKE LCASE(CONCAT(CONCAT('%',v_txt),'%'))
ORDER BY Name;
--
OPEN result;
--
END;
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

CREATE PROCEDURE Mix_getFQDiff (
--
IN v_MixId_1 LONGVARCHAR,
--
IN v_MixId_2 LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Food Quotient' AS nutrient,
       a.fq AS mix1,
       b.fq AS mix2,
       b.fq - a.fq AS diff
FROM (SELECT getFoodQuotient(v_MixId_1) AS fq FROM ( VALUES (0))) a,
     (SELECT getFoodQuotient(v_MixId_2) AS fq FROM ( VALUES (0))) b;
--
OPEN result;
--
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

CREATE PROCEDURE Mix_getRdaDiff (
--
IN v_MixId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.nutrientid,
       b.name,
       ROUND(a.mix,v_Precision) AS Mix,
       ROUND(a.rda,v_Precision) AS Rda,
       ROUND(CASE WHEN a.rda <= 0 THEN 0 ELSE (a.mix / a.rda)*100 END,v_Precision) AS PctRda,
       ROUND(a.ul,v_Precision) AS UL,
       ROUND(CASE WHEN a.ul <= 0 THEN 0 ELSE (a.mix / a.ul)*100 END,v_Precision) AS PctUL
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
SELECT  '<mix>' +CHAR(10) + '<mixid>' + mixid + '</mixid>' +CHAR(10) + '<name>' + escape_xml_element_data(Name) + '</name>' + CHAR(10) + '<nutrientid>' + nutrientid + '</nutrientid>' + CHAR(10)  + '</mix>'  INTO doc FROM Mix WHERE mixid = v_MixId;
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
FOR SELECT * FROM (SELECT LABEL, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = id AND   Y.NUTRIENTID = Z.NUTRIENTID AND   (Y.NUTRIENTID != '10003' AND Y.NUTRIENTID != '10006' AND Y.NUTRIENTID != '10009' AND Y.NUTRIENTID != '10010' AND Y.NUTRIENTID != '10011' AND Y.NUTRIENTID != '10012' AND Y.NUTRIENTID != '10013' AND Y.NUTRIENTID != '10014' AND Y.NUTRIENTID != '10015') UNION SELECT 'carbohydrates-glycemicindex' AS LABEL, pick_food_gi(id) FROM (VALUES(0)) ) ORDER BY LABEL DO
--
SET doc = '<'+label +'>'+cast(q as decimal(128,32)) +'</'+label +'>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
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
SET doc = '<category>' + CHAR(10) + '<categoryid>' + id + '</categoryid>' + CHAR(10) + '<categoryname>' + escape_xml_element_data(name) + '</categoryname>'  + CHAR(10)  + '</category>' + CHAR (10);
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
SET doc =  '<category_link>' + CHAR(10) + '<foodid>' + foodid + '</foodid>' + CHAR(10) + '<categoryid>' + categoryid + '</categoryid>'  + CHAR(10) + '</category_link>'  + CHAR(10) ;
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
SELECT count(nutrientid, relationshipid, b) INTO counter FROM nutrientconstraint WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<nutrient_constraint_list>' + CHAR (10);
--
FOR select nutrientid, relationshipid, b from nutrientconstraint  WHERE mixid = v_mixid DO
--
SET doc = doc + '<nutrient_constraint>' + CHAR (10) + '<nutrientid>' + nutrientid + '</nutrientid>' + CHAR (10) + '<relationshipid>'+relationshipid +'</relationshipid>' + CHAR (10) + '<b>'+ cast(b as decimal(128,32)) +'</b>' + CHAR (10) + '</nutrient_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</nutrient_constraint_list>';
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
SELECT count(foodid , nutrientid, relationshipid, b) INTO counter FROM foodnutrientconstraint a WHERE a.mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<food_nutrient_constraint_list>' + CHAR (10);
--
FOR select foodid , nutrientid, relationshipid, b from foodnutrientconstraint a WHERE a.mixid = v_mixid DO
--
SET doc = doc + '<food_nutrient_constraint>' + CHAR (10) + '<foodid>' + foodid + '</foodid>' + CHAR (10) + '<nutrientid>' + nutrientid + '</nutrientid>' + CHAR (10) + '<relationshipid>'+relationshipid +'</relationshipid>' + CHAR (10) + '<b>'+ cast(b as decimal(128,32)) +'</b>' + CHAR (10) + '</food_nutrient_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</food_nutrient_constraint_list>';
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
SELECT count(food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b) INTO counter FROM foodnutrientratio WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<food_nutrient_ratio_constraint_list>' + CHAR (10);
--
FOR select food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b from foodnutrientratio WHERE mixid = v_mixid DO
--
SET doc = doc + '<food_nutrient_ratio_constraint>' + CHAR (10) + '<foodid_01>' + food_id_1 + '</foodid_01>' + CHAR (10) + '<nutrientid_01>' + nutrient_id_1 + '</nutrientid_01>' + CHAR (10) + '<foodid_02>' + food_id_2 + '</foodid_02>' + CHAR (10) + '<nutrientid_02>' + nutrient_id_2 + '</nutrientid_02>' + CHAR (10) + '<relationshipid>' + relationshipid  + '</relationshipid>' + CHAR (10) + '<a>' + cast(a as decimal(128,32))  + '</a>' +CHAR (10) + '<b>'+ cast(b as decimal(128,32))  + '</b>' +CHAR (10) + '</food_nutrient_ratio_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</food_nutrient_ratio_constraint_list>';
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
SELECT count(nutrient_id_1, nutrient_id_2, relationshipid, a, b) INTO counter FROM nutrientratio WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<nutrient_ratio_constraint_list>' + CHAR (10);
--
FOR select nutrient_id_1, nutrient_id_2, relationshipid, a, b from nutrientratio WHERE mixid = v_mixid DO
--
SET doc = doc + '<nutrient_ratio_constraint>' + CHAR (10)  + '<nutrientid_01>' + nutrient_id_1 + '</nutrientid_01>' + CHAR (10)  + '<nutrientid_02>' + nutrient_id_2 + '</nutrientid_02>' + CHAR (10) + '<relationshipid>' + relationshipid  + '</relationshipid>' + CHAR (10) + '<a>' + cast(a as decimal(128,32))  + '</a>' +CHAR (10) + '<b>'+ cast(b as decimal(128,32))  + '</b>' +CHAR (10) + '</nutrient_ratio_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</nutrient_ratio_constraint_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/


CREATE PROCEDURE fill_mixresultdn (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
INSERT INTO mixresultdn
(
mixid,
foodid,
name,
weight,
completeprotein,
digestiblecarbohydrate,
cost,
protein,
fat,
carbsbydiff,
energygross,
alcohol,
water,
fiber,
calcium,
iron,
magnesium,
phosphorus,
potassium,
sodium,
zinc,
copper,
manganese,
selenium,
vitamina,
vitamine,
vitamind,
vitaminc,
thiamin,
riboflavin,
niacin,
pantothenicacid,
vitaminb6,
vitaminb12,
choline,
vitamink,
folate,
cholesterol,
sfa,
dha,
epa,
mufa,
pufa,
linoleicacid,
alphalinolenicacid,
glycemicload,
energydigestible,
energycarbohydrate,
energyprotein,
energyfat,
energyalcohol,
energyfatcarbohydrate,
lauric,
myristic,
palmitic,
stearic,
hcsfa
)
SELECT a.MixId,
       a.FoodId,
       b.Name,
       a.Weight,
       CompleteProtein,
       DigestibleCarbohydrate,
       Cost,
       Protein,
       Fat,
       CarbsByDiff,
       Energy,
       Alcohol,
       Water,
       Fiber,
       Calcium,
       Iron,
       Magnesium,
       Phosphorus,
       Potassium,
       Sodium,
       Zinc,
       Copper,
       Manganese,
       Selenium,
       VitaminA,
       VitaminE,
       VitaminD,
       VitaminC,
       Thiamin,
       Riboflavin,
       Niacin,
       Pantothenic,
       VitaminB6,
       VitaminB12,
       Choline,
       VitaminK,
       Folate,
       Cholesterol,
       Saturated,
       DHA,
       EPA,
       Monounsaturated,
       Polyunsaturated,
       Linoleic,
       AlphaLinolenic,
       GlycemicLoad,
       EnergyDigestible,
       EnergyCarbohydrate,
       EnergyProtein,
       EnergyFat,
       EnergyAlcohol,
       EnergyFatCarbohydrate,
       Lauric,
       Myristic,
       Palmitic,
       Stearic,
       HCSFA
FROM (SELECT x0.Mixid,
             x0.Foodid,
             x1.Weight,
             x2.CompleteProtein,
             x4.DigestibleCarbohydrate,
             x5.Cost,
             x6.Protein,
             x7.Fat,
             x8.CarbsByDiff,
             x9.Energy,
             x13.Alcohol,
             x14.Water,
             x15.Fiber,
             x16.Calcium,
             x17.Iron,
             x18.Magnesium,
             x19.Phosphorus,
             x20.Potassium,
             x21.Sodium,
             x22.Zinc,
             x23.Copper,
             x25.Manganese,
             x26.Selenium,
             x27.VitaminA,
             x28.VitaminE,
             x29.VitaminD,
             x30.VitaminC,
             x31.Thiamin,
             x32.Riboflavin,
             x33.Niacin,
             x34.Pantothenic,
             x35.VitaminB6,
             x36.VitaminB12,
             x37.Choline,
             x38.VitaminK,
             x39.Folate,
             x40.Cholesterol,
             x41.Saturated,
             x42.DHA,
             x43.EPA,
             x44.Monounsaturated,
             x45.Polyunsaturated,
             x46.Linoleic,
             x47.AlphaLinolenic,
             x50.GlycemicLoad,
             x51.EnergyDigestible,
             x53.EnergyCarbohydrate,
             x54.EnergyProtein,
             x55.EnergyFat,
             x56.EnergyAlcohol,
             x57.EnergyFatCarbohydrate,
             x58.Lauric,
             x59.Myristic,
             x60.Palmitic,
             x61.Stearic,
             x62.HCSFA
      FROM
      --
      (SELECT mixid, foodid FROM mixfood WHERE mixid = v_MixId) x0,
           --
      --10000	Weight (g)
      (SELECT mixid,
              foodid,
              q AS Weight
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10000') x1,
           --
      --10001	Complete Protein (g)
      (SELECT mixid,
              foodid,
              q AS CompleteProtein
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10001') x2,
           --
      --10003	Digestible Carbohydrate (g)
      (SELECT mixid,
              foodid,
              q AS DigestibleCarbohydrate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10003') x4,
           --
      --10005	Cost (g)
      (SELECT mixid,
              foodid,
              q AS Cost
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10005') x5,
           --
      --203	Protein (g)
      (SELECT mixid,
              foodid,
              q AS Protein
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '203') x6,
           --
      --204	Total lipid (Fat) (g)
      (SELECT mixid,
              foodid,
              q AS Fat
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '204') x7,
           --205	Carbohydrate, by difference (g)
      (SELECT mixid,
              foodid,
              q AS Carbsbydiff
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '205') x8,
           --
      --208	Energy (kcal)
      (SELECT mixid,
              foodid,
              q AS Energy
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '208') x9,
           --221	Alcohol, ethyl (g)
      (SELECT mixid,
              foodid,
              q AS Alcohol
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '221') x13,
           --255	Water (g)
      (SELECT mixid,
              foodid,
              q AS Water
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '255') x14,
           --291	Fiber, total dietary (g)
      (SELECT mixid,
              foodid,
              q AS Fiber
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '291') x15,
           --301	Calcium, Ca (mg)
      (SELECT mixid,
              foodid,
              q AS Calcium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '301') x16,
           --303	Iron, Fe (mg)
      (SELECT mixid,
              foodid,
              q AS Iron
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '303') x17,
           --304	Magnesium, Mg (mg)
      (SELECT mixid,
              foodid,
              q AS Magnesium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '304') x18,
           --305	Phosphorus, P (mg)
      (SELECT mixid,
              foodid,
              q AS Phosphorus
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '305') x19,
           --306	Potassium, K (mg)
      (SELECT mixid,
              foodid,
              q AS Potassium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '306') x20,
           --307	Sodium, Na (mg)
      (SELECT mixid,
              foodid,
              q AS Sodium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '307') x21,
           --309	Zinc, Zn (mg)
      (SELECT mixid,
              foodid,
              q AS Zinc
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '309') x22,
           --312	Copper, Cu (mg)
      (SELECT mixid,
              foodid,
              q AS Copper
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '312') x23,
           --315	Manganese, Mn (mg)
      (SELECT mixid,
              foodid,
              q AS Manganese
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '315') x25,
           --317	Selenium, Se (µg)
      (SELECT mixid,
              foodid,
              q AS Selenium
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '317') x26,
           --320	Vitamin A, RAE (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '320') x27,
           --323	Vitamin E (Alpha-Tocopherol) (mg)
      (SELECT mixid,
              foodid,
              q AS VitaminE
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '323') x28,
           --328	Vitamin D (D2 + D3) (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminD
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '328') x29,
           --401	Vitamin C, total (Ascorbic Acid) (mg)
      (SELECT mixid,
              foodid,
              q AS VitaminC
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '401') x30,
           --404	Thiamin (mg)
      (SELECT mixid,
              foodid,
              q AS Thiamin
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '404') x31,
           --405	Riboflavin (mg)
      (SELECT mixid,
              foodid,
              q AS Riboflavin
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '405') x32,
           --406	Niacin (mg)
      (SELECT mixid,
              foodid,
              q AS Niacin
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '406') x33,
           --410	Pantothenic acid (mg)
      (SELECT mixid,
              foodid,
              q AS Pantothenic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '410') x34,
           --415	Vitamin B-6 (mg)
      (SELECT mixid,
              foodid,
              q AS VitaminB6
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '415') x35,
           --418	Vitamin B-12 (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminB12
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '418') x36,
           --421	Choline, total (mg)
      (SELECT mixid,
              foodid,
              q AS Choline
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '421') x37,
           --430	Vitamin K (Phylloquinone) (µg)
      (SELECT mixid,
              foodid,
              q AS VitaminK
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '430') x38,
           --435	Folate, DFE (µg)
      (SELECT mixid,
              foodid,
              q AS Folate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '435') x39,
           --601	Cholesterol (mg)
      (SELECT mixid,
              foodid,
              q AS Cholesterol
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '601') x40,
           --606	Fatty acids, total saturated (g)
      (SELECT mixid,
              foodid,
              q AS Saturated
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '606') x41,
           --621	22:6 n-3 (DHA) (g)
      (SELECT mixid,
              foodid,
              q AS DHA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '621') x42,
           --629	20:5 n-3 (EPA) (g)
      (SELECT mixid,
              foodid,
              q AS EPA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '629') x43,
           --645	Fatty acids, total monounsaturated (g)
      (SELECT mixid,
              foodid,
              q AS Monounsaturated
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '645') x44,
           --646	Fatty acids, total polyunsaturated (g)
      (SELECT mixid,
              foodid,
              q AS Polyunsaturated
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '646') x45,
           --618	18:2 undifferentiated (Linoleic) (g)
      (SELECT mixid,
              foodid,
              q AS Linoleic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '618') x46,
           --619	18:3 undifferentiated (Linolenic) (g)
      (SELECT mixid,
              foodid,
              q AS AlphaLinolenic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '619') x47,
           --10006	Glycemic Load
      (SELECT mixid,
              foodid,
              q AS GlycemicLoad
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10006') x50,
           --10009	Energy, digestible (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyDigestible
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10009') x51,
           --10011	Energy, carbohydrate (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyCarbohydrate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10011') x53,
           --10012	Energy, protein (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyProtein
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10012') x54,
           --10013	Energy, fat (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyFat
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10013') x55,
           --10014	Energy, no alcohol (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyAlcohol
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10014') x56,
            --10010	Energy, fat and carbohydrate (kcal)
      (SELECT mixid,
              foodid,
              q AS EnergyFatCarbohydrate
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10010') x57,
           --611, Lauric, 12:0 (g)
      (SELECT mixid,
              foodid,
              q AS Lauric
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '611') x58,
           --612, Myristic, 14:0 (g)
      (SELECT mixid,
              foodid,
              q AS Myristic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '612') x59,
           --613, Palmitic, 16:0 (g)
      (SELECT mixid,
              foodid,
              q AS Palmitic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '613') x60,
           --614, Stearic, 18:0 (g)
      (SELECT mixid,
              foodid,
              q AS Stearic
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '614') x61,
         --10015, Fats, Saturated Fatty Acids, HC (g)
      (SELECT mixid,
              foodid,
              q AS HCSFA
       FROM mixresult
       WHERE mixid = v_MixId
       AND   nutrientid = '10015') x62
      --
      WHERE x0.mixid = x1.mixid
      AND   x0.foodid = x1.foodid
      AND   x0.mixid = x2.mixid
      AND   x0.foodid = x2.foodid
      AND   x0.mixid = x4.mixid
      AND   x0.foodid = x4.foodid
      AND   x0.mixid = x5.mixid
      AND   x0.foodid = x5.foodid
      AND   x0.mixid = x6.mixid
      AND   x0.foodid = x6.foodid
      AND   x0.mixid = x7.mixid
      AND   x0.foodid = x7.foodid
      AND   x0.mixid = x8.mixid
      AND   x0.foodid = x8.foodid
      AND   x0.mixid = x9.mixid
      AND   x0.foodid = x9.foodid
      AND   x0.mixid = x13.mixid
      AND   x0.foodid = x13.foodid
      AND   x0.mixid = x14.mixid
      AND   x0.foodid = x14.foodid
      AND   x0.mixid = x15.mixid
      AND   x0.foodid = x15.foodid
      AND   x0.mixid = x16.mixid
      AND   x0.foodid = x16.foodid
      AND   x0.mixid = x17.mixid
      AND   x0.foodid = x17.foodid
      AND   x0.mixid = x18.mixid
      AND   x0.foodid = x18.foodid
      AND   x0.mixid = x19.mixid
      AND   x0.foodid = x19.foodid
      AND   x0.mixid = x20.mixid
      AND   x0.foodid = x20.foodid
      AND   x0.mixid = x21.mixid
      AND   x0.foodid = x21.foodid
      AND   x0.mixid = x22.mixid
      AND   x0.foodid = x22.foodid
      AND   x0.mixid = x23.mixid
      AND   x0.foodid = x23.foodid
      AND   x0.mixid = x25.mixid
      AND   x0.foodid = x25.foodid
      AND   x0.mixid = x26.mixid
      AND   x0.foodid = x26.foodid
      AND   x0.mixid = x27.mixid
      AND   x0.foodid = x27.foodid
      AND   x0.mixid = x28.mixid
      AND   x0.foodid = x28.foodid
      AND   x0.mixid = x29.mixid
      AND   x0.foodid = x29.foodid
      AND   x0.mixid = x30.mixid
      AND   x0.foodid = x30.foodid
      AND   x0.mixid = x31.mixid
      AND   x0.foodid = x31.foodid
      AND   x0.mixid = x32.mixid
      AND   x0.foodid = x32.foodid
      AND   x0.mixid = x33.mixid
      AND   x0.foodid = x33.foodid
      AND   x0.mixid = x34.mixid
      AND   x0.foodid = x34.foodid
      AND   x0.mixid = x35.mixid
      AND   x0.foodid = x35.foodid
      AND   x0.mixid = x36.mixid
      AND   x0.foodid = x36.foodid
      AND   x0.mixid = x37.mixid
      AND   x0.foodid = x37.foodid
      AND   x0.mixid = x38.mixid
      AND   x0.foodid = x38.foodid
      AND   x0.mixid = x39.mixid
      AND   x0.foodid = x39.foodid
      AND   x0.mixid = x40.mixid
      AND   x0.foodid = x40.foodid
      AND   x0.mixid = x41.mixid
      AND   x0.foodid = x41.foodid
      AND   x0.mixid = x42.mixid
      AND   x0.foodid = x42.foodid
      AND   x0.mixid = x43.mixid
      AND   x0.foodid = x43.foodid
      AND   x0.mixid = x44.mixid
      AND   x0.foodid = x44.foodid
      AND   x0.mixid = x45.mixid
      AND   x0.foodid = x45.foodid
      AND   x0.mixid = x46.mixid
      AND   x0.foodid = x46.foodid
      AND   x0.mixid = x47.mixid
      AND   x0.foodid = x47.foodid
      AND   x0.mixid = x50.mixid
      AND   x0.foodid = x50.foodid
      AND   x0.mixid = x51.mixid
      AND   x0.foodid = x51.foodid
      AND   x0.mixid = x53.mixid
      AND   x0.foodid = x53.foodid
      AND   x0.mixid = x54.mixid
      AND   x0.foodid = x54.foodid
      AND   x0.mixid = x55.mixid
      AND   x0.foodid = x55.foodid
      AND   x0.mixid = x56.mixid
      AND   x0.foodid = x56.foodid
      AND   x0.mixid = x57.mixid
      AND   x0.foodid = x57.foodid
      AND   x0.mixid = x58.mixid
      AND   x0.foodid = x58.foodid
      AND   x0.mixid = x59.mixid
      AND   x0.foodid = x59.foodid
      AND   x0.mixid = x60.mixid
      AND   x0.foodid = x60.foodid
      AND   x0.mixid = x61.mixid
      AND   x0.foodid = x61.foodid
      AND   x0.mixid = x62.mixid
      AND   x0.foodid = x62.foodid) a,
     (SELECT foodid, name FROM food) b
WHERE a.foodid = b.foodid;
--
END;
/


CREATE PROCEDURE mixresultdn_delete (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
delete from mixresultdn where mixid = v_MixId;
--
END;
/


CREATE PROCEDURE food_differences_procedure (
--
IN v_food_a LONGVARCHAR,
IN v_food_b LONGVARCHAR,
IN v_precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
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
       round(a.food_a,5) as food_a,
       round(a.food_b,5) as food_b,
       round(a.diff,5) as diff
FROM (SELECT a.nutrientid,
             a.value AS food_a,
             b.value AS food_b,
             b.value - a.value AS diff
      FROM (SELECT nutrientid,
                   c * 100 AS value
            FROM foodfactcoefficient
            WHERE foodid = v_food_a
            ) a,
           (SELECT nutrientid,
                   c * 100 AS value
            FROM foodfactcoefficient
            WHERE foodid = v_food_b
            ) b
      WHERE a.nutrientid = b.nutrientid) a,
     (SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
WHERE a.nutrientid = b.nutrientid) B
WHERE a.nutrientcategoryid = b.nutrientcategoryid
ORDER BY a.name, b.name;
--
OPEN result;
--
END;
/


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


CREATE PROCEDURE Meal_insert (
IN v_MixId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_MealOrder INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Meal (
MixId,
Name,
MealOrder
) VALUES (
v_MixId,
v_Name,
v_MealOrder
);
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
IN v_MixId LONGVARCHAR,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT MixId,
       c.MealId,
       b.FoodId,
       c.Name,
       b.Name,
       ROUND(a.Pct * 100,v_Precision),
       ROUND(a.ExpectedWt,v_Precision),
       ROUND(a.ActualWt,v_Precision),
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

CREATE PROCEDURE MealFoodPortion_update_pct (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE MealFoodPortion
SET
Pct = v_Pct
WHERE
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId;
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

CREATE PROCEDURE MealFoodPortion_insert_and_calculate_01 (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
DECLARE v_Pct_d DOUBLE;
SET v_Pct_d = v_Pct/100;
CALL MealFoodPortion_update_pct(v_MixId,v_MealId,v_FoodId,v_Pct_d);
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
SET doc = doc +  '<meal>' + CHAR(10) + '<mixid>' + mixid + '</mixid>' + CHAR(10)  + '<mealid>' + mealid + '</mealid>' + CHAR(10) + '<name>' + escape_xml_element_data(name) + '</name>' + CHAR(10)  + '<mealorder>'  + mealorder + '</mealorder>' + CHAR(10) + '</meal>' + CHAR (10);
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
SET doc = doc +  '<meal_food_portion>' + CHAR (10) + '<mixid>' + mixid + '</mixid>' + CHAR (10) + '<mealid>' + mealid + '</mealid>' + CHAR (10) + '<foodid>' + foodid + '</foodid>' + CHAR (10) + '<pct>' + pct + '</pct>' + CHAR (10) + '<expectedwt>' + expectedwt + '</expectedwt>' + CHAR (10) + '<actualwt>' + actualwt + '</actualwt>'  + CHAR (10) + '</meal_food_portion>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</meal_food_portion_list>';
--
SET v_doc = doc;
--
END
/

CREATE PROCEDURE Export_xml (IN v_MixId LONGVARCHAR)
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
SET doc2 = '<snack' + CHAR(10) + 'xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''' + CHAR(10) + 'xsi:noNamespaceSchemaLocation=''https://xjrga.github.io/schemas/snack_v8.xsd''>' + CHAR (10);
--
call Select_mix_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_mixfood_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_category_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_category_link_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_nutrient_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_foodnutrient_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
call Select_foodnutrient_ratio_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_nutrient_ratio_constraint_list_as_xml (doc,v_MixId);
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
CALL mixresultdn_copy(v_MixId_Old,v_MixId_New);
--
CALL meal_copy(v_MixId_Old,v_MixId_New);
--
CALL meal_food_portion_copy(v_MixId_Old,v_MixId_New);
--
END;
/

CREATE PROCEDURE results_by_meal_select (IN v_MixId LONGVARCHAR,IN v_Precision INTEGER) 
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 
BEGIN ATOMIC 
DECLARE result CURSOR
FOR
--
SELECT a.name,
       ROUND(a.amt,v_Precision) AS weight,
       ROUND(b.amt,v_Precision) AS egross,
       ROUND(c.amt,v_Precision) AS edigest,
       ROUND(d.amt,v_Precision) AS efat,
       ROUND(e.amt,v_Precision) AS ecarbs,
       ROUND(m.amt,v_Precision) AS efatcarbs,
       ROUND(f.amt,v_Precision) AS eprotein,
       ROUND(g.amt,v_Precision) AS ealcohol,
       ROUND(h.amt,v_Precision) AS fat,
       ROUND(i.amt,v_Precision) AS carbs,
       ROUND(j.amt,v_Precision) AS protein,
       ROUND(k.amt,v_Precision) AS complete,
       ROUND(l.amt,v_Precision) AS alcohol,
       ROUND(n.amt,v_Precision) AS fiber,
       ROUND(o.amt,v_Precision) AS sodium,
       ROUND(p.amt,v_Precision) AS potassium
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
       ROUND(a.amt,v_Precision) AS weight,
       ROUND(b.amt,v_Precision) AS egross,
       ROUND(c.amt,v_Precision) AS edigest,
       ROUND(d.amt,v_Precision) AS efat,
       ROUND(e.amt,v_Precision) AS ecarbs,
       ROUND(m.amt,v_Precision) AS efatcarbs,
       ROUND(f.amt,v_Precision) AS eprotein,
       ROUND(g.amt,v_Precision) AS ealcohol,
       ROUND(h.amt,v_Precision) AS fat,
       ROUND(i.amt,v_Precision) AS carbs,
       ROUND(j.amt,v_Precision) AS protein,
       ROUND(k.amt,v_Precision) AS complete,
       ROUND(l.amt,v_Precision) AS alcohol,
       ROUND(n.amt,v_Precision) AS fiber,
       ROUND(o.amt,v_Precision) AS sodium,
       ROUND(p.amt,v_Precision) AS potassium
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
DECLARE v_carbsbydiff DOUBLE;
DECLARE v_fiber DOUBLE;
DECLARE v_digestible_carbohydrate DOUBLE;
DECLARE v_energy_alcohol DOUBLE;
DECLARE v_energy_carbohydrate DOUBLE;
DECLARE v_energy_fat DOUBLE;
DECLARE v_energy_protein DOUBLE;
DECLARE v_gi DOUBLE;
DECLARE v_lauric DOUBLE;
DECLARE v_myristic DOUBLE;
DECLARE v_palmitic DOUBLE;
DECLARE v_hcsfa DOUBLE;
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
-- glycemic_load
SELECT q  INTO v_gi FROM glycemicindex WHERE foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10006',v_digestible_carbohydrate*v_gi/100);
--
--hcsfa
SELECT q INTO v_lauric FROM foodfact WHERE nutrientid = '611' AND foodid = v_foodid;
SELECT q INTO v_myristic FROM foodfact  WHERE nutrientid = '612' AND foodid = v_foodid;
SELECT q INTO v_palmitic FROM foodfact  WHERE nutrientid = '613' AND foodid = v_foodid;
SET v_hcsfa = v_lauric + v_myristic + v_palmitic;
CALL foodfact_merge (v_foodid,'10015',v_hcsfa);
--
--
END;
/

CREATE PROCEDURE GlycemicIndex_select (
IN v_FoodId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
FoodId,
q
FROM
GlycemicIndex
WHERE
FoodId = v_FoodId;
OPEN result;
END;
/

CREATE PROCEDURE Select_food_as_xml (
--
IN v_FoodId LONGVARCHAR
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
DECLARE v_gi DOUBLE;
--
SET doc = '';
SET doc2 = '<food' + CHAR(10) + 'xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''' + CHAR(10) + 'xsi:noNamespaceSchemaLocation=''https://xjrga.github.io/schemas/food_v2.xsd''>' + CHAR (10);
--
FOR SELECT foodid as id ,name FROM food WHERE  foodid  = v_FoodId DO
--
SET doc = '<food-id>'+id +'</food-id>' + CHAR (10) + '<food-name>'+ escape_xml_element_data(name) +'</food-name>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT * FROM (SELECT LABEL, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = v_FoodId AND   Y.NUTRIENTID = Z.NUTRIENTID AND   (Y.NUTRIENTID != '10003' AND Y.NUTRIENTID != '10006' AND Y.NUTRIENTID != '10009' AND Y.NUTRIENTID != '10010' AND Y.NUTRIENTID != '10011' AND Y.NUTRIENTID != '10012' AND Y.NUTRIENTID != '10013' AND Y.NUTRIENTID != '10014' AND Y.NUTRIENTID != '10015') UNION SELECT 'carbohydrates-glycemicindex' AS LABEL, pick_food_gi(v_FoodId) FROM (VALUES(0)) ) ORDER BY LABEL DO
--
SET doc = '<'+label +'>'+cast(q as decimal(128,32)) +'</'+label +'>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc2 = doc2 + '</food>' + CHAR (10);
--
END FOR;
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


CREATE PROCEDURE get_essential_fat_ratio_difference (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Ratio LA/ALA' AS nutrient,
       ROUND(a.ratio,v_Precision) AS mix1,
       ROUND(b.ratio,v_Precision) AS mix2,
       ROUND(b.ratio - a.ratio,v_Precision) AS diff
FROM (SELECT get_essential_fat_ratio(v_MixId_1) AS ratio FROM ( VALUES (0))) a,
     (SELECT get_essential_fat_ratio(v_MixId_2) AS ratio FROM ( VALUES (0))) b;
--
OPEN result;
--
END;
/

CREATE PROCEDURE get_electrolyte_ratio_difference (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Ratio K/Na' AS nutrient,
       ROUND(a.ratio,v_Precision) AS mix1,
       ROUND(b.ratio,v_Precision) AS mix2,
       ROUND(b.ratio - a.ratio,v_Precision) AS diff
FROM (SELECT get_electrolyte_ratio(v_MixId_1) AS ratio FROM ( VALUES (0))) a,
     (SELECT get_electrolyte_ratio(v_MixId_2) AS ratio FROM ( VALUES (0))) b;
--
OPEN result;
--
END;
/

CREATE PROCEDURE get_monoufat_ratio_difference (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Ratio MUFA/SFA' AS nutrient,
       ROUND(a.ratio,v_Precision) AS mix1,
       ROUND(b.ratio,v_Precision) AS mix2,
       ROUND(b.ratio - a.ratio,v_Precision) AS diff
FROM (SELECT get_monoufat_ratio(v_MixId_1) AS ratio FROM ( VALUES (0))) a,
     (SELECT get_monoufat_ratio(v_MixId_2) AS ratio FROM ( VALUES (0))) b;
--
OPEN result;
--
END;
/

CREATE PROCEDURE get_polyufat_ratio_difference (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Ratio PUFA/SFA' AS nutrient,
       ROUND(a.ratio,v_Precision) AS mix1,
       ROUND(b.ratio,v_Precision) AS mix2,
       ROUND(b.ratio - a.ratio,v_Precision) AS diff
FROM (SELECT get_polyufat_ratio(v_MixId_1) AS ratio FROM ( VALUES (0))) a,
     (SELECT get_polyufat_ratio(v_MixId_2) AS ratio FROM ( VALUES (0))) b;
--
OPEN result;
--
END;
/

CREATE PROCEDURE getMixCoefficients (
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
       getfoodcoefficient(b.foodid,b.nutrientid) as c
FROM mixfood a,
     foodfactcoefficient b,
     (SELECT nutrientid
      FROM (SELECT nutrientid
            FROM nutrientconstraint
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_1
            FROM nutrientratio
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_2
            FROM nutrientratio
            WHERE mixid =mixid
            UNION
            SELECT nutrientid
            FROM foodnutrientconstraint
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_1
            FROM foodnutrientratio
            WHERE mixid =mixid
            UNION
            SELECT nutrient_id_2
            FROM foodnutrientratio
            WHERE mixid =mixid)) c
WHERE a.foodid = b.foodid
AND   b.nutrientid = c.nutrientid
AND   a.mixid =mixid
ORDER BY b.foodid,b.nutrientid;
--
OPEN result;
--
END;
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
      FROM nutrientconstraint
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM nutrientratio
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM nutrientratio
      WHERE mixid = v_mixid
      UNION
      SELECT nutrientid
      FROM foodnutrientconstraint
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM foodnutrientratio
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM foodnutrientratio
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


CREATE PROCEDURE getDri()
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
       13 AS n203,
       14 AS n204,
       15 AS n205,
       16 AS n208,
       17 AS n221,
       18 AS n255,
       19 AS n291,
       20 AS n301,
       21 AS n303,
       22 AS n304,
       23 AS n305,
       24 AS n306,
       25 AS n307,
       26 AS n309,
       27 AS n312,
       28 AS n315,
       29 AS n317,
       30 AS n320,
       31 AS n323,
       32 AS n328,
       33 AS n401,
       34 AS n404,
       35 AS n405,
       36 AS n406,
       37 AS n410,
       38 AS n415,
       39 AS n418,
       40 AS n421,
       41 AS n430,
       42 AS n435,
       43 AS n601,
       44 AS n606,
       45 AS n611,
       46 AS n612,
       47 AS n613,
       48 AS n614,
       49 AS n618,
       50 AS n619,
       51 AS n621,
       52 AS n629,
       53 AS n645,
       54 AS n646
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


CREATE PROCEDURE populate_zff (IN v_mixid LONGVARCHAR) MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO zff
(
  row,
  mixid,
  foodid,
  n10000,
  n10001,
  n10003,
  n10005,
  n10006,
  n10009,
  n10010,
  n10011,
  n10012,
  n10013,
  n10014,
  n10015,
  n203,
  n204,
  n205,
  n208,
  n221,
  n255,
  n291,
  n301,
  n303,
  n304,
  n305,
  n306,
  n307,
  n309,
  n312,
  n315,
  n317,
  n320,
  n323,
  n328,
  n401,
  n404,
  n405,
  n406,
  n410,
  n415,
  n418,
  n421,
  n430,
  n435,
  n601,
  n606,
  n611,
  n612,
  n613,
  n614,
  n618,
  n619,
  n621,
  n629,
  n645,
  n646
)
SELECT ROWNUM(),
       a.*
FROM (SELECT a1.mixid AS mixid,
             a1.foodid AS foodid,
             a1.q AS n10000,
             a2.q AS n10001,
             a3.q AS n10003,
             a4.q AS n10005,
             a5.q AS n10006,
             a6.q AS n10009,
             a7.q AS n10010,
             a8.q AS n10011,
             a9.q AS n10012,
             a10.q AS n10013,
             a11.q AS n10014,
             a12.q AS n10015,
             a13.q AS n203,
             a14.q AS n204,
             a15.q AS n205,
             a16.q AS n208,
             a17.q AS n221,
             a18.q AS n255,
             a19.q AS n291,
             a20.q AS n301,
             a21.q AS n303,
             a22.q AS n304,
             a23.q AS n305,
             a24.q AS n306,
             a25.q AS n307,
             a26.q AS n309,
             a27.q AS n312,
             a28.q AS n315,
             a29.q AS n317,
             a30.q AS n320,
             a31.q AS n323,
             a32.q AS n328,
             a33.q AS n401,
             a34.q AS n404,
             a35.q AS n405,
             a36.q AS n406,
             a37.q AS n410,
             a38.q AS n415,
             a39.q AS n418,
             a40.q AS n421,
             a41.q AS n430,
             a42.q AS n435,
             a43.q AS n601,
             a44.q AS n606,
             a45.q AS n611,
             a46.q AS n612,
             a47.q AS n613,
             a48.q AS n614,
             a49.q AS n618,
             a50.q AS n619,
             a51.q AS n621,
             a52.q AS n629,
             a53.q AS n645,
             a54.q AS n646
      FROM (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10000'
            AND   a.mixid = v_mixid) a1,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10001'
            AND   a.mixid = v_mixid) a2,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10003'
            AND   a.mixid = v_mixid) a3,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10005'
            AND   a.mixid = v_mixid) a4,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10006'
            AND   a.mixid = v_mixid) a5,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10009'
            AND   a.mixid = v_mixid) a6,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10010'
            AND   a.mixid = v_mixid) a7,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10011'
            AND   a.mixid = v_mixid) a8,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10012'
            AND   a.mixid = v_mixid) a9,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10013'
            AND   a.mixid = v_mixid) a10,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10014'
            AND   a.mixid = v_mixid) a11,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10015'
            AND   a.mixid = v_mixid) a12,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '203'
            AND   a.mixid = v_mixid) a13,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '204'
            AND   a.mixid = v_mixid) a14,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '205'
            AND   a.mixid = v_mixid) a15,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '208'
            AND   a.mixid = v_mixid) a16,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '221'
            AND   a.mixid = v_mixid) a17,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '255'
            AND   a.mixid = v_mixid) a18,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '291'
            AND   a.mixid = v_mixid) a19,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '301'
            AND   a.mixid = v_mixid) a20,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '303'
            AND   a.mixid = v_mixid) a21,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '304'
            AND   a.mixid = v_mixid) a22,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '305'
            AND   a.mixid = v_mixid) a23,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '306'
            AND   a.mixid = v_mixid) a24,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '307'
            AND   a.mixid = v_mixid) a25,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '309'
            AND   a.mixid = v_mixid) a26,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '312'
            AND   a.mixid = v_mixid) a27,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '315'
            AND   a.mixid = v_mixid) a28,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '317'
            AND   a.mixid = v_mixid) a29,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '320'
            AND   a.mixid = v_mixid) a30,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '323'
            AND   a.mixid = v_mixid) a31,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '328'
            AND   a.mixid = v_mixid) a32,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '401'
            AND   a.mixid = v_mixid) a33,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '404'
            AND   a.mixid = v_mixid) a34,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '405'
            AND   a.mixid = v_mixid) a35,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '406'
            AND   a.mixid = v_mixid) a36,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '410'
            AND   a.mixid = v_mixid) a37,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '415'
            AND   a.mixid = v_mixid) a38,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '418'
            AND   a.mixid = v_mixid) a39,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '421'
            AND   a.mixid = v_mixid) a40,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '430'
            AND   a.mixid = v_mixid) a41,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '435'
            AND   a.mixid = v_mixid) a42,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '601'
            AND   a.mixid = v_mixid) a43,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '606'
            AND   a.mixid = v_mixid) a44,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '611'
            AND   a.mixid = v_mixid) a45,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '612'
            AND   a.mixid = v_mixid) a46,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '613'
            AND   a.mixid = v_mixid) a47,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '614'
            AND   a.mixid = v_mixid) a48,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '618'
            AND   a.mixid = v_mixid) a49,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '619'
            AND   a.mixid = v_mixid) a50,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '621'
            AND   a.mixid = v_mixid) a51,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '629'
            AND   a.mixid = v_mixid) a52,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '645'
            AND   a.mixid = v_mixid) a53,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '646'
            AND   a.mixid = v_mixid) a54
      WHERE a1.mixid = a2.mixid
      AND   a1.foodid = a2.foodid
      AND   a1.mixid = a3.mixid
      AND   a1.foodid = a3.foodid
      AND   a1.mixid = a4.mixid
      AND   a1.foodid = a4.foodid
      AND   a1.mixid = a5.mixid
      AND   a1.foodid = a5.foodid
      AND   a1.mixid = a6.mixid
      AND   a1.foodid = a6.foodid
      AND   a1.mixid = a7.mixid
      AND   a1.foodid = a7.foodid
      AND   a1.mixid = a8.mixid
      AND   a1.foodid = a8.foodid
      AND   a1.mixid = a9.mixid
      AND   a1.foodid = a9.foodid
      AND   a1.mixid = a10.mixid
      AND   a1.foodid = a10.foodid
      AND   a1.mixid = a11.mixid
      AND   a1.foodid = a11.foodid
      AND   a1.mixid = a12.mixid
      AND   a1.foodid = a12.foodid
      AND   a1.mixid = a13.mixid
      AND   a1.foodid = a13.foodid
      AND   a1.mixid = a14.mixid
      AND   a1.foodid = a14.foodid
      AND   a1.mixid = a15.mixid
      AND   a1.foodid = a15.foodid
      AND   a1.mixid = a16.mixid
      AND   a1.foodid = a16.foodid
      AND   a1.mixid = a17.mixid
      AND   a1.foodid = a17.foodid
      AND   a1.mixid = a18.mixid
      AND   a1.foodid = a18.foodid
      AND   a1.mixid = a19.mixid
      AND   a1.foodid = a19.foodid
      AND   a1.mixid = a20.mixid
      AND   a1.foodid = a20.foodid
      AND   a1.mixid = a21.mixid
      AND   a1.foodid = a21.foodid
      AND   a1.mixid = a22.mixid
      AND   a1.foodid = a22.foodid
      AND   a1.mixid = a23.mixid
      AND   a1.foodid = a23.foodid
      AND   a1.mixid = a24.mixid
      AND   a1.foodid = a24.foodid
      AND   a1.mixid = a25.mixid
      AND   a1.foodid = a25.foodid
      AND   a1.mixid = a26.mixid
      AND   a1.foodid = a26.foodid
      AND   a1.mixid = a27.mixid
      AND   a1.foodid = a27.foodid
      AND   a1.mixid = a28.mixid
      AND   a1.foodid = a28.foodid
      AND   a1.mixid = a29.mixid
      AND   a1.foodid = a29.foodid
      AND   a1.mixid = a30.mixid
      AND   a1.foodid = a30.foodid
      AND   a1.mixid = a31.mixid
      AND   a1.foodid = a31.foodid
      AND   a1.mixid = a32.mixid
      AND   a1.foodid = a32.foodid
      AND   a1.mixid = a33.mixid
      AND   a1.foodid = a33.foodid
      AND   a1.mixid = a34.mixid
      AND   a1.foodid = a34.foodid
      AND   a1.mixid = a35.mixid
      AND   a1.foodid = a35.foodid
      AND   a1.mixid = a36.mixid
      AND   a1.foodid = a36.foodid
      AND   a1.mixid = a37.mixid
      AND   a1.foodid = a37.foodid
      AND   a1.mixid = a38.mixid
      AND   a1.foodid = a38.foodid
      AND   a1.mixid = a39.mixid
      AND   a1.foodid = a39.foodid
      AND   a1.mixid = a40.mixid
      AND   a1.foodid = a40.foodid
      AND   a1.mixid = a41.mixid
      AND   a1.foodid = a41.foodid
      AND   a1.mixid = a42.mixid
      AND   a1.foodid = a42.foodid
      AND   a1.mixid = a43.mixid
      AND   a1.foodid = a43.foodid
      AND   a1.mixid = a44.mixid
      AND   a1.foodid = a44.foodid
      AND   a1.mixid = a45.mixid
      AND   a1.foodid = a45.foodid
      AND   a1.mixid = a46.mixid
      AND   a1.foodid = a46.foodid
      AND   a1.mixid = a47.mixid
      AND   a1.foodid = a47.foodid
      AND   a1.mixid = a48.mixid
      AND   a1.foodid = a48.foodid
      AND   a1.mixid = a49.mixid
      AND   a1.foodid = a49.foodid
      AND   a1.mixid = a50.mixid
      AND   a1.foodid = a50.foodid
      AND   a1.mixid = a51.mixid
      AND   a1.foodid = a51.foodid
      AND   a1.mixid = a52.mixid
      AND   a1.foodid = a52.foodid
      AND   a1.mixid = a53.mixid
      AND   a1.foodid = a53.foodid
      AND   a1.mixid = a54.mixid
      AND   a1.foodid = a54.foodid
      ORDER BY a1.foodid
      ) a
ORDER BY a.foodid;
--
END;
/


CREATE PROCEDURE save_zff(
IN v_mixid LONGVARCHAR
)
MODIFIES SQL DATA
BEGIN ATOMIC
--
DELETE FROM ZFF WHERE mixid = v_mixid;
--
CALL populate_zff(v_mixid);
--
END;
/

CREATE PROCEDURE get_zff(
IN v_mixid LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR
FOR
--
SELECT a.row,
       a.n10000,
       a.n10001,
       a.n10003,
       a.n10005,
       a.n10006,
       a.n10009,
       a.n10010,
       a.n10011,
       a.n10012,
       a.n10013,
       a.n10014,
       a.n10015,
       a.n203,
       a.n204,
       a.n205,
       a.n208,
       a.n221,
       a.n255,
       a.n291,
       a.n301,
       a.n303,
       a.n304,
       a.n305,
       a.n306,
       a.n307,
       a.n309,
       a.n312,
       a.n315,
       a.n317,
       a.n320,
       a.n323,
       a.n328,
       a.n401,
       a.n404,
       a.n405,
       a.n406,
       a.n410,
       a.n415,
       a.n418,
       a.n421,
       a.n430,
       a.n435,
       a.n601,
       a.n606,
       a.n611,
       a.n612,
       a.n613,
       a.n614,
       a.n618,
       a.n619,
       a.n621,
       a.n629,
       a.n645,
       a.n646
FROM (SELECT '' AS mixid,
             '' AS foodid,
             0 AS ROW,
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
             13 AS n203,
             14 AS n204,
             15 AS n205,
             16 AS n208,
             17 AS n221,
             18 AS n255,
             19 AS n291,
             20 AS n301,
             21 AS n303,
             22 AS n304,
             23 AS n305,
             24 AS n306,
             25 AS n307,
             26 AS n309,
             27 AS n312,
             28 AS n315,
             29 AS n317,
             30 AS n320,
             31 AS n323,
             32 AS n328,
             33 AS n401,
             34 AS n404,
             35 AS n405,
             36 AS n406,
             37 AS n410,
             38 AS n415,
             39 AS n418,
             40 AS n421,
             41 AS n430,
             42 AS n435,
             43 AS n601,
             44 AS n606,
             45 AS n611,
             46 AS n612,
             47 AS n613,
             48 AS n614,
             49 AS n618,
             50 AS n619,
             51 AS n621,
             52 AS n629,
             53 AS n645,
             54 AS n646
      FROM (
           VALUES (0))
      UNION
      SELECT *
      FROM zff
      WHERE mixid = v_mixid) a
ORDER BY a.foodid;
--
OPEN result;
--
END;
/

CREATE PROCEDURE populate_zfc (IN v_mixid LONGVARCHAR) MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO zfc
(
  row,
  mixid,
  foodid,
  n10000,
  n10001,
  n10003,
  n10005,
  n10006,
  n10009,
  n10010,
  n10011,
  n10012,
  n10013,
  n10014,
  n10015,
  n203,
  n204,
  n205,
  n208,
  n221,
  n255,
  n291,
  n301,
  n303,
  n304,
  n305,
  n306,
  n307,
  n309,
  n312,
  n315,
  n317,
  n320,
  n323,
  n328,
  n401,
  n404,
  n405,
  n406,
  n410,
  n415,
  n418,
  n421,
  n430,
  n435,
  n601,
  n606,
  n611,
  n612,
  n613,
  n614,
  n618,
  n619,
  n621,
  n629,
  n645,
  n646
)
SELECT ROWNUM(),
       a.*
FROM (SELECT a1.mixid AS mixid,
             a1.foodid AS foodid,
             a1.c AS n10000,
             a2.c AS n10001,
             a3.c AS n10003,
             a4.c AS n10005,
             a5.c AS n10006,
             a6.c AS n10009,
             a7.c AS n10010,
             a8.c AS n10011,
             a9.c AS n10012,
             a10.c AS n10013,
             a11.c AS n10014,
             a12.c AS n10015,
             a13.c AS n203,
             a14.c AS n204,
             a15.c AS n205,
             a16.c AS n208,
             a17.c AS n221,
             a18.c AS n255,
             a19.c AS n291,
             a20.c AS n301,
             a21.c AS n303,
             a22.c AS n304,
             a23.c AS n305,
             a24.c AS n306,
             a25.c AS n307,
             a26.c AS n309,
             a27.c AS n312,
             a28.c AS n315,
             a29.c AS n317,
             a30.c AS n320,
             a31.c AS n323,
             a32.c AS n328,
             a33.c AS n401,
             a34.c AS n404,
             a35.c AS n405,
             a36.c AS n406,
             a37.c AS n410,
             a38.c AS n415,
             a39.c AS n418,
             a40.c AS n421,
             a41.c AS n430,
             a42.c AS n435,
             a43.c AS n601,
             a44.c AS n606,
             a45.c AS n611,
             a46.c AS n612,
             a47.c AS n613,
             a48.c AS n614,
             a49.c AS n618,
             a50.c AS n619,
             a51.c AS n621,
             a52.c AS n629,
             a53.c AS n645,
             a54.c AS n646
      FROM (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10000'
            AND   a.mixid = v_mixid) a1,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10001'
            AND   a.mixid = v_mixid) a2,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10003'
            AND   a.mixid = v_mixid) a3,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10005'
            AND   a.mixid = v_mixid) a4,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10006'
            AND   a.mixid = v_mixid) a5,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10009'
            AND   a.mixid = v_mixid) a6,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10010'
            AND   a.mixid = v_mixid) a7,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10011'
            AND   a.mixid = v_mixid) a8,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10012'
            AND   a.mixid = v_mixid) a9,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10013'
            AND   a.mixid = v_mixid) a10,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10014'
            AND   a.mixid = v_mixid) a11,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10015'
            AND   a.mixid = v_mixid) a12,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '203'
            AND   a.mixid = v_mixid) a13,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '204'
            AND   a.mixid = v_mixid) a14,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '205'
            AND   a.mixid = v_mixid) a15,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '208'
            AND   a.mixid = v_mixid) a16,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '221'
            AND   a.mixid = v_mixid) a17,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '255'
            AND   a.mixid = v_mixid) a18,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '291'
            AND   a.mixid = v_mixid) a19,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '301'
            AND   a.mixid = v_mixid) a20,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '303'
            AND   a.mixid = v_mixid) a21,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '304'
            AND   a.mixid = v_mixid) a22,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '305'
            AND   a.mixid = v_mixid) a23,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '306'
            AND   a.mixid = v_mixid) a24,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '307'
            AND   a.mixid = v_mixid) a25,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '309'
            AND   a.mixid = v_mixid) a26,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '312'
            AND   a.mixid = v_mixid) a27,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '315'
            AND   a.mixid = v_mixid) a28,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '317'
            AND   a.mixid = v_mixid) a29,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '320'
            AND   a.mixid = v_mixid) a30,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '323'
            AND   a.mixid = v_mixid) a31,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '328'
            AND   a.mixid = v_mixid) a32,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '401'
            AND   a.mixid = v_mixid) a33,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '404'
            AND   a.mixid = v_mixid) a34,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '405'
            AND   a.mixid = v_mixid) a35,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '406'
            AND   a.mixid = v_mixid) a36,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '410'
            AND   a.mixid = v_mixid) a37,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '415'
            AND   a.mixid = v_mixid) a38,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '418'
            AND   a.mixid = v_mixid) a39,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '421'
            AND   a.mixid = v_mixid) a40,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '430'
            AND   a.mixid = v_mixid) a41,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '435'
            AND   a.mixid = v_mixid) a42,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '601'
            AND   a.mixid = v_mixid) a43,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '606'
            AND   a.mixid = v_mixid) a44,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '611'
            AND   a.mixid = v_mixid) a45,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '612'
            AND   a.mixid = v_mixid) a46,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '613'
            AND   a.mixid = v_mixid) a47,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '614'
            AND   a.mixid = v_mixid) a48,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '618'
            AND   a.mixid = v_mixid) a49,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '619'
            AND   a.mixid = v_mixid) a50,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '621'
            AND   a.mixid = v_mixid) a51,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '629'
            AND   a.mixid = v_mixid) a52,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '645'
            AND   a.mixid = v_mixid) a53,
           (SELECT a.mixid,
                   b.foodid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '646'
            AND   a.mixid = v_mixid) a54
      WHERE a1.mixid = a2.mixid
      AND   a1.foodid = a2.foodid
      AND   a1.mixid = a3.mixid
      AND   a1.foodid = a3.foodid
      AND   a1.mixid = a4.mixid
      AND   a1.foodid = a4.foodid
      AND   a1.mixid = a5.mixid
      AND   a1.foodid = a5.foodid
      AND   a1.mixid = a6.mixid
      AND   a1.foodid = a6.foodid
      AND   a1.mixid = a7.mixid
      AND   a1.foodid = a7.foodid
      AND   a1.mixid = a8.mixid
      AND   a1.foodid = a8.foodid
      AND   a1.mixid = a9.mixid
      AND   a1.foodid = a9.foodid
      AND   a1.mixid = a10.mixid
      AND   a1.foodid = a10.foodid
      AND   a1.mixid = a11.mixid
      AND   a1.foodid = a11.foodid
      AND   a1.mixid = a12.mixid
      AND   a1.foodid = a12.foodid
      AND   a1.mixid = a13.mixid
      AND   a1.foodid = a13.foodid
      AND   a1.mixid = a14.mixid
      AND   a1.foodid = a14.foodid
      AND   a1.mixid = a15.mixid
      AND   a1.foodid = a15.foodid
      AND   a1.mixid = a16.mixid
      AND   a1.foodid = a16.foodid
      AND   a1.mixid = a17.mixid
      AND   a1.foodid = a17.foodid
      AND   a1.mixid = a18.mixid
      AND   a1.foodid = a18.foodid
      AND   a1.mixid = a19.mixid
      AND   a1.foodid = a19.foodid
      AND   a1.mixid = a20.mixid
      AND   a1.foodid = a20.foodid
      AND   a1.mixid = a21.mixid
      AND   a1.foodid = a21.foodid
      AND   a1.mixid = a22.mixid
      AND   a1.foodid = a22.foodid
      AND   a1.mixid = a23.mixid
      AND   a1.foodid = a23.foodid
      AND   a1.mixid = a24.mixid
      AND   a1.foodid = a24.foodid
      AND   a1.mixid = a25.mixid
      AND   a1.foodid = a25.foodid
      AND   a1.mixid = a26.mixid
      AND   a1.foodid = a26.foodid
      AND   a1.mixid = a27.mixid
      AND   a1.foodid = a27.foodid
      AND   a1.mixid = a28.mixid
      AND   a1.foodid = a28.foodid
      AND   a1.mixid = a29.mixid
      AND   a1.foodid = a29.foodid
      AND   a1.mixid = a30.mixid
      AND   a1.foodid = a30.foodid
      AND   a1.mixid = a31.mixid
      AND   a1.foodid = a31.foodid
      AND   a1.mixid = a32.mixid
      AND   a1.foodid = a32.foodid
      AND   a1.mixid = a33.mixid
      AND   a1.foodid = a33.foodid
      AND   a1.mixid = a34.mixid
      AND   a1.foodid = a34.foodid
      AND   a1.mixid = a35.mixid
      AND   a1.foodid = a35.foodid
      AND   a1.mixid = a36.mixid
      AND   a1.foodid = a36.foodid
      AND   a1.mixid = a37.mixid
      AND   a1.foodid = a37.foodid
      AND   a1.mixid = a38.mixid
      AND   a1.foodid = a38.foodid
      AND   a1.mixid = a39.mixid
      AND   a1.foodid = a39.foodid
      AND   a1.mixid = a40.mixid
      AND   a1.foodid = a40.foodid
      AND   a1.mixid = a41.mixid
      AND   a1.foodid = a41.foodid
      AND   a1.mixid = a42.mixid
      AND   a1.foodid = a42.foodid
      AND   a1.mixid = a43.mixid
      AND   a1.foodid = a43.foodid
      AND   a1.mixid = a44.mixid
      AND   a1.foodid = a44.foodid
      AND   a1.mixid = a45.mixid
      AND   a1.foodid = a45.foodid
      AND   a1.mixid = a46.mixid
      AND   a1.foodid = a46.foodid
      AND   a1.mixid = a47.mixid
      AND   a1.foodid = a47.foodid
      AND   a1.mixid = a48.mixid
      AND   a1.foodid = a48.foodid
      AND   a1.mixid = a49.mixid
      AND   a1.foodid = a49.foodid
      AND   a1.mixid = a50.mixid
      AND   a1.foodid = a50.foodid
      AND   a1.mixid = a51.mixid
      AND   a1.foodid = a51.foodid
      AND   a1.mixid = a52.mixid
      AND   a1.foodid = a52.foodid
      AND   a1.mixid = a53.mixid
      AND   a1.foodid = a53.foodid
      AND   a1.mixid = a54.mixid
      AND   a1.foodid = a54.foodid
      ORDER BY a1.foodid
      ) a
ORDER BY a.foodid;
--
END;
/


CREATE PROCEDURE save_zfc(
IN v_mixid LONGVARCHAR
)
MODIFIES SQL DATA
BEGIN ATOMIC
--
DELETE FROM ZFC WHERE mixid = v_mixid;
--
CALL populate_zfc(v_mixid);
--
END;
/

CREATE PROCEDURE get_zfc(
IN v_mixid LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR
FOR
--
SELECT a.row,
       a.n10000,
       a.n10001,
       a.n10003,
       a.n10005,
       a.n10006,
       a.n10009,
       a.n10010,
       a.n10011,
       a.n10012,
       a.n10013,
       a.n10014,
       a.n10015,
       a.n203,
       a.n204,
       a.n205,
       a.n208,
       a.n221,
       a.n255,
       a.n291,
       a.n301,
       a.n303,
       a.n304,
       a.n305,
       a.n306,
       a.n307,
       a.n309,
       a.n312,
       a.n315,
       a.n317,
       a.n320,
       a.n323,
       a.n328,
       a.n401,
       a.n404,
       a.n405,
       a.n406,
       a.n410,
       a.n415,
       a.n418,
       a.n421,
       a.n430,
       a.n435,
       a.n601,
       a.n606,
       a.n611,
       a.n612,
       a.n613,
       a.n614,
       a.n618,
       a.n619,
       a.n621,
       a.n629,
       a.n645,
       a.n646
FROM (SELECT '' AS mixid,
             '' AS foodid,
             0 AS ROW,
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
             13 AS n203,
             14 AS n204,
             15 AS n205,
             16 AS n208,
             17 AS n221,
             18 AS n255,
             19 AS n291,
             20 AS n301,
             21 AS n303,
             22 AS n304,
             23 AS n305,
             24 AS n306,
             25 AS n307,
             26 AS n309,
             27 AS n312,
             28 AS n315,
             29 AS n317,
             30 AS n320,
             31 AS n323,
             32 AS n328,
             33 AS n401,
             34 AS n404,
             35 AS n405,
             36 AS n406,
             37 AS n410,
             38 AS n415,
             39 AS n418,
             40 AS n421,
             41 AS n430,
             42 AS n435,
             43 AS n601,
             44 AS n606,
             45 AS n611,
             46 AS n612,
             47 AS n613,
             48 AS n614,
             49 AS n618,
             50 AS n619,
             51 AS n621,
             52 AS n629,
             53 AS n645,
             54 AS n646
      FROM (
           VALUES (0))
      UNION
      SELECT *
      FROM zfc
      WHERE mixid = v_mixid) a
ORDER BY a.foodid;
--
OPEN result;
--
END;
/

CREATE PROCEDURE MixCost_merge (
IN v_Mixid LONGVARCHAR,
IN v_MixCost DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO MixCost USING ( VALUES (
v_Mixid,
v_MixCost
) ) ON (
Mixid = v_Mixid
)
WHEN MATCHED THEN UPDATE SET
MixCost = v_MixCost
WHEN NOT MATCHED THEN INSERT VALUES
v_Mixid,
v_MixCost;
END;
/


CREATE TRIGGER FoodFact_RowLevelAfterUpdate_Trigger AFTER UPDATE OF q ON FoodFact REFERENCING NEW ROW AS newrow OLD AS oldrow
--
FOR EACH ROW
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
IF newrow.NutrientId = '10000' THEN
--
FOR SELECT nutrientid FROM nutrient DO
--
SET v_c = getFoodCoefficient(newrow.FoodId,nutrientid);
--
call FoodFactCoefficient_Merge(newrow.FoodId,nutrientid,v_c);
--
END FOR;
--
ELSE
--
SET v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
--
CALL FoodFactCoefficient_Merge(newrow.FoodId,newrow.NutrientId, v_c);
--
END IF;
--
END;
/


CREATE TRIGGER FoodFact_RowLevelAfterInsert_Trigger AFTER INSERT ON FoodFact
REFERENCING NEW ROW AS newrow
FOR EACH ROW
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
SET v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
CALL FoodFactCoefficient_Merge(newrow.FoodId,newrow.NutrientId,v_c);
--
END;
/


CREATE TRIGGER MixCost_rlau_trigger AFTER UPDATE ON MixCost REFERENCING NEW AS new FOR EACH ROW
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.mixresultdn_delete(new.mixid);
CALL public.fill_mixresultdn(new.mixid);
CALL public.save_zff (new.mixid);
CALL public.save_zfc (new.mixid);
--
END;
/


CREATE TRIGGER MixCost_rlai_trigger AFTER INSERT ON MixCost REFERENCING NEW AS new FOR EACH ROW
--
BEGIN ATOMIC
--
CALL public.fill_mixresult(new.mixid);
CALL public.mixresultdn_delete(new.mixid);
CALL public.fill_mixresultdn(new.mixid);
CALL public.save_zff (new.mixid);
CALL public.save_zfc (new.mixid);
--
END;
/


