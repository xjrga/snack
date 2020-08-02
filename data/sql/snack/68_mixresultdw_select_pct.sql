CREATE PROCEDURE MixResultDW_Select_Pct (
--
IN v_MixId INTEGER,
IN v_Precision INTEGER
--
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END ,v_Precision) AS calories,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS fat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS carbs,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS protein,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS alcohol,
       --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,2) AS fq
FROM mixresultdw
WHERE mixid = v_MixId;
--
OPEN result;
--
END;
/
