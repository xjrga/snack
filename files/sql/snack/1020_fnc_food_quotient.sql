CREATE FUNCTION getFoodQuotient(
IN v_MixId LONGVARCHAR
) RETURNS DECIMAL(10,5)
READS SQL DATA BEGIN ATOMIC
DECLARE fq DECIMAL(10,5);
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       CASE WHEN SUM(energy_digestible) <= 0 OR SUM(energy_digestible) IS NULL THEN 0 ELSE SUM(energy_carbohydrate) /SUM(energy_digestible)*1.00 +SUM(energy_fat) /SUM(energy_digestible)*0.71 +SUM(energy_protein) /SUM(energy_digestible)*0.81 +SUM(energy_alcohol) /SUM(energy_digestible)*0.667 END into fq
FROM DnMixResult
WHERE mix_id = v_MixId;
RETURN fq;
END;
/
