CREATE PROCEDURE MixResultDW_Select (
IN v_MixId INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT MIXID,
       FOODID,
       NAME,
       PROTEIN,
       FAT,
       KCAL,
       ALCOHOL,
       FIBER,
       CALCIUM,
       MAGNESIUM,
       POTASSIUM,
       SODIUM,
       CHOLESTEROL,
       SATFAT,
       MONOUFAT,
       POLYUFAT,
       QUANTITY,
       COMPLETE,
       INCOMPLETE,
       CARBSDIGESTIBLE,
       COST
FROM (
SELECT MIXID,
       FOODID,
       NAME,
       ROUND(PROTEIN) as protein,
       ROUND(FAT) as fat,
       ROUND(KCAL) as kcal,
       ROUND(ALCOHOL) as alcohol,
       ROUND(FIBER) as fiber,
       ROUND(CALCIUM) as calcium,
       ROUND(MAGNESIUM) as magnesium,
       ROUND(POTASSIUM) as potassium,
       ROUND(SODIUM) as sodium,
       ROUND(CHOLESTEROL) as cholesterol,
       ROUND(SATFAT) as satfat,
       ROUND(MONOUFAT) as monoufat,
       ROUND(POLYUFAT) as polyufat,
       ROUND(QUANTITY) as quantity,
       ROUND(COMPLETE) as complete,
       ROUND(INCOMPLETE) as incomplete,
       ROUND(CARBSDIGESTIBLE) as carbsdigestible,
       ROUND(COST) as cost
FROM PUBLIC.MIXRESULTDW
WHERE MIXID = V_MIXID
UNION
SELECT MIXID,
       '99999',
       'Total',
       ROUND(SUM(PROTEIN)),
       ROUND(SUM(FAT)),
       ROUND(SUM(KCAL)),
       ROUND(SUM(ALCOHOL)),
       ROUND(SUM(FIBER)),
       ROUND(SUM(CALCIUM)),
       ROUND(SUM(MAGNESIUM)),
       ROUND(SUM(POTASSIUM)),
       ROUND(SUM(SODIUM)),
       ROUND(SUM(CHOLESTEROL)),
       ROUND(SUM(SATFAT)),
       ROUND(SUM(MONOUFAT)),
       ROUND(SUM(POLYUFAT)),
       ROUND(SUM(QUANTITY)),
       ROUND(SUM(COMPLETE)),
       ROUND(SUM(INCOMPLETE)),
       ROUND(SUM(CARBSDIGESTIBLE)),
       ROUND(SUM(COST))
FROM PUBLIC.MIXRESULTDW
WHERE MIXID = V_MIXID
GROUP BY MIXID
)
ORDER BY KCAL;
--
OPEN result;
END;
/