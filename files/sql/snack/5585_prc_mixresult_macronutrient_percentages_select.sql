CREATE PROCEDURE MixResult_Select_Pct (
--
IN v_MixId LONGVARCHAR
--
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_digestible)) AS calories,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_fat) / SUM(energy_digestible)*100) AS fatpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_carbohydrate) / SUM(energy_digestible)*100) AS carbpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_protein) / SUM(energy_digestible)*100) AS proteinpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_alcohol) / SUM(energy_digestible)*100) AS alcoholpct,
       getFoodQuotient (v_MixId) AS fq,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_saturated*9) / SUM(energy_digestible)*100) AS satfatpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_monounsaturated*9) / SUM(energy_digestible)*100) AS monoufatpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_polyunsaturated*9) / SUM(energy_digestible)*100) AS polyufatpct,
       get_essential_fat_ratio(v_MixId) AS essentialfatratio,
       get_electrolyte_ratio(v_MixId) AS electrolyteratio,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_linoleic*9) / SUM(energy_digestible)*100) AS linoleicacidpct,
       CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(fats_linolenic*9) / SUM(energy_digestible)*100) AS alphalinolenicacidpct,
       get_polyufat_ratio(v_MixId) AS psratio,
       get_monoufat_ratio(v_MixId) AS msratio
FROM DnMixResult
WHERE mix_id = v_MixId;
--
OPEN result;
--
END;
/
