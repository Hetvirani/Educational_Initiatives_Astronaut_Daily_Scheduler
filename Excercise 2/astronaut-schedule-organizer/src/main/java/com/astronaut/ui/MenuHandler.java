package com.astronaut.ui;

import com.astronaut.exceptions.InvalidTimeException;
import com.astronaut.exceptions.TaskConflictException;
import com.astronaut.exceptions.TaskNotFoundException;
import com.astronaut.models.Priority;
import com.astronaut.models.Task;
import com.astronaut.patterns.structural.adapter.MilitaryTimeAdapter;
import com.astronaut.patterns.structural.adapter.StandardTimeAdapter;
import com.astronaut.services.TaskService;
import com.astronaut.utils.Logger;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
  private final TaskService taskService;
  private final Scanner scanner;
  private final Logger logger;
  private boolean running;

  public MenuHandler() {
    this.taskService = new TaskService();
    this.scanner = new Scanner(System.in);
    this.logger = Logger.getInstance();
    this.running = true;
  }

  public void start() {
    logger.info("Application started");
    System.out.println("===========================================");
    System.out.println(" ASTRONAUT DAILY SCHEDULE ORGANIZER");
    System.out.println("===========================================\n");

    while (running) {
      try {
        displayMenu();
        int choice = getIntInput("Enter your choice: ");
        processChoice(choice);
      } catch (Exception e) {
        logger.error("Error in menu handler: " + e.getMessage());
        System.out.println("❌ Error: " + e.getMessage() + "\n");
      }
    }

    scanner.close();
    logger.info("Application terminated");
  }

  private void displayMenu() {
    System.out.println("\n========== MAIN MENU ==========");
    System.out.println("1. Add Task");
    System.out.println("2. Add Task (Military Time)");
    System.out.println("3. Add Task (Standard Time)");
    System.out.println("4. Remove Task");
    System.out.println("5. Update Task");
    System.out.println("6. Mark Task Completed");
    System.out.println("7. View All Tasks");
    System.out.println("8. View Tasks by Priority");
    System.out.println("9. Sort by Start Time");
    System.out.println("10. Sort by Priority");
    System.out.println("11. Add Task with Reminder");
    System.out.println("12. Add Task with Notes");
    System.out.println("0. Exit");
    System.out.println("===============================");
  }

  private void processChoice(int choice) {
    switch (choice) {
      case 1 -> addTask();
      case 2 -> addTaskMilitaryTime();
      case 3 -> addTaskStandardTime();
      case 4 -> removeTask();
      case 5 -> updateTask();
      case 6 -> markTaskCompleted();
      case 7 -> viewAllTasks();
      case 8 -> viewTasksByPriority();
      case 9 -> sortByStartTime();
      case 10 -> sortByPriority();
      case 11 -> addTaskWithReminder();
      case 12 -> addTaskWithNotes();
      case 0 -> exitApplication();
      default -> System.out.println("❌ Invalid choice. Please try again.");
    }
  }

  private void addTask() {
    try {
      System.out.println("\n--- Add New Task ---");
      String description = getStringInput("Description: ");
      String startTime = getStringInput("Start Time (HH:mm, e.g., 09:00): ");
      String endTime = getStringInput("End Time (HH:mm, e.g., 10:00): ");
      String priority = getStringInput("Priority (LOW/MEDIUM/HIGH/CRITICAL): ");

      taskService.addTask(description, startTime, endTime, priority);
      System.out.println("✅ Task added successfully!\n");
    } catch (InvalidTimeException | TaskConflictException e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void addTaskMilitaryTime() {
    try {
      System.out.println("\n--- Add Task (Military Time Format) ---");
      String description = getStringInput("Description: ");
      String startTime = getStringInput("Start Time (HHmm, e.g., 0900): ");
      String endTime = getStringInput("End Time (HHmm, e.g., 1000): ");
      String priority = getStringInput("Priority (LOW/MEDIUM/HIGH/CRITICAL): ");

      taskService.addTaskWithAdapter(description, startTime, endTime, priority, new MilitaryTimeAdapter());
      System.out.println("✅ Task added successfully!\n");
    } catch (Exception e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void addTaskStandardTime() {
    try {
      System.out.println("\n--- Add Task (Standard Time Format) ---");
      String description = getStringInput("Description: ");
      String startTime = getStringInput("Start Time (h:mm AM/PM, e.g., 9:00 AM): ");
      String endTime = getStringInput("End Time (h:mm AM/PM, e.g., 10:00 AM): ");
      String priority = getStringInput("Priority (LOW/MEDIUM/HIGH/CRITICAL): ");

      taskService.addTaskWithAdapter(description, startTime, endTime, priority, new StandardTimeAdapter());
      System.out.println("✅ Task added successfully!\n");
    } catch (Exception e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void removeTask() {
    try {
      System.out.println("\n--- Remove Task ---");
      String description = getStringInput("Task Description: ");
      taskService.removeTask(description);
      System.out.println("✅ Task removed successfully!\n");
    } catch (TaskNotFoundException e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void updateTask() {
    try {
      System.out.println("\n--- Update Task ---");
      String oldDescription = getStringInput("Current Task Description: ");
      String newDescription = getStringInput("New Description: ");
      String startTime = getStringInput("New Start Time (HH:mm): ");
      String endTime = getStringInput("New End Time (HH:mm): ");
      String priority = getStringInput("New Priority (LOW/MEDIUM/HIGH/CRITICAL): ");

      taskService.updateTask(oldDescription, newDescription, startTime, endTime, priority);
      System.out.println("✅ Task updated successfully!\n");
    } catch (InvalidTimeException | TaskNotFoundException | TaskConflictException e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void markTaskCompleted() {
    try {
      System.out.println("\n--- Mark Task as Completed ---");
      String description = getStringInput("Task Description: ");
      taskService.markTaskCompleted(description);
      System.out.println("✅ Task marked as completed!\n");
    } catch (TaskNotFoundException e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void viewAllTasks() {
    System.out.println("\n========== ALL TASKS ==========");
    List<Task> tasks = taskService.viewAllTasks();
    if (tasks.isEmpty()) {
      System.out.println("No tasks scheduled for the day.");
    } else {
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println((i + 1) + ". " + tasks.get(i));
      }
    }
    System.out.println("==============================\n");
  }

  private void viewTasksByPriority() {
    try {
      System.out.println("\n--- View Tasks by Priority ---");
      String priorityStr = getStringInput("Priority (LOW/MEDIUM/HIGH/CRITICAL): ");
      Priority priority = Priority.fromString(priorityStr);

      List<Task> tasks = taskService.viewTasksByPriority(priority);
      System.out.println("\n========== " + priority + " PRIORITY TASKS ==========");
      if (tasks.isEmpty()) {
        System.out.println("No tasks found for this priority.");
      } else {
        for (int i = 0; i < tasks.size(); i++) {
          System.out.println((i + 1) + ". " + tasks.get(i));
        }
      }
      System.out.println("===========================================\n");
    } catch (IllegalArgumentException e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void sortByStartTime() {
    taskService.setSortByStartTime();
    System.out.println("✅ Tasks will now be sorted by Start Time\n");
  }

  private void sortByPriority() {
    taskService.setSortByPriority();
    System.out.println("✅ Tasks will now be sorted by Priority\n");
  }

  private void addTaskWithReminder() {
    try {
      System.out.println("\n--- Add Task with Reminder ---");
      String description = getStringInput("Description: ");
      String startTime = getStringInput("Start Time (HH:mm): ");
      String endTime = getStringInput("End Time (HH:mm): ");
      String priority = getStringInput("Priority (LOW/MEDIUM/HIGH/CRITICAL): ");
      int reminderMinutes = getIntInput("Reminder (minutes before): ");

      Task decoratedTask =
          taskService.addTaskWithReminder(description, startTime, endTime, priority, reminderMinutes);
      System.out.println("✅ Task added with reminder!");
      System.out.println(" " + decoratedTask + "\n");
    } catch (Exception e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void addTaskWithNotes() {
    try {
      System.out.println("\n--- Add Task with Notes ---");
      String description = getStringInput("Description: ");
      String startTime = getStringInput("Start Time (HH:mm): ");
      String endTime = getStringInput("End Time (HH:mm): ");
      String priority = getStringInput("Priority (LOW/MEDIUM/HIGH/CRITICAL): ");
      String notes = getStringInput("Notes: ");

      Task decoratedTask =
          taskService.addTaskWithNotes(description, startTime, endTime, priority, notes);
      System.out.println("✅ Task added with notes!");
      System.out.println(" " + decoratedTask + "\n");
    } catch (Exception e) {
      System.out.println("❌ " + e.getMessage() + "\n");
    }
  }

  private void exitApplication() {
    System.out.println("\nThank you for using Astronaut Schedule Organizer!");
    System.out.println("Total tasks managed: " + taskService.getTaskCount());
    System.out.println("Goodbye! 🚀\n");
    running = false;
  }

  private String getStringInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine().trim();
  }

  private int getIntInput(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("❌ Invalid input. Please enter a number.");
      }
    }
  }
}
