CREATE PROCEDURE foodfact_calculated_quantities_update (
IN v_foodid LONGVARCHAR
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE v_carbsbydiff DECIMAL(25,18);
DECLARE v_fiber DECIMAL(25,18);
DECLARE v_digestible_carbohydrate DECIMAL(25,18);
DECLARE v_energy_alcohol DECIMAL(25,18);
DECLARE v_energy_carbohydrate DECIMAL(25,18);
DECLARE v_energy_fat DECIMAL(25,18);
DECLARE v_energy_protein DECIMAL(25,18);
DECLARE v_gi DECIMAL(25,18);
DECLARE v_lauric DECIMAL(25,18);
DECLARE v_myristic DECIMAL(25,18);
DECLARE v_palmitic DECIMAL(25,18);
DECLARE v_hcsfa DECIMAL(25,18);
DECLARE v_dha DECIMAL(25,18);
DECLARE v_epa DECIMAL(25,18);
DECLARE v_lcn3pufa DECIMAL(25,18);
DECLARE v_energy_linoleic DECIMAL(25,18);
DECLARE v_energy_linolenic DECIMAL(25,18);
DECLARE v_energy_sfa DECIMAL(25,18);
DECLARE v_energy_mufa DECIMAL(25,18);
DECLARE v_energy_pufa DECIMAL(25,18);
--
--digestible_carbohydrate
SELECT q INTO v_carbsbydiff FROM foodfact WHERE nutrientid = '205' AND foodid = v_foodid;
SELECT q INTO v_fiber FROM foodfact WHERE nutrientid = '291' AND foodid = v_foodid;
SET v_digestible_carbohydrate = v_carbsbydiff - v_fiber;
CALL foodfact_merge (v_foodid,'10003',v_digestible_carbohydrate);
--
-- energy_alcohol
SELECT q * 6.93 INTO v_energy_alcohol FROM foodfact WHERE nutrientid = '221' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10014',v_energy_alcohol);
--
-- energy_carbohydrate
SELECT q * 4 INTO v_energy_carbohydrate FROM foodfact WHERE nutrientid = '10003' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10011',v_energy_carbohydrate);
--
-- energy_fat
SELECT q * 9 INTO v_energy_fat FROM foodfact WHERE nutrientid = '204' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10013',v_energy_fat);
--
-- energy_protein
SELECT q * 4.7 INTO v_energy_protein FROM foodfact WHERE nutrientid = '203' AND foodid = v_foodid;
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
SELECT q INTO v_myristic FROM foodfact WHERE nutrientid = '612' AND foodid = v_foodid;
SELECT q INTO v_palmitic FROM foodfact WHERE nutrientid = '613' AND foodid = v_foodid;
SET v_hcsfa = v_lauric + v_myristic + v_palmitic;
CALL foodfact_merge (v_foodid,'10015',v_hcsfa);
--
--lcn3pufa
SELECT q INTO v_dha FROM foodfact WHERE nutrientid = '621' AND foodid = v_foodid;
SELECT q INTO v_epa FROM foodfact WHERE nutrientid = '629' AND foodid = v_foodid;
SET v_lcn3pufa = v_dha + v_epa;
CALL foodfact_merge (v_foodid,'10016',v_lcn3pufa);
--
-- energy_linoleic
SELECT q * 9 INTO v_energy_linoleic FROM foodfact WHERE nutrientid = '618' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10027',v_energy_linoleic);
--
-- energy_linolenic
SELECT q * 9 INTO v_energy_linolenic FROM foodfact WHERE nutrientid = '619' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10028',v_energy_linolenic);
--
-- energy_sfa
SELECT q * 9 INTO v_energy_sfa FROM foodfact WHERE nutrientid = '606' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10029',v_energy_sfa);
--
-- energy_mufa
SELECT q * 9 INTO v_energy_mufa FROM foodfact WHERE nutrientid = '645' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10030',v_energy_mufa);
--
-- energy_pufa
SELECT q * 9 INTO v_energy_pufa FROM foodfact WHERE nutrientid = '646' AND foodid = v_foodid;
CALL foodfact_merge (v_foodid,'10031',v_energy_pufa);
--
-- energy_protein_and_carbohydrate
CALL foodfact_merge (v_foodid,'10032',v_energy_protein+v_energy_carbohydrate);
--
-- energy-dha
CALL foodfact_merge (v_foodid,'10033',v_dha * 9);
--
-- energy-epa
CALL foodfact_merge (v_foodid,'10034',v_epa * 9);
--
-- energy-long_chain_n3_polyunsaturated
CALL foodfact_merge (v_foodid,'10035',v_lcn3pufa * 9);
--
-- energy-high_cholesterol_saturated
--
CALL foodfact_merge (v_foodid,'10036',v_hcsfa * 9);
--
END;
/