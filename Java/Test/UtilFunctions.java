package com.Test;



import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class UtilFunctions {

    @Param({"X", ""})
    public String prefix;

    @State(Scope.Thread)
    public static class IterationEnvironment {

        private final AtomicInteger positive = new AtomicInteger(0);
        private final AtomicInteger negative = new AtomicInteger(0);

        IntStream getIntStream() {
            return IntStream.range(0, 10_000_000);
        }

        AtomicInteger getPositive() {
            return positive;
        }

        AtomicInteger getNegative() {
            return negative;
        }

    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void parseIntWithTryCatch(final IterationEnvironment iterationEnvironment, final Blackhole blackhole) {

        iterationEnvironment.getIntStream().forEach(value -> parseAndCatch(iterationEnvironment.getPositive(), iterationEnvironment.getNegative(), prefix, value));

        blackhole.consume(iterationEnvironment.getPositive().get());
        blackhole.consume(iterationEnvironment.getNegative().get());
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 2, time = 1)
    @Warmup(iterations = 1, time = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void isNumberWithRegex(final IterationEnvironment iterationEnvironment, final Blackhole blackhole) {

        iterationEnvironment.getIntStream().forEach(value -> matchWithRegex(iterationEnvironment.getPositive(), iterationEnvironment.getNegative(), prefix, value));

        blackhole.consume(iterationEnvironment.getPositive().get());
        blackhole.consume(iterationEnvironment.getNegative().get());
    }


    private void parseAndCatch(final AtomicInteger positive, final AtomicInteger negative, final String prefix, final int value) {

        final String s = prefix + value;
        try {
            positive.getAndAdd(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            negative.getAndAdd(value);
        }
    }

    private void matchWithRegex(final AtomicInteger positive, final AtomicInteger negative, final String prefix, final int value) {

        final String s = prefix + value;
        if (s.matches("\\d+")) {
            positive.getAndAdd(value);
        } else {
            negative.getAndAdd(value);
        }
    }



}
