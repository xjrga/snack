package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.jcomponents.TableFood;
import io.github.xjrga.snack.jcomponents.TableFoodDiff;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class FoodComparisonReport {

    enum Headers {
        Category,
        Nutrient,
        FoodA,
        FoodB,
        Difference
    }


    public FoodComparisonReport() {
    }


    public void create( TableFoodDiff modelTableFoodDiff, TableFood tableCompareA, TableFood tableCompareB ) {
        try ( FileWriter fileWriter = new FileWriter( "models/foodcomparison.csv" ) ) {
            StringBuilder comment = new StringBuilder();
            comment.append( tableCompareA.getSelectedValue().getFoodname() )
                    .append( " VS " )
                    .append( "\n" );
            comment.append( tableCompareB.getSelectedValue().getFoodname() );
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker( '#' )
                    .setHeaderComments( "Food Comparison Report", comment.toString(), LocalDateTime.now() )
                    .setHeader( Headers.class )
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );
            for ( int j = 0; j < modelTableFoodDiff.getRowCount(); j++ ) {
                String category = ( String ) modelTableFoodDiff.getValueAt( j, 0 );
                String nutrient = ( String ) modelTableFoodDiff.getValueAt( j, 1 );
                BigDecimal fooda = ( ( BigDecimal ) modelTableFoodDiff.getValueAt( j, 2 ) );
                BigDecimal foodb = ( ( BigDecimal ) modelTableFoodDiff.getValueAt( j, 3 ) );
                BigDecimal diff = ( ( BigDecimal ) modelTableFoodDiff.getValueAt( j, 4 ) );
                csvPrinter.printRecord(
                        category, nutrient, Utilities.strip( fooda ), Utilities.strip( foodb ), Utilities.strip( diff ) );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
