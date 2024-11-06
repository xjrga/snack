CREATE FUNCTION getFoodQuotient(
IN v_MixId LONGVARCHAR
) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE fq DOUBLE;
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       CASE WHEN SUM(energydigestible) <= 0 OR SUM(energydigestible) IS NULL THEN 0 ELSE SUM(energycarbohydrate) /SUM(energydigestible)*1.00 +SUM(energyfat) /SUM(energydigestible)*0.71 +SUM(energyprotein) /SUM(energydigestible)*0.81 +SUM(energyalcohol) /SUM(energydigestible)*0.667 END into fq
FROM mixresultdn
WHERE mixid = v_MixId;
RETURN fq;
END;
/
