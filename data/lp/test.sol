Problem:    test
Rows:       4
Columns:    3
Non-zeros:  9
Status:     OPTIMAL
Objective:  z = 2000 (MINimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 z            B           2000                             
     2 req01        NS           100           100             =         < eps
     3 req02        NS          2000          2000             =             1 
     4 req03        NS            40            40             =         < eps

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 x[1]         B        322.373             0               
     2 x[2]         B        561.039             0               
     3 x[3]         B        1193.65             0               

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 2.27e-13 on row 3
        max.rel.err = 7.07e-17 on row 2
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 2.22e-16 on column 3
        max.rel.err = 7.15e-17 on column 3
        High quality

KKT.DB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
