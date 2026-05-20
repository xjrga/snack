package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.Connect;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class AllFoodsReportDn {

    private final Connection connection;


    public AllFoodsReportDn() {
        connection = Connect.getInstance().getConnection();
    }


    public void create() {
        try ( FileWriter fileWriter = new FileWriter( "models/allfoodsdn.csv" ) ) {
            CallableStatement proc = connection.prepareCall( "{CALL public.Food_Select_Details_Exp()}" );
            ResultSet rs = proc.executeQuery();
            StringBuilder comment = new StringBuilder();
            comment.append( "Nutritional Values For Common Foods And Products" );
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker( '#' )
                    .setHeaderComments( "All Foods Report Denormalized", comment.toString(), LocalDateTime.now() )
                    .setHeader( rs )
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter( fileWriter, csvFormat );
            while ( rs.next() ) {
                //food_id
                String x1 = rs.getString( 1 );
                //food_name
                String x2 = rs.getString( 2 );
                //carbohydrates_carbs_by_diff
                BigDecimal x3 = rs.getBigDecimal( 3 );
                //carbohydrates_digestible
                BigDecimal x4 = rs.getBigDecimal( 4 );
                //carbohydrates_fiber
                BigDecimal x5 = rs.getBigDecimal( 5 );
                //carbohydrates_fiber_insoluble
                BigDecimal x6 = rs.getBigDecimal( 6 );
                //carbohydrates_fiber_soluble
                BigDecimal x7 = rs.getBigDecimal( 7 );
                //carbohydrates_fructose
                BigDecimal x8 = rs.getBigDecimal( 8 );
                //carbohydrates_glucose
                BigDecimal x9 = rs.getBigDecimal( 9 );
                //carbohydrates_glycemic_load
                BigDecimal x10 = rs.getBigDecimal( 10 );
                //carbohydrates_lactose
                BigDecimal x11 = rs.getBigDecimal( 11 );
                //carbohydrates_starch
                BigDecimal x12 = rs.getBigDecimal( 12 );
                //carbohydrates_sucrose
                BigDecimal x13 = rs.getBigDecimal( 13 );
                //carbohydrates_sugars
                BigDecimal x14 = rs.getBigDecimal( 14 );
                //energy_alcohol
                BigDecimal x15 = rs.getBigDecimal( 15 );
                //energy_carbohydrate
                BigDecimal x16 = rs.getBigDecimal( 16 );
                //energy_dha
                BigDecimal x17 = rs.getBigDecimal( 17 );
                //energy_digestible
                BigDecimal x18 = rs.getBigDecimal( 18 );
                //energy_epa
                BigDecimal x19 = rs.getBigDecimal( 19 );
                //energy_fat
                BigDecimal x20 = rs.getBigDecimal( 20 );
                //energy_fat_and_carbohydrate
                BigDecimal x21 = rs.getBigDecimal( 21 );
                //energy_gross
                BigDecimal x22 = rs.getBigDecimal( 22 );
                //energy_hcsfa
                BigDecimal x23 = rs.getBigDecimal( 23 );
                //energy_lcn3pufa
                BigDecimal x24 = rs.getBigDecimal( 24 );
                //energy_linoleic
                BigDecimal x25 = rs.getBigDecimal( 25 );
                //energy_linolenic
                BigDecimal x26 = rs.getBigDecimal( 26 );
                //energy_monounsaturated
                BigDecimal x27 = rs.getBigDecimal( 27 );
                //energy_polyunsaturated
                BigDecimal x28 = rs.getBigDecimal( 28 );
                //energy_protein
                BigDecimal x29 = rs.getBigDecimal( 29 );
                //energy_protein_and_carbohydrate
                BigDecimal x30 = rs.getBigDecimal( 30 );
                //energy_saturated
                BigDecimal x31 = rs.getBigDecimal( 31 );
                //fats_cholesterol
                BigDecimal x32 = rs.getBigDecimal( 32 );
                //fats_dha
                BigDecimal x33 = rs.getBigDecimal( 33 );
                //fats_epa
                BigDecimal x34 = rs.getBigDecimal( 34 );
                //fats_hcsfa
                BigDecimal x35 = rs.getBigDecimal( 35 );
                //fats_lauric
                BigDecimal x36 = rs.getBigDecimal( 36 );
                //fats_lcn3pufa
                BigDecimal x37 = rs.getBigDecimal( 37 );
                //fats_linoleic
                BigDecimal x38 = rs.getBigDecimal( 38 );
                //fats_linolenic
                BigDecimal x39 = rs.getBigDecimal( 39 );
                //fats_monounsaturated
                BigDecimal x40 = rs.getBigDecimal( 40 );
                //fats_myristic
                BigDecimal x41 = rs.getBigDecimal( 41 );
                //fats_palmitic
                BigDecimal x42 = rs.getBigDecimal( 42 );
                //fats_polyunsaturated
                BigDecimal x43 = rs.getBigDecimal( 43 );
                //fats_saturated
                BigDecimal x44 = rs.getBigDecimal( 44 );
                //fats_stearic
                BigDecimal x45 = rs.getBigDecimal( 45 );
                //fats_total
                BigDecimal x46 = rs.getBigDecimal( 46 );
                //minerals_calcium
                BigDecimal x47 = rs.getBigDecimal( 47 );
                //minerals_copper
                BigDecimal x48 = rs.getBigDecimal( 48 );
                //minerals_iron
                BigDecimal x49 = rs.getBigDecimal( 49 );
                //minerals_magnesium
                BigDecimal x50 = rs.getBigDecimal( 50 );
                //minerals_manganese
                BigDecimal x51 = rs.getBigDecimal( 51 );
                //minerals_phosphorus
                BigDecimal x52 = rs.getBigDecimal( 52 );
                //minerals_potassium
                BigDecimal x53 = rs.getBigDecimal( 53 );
                //minerals_selenium
                BigDecimal x54 = rs.getBigDecimal( 54 );
                //minerals_sodium
                BigDecimal x55 = rs.getBigDecimal( 55 );
                //minerals_zinc
                BigDecimal x56 = rs.getBigDecimal( 56 );
                //other_alcohol
                BigDecimal x57 = rs.getBigDecimal( 57 );
                //other_cost
                BigDecimal x58 = rs.getBigDecimal( 58 );
                //other_water
                BigDecimal x59 = rs.getBigDecimal( 59 );
                //other_weight
                BigDecimal x60 = rs.getBigDecimal( 60 );
                //phytonutrients_anthocyanins
                BigDecimal x61 = rs.getBigDecimal( 61 );
                //phytonutrients_beta_carotene
                BigDecimal x62 = rs.getBigDecimal( 62 );
                //phytonutrients_caffeine
                BigDecimal x63 = rs.getBigDecimal( 63 );
                //phytonutrients_carotenoids
                BigDecimal x64 = rs.getBigDecimal( 64 );
                //phytonutrients_flavanols
                BigDecimal x65 = rs.getBigDecimal( 65 );
                //phytonutrients_flavanones
                BigDecimal x66 = rs.getBigDecimal( 66 );
                //phytonutrients_flavones
                BigDecimal x67 = rs.getBigDecimal( 67 );
                //phytonutrients_flavonoids
                BigDecimal x68 = rs.getBigDecimal( 68 );
                //phytonutrients_flavonols
                BigDecimal x69 = rs.getBigDecimal( 69 );
                //phytonutrients_gamma_tocopherol
                BigDecimal x70 = rs.getBigDecimal( 70 );
                //phytonutrients_isoflavones
                BigDecimal x71 = rs.getBigDecimal( 71 );
                //phytonutrients_lutein_zeaxanthin
                BigDecimal x72 = rs.getBigDecimal( 72 );
                //phytonutrients_lycopene
                BigDecimal x73 = rs.getBigDecimal( 73 );
                //phytonutrients_phytosterols
                BigDecimal x74 = rs.getBigDecimal( 74 );
                //phytonutrients_theobromine
                BigDecimal x75 = rs.getBigDecimal( 75 );
                //protein_complete
                BigDecimal x76 = rs.getBigDecimal( 76 );
                //protein_total
                BigDecimal x77 = rs.getBigDecimal( 77 );
                //vitamins_choline
                BigDecimal x78 = rs.getBigDecimal( 78 );
                //vitamins_folate
                BigDecimal x79 = rs.getBigDecimal( 79 );
                //vitamins_niacin
                BigDecimal x80 = rs.getBigDecimal( 80 );
                //vitamins_pantothenic_acid
                BigDecimal x81 = rs.getBigDecimal( 81 );
                //vitamins_riboflavin
                BigDecimal x82 = rs.getBigDecimal( 82 );
                //vitamins_thiamin
                BigDecimal x83 = rs.getBigDecimal( 83 );
                //vitamins_vitamin_a
                BigDecimal x84 = rs.getBigDecimal( 84 );
                //vitamins_vitamin_b6
                BigDecimal x85 = rs.getBigDecimal( 85 );
                //vitamins_vitamin_b12
                BigDecimal x86 = rs.getBigDecimal( 86 );
                //vitamins_vitamin_c
                BigDecimal x87 = rs.getBigDecimal( 87 );
                //vitamins_vitamin_d
                BigDecimal x88 = rs.getBigDecimal( 88 );
                //vitamins_vitamin_e
                BigDecimal x89 = rs.getBigDecimal( 89 );
                //vitamins_vitamin_k
                BigDecimal x90 = rs.getBigDecimal( 90 );
                //
                csvPrinter.printRecord(
                        x1,
                        x2,
                        Utilities.strip( x3 ),
                        Utilities.strip( x4 ),
                        Utilities.strip( x5 ),
                        Utilities.strip( x6 ),
                        Utilities.strip( x7 ),
                        Utilities.strip( x8 ),
                        Utilities.strip( x9 ),
                        Utilities.strip( x10 ),
                        Utilities.strip( x11 ),
                        Utilities.strip( x12 ),
                        Utilities.strip( x13 ),
                        Utilities.strip( x14 ),
                        Utilities.strip( x15 ),
                        Utilities.strip( x16 ),
                        Utilities.strip( x17 ),
                        Utilities.strip( x18 ),
                        Utilities.strip( x19 ),
                        Utilities.strip( x20 ),
                        Utilities.strip( x21 ),
                        Utilities.strip( x22 ),
                        Utilities.strip( x23 ),
                        Utilities.strip( x24 ),
                        Utilities.strip( x25 ),
                        Utilities.strip( x26 ),
                        Utilities.strip( x27 ),
                        Utilities.strip( x28 ),
                        Utilities.strip( x29 ),
                        Utilities.strip( x30 ),
                        Utilities.strip( x31 ),
                        Utilities.strip( x32 ),
                        Utilities.strip( x33 ),
                        Utilities.strip( x34 ),
                        Utilities.strip( x35 ),
                        Utilities.strip( x36 ),
                        Utilities.strip( x37 ),
                        Utilities.strip( x38 ),
                        Utilities.strip( x39 ),
                        Utilities.strip( x40 ),
                        Utilities.strip( x41 ),
                        Utilities.strip( x42 ),
                        Utilities.strip( x43 ),
                        Utilities.strip( x44 ),
                        Utilities.strip( x45 ),
                        Utilities.strip( x46 ),
                        Utilities.strip( x47 ),
                        Utilities.strip( x48 ),
                        Utilities.strip( x49 ),
                        Utilities.strip( x50 ),
                        Utilities.strip( x51 ),
                        Utilities.strip( x52 ),
                        Utilities.strip( x53 ),
                        Utilities.strip( x54 ),
                        Utilities.strip( x55 ),
                        Utilities.strip( x56 ),
                        Utilities.strip( x57 ),
                        Utilities.strip( x58 ),
                        Utilities.strip( x59 ),
                        Utilities.strip( x60 ),
                        Utilities.strip( x61 ),
                        Utilities.strip( x62 ),
                        Utilities.strip( x63 ),
                        Utilities.strip( x64 ),
                        Utilities.strip( x65 ),
                        Utilities.strip( x66 ),
                        Utilities.strip( x67 ),
                        Utilities.strip( x68 ),
                        Utilities.strip( x69 ),
                        Utilities.strip( x70 ),
                        Utilities.strip( x71 ),
                        Utilities.strip( x72 ),
                        Utilities.strip( x73 ),
                        Utilities.strip( x74 ),
                        Utilities.strip( x75 ),
                        Utilities.strip( x76 ),
                        Utilities.strip( x77 ),
                        Utilities.strip( x78 ),
                        Utilities.strip( x79 ),
                        Utilities.strip( x80 ),
                        Utilities.strip( x81 ),
                        Utilities.strip( x82 ),
                        Utilities.strip( x83 ),
                        Utilities.strip( x84 ),
                        Utilities.strip( x85 ),
                        Utilities.strip( x86 ),
                        Utilities.strip( x87 ),
                        Utilities.strip( x88 ),
                        Utilities.strip( x89 ),
                        Utilities.strip( x90 ) );
            }
        } catch ( Exception e ) {
            LoggerImpl.INSTANCE.logProblem( e );
        }
    }
}
