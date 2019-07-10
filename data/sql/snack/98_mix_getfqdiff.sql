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
       ROUND(
       SUM(carbsdigestible*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*1.00 + 
       SUM(fat*9) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.71 + 
       SUM(protein*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.81 +
       SUM(alcohol*6.93) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.667
       ,2) AS fq
FROM mixresultdw
WHERE mixid = v_MixId_1) as a,
(SELECT --Food quotient (FQ) calculated using the equation of Black et al
        --FQ for alcohol is 0.667
       ROUND(
       SUM(carbsdigestible*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*1.00 + 
       SUM(fat*9) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.71 + 
       SUM(protein*4) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.81 +
       SUM(alcohol*6.93) / SUM(fat*9 + carbsdigestible*4 + protein*4 + alcohol*6.93)*0.667
       ,2) AS fq
FROM mixresultdw
WHERE mixid = v_MixId_2) as b;
--
OPEN result;
--
END;
/