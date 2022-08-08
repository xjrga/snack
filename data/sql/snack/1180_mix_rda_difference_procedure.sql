CREATE PROCEDURE Mix_getRdaDiff (
--
IN v_MixId LONGVARCHAR,
IN v_LifeStageId INTEGER,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.nutrientid,
       b.name,
       ROUND(a.mix,v_Precision) AS Mix,
       ROUND(a.rda,v_Precision) AS Rda,
       ROUND(CASE WHEN a.rda <= 0 THEN 0 ELSE (a.mix / a.rda)*100 END,v_Precision) AS PctRda,
       ROUND(a.ul,v_Precision) AS UL,
       ROUND(CASE WHEN a.ul <= 0 THEN 0 ELSE (a.mix / a.ul)*100 END,v_Precision) AS PctUL
FROM (SELECT a.nutrientid,
             a.mix,
             b.rda,
             b.ul
      FROM (SELECT nutrientid,
                   SUM(a.q) AS mix
            FROM mixresult a
            WHERE a.mixid = v_MixId
            AND   (
            --vitamin A
            nutrientid = '320' OR
            --Vitamin D
            nutrientid = '328' OR
            --E
            nutrientid = '323' OR
            --K
            nutrientid = '430' OR
            --C
            nutrientid = '401' OR
            --Thiamin
            nutrientid = '404' OR
            --Riboflavin
            nutrientid = '405' OR
            --Niacin
            nutrientid = '406' OR
            --B6
            nutrientid = '415' OR
            --Folate
            nutrientid = '435' OR
            --B12
            nutrientid = '418' OR
            --Choline
            nutrientid = '421' OR
            --Calcium
            nutrientid = '301' OR
            --Phosphorus
            nutrientid = '305' OR
            --Magnesium
            nutrientid = '304' OR
            --Iron
            nutrientid = '303' OR
            --Potassium
            nutrientid = '306' OR
            --Sodium
            nutrientid = '307' OR
            --Zinc
            nutrientid = '309' OR
            --Selenium
            nutrientid = '317' OR
            --Copper
            nutrientid = '312' OR
            --Manganese
            nutrientid = '315' OR
            --Panthotenic Acid
            nutrientid = '410' OR
            --Water (g)
            nutrientid = '255' OR
            --Digestible Carbohydrate (g)
            nutrientid = '10003' OR
            --Fiber, total dietary (g)
            nutrientid = '291' OR
            --Total lipid (Fat) (g)
            nutrientid = '204' OR
            --18:2 undifferentiated (Linoleic) (g)
            nutrientid = '618' OR
            --18:3 undifferentiated (Linolenic) (g)
            nutrientid = '619' OR
            --Complete Protein (g)
            nutrientid = '10001')
            GROUP BY nutrientid) a,
           (SELECT nutrientid, q AS rda, ul FROM rda WHERE lifestageid = v_LifeStageId) b
      WHERE a.nutrientid = b.nutrientid) a,
     (SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
WHERE a.nutrientid = b.nutrientid
ORDER BY b.name;
--
OPEN result;
--
END;
/
