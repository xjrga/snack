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
WHERE tni = 1;
/
