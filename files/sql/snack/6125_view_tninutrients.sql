CREATE VIEW tninutrients 
(
  nutrientid,
  name,
  label,
  units
)
AS
SELECT nutrientid,
       name,
       label,
       units
FROM public.nutrient
WHERE (nutrientid = '301' OR nutrientid = '304' OR nutrientid = '306' OR nutrientid = '320' OR nutrientid = '323' OR nutrientid = '328' OR nutrientid = '401' OR nutrientid = '421');
/
