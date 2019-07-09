CREATE TABLE FoodFactCoefficient
(
FoodId VARCHAR(8000),
NutrientId VARCHAR(8000),
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
FoodCategoryId VARCHAR(8000),
CONSTRAINT Food_primaryKey PRIMARY KEY (FoodId)
);
/

CREATE TABLE FoodFact
(
FoodId VARCHAR(8000),
NutrientId VARCHAR(8000),
c DOUBLE,
CONSTRAINT FoodFact_primaryKey PRIMARY KEY (FoodId, NutrientId)
);
/

CREATE TABLE Relationship
(
RelationshipId INTEGER,
Name VARCHAR(8000),
CONSTRAINT Relationship_primaryKey PRIMARY KEY (RelationshipId)
);
/

CREATE TABLE Mix
(
MixId INTEGER,
Name VARCHAR(8000),
Model VARCHAR(8000),
NutrientId VARCHAR(8000),
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

CREATE TABLE FoodRatio
(
MixId INTEGER,
Food_Id_1 VARCHAR(8000),
Food_Id_2 VARCHAR(8000),
Relationship INTEGER,
A INTEGER,
B INTEGER,
CONSTRAINT FoodRatio_primaryKey PRIMARY KEY (MixId, Food_Id_1, Food_Id_2, Relationship)
);
/

CREATE TABLE FoodConstraint
(
MixId INTEGER,
FoodId VARCHAR(8000),
RelationshipId INTEGER,
b DOUBLE,
CONSTRAINT FoodConstraint_primaryKey PRIMARY KEY (MixId, FoodId, RelationshipId)
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

ALTER TABLE Food ADD CONSTRAINT R0_FoodCategory_Food FOREIGN KEY ( FoodCategoryId ) REFERENCES FoodCategory ( FoodCategoryId ) ON DELETE SET NULL;
/
ALTER TABLE FoodFact ADD CONSTRAINT R1_Food_FoodFact FOREIGN KEY ( FoodId ) REFERENCES Food ( FoodId ) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R2_Food_MixFood FOREIGN KEY ( FoodId ) REFERENCES Food ( FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodFactCoefficient ADD CONSTRAINT R3_FoodFact_FoodFactCoefficient FOREIGN KEY ( FoodId,NutrientId ) REFERENCES FoodFact ( FoodId,NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R4_Relationship_FoodNutrientRatio FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R5_Relationship_NutrientRatio FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R6_Relationship_NutrientConstraint FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE FoodRatio ADD CONSTRAINT R7_Relationship_FoodRatio FOREIGN KEY ( Relationship ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE FoodConstraint ADD CONSTRAINT R8_Relationship_FoodConstraint FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R9_Relationship_FoodNutrientConstraint FOREIGN KEY ( RelationshipId ) REFERENCES Relationship ( RelationshipId ) ON DELETE CASCADE;
/
ALTER TABLE MixFood ADD CONSTRAINT R10_Mix_MixFood FOREIGN KEY ( MixId ) REFERENCES Mix ( MixId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R11_Mix_NutrientRatio FOREIGN KEY ( MixId ) REFERENCES Mix ( MixId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R12_Mix_NutrientConstraint FOREIGN KEY ( MixId ) REFERENCES Mix ( MixId ) ON DELETE CASCADE;
/
ALTER TABLE FoodFact ADD CONSTRAINT R13_Nutrient_FoodFact FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE Mix ADD CONSTRAINT R14_Nutrient_Mix FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE SET NULL;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R15_Nutrient_FoodNutrientRatio FOREIGN KEY ( Nutrient_Id_1 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R16_Nutrient_FoodNutrientRatio FOREIGN KEY ( Nutrient_Id_2 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R17_Nutrient_NutrientRatio FOREIGN KEY ( Nutrient_Id_1 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientRatio ADD CONSTRAINT R18_Nutrient_NutrientRatio FOREIGN KEY ( Nutrient_Id_2 ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE NutrientConstraint ADD CONSTRAINT R19_Nutrient_NutrientConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R20_Nutrient_FoodNutrientConstraint FOREIGN KEY ( NutrientId ) REFERENCES Nutrient ( NutrientId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R21_MixFood_FoodNutrientRatio FOREIGN KEY ( MixId,Food_Id_1 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientRatio ADD CONSTRAINT R22_MixFood_FoodNutrientRatio FOREIGN KEY ( MixId,Food_Id_2 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodRatio ADD CONSTRAINT R23_MixFood_FoodRatio FOREIGN KEY ( MixId,Food_Id_1 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodRatio ADD CONSTRAINT R24_MixFood_FoodRatio FOREIGN KEY ( MixId,Food_Id_2 ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodConstraint ADD CONSTRAINT R25_MixFood_FoodConstraint FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
ALTER TABLE FoodNutrientConstraint ADD CONSTRAINT R26_MixFood_FoodNutrientConstraint FOREIGN KEY ( MixId,FoodId ) REFERENCES MixFood ( MixId,FoodId ) ON DELETE CASCADE;
/
