CREATE FUNCTION calculateTniScore (
--
IN v_lifestageid INTEGER,
IN deficiency_Ca DECIMAL(28,15),
IN deficiency_Mg DECIMAL(28,15),
IN deficiency_K DECIMAL(28,15),
IN deficiency_VitA DECIMAL(28,15),
IN deficiency_VitE DECIMAL(28,15),
IN deficiency_VitD DECIMAL(28,15),
IN deficiency_VitC DECIMAL(28,15),
IN deficiency_Choline DECIMAL(28,15)
--
)
--
RETURNS DECIMAL(28,15) READS SQL DATA BEGIN ATOMIC
--
DECLARE pct_Ca DECIMAL(28,15);
DECLARE pct_Mg DECIMAL(28,15);
DECLARE pct_K DECIMAL(28,15);
DECLARE pct_VitA DECIMAL(28,15);
DECLARE pct_VitE DECIMAL(28,15);
DECLARE pct_VitD DECIMAL(28,15);
DECLARE pct_VitC DECIMAL(28,15);
DECLARE pct_Choline DECIMAL(28,15);
DECLARE tniscore DECIMAL(28,15);
--
--
SELECT deficiency_Ca/q INTO pct_Ca FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '301';
SELECT deficiency_Mg/q INTO pct_Mg FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '304';
SELECT deficiency_K/q INTO pct_K FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '306';
SELECT deficiency_VitA/q INTO pct_VitA FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '320';
SELECT deficiency_VitE/q INTO pct_VitE FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '323';
SELECT deficiency_VitD/q INTO pct_VitD FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '328';
SELECT deficiency_VitC/q INTO pct_VitC FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '401';
SELECT deficiency_Choline/q INTO pct_Choline FROM Rda WHERE LifestageId =  v_lifestageid AND NutrientId = '421';
--
SELECT
(1 - ((pct_Ca + pct_Mg + pct_K + pct_VitA + pct_VitE + pct_VitD + pct_VitC + pct_Choline ) /
CAST (8.0 AS DECIMAL(25,18)))) * 100
INTO tniscore FROM (VALUES(0));
--
RETURN tniscore;

END;
/