CREATE PROCEDURE MixCost_merge (
IN v_Mixid LONGVARCHAR,
IN v_MixCost DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO MixCost USING ( VALUES (
v_Mixid,
v_MixCost
) ) ON (
Mixid = v_Mixid
)
WHEN MATCHED THEN UPDATE SET
MixCost = v_MixCost
WHEN NOT MATCHED THEN INSERT VALUES
v_Mixid,
v_MixCost;
END;
/