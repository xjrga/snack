param FOODS;
param NUTRIENTS;
param CONSTRAINTS;
param a{i in 1..NUTRIENTS,j in 1..FOODS};
param b{i in 1..CONSTRAINTS};
param c{j in 1..FOODS};
var x{j in 1..FOODS} >= 0;

/* objective function */
minimize z: sum{j in 1..FOODS} a[2,j] * x[j];

/* nutrient constraint set individually */
/*s.t.  protein: sum{j in 1..FOODS} a[1,j] * x[j] = b[1];*/
s.t. calories: sum{j in 1..FOODS} a[2,j] * x[j] = b[2];
/*s.t.    fiber: sum{j in 1..FOODS} a[3,j] * x[j] = b[3];*/

/* nutrient ratio */
/*s.t.  protein_1_to_fiber_2:  sum{j in 1..FOODS} ( 1 * a[1,j] - 2 * a[3,j]) * x[j]  = 0;*/

/* food nutrient constraint */
/*s.t.    chicken: a[1,1] * x[1] = 300;*/

/* food nutrient percent */
/*s.t.  broccoli_is_50_pct_of_fiber:   2 * a[3,2] * x[2] - 1 * sum{j in 1..FOODS} a[3,j] * x[j] = 0;*/

/* food nutrient ratio */
/*s.t.    chicken_calories_to_rice_calories_ratio: 2 * a[2,1] * x[1] - 1 * a[2,3] * x[3] = 0;*/

data;

param       FOODS:= 3;
param   NUTRIENTS:= 3;
param CONSTRAINTS:= 3;

/* These are food coefficients */
/* Chicken, Broccoli, Rice */
/* Use this -> param cost (tr): */
param a: 1                   2                   3:=
       1 0.31020000000000000 0.00000000000000000 0.00000000000000000
       2 1.77924000000000020 0.30396000000000000 1.05214000000000000
       3 0.00000000000000000 0.03300000000000000 0.01800000000000000;
/* These are the constraint values*/
param : b :=
 1  100
 2 2000
 3   40;
end;

/*
ROW -> FOODS: CHICKEN, BROCCOLI, RICE
COL -> NUTRIENTS: PROTEIN, CALORIES, FIBER
*/

/* I need to know how many NUTRIENTS there are so I can create the parameters a and b */