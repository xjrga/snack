CREATE PROCEDURE MixInventory_merge (
--
IN v_MixId LONGVARCHAR,
IN v_Days DOUBLE
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
MERGE INTO MixInventory USING ( VALUES (
v_MixId,
v_Days
) ) ON (
MixId = v_MixId
)
WHEN MATCHED THEN UPDATE SET
Days = v_Days
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_Days;
--
END;
/
