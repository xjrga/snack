CREATE PROCEDURE Group_Copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO MixFoodGroup
(
  mixid,
  groupid,
  name
)
SELECT v_MixId_New,
       groupid,
       name
FROM MixFoodGroup
WHERE mixid = v_MixId_Old;

--
END;
/
