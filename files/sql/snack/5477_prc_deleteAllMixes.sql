CREATE PROCEDURE deleteAllMixes()
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM Mix;
END;
/
