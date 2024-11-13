CREATE VIEW MixInventoryDays
AS
SELECT a.mixid,
       b.name,
       a.days
FROM MixInventory a,
     Mix b
WHERE a.mixid = b.mixid
ORDER BY b.name
/

