CREATE PROCEDURE MixResultDw_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO MixResultDw
(
  mixid,
  foodid,
  Name,
  Protein,
  Fat,
  CarbsByDifference,
  Kcal,
  Alcohol,
  Fiber,
  Calcium,
  Magnesium,
  Potassium,
  Sodium,
  Cholesterol,
  SatFat,
  Monoufat,
  Polyufat,
  Quantity,
  Complete,
  Incomplete,
  CarbsDigestible,
  Cost
)
SELECT v_MixId_New,
       foodid,
       Name,
       Protein,
       Fat,
       CarbsByDifference,
       Kcal,
       Alcohol,
       Fiber,
       Calcium,
       Magnesium,
       Potassium,
       Sodium,
       Cholesterol,
       SatFat,
       Monoufat,
       Polyufat,
       Quantity,
       Complete,
       Incomplete,
       CarbsDigestible,
       Cost
FROM MixResultDw
WHERE mixid = v_MixId_Old;

--
END;
/