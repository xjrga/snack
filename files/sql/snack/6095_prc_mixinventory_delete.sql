CREATE PROCEDURE MixInventory_delete (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
MixInventory
WHERE
MixId = v_MixId;
--
END;
/
