package com.astronaut;

import com.astronaut.patterns.behavioral.observer.ConflictNotifier;
import com.astronaut.patterns.creational.singleton.ScheduleManager;
import com.astronaut.ui.ConsoleUI;
import com.astronaut.ui.MenuHandler;
import com.astronaut.utils.Logger;

public class Main {
  public static void main(String[] args) {
    try {
      Logger logger = Logger.getInstance();
      logger.info("=".repeat(60));
      logger.info("APPLICATION STARTUP");
      logger.info("=".repeat(60));

      ConsoleUI.displayWelcomeMessage();
      ConsoleUI.displaySystemInfo();

      ScheduleManager scheduleManager = ScheduleManager.getInstance();
      scheduleManager.addObserver(new ConflictNotifier());

      MenuHandler menuHandler = new MenuHandler();
      menuHandler.start();
    } catch (Exception e) {
      System.err.println("Fatal error: " + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
  }
}
