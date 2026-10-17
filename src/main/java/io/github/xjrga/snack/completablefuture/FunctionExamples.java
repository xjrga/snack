package io.github.xjrga.snack.completablefuture;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author jr
 */
public class FunctionExamples {

    public Function<Double, Double> f0 = a -> {
        return 0.0;
    };

    public BiFunction<Double, Double, Double> f1 = (a, b) -> {
        return 0.0;
    };

    public Supplier<Double> s0 = () -> {
        return 0.0;
    };

    public Consumer<Double> c0 = a -> {
    };

    public BiConsumer<Double, Double> c1 = (a, b) -> {
    };

    public Runnable r0 = () -> {
    };

}
