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
