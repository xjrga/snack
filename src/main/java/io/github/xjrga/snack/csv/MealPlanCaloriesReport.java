package io.github.xjrga.snack.csv;

import io.github.xjrga.snack.launcher.TaskLauncher;
import io.github.xjrga.snack.database.callable.select.MealPlanResultsTask;
import io.github.xjrga.snack.dataobject.MixDO;
import io.github.xjrga.snack.logger.LoggerImpl;
import io.github.xjrga.snack.other.Reloader;
import io.github.xjrga.snack.other.U;
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
        Egross,
        Edigest,
        Efat,
        Ecarbs,
        Efatcarbs,
        Eprotein,
        Ealcohol
    }

    public MealPlanCaloriesReport() {
        //
    }

    public void create(MixDO mixDataObject) {
        try (FileWriter fileWriter = new FileWriter("models/mealplancalories.csv")) {
            StringBuilder comment = new StringBuilder();
            comment.append("For ");
            comment.append(mixDataObject.getName());
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .builder()
                    .setCommentMarker('#')
                    .setHeaderComments("Meal Plan Calories Report", comment.toString(), LocalDateTime.now())
                    .setHeader(Headers.class)
                    .get();
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
            try {
                Future<List<List>> task = TaskLauncher.submit(new MealPlanResultsTask(mixDataObject.getMixid()));
                List<List> list = task.get();
                List<List> rows = Reloader.getMealPlanCalories(list);
                rows.forEach(row -> {
                    try {
                        // meal
                        String meal = (String) row.get(0);
                        // weight
                        BigDecimal weight = (BigDecimal) row.get(1);
                        // egross
                        BigDecimal egross = (BigDecimal) row.get(2);
                        // edigest
                        BigDecimal edigest = (BigDecimal) row.get(3);
                        // efat
                        BigDecimal efat = (BigDecimal) row.get(4);
                        // ecarbs
                        BigDecimal ecarbs = (BigDecimal) row.get(5);
                        // efatcarbs
                        BigDecimal efatcarbs = (BigDecimal) row.get(6);
                        // eprotein
                        BigDecimal eprotein = (BigDecimal) row.get(7);
                        // ealcohol
                        BigDecimal ealcohol = (BigDecimal) row.get(8);
                        csvPrinter.printRecord(meal,
                                U.strip(weight),
                                U.strip(egross),
                                U.strip(edigest),
                                U.strip(efat),
                                U.strip(ecarbs),
                                U.strip(efatcarbs),
                                U.strip(eprotein),
                                U.strip(ealcohol)
                        );
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
