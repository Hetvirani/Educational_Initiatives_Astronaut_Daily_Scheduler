package com.astronaut.ui;

public class ConsoleUI {
  public static void displayWelcomeMessage() {
    System.out.println("\n╔═══════════════════════════════════════════╗");
    System.out.println("║ ASTRONAUT DAILY SCHEDULE ORGANIZER ║");
    System.out.println("║ Version 1.0 ║");
    System.out.println("╚═══════════════════════════════════════════╝\n");
  }

  public static void displaySystemInfo() {
    System.out.println("System Initialized Successfully");
    System.out.println("Design Patterns Implemented:");
    System.out.println(" ✓ Singleton Pattern (ScheduleManager)");
    System.out.println(" ✓ Factory Pattern (TaskFactory)");
    System.out.println(" ✓ Observer Pattern (Task Notifications)");
    System.out.println(" ✓ Strategy Pattern (Sorting Strategies)");
    System.out.println(" ✓ Decorator Pattern (Task Enhancement)");
    System.out.println(" ✓ Adapter Pattern (Time Format Conversion)");
    System.out.println();
  }
}
