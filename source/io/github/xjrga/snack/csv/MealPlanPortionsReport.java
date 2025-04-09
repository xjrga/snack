package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.MealPlanPortionsTask;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MealPlanPortionsReport {

  enum Headers {
    MixId,
    MealId,
    FoodId,
    Meal,
    Food,
    Pct,
    ExpectedWt,
    ActualWt,
    MealOrder
  }

  public MealPlanPortionsReport() {
    //
  }

  public void create(MixDO mixDataObject) {
    try (FileWriter fileWriter = new FileWriter("models/mealplanportions.csv")) {
      StringBuilder comment = new StringBuilder();
      comment.append("For ");
      comment.append(mixDataObject.getName());
      CSVFormat csvFormat =
          CSVFormat.DEFAULT
              .builder()
              .setCommentMarker('#')
              .setHeaderComments(
                  "Meal Plan Portions Report", comment.toString(), LocalDateTime.now())
              .setHeader(Headers.class)
              .get();
      CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
      Future<List<List>> task = BackgroundExec.submit(new MealPlanPortionsTask(mixDataObject.getMixId()));
      List<List> portions = task.get();
      portions.forEach(
          row -> {
            try {
              String mixid = (String) row.get(0);
              Integer mealid = (Integer) row.get(1);
              String foodid = (String) row.get(2);
              String meal = (String) row.get(3);
              String food = (String) row.get(4);
              BigDecimal pct = (BigDecimal) row.get(5);
              BigDecimal expectedwt = (BigDecimal) row.get(6);
              BigDecimal actualwt = (BigDecimal) row.get(7);
              Integer mealorder = (Integer) row.get(8);
              csvPrinter.printRecord(
                  mixid,
                  mealid,
                  foodid,
                  meal,
                  food,
                  Utilities.strip(pct),
                  Utilities.strip(expectedwt),
                  Utilities.strip(actualwt),
                  mealorder);
            } catch (Exception e) {
              LoggerImpl.INSTANCE.logProblem(e);
            }
          });

    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }
}
