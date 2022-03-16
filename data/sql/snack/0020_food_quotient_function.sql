CREATE FUNCTION getFoodQuotient(
IN v_MixId LONGVARCHAR
) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE fq DOUBLE;
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) /SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93)*1.00 +SUM(fat*9) /SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93)*0.71 +SUM(protein*4) /SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93)*0.81 +SUM(alcohol*6.93) /SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93)*0.667 END into fq
FROM mixresultdn
WHERE mixid = v_MixId;
RETURN fq;
END;
/
