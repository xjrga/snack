DROP SCHEMA PUBLIC CASCADE;
/

CREATE TABLE FoodFactCoefficient
(
FoodId LONGVARCHAR,
NutrientId LONGVARCHAR,
c DOUBLE,
CONSTRAINT FoodFactCoefficient_primaryKey PRIMARY KEY (FoodId, NutrientId)
);
/

CREATE TABLE FoodCategory
(
FoodCategoryId LONGVARCHAR,
Name LONGVARCHAR,
CONSTRAINT FoodCategory_primaryKey PRIMARY KEY (FoodCategoryId)
);
/

CREATE TABLE Food
(
FoodId LONGVARCHAR,
Name LONGVARCHAR,
CONSTRAINT Food_primaryKey PRIMARY KEY (FoodId)
);
/

CREATE TABLE FoodFact
(
FoodId LONGVARCHAR,
NutrientId LONGVARCHAR,
q DOUBLE DEFAULT CAST(0 AS DOUBLE),
CONSTRAINT FoodFact_primaryKey PRIMARY KEY (FoodId, NutrientId)
);
/

CREATE TABLE Relationship
(
RelationshipId IDENTITY,
Name LONGVARCHAR,
CONSTRAINT Relationship_primaryKey PRIMARY KEY (RelationshipId)
);
/

CREATE TABLE Mix
(
MixId IDENTITY,
Name LONGVARCHAR,
ADate DATE,
ATime TIME,
Status INTEGER,
NutrientId LONGVARCHAR,
Model LONGVARCHAR,
Note LONGVARCHAR,
CONSTRAINT Mix_primaryKey PRIMARY KEY (MixId)
);
/

CREATE TABLE NutrientCategory
(
NutrientCategoryId LONGVARCHAR,
Name LONGVARCHAR,
CONSTRAINT NutrientCategory_primaryKey PRIMARY KEY (NutrientCategoryId)
);
/

CREATE TABLE Nutrient
(
NutrientId LONGVARCHAR,
Name LONGVARCHAR,
Visible INTEGER DEFAULT 1,
NutrientCategoryId LONGVARCHAR,
Label LONGVARCHAR,
CONSTRAINT Nutrient_primaryKey PRIMARY KEY (NutrientId)
);
/

CREATE TABLE MixFood
(
MixId INTEGER,
FoodId LONGVARCHAR,
x DOUBLE,
CONSTRAINT MixFood_primaryKey PRIMARY KEY (MixId, FoodId)
);
/

CREATE TABLE FoodNutrientRatio
(
MixId INTEGER,
Food_Id_1 LONGVARCHAR,
Nutrient_Id_1 LONGVARCHAR,
Food_Id_2 LONGVARCHAR,
Nutrient_Id_2 LONGVARCHAR,
RelationshipId INTEGER,
A DOUBLE,
B DOUBLE,
CONSTRAINT FoodNutrientRatio_primaryKey PRIMARY KEY (MixId, Food_Id_1, Nutrient_Id_1, Food_Id_2, Nutrient_Id_2, RelationshipId)
);
/

CREATE TABLE NutrientRatio
(
MixId INTEGER,
Nutrient_Id_1 LONGVARCHAR,
Nutrient_Id_2 LONGVARCHAR,
RelationshipId INTEGER,
A DOUBLE,
B DOUBLE,
CONSTRAINT NutrientRatio_primaryKey PRIMARY KEY (MixId, Nutrient_Id_1, Nutrient_Id_2, RelationshipId)
);
/

CREATE TABLE NutrientConstraint
(
MixId INTEGER,
NutrientId LONGVARCHAR,
RelationshipId INTEGER,
b DOUBLE,
CONSTRAINT NutrientConstraint_primaryKey PRIMARY KEY (MixId, NutrientId, RelationshipId)
);
/

CREATE TABLE FoodNutrientConstraint
(
MixId INTEGER,
FoodId LONGVARCHAR,
NutrientId LONGVARCHAR,
RelationshipId INTEGER,
b DOUBLE,
CONSTRAINT FoodNutrientConstraint_primaryKey PRIMARY KEY (MixId, FoodId, NutrientId, RelationshipId)
);
/

CREATE TABLE CategoryLink
(
FoodCategoryId LONGVARCHAR,
FoodId LONGVARCHAR,
CONSTRAINT CategoryLink_primaryKey PRIMARY KEY (FoodCategoryId, FoodId)
);
/

CREATE TABLE PercentConstraint
(
MixId INTEGER,
FoodId LONGVARCHAR,
NutrientId LONGVARCHAR,
b DOUBLE,
CONSTRAINT PercentConstraint_primaryKey PRIMARY KEY (MixId, FoodId, NutrientId)
);
/

CREATE TABLE Rda
(
NutrientId LONGVARCHAR,
LifeStageId INTEGER,
q DOUBLE DEFAULT CAST(0 AS DOUBLE),
UL DOUBLE DEFAULT CAST(0 AS DOUBLE),
CONSTRAINT Rda_primaryKey PRIMARY KEY (NutrientId, LifeStageId)
);

CREATE TABLE RdaLifeStage
(
LifeStageId INTEGER,
Label LONGVARCHAR,
CONSTRAINT RdaLifeStage_primaryKey PRIMARY KEY (LifeStageId)
);

CREATE TABLE MixResult
(
MixId INTEGER,
FoodId LONGVARCHAR,
NutrientId LONGVARCHAR,
q DOUBLE,
CONSTRAINT MixResult_primaryKey PRIMARY KEY (MixId, FoodId, NutrientId)
);
/

ALTER TABLE CategoryLink ADD CONSTRAINT R0_FoodCategory_CategoryLink FOREIGN KEY ( FoodCategoryId ) REFERENCES FoodCategory ( FoodCategoryId ) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R1_Food_FoodFact FOREIGN KEY ( FoodId ) REFERENCES Food ( FoodId ) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R2_Food_MixFood FOREIGN KEY ( FoodId ) REFERENCES Food ( FoodId ) ON DELETE CASCADE;
/
ALTER TABLE CategoryLink ADD CONSTRAINT R3_Food_CategoryLink FOREIGN KEY ( FoodId ) REFERENCES Food ( FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodFactCoefficient ADD CONSTRAINT R4_FoodFact_FoodFactCoefficient FOREIGN KEY ( FoodId,NutrientId ) REFERENCES FoodFact ( FoodId,NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R5_Relationship_FoodNutrientRatio FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R6_Relationship_NutrientRatio FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R7_Relationship_NutrientConstraint FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R8_Relationship_FoodNutrientConstraint FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R9_Mix_MixFood FOREIGN KEY ( MixId ) REFERENCES Mix ( MixId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R10_Mix_NutrientRatio FOREIGN KEY ( MixId ) REFERENCES Mix ( MixId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R11_Mix_NutrientConstraint FOREIGN KEY ( MixId ) REFERENCES Mix ( MixId ) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R12_Nutrient_FoodFact FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R13_Nutrient_FoodNutrientRatio FOREIGN KEY ( Nutrient_Id_1 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R14_Nutrient_FoodNutrientRatio FOREIGN KEY ( Nutrient_Id_2 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R15_Nutrient_NutrientRatio FOREIGN KEY ( Nutrient_Id_1 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R16_Nutrient_NutrientRatio FOREIGN KEY ( Nutrient_Id_2 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R17_Nutrient_NutrientConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R18_Nutrient_FoodNutrientConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE PercentConstraint ADD CONSTRAINT R19_Nutrient_PercentConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R20_MixFood_FoodNutrientRatio FOREIGN KEY ( MixId,Food_Id_1 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R21_MixFood_FoodNutrientRatio FOREIGN KEY ( MixId,Food_Id_2 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R22_MixFood_FoodNutrientConstraint FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE PercentConstraint ADD CONSTRAINT R23_MixFood_PercentConstraint FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE Rda ADD CONSTRAINT R24_RdaLifeStage_Rda FOREIGN KEY ( LifeStageId ) REFERENCES RdaLifeStage ( LifeStageId ) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R25_MixFood_MixResult FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE MixResult ADD CONSTRAINT R26_FoodFactCoefficient_MixResult FOREIGN KEY ( FoodId,NutrientId ) REFERENCES FoodFactCoefficient ( FoodId,NutrientId ) ON DELETE CASCADE;
/


CREATE FUNCTION getFoodQuotient(
IN v_MixId INTEGER
) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE fq DOUBLE;
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,5) INTO fq
FROM (SELECT mixid,
             foodid,
             q AS fat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '204') a,
     (SELECT mixid,
             foodid,
             q AS digestiblecarbohydrate
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
      (SELECT mixid,
             foodid,
             q AS protein
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '203') c,
      (SELECT mixid,
             foodid,
             q AS alcohol
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '221') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND   a.foodid = c.foodid
AND   a.foodid = d.foodid;
RETURN fq;
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
IN v_MixId INTEGER,
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

CREATE FUNCTION getMixResultSumValue (
--
IN v_MixId INTEGER,
--
IN v_NutrientId LONGVARCHAR
--
)
--
RETURNS DOUBLE READS SQL DATA BEGIN ATOMIC
--
DECLARE v_c DOUBLE;

--
SELECT sum(a.x * b.c) INTO v_c       
FROM mixfood a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND a.mixid = v_MixId
AND b.nutrientid = v_NutrientId;
--
RETURN v_c;

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


CREATE FUNCTION generateLargeRandomNumber() RETURNS NUMERIC
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_count NUMERIC;
--
SET v_count = round(rand()*10000000000);
--
RETURN v_count;
--
END;
/

CREATE FUNCTION generateId(
--
IN v_txt_1 LONGVARCHAR,
--
IN v_txt_2 LONGVARCHAR
--
) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_id LONGVARCHAR;
--
SELECT v_txt_1||v_txt_2||generateLargeRandomNumber() INTO v_id FROM (VALUES(0));
--
RETURN v_id;
--
END;
/

CREATE PROCEDURE Food_Insert_Temp (OUT v_OutFoodId LONGVARCHAR,IN v_FoodNom LONGVARCHAR)
--
modifies sql data BEGIN atomic
--
DECLARE v_FoodId LONGVARCHAR;
--
SET v_FoodId = generateId('f','');
SET v_OutFoodId = v_FoodId;
--
call Food_Insert(v_FoodId,v_FoodNom);
call CategoryLink_Insert(v_FoodId,'5000');
--
FOR SELECT nutrientid FROM nutrient DO
call FoodFact_Merge (v_FoodId,nutrientid,0);
END FOR;
--
END;
/

CREATE PROCEDURE FoodFact_ZeroOut ()
--
modifies sql data BEGIN atomic
--
FOR SELECT foodid FROM food DO
--
FOR SELECT nutrientid FROM nutrient DO
--
call FoodFact_Merge (foodid,nutrientid,0);
--
END FOR;
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
AND b.NutrientId != '675'
AND b.NutrientId != '851';
OPEN result;
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
IN v_mixid INTEGER
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
SET v_FoodIdNew = generateId('f','');
SET v_FoodNom = getFoodName(v_FoodId);
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
IN v_MixId INTEGER,
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

CREATE PROCEDURE FillMixResults(
--
IN v_MixId INTEGER
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

CREATE FUNCTION getCategoryId (IN v_FoodId LONGVARCHAR) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodCategoryId LONGVARCHAR;
--
SELECT FoodCategoryId INTO v_FoodCategoryId
FROM CategoryLink
WHERE FoodId = v_FoodId;
--
RETURN v_FoodCategoryId;
--
END;
/

CREATE PROCEDURE Mix_getMealGi (
--
IN v_MixId INTEGER,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT CASE
       WHEN b.name IS NULL THEN 'Total'
       ELSE b.name
       END as name,
       ROUND(a.weight,v_Precision) AS weight,
       ROUND(a.carbs,v_Precision) AS carbs,
       ROUND(a.pct*100,v_Precision) AS pct,
       ROUND(a.gl,v_Precision) AS gl,
       ROUND(a.gi,v_Precision) AS gi,
       ROUND(a.mealgi,v_Precision) AS mealgi
FROM
(
SELECT a.mixid,
       a.foodid,
       a.weight,
       b.carbs,
       CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END AS Pct,
       d.gl,
       getGIFromGL(a.foodid) as gi,
       CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid) AS MealGI
FROM (SELECT mixid,
             foodid,
             q AS weight
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10000') a,
     (SELECT mixid,
             foodid,
             q AS carbs
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
     (SELECT mixid,
             SUM(q) AS tcarbs
             FROM mixresult
             WHERE mixid = v_MixId
             AND   nutrientid = '10003'
             GROUP BY mixid) c,
     (SELECT mixid,
             foodid,
             q AS gl
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10006') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND a.foodid = d.foodid
--
UNION
--
SELECT a.mixid,
       'Total',
       sum(a.weight),
       sum(b.carbs),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END) AS Pct,
       sum(d.gl),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid)) AS MealGI,
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid)) AS MealGI
FROM (SELECT mixid,
             foodid,
             q AS weight
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10000') a,
     (SELECT mixid,
             foodid,
             q AS carbs
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
     (SELECT mixid,
             SUM(q) AS tcarbs
             FROM mixresult
             WHERE mixid = v_MixId
             AND   nutrientid = '10003'
             GROUP BY mixid) c,
     (SELECT mixid,
             foodid,
             q AS gl
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10006') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND a.foodid = d.foodid
GROUP BY a.mixid
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


CREATE FUNCTION getMealGI (IN v_MixId INTEGER) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE mealGI DOUBLE;
--
SET mealGI = 0;
--
SELECT MealGI INTO mealGI
FROM
(
SELECT a.mixid,
       'Total',
       sum(a.weight),
       sum(b.carbs),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END) AS Pct,
       sum(d.gl),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid)),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid)) AS MealGI
FROM (SELECT mixid,
             foodid,
             q AS weight
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10000') a,
     (SELECT mixid,
             foodid,
             q AS carbs
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
     (SELECT mixid,
             SUM(q) AS tcarbs
             FROM mixresult
             WHERE mixid = v_MixId
             AND   nutrientid = '10003'
             GROUP BY mixid) c,
     (SELECT mixid,
             foodid,
             q AS gl
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10006') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND a.foodid = d.foodid
GROUP BY a.mixid
);
--
RETURN mealGI;
--
END;
/


CREATE PROCEDURE Mix_getMealGIDiff (
--
IN v_MixId_1 INTEGER,
IN v_MixId_2 INTEGER,
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


CREATE PROCEDURE FoodNutrientConstraint (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
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
FOR SELECT FOODID, Q*4 AS ENERGY FROM FOODFACT WHERE NUTRIENTID = v_NutrientIdA DO
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
IN v_MixId INTEGER,
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
IN v_MixId INTEGER,
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
IN v_MixId INTEGER
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
a.b
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

CREATE PROCEDURE FoodNutrientRatio (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
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
IN v_MixId INTEGER,
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
IN v_mixid INTEGER,
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
       ROUND(x25.q,v_Precision) AS "Fluoride",
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
     foodfact x25,
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
     foodfact x58
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
a.foodid = x25.foodid AND
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
a.foodid = x58.foodid
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
x25.nutrientid = '313' AND
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
x58.nutrientid = '10014'
)
UNION
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
       ROUND(x25.q,v_Precision) AS "Fluoride",
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
       --Glycemic
       ROUND(x50.q,v_Precision) AS "GlycemicLoad",
       --Other
       ROUND(x13.q,v_Precision) AS "Water",
       ROUND(x4.q,v_Precision) AS "Cost",
       --Ids
       a.foodid AS "FoodId"
FROM (SELECT foodid,
             name
      FROM food
      WHERE foodid NOT IN (SELECT b.foodid
                           FROM categorylink a,
                                food b
                           WHERE a.foodid = b.foodid)) a,
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
     foodfact x25,
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
     foodfact x58
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
a.foodid = x25.foodid AND
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
a.foodid = x58.foodid
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
x25.nutrientid = '313' AND
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
x58.nutrientid = '10014'
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
IN v_MixId INTEGER,
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
IN v_mixid INTEGER
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
generateId('c',''),
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


CREATE PROCEDURE foodnutrient_lhs (
--
IN v_mixid INTEGER,
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
IN v_MixId INTEGER
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
OUT newid INTEGER,
--
IN v_MixId_Old INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_Name_Old LONGVARCHAR;
DECLARE v_ADate DATE;
DECLARE v_ATime TIME;
DECLARE v_NutrientId LONGVARCHAR;
DECLARE v_Model LONGVARCHAR;
DECLARE v_Note LONGVARCHAR;
--
SELECT Name,
       Nutrientid,
       Model,
       Note
       INTO
       v_Name_Old,
       v_NutrientId,
       v_Model,
       v_Note
       FROM Mix
       WHERE MixId = v_MixId_Old;
--
SELECT CURRENT_DATE INTO v_ADate FROM (VALUES(0));
--
SELECT LOCALTIME INTO v_ATime FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
ADate,
ATime,
Status,
Nutrientid,
Model,
Note
) VALUES (
DEFAULT,
v_Name_Old||'_copy',
v_ADate,
v_ATime,
1,
v_NutrientId,
v_Model,
v_Note
);
--
SET newid = IDENTITY();
--
END;
/

CREATE PROCEDURE Mix_Delete (
IN v_MixId INTEGER
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
IN v_MixId_1 INTEGER,
IN v_MixId_2 INTEGER,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.name,
       round(a.mix1,v_Precision),
       round(a.mix2,v_Precision),
       round(a.diff,v_Precision)
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
WHERE a.nutrientid = b.nutrientid
ORDER BY b.nutrientcategoryid desc,b.nutrientid;
--
OPEN result;
--
END;
/

CREATE PROCEDURE Mix_Insert (
--
OUT newid INTEGER,
--
IN v_Name LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_ADate DATE;
--
DECLARE v_ATime TIME;
--
SELECT CURRENT_DATE INTO v_ADate FROM (VALUES(0));
--
SELECT LOCALTIME INTO v_ATime FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
ADate,
ATime
) VALUES (
DEFAULT,
v_Name,
v_ADate,
v_ATime
);
--
SET newid = IDENTITY();
--
END;
/

CREATE PROCEDURE Mix_Select_All ()
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT MixId,
       Name
FROM Mix
ORDER BY Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Mix_Select_All_0 ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT MixId,
       Name
FROM Mix
WHERE Status = 0
ORDER BY Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Mix_Select_All_1 ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT MixId,
       Name
FROM Mix
WHERE Status = 1
ORDER BY Name;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Mix_Update_Name (
IN v_MixId INTEGER,
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


CREATE PROCEDURE Mix_Update_Status (
--
IN v_MixId INTEGER,
--
IN v_Status INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
UPDATE
Mix
SET
Status = v_Status
WHERE
MixId = v_MixId;
--
END;
/


CREATE PROCEDURE Mix_Update_NutrientId (
IN v_MixId INTEGER,
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
IN v_MixId INTEGER,
IN v_Model LONGVARCHAR,
IN v_Note LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Mix
SET
Model = v_Model,
Note = v_Note
WHERE
MixId = v_MixId;
END;
/


CREATE PROCEDURE Mix_Update_Time (
--
IN v_MixId INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_ADate DATE;
--
DECLARE v_ATime TIME;
--
SELECT CURRENT_DATE INTO v_ADate FROM (VALUES(0));
--
SELECT LOCALTIME INTO v_ATime FROM (VALUES(0));
--
UPDATE
Mix
SET
ADate = v_ADate,
ATime = v_ATime
WHERE
MixId = v_MixId;
--
END;
/


CREATE PROCEDURE MixFood_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
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
IN v_MixId INTEGER,
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
IN v_MixId INTEGER,
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
IN v_MixId INTEGER
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


CREATE PROCEDURE MixFood_Select_All (IN v_mixid INTEGER)
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


CREATE PROCEDURE MixFood_Update (
IN v_MixId INTEGER,
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


CREATE PROCEDURE Mix_Select_Other (
IN v_MixId INTEGER
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
MixId,
NutrientId,
Model,
Note
FROM
Mix
WHERE
MixId = v_MixId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE MixResult_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
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

CREATE PROCEDURE MixResult_Select (
IN v_MixId INTEGER,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
select a.MixId,
       a.FoodId,
       b.Name,
       Round(a.Weight,v_Precision) as Weight,
       Round(CompleteProtein,v_Precision) as CompleteProtein,       
       Round(DigestibleCarbohydrate,v_Precision) as DigestibleCarbohydrate,
       Round(Cost,v_Precision) as Cost,
       Round(Protein,v_Precision) as Protein,
       Round(Fat,v_Precision) as Fat,
       Round(CarbsByDiff,v_Precision) as CarbsByDiff,
       Round(Energy,v_Precision) as EnergyGross,
       Round(Alcohol,v_Precision) as Alcohol,
       Round(Water,v_Precision) as Water,
       Round(Fiber,v_Precision) as Fiber,
       Round(Calcium,v_Precision) as Calcium,
       Round(Iron,v_Precision) as Iron,
       Round(Magnesium,v_Precision) as Magnesium,
       Round(Phosphorus,v_Precision) as Phosphorus,
       Round(Potassium,v_Precision) as Potassium,
       Round(Sodium,v_Precision) as Sodium,
       Round(Zinc,v_Precision) as Zinc,
       Round(Copper,v_Precision) as Copper,
       Round(Fluoride,v_Precision) as Fluoride,
       Round(Manganese,v_Precision) as Manganese,
       Round(Selenium,v_Precision) as Selenium,
       Round(VitaminA,v_Precision) as VitaminA,
       Round(VitaminE,v_Precision) as VitaminE,
       Round(VitaminD,v_Precision) as VitaminD,
       Round(VitaminC,v_Precision) as VitaminC,
       Round(Thiamin,v_Precision) as Thiamin,
       Round(Riboflavin,v_Precision) as Riboflavin,
       Round(Niacin,v_Precision) as Niacin,
       Round(Pantothenic,v_Precision) as Pantothenic,
       Round(VitaminB6,v_Precision) as VitaminB6,
       Round(VitaminB12,v_Precision) as VitaminB12,
       Round(Choline,v_Precision) as Choline,
       Round(VitaminK,v_Precision) as VitaminK,
       Round(Folate,v_Precision) as Folate,
       Round(Cholesterol,v_Precision) as Cholesterol,
       Round(Saturated,v_Precision) as Saturated,
       Round(DHA,v_Precision) as DHA,
       Round(EPA,v_Precision) as EPA,
       Round(Monounsaturated,v_Precision) as Monounsaturated,
       Round(Polyunsaturated,v_Precision) as Polyunsaturated,
       Round(Linoleic,v_Precision) as Linoleic,
       Round(AlphaLinolenic,v_Precision) as AlphaLinolenic,
       Round(GlycemicLoad,v_Precision) as GlycemicLoad,
       Round(EnergyDigestible,v_Precision) as EnergyDigestible,       
       Round(EnergyCarbohydrate,v_Precision) as EnergyCarbohydrate,
       Round(EnergyProtein,v_Precision) as EnergyProtein,
       Round(EnergyFat,v_Precision) as EnergyFat,
       Round(EnergyAlcohol,v_Precision) as EnergyAlcohol
from
(
select
       x0.Mixid,
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
       x24.Fluoride,
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
       x56.EnergyAlcohol
from
--
(
select mixid,foodid from mixfood where mixid = v_MixId
) x0,
--
--10000	Weight (g)
(
select mixid,foodid,q as Weight from mixresult
where mixid = v_MixId
and nutrientid = '10000'
) x1,
--
--10001	Complete Protein (g)
(
select mixid,foodid,q as CompleteProtein from mixresult
where mixid = v_MixId
and nutrientid = '10001'
) x2,
--
--10003	Digestible Carbohydrate (g)
(
select mixid,foodid,q as DigestibleCarbohydrate from mixresult
where mixid = v_MixId
and nutrientid = '10003'
) x4,
--
--10005	Cost (g)
(
select mixid,foodid,q as Cost from mixresult
where mixid = v_MixId
and nutrientid = '10005'
) x5,
--
--203	Protein (g)
(
select mixid,foodid,q as Protein from mixresult
where mixid = v_MixId
and nutrientid = '203'
) x6,
--
--204	Total lipid (Fat) (g)
(
select mixid,foodid,q as Fat from mixresult
where mixid = v_MixId
and nutrientid = '204'
) x7,
--205	Carbohydrate, by difference (g)
(
select mixid,foodid,q as Carbsbydiff from mixresult
where mixid = v_MixId
and nutrientid = '205'
) x8,
--
--208	Energy (kcal)
(
select mixid,foodid,q as Energy from mixresult
where mixid = v_MixId
and nutrientid = '208'
) x9,
--221	Alcohol, ethyl (g)
(
select mixid,foodid,q as Alcohol from mixresult
where mixid = v_MixId
and nutrientid = '221'
) x13,
--255	Water (g)
(
select mixid,foodid,q as Water from mixresult
where mixid = v_MixId
and nutrientid = '255'
) x14,
--291	Fiber, total dietary (g)
(
select mixid,foodid,q as Fiber from mixresult
where mixid = v_MixId
and nutrientid = '291'
) x15,
--301	Calcium, Ca (mg)
(
select mixid,foodid,q as Calcium from mixresult
where mixid = v_MixId
and nutrientid = '301'
) x16,
--303	Iron, Fe (mg)
(
select mixid,foodid,q as Iron from mixresult
where mixid = v_MixId
and nutrientid = '303'
) x17,
--304	Magnesium, Mg (mg)
(
select mixid,foodid,q as Magnesium from mixresult
where mixid = v_MixId
and nutrientid = '304'
) x18,
--305	Phosphorus, P (mg)
(
select mixid,foodid,q as Phosphorus from mixresult
where mixid = v_MixId
and nutrientid = '305'
) x19,
--306	Potassium, K (mg)
(
select mixid,foodid,q as Potassium from mixresult
where mixid = v_MixId
and nutrientid = '306'
) x20,
--307	Sodium, Na (mg)
(
select mixid,foodid,q as Sodium from mixresult
where mixid = v_MixId
and nutrientid = '307'
) x21,
--309	Zinc, Zn (mg)
(
select mixid,foodid,q as Zinc from mixresult
where mixid = v_MixId
and nutrientid = '309'
) x22,
--312	Copper, Cu (mg)
(
select mixid,foodid,q as Copper from mixresult
where mixid = v_MixId
and nutrientid = '312'
) x23,
--313	Fluoride, F (µg)
(
select mixid,foodid,q as Fluoride from mixresult
where mixid = v_MixId
and nutrientid = '313'
) x24,
--315	Manganese, Mn (mg)
(
select mixid,foodid,q as Manganese from mixresult
where mixid = v_MixId
and nutrientid = '315'
) x25,
--317	Selenium, Se (µg)
(
select mixid,foodid,q as Selenium from mixresult
where mixid = v_MixId
and nutrientid = '317'
) x26,
--320	Vitamin A, RAE (µg)
(
select mixid,foodid,q as VitaminA from mixresult
where mixid = v_MixId
and nutrientid = '320'
) x27,
--323	Vitamin E (Alpha-Tocopherol) (mg)
(
select mixid,foodid,q as VitaminE from mixresult
where mixid = v_MixId
and nutrientid = '323'
) x28,
--328	Vitamin D (D2 + D3) (µg)
(
select mixid,foodid,q as VitaminD from mixresult
where mixid = v_MixId
and nutrientid = '328'
) x29,
--401	Vitamin C, total (Ascorbic Acid) (mg)
(
select mixid,foodid,q as VitaminC from mixresult
where mixid = v_MixId
and nutrientid = '401'
) x30,
--404	Thiamin (mg)
(
select mixid,foodid,q as Thiamin from mixresult
where mixid = v_MixId
and nutrientid = '404'
) x31,
--405	Riboflavin (mg)
(
select mixid,foodid,q as Riboflavin from mixresult
where mixid = v_MixId
and nutrientid = '405'
) x32,
--406	Niacin (mg)
(
select mixid,foodid,q as Niacin from mixresult
where mixid = v_MixId
and nutrientid = '406'
) x33,
--410	Pantothenic acid (mg)
(
select mixid,foodid,q as Pantothenic from mixresult
where mixid = v_MixId
and nutrientid = '410'
) x34,
--415	Vitamin B-6 (mg)
(
select mixid,foodid,q as VitaminB6 from mixresult
where mixid = v_MixId
and nutrientid = '415'
) x35,
--418	Vitamin B-12 (µg)
(
select mixid,foodid,q as VitaminB12 from mixresult
where mixid = v_MixId
and nutrientid = '418'
) x36,
--421	Choline, total (mg)
(
select mixid,foodid,q as Choline from mixresult
where mixid = v_MixId
and nutrientid = '421'
) x37,
--430	Vitamin K (Phylloquinone) (µg)
(
select mixid,foodid,q as VitaminK from mixresult
where mixid = v_MixId
and nutrientid = '430'
) x38,
--435	Folate, DFE (µg)
(
select mixid,foodid,q as Folate from mixresult
where mixid = v_MixId
and nutrientid = '435'
) x39,
--601	Cholesterol (mg)
(
select mixid,foodid,q as Cholesterol from mixresult
where mixid = v_MixId
and nutrientid = '601'
) x40,
--606	Fatty acids, total saturated (g)
(
select mixid,foodid,q as Saturated from mixresult
where mixid = v_MixId
and nutrientid = '606'
) x41,
--621	22:6 n-3 (DHA) (g)
(
select mixid,foodid,q as DHA from mixresult
where mixid = v_MixId
and nutrientid = '621'
) x42,
--629	20:5 n-3 (EPA) (g)
(
select mixid,foodid,q as EPA from mixresult
where mixid = v_MixId
and nutrientid = '629'
) x43,
--645	Fatty acids, total monounsaturated (g)
(
select mixid,foodid,q as Monounsaturated from mixresult
where mixid = v_MixId
and nutrientid = '645'
) x44,
--646	Fatty acids, total polyunsaturated (g)
(
select mixid,foodid,q as Polyunsaturated from mixresult
where mixid = v_MixId
and nutrientid = '646'
) x45,
--618	18:2 undifferentiated (Linoleic) (g)
(
select mixid,foodid,q as Linoleic from mixresult
where mixid = v_MixId
and nutrientid = '618'
) x46,
--619	18:3 undifferentiated (Linolenic) (g)
(
select mixid,foodid,q as AlphaLinolenic from mixresult
where mixid = v_MixId
and nutrientid = '619'
) x47,
--10006	Glycemic Load
(
select mixid,foodid,q as GlycemicLoad from mixresult
where mixid = v_MixId
and nutrientid = '10006'
) x50,
--10009	Energy, digestible (kcal)
(
select mixid,foodid,q as EnergyDigestible from mixresult
where mixid = v_MixId
and nutrientid = '10009'
) x51,
--10011	Energy, carbohydrate (kcal)
(
select mixid,foodid,q as EnergyCarbohydrate from mixresult
where mixid = v_MixId
and nutrientid = '10011'
) x53,
--10012	Energy, protein (kcal)
(
select mixid,foodid,q as EnergyProtein from mixresult
where mixid = v_MixId
and nutrientid = '10012'
) x54,
--10013	Energy, fat (kcal)
(
select mixid,foodid,q as EnergyFat from mixresult
where mixid = v_MixId
and nutrientid = '10013'
) x55,
--10014	Energy, no alcohol (kcal)
(
select mixid,foodid,q as EnergyAlcohol from mixresult
where mixid = v_MixId
and nutrientid = '10014'
) x56
--
where x0.mixid = x1.mixid
and x0.foodid = x1.foodid
and x0.mixid = x2.mixid
and x0.foodid = x2.foodid
and x0.mixid = x4.mixid
and x0.foodid = x4.foodid
and x0.mixid = x5.mixid
and x0.foodid = x5.foodid
and x0.mixid = x6.mixid
and x0.foodid = x6.foodid
and x0.mixid = x7.mixid
and x0.foodid = x7.foodid
and x0.mixid = x8.mixid
and x0.foodid = x8.foodid
and x0.mixid = x9.mixid
and x0.foodid = x9.foodid
and x0.mixid = x13.mixid
and x0.foodid = x13.foodid
and x0.mixid = x14.mixid
and x0.foodid = x14.foodid
and x0.mixid = x15.mixid
and x0.foodid = x15.foodid
and x0.mixid = x16.mixid
and x0.foodid = x16.foodid
and x0.mixid = x17.mixid
and x0.foodid = x17.foodid
and x0.mixid = x18.mixid
and x0.foodid = x18.foodid
and x0.mixid = x19.mixid
and x0.foodid = x19.foodid
and x0.mixid = x20.mixid
and x0.foodid = x20.foodid
and x0.mixid = x21.mixid
and x0.foodid = x21.foodid
and x0.mixid = x22.mixid
and x0.foodid = x22.foodid
and x0.mixid = x23.mixid
and x0.foodid = x23.foodid
and x0.mixid = x24.mixid
and x0.foodid = x24.foodid
and x0.mixid = x25.mixid
and x0.foodid = x25.foodid
and x0.mixid = x26.mixid
and x0.foodid = x26.foodid
and x0.mixid = x27.mixid
and x0.foodid = x27.foodid
and x0.mixid = x28.mixid
and x0.foodid = x28.foodid
and x0.mixid = x29.mixid
and x0.foodid = x29.foodid
and x0.mixid = x30.mixid
and x0.foodid = x30.foodid
and x0.mixid = x31.mixid
and x0.foodid = x31.foodid
and x0.mixid = x32.mixid
and x0.foodid = x32.foodid
and x0.mixid = x33.mixid
and x0.foodid = x33.foodid
and x0.mixid = x34.mixid
and x0.foodid = x34.foodid
and x0.mixid = x35.mixid
and x0.foodid = x35.foodid
and x0.mixid = x36.mixid
and x0.foodid = x36.foodid
and x0.mixid = x37.mixid
and x0.foodid = x37.foodid
and x0.mixid = x38.mixid
and x0.foodid = x38.foodid
and x0.mixid = x39.mixid
and x0.foodid = x39.foodid
and x0.mixid = x40.mixid
and x0.foodid = x40.foodid
and x0.mixid = x41.mixid
and x0.foodid = x41.foodid
and x0.mixid = x42.mixid
and x0.foodid = x42.foodid
and x0.mixid = x43.mixid
and x0.foodid = x43.foodid
and x0.mixid = x44.mixid
and x0.foodid = x44.foodid
and x0.mixid = x45.mixid
and x0.foodid = x45.foodid
and x0.mixid = x46.mixid
and x0.foodid = x46.foodid
and x0.mixid = x47.mixid
and x0.foodid = x47.foodid
and x0.mixid = x50.mixid
and x0.foodid = x50.foodid
and x0.mixid = x51.mixid
and x0.foodid = x51.foodid
and x0.mixid = x53.mixid
and x0.foodid = x53.foodid
and x0.mixid = x54.mixid
and x0.foodid = x54.foodid
and x0.mixid = x55.mixid
and x0.foodid = x55.foodid
and x0.mixid = x56.mixid
and x0.foodid = x56.foodid
) a,
(
select foodid,name from food
) b
where a.foodid = b.foodid
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
       Round(sum(Energy),v_Precision),
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
       Round(sum(Fluoride),v_Precision),
       Round(sum(Manganese),v_Precision),
       Round(sum(Selenium),v_Precision),
       Round(sum(VitaminA),v_Precision),
       Round(sum(VitaminE),v_Precision),
       Round(sum(VitaminD),v_Precision),
       Round(sum(VitaminC),v_Precision),
       Round(sum(Thiamin),v_Precision),
       Round(sum(Riboflavin),v_Precision),
       Round(sum(Niacin),v_Precision),
       Round(sum(Pantothenic),v_Precision),
       Round(sum(VitaminB6),v_Precision),
       Round(sum(VitaminB12),v_Precision),
       Round(sum(Choline),v_Precision),
       Round(sum(VitaminK),v_Precision),
       Round(sum(Folate),v_Precision),
       Round(sum(Cholesterol),v_Precision),
       Round(sum(Saturated),v_Precision),
       Round(sum(DHA),v_Precision),
       Round(sum(EPA),v_Precision),
       Round(sum(Monounsaturated),v_Precision),
       Round(sum(Polyunsaturated),v_Precision),
       Round(sum(Linoleic),v_Precision),
       Round(sum(AlphaLinolenic),v_Precision),
       Round(sum(GlycemicLoad),v_Precision),
       Round(sum(EnergyDigestible),v_Precision),       
       Round(sum(EnergyCarbohydrate),v_Precision),
       Round(sum(EnergyProtein),v_Precision),
       Round(sum(EnergyFat),v_Precision),
       Round(sum(EnergyAlcohol),v_Precision)
from
(
select
       x0.Mixid,
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
       x24.Fluoride,
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
       x56.EnergyAlcohol
from
--
(
select mixid,foodid from mixfood where mixid = v_MixId
) x0,
--
--10000	Weight (g)
(
select mixid,foodid,q as Weight from mixresult
where mixid = v_MixId
and nutrientid = '10000'
) x1,
--
--10001	Complete Protein (g)
(
select mixid,foodid,q as CompleteProtein from mixresult
where mixid = v_MixId
and nutrientid = '10001'
) x2,
--
--10003	Digestible Carbohydrate (g)
(
select mixid,foodid,q as DigestibleCarbohydrate from mixresult
where mixid = v_MixId
and nutrientid = '10003'
) x4,
--
--10005	Cost (g)
(
select mixid,foodid,q as Cost from mixresult
where mixid = v_MixId
and nutrientid = '10005'
) x5,
--
--203	Protein (g)
(
select mixid,foodid,q as Protein from mixresult
where mixid = v_MixId
and nutrientid = '203'
) x6,
--
--204	Total lipid (Fat) (g)
(
select mixid,foodid,q as Fat from mixresult
where mixid = v_MixId
and nutrientid = '204'
) x7,
--205	Carbohydrate, by difference (g)
(
select mixid,foodid,q as Carbsbydiff from mixresult
where mixid = v_MixId
and nutrientid = '205'
) x8,
--
--208	Energy (kcal)
(
select mixid,foodid,q as Energy from mixresult
where mixid = v_MixId
and nutrientid = '208'
) x9,
--221	Alcohol, ethyl (g)
(
select mixid,foodid,q as Alcohol from mixresult
where mixid = v_MixId
and nutrientid = '221'
) x13,
--255	Water (g)
(
select mixid,foodid,q as Water from mixresult
where mixid = v_MixId
and nutrientid = '255'
) x14,
--291	Fiber, total dietary (g)
(
select mixid,foodid,q as Fiber from mixresult
where mixid = v_MixId
and nutrientid = '291'
) x15,
--301	Calcium, Ca (mg)
(
select mixid,foodid,q as Calcium from mixresult
where mixid = v_MixId
and nutrientid = '301'
) x16,
--303	Iron, Fe (mg)
(
select mixid,foodid,q as Iron from mixresult
where mixid = v_MixId
and nutrientid = '303'
) x17,
--304	Magnesium, Mg (mg)
(
select mixid,foodid,q as Magnesium from mixresult
where mixid = v_MixId
and nutrientid = '304'
) x18,
--305	Phosphorus, P (mg)
(
select mixid,foodid,q as Phosphorus from mixresult
where mixid = v_MixId
and nutrientid = '305'
) x19,
--306	Potassium, K (mg)
(
select mixid,foodid,q as Potassium from mixresult
where mixid = v_MixId
and nutrientid = '306'
) x20,
--307	Sodium, Na (mg)
(
select mixid,foodid,q as Sodium from mixresult
where mixid = v_MixId
and nutrientid = '307'
) x21,
--309	Zinc, Zn (mg)
(
select mixid,foodid,q as Zinc from mixresult
where mixid = v_MixId
and nutrientid = '309'
) x22,
--312	Copper, Cu (mg)
(
select mixid,foodid,q as Copper from mixresult
where mixid = v_MixId
and nutrientid = '312'
) x23,
--313	Fluoride, F (µg)
(
select mixid,foodid,q as Fluoride from mixresult
where mixid = v_MixId
and nutrientid = '313'
) x24,
--315	Manganese, Mn (mg)
(
select mixid,foodid,q as Manganese from mixresult
where mixid = v_MixId
and nutrientid = '315'
) x25,
--317	Selenium, Se (µg)
(
select mixid,foodid,q as Selenium from mixresult
where mixid = v_MixId
and nutrientid = '317'
) x26,
--320	Vitamin A, RAE (µg)
(
select mixid,foodid,q as VitaminA from mixresult
where mixid = v_MixId
and nutrientid = '320'
) x27,
--323	Vitamin E (Alpha-Tocopherol) (mg)
(
select mixid,foodid,q as VitaminE from mixresult
where mixid = v_MixId
and nutrientid = '323'
) x28,
--328	Vitamin D (D2 + D3) (µg)
(
select mixid,foodid,q as VitaminD from mixresult
where mixid = v_MixId
and nutrientid = '328'
) x29,
--401	Vitamin C, total (Ascorbic Acid) (mg)
(
select mixid,foodid,q as VitaminC from mixresult
where mixid = v_MixId
and nutrientid = '401'
) x30,
--404	Thiamin (mg)
(
select mixid,foodid,q as Thiamin from mixresult
where mixid = v_MixId
and nutrientid = '404'
) x31,
--405	Riboflavin (mg)
(
select mixid,foodid,q as Riboflavin from mixresult
where mixid = v_MixId
and nutrientid = '405'
) x32,
--406	Niacin (mg)
(
select mixid,foodid,q as Niacin from mixresult
where mixid = v_MixId
and nutrientid = '406'
) x33,
--410	Pantothenic acid (mg)
(
select mixid,foodid,q as Pantothenic from mixresult
where mixid = v_MixId
and nutrientid = '410'
) x34,
--415	Vitamin B-6 (mg)
(
select mixid,foodid,q as VitaminB6 from mixresult
where mixid = v_MixId
and nutrientid = '415'
) x35,
--418	Vitamin B-12 (µg)
(
select mixid,foodid,q as VitaminB12 from mixresult
where mixid = v_MixId
and nutrientid = '418'
) x36,
--421	Choline, total (mg)
(
select mixid,foodid,q as Choline from mixresult
where mixid = v_MixId
and nutrientid = '421'
) x37,
--430	Vitamin K (Phylloquinone) (µg)
(
select mixid,foodid,q as VitaminK from mixresult
where mixid = v_MixId
and nutrientid = '430'
) x38,
--435	Folate, DFE (µg)
(
select mixid,foodid,q as Folate from mixresult
where mixid = v_MixId
and nutrientid = '435'
) x39,
--601	Cholesterol (mg)
(
select mixid,foodid,q as Cholesterol from mixresult
where mixid = v_MixId
and nutrientid = '601'
) x40,
--606	Fatty acids, total saturated (g)
(
select mixid,foodid,q as Saturated from mixresult
where mixid = v_MixId
and nutrientid = '606'
) x41,
--621	22:6 n-3 (DHA) (g)
(
select mixid,foodid,q as DHA from mixresult
where mixid = v_MixId
and nutrientid = '621'
) x42,
--629	20:5 n-3 (EPA) (g)
(
select mixid,foodid,q as EPA from mixresult
where mixid = v_MixId
and nutrientid = '629'
) x43,
--645	Fatty acids, total monounsaturated (g)
(
select mixid,foodid,q as Monounsaturated from mixresult
where mixid = v_MixId
and nutrientid = '645'
) x44,
--646	Fatty acids, total polyunsaturated (g)
(
select mixid,foodid,q as Polyunsaturated from mixresult
where mixid = v_MixId
and nutrientid = '646'
) x45,
--618	18:2 undifferentiated (Linoleic) (g)
(
select mixid,foodid,q as Linoleic from mixresult
where mixid = v_MixId
and nutrientid = '618'
) x46,
--619	18:3 undifferentiated (Linolenic) (g)
(
select mixid,foodid,q as AlphaLinolenic from mixresult
where mixid = v_MixId
and nutrientid = '619'
) x47,
--10006	Glycemic Load
(
select mixid,foodid,q as GlycemicLoad from mixresult
where mixid = v_MixId
and nutrientid = '10006'
) x50,
--10009	Energy, digestible (kcal)
(
select mixid,foodid,q as EnergyDigestible from mixresult
where mixid = v_MixId
and nutrientid = '10009'
) x51,
--10011	Energy, carbohydrate (kcal)
(
select mixid,foodid,q as EnergyCarbohydrate from mixresult
where mixid = v_MixId
and nutrientid = '10011'
) x53,
--10012	Energy, protein (kcal)
(
select mixid,foodid,q as EnergyProtein from mixresult
where mixid = v_MixId
and nutrientid = '10012'
) x54,
--10013	Energy, fat (kcal)
(
select mixid,foodid,q as EnergyFat from mixresult
where mixid = v_MixId
and nutrientid = '10013'
) x55,
--10014	Energy, no alcohol (kcal)
(
select mixid,foodid,q as EnergyAlcohol from mixresult
where mixid = v_MixId
and nutrientid = '10014'
) x56
--
where x0.mixid = x1.mixid
and x0.foodid = x1.foodid
and x0.mixid = x2.mixid
and x0.foodid = x2.foodid
and x0.mixid = x4.mixid
and x0.foodid = x4.foodid
and x0.mixid = x5.mixid
and x0.foodid = x5.foodid
and x0.mixid = x6.mixid
and x0.foodid = x6.foodid
and x0.mixid = x7.mixid
and x0.foodid = x7.foodid
and x0.mixid = x8.mixid
and x0.foodid = x8.foodid
and x0.mixid = x9.mixid
and x0.foodid = x9.foodid
and x0.mixid = x13.mixid
and x0.foodid = x13.foodid
and x0.mixid = x14.mixid
and x0.foodid = x14.foodid
and x0.mixid = x15.mixid
and x0.foodid = x15.foodid
and x0.mixid = x16.mixid
and x0.foodid = x16.foodid
and x0.mixid = x17.mixid
and x0.foodid = x17.foodid
and x0.mixid = x18.mixid
and x0.foodid = x18.foodid
and x0.mixid = x19.mixid
and x0.foodid = x19.foodid
and x0.mixid = x20.mixid
and x0.foodid = x20.foodid
and x0.mixid = x21.mixid
and x0.foodid = x21.foodid
and x0.mixid = x22.mixid
and x0.foodid = x22.foodid
and x0.mixid = x23.mixid
and x0.foodid = x23.foodid
and x0.mixid = x24.mixid
and x0.foodid = x24.foodid
and x0.mixid = x25.mixid
and x0.foodid = x25.foodid
and x0.mixid = x26.mixid
and x0.foodid = x26.foodid
and x0.mixid = x27.mixid
and x0.foodid = x27.foodid
and x0.mixid = x28.mixid
and x0.foodid = x28.foodid
and x0.mixid = x29.mixid
and x0.foodid = x29.foodid
and x0.mixid = x30.mixid
and x0.foodid = x30.foodid
and x0.mixid = x31.mixid
and x0.foodid = x31.foodid
and x0.mixid = x32.mixid
and x0.foodid = x32.foodid
and x0.mixid = x33.mixid
and x0.foodid = x33.foodid
and x0.mixid = x34.mixid
and x0.foodid = x34.foodid
and x0.mixid = x35.mixid
and x0.foodid = x35.foodid
and x0.mixid = x36.mixid
and x0.foodid = x36.foodid
and x0.mixid = x37.mixid
and x0.foodid = x37.foodid
and x0.mixid = x38.mixid
and x0.foodid = x38.foodid
and x0.mixid = x39.mixid
and x0.foodid = x39.foodid
and x0.mixid = x40.mixid
and x0.foodid = x40.foodid
and x0.mixid = x41.mixid
and x0.foodid = x41.foodid
and x0.mixid = x42.mixid
and x0.foodid = x42.foodid
and x0.mixid = x43.mixid
and x0.foodid = x43.foodid
and x0.mixid = x44.mixid
and x0.foodid = x44.foodid
and x0.mixid = x45.mixid
and x0.foodid = x45.foodid
and x0.mixid = x46.mixid
and x0.foodid = x46.foodid
and x0.mixid = x47.mixid
and x0.foodid = x47.foodid
and x0.mixid = x50.mixid
and x0.foodid = x50.foodid
and x0.mixid = x51.mixid
and x0.foodid = x51.foodid
and x0.mixid = x53.mixid
and x0.foodid = x53.foodid
and x0.mixid = x54.mixid
and x0.foodid = x54.foodid
and x0.mixid = x55.mixid
and x0.foodid = x55.foodid
and x0.mixid = x56.mixid
and x0.foodid = x56.foodid
) a,
(
select foodid,name from food
) b
where a.foodid = b.foodid
group by a.MixId
order by a.EnergyDigestible,a.Weight,b.Name;
--
OPEN result;
END;
/

CREATE PROCEDURE MixResult_Select_Pct (
--
IN v_MixId INTEGER,
IN v_Precision INTEGER
--
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END ,v_Precision) AS calories,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS fat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS carbs,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS protein,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS alcohol,
       ROUND(getFoodQuotient(v_MixId),2) AS fq,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(satfat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS satfat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(monoufat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS monoufat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(polyufat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS polyufat
FROM (SELECT mixid,
             foodid,
             q AS fat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '204') a,
     (SELECT mixid,
             foodid,
             q AS digestiblecarbohydrate
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
      (SELECT mixid,
             foodid,
             q AS protein
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '203') c,
      (SELECT mixid,
             foodid,
             q AS alcohol
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '221') d,
      (SELECT mixid,
             foodid,
             q AS satfat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '606') e,
     (SELECT mixid,
             foodid,
             q AS monoufat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '645') f,
     (SELECT mixid,
             foodid,
             q AS polyufat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '646') g
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND a.mixid = e.mixid
AND a.mixid = f.mixid
AND a.mixid = g.mixid
AND   a.foodid = b.foodid
AND   a.foodid = c.foodid
AND   a.foodid = d.foodid
AND   a.foodid = e.foodid
AND   a.foodid = f.foodid
AND   a.foodid = g.foodid;
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
IN v_mixid INTEGER,
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
IN v_mixid INTEGER
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
a.NutrientId != '203' AND
a.NutrientId != '204' AND
a.NutrientId != '205' AND
a.NutrientId != '208' AND
a.NutrientId != '210' AND
a.NutrientId != '212' AND
a.NutrientId != '213' AND
a.NutrientId != '221' AND
a.NutrientId != '255' AND
a.NutrientId != '291' AND
a.NutrientId != '421' AND
a.NutrientId != '601' AND
a.NutrientId != '606' AND
a.NutrientId != '621' AND
a.NutrientId != '629' AND
a.NutrientId != '645' AND
a.NutrientId != '646' AND
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
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
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
IN v_MixId INTEGER,
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
IN v_MixId INTEGER,
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
IN v_MixId INTEGER
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
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
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

CREATE PROCEDURE Mix_Duplicate (
--
IN v_MixId_Old INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_MixId_New INTEGER;
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
CALL FoodNutrientConstraint(v_MixId_Old,v_MixId_New);
--
CALL FoodNutrientRatio(v_MixId_Old,v_MixId_New);
--
END;
/

CREATE PROCEDURE NutrientRatio_Delete (
IN v_MixId INTEGER,
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
IN v_mixid INTEGER,
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
IN v_MixId INTEGER,
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
IN v_mixid INTEGER
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
IN v_MixId INTEGER
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
IN v_mixid INTEGER
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
       ROUND(v_q / b.c,v_Precision) AS Weight
FROM food a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND   b.nutrientid = v_nutrientid
AND   b.c > 0
ORDER BY Weight;
--
OPEN result;

--
END
/

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
SET v_FoodId = generateId('f','');
SELECT Name INTO v_FoodName
FROM Mix
WHERE MixId = v_MixId;
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
CALL CategoryLink_Insert (v_FoodId,'5000');
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

call relationship_insert(1,'>');
/
call relationship_insert(2,'<');
/
call relationship_insert(3,'=');
/


CREATE PROCEDURE PercentNutrientConstraint_Merge (
IN v_MixId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_b DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO PercentConstraint USING ( VALUES (
v_MixId,
v_FoodId,
v_NutrientId,
v_b
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
)
WHEN MATCHED THEN UPDATE SET
b = v_b
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_NutrientId,
v_b;
END;
/

CREATE PROCEDURE PercentNutrientConstraint_Select (
IN v_MixId INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.FoodId,
a.NutrientId,
b.Name as Food,
c.Name as Nutrient,
a.b
FROM
PercentConstraint a, Food b, Nutrient c
WHERE
a.MixId = v_MixId
AND
a.FoodId = b.FoodId
AND
a.NutrientId = c.NutrientId
ORDER BY
a.NutrientId,a.FoodId;
--
OPEN result;
--
END;
/

CREATE PROCEDURE PercentNutrientConstraint_Delete (
IN v_MixId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
PercentConstraint
WHERE
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId;
END;
/


CREATE PROCEDURE percentnutrient_rhs (
--
IN v_mixid INTEGER
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
       b
FROM percentconstraint
WHERE mixid = v_mixid
ORDER BY foodid;
--
OPEN result;
--
END;
/

CREATE PROCEDURE percentnutrient_lhs (
--
IN v_mixid INTEGER,
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR,
--
IN v_b DOUBLE

)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT --a.mixid,
       a.foodid,
       --b.nutrientid,
       CASE
         WHEN a.foodid = v_foodid THEN b.c*(1.0-(v_b/100.0))
         ELSE -1.0*b.c*(v_b/100.0)
       END AS c
FROM mixfood a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND b.nutrientid = v_nutrientid
AND   a.mixid = v_mixid
ORDER BY a.foodid;
         ---b.nutrientid;
--	    
OPEN result;
--
END
/

CREATE PROCEDURE Mix_getFQDiff (
--
IN v_MixId_1 INTEGER,
--
IN v_MixId_2 INTEGER
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
       a.fq - b.fq AS diff
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
NutrientId != '205' AND 
NutrientId != '675' AND 
NutrientId != '851'
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

CREATE PROCEDURE Rda_Select_All ()
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
NutrientId,
q,
UL
FROM
Rda;
OPEN result;
END;
/

CREATE PROCEDURE Mix_getRdaDiff (
--
IN v_MixId INTEGER,
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
       ROUND(a.mix,v_Precision) as Mix,
       ROUND(a.rda,v_Precision) as Rda,
       ROUND(CASE WHEN a.rda <= 0 THEN 0 ELSE (a.mix/a.rda)*100 END,v_Precision)as PctRda,
       ROUND(a.ul,v_Precision) as UL,
       ROUND(CASE WHEN a.ul <= 0 THEN 0 ELSE (a.mix/a.ul)*100 END,v_Precision) as PctUL
FROM (
SELECT a.nutrientid,
       a.mix,
       b.rda,
       b.ul
      FROM (
            SELECT nutrientid,
            SUM(a.x*b.c) AS mix
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid
            AND   a.mixid = v_MixId
            AND (
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
            --Flouride
            nutrientid = '313' OR
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
            nutrientid = '10001'
            )
            GROUP BY nutrientid) a,
           (SELECT nutrientid, q AS rda, ul FROM rda WHERE lifestageid = v_LifeStageId) b
      WHERE a.nutrientid = b.nutrientid) a,
     (
SELECT nutrientid, 
       name, 
       nutrientcategoryid 
       FROM nutrient) b
WHERE a.nutrientid = b.nutrientid
ORDER BY b.nutrientcategoryid DESC,
         b.nutrientid;
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

