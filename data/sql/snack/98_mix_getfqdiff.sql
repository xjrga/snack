CREATE PROCEDURE Mix_getFQDiff (
--
IN v_MixId_1 INTEGER,
--
IN v_MixId_2 INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Food Quotient' as nutrient,a.fq as mix1,b.fq as mix2,a.fq-b.fq as diff
FROM
(SELECT --Food quotient (FQ) calculated using the equation of Black et al
         --FQ for alcohol is 0.667
        ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) < 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,5) AS fq
 FROM mixresultdw
WHERE mixid = v_MixId_1) as a,
(SELECT --Food quotient (FQ) calculated using the equation of Black et al
         --FQ for alcohol is 0.667
        ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) < 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,5) AS fq
 FROM mixresultdw
WHERE mixid = v_MixId_2) as b;
--
OPEN result;
--
END;
/