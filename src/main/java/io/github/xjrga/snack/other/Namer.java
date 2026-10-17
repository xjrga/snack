package io.github.xjrga.snack.other;

/**
 *
 * @author jr
 */
public class Namer {

    private static boolean print = false;

    public static void on() {
        print = true;
    }

    public static void threadName(String name) {
        if (print) {
            System.out.println(name + ": " + Thread.currentThread().getName());
        };
    }

    public static void separator() {
        if (print) {
            System.out.println("**********************");
            System.out.println("");
        }

    }

}
