CREATE PROCEDURE Group_Select_All_By_Name (IN v_MixId LONGVARCHAR)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
        a.MixId,
	a.GroupId,
	a.Name
FROM
	MixFoodGroup a
WHERE
a.mixid = v_mixid
ORDER BY
	a.Name;
OPEN result;
END;
/
