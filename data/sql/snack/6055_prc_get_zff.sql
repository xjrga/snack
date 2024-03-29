CREATE PROCEDURE get_zff(
IN v_mixid LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
DECLARE result CURSOR
FOR
--
SELECT a.row,
       a.n10000,
       a.n10001,
       a.n10003,
       a.n10005,
       a.n10006,
       a.n10009,
       a.n10010,
       a.n10011,
       a.n10012,
       a.n10013,
       a.n10014,
       a.n10015,
       a.n203,
       a.n204,
       a.n205,
       a.n208,
       a.n221,
       a.n255,
       a.n291,
       a.n301,
       a.n303,
       a.n304,
       a.n305,
       a.n306,
       a.n307,
       a.n309,
       a.n312,
       a.n315,
       a.n317,
       a.n320,
       a.n323,
       a.n328,
       a.n401,
       a.n404,
       a.n405,
       a.n406,
       a.n410,
       a.n415,
       a.n418,
       a.n421,
       a.n430,
       a.n435,
       a.n601,
       a.n606,
       a.n611,
       a.n612,
       a.n613,
       a.n614,
       a.n618,
       a.n619,
       a.n621,
       a.n629,
       a.n645,
       a.n646
FROM (SELECT '' AS mixid,
             '' AS foodid,
             0 AS ROW,
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
      SELECT *
      FROM zff
      WHERE mixid = v_mixid) a
ORDER BY a.foodid;
--
OPEN result;
--
END;
/