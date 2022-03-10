CREATE PROCEDURE Delete_all_categories_and_foods_from_database (
)
--
MODIFIES SQL DATA
--
BEGIN ATOMIC 
--
DELETE FROM foodcategory;
DELETE FROM food;
--
END
/