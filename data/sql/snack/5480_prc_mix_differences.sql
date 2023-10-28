CREATE PROCEDURE Mix_getDiff (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.name,b.name,b.mixa,b.mixb,b.diff
FROM
(
SELECT nutrientcategoryid, name
FROM nutrientcategory) A,
(
SELECT
       b.nutrientcategoryid,
       b.nutrientid,
       b.name,
       round(a.mix1,v_Precision) as mixa,
       round(a.mix2,v_Precision) as mixb,
       round(a.diff,v_Precision) as diff
FROM (SELECT a.nutrientid,
             a.value AS mix1,
             b.value AS mix2,
             b.value - a.value AS diff
      FROM (SELECT nutrientid,
                   SUM(q) AS value
            FROM mixresult
            WHERE mixid = v_MixId_1
            GROUP BY nutrientid) a,
           (SELECT nutrientid,
                   SUM(q) AS value
            FROM mixresult
            WHERE mixid = v_MixId_2
            GROUP BY nutrientid) b
      WHERE a.nutrientid = b.nutrientid) a,
     (SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
WHERE a.nutrientid = b.nutrientid) B
WHERE a.nutrientcategoryid = b.nutrientcategoryid
ORDER BY a.name, b.name;
--
OPEN result;
--
END;
/