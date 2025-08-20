CREATE PROCEDURE foodfact_calculated_quantities_update (
IN v_foodid LONGVARCHAR
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE v_carbsbydiff DECIMAL(25,18)
;
DECLARE v_fiber DECIMAL(25,18)
;
DECLARE v_digestible_carbohydrate DECIMAL(25,18)
;
DECLARE v_energy_alcohol DECIMAL(25,18)
;
DECLARE v_energy_carbohydrate DECIMAL(25,18)
;
DECLARE v_energy_fat DECIMAL(25,18)
;
DECLARE v_energy_protein DECIMAL(25,18)
;
DECLARE v_gi DECIMAL(25,18)
;
DECLARE v_lauric DECIMAL(25,18)
;
DECLARE v_myristic DECIMAL(25,18)
;
DECLARE v_palmitic DECIMAL(25,18)
;
DECLARE v_hcsfa DECIMAL(25,18)
;
DECLARE v_dha DECIMAL(25,18)
;
DECLARE v_epa DECIMAL(25,18)
;
DECLARE v_lcn3pufa DECIMAL(25,18)
;
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
--hcsfa
SELECT q INTO v_lauric FROM foodfact WHERE nutrientid = '611' AND foodid = v_foodid;
SELECT q INTO v_myristic FROM foodfact  WHERE nutrientid = '612' AND foodid = v_foodid;
SELECT q INTO v_palmitic FROM foodfact  WHERE nutrientid = '613' AND foodid = v_foodid;
SET v_hcsfa = v_lauric + v_myristic + v_palmitic;
CALL foodfact_merge (v_foodid,'10015',v_hcsfa);
--
--lcn3pufa
SELECT q INTO v_dha FROM foodfact WHERE nutrientid = '621' AND foodid = v_foodid;
SELECT q INTO v_epa FROM foodfact  WHERE nutrientid = '629' AND foodid = v_foodid;
SET v_lcn3pufa = v_dha + v_epa;
CALL foodfact_merge (v_foodid,'10016',v_lcn3pufa);
--
--
END;
/