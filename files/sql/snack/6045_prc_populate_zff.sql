CREATE PROCEDURE populate_zff (IN v_mixid LONGVARCHAR) MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO zff
(
  row,
  mixid,
  foodid,
  n10000,
  n10001,
  n10003,
  n10005,
  n10006,
  n10009,
  n10010,
  n10011,
  n10012,
  n10013,
  n10014,
  n10015,
  n203,
  n204,
  n205,
  n208,
  n221,
  n255,
  n291,
  n301,
  n303,
  n304,
  n305,
  n306,
  n307,
  n309,
  n312,
  n315,
  n317,
  n320,
  n323,
  n328,
  n401,
  n404,
  n405,
  n406,
  n410,
  n415,
  n418,
  n421,
  n430,
  n435,
  n601,
  n606,
  n611,
  n612,
  n613,
  n614,
  n618,
  n619,
  n621,
  n629,
  n645,
  n646
)
SELECT ROWNUM(),
       a.*
FROM (SELECT a1.mixid AS mixid,
             a1.foodid AS foodid,
             a1.q AS n10000,
             a2.q AS n10001,
             a3.q AS n10003,
             a4.q AS n10005,
             a5.q AS n10006,
             a6.q AS n10009,
             a7.q AS n10010,
             a8.q AS n10011,
             a9.q AS n10012,
             a10.q AS n10013,
             a11.q AS n10014,
             a12.q AS n10015,
             a13.q AS n203,
             a14.q AS n204,
             a15.q AS n205,
             a16.q AS n208,
             a17.q AS n221,
             a18.q AS n255,
             a19.q AS n291,
             a20.q AS n301,
             a21.q AS n303,
             a22.q AS n304,
             a23.q AS n305,
             a24.q AS n306,
             a25.q AS n307,
             a26.q AS n309,
             a27.q AS n312,
             a28.q AS n315,
             a29.q AS n317,
             a30.q AS n320,
             a31.q AS n323,
             a32.q AS n328,
             a33.q AS n401,
             a34.q AS n404,
             a35.q AS n405,
             a36.q AS n406,
             a37.q AS n410,
             a38.q AS n415,
             a39.q AS n418,
             a40.q AS n421,
             a41.q AS n430,
             a42.q AS n435,
             a43.q AS n601,
             a44.q AS n606,
             a45.q AS n611,
             a46.q AS n612,
             a47.q AS n613,
             a48.q AS n614,
             a49.q AS n618,
             a50.q AS n619,
             a51.q AS n621,
             a52.q AS n629,
             a53.q AS n645,
             a54.q AS n646
      FROM (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10000'
            AND   a.mixid = v_mixid) a1,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10001'
            AND   a.mixid = v_mixid) a2,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10003'
            AND   a.mixid = v_mixid) a3,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10005'
            AND   a.mixid = v_mixid) a4,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10006'
            AND   a.mixid = v_mixid) a5,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10009'
            AND   a.mixid = v_mixid) a6,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10010'
            AND   a.mixid = v_mixid) a7,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10011'
            AND   a.mixid = v_mixid) a8,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10012'
            AND   a.mixid = v_mixid) a9,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10013'
            AND   a.mixid = v_mixid) a10,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10014'
            AND   a.mixid = v_mixid) a11,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '10015'
            AND   a.mixid = v_mixid) a12,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '203'
            AND   a.mixid = v_mixid) a13,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '204'
            AND   a.mixid = v_mixid) a14,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '205'
            AND   a.mixid = v_mixid) a15,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '208'
            AND   a.mixid = v_mixid) a16,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '221'
            AND   a.mixid = v_mixid) a17,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '255'
            AND   a.mixid = v_mixid) a18,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '291'
            AND   a.mixid = v_mixid) a19,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '301'
            AND   a.mixid = v_mixid) a20,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '303'
            AND   a.mixid = v_mixid) a21,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '304'
            AND   a.mixid = v_mixid) a22,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '305'
            AND   a.mixid = v_mixid) a23,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '306'
            AND   a.mixid = v_mixid) a24,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '307'
            AND   a.mixid = v_mixid) a25,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '309'
            AND   a.mixid = v_mixid) a26,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '312'
            AND   a.mixid = v_mixid) a27,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '315'
            AND   a.mixid = v_mixid) a28,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '317'
            AND   a.mixid = v_mixid) a29,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '320'
            AND   a.mixid = v_mixid) a30,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '323'
            AND   a.mixid = v_mixid) a31,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '328'
            AND   a.mixid = v_mixid) a32,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '401'
            AND   a.mixid = v_mixid) a33,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '404'
            AND   a.mixid = v_mixid) a34,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '405'
            AND   a.mixid = v_mixid) a35,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '406'
            AND   a.mixid = v_mixid) a36,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '410'
            AND   a.mixid = v_mixid) a37,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '415'
            AND   a.mixid = v_mixid) a38,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '418'
            AND   a.mixid = v_mixid) a39,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '421'
            AND   a.mixid = v_mixid) a40,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '430'
            AND   a.mixid = v_mixid) a41,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '435'
            AND   a.mixid = v_mixid) a42,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '601'
            AND   a.mixid = v_mixid) a43,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '606'
            AND   a.mixid = v_mixid) a44,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '611'
            AND   a.mixid = v_mixid) a45,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '612'
            AND   a.mixid = v_mixid) a46,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '613'
            AND   a.mixid = v_mixid) a47,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '614'
            AND   a.mixid = v_mixid) a48,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '618'
            AND   a.mixid = v_mixid) a49,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '619'
            AND   a.mixid = v_mixid) a50,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '621'
            AND   a.mixid = v_mixid) a51,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '629'
            AND   a.mixid = v_mixid) a52,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '645'
            AND   a.mixid = v_mixid) a53,
           (SELECT a.mixid,
                   b.foodid,
                   b.q
            FROM mixfood a,
                 foodfact b,
                 nutrient c
            WHERE a.foodid = b.foodid
            AND   b.nutrientid = c.nutrientid
            AND   b.nutrientid = '646'
            AND   a.mixid = v_mixid) a54
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
      AND   a1.foodid = a54.foodid
      ORDER BY a1.foodid
      ) a
ORDER BY a.foodid;
--
END;
/
