package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.other.Reloader;
import io.github.xjrga.snack.database.callable.BackgroundExec;
import io.github.xjrga.snack.database.callable.select.MealPlanResultsCaloriesTask;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Utilities;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MealPlanCaloriesReport {

  enum Headers {
    Meal,
    Weight,
    eGross,
    eDigestible,
    eFat,
    eCarbs,
    eFatPlus,
    eProtein,
    eAlcohol
  }

  public MealPlanCaloriesReport() {
    //
  }

  public void create(MixDO mixDataObject) {
    try (FileWriter fileWriter = new FileWriter("models/mealplancalories.csv")) {
      StringBuilder comment = new StringBuilder();
      comment.append("For ");
      comment.append(mixDataObject.getName());
      CSVFormat csvFormat =
          CSVFormat.DEFAULT
              .builder()
              .setCommentMarker('#')
              .setHeaderComments(
                  "Meal Plan Calories Report", comment.toString(), LocalDateTime.now())
              .setHeader(Headers.class)
              .get();
      CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
      try {
        Future<List<List>> task =
            BackgroundExec.submit(new MealPlanResultsCaloriesTask(mixDataObject.getMixId()));
        List<List> list = task.get();
        List<List> rows = Reloader.getMealPlanCalories(list);
        rows.forEach(
            row -> {
              try {
                String meal = (String) row.get(0);
                BigDecimal weight = (BigDecimal) row.get(1);
                BigDecimal eGross = (BigDecimal) row.get(2);
                BigDecimal eDigestible = (BigDecimal) row.get(3);
                BigDecimal eFat = (BigDecimal) row.get(4);
                BigDecimal eCarbs = (BigDecimal) row.get(5);
                BigDecimal eFatPlus = (BigDecimal) row.get(6);
                BigDecimal eProtein = (BigDecimal) row.get(7);
                BigDecimal eAlcohol = (BigDecimal) row.get(8);
                csvPrinter.printRecord(
                    meal,
                    Utilities.strip(weight),
                    Utilities.strip(eGross),
                    Utilities.strip(eDigestible),
                    Utilities.strip(eFat),
                    Utilities.strip(eCarbs),
                    Utilities.strip(eFatPlus),
                    Utilities.strip(eProtein),
                    Utilities.strip(eAlcohol));
              } catch (Exception e) {
                LoggerImpl.INSTANCE.logProblem(e);
              }
            });
      } catch (Exception e) {
        LoggerImpl.INSTANCE.logProblem(e);
      }

    } catch (IOException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }
}
