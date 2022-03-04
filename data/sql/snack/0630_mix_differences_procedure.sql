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
SELECT b.name,
       round(a.mix1,v_Precision),
       round(a.mix2,v_Precision),
       round(a.diff,v_Precision)
FROM (SELECT a.nutrientid,
             a.value AS mix1,
             b.value AS mix2,
             a.value - b.value AS diff
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
WHERE a.nutrientid = b.nutrientid
ORDER BY b.nutrientcategoryid desc,b.nutrientid;
--
OPEN result;
--
END;
/