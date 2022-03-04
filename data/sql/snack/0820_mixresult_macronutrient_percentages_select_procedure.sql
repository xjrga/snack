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
SELECT ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END ,v_Precision) AS calories,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(fat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS fat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(digestiblecarbohydrate*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS carbs,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(protein*4) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS protein,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(alcohol*6.93) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS alcohol,
       ROUND(getFoodQuotient(v_MixId),2) AS fq,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(satfat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS satfat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(monoufat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS monoufat,
       ROUND(CASE WHEN SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) <= 0 OR SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) IS NULL THEN 0 ELSE SUM(polyufat*9) / SUM(fat*9 + digestiblecarbohydrate*4 + protein*4 + alcohol*6.93) END * 100,v_Precision) AS polyufat
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
      AND   nutrientid = '221') d,
      (SELECT mixid,
             foodid,
             q AS satfat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '606') e,
     (SELECT mixid,
             foodid,
             q AS monoufat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '645') f,
     (SELECT mixid,
             foodid,
             q AS polyufat
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '646') g
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND a.mixid = e.mixid
AND a.mixid = f.mixid
AND a.mixid = g.mixid
AND   a.foodid = b.foodid
AND   a.foodid = c.foodid
AND   a.foodid = d.foodid
AND   a.foodid = e.foodid
AND   a.foodid = f.foodid
AND   a.foodid = g.foodid;
--
OPEN result;
--
END;
/
