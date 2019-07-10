DROP SCHEMA PUBLIC CASCADE;
/

CREATE TABLE FoodFactCoefficient
(
FoodId VARCHAR(8000),
NutrientId VARCHAR(8000),
c DOUBLE,
CONSTRAINT FoodFactCoefficient_primaryKey PRIMARY KEY (FoodId, NutrientId)
);
/

CREATE TABLE FoodCategory
(
FoodCategoryId VARCHAR(8000),
Name VARCHAR(8000),
CONSTRAINT FoodCategory_primaryKey PRIMARY KEY (FoodCategoryId)
);
/

CREATE TABLE Food
(
FoodId VARCHAR(8000),
Name VARCHAR(8000),
ServingSize DOUBLE DEFAULT 100,
CONSTRAINT Food_primaryKey PRIMARY KEY (FoodId)
);
/

CREATE TABLE FoodFact
(
FoodId VARCHAR(8000),
NutrientId VARCHAR(8000),
q DOUBLE,
CONSTRAINT FoodFact_primaryKey PRIMARY KEY (FoodId, NutrientId)
);
/

CREATE TABLE Relationship
(
RelationshipId IDENTITY,
Name VARCHAR(8000),
CONSTRAINT Relationship_primaryKey PRIMARY KEY (RelationshipId)
);
/

CREATE TABLE Mix
(
MixId IDENTITY,
Name VARCHAR(8000),
ADate DATE,
ATime TIME,
Status INTEGER,
CONSTRAINT Mix_primaryKey PRIMARY KEY (MixId)
);
/

CREATE TABLE Nutrient
(
NutrientId VARCHAR(8000),
Name VARCHAR(8000),
CONSTRAINT Nutrient_primaryKey PRIMARY KEY (NutrientId)
);
/

CREATE TABLE MixFood
(
MixId INTEGER,
FoodId VARCHAR(8000),
x DOUBLE,
CONSTRAINT MixFood_primaryKey PRIMARY KEY (MixId, FoodId)
);
/

CREATE TABLE FoodNutrientRatio
(
MixId INTEGER,
Food_Id_1 VARCHAR(8000),
Nutrient_Id_1 VARCHAR(8000),
Food_Id_2 VARCHAR(8000),
Nutrient_Id_2 VARCHAR(8000),
RelationshipId INTEGER,
A INTEGER,
B INTEGER,
CONSTRAINT FoodNutrientRatio_primaryKey PRIMARY KEY (MixId, Food_Id_1, Nutrient_Id_1, Food_Id_2, Nutrient_Id_2, RelationshipId)
);
/

CREATE TABLE NutrientRatio
(
MixId INTEGER,
Nutrient_Id_1 VARCHAR(8000),
Nutrient_Id_2 VARCHAR(8000),
RelationshipId INTEGER,
A INTEGER,
B INTEGER,
CONSTRAINT NutrientRatio_primaryKey PRIMARY KEY (MixId, Nutrient_Id_1, Nutrient_Id_2, RelationshipId)
);
/

CREATE TABLE NutrientConstraint
(
MixId INTEGER,
NutrientId VARCHAR(8000),
RelationshipId INTEGER,
b DOUBLE,
CONSTRAINT NutrientConstraint_primaryKey PRIMARY KEY (MixId, NutrientId, RelationshipId)
);
/

CREATE TABLE FoodNutrientConstraint
(
MixId INTEGER,
FoodId VARCHAR(8000),
NutrientId VARCHAR(8000),
RelationshipId INTEGER,
b DOUBLE,
CONSTRAINT FoodNutrientConstraint_primaryKey PRIMARY KEY (MixId, FoodId, NutrientId, RelationshipId)
);
/

CREATE TABLE MixResultDW
(
MixId INTEGER,
FoodId VARCHAR(8000),
Name VARCHAR(8000),
Protein DOUBLE,
Fat DOUBLE,
CarbsByDifference DOUBLE,
Kcal DOUBLE,
Alcohol DOUBLE,
Fiber DOUBLE,
Calcium DOUBLE,
Magnesium DOUBLE,
Potassium DOUBLE,
Sodium DOUBLE,
Cholesterol DOUBLE,
SatFat DOUBLE,
Monoufat DOUBLE,
Polyufat DOUBLE,
Quantity DOUBLE,
Complete DOUBLE,
Incomplete DOUBLE,
CarbsDigestible DOUBLE,
Cost DOUBLE,
CONSTRAINT MixResultDW_primaryKey PRIMARY KEY (MixId, FoodId)
);
/

CREATE TABLE MixModel
(
MixId INTEGER,
NutrientId VARCHAR(8000),
Model LONGVARCHAR,
CONSTRAINT MixModel_primaryKey PRIMARY KEY (MixId)
);
/

CREATE TABLE CategoryLink
(
FoodCategoryId VARCHAR(8000),
FoodId VARCHAR(8000),
CONSTRAINT CategoryLink_primaryKey PRIMARY KEY (FoodCategoryId, FoodId)
);
/

CREATE TABLE PercentConstraint
(
MixId INTEGER,
FoodId VARCHAR(8000),
NutrientId VARCHAR(8000),
b DOUBLE,
CONSTRAINT PercentConstraint_primaryKey PRIMARY KEY (MixId, FoodId, NutrientId)
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
ALTER TABLE MixModel ADD CONSTRAINT R12_Mix_MixModel FOREIGN KEY ( MixId ) REFERENCES Mix ( MixId ) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R13_Nutrient_FoodFact FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R14_Nutrient_FoodNutrientRatio FOREIGN KEY ( Nutrient_Id_1 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R15_Nutrient_FoodNutrientRatio FOREIGN KEY ( Nutrient_Id_2 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R16_Nutrient_NutrientRatio FOREIGN KEY ( Nutrient_Id_1 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R17_Nutrient_NutrientRatio FOREIGN KEY ( Nutrient_Id_2 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R18_Nutrient_NutrientConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R19_Nutrient_FoodNutrientConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE MixModel ADD CONSTRAINT R20_Nutrient_MixModel FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE SET NULL;
/
ALTER TABLE PercentConstraint ADD CONSTRAINT R21_Nutrient_PercentConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R22_MixFood_FoodNutrientRatio FOREIGN KEY ( MixId,Food_Id_1 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R23_MixFood_FoodNutrientRatio FOREIGN KEY ( MixId,Food_Id_2 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R24_MixFood_FoodNutrientConstraint FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE MixResultDW ADD CONSTRAINT R25_MixFood_MixResultDW FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE PercentConstraint ADD CONSTRAINT R26_MixFood_PercentConstraint FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/


CREATE FUNCTION getFoodCoefficient(IN v_FoodId VARCHAR(8000),IN v_NutrientId VARCHAR(8000) ) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE v_c DOUBLE;
select b.q/a.servingsize INTO v_c from food a, foodfact b where a.foodid = b.foodid and a.foodid = v_FoodId and b.nutrientid = v_NutrientId;
RETURN v_c;
END;
/


CREATE FUNCTION getFoodName (IN v_FoodId VARCHAR(8000)) RETURNS VARCHAR(8000) 
--
READS SQL DATA BEGIN ATOMIC 
--
DECLARE v_name VARCHAR(8000);
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
IN v_FoodId VARCHAR(8000),
--
IN v_NutrientId VARCHAR(8000)
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


CREATE FUNCTION getFoodFactValue (IN v_FoodId VARCHAR(8000),IN v_NutrientId VARCHAR(8000)) RETURNS DOUBLE 
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_q DOUBLE;
--
SELECT a.q INTO v_q
FROM foodfact a
WHERE a.foodid = v_FoodId
AND   a.nutrientid = v_NutrientId;
--
RETURN v_q;
--
END;
/


CREATE FUNCTION getMixResultSumValue (
--
IN v_MixId INTEGER,
--
IN v_NutrientId VARCHAR(8000)
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


CREATE TRIGGER FoodFact_RowLevelAfterUpdate_Trigger
AFTER UPDATE ON FoodFact REFERENCING NEW ROW AS newrow OLD as oldrow
FOR EACH ROW
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
SET v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
--
UPDATE
FoodFactCoefficient
SET
c = v_c
WHERE
FoodId = newrow.FoodId
AND
NutrientId = newrow.NutrientId;
--
END;
/


CREATE TRIGGER MixFood_RowLevelAfterDelete_Trigger
AFTER DELETE ON MixFood REFERENCING OLD as row
FOR EACH ROW
BEGIN ATOMIC
--
DELETE FROM MixResultDw WHERE MixId = row.MixId;
--
END;
/


CREATE PROCEDURE CategoryLink_Insert (
IN v_FoodId VARCHAR(8000),
IN v_FoodCategoryId VARCHAR(8000)
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

CREATE PROCEDURE CategoryLink_Delete (
--
IN v_FoodCategoryId VARCHAR(8000),
--
IN v_FoodId VARCHAR(8000)
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


CREATE PROCEDURE Food_Delete (
--
IN v_FoodId VARCHAR(8000)
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


CREATE PROCEDURE Food_Insert (
IN v_FoodId VARCHAR(8000),
IN v_Name VARCHAR(8000),
IN v_ServingSize DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Food (
FoodId,
Name,
ServingSize
) VALUES (
v_FoodId,
v_Name,
v_ServingSize
);
END;
/


CREATE PROCEDURE Food_Insert_Default (
IN v_FoodId VARCHAR(8000),
IN v_Name VARCHAR(8000)
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

CREATE PROCEDURE Food_Select_By_Category (
--
IN v_FoodCategoryId VARCHAR(8000)
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

CREATE PROCEDURE Food_Select_Details ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT y.category,
       x.food,
       x.protein,
       x.fat,
       --       x.carbohydrate,
       x.calories,
       x.alcohol,
       x.fiber,
       x.calcium,
       x.magnesium,
       x.potassium,
       x.sodium,
       x.cholesterol,
       x.satfat,
       x.monoufat,
       x.polyufat,
       x.quantity,
       x.complete,
       x.incomplete,
       x.carbsdigestible,
       x.cost,
       y.foodcategoryid,
       x.foodid
FROM (SELECT a0.name AS food,
             a1.protein,
             a2.fat,
             --             a3.carbohydrate,
             a4.calories,
             a5.alcohol,
             a6.fiber,
             a7.calcium,
             a8.magnesium,
             a9.potassium,
             a10.sodium,
             a11.cholesterol,
             a12.satfat,
             a13.monoufat,
             a14.polyufat,
             a15.quantity,
             a16.complete,
             a17.incomplete,
             a18.carbsdigestible,
             a20.cost,
             a0.foodid
      FROM
      --
      (SELECT b.name, b.foodid FROM food b) a0,
           --
      (SELECT foodid,
              q AS protein
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '203') a1,
           --
      (SELECT foodid,
              q AS fat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '204') a2,
           (SELECT foodid,
                   q AS calories
            FROM food a,
                 foodfact b
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = '208') a4,
           --
      (SELECT foodid,
              q AS alcohol
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '221') a5,
           --
      (SELECT foodid,
              q AS fiber
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '291') a6,
           --
      (SELECT foodid,
              q AS calcium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '301') a7,
           --
      (SELECT foodid,
              q AS magnesium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '304') a8,
           --
      (SELECT foodid,
              q AS potassium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '306') a9,
           --
      (SELECT foodid,
              q AS sodium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '307') a10,
           --
      (SELECT foodid,
              q AS cholesterol
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '601') a11,
           --
      (SELECT foodid,
              q AS satfat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '606') a12,
           --
      (SELECT foodid,
              q AS monoufat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '645') a13,
           --
      (SELECT foodid,
              q AS polyufat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '646') a14,
           --
      (SELECT foodid,
              q AS quantity
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10000') a15,
           --
      (SELECT foodid,
              q AS complete
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10001') a16,
           --
      (SELECT foodid,
              q AS incomplete
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10002') a17,
           --
      (SELECT foodid,
              q AS carbsdigestible
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10003') a18,
           --
      (SELECT foodid,
              q AS cost
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10005') a20
      WHERE a0.foodid = a1.foodid
      AND   a0.foodid = a2.foodid
      --      AND   a0.foodid = a3.foodid
      AND   a0.foodid = a4.foodid
      AND   a0.foodid = a5.foodid
      AND   a0.foodid = a6.foodid
      AND   a0.foodid = a7.foodid
      AND   a0.foodid = a8.foodid
      AND   a0.foodid = a9.foodid
      AND   a0.foodid = a10.foodid
      AND   a0.foodid = a11.foodid
      AND   a0.foodid = a12.foodid
      AND   a0.foodid = a13.foodid
      AND   a0.foodid = a14.foodid
      AND   a0.foodid = a15.foodid
      AND   a0.foodid = a16.foodid
      AND   a0.foodid = a17.foodid
      AND   a0.foodid = a18.foodid
      AND   a0.foodid = a20.foodid) x
  LEFT JOIN (SELECT c.name AS category,
                    c.foodcategoryid,
                    a.foodid
             FROM categorylink a,
                  foodcategory c
             WHERE a.foodcategoryid = c.foodcategoryid) y ON x.foodid = y.foodid
ORDER BY category,
         food;
--
OPEN result;

--
END;
/

CREATE PROCEDURE Food_Update (
IN v_FoodId VARCHAR(8000),
IN v_Name VARCHAR(8000),
IN v_ServingSize DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Food
SET
Name = v_Name,
ServingSize = v_ServingSize
WHERE
FoodId = v_FoodId;
END;
/

CREATE PROCEDURE FoodCategory_Delete (
--
IN v_FoodCategoryId VARCHAR(8000)
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
IN v_txt_1 VARCHAR(8000),
--
IN v_txt_2 VARCHAR(8000)
--
) RETURNS VARCHAR(8000)
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_id VARCHAR(8000);
--
SELECT v_txt_1||v_txt_2||generateLargeRandomNumber() INTO v_id FROM (VALUES(0));
--
RETURN v_id;
--
END;
/

CREATE PROCEDURE FoodCategory_Insert (
IN v_FoodCategoryId VARCHAR(8000),
IN v_Name VARCHAR(8000)
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
IN v_Name VARCHAR(8000)
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
IN v_FoodCategoryId VARCHAR(8000),
--
IN v_Name VARCHAR(8000)
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

CREATE PROCEDURE FoodFact_Insert (
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO FoodFact (
FoodId,
NutrientId,
q
) VALUES (
v_FoodId,
v_NutrientId,
v_q
);
END;
/


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

CREATE PROCEDURE FoodFact_Merge (
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
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


CREATE TRIGGER FoodFact_RowLevelAfterInsert_Trigger
AFTER INSERT ON FoodFact REFERENCING NEW ROW AS newrow
FOR EACH ROW
BEGIN ATOMIC
DECLARE v_c DOUBLE;
set v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
INSERT INTO FoodFactCoefficient VALUES (newrow.FoodId,newrow.NutrientId,v_c);
END;
/


CREATE PROCEDURE FoodFact_Update (
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
FoodFact
SET
q = v_q
WHERE
FoodId = v_FoodId
AND
NutrientId = v_NutrientId;
END;
/


CREATE PROCEDURE Food_Update_Details (
--
IN v_foodid VARCHAR(8000),
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
call Food_Update(v_FoodId,v_foodnom,v_serving_size);
--
call FoodFact_Update(v_FoodId,'10000',v_serving_size);
--
call FoodFact_Update(v_FoodId,'208',v_calories);
--
call FoodFact_Update(v_FoodId,'203',v_protein);
--
call FoodFact_Update(v_FoodId,'204',v_fat);
--
call FoodFact_Update(v_FoodId,'10003',v_carbohydrates);
--
call FoodFact_Update(v_FoodId,'291',v_fiber);
--
call FoodFact_Update(v_FoodId,'606',v_saturated_fat);
--
call FoodFact_Update(v_FoodId,'645',v_monounsaturated_fat);
--
call FoodFact_Update(v_FoodId,'646',v_polyunsaturated_fat);
--
call FoodFact_Update(v_FoodId,'601',v_cholesterol);
--
call FoodFact_Update(v_FoodId,'307',v_sodium);
--
call FoodFact_Update(v_FoodId,'306',v_potassium);
--
call FoodFact_Update(v_FoodId,'301',v_calcium);
--
call FoodFact_Update(v_FoodId,'304',v_magnesium);
--
call FoodFact_Update(v_FoodId,'10005',v_cost);
--
call FoodFact_Update(v_FoodId,'10001',v_complete_protein);
--
call FoodFact_Update(v_FoodId,'10002',v_incomplete_protein);
--
call FoodFact_Update(v_FoodId,'221',v_alcohol);
--
END;
/

CREATE PROCEDURE foodnutrient_lhs (
--
IN v_mixid INTEGER,
--
IN v_foodid VARCHAR(8000),
--
IN v_nutrientid VARCHAR(8000),
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


CREATE PROCEDURE FoodNutrientConstraint_Delete (
IN v_MixId INTEGER,
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
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
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
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


CREATE PROCEDURE FoodNutrientRatio_Delete (
IN v_MixId INTEGER,
IN v_Food_Id_1 VARCHAR(8000),
IN v_Nutrient_Id_1 VARCHAR(8000),
IN v_Food_Id_2 VARCHAR(8000),
IN v_Nutrient_Id_2 VARCHAR(8000),
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
IN v_foodid1 VARCHAR(8000),
--
IN v_nutrientid1 VARCHAR(8000),
--
IN v_foodid2 VARCHAR(8000),
--
IN v_nutrientid2 VARCHAR(8000),
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


CREATE PROCEDURE FoodNutrientRatio_Merge (
IN v_MixId INTEGER,
IN v_Food_Id_1 VARCHAR(8000),
IN v_Nutrient_Id_1 VARCHAR(8000),
IN v_Food_Id_2 VARCHAR(8000),
IN v_Nutrient_Id_2 VARCHAR(8000),
IN v_RelationshipId INTEGER,
IN v_A INTEGER,
IN v_B INTEGER
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
a.B
FROM
FoodNutrientRatio a, Food b, Nutrient c, Food d, Nutrient e
WHERE
a.MixId = v_MixId
AND
a.Food_Id_1 = b.FoodId
AND
a.Nutrient_Id_1 = c.NutrientId
AND
a.Food_Id_2 = d.FoodId
AND
a.Nutrient_Id_2 = e.NutrientId;
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
DECLARE v_Name_Old VARCHAR(8000);
--
DECLARE v_ADate DATE;
--
DECLARE v_ATime TIME;
--
SELECT Name INTO v_Name_Old FROM Mix WHERE MixId = v_MixId_Old;
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
Status
) VALUES (
DEFAULT,
v_Name_Old||'_copy',
v_ADate,
v_ATime,
1
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
--
IN v_MixId_2 INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.name,
       round(a.mix1),
       round(a.mix2),
       round(a.diff)
FROM (SELECT a.nutrientid,
             a.value AS mix1,
             b.value AS mix2,
             a.value - b.value AS diff
      FROM (SELECT nutrientid,
                   SUM(a.x*b.c) AS value
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid
            AND   a.mixid = v_MixId_1
            GROUP BY nutrientid) a,
           (SELECT nutrientid,
                   SUM(a.x*b.c) AS value
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid
            AND   a.mixid = v_MixId_2
            GROUP BY nutrientid) b
      WHERE a.nutrientid = b.nutrientid) a,
     (SELECT nutrientid, name FROM nutrient) b
WHERE a.nutrientid = b.nutrientid
ORDER BY a.nutrientid;
--
OPEN result;
--
END;
/

CREATE PROCEDURE Mix_Insert (
--
OUT newid INTEGER,
--
IN v_Name VARCHAR(8000)
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
SELECT
MixId,
Name
FROM
Mix;
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
SELECT
MixId,
Name
FROM
Mix
WHERE Status = 0;
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
SELECT
MixId,
Name
FROM
Mix
WHERE Status = 1;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Mix_Update (
IN v_MixId INTEGER,
IN v_Name VARCHAR(8000)
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
IN v_FoodId VARCHAR(8000)
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
IN v_FoodId VARCHAR(8000)
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
a.mixid = v_mixid;
OPEN result;
END;
/


CREATE PROCEDURE MixFood_Update (
IN v_MixId INTEGER,
IN v_FoodId VARCHAR(8000),
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


CREATE PROCEDURE MixModel_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO MixModel
(
  mixid,
  nutrientid,
  model
)
SELECT v_MixId_New,
       nutrientid,
       model
FROM MixModel
WHERE mixid = v_MixId_Old;
--
END;
/


CREATE PROCEDURE MixModel_Merge (
IN v_MixId INTEGER,
IN v_NutrientId VARCHAR(8000),
IN v_Model VARCHAR(8000)
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO MixModel USING ( VALUES (
v_MixId,
v_NutrientId,
v_Model
) ) ON (
MixId = v_MixId
)
WHEN MATCHED THEN UPDATE SET
NutrientId = v_NutrientId,
Model = v_Model
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_NutrientId,
v_Model;
END;
/

CREATE PROCEDURE MixModel_Select (
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
Model
FROM
MixModel
WHERE
MixId = v_MixId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE MixResultDw_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO MixResultDw
(
  mixid,
  foodid,
  Name,
  Protein,
  Fat,
  CarbsByDifference,
  Kcal,
  Alcohol,
  Fiber,
  Calcium,
  Magnesium,
  Potassium,
  Sodium,
  Cholesterol,
  SatFat,
  Monoufat,
  Polyufat,
  Quantity,
  Complete,
  Incomplete,
  CarbsDigestible,
  Cost
)
SELECT v_MixId_New,
       foodid,
       Name,
       Protein,
       Fat,
       CarbsByDifference,
       Kcal,
       Alcohol,
       Fiber,
       Calcium,
       Magnesium,
       Potassium,
       Sodium,
       Cholesterol,
       SatFat,
       Monoufat,
       Polyufat,
       Quantity,
       Complete,
       Incomplete,
       CarbsDigestible,
       Cost
FROM MixResultDw
WHERE mixid = v_MixId_Old;

--
END;
/

CREATE PROCEDURE MixResultDW_Merge (
IN v_MixId INTEGER,
IN v_FoodId VARCHAR(8000)
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_Name VARCHAR(8000);
DECLARE v_Protein DOUBLE;
DECLARE v_Fat DOUBLE;
DECLARE v_CarbsByDifference DOUBLE;
DECLARE v_Kcal DOUBLE;
DECLARE v_Alcohol DOUBLE;
DECLARE v_Fiber DOUBLE;
DECLARE v_Calcium DOUBLE;
DECLARE v_Magnesium DOUBLE;
DECLARE v_Potassium DOUBLE;
DECLARE v_Sodium DOUBLE;
DECLARE v_Cholesterol DOUBLE;
DECLARE v_SatFat DOUBLE;
DECLARE v_Monoufat DOUBLE;
DECLARE v_Polyufat DOUBLE;
DECLARE v_Quantity DOUBLE;
DECLARE v_Complete DOUBLE;
DECLARE v_Incomplete DOUBLE;
DECLARE v_CarbsDigestible DOUBLE;
DECLARE v_Cost DOUBLE;
--
--
SET v_Name =  getFoodName(v_FoodId);
SET v_Protein =  getmixresultvalue(v_MixId,v_FoodId,'203');
SET v_Fat =  getmixresultvalue(v_MixId,v_FoodId,'204');
SET v_CarbsByDifference =  getmixresultvalue(v_MixId,v_FoodId,'205');
SET v_Kcal =  getmixresultvalue(v_MixId,v_FoodId,'208');
SET v_Alcohol =  getmixresultvalue(v_MixId,v_FoodId,'221');
SET v_Fiber =  getmixresultvalue(v_MixId,v_FoodId,'291');
SET v_Calcium =  getmixresultvalue(v_MixId,v_FoodId,'301');
SET v_Magnesium =  getmixresultvalue(v_MixId,v_FoodId,'304');
SET v_Potassium =  getmixresultvalue(v_MixId,v_FoodId,'306');
SET v_Sodium =  getmixresultvalue(v_MixId,v_FoodId,'307');
SET v_Cholesterol =  getmixresultvalue(v_MixId,v_FoodId,'601');
SET v_SatFat =  getmixresultvalue(v_MixId,v_FoodId,'606');
SET v_Monoufat =  getmixresultvalue(v_MixId,v_FoodId,'645');
SET v_Polyufat =  getmixresultvalue(v_MixId,v_FoodId,'646');
SET v_Quantity =  getmixresultvalue(v_MixId,v_FoodId,'10000');
SET v_Complete =  getmixresultvalue(v_MixId,v_FoodId,'10001');
SET v_Incomplete =  getmixresultvalue(v_MixId,v_FoodId,'10002');
SET v_CarbsDigestible =  getmixresultvalue(v_MixId,v_FoodId,'10003');
SET v_Cost =  getmixresultvalue(v_MixId,v_FoodId,'10005');
--
MERGE INTO MixResultDW USING ( VALUES (
v_MixId,
v_FoodId,
v_Name,
v_Protein,
v_Fat,
v_CarbsByDifference,
v_Kcal,
v_Alcohol,
v_Fiber,
v_Calcium,
v_Magnesium,
v_Potassium,
v_Sodium,
v_Cholesterol,
v_SatFat,
v_Monoufat,
v_Polyufat,
v_Quantity,
v_Complete,
v_Incomplete,
v_CarbsDigestible,
v_Cost
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
Name = v_Name,
Protein = v_Protein,
Fat = v_Fat,
CarbsByDifference = v_CarbsByDifference,
Kcal = v_Kcal,
Alcohol = v_Alcohol,
Fiber = v_Fiber,
Calcium = v_Calcium,
Magnesium = v_Magnesium,
Potassium = v_Potassium,
Sodium = v_Sodium,
Cholesterol = v_Cholesterol,
SatFat = v_SatFat,
Monoufat = v_Monoufat,
Polyufat = v_Polyufat,
Quantity = v_Quantity,
Complete = v_Complete,
Incomplete = v_Incomplete,
CarbsDigestible = v_CarbsDigestible,
Cost = v_Cost
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_Name,
v_Protein,
v_Fat,
v_CarbsByDifference,
v_Kcal,
v_Alcohol,
v_Fiber,
v_Calcium,
v_Magnesium,
v_Potassium,
v_Sodium,
v_Cholesterol,
v_SatFat,
v_Monoufat,
v_Polyufat,
v_Quantity,
v_Complete,
v_Incomplete,
v_CarbsDigestible,
v_Cost;
--
END;
/

CREATE PROCEDURE MixResultDW_Select (
IN v_MixId INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT MIXID,
       FOODID,
       NAME,
       PROTEIN,
       FAT,
       KCAL,
       ALCOHOL,
       FIBER,
       CALCIUM,
       MAGNESIUM,
       POTASSIUM,
       SODIUM,
       CHOLESTEROL,
       SATFAT,
       MONOUFAT,
       POLYUFAT,
       QUANTITY,
       COMPLETE,
       INCOMPLETE,
       CARBSDIGESTIBLE,
       COST
FROM (
SELECT MIXID,
       FOODID,
       NAME,
       ROUND(PROTEIN) as protein,
       ROUND(FAT) as fat,
       ROUND(KCAL) as kcal,
       ROUND(ALCOHOL) as alcohol,
       ROUND(FIBER) as fiber,
       ROUND(CALCIUM) as calcium,
       ROUND(MAGNESIUM) as magnesium,
       ROUND(POTASSIUM) as potassium,
       ROUND(SODIUM) as sodium,
       ROUND(CHOLESTEROL) as cholesterol,
       ROUND(SATFAT) as satfat,
       ROUND(MONOUFAT) as monoufat,
       ROUND(POLYUFAT) as polyufat,
       ROUND(QUANTITY) as quantity,
       ROUND(COMPLETE) as complete,
       ROUND(INCOMPLETE) as incomplete,
       ROUND(CARBSDIGESTIBLE) as carbsdigestible,
       ROUND(COST) as cost
FROM PUBLIC.MIXRESULTDW
WHERE MIXID = V_MIXID
UNION
SELECT MIXID,
       '99999',
       'Total',
       ROUND(SUM(PROTEIN)),
       ROUND(SUM(FAT)),
       ROUND(SUM(KCAL)),
       ROUND(SUM(ALCOHOL)),
       ROUND(SUM(FIBER)),
       ROUND(SUM(CALCIUM)),
       ROUND(SUM(MAGNESIUM)),
       ROUND(SUM(POTASSIUM)),
       ROUND(SUM(SODIUM)),
       ROUND(SUM(CHOLESTEROL)),
       ROUND(SUM(SATFAT)),
       ROUND(SUM(MONOUFAT)),
       ROUND(SUM(POLYUFAT)),
       ROUND(SUM(QUANTITY)),
       ROUND(SUM(COMPLETE)),
       ROUND(SUM(INCOMPLETE)),
       ROUND(SUM(CARBSDIGESTIBLE)),
       ROUND(SUM(COST))
FROM PUBLIC.MIXRESULTDW
WHERE MIXID = V_MIXID
GROUP BY MIXID
)
ORDER BY KCAL;
--
OPEN result;
END;
/

CREATE TRIGGER MixFood_RowLevelAfterUpdate_Trigger
AFTER UPDATE ON MixFood REFERENCING NEW ROW AS row OLD as oldrow
FOR EACH ROW
BEGIN ATOMIC
--
CALL MixResultDW_Merge(row.mixid,row.foodid);
--
END;
/


CREATE PROCEDURE MixResultDW_Select_Pct (
--
IN v_MixId INTEGER
--
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT ROUND(SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93),1) AS calories,
       ROUND(SUM(fat*9) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*100,1) AS fat,
       ROUND(SUM(carbsdigestible*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*100,1) AS carbs,
       ROUND(SUM(protein*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*100,1) AS protein,
       ROUND(SUM(alcohol*6.93) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*100,1) AS alcohol,
       --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       ROUND(
       SUM(carbsdigestible*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*1.00 + 
       SUM(fat*9) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.71 + 
       SUM(protein*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.81 +
       SUM(alcohol*6.93) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.667
       ,2) AS fq
FROM mixresultdw
WHERE mixid = v_MixId;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Nutrient_Insert (
IN v_NutrientId VARCHAR(8000),
IN v_Name VARCHAR(8000)
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Nutrient (
NutrientId,
Name
) VALUES (
v_NutrientId,
v_Name
);
END;
/


CREATE PROCEDURE nutrient_lhs (
--
IN v_mixid INTEGER,
IN v_nutrientid VARCHAR(8000),
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


CREATE PROCEDURE Nutrient_Select_All ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name 
FROM
Nutrient
WHERE NutrientId != '205'
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
IN v_NutrientId VARCHAR(8000),
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
IN v_NutrientId VARCHAR(8000),
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
call mixmodel_copy(v_MixId_Old,v_MixId_New);
--
CALL MixResultDw_Copy(v_MixId_Old,v_MixId_New);
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
IN v_Nutrient_Id_1 VARCHAR(8000),
IN v_Nutrient_Id_2 VARCHAR(8000),
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
IN v_nutrientid1 VARCHAR(8000),
--
IN v_nutrientid2 VARCHAR(8000),
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
IN v_Nutrient_Id_1 VARCHAR(8000),
IN v_Nutrient_Id_2 VARCHAR(8000),
IN v_RelationshipId INTEGER,
IN v_A INTEGER,
IN v_B INTEGER
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
a.B
FROM
NutrientRatio a, Nutrient b, Nutrient c
WHERE
a.MixId = v_MixId
AND
a.Nutrient_Id_1 = b.NutrientId
AND
a.Nutrient_Id_2 = c.NutrientId;
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
b.nutrientid = (SELECT a.nutrientid FROM mixmodel a WHERE a.mixid = v_mixid)
ORDER BY foodid;
--
OPEN result;
--
END;
/


CREATE PROCEDURE Relationship_Insert (
IN v_RelationshipId INTEGER,
IN v_Name VARCHAR(8000)
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


CREATE PROCEDURE Food_Exchange_List (
--
IN v_nutrientid VARCHAR(8000),
--
IN v_q DOUBLE
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT a.name,
       ROUND(v_q / b.c) AS Quantity
FROM food a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND   b.nutrientid = v_nutrientid
AND   b.c > 0
ORDER BY quantity;
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

CREATE FUNCTION CategoryLink_Count (
--
IN v_FoodCategoryId VARCHAR(8000),
--
IN v_FoodId VARCHAR(8000)
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
IN v_txt VARCHAR(8000)
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


call nutrient_insert('203','Protein');
/
call nutrient_insert('204','Total lipid (fat)');
/
call nutrient_insert('208','Energy (Kcal)');
/
call nutrient_insert('221','Alcohol, ethyl');
/
call nutrient_insert('291','Fiber, total dietary');
/
call nutrient_insert('301','Calcium, Ca');
/
call nutrient_insert('304','Magnesium, Mg');
/
call nutrient_insert('306','Potassium, K');
/
call nutrient_insert('307','Sodium, Na');
/
call nutrient_insert('601','Cholesterol');
/
call nutrient_insert('606','Fatty acids, total saturated');
/
call nutrient_insert('645','Fatty acids, total monounsaturated');
/
call nutrient_insert('646','Fatty acids, total polyunsaturated');
/
call nutrient_insert('10000','Quantity');
/
call nutrient_insert('10001','Complete Protein');
/
call nutrient_insert('10002','Incomplete Protein');
/
call nutrient_insert('10003','Carbohydrates Digestible');
/
call nutrient_insert('10005','Cost');
/

CREATE PROCEDURE PercentNutrientConstraint_Merge (
IN v_MixId INTEGER,
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
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
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000)
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
IN v_foodid VARCHAR(8000),
--
IN v_nutrientid VARCHAR(8000),
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
SELECT 'Food Quotient' as nutrient,a.fq as mix1,b.fq as mix2,a.fq-b.fq as diff
FROM
(SELECT --Food quotient (FQ) calculated using the equation of Black et al
        --FQ for alcohol is 0.667
       ROUND(
       SUM(carbsdigestible*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*1.00 + 
       SUM(fat*9) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.71 + 
       SUM(protein*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.81 +
       SUM(alcohol*6.93) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.667
       ,2) AS fq
FROM mixresultdw
WHERE mixid = v_MixId_1) as a,
(SELECT --Food quotient (FQ) calculated using the equation of Black et al
        --FQ for alcohol is 0.667
       ROUND(
       SUM(carbsdigestible*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*1.00 + 
       SUM(fat*9) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.71 + 
       SUM(protein*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.81 +
       SUM(alcohol*6.93) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.667
       ,2) AS fq
FROM mixresultdw
WHERE mixid = v_MixId_2) as b;
--
OPEN result;
--
END;
/

