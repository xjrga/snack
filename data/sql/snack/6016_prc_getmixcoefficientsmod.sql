CREATE PROCEDURE getMixCoefficientsMod (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT 0 AS row,
       1 AS n10000,
       2 AS n10001,
       3 AS n10003,
       4 AS n10005,
       5 AS n10006,
       6 AS n10009,
       7 AS n10010,
       8 AS n10011,
       9 AS n10012,
       10 AS n10013,
       11 AS n10014,
       12 AS n10015,
       13 AS n203,
       14 AS n204,
       15 AS n205,
       16 AS n208,
       17 AS n221,
       18 AS n255,
       19 AS n291,
       20 AS n301,
       21 AS n303,
       22 AS n304,
       23 AS n305,
       24 AS n306,
       25 AS n307,
       26 AS n309,
       27 AS n312,
       28 AS n315,
       29 AS n317,
       30 AS n320,
       31 AS n323,
       32 AS n328,
       33 AS n401,
       34 AS n404,
       35 AS n405,
       36 AS n406,
       37 AS n410,
       38 AS n415,
       39 AS n418,
       40 AS n421,
       41 AS n430,
       42 AS n435,
       43 AS n601,
       44 AS n606,
       45 AS n611,
       46 AS n612,
       47 AS n613,
       48 AS n614,
       49 AS n618,
       50 AS n619,
       51 AS n621,
       52 AS n629,
       53 AS n645,
       54 AS n646
FROM (
     VALUES (0))
UNION
SELECT ROWNUM(),
       a1.c,
       a2.c,
       a3.c,
       a4.c,
       a5.c,
       a6.c,
       a7.c,
       a8.c,
       a8.c,
       a10.c,
       a11.c,
       a12.c,
       a13.c,
       a14.c,
       a15.c,
       a16.c,
       a17.c,
       a18.c,
       a19.c,
       a20.c,
       a21.c,
       a22.c,
       a23.c,
       a24.c,
       a25.c,
       a26.c,
       a27.c,
       a28.c,
       a29.c,
       a30.c,
       a31.c,
       a32.c,
       a33.c,
       a34.c,
       a35.c,
       a36.c,
       a37.c,
       a38.c,
       a39.c,
       a40.c,
       a41.c,
       a42.c,
       a43.c,
       a44.c,
       a45.c,
       a46.c,
       a47.c,
       a48.c,
       a49.c,
       a50.c,
       a51.c,
       a52.c,
       a53.c,
       a54.c
FROM (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10000'
      AND   a.mixid =  v_mixid) a1,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10001'
      AND   a.mixid =  v_mixid) a2,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10003'
      AND   a.mixid =  v_mixid) a3,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10005'
      AND   a.mixid =  v_mixid) a4,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10006'
      AND   a.mixid =  v_mixid) a5,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10009'
      AND   a.mixid =  v_mixid) a6,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10010'
      AND   a.mixid =  v_mixid) a7,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10011'
      AND   a.mixid =  v_mixid) a8,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10012'
      AND   a.mixid =  v_mixid) a9,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10013'
      AND   a.mixid =  v_mixid) a10,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10014'
      AND   a.mixid =  v_mixid) a11,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '10015'
      AND   a.mixid =  v_mixid) a12,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '203'
      AND   a.mixid =  v_mixid) a13,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '204'
      AND   a.mixid =  v_mixid) a14,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '205'
      AND   a.mixid =  v_mixid) a15,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '208'
      AND   a.mixid =  v_mixid) a16,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '221'
      AND   a.mixid =  v_mixid) a17,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '255'
      AND   a.mixid =  v_mixid) a18,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '291'
      AND   a.mixid =  v_mixid) a19,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '301'
      AND   a.mixid =  v_mixid) a20,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '303'
      AND   a.mixid =  v_mixid) a21,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '304'
      AND   a.mixid =  v_mixid) a22,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '305'
      AND   a.mixid =  v_mixid) a23,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '306'
      AND   a.mixid =  v_mixid) a24,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '307'
      AND   a.mixid =  v_mixid) a25,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '309'
      AND   a.mixid =  v_mixid) a26,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '312'
      AND   a.mixid =  v_mixid) a27,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '315'
      AND   a.mixid =  v_mixid) a28,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '317'
      AND   a.mixid =  v_mixid) a29,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '320'
      AND   a.mixid =  v_mixid) a30,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '323'
      AND   a.mixid =  v_mixid) a31,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '328'
      AND   a.mixid =  v_mixid) a32,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '401'
      AND   a.mixid =  v_mixid) a33,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '404'
      AND   a.mixid =  v_mixid) a34,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '405'
      AND   a.mixid =  v_mixid) a35,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '406'
      AND   a.mixid =  v_mixid) a36,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '410'
      AND   a.mixid =  v_mixid) a37,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '415'
      AND   a.mixid =  v_mixid) a38,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '418'
      AND   a.mixid =  v_mixid) a39,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '421'
      AND   a.mixid =  v_mixid) a40,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '430'
      AND   a.mixid =  v_mixid) a41,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '435'
      AND   a.mixid =  v_mixid) a42,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '601'
      AND   a.mixid =  v_mixid) a43,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '606'
      AND   a.mixid =  v_mixid) a44,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '611'
      AND   a.mixid =  v_mixid) a45,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '612'
      AND   a.mixid =  v_mixid) a46,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '613'
      AND   a.mixid =  v_mixid) a47,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '614'
      AND   a.mixid =  v_mixid) a48,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '618'
      AND   a.mixid =  v_mixid) a49,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '619'
      AND   a.mixid =  v_mixid) a50,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '621'
      AND   a.mixid =  v_mixid) a51,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '629'
      AND   a.mixid =  v_mixid) a52,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '645'
      AND   a.mixid =  v_mixid) a53,
     (SELECT a.mixid,
             b.foodid,
             b.c
      FROM mixfood a,
           foodfactcoefficient b,
           nutrient c
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = c.nutrientid
      AND   b.nutrientid = '646'
      AND   a.mixid =  v_mixid) a54
WHERE a1.mixid = a2.mixid
AND   a1.foodid = a2.foodid
AND   a1.mixid = a3.mixid
AND   a1.foodid = a3.foodid
AND   a1.mixid = a4.mixid
AND   a1.foodid = a4.foodid
AND   a1.mixid = a5.mixid
AND   a1.foodid = a5.foodid
AND   a1.mixid = a6.mixid
AND   a1.foodid = a6.foodid
AND   a1.mixid = a7.mixid
AND   a1.foodid = a7.foodid
AND   a1.mixid = a8.mixid
AND   a1.foodid = a8.foodid
AND   a1.mixid = a9.mixid
AND   a1.foodid = a9.foodid
AND   a1.mixid = a10.mixid
AND   a1.foodid = a10.foodid
AND   a1.mixid = a11.mixid
AND   a1.foodid = a11.foodid
AND   a1.mixid = a12.mixid
AND   a1.foodid = a12.foodid
AND   a1.mixid = a13.mixid
AND   a1.foodid = a13.foodid
AND   a1.mixid = a14.mixid
AND   a1.foodid = a14.foodid
AND   a1.mixid = a15.mixid
AND   a1.foodid = a15.foodid
AND   a1.mixid = a16.mixid
AND   a1.foodid = a16.foodid
AND   a1.mixid = a17.mixid
AND   a1.foodid = a17.foodid
AND   a1.mixid = a18.mixid
AND   a1.foodid = a18.foodid
AND   a1.mixid = a19.mixid
AND   a1.foodid = a19.foodid
AND   a1.mixid = a20.mixid
AND   a1.foodid = a20.foodid
AND   a1.mixid = a21.mixid
AND   a1.foodid = a21.foodid
AND   a1.mixid = a22.mixid
AND   a1.foodid = a22.foodid
AND   a1.mixid = a23.mixid
AND   a1.foodid = a23.foodid
AND   a1.mixid = a24.mixid
AND   a1.foodid = a24.foodid
AND   a1.mixid = a25.mixid
AND   a1.foodid = a25.foodid
AND   a1.mixid = a26.mixid
AND   a1.foodid = a26.foodid
AND   a1.mixid = a27.mixid
AND   a1.foodid = a27.foodid
AND   a1.mixid = a28.mixid
AND   a1.foodid = a28.foodid
AND   a1.mixid = a29.mixid
AND   a1.foodid = a29.foodid
AND   a1.mixid = a30.mixid
AND   a1.foodid = a30.foodid
AND   a1.mixid = a31.mixid
AND   a1.foodid = a31.foodid
AND   a1.mixid = a32.mixid
AND   a1.foodid = a32.foodid
AND   a1.mixid = a33.mixid
AND   a1.foodid = a33.foodid
AND   a1.mixid = a34.mixid
AND   a1.foodid = a34.foodid
AND   a1.mixid = a35.mixid
AND   a1.foodid = a35.foodid
AND   a1.mixid = a36.mixid
AND   a1.foodid = a36.foodid
AND   a1.mixid = a37.mixid
AND   a1.foodid = a37.foodid
AND   a1.mixid = a38.mixid
AND   a1.foodid = a38.foodid
AND   a1.mixid = a39.mixid
AND   a1.foodid = a39.foodid
AND   a1.mixid = a40.mixid
AND   a1.foodid = a40.foodid
AND   a1.mixid = a41.mixid
AND   a1.foodid = a41.foodid
AND   a1.mixid = a42.mixid
AND   a1.foodid = a42.foodid
AND   a1.mixid = a43.mixid
AND   a1.foodid = a43.foodid
AND   a1.mixid = a44.mixid
AND   a1.foodid = a44.foodid
AND   a1.mixid = a45.mixid
AND   a1.foodid = a45.foodid
AND   a1.mixid = a46.mixid
AND   a1.foodid = a46.foodid
AND   a1.mixid = a47.mixid
AND   a1.foodid = a47.foodid
AND   a1.mixid = a48.mixid
AND   a1.foodid = a48.foodid
AND   a1.mixid = a49.mixid
AND   a1.foodid = a49.foodid
AND   a1.mixid = a50.mixid
AND   a1.foodid = a50.foodid
AND   a1.mixid = a51.mixid
AND   a1.foodid = a51.foodid
AND   a1.mixid = a52.mixid
AND   a1.foodid = a52.foodid
AND   a1.mixid = a53.mixid
AND   a1.foodid = a53.foodid
AND   a1.mixid = a54.mixid
AND   a1.foodid = a54.foodid;

--
OPEN result;

--
END;
/
