package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.jcomponents.TableMix;
import io.github.xjrga.snack.jcomponents.TableMixDiff;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MixComparisonReport {

  enum Headers {
    Category,
    Nutrient,
    MixA,
    MixB,
    Difference
  }

  public MixComparisonReport() {}

  public void create(TableMixDiff tblMixDiff, TableMix tblMixA, TableMix tblMixB) {
    try (FileWriter fileWriter = new FileWriter("models/mixcomparison.csv")) {
      TableMix.Row rowa = tblMixA.getSelectedValue();
      TableMix.Row rowb = tblMixB.getSelectedValue();
      StringBuilder comment = new StringBuilder();
      comment.append(rowa.getMixname()).append(" VS ").append("\n");
      comment.append(rowb.getMixname());
      CSVFormat csvFormat =
          CSVFormat.DEFAULT
              .builder()
              .setCommentMarker('#')
              .setHeaderComments("Mix Comparison Report", comment.toString(), LocalDateTime.now())
              .setHeader(Headers.class)
              .get();
      CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
      for (int j = 0; j < tblMixDiff.getRowCount(); j++) {
        String category = (String) tblMixDiff.getValueAt(j, 0);
        String nutrient = (String) tblMixDiff.getValueAt(j, 1);
        BigDecimal mixa = ((BigDecimal) tblMixDiff.getValueAt(j, 2));
        BigDecimal mixb = ((BigDecimal) tblMixDiff.getValueAt(j, 3));
        BigDecimal diff = ((BigDecimal) tblMixDiff.getValueAt(j, 4));
        csvPrinter.printRecord(
            category,
            nutrient,
            Utilities.strip(mixa),
            Utilities.strip(mixb),
            Utilities.strip(diff));
      }
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }
}
