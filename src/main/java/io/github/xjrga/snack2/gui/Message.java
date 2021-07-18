package io.github.xjrga.snack2.gui;

import java.awt.image.BufferedImage;
import javax.swing.*;
import io.github.xjrga.snack2.other.ImageUtilities;

public class Message {

    private static final BufferedImage logo = ImageUtilities.readImage("resources/images/logo.png");

    public Message() {
    }

    public static void showMessage(String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog("Snack");
        dialog.setIconImage(logo);
        dialog.setVisible(true);
    }

    public static void showMessage(String title, String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setIconImage(logo);
        dialog.setVisible(true);
    }

    public static int showOptionDialog(JComponent[] inputs, String title) {
        JOptionPane optionPane = new JOptionPane(inputs, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setIconImage(logo);
        dialog.setVisible(true);
        //0 - Ok
        //2 - Cancel
        //null - x
        Object optionValue = optionPane.getValue();
        int value = -1;
        if (optionValue != null) {
            value = (int) optionValue;
        }
        return value;
    }

    public static int showOptionDialogYesNo(JComponent[] inputs, String title) {
        JOptionPane optionPane = new JOptionPane(inputs, JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setIconImage(logo);
        dialog.setVisible(true);
        //0 - Ok
        //2 - Cancel
        //null - x
        Object optionValue = optionPane.getValue();
        int value = -1;
        if (optionValue != null) {
            value = (int) optionValue;
        }
        return value;
    }

    public static int showOptionDialogOkCancel(JComponent[] inputs, String title) {
        JOptionPane optionPane = new JOptionPane(inputs, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setIconImage(logo);
        dialog.setVisible(true);
        //0 - Ok
        //2 - Cancel
        //null - x
        Object optionValue = optionPane.getValue();
        int value = -1;
        if (optionValue != null) {
            value = (int) optionValue;
        }
        return value;
    }

    public static void showMessage(JComponent[] inputs, String title) {
        JOptionPane optionPane = new JOptionPane(inputs, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setIconImage(logo);
        dialog.setVisible(true);
    }
}
