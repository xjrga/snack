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
DECLARE v_MixCost LONGVARCHAR;
DECLARE v_MixDeficiency LONGVARCHAR;
DECLARE v_MixExcess LONGVARCHAR;
DECLARE newid2 LONGVARCHAR;
--
SELECT Name,
       LifeStageId,
       Model,
       MixCost,
       MixDeficiency,
       MixExcess
INTO
       v_Name_Old,
       v_LifeStageId,
       v_Model,
       v_MixCost,
       v_MixDeficiency,
       v_MixExcess
       
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
MixCost,
MixDeficiency,
MixExcess
) VALUES (
newid2,
v_Name_Old||'_duplicate',
v_LifeStageId,
v_Model,
v_MixCost,
v_MixDeficiency,
v_MixExcess 
);
--
SET newid = newid2;
--
END;
/