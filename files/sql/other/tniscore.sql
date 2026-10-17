--Foods
--0:708.2922224109734
--1:1039.1472912773665
--2:327.43942370661426

--Deficiencies
--Calcium
--3:669.1367211119588
--Magnesium
--4:0.0
--Potassium
--5:0.0
--Sodium
--6:997.765796832967
--Vit A
--7:321.87104637288894
--Vit E
--8:1.1950394918536356
--Vit D
--9:15.0
--Vit C
--10:0.0
--Choline
--11:0.0

--Excesses
--12:0.0
--13:245.33821436472616
--14:849.2510288555505
--15:0.0
--16:0.0
--17:0.0
--18:0.0
--19:369.6816523447221
--20:194.39424999348654

--Averages
--21:0.30795752382526537
--22:0.1045942630236194
select 
getCalciumPctOfRda(22) as Ca,
getMagnesiumPctOfRda(22) as Mg,
getPotassiumPctOfRda(22) as K,
getVitAPctOfRda(22) as VitA,
getVitEPctOfRda(22) as VitE,
getVitDPctOfRda(22) as VitD,
getVitCPctOfRda(22) as VitC,
getCholinePctOfRda(22) as Chol,
1 - ((
getCalciumPctOfRda(22) +
getMagnesiumPctOfRda(22) +
getPotassiumPctOfRda(22) +
getVitAPctOfRda(22) +
getVitEPctOfRda(22) +
getVitDPctOfRda(22) +
getVitCPctOfRda(22) +
getCholinePctOfRda(22) ) / CAST (8.0 AS DECIMAL(25,18)) ) as TniScore,
((1 - getCalciumPctOfRda(22)) +
(1 - getMagnesiumPctOfRda(22)) +
(1 - getPotassiumPctOfRda(22)) +
(1 - getVitAPctOfRda(22)) +
(1 - getVitEPctOfRda(22)) +
(1 - getVitDPctOfRda(22)) +
(1 - getVitCPctOfRda(22)) +
(1 - getCholinePctOfRda(22))) / CAST (8.0 AS DECIMAL(25,18))  as TniScore2,
(
getCalciumPctOfRda(22) +
getMagnesiumPctOfRda(22) +
getPotassiumPctOfRda(22) +
getSodiumPctOfRda(22) +
getVitAPctOfRda(22) +
getVitEPctOfRda(22) +
getVitDPctOfRda(22) +
getVitCPctOfRda(22) +
getCholinePctOfRda(22) ) / CAST (9.0 AS DECIMAL(25,18)) as AvgDeficiency

from (VALUES(0));
/
