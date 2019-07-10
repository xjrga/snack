CREATE PROCEDURE MixModel_Copy (
--
IN v_MixId_Old INTEGER,
--
IN v_MixId_New INTEGER
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO MixModel
(
  mixid,
  nutrientid,
  model
)
SELECT v_MixId_New,
       nutrientid,
       model
FROM MixModel
WHERE mixid = v_MixId_Old;
--
END;
/
