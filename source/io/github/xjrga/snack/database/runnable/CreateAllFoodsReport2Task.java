package io.github.xjrga.snack.database.runnable;

import io.github.xjrga.snack.csv.AllFoodsReport2;
import io.github.xjrga.snack.gui.Message;
import io.github.xjrga.snack.logger.LoggerImpl;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author jr
 */
public class CreateAllFoodsReport2Task implements Runnable {

  private final JFrame frm;

  public CreateAllFoodsReport2Task(JFrame frm) {
    this.frm = frm;
  }

  @Override
  public void run() {
    try {
      (new AllFoodsReport2()).create();
    } catch (Exception e) {
      LoggerImpl.INSTANCE.logProblem(e);
    } finally {
      Runnable r =
          () -> {
            frm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            Message.showMessage("All Foods Report #2 created.");
          };
      SwingUtilities.invokeLater(r);
    }
  }
}
