CREATE FUNCTION getFoodQuotient(
IN v_MixId LONGVARCHAR
) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE fq DOUBLE;
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,5)  into fq
FROM (SELECT mixid,
             foodid,
             fat
      FROM mixresultdn
      WHERE mixid = v_MixId) a,
     (SELECT mixid,
             foodid,
             digestiblecarbohydrate
      FROM mixresultdn
      WHERE mixid = v_MixId) b,
      (SELECT mixid,
             foodid,
             protein
      FROM mixresultdn
      WHERE mixid = v_MixId) c,
      (SELECT mixid,
             foodid,
             alcohol
      FROM mixresultdn
      WHERE mixid = v_MixId) d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND   a.foodid = c.foodid
AND   a.foodid = d.foodid;
RETURN fq;
END;
/
