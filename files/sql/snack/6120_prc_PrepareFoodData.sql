CREATE PROCEDURE PrepareFoodData(
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
CALL foodfact_calculated_quantities_update(v_foodid);
CALL MergeFoodCoefficients(v_foodid);
CALL CopyFoodFactsToDenormalizedTable(v_foodid);
--
END;
/
