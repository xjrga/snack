CREATE PROCEDURE foodnutrient_lhs (
--
IN v_MixId LONGVARCHAR,
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR,
--
IN v_relationshipid integer
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
    --
DECLARE
    result CURSOR FOR
        SELECT
            rownum () AS x,
                name,
                c
            FROM (
                SELECT
                    name,
                    c
                FROM (
                    SELECT
                        food_id_b AS name,
                        nutrientid,
                        c
                    FROM (
                        SELECT
                            a.mixid,
                            a.foodid AS food_id_a,
                            a.relationshipid,
                            b.foodid AS food_id_b,
                            a.nutrientid,
                            CASE WHEN b.foodid = a.foodid THEN
                            (
                                SELECT
                                    c
                                FROM
                                    foodfactcoefficient
                                WHERE
                                    foodid = a.foodid
                                    AND nutrientid = a.nutrientid)
                            ELSE
                                0
                            END AS c
                        FROM
                            FoodQuantityC a,
                            mixfood b
                        WHERE
                            a.mixid = b.mixid
                            AND a.mixid = v_mixid
                        ORDER BY
                            a.mixid,
                            a.foodid,
                            a.relationshipid,
                            b.foodid)
                    WHERE
                        mixid = v_mixid
                        AND food_id_a = v_foodid
                        AND nutrientid = v_nutrientid
                        AND relationshipid = v_relationshipid
                    ORDER BY
                        mixid,
                        food_id_a,
                        relationshipid,
                        food_id_b,
                        nutrientid)
                UNION ALL
                SELECT
                    name,
                    deficiency
                FROM (
                    SELECT
                        concat('deficiency_', nutrientid) AS name,
                        0 AS deficiency
                    FROM
                        tninutrients
                    ORDER BY
                        nutrientid)
                UNION ALL
                SELECT
                    name,
                    excess
                FROM (
                    SELECT
                        concat('excess_', nutrientid) AS name,
                        0 AS excess
                    FROM
                        tninutrients
                    ORDER BY
                        nutrientid)
                UNION ALL
                SELECT
                    'avg_deficiency',
                    0 AS avg_deficiency
                FROM (
                    VALUES (0))
                UNION ALL
                SELECT
                    'avg_excess',
                    0 AS avg_excess
                FROM (
                    VALUES (0)));
                    --
                    OPEN result;
                    --
END
/
