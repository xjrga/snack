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
DECLARE v_LifeStageId INTEGER;
DECLARE v_Model LONGVARCHAR;
DECLARE v_Deficiency_Ca DECIMAL(28,15);
DECLARE v_Deficiency_Mg DECIMAL(28,15);
DECLARE v_Deficiency_K DECIMAL(28,15);
DECLARE v_Deficiency_Na DECIMAL(28,15);
DECLARE v_Deficiency_vitA DECIMAL(28,15);
DECLARE v_Deficiency_vitE DECIMAL(28,15);
DECLARE v_Deficiency_vitD DECIMAL(28,15);
DECLARE v_Deficiency_vitC DECIMAL(28,15);
DECLARE v_Deficiency_Choline DECIMAL(28,15);
DECLARE v_Excess_Ca DECIMAL(28,15);
DECLARE v_Excess_Mg DECIMAL(28,15);
DECLARE v_Excess_K DECIMAL(28,15);
DECLARE v_Excess_Na DECIMAL(28,15);
DECLARE v_Excess_vitA DECIMAL(28,15);
DECLARE v_Excess_vitE DECIMAL(28,15);
DECLARE v_Excess_vitD DECIMAL(28,15);
DECLARE v_Excess_vitC DECIMAL(28,15);
DECLARE v_Excess_Choline DECIMAL(28,15);
DECLARE v_Avg_Deficiency DECIMAL(28,15);
DECLARE v_Avg_Excess DECIMAL(28,15);
DECLARE v_Cost DECIMAL(28,15);
DECLARE v_TniScore DECIMAL(28,15);
DECLARE newid2 LONGVARCHAR;
--
SELECT Name,
       LifeStageId,
       Model,
       Deficiency_Ca,
       Deficiency_Mg,
       Deficiency_K,
       Deficiency_Na,
       Deficiency_VitA,
       Deficiency_VitE,
       Deficiency_VitD,
       Deficiency_VitC,
       Deficiency_Choline,
       Excess_Ca,
       Excess_Mg,
       Excess_K,
       Excess_Na,
       Excess_VitA,
       Excess_VitE,
       Excess_VitD,
       Excess_VitC,
       Excess_Choline,
       Avg_Deficiency,
       Avg_Excess,
       Cost,
       TniScore
INTO
       v_Name_Old,
       v_LifeStageId,
       v_Model,
       v_Deficiency_Ca,
       v_Deficiency_Mg,
       v_Deficiency_K,
       v_Deficiency_Na,
       v_Deficiency_VitA,
       v_Deficiency_VitE,
       v_Deficiency_VitD,
       v_Deficiency_VitC,
       v_Deficiency_Choline,
       v_Excess_Ca,
       v_Excess_Mg,
       v_Excess_K,
       v_Excess_Na,
       v_Excess_VitA,
       v_Excess_VitE,
       v_Excess_VitD,
       v_Excess_VitC,
       v_Excess_Choline,
       v_Avg_Deficiency,
       v_Avg_Excess,
       v_Cost,
       v_TniScore
FROM Mix
WHERE MixId = v_MixId_Old;
--
SELECT generateId() INTO newid2 FROM (VALUES(0));
--
INSERT INTO Mix (
MixId,
Name,
LifeStageId,
Model,
Deficiency_Ca,
Deficiency_Mg,
Deficiency_K,
Deficiency_Na,
Deficiency_VitA,
Deficiency_VitE,
Deficiency_VitD,
Deficiency_VitC,
Deficiency_Choline,
Excess_Ca,
Excess_Mg,
Excess_K,
Excess_Na,
Excess_VitA,
Excess_VitE,
Excess_VitD,
Excess_VitC,
Excess_Choline,
Avg_Deficiency,
Avg_Excess,
Cost,
TniScore
) VALUES (
newid2,
v_Name_Old||'_copy',
v_LifeStageId,
v_Model,
v_Deficiency_Ca,
v_Deficiency_Mg,
v_Deficiency_K,
v_Deficiency_Na,
v_Deficiency_VitA,
v_Deficiency_VitE,
v_Deficiency_VitD,
v_Deficiency_VitC,
v_Deficiency_Choline,
v_Excess_Ca,
v_Excess_Mg,
v_Excess_K,
v_Excess_Na,
v_Excess_VitA,
v_Excess_VitE,
v_Excess_VitD,
v_Excess_VitC,
v_Excess_Choline,
v_Avg_Deficiency,
v_Avg_Excess,
v_Cost,
v_TniScore
);
--
SET newid = newid2;
--
END;
/