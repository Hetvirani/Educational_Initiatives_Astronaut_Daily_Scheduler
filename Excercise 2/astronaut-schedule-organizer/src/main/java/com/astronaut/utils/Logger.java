package com.astronaut.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
  private static Logger instance;
  private static final String LOG_FILE = "logs/application.log";
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  private Logger() {
    // Create logs directory if it doesn't exist
    new java.io.File("logs").mkdirs();
  }

  public static Logger getInstance() {
    if (instance == null) {
      synchronized (Logger.class) {
        if (instance == null) {
          instance = new Logger();
        }
      }
    }
    return instance;
  }

  public void info(String message) {
    log("INFO", message);
  }

  public void error(String message) {
    log("ERROR", message);
  }

  public void warn(String message) {
    log("WARN", message);
  }

  public void debug(String message) {
    log("DEBUG", message);
  }

  private void log(String level, String message) {
    String timestamp = LocalDateTime.now().format(formatter);
    String logMessage = String.format("[%s] [%s] %s", timestamp, level, message);

    // Console output
    System.out.println(logMessage);

    // File output
    try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
      writer.println(logMessage);
    } catch (IOException e) {
      System.err.println("Failed to write to log file: " + e.getMessage());
    }
  }
}
