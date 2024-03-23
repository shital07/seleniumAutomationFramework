package com.learn.reports;

import com.learn.enums.LogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public class FrameworkLogger {
    private FrameworkLogger() {

    }

    private static Consumer<String> PASS = (message) -> ExtendReportManager.getExTest().pass(message);
    private static Consumer<String> FAIL = (message) -> ExtendReportManager.getExTest().fail(message);
    private static Consumer<String> SKIP = (message) -> ExtendReportManager.getExTest().skip(message);
    private static Consumer<String> INFO = (message) -> ExtendReportManager.getExTest().info(message);
    private static Consumer<String> CONSOLE = (message) -> System.out.println(message);
    private static Consumer<String> EXTENDANDCONSOLE = PASS.andThen(CONSOLE);

    private static Map<LogType, Consumer<String>> mp = new EnumMap<>(LogType.class);

    static {

        mp.put(LogType.PASS, PASS);
        mp.put(LogType.FAIL, FAIL);
        mp.put(LogType.SKIP, SKIP);
        mp.put(LogType.INFO, INFO);
        mp.put(LogType.CONSOLE, CONSOLE);
        mp.put(LogType.EXTENDANDCONSOLE, EXTENDANDCONSOLE);


    }

    public static void log(LogType type, String message) {
        System.out.println("hi");
        mp.get(type).accept(message);
    }


}

