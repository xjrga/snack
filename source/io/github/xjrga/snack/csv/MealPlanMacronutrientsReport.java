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

public class MealPlanMacronutrientsReport {

  enum Headers {
    Meal,
    Weight,
    Fat,
    Carbs,
    Protein,
    Complete,
    Alcohol,
    Fiber,
    Sodium,
    Potassium
  }

  public MealPlanMacronutrientsReport() {
    //
  }

  public void create(MixDO mixDataObject) {
    try (FileWriter fileWriter = new FileWriter("models/mealplanmacronutrients.csv")) {
      StringBuilder comment = new StringBuilder();
      comment.append("For ");
      comment.append(mixDataObject.getName());
      CSVFormat csvFormat =
          CSVFormat.DEFAULT
              .builder()
              .setCommentMarker('#')
              .setHeaderComments(
                  "Meal Plan Macronutrients Report", comment.toString(), LocalDateTime.now())
              .setHeader(Headers.class)
              .get();
      CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
      try {
        Future<List<List>> task =
            BackgroundExec.submit(new MealPlanResultsCaloriesTask(mixDataObject.getMixId()));
        List<List> results = task.get();
        List<List> rows = Reloader.getMealPlanMacronutrients(results);
        rows.forEach(
            row -> {
              try {
                String meal = (String) row.get(0);
                BigDecimal weight = (BigDecimal) row.get(1);
                BigDecimal fat = (BigDecimal) row.get(2);
                BigDecimal carbs = (BigDecimal) row.get(3);
                BigDecimal protein = (BigDecimal) row.get(4);
                BigDecimal complete = (BigDecimal) row.get(5);
                BigDecimal alcohol = (BigDecimal) row.get(6);
                BigDecimal fiber = (BigDecimal) row.get(7);
                BigDecimal sodium = (BigDecimal) row.get(8);
                BigDecimal potassium = (BigDecimal) row.get(9);
                csvPrinter.printRecord(
                    meal,
                    Utilities.strip(weight),
                    Utilities.strip(fat),
                    Utilities.strip(carbs),
                    Utilities.strip(protein),
                    Utilities.strip(complete),
                    Utilities.strip(alcohol),
                    Utilities.strip(fiber),
                    Utilities.strip(sodium),
                    Utilities.strip(potassium));
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
