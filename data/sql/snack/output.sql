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

CREATE TABLE MixResultDW
(
MixId INTEGER,
FoodId LONGVARCHAR,
Name LONGVARCHAR,
Weight DOUBLE,
CompleteProtein DOUBLE,
IncompleteProtein DOUBLE,
DigestibleCarbohydrate DOUBLE,
Cost DOUBLE,
Protein DOUBLE,
Fat DOUBLE,
CarbsByDiff DOUBLE,
Energy DOUBLE,
Sucrose DOUBLE,
Fructose DOUBLE,
Lactose DOUBLE,
Alcohol DOUBLE,
Water DOUBLE,
Fiber DOUBLE,
Calcium DOUBLE,
Iron DOUBLE,
Magnesium DOUBLE,
Phosphorus DOUBLE,
Potassium DOUBLE,
Sodium DOUBLE,
Zinc DOUBLE,
Copper DOUBLE,
Fluoride DOUBLE,
Manganese DOUBLE,
Selenium DOUBLE,
VitaminA DOUBLE,
VitaminE DOUBLE,
VitaminD DOUBLE,
VitaminC DOUBLE,
Thiamin DOUBLE,
Riboflavin DOUBLE,
Niacin DOUBLE,
Pantothenic DOUBLE,
VitaminB6 DOUBLE,
VitaminB12 DOUBLE,
Choline DOUBLE,
VitaminK DOUBLE,
Folate DOUBLE,
Cholesterol DOUBLE,
Saturated DOUBLE,
DHA DOUBLE,
EPA DOUBLE,
Monounsaturated DOUBLE,
Polyunsaturated DOUBLE,
Linoleic DOUBLE,
AlphaLinolenic DOUBLE,
CONSTRAINT MixResultDW_primaryKey PRIMARY KEY (MixId, FoodId)
);
/

CREATE TABLE MixModel
(
MixId INTEGER,
NutrientId LONGVARCHAR,
Model LONGVARCHAR,
CONSTRAINT MixModel_primaryKey PRIMARY KEY (MixId)
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
ALTER TABLE Rda ADD CONSTRAINT R27_RdaLifeStage_Rda FOREIGN KEY ( LifeStageId ) REFERENCES RdaLifeStage ( LifeStageId ) ON DELETE CASCADE;
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


CREATE FUNCTION getFoodFactValue (IN v_FoodId LONGVARCHAR,IN v_NutrientId LONGVARCHAR) RETURNS DOUBLE
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

CREATE PROCEDURE Food_Select_Details (
IN v_Precision INTEGER
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT b.name AS "Category",
       a.name AS "Name",
       ROUND(x0.q,v_Precision) AS "Weight",
       ROUND(x1.q,v_Precision) AS "CompleteProtein",
       ROUND(x2.q,v_Precision) AS "IncompleteProtein",
       ROUND(x3.q,v_Precision) AS "DigestibleCarbs",
       ROUND(x4.q,v_Precision) AS "Cost",
       ROUND(x5.q,v_Precision) AS "Protein",
       ROUND(x6.q,v_Precision) AS "Fat",
       ROUND(x7.q,v_Precision) AS "CarbsByDiff",
       ROUND(x8.q,v_Precision) AS "Energy",
       ROUND(x9.q,v_Precision) AS "Sucrose",
       ROUND(x10.q,v_Precision) AS "Fructose",
       ROUND(x11.q,v_Precision) AS "Lactose",
       ROUND(x12.q,v_Precision) AS "Alcohol",
       ROUND(x13.q,v_Precision) AS "Water",
       ROUND(x16.q,v_Precision) AS "Fiber",
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
       ROUND(x42.q,v_Precision) AS "Cholesterol",
       ROUND(x43.q,v_Precision) AS "Saturated",
       ROUND(x44.q,v_Precision) AS "DHA",
       ROUND(x45.q,v_Precision) AS "EPA",
       ROUND(x46.q,v_Precision) AS "Monounsaturated",
       ROUND(x47.q,v_Precision) AS "Polyunsaturated",
       ROUND(x48.q,v_Precision) AS "Linoleic",
       ROUND(x49.q,v_Precision) AS "AlphaLinolenic",
       b.foodcategoryid AS "CategoryId",
       a.foodid AS "FoodId"
FROM food a,
     foodcategory b,
     categorylink c,
     foodfact x0,
     foodfact x1,
     foodfact x2,
     foodfact x3,
     foodfact x4,
     foodfact x5,
     foodfact x6,
     foodfact x7,
     foodfact x8,
     foodfact x9,
     foodfact x10,
     foodfact x11,
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
     foodfact x49
WHERE
(
b.foodcategoryid =  c.foodcategoryid AND
a.foodid = c.foodid AND
a.foodid = x0.foodid AND
a.foodid = x1.foodid AND
a.foodid = x2.foodid AND
a.foodid = x3.foodid AND
a.foodid = x4.foodid AND
a.foodid = x5.foodid AND
a.foodid = x6.foodid AND
a.foodid = x7.foodid AND
a.foodid = x8.foodid AND
a.foodid = x9.foodid AND
a.foodid = x10.foodid AND
a.foodid = x11.foodid AND
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
a.foodid = x49.foodid
)
AND
(
x0.nutrientid = '10000' AND
x1.nutrientid = '10001' AND
x2.nutrientid = '10002' AND
x3.nutrientid = '10003' AND
x4.nutrientid = '10005' AND
x5.nutrientid = '203' AND
x6.nutrientid = '204' AND
x7.nutrientid = '205' AND
x8.nutrientid = '208' AND
x9.nutrientid = '210' AND
x10.nutrientid = '212' AND
x11.nutrientid = '213' AND
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
x48.nutrientid = '675' AND
x49.nutrientid = '851'
)
UNION
SELECT null,
       a.name AS "Name",
       ROUND(x0.q,v_Precision) AS "Weight",
       ROUND(x1.q,v_Precision) AS "CompleteProtein",
       ROUND(x2.q,v_Precision) AS "IncompleteProtein",
       ROUND(x3.q,v_Precision) AS "DigestibleCarbs",
       ROUND(x4.q,v_Precision) AS "Cost",
       ROUND(x5.q,v_Precision) AS "Protein",
       ROUND(x6.q,v_Precision) AS "Fat",
       ROUND(x7.q,v_Precision) AS "CarbsByDiff",
       ROUND(x8.q,v_Precision) AS "Energy",
       ROUND(x9.q,v_Precision) AS "Sucrose",
       ROUND(x10.q,v_Precision) AS "Fructose",
       ROUND(x11.q,v_Precision) AS "Lactose",
       ROUND(x12.q,v_Precision) AS "Alcohol",
       ROUND(x13.q,v_Precision) AS "Water",
       ROUND(x16.q,v_Precision) AS "Fiber",
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
       ROUND(x42.q,v_Precision) AS "Cholesterol",
       ROUND(x43.q,v_Precision) AS "Saturated",
       ROUND(x44.q,v_Precision) AS "DHA",
       ROUND(x45.q,v_Precision) AS "EPA",
       ROUND(x46.q,v_Precision) AS "Monounsaturated",
       ROUND(x47.q,v_Precision) AS "Polyunsaturated",
       ROUND(x48.q,v_Precision) AS "Linoleic",
       ROUND(x49.q,v_Precision) AS "AlphaLinolenic",
       null,
       a.foodid AS "FoodId"
FROM (SELECT
foodid,
name
FROM food
WHERE foodid NOT IN (SELECT
                     b.foodid
                     FROM categorylink a,
                          food b
                     WHERE a.foodid = b.foodid)) a,
     foodfact x0,
     foodfact x1,
     foodfact x2,
     foodfact x3,
     foodfact x4,
     foodfact x5,
     foodfact x6,
     foodfact x7,
     foodfact x8,
     foodfact x9,
     foodfact x10,
     foodfact x11,
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
     foodfact x49
WHERE
(
a.foodid = x0.foodid AND
a.foodid = x1.foodid AND
a.foodid = x2.foodid AND
a.foodid = x3.foodid AND
a.foodid = x4.foodid AND
a.foodid = x5.foodid AND
a.foodid = x6.foodid AND
a.foodid = x7.foodid AND
a.foodid = x8.foodid AND
a.foodid = x9.foodid AND
a.foodid = x10.foodid AND
a.foodid = x11.foodid AND
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
a.foodid = x49.foodid
)
AND
(
x0.nutrientid = '10000' AND
x1.nutrientid = '10001' AND
x2.nutrientid = '10002' AND
x3.nutrientid = '10003' AND
x4.nutrientid = '10005' AND
x5.nutrientid = '203' AND
x6.nutrientid = '204' AND
x7.nutrientid = '205' AND
x8.nutrientid = '208' AND
x9.nutrientid = '210' AND
x10.nutrientid = '212' AND
x11.nutrientid = '213' AND
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
x48.nutrientid = '675' AND
x49.nutrientid = '851'
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

CREATE PROCEDURE FoodFact_Insert (
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
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


CREATE TRIGGER FoodFact_RowLevelAfterInsert_Trigger
AFTER INSERT ON FoodFact REFERENCING NEW ROW AS newrow
FOR EACH ROW
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
SET v_c = getFoodCoefficient(newrow.FoodId,newrow.NutrientId);
--
INSERT INTO FoodFactCoefficient VALUES (newrow.FoodId,newrow.NutrientId,v_c);
--
END;
/


CREATE PROCEDURE FoodFact_Update (
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
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
IN v_foodid LONGVARCHAR,
--
IN v_foodnom LONGVARCHAR,
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
call Food_Update(v_FoodId,v_foodnom);
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
DECLARE v_Name_Old LONGVARCHAR;
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
IN v_NutrientId LONGVARCHAR,
IN v_Model LONGVARCHAR
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
         MIXID,
         FOODID,
         NAME,
         Weight,
         CompleteProtein,
         IncompleteProtein,
         DigestibleCarbohydrate,
         Cost,
         Protein,
         Fat,
         CarbsByDiff,
         Energy,
         Sucrose,
         Fructose,
         Lactose,
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
         Fluoride,
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
         AlphaLinolenic
)
SELECT v_MixId_New,
       FOODID,
       NAME,
       Weight,
       CompleteProtein,
       IncompleteProtein,
       DigestibleCarbohydrate,
       Cost,
       Protein,
       Fat,
       CarbsByDiff,
       Energy,
       Sucrose,
       Fructose,
       Lactose,
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
       Fluoride,
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
       AlphaLinolenic
FROM MixResultDw
WHERE mixid = v_MixId_Old;
--
END;
/

CREATE PROCEDURE MixResultDW_Merge (
IN v_MixId INTEGER,
IN v_FoodId LONGVARCHAR
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_Name LONGVARCHAR;
DECLARE v_Weight DOUBLE;
DECLARE v_CompleteProtein DOUBLE;
DECLARE v_IncompleteProtein DOUBLE;
DECLARE v_DigestibleCarbs DOUBLE;
DECLARE v_Cost DOUBLE;
DECLARE v_Protein DOUBLE;
DECLARE v_Fat DOUBLE;
DECLARE v_CarbsByDiff DOUBLE;
DECLARE v_Energy DOUBLE;
DECLARE v_Sucrose DOUBLE;
DECLARE v_Fructose DOUBLE;
DECLARE v_Lactose DOUBLE;
DECLARE v_Alcohol DOUBLE;
DECLARE v_Water DOUBLE;
DECLARE v_Fiber DOUBLE;
DECLARE v_Calcium DOUBLE;
DECLARE v_Iron DOUBLE;
DECLARE v_Magnesium DOUBLE;
DECLARE v_Phosphorus DOUBLE;
DECLARE v_Potassium DOUBLE;
DECLARE v_Sodium DOUBLE;
DECLARE v_Zinc DOUBLE;
DECLARE v_Copper DOUBLE;
DECLARE v_Fluoride DOUBLE;
DECLARE v_Manganese DOUBLE;
DECLARE v_Selenium DOUBLE;
DECLARE v_VitaminA DOUBLE;
DECLARE v_VitaminE DOUBLE;
DECLARE v_VitaminD DOUBLE;
DECLARE v_VitaminC DOUBLE;
DECLARE v_Thiamin DOUBLE;
DECLARE v_Riboflavin DOUBLE;
DECLARE v_Niacin DOUBLE;
DECLARE v_Pantothenic DOUBLE;
DECLARE v_VitaminB6 DOUBLE;
DECLARE v_VitaminB12 DOUBLE;
DECLARE v_Choline DOUBLE;
DECLARE v_VitaminK DOUBLE;
DECLARE v_Folate DOUBLE;
DECLARE v_Cholesterol DOUBLE;
DECLARE v_Saturated DOUBLE;
DECLARE v_DHA DOUBLE;
DECLARE v_EPA DOUBLE;
DECLARE v_Monounsaturated DOUBLE;
DECLARE v_Polyunsaturated DOUBLE;
DECLARE v_Linoleic DOUBLE;
DECLARE v_AlphaLinolenic DOUBLE;
--
SET v_Name =  getFoodName(v_FoodId);

SELECT x2.c * a.x AS "Weight",
       x3.c * a.x AS "CompleteProtein",
       x4.c * a.x AS "IncompleteProtein",
       x5.c * a.x AS "DigestibleCarbs",
       x6.c * a.x AS "Cost",
       x7.c * a.x AS "Protein",
       x8.c * a.x AS "Fat",
       x9.c * a.x AS "CarbsByDiff",
       x10.c * a.x AS "Energy",
       x11.c * a.x AS "Sucrose",
       x12.c * a.x AS "Fructose",
       x13.c * a.x AS "Lactose",
       x14.c * a.x AS "Alcohol",
       x15.c * a.x AS "Water",
       x18.c * a.x AS "Fiber",
       x19.c * a.x AS "Calcium",
       x20.c * a.x AS "Iron",
       x21.c * a.x AS "Magnesium",
       x22.c * a.x AS "Phosphorus",
       x23.c * a.x AS "Potassium",
       x24.c * a.x AS "Sodium",
       x25.c * a.x AS "Zinc",
       x26.c * a.x AS "Copper",
       x27.c * a.x AS "Fluoride",
       x28.c * a.x AS "Manganese",
       x29.c * a.x AS "Selenium",
       x30.c * a.x AS "VitaminA",
       x31.c * a.x AS "VitaminE",
       x32.c * a.x AS "VitaminD",
       x35.c * a.x AS "VitaminC",
       x36.c * a.x AS "Thiamin",
       x37.c * a.x AS "Riboflavin",
       x38.c * a.x AS "Niacin",
       x39.c * a.x AS "Pantothenic",
       x40.c * a.x AS "VitaminB6",
       x41.c * a.x AS "VitaminB12",
       x16.c * a.x AS "Choline",
       x42.c * a.x AS "VitaminK",
       x43.c * a.x AS "Folate",
       x44.c * a.x AS "Cholesterol",
       x45.c * a.x AS "Saturated",
       x46.c * a.x AS "DHA",
       x47.c * a.x AS "EPA",
       x48.c * a.x AS "Monounsaturated",
       x49.c * a.x AS "Polyunsaturated",
       x50.c * a.x AS "Linoleic",
       x51.c * a.x AS "AlphaLinolenic"
INTO
                v_Weight,
                v_CompleteProtein,
                v_IncompleteProtein,
                v_DigestibleCarbs,
                v_Cost,
                v_Protein,
                v_Fat,
                v_CarbsByDiff,
                v_Energy,
                v_Sucrose,
                v_Fructose,
                v_Lactose,
                v_Alcohol,
                v_Water,
                v_Fiber,
                v_Calcium,
                v_Iron,
                v_Magnesium,
                v_Phosphorus,
                v_Potassium,
                v_Sodium,
                v_Zinc,
                v_Copper,
                v_Fluoride,
                v_Manganese,
                v_Selenium,
                v_VitaminA,
                v_VitaminE,
                v_VitaminD,
                v_VitaminC,
                v_Thiamin,
                v_Riboflavin,
                v_Niacin,
                v_Pantothenic,
                v_VitaminB6,
                v_VitaminB12,
                v_Choline,
                v_VitaminK,
                v_Folate,
                v_Cholesterol,
                v_Saturated,
                v_DHA,
                v_EPA,
                v_Monounsaturated,
                v_Polyunsaturated,
                v_Linoleic,
                v_AlphaLinolenic
FROM mixfood a,
     foodfactcoefficient x2,
     foodfactcoefficient x3,
     foodfactcoefficient x4,
     foodfactcoefficient x5,
     foodfactcoefficient x6,
     foodfactcoefficient x7,
     foodfactcoefficient x8,
     foodfactcoefficient x9,
     foodfactcoefficient x10,
     foodfactcoefficient x11,
     foodfactcoefficient x12,
     foodfactcoefficient x13,
     foodfactcoefficient x14,
     foodfactcoefficient x15,
     foodfactcoefficient x18,
     foodfactcoefficient x19,
     foodfactcoefficient x20,
     foodfactcoefficient x21,
     foodfactcoefficient x22,
     foodfactcoefficient x23,
     foodfactcoefficient x24,
     foodfactcoefficient x25,
     foodfactcoefficient x26,
     foodfactcoefficient x27,
     foodfactcoefficient x28,
     foodfactcoefficient x29,
     foodfactcoefficient x30,
     foodfactcoefficient x31,
     foodfactcoefficient x32,
     foodfactcoefficient x35,
     foodfactcoefficient x36,
     foodfactcoefficient x37,
     foodfactcoefficient x38,
     foodfactcoefficient x39,
     foodfactcoefficient x40,
     foodfactcoefficient x41,
     foodfactcoefficient x16,
     foodfactcoefficient x42,
     foodfactcoefficient x43,
     foodfactcoefficient x44,
     foodfactcoefficient x45,
     foodfactcoefficient x46,
     foodfactcoefficient x47,
     foodfactcoefficient x48,
     foodfactcoefficient x49,
     foodfactcoefficient x50,
     foodfactcoefficient x51
WHERE
(
a.foodid = x2.foodid AND
a.foodid = x3.foodid AND
a.foodid = x4.foodid AND
a.foodid = x5.foodid AND
a.foodid = x6.foodid AND
a.foodid = x7.foodid AND
a.foodid = x8.foodid AND
a.foodid = x9.foodid AND
a.foodid = x10.foodid AND
a.foodid = x11.foodid AND
a.foodid = x12.foodid AND
a.foodid = x13.foodid AND
a.foodid = x14.foodid AND
a.foodid = x15.foodid AND
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
a.foodid = x31.foodid AND
a.foodid = x32.foodid AND
a.foodid = x35.foodid AND
a.foodid = x36.foodid AND
a.foodid = x37.foodid AND
a.foodid = x38.foodid AND
a.foodid = x39.foodid AND
a.foodid = x40.foodid AND
a.foodid = x41.foodid AND
a.foodid = x16.foodid AND
a.foodid = x42.foodid AND
a.foodid = x43.foodid AND
a.foodid = x44.foodid AND
a.foodid = x45.foodid AND
a.foodid = x46.foodid AND
a.foodid = x47.foodid AND
a.foodid = x48.foodid AND
a.foodid = x49.foodid AND
a.foodid = x50.foodid AND
a.foodid = x51.foodid
)
AND
(
x2.nutrientid = '10000' AND
x3.nutrientid = '10001' AND
x4.nutrientid = '10002' AND
x5.nutrientid = '10003' AND
x6.nutrientid = '10005' AND
x7.nutrientid = '203' AND
x8.nutrientid = '204' AND
x9.nutrientid = '205' AND
x10.nutrientid = '208' AND
x11.nutrientid = '210' AND
x12.nutrientid = '212' AND
x13.nutrientid = '213' AND
x14.nutrientid = '221' AND
x15.nutrientid = '255' AND
x18.nutrientid = '291' AND
x19.nutrientid = '301' AND
x20.nutrientid = '303' AND
x21.nutrientid = '304' AND
x22.nutrientid = '305' AND
x23.nutrientid = '306' AND
x24.nutrientid = '307' AND
x25.nutrientid = '309' AND
x26.nutrientid = '312' AND
x27.nutrientid = '313' AND
x28.nutrientid = '315' AND
x29.nutrientid = '317' AND
x30.nutrientid = '320' AND
x31.nutrientid = '323' AND
x32.nutrientid = '328' AND
x35.nutrientid = '401' AND
x36.nutrientid = '404' AND
x37.nutrientid = '405' AND
x38.nutrientid = '406' AND
x39.nutrientid = '410' AND
x40.nutrientid = '415' AND
x41.nutrientid = '418' AND
x16.nutrientid = '421' AND
x42.nutrientid = '430' AND
x43.nutrientid = '435' AND
x44.nutrientid = '601' AND
x45.nutrientid = '606' AND
x46.nutrientid = '621' AND
x47.nutrientid = '629' AND
x48.nutrientid = '645' AND
x49.nutrientid = '646' AND
x50.nutrientid = '675' AND
x51.nutrientid = '851'
)
AND a.mixid = v_MixId
AND a.foodid = v_FoodId;
--
MERGE INTO MixResultDW USING ( VALUES (
v_MixId,
v_FoodId,
v_Name,
v_Weight,
v_CompleteProtein,
v_IncompleteProtein,
v_DigestibleCarbs,
v_Cost,
v_Protein,
v_Fat,
v_CarbsByDiff,
v_Energy,
v_Sucrose,
v_Fructose,
v_Lactose,
v_Alcohol,
v_Water,
v_Fiber,
v_Calcium,
v_Iron,
v_Magnesium,
v_Phosphorus,
v_Potassium,
v_Sodium,
v_Zinc,
v_Copper,
v_Fluoride,
v_Manganese,
v_Selenium,
v_VitaminA,
v_VitaminE,
v_VitaminD,
v_VitaminC,
v_Thiamin,
v_Riboflavin,
v_Niacin,
v_Pantothenic,
v_VitaminB6,
v_VitaminB12,
v_Choline,
v_VitaminK,
v_Folate,
v_Cholesterol,
v_Saturated,
v_DHA,
v_EPA,
v_Monounsaturated,
v_Polyunsaturated,
v_Linoleic,
v_AlphaLinolenic
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
Name = v_Name,
Weight = v_Weight,
CompleteProtein = v_CompleteProtein,
IncompleteProtein = v_IncompleteProtein,
DigestibleCarbohydrate = v_DigestibleCarbs,
Cost = v_Cost,
Protein = v_Protein,
Fat = v_Fat,
CarbsByDiff = v_CarbsByDiff,
Energy = v_Energy,
Sucrose = v_Sucrose,
Fructose = v_Fructose,
Lactose = v_Lactose,
Alcohol = v_Alcohol,
Water = v_Water,
Fiber = v_Fiber,
Calcium = v_Calcium,
Iron = v_Iron,
Magnesium = v_Magnesium,
Phosphorus = v_Phosphorus,
Potassium = v_Potassium,
Sodium = v_Sodium,
Zinc = v_Zinc,
Copper = v_Copper,
Fluoride = v_Fluoride,
Manganese = v_Manganese,
Selenium = v_Selenium,
VitaminA = v_VitaminA,
VitaminE = v_VitaminE,
VitaminD = v_VitaminD,
VitaminC = v_VitaminC,
Thiamin = v_Thiamin,
Riboflavin = v_Riboflavin,
Niacin = v_Niacin,
Pantothenic = v_Pantothenic,
VitaminB6 = v_VitaminB6,
VitaminB12 = v_VitaminB12,
Choline = v_Choline,
VitaminK = v_VitaminK,
Folate = v_Folate,
Cholesterol = v_Cholesterol,
Saturated = v_Saturated,
DHA = v_DHA,
EPA = v_EPA,
Monounsaturated = v_Monounsaturated,
Polyunsaturated = v_Polyunsaturated,
Linoleic = v_Linoleic,
AlphaLinolenic = v_AlphaLinolenic
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_Name,
v_Weight,
v_CompleteProtein,
v_IncompleteProtein,
v_DigestibleCarbs,
v_Cost,
v_Protein,
v_Fat,
v_CarbsByDiff,
v_Energy,
v_Sucrose,
v_Fructose,
v_Lactose,
v_Alcohol,
v_Water,
v_Fiber,
v_Calcium,
v_Iron,
v_Magnesium,
v_Phosphorus,
v_Potassium,
v_Sodium,
v_Zinc,
v_Copper,
v_Fluoride,
v_Manganese,
v_Selenium,
v_VitaminA,
v_VitaminE,
v_VitaminD,
v_VitaminC,
v_Thiamin,
v_Riboflavin,
v_Niacin,
v_Pantothenic,
v_VitaminB6,
v_VitaminB12,
v_Choline,
v_VitaminK,
v_Folate,
v_Cholesterol,
v_Saturated,
v_DHA,
v_EPA,
v_Monounsaturated,
v_Polyunsaturated,
v_Linoleic,
v_AlphaLinolenic;
--
END;
/

CREATE PROCEDURE MixResultDW_Select (
IN v_MixId INTEGER,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
       MIXID,
       FOODID,
       NAME,
       Weight,
       CompleteProtein,
       IncompleteProtein,
       DigestibleCarbohydrate,
       Cost,
       Protein,
       Fat,
       CarbsByDiff,
       Energy,
       Sucrose,
       Fructose,
       Lactose,
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
       Fluoride,
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
       AlphaLinolenic
FROM (
SELECT MIXID,
       FOODID,
       NAME,
       Round(Weight,v_Precision) as Weight,
       Round(CompleteProtein,v_Precision) as CompleteProtein,
       Round(IncompleteProtein,v_Precision) as IncompleteProtein,
       Round(DigestibleCarbohydrate,v_Precision) as DigestibleCarbohydrate,
       Round(Cost,v_Precision) as Cost,
       Round(Protein,v_Precision) as Protein,
       Round(Fat,v_Precision) as Fat,
       Round(CarbsByDiff,v_Precision) as CarbsByDiff,
       Round(Energy,v_Precision) as Energy,
       Round(Sucrose,v_Precision) as Sucrose,
       Round(Fructose,v_Precision) as Fructose,
       Round(Lactose,v_Precision) as Lactose,
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
       Round(AlphaLinolenic,v_Precision) as AlphaLinolenic
FROM PUBLIC.MIXRESULTDW
WHERE MIXID = v_MixId
UNION
SELECT MIXID,
       '99999',
       'Total',
       Round(Sum(Weight),v_Precision),
       Round(Sum(CompleteProtein),v_Precision),
       Round(Sum(IncompleteProtein),v_Precision),
       Round(Sum(DigestibleCarbohydrate),v_Precision),
       Round(Sum(Cost),v_Precision),
       Round(Sum(Protein),v_Precision),
       Round(Sum(Fat),v_Precision),
       Round(Sum(CarbsByDiff),v_Precision),
       Round(Sum(Energy),v_Precision),
       Round(Sum(Sucrose),v_Precision),
       Round(Sum(Fructose),v_Precision),
       Round(Sum(Lactose),v_Precision),
       Round(Sum(Alcohol),v_Precision),
       Round(Sum(Water),v_Precision),
       Round(Sum(Fiber),v_Precision),
       Round(Sum(Calcium),v_Precision),
       Round(Sum(Iron),v_Precision),
       Round(Sum(Magnesium),v_Precision),
       Round(Sum(Phosphorus),v_Precision),
       Round(Sum(Potassium),v_Precision),
       Round(Sum(Sodium),v_Precision),
       Round(Sum(Zinc),v_Precision),
       Round(Sum(Copper),v_Precision),
       Round(Sum(Fluoride),v_Precision),
       Round(Sum(Manganese),v_Precision),
       Round(Sum(Selenium),v_Precision),
       Round(Sum(VitaminA),v_Precision),
       Round(Sum(VitaminE),v_Precision),
       Round(Sum(VitaminD),v_Precision),
       Round(Sum(VitaminC),v_Precision),
       Round(Sum(Thiamin),v_Precision),
       Round(Sum(Riboflavin),v_Precision),
       Round(Sum(Niacin),v_Precision),
       Round(Sum(Pantothenic),v_Precision),
       Round(Sum(VitaminB6),v_Precision),
       Round(Sum(VitaminB12),v_Precision),
       Round(Sum(Choline),v_Precision),
       Round(Sum(VitaminK),v_Precision),
       Round(Sum(Folate),v_Precision),
       Round(Sum(Cholesterol),v_Precision),
       Round(Sum(Saturated),v_Precision),
       Round(Sum(DHA),v_Precision),
       Round(Sum(EPA),v_Precision),
       Round(Sum(Monounsaturated),v_Precision),
       Round(Sum(Polyunsaturated),v_Precision),
       Round(Sum(Linoleic),v_Precision),
       Round(Sum(AlphaLinolenic),v_Precision)
FROM PUBLIC.MIXRESULTDW
WHERE MIXID = v_MixId
GROUP BY MIXID
)
ORDER BY Energy, Weight;
--
OPEN result;
END;
/

CREATE TRIGGER MixFood_RowLevelAfterUpdate_Trigger AFTER UPDATE OF x ON MixFood REFERENCING NEW ROW AS row OLD as oldrow
--
FOR EACH ROW
--
BEGIN ATOMIC
--
CALL MixResultDW_Merge(row.mixid,row.foodid);
--
END;
/


CREATE PROCEDURE MixResultDW_Select_Pct (
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
SELECT ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END ,v_Precision) AS calories,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS fat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS carbs,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS protein,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS alcohol,
       --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,2) AS fq
FROM mixresultdw
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
SELECT Name INTO v_FoodName FROM Mix WHERE MixId = v_MixId;
--
CALL Food_Add_Details (
v_FoodId,
v_FoodName,
getMixResultSumValue(v_MixId,'10000'),
getMixResultSumValue(v_MixId,'10001'),
getMixResultSumValue(v_MixId,'10002'),
getMixResultSumValue(v_MixId,'10003'),
getMixResultSumValue(v_MixId,'10005'),
getMixResultSumValue(v_MixId,'203'),
getMixResultSumValue(v_MixId,'204'),
getMixResultSumValue(v_MixId,'205'),
getMixResultSumValue(v_MixId,'208'),
getMixResultSumValue(v_MixId,'210'),
getMixResultSumValue(v_MixId,'212'),
getMixResultSumValue(v_MixId,'213'),
getMixResultSumValue(v_MixId,'221'),
getMixResultSumValue(v_MixId,'255'),
getMixResultSumValue(v_MixId,'291'),
getMixResultSumValue(v_MixId,'301'),
getMixResultSumValue(v_MixId,'303'),
getMixResultSumValue(v_MixId,'304'),
getMixResultSumValue(v_MixId,'305'),
getMixResultSumValue(v_MixId,'306'),
getMixResultSumValue(v_MixId,'307'),
getMixResultSumValue(v_MixId,'309'),
getMixResultSumValue(v_MixId,'312'),
getMixResultSumValue(v_MixId,'313'),
getMixResultSumValue(v_MixId,'315'),
getMixResultSumValue(v_MixId,'317'),
getMixResultSumValue(v_MixId,'320'),
getMixResultSumValue(v_MixId,'323'),
getMixResultSumValue(v_MixId,'328'),
getMixResultSumValue(v_MixId,'401'),
getMixResultSumValue(v_MixId,'404'),
getMixResultSumValue(v_MixId,'405'),
getMixResultSumValue(v_MixId,'406'),
getMixResultSumValue(v_MixId,'410'),
getMixResultSumValue(v_MixId,'415'),
getMixResultSumValue(v_MixId,'418'),
getMixResultSumValue(v_MixId,'421'),
getMixResultSumValue(v_MixId,'430'),
getMixResultSumValue(v_MixId,'435'),
getMixResultSumValue(v_MixId,'601'),
getMixResultSumValue(v_MixId,'606'),
getMixResultSumValue(v_MixId,'621'),
getMixResultSumValue(v_MixId,'629'),
getMixResultSumValue(v_MixId,'645'),
getMixResultSumValue(v_MixId,'646'),
getMixResultSumValue(v_MixId,'675'),
getMixResultSumValue(v_MixId,'851')
);
CALL CategoryLink_Insert(v_FoodId,'5000');
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
SELECT 'Food Quotient' as nutrient,a.fq as mix1,b.fq as mix2,a.fq-b.fq as diff
FROM
(SELECT --Food quotient (FQ) calculated using the equation of Black et al
         --FQ for alcohol is 0.667
        ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) < 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,5) AS fq
 FROM mixresultdw
WHERE mixid = v_MixId_1) as a,
(SELECT --Food quotient (FQ) calculated using the equation of Black et al
         --FQ for alcohol is 0.667
        ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) < 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,5) AS fq
 FROM mixresultdw
WHERE mixid = v_MixId_2) as b;
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
            --18:2 n-6 c,c (Linoleic) (g)
            nutrientid = '675' OR
            --18:3 n-3 c,c,c (Alpha-Linolenic) (g)
            nutrientid = '851' OR
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
call FoodFact_Insert (v_FoodId,nutrientid,0);
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
call FoodFact_Insert (foodid,nutrientid,0);
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
AND c.FoodId = v_FoodId;
OPEN result;
END;
/

CREATE PROCEDURE FoodFactCoefficient_Update (
--
IN v_FoodId LONGVARCHAR,
--
IN v_NutrientId LONGVARCHAR
--
)
MODIFIES SQL DATA BEGIN ATOMIC
--
UPDATE
FoodFactCoefficient
SET
c = getFoodCoefficient(v_FoodId,v_NutrientId)
WHERE
FoodId = v_FoodId
AND
NutrientId = v_NutrientId;
--
END;
/

CREATE TRIGGER FoodFact_RowLevelAfterUpdate_Trigger_02 AFTER UPDATE OF q ON FoodFact REFERENCING NEW ROW AS newrow OLD AS oldrow
--
FOR EACH ROW BEGIN ATOMIC
--
IF newrow.NutrientId = '10000' THEN
--
FOR SELECT nutrientid FROM nutrient DO
--
call FoodFactCoefficient_Update(newrow.FoodId,nutrientid);
--
END FOR;
--
ELSE
--
call FoodFactCoefficient_Update(newrow.FoodId,newrow.NutrientId);
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
call FoodFact_Insert (v_FoodId,nutrientid,0);
--
END FOR;
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
SET v_CategoryId = getCategoryId(v_FoodId);
--
call Food_Insert(v_FoodIdNew,v_FoodNom||'_duplicate');
call CategoryLink_Insert(v_FoodIdNew,v_CategoryId);
call DuplicateFoodFact(v_FoodId,v_FoodIdNew);
--
END;
/

