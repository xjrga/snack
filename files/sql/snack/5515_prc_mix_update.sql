CREATE PROCEDURE Mix_Update (
--
IN v_MixId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_Model LONGVARCHAR,
IN v_Deficiency_Ca DECIMAL(28,15),
IN v_Deficiency_Mg DECIMAL(28,15),
IN v_Deficiency_K DECIMAL(28,15),
IN v_Deficiency_Na DECIMAL(28,15),
IN v_Deficiency_VitA DECIMAL(28,15),
IN v_Deficiency_VitE DECIMAL(28,15),
IN v_Deficiency_VitD DECIMAL(28,15),
IN v_Deficiency_VitC DECIMAL(28,15),
IN v_Deficiency_Choline DECIMAL(28,15),
IN v_Excess_Ca DECIMAL(28,15),
IN v_Excess_Mg DECIMAL(28,15),
IN v_Excess_K DECIMAL(28,15),
IN v_Excess_Na DECIMAL(28,15),
IN v_Excess_VitA DECIMAL(28,15),
IN v_Excess_VitE DECIMAL(28,15),
IN v_Excess_VitD DECIMAL(28,15),
IN v_Excess_VitC DECIMAL(28,15),
IN v_Excess_Choline DECIMAL(28,15),
IN v_Avg_Deficiency DECIMAL(28,15),
IN v_Avg_Excess DECIMAL(28,15),
IN v_Cost DECIMAL(28,15)
--IN v_TniScore DECIMAL(28,15)
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
UPDATE
Mix
SET
LifeStageId = v_LifeStageId,
Model = v_Model,
Deficiency_Ca = v_Deficiency_Ca,
Deficiency_Mg = v_Deficiency_Mg,
Deficiency_K = v_Deficiency_K,
Deficiency_Na = v_Deficiency_Na,
Deficiency_VitA = v_Deficiency_VitA,
Deficiency_VitE = v_Deficiency_VitE,
Deficiency_VitD = v_Deficiency_VitD,
Deficiency_VitC = v_Deficiency_VitC,
Deficiency_Choline = v_Deficiency_Choline,
Excess_Ca = v_Excess_Ca,
Excess_Mg = v_Excess_Mg,
Excess_K = v_Excess_K,
Excess_Na = v_Excess_Na,
Excess_VitA = v_Excess_VitA,
Excess_VitE = v_Excess_VitE,
Excess_VitD = v_Excess_VitD,
Excess_VitC = v_Excess_VitC,
Excess_Choline = v_Excess_Choline,
Avg_Deficiency = v_Avg_Deficiency,
Avg_Excess = v_Avg_Excess,
Cost = v_Cost
--TniScore = v_TniScore
WHERE
MixId = v_MixId;
END;
--
/