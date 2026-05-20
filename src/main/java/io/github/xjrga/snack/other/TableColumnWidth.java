package io.github.xjrga.snack.other;

public enum TableColumnWidth {
    Food( 550 ),
    Nutrient( 350 ),
    Quantity( 90 ),
    Relationship( 21 ),
    Scrollbar( 28 );
    private final Integer width;


    TableColumnWidth( Integer width ) {
        this.width = width;
    }


    public Integer getWidth() {
        return width;
    }
}
// Food: 550
// Nutrient: 350
// Relationship: 21
// Quantity: 90
// Subtotal: 961
// Plus: 28
// Total: 989
//
// Quantity Text Box: new Dimension( 100, 25 )
