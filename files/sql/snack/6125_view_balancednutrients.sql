CREATE VIEW balancednutrients
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
WHERE balanced = 1;
/
