CREATE PROCEDURE getDri()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT -1 AS row,
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
SELECT a.lifestageid+1,
       0.0 AS "n10000",
       a.q AS "n10001",
       b.q AS "n10003",
       0.0 AS "n10005",
       0.0 AS "n10006",
       0.0 AS "n10009",
       0.0 AS "n10010",
       0.0 AS "n10011",
       0.0 AS "n10012",
       0.0 AS "n10013",
       0.0 AS "n10014",
       0.0 AS "n10015",
       0.0 AS "n203",
       c.q AS "n204",
       0.0 AS "n205",
       0.0 AS "n208",
       0.0 AS "n221",
       d.q AS "n255",
       e.q AS "n291",
       f.q AS "n301",
       g.q AS "n303",
       h.q AS "n304",
       i.q AS "n305",
       j.q AS "n306",
       k.q AS "n307",
       l.q AS "n309",
       m.q AS "n312",
       n.q AS "n315",
       o.q AS "n317",
       p.q AS "n320",
       q.q AS "n323",
       r.q AS "n328",
       s.q AS "n401",
       t.q AS "n404",
       u.q AS "n405",
       v.q AS "n406",
       w.q AS "n410",
       x.q AS "n415",
       y.q AS "n418",
       z.q AS "n421",
       aa.q AS "n430",
       ab.q AS "n435",
       0.0 AS "n601",
       0.0 AS "n606",
       0.0 AS "n611",
       0.0 AS "n612",
       0.0 AS "n613",
       0.0 AS "n614",
       ac.q AS "n618",
       ad.q AS "n619",
       0.0 AS "n621",
       0.0 AS "n629",
       0.0 AS "n645",
       0.0 AS "n646"
FROM (SELECT lifestageid, q FROM Rda WHERE nutrientid = '10001') a,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '10003') b,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '204') c,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '255') d,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '291') e,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '301') f,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '303') g,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '304') h,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '305') i,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '306') j,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '307') k,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '309') l,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '312') m,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '315') n,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '317') o,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '320') p,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '323') q,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '328') r,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '401') s,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '404') t,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '405') u,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '406') v,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '410') w,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '415') x,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '418') y,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '421') z,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '430') aa,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '435') ab,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '618') ac,
     (SELECT lifestageid, q FROM Rda WHERE nutrientid = '619') ad
WHERE a.lifestageid = a.lifestageid
AND   a.lifestageid = b.lifestageid
AND   a.lifestageid = c.lifestageid
AND   a.lifestageid = d.lifestageid
AND   a.lifestageid = e.lifestageid
AND   a.lifestageid = f.lifestageid
AND   a.lifestageid = g.lifestageid
AND   a.lifestageid = h.lifestageid
AND   a.lifestageid = i.lifestageid
AND   a.lifestageid = j.lifestageid
AND   a.lifestageid = k.lifestageid
AND   a.lifestageid = l.lifestageid
AND   a.lifestageid = m.lifestageid
AND   a.lifestageid = n.lifestageid
AND   a.lifestageid = o.lifestageid
AND   a.lifestageid = p.lifestageid
AND   a.lifestageid = q.lifestageid
AND   a.lifestageid = r.lifestageid
AND   a.lifestageid = s.lifestageid
AND   a.lifestageid = t.lifestageid
AND   a.lifestageid = u.lifestageid
AND   a.lifestageid = v.lifestageid
AND   a.lifestageid = w.lifestageid
AND   a.lifestageid = x.lifestageid
AND   a.lifestageid = y.lifestageid
AND   a.lifestageid = z.lifestageid
AND   a.lifestageid = aa.lifestageid
AND   a.lifestageid = ab.lifestageid
AND   a.lifestageid = ac.lifestageid
AND   a.lifestageid = ad.lifestageid;
--
OPEN result;
--
END;
/
