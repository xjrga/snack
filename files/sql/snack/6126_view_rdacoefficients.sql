CREATE VIEW public.rdacoefficients 
(
  nutrientid,
  lifestageid,
  cq,
  cul
)
AS
SELECT nutrientid,
       lifestageid,
       casewhen(q <= 0.0,0.0,1.0 / q) AS cq,
       casewhen(ul <= 0.0,0.0,1.0 / ul) AS cul
FROM public.rda;
/
