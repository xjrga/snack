CREATE PROCEDURE MixResult_Select_Pct (
--
IN v_MixId LONGVARCHAR,
IN v_Precision INTEGER
--
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energydigestible)),v_Precision) AS calories,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energyfat) / SUM(energydigestible)*100),v_Precision) AS fatpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energycarbohydrate) / SUM(energydigestible)*100),v_Precision) AS carbpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energyprotein) / SUM(energydigestible)*100),v_Precision) AS proteinpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(energyalcohol) / SUM(energydigestible)*100),v_Precision) AS alcoholpct,
       ROUND(getFoodQuotient (v_MixId),3) AS fq,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(sfa*9) / SUM(energydigestible)*100),v_Precision) AS satfatpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(mufa*9) / SUM(energydigestible)*100),v_Precision) AS monoufatpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(pufa*9) / SUM(energydigestible)*100),v_Precision) AS polyufatpct,
       ROUND(get_essential_fat_ratio(v_MixId),v_Precision) AS essentialfatratio,
       ROUND(get_electrolyte_ratio(v_MixId),v_Precision) AS electrolyteratio,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(linoleicacid*9) / SUM(energydigestible)*100),v_Precision) AS linoleicacidpct,
       ROUND(CASEWHEN (SUM(energydigestible) <= 0,0,SUM(alphalinolenicacid*9) / SUM(energydigestible)*100),v_Precision) AS alphalinolenicacidpct,
       ROUND(get_polyufat_ratio(v_MixId),v_Precision) AS psratio,
       ROUND(get_monoufat_ratio(v_MixId),v_Precision) AS msratio
FROM mixresultdn
WHERE mixid = v_MixId;
--
OPEN result;
--
END;
/
