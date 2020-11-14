CREATE FUNCTION getFoodQuotient(
IN v_MixId INTEGER
) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE fq DOUBLE;
SELECT --Food quotient (FQ) calculated using the equation of Black et al
       --FQ for alcohol is 0.667
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 1.00 + SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.71 + SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.81 + SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) * 0.667 END,5) INTO fq
FROM (SELECT mixid,
             foodid,
             q AS fat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '204') a,
     (SELECT mixid,
             foodid,
             q AS digestiblecarbohydrate
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
      (SELECT mixid,
             foodid,
             q AS protein
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '203') c,
      (SELECT mixid,
             foodid,
             q AS alcohol
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '221') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND   a.foodid = c.foodid
AND   a.foodid = d.foodid;
RETURN fq;
END;
/
