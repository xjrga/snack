CREATE PROCEDURE Relationship_Insert (
IN v_RelationshipId INTEGER,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Relationship (
RelationshipId,
Name
) VALUES (
v_RelationshipId,
v_Name
);
END;
/
