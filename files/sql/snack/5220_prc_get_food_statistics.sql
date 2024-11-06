CREATE PROCEDURE get_food_statistics (
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
--eFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10013') / get_foodfact (v_foodid,'10009'))*100) AS efatpct,
--eCarbsPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10011') / get_foodfact (v_foodid,'10009'))*100) AS ecarbspct,
--eProteinPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10012') / get_foodfact (v_foodid,'10009'))*100) AS eproteinpct,
--eAlcoholPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'10014') / get_foodfact (v_foodid,'10009'))*100) AS ealcoholpct,
--eSaturatedFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'606')*9 / get_foodfact (v_foodid,'10009'))*100) AS esfapct,
--ePolyunsaturatedFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'646')*9 / get_foodfact (v_foodid,'10009'))*100) AS epufapct,
--eMonounsaturatedFatPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'645')*9 / get_foodfact (v_foodid,'10009'))*100) AS emufapct,
--eLinoleicAcidPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'618')*9 / get_foodfact (v_foodid,'10009'))*100) AS elapct,
--eAlphaLinolenicAcidPct
CASEWHEN(get_foodfact (v_foodid,'10009') <= 0,0,(get_foodfact (v_foodid,'619')*9 / get_foodfact (v_foodid,'10009'))*100) AS ealapct,
--pufa/sfa
CASEWHEN(get_foodfact (v_foodid,'606') <= 0,0,get_foodfact (v_foodid,'646') / get_foodfact (v_foodid,'606')) AS pufa_sfa,
--mufa/sfa
CASEWHEN(get_foodfact (v_foodid,'606') <= 0,0,get_foodfact (v_foodid,'645') / get_foodfact (v_foodid,'606')) AS mufa_sfa,
--la/ala
CASEWHEN(get_foodfact (v_foodid,'619') <= 0,0,get_foodfact (v_foodid,'618') / get_foodfact (v_foodid,'619')) AS la_ala,
--k/na
CASEWHEN(get_foodfact (v_foodid,'307') <= 0,0,get_foodfact (v_foodid,'306') / get_foodfact (v_foodid,'307')) AS k_na,
--fq
get_food_fq(v_foodid) AS fq
--
FROM (VALUES (0));
--
OPEN result;
--
END;
/
