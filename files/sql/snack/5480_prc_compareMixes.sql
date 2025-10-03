CREATE PROCEDURE compareMixes (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT category, nutrient, mixa, mixb, diff
FROM
(
SELECT a.name as category,
       b.name as nutrient,
       b.mixa,
       b.mixb,
       b.diff
FROM (SELECT nutrientcategoryid, name FROM nutrientcategory) A,
     (SELECT b.nutrientcategoryid,
             b.nutrientid,
             b.name,
             a.mix1 AS mixa,
             a.mix2 AS mixb,
             a.diff AS diff
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
      WHERE a.nutrientid = b.nutrientid) B
WHERE a.nutrientcategoryid = b.nutrientcategoryid
UNION
SELECT 'Dietary Index'
       AS name,
       'Total Nutrient Index Score' AS name,
       a.mixa,
       b.mixb,
       a.mixa - b.mixb as diff
FROM (SELECT IFNULL((1 - mixdeficiency)*100.0,0) AS mixa
      FROM mix
      WHERE mixid = v_MixId_1) a,
     (SELECT IFNULL((1 - mixdeficiency)*100.0,0) AS mixb
      FROM mix
      WHERE mixid = v_MixId_2) b
UNION      
SELECT 'Energy' AS category,
       'Energy, Food Quotient' AS name,
       getFoodQuotient(v_MixId_1) * 100.0 AS mixa,
       getFoodQuotient(v_MixId_2) * 100.0 AS mixb,
       (getFoodQuotient(v_MixId_1) - getFoodQuotient(v_MixId_2)) * 100 as diff
FROM (
     VALUES (0))
UNION
SELECT 'Energy' AS category,
       'Energy, Protein (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_protein) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_protein) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Fat and Carbohydrate (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0, (SUM(energy_carbohydrate) + SUM(energy_fat)) / SUM(energy_digestible) *100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0, (SUM(energy_carbohydrate) + SUM(energy_fat)) / SUM(energy_digestible) *100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Fat (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0,SUM(energy_fat) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0,SUM(energy_fat) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Carbohydrate (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_carbohydrate) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_carbohydrate) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
UNION
SELECT 'Energy' AS category,
       'Energy, Alcohol (%)' AS name,
       a.mixa,
       b.mixb,
              a.mixa - b.mixb as diff
FROM (SELECT IFNULL(CASEWHEN(SUM(energy_digestible) <= 0,0,SUM(energy_alcohol) / SUM(energy_digestible)*100),0) AS mixa
      FROM DnMixResult
      WHERE mix_id = v_MixId_1) a,
     (SELECT IFNULL(CASEWHEN (SUM(energy_digestible) <= 0,0,SUM(energy_alcohol) / SUM(energy_digestible)*100),0) AS mixb
      FROM DnMixResult
      WHERE mix_id = v_MixId_2) b
)      
ORDER BY nutrient ASC;
--
OPEN result;
--
END;
/