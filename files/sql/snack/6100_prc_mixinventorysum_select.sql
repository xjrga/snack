CREATE PROCEDURE MixInventorySum_select ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.foodid,
       a.name,
       a.grams AS g,
       b.ouncefactor*a.grams AS oz,
       c.lbfactor*a.grams AS lb,
       d.kgfactor*a.grams AS kg
FROM (SELECT b.foodid,
             c.name,
             SUM(b.x*a.days) AS grams
      FROM mixinventory a,
           mixfood b,
           food c
      WHERE a.mixid = b.mixid
      AND   b.foodid = c.foodid
      GROUP BY b.foodid,
               c.name
      ORDER BY c.name) a,
     (SELECT factor AS ouncefactor FROM units WHERE unitid = 1) b,
     (SELECT factor AS lbfactor FROM units WHERE unitid = 2) c,
     (SELECT factor AS kgfactor FROM units WHERE unitid = 3) d;
--
OPEN result;
--
END;
/
