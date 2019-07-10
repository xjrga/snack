CREATE PROCEDURE Food_Select_Details ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT y.category,
       x.food,
       x.protein,
       x.fat,
       --       x.carbohydrate,
       x.calories,
       x.alcohol,
       x.fiber,
       x.calcium,
       x.magnesium,
       x.potassium,
       x.sodium,
       x.cholesterol,
       x.satfat,
       x.monoufat,
       x.polyufat,
       x.quantity,
       x.complete,
       x.incomplete,
       x.carbsdigestible,
       x.cost,
       y.foodcategoryid,
       x.foodid
FROM (SELECT a0.name AS food,
             a1.protein,
             a2.fat,
             --             a3.carbohydrate,
             a4.calories,
             a5.alcohol,
             a6.fiber,
             a7.calcium,
             a8.magnesium,
             a9.potassium,
             a10.sodium,
             a11.cholesterol,
             a12.satfat,
             a13.monoufat,
             a14.polyufat,
             a15.quantity,
             a16.complete,
             a17.incomplete,
             a18.carbsdigestible,
             a20.cost,
             a0.foodid
      FROM
      --
      (SELECT b.name, b.foodid FROM food b) a0,
           --
      (SELECT foodid,
              q AS protein
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '203') a1,
           --
      (SELECT foodid,
              q AS fat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '204') a2,
           (SELECT foodid,
                   q AS calories
            FROM food a,
                 foodfact b
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = '208') a4,
           --
      (SELECT foodid,
              q AS alcohol
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '221') a5,
           --
      (SELECT foodid,
              q AS fiber
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '291') a6,
           --
      (SELECT foodid,
              q AS calcium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '301') a7,
           --
      (SELECT foodid,
              q AS magnesium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '304') a8,
           --
      (SELECT foodid,
              q AS potassium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '306') a9,
           --
      (SELECT foodid,
              q AS sodium
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '307') a10,
           --
      (SELECT foodid,
              q AS cholesterol
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '601') a11,
           --
      (SELECT foodid,
              q AS satfat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '606') a12,
           --
      (SELECT foodid,
              q AS monoufat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '645') a13,
           --
      (SELECT foodid,
              q AS polyufat
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '646') a14,
           --
      (SELECT foodid,
              q AS quantity
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10000') a15,
           --
      (SELECT foodid,
              q AS complete
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10001') a16,
           --
      (SELECT foodid,
              q AS incomplete
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10002') a17,
           --
      (SELECT foodid,
              q AS carbsdigestible
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10003') a18,
           --
      (SELECT foodid,
              q AS cost
       FROM food a,
            foodfact b
       WHERE a.foodid = b.foodid
       AND   b.nutrientid = '10005') a20
      WHERE a0.foodid = a1.foodid
      AND   a0.foodid = a2.foodid
      --      AND   a0.foodid = a3.foodid
      AND   a0.foodid = a4.foodid
      AND   a0.foodid = a5.foodid
      AND   a0.foodid = a6.foodid
      AND   a0.foodid = a7.foodid
      AND   a0.foodid = a8.foodid
      AND   a0.foodid = a9.foodid
      AND   a0.foodid = a10.foodid
      AND   a0.foodid = a11.foodid
      AND   a0.foodid = a12.foodid
      AND   a0.foodid = a13.foodid
      AND   a0.foodid = a14.foodid
      AND   a0.foodid = a15.foodid
      AND   a0.foodid = a16.foodid
      AND   a0.foodid = a17.foodid
      AND   a0.foodid = a18.foodid
      AND   a0.foodid = a20.foodid) x
  LEFT JOIN (SELECT c.name AS category,
                    c.foodcategoryid,
                    a.foodid
             FROM categorylink a,
                  foodcategory c
             WHERE a.foodcategoryid = c.foodcategoryid) y ON x.foodid = y.foodid
ORDER BY category,
         food;
--
OPEN result;

--
END;
/