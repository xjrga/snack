CREATE TRIGGER Mix_rlbu_trigger
BEFORE UPDATE ON Mix
REFERENCING NEW AS new
FOR EACH ROW WHEN (new.cost >= 0)
--
BEGIN ATOMIC
--
SET new.tniscore = calculateTniScore(
new.lifestageid,
new.deficiency_Ca,
new.deficiency_Mg,
new.deficiency_K,
new.deficiency_VitA,
new.deficiency_VitE,
new.deficiency_VitD,
new.deficiency_VitC,
new.deficiency_Choline
);
--
END;
/
