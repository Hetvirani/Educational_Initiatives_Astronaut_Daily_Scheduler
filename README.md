# Astronaut Daily Schedule Organizer

A console-based task management application demonstrating advanced Java design patterns and SOLID principles.

---

## 🚀 Project Overview

This project is a comprehensive solution for **Exercise 1** (Design Patterns Showcase) and **Exercise 2** (Astronaut Schedule Organizer) demonstrating expertise in:

* 6 Design Patterns (2 Behavioral, 2 Creational, 2 Structural)
* SOLID Principles
* Clean Architecture
* Enterprise-grade Error Handling
* Comprehensive Logging

---

## 📋 Features

### Core Functionality

* Add, remove, update, and view tasks
* Automatic conflict detection
* Task completion tracking
* Priority-based filtering
* Multiple time format support (24-hour, Military, Standard AM/PM)
* Task reminders and notes
* Flexible sorting strategies

### Quality Standards

* Exception handling at all levels
* Input validation
* File-based logging system
* Defensive programming practices
* Zero hard-coded boolean loops
* Performance optimized

---

## 🎨 Design Patterns Implemented

### Behavioral Patterns

#### 1. Observer Pattern – Task Conflict Notification System

<img src="./BehavioralPattern.jpg" alt="Behavioral Pattern Diagram" width="400" height="400"/>

* **Purpose:** Automatically notify users when task conflicts occur
* **Implementation:**

  * `TaskObserver` interface
  * `ConflictNotifier` concrete observer
  * `TaskSubject` manages observer subscriptions
* **Location:** `com.astronaut.patterns.behavioral.observer`

#### 2. Strategy Pattern – Dynamic Task Sorting

* **Purpose:** Switch between different sorting algorithms at runtime
* **Strategies:**

  * `StartTimeSortStrategy` – Sort by start time
  * `PrioritySortStrategy` – Sort by priority level
* **Location:** `com.astronaut.patterns.behavioral.strategy`

---

### Creational Patterns

<img src="./CreationalPattern.drawio.png" alt="Creational Pattern Diagram" width="400" height="400"/>

#### 3. Singleton Pattern – Schedule Manager

* **Purpose:** Ensure single instance of the schedule manager throughout the application
* **Features:**

  * Thread-safe double-checked locking
  * Centralized task management
* **Location:** `com.astronaut.patterns.creational.singleton.ScheduleManager`

#### 4. Factory Pattern – Task Creation with Validation

* **Purpose:** Encapsulate task object creation with validation logic
* **Components:**

  * `TaskFactory` – Creates validated task objects
  * `TaskValidator` – Validates all task inputs
* **Location:** `com.astronaut.patterns.creational.factory`

---

### Structural Patterns

<img src="./StructuralPattern.drawio.png" alt="Structural Pattern Diagram" width="400" height="400"/>

#### 5. Decorator Pattern – Enhanced Task Features

* **Purpose:** Dynamically add features to tasks without modifying the base class
* **Decorators:**

  * `ReminderDecorator` – Adds reminder functionality
  * `NotesDecorator` – Adds notes to tasks
* **Location:** `com.astronaut.patterns.structural.decorator`

#### 6. Adapter Pattern – Multiple Time Format Support

* **Purpose:** Convert different time formats to a standard format
* **Adapters:**

  * `MilitaryTimeAdapter` – Converts military time (0900, 1430)
  * `StandardTimeAdapter` – Converts 12-hour format (9:00 AM)
* **Location:** `com.astronaut.patterns.structural.adapter`

---

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────┐
│                   Main.java                     │
│              (Application Entry)                │
└────────────────┬────────────────────────────────┘
                 │
         ┌───────┴────────┐
         │   MenuHandler   │
         │   (UI Layer)    │
         └───────┬─────────┘
                 │
         ┌───────┴──────────┐
         │   TaskService     │
         │ (Business Logic)  │
         └───────┬───────────┘
                 │
    ┌────────────┼────────────┐
    │            │            │
┌───┴────┐  ┌───┴────┐  ┌───┴────┐
│Schedule│  │  Task  │  │Pattern │
│Manager │  │Factory │  │Classes │
│(Single)│  │(Factory)│ │(Various)│
└────────┘  └────────┘  └────────┘
```

---

## 📦 Project Structure

```
astronaut-schedule-organizer/
├── src/main/java/com/astronaut/
│   ├── Main.java
│   ├── models/…
│   ├── patterns/
│   │   ├── behavioral/observer/…
│   │   ├── behavioral/strategy/…
│   │   ├── creational/singleton/…
│   │   ├── creational/factory/…
│   │   └── structural/…
│   ├── services/…
│   ├── exceptions/…
│   ├── utils/…
│   └── ui/…
├── logs/application.log
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

* Java 11 or higher
* Git

### Compile

```bash
javac -d bin -sourcepath src/main/java src/main/java/com/astronaut/Main.java
```

### Run

```bash
java -cp bin com.astronaut.Main
```

---

## 📖 Usage Examples

### Adding a Task

```
Description: Morning Exercise
Start Time: 07:00
End Time: 08:00
Priority: HIGH
✅ Task added successfully!
```

### Conflict Detection

```
Description: Team Meeting
Start Time: 07:30
End Time: 08:30
Priority: MEDIUM
⚠️ CONFLICT DETECTED!
```

### Viewing Tasks

```
========== ALL TASKS ==========
1. 07:00 - 08:00: Morning Exercise [High] (Pending)
2. 09:00 - 10:00: Team Meeting [Medium] (Pending)
==============================
```

---

## 🧪 Test Coverage

* **Positive:** add valid tasks, view tasks, update tasks, mark complete, switch sorting strategies, etc.
* **Negative:** overlapping tasks, invalid time formats, non-existent tasks, empty list, etc.

---

## 📊 Design Decisions

* **Singleton for ScheduleManager:** Single source of truth, prevents inconsistencies
* **Factory for Task Creation:** Centralizes validation logic, easier maintenance
* **Observer for Notifications:** Decoupled conflict detection/notification, easy to extend
* **Strategy for Sorting:** Add new sorting without changing existing code
* **Decorator for Task Features:** Optional features without bloating base class
* **Adapter for Time Formats:** User flexibility, one parsing path

---

## 🛡️ Error Handling

* **Input Validation:** Immediate feedback, `InputValidator`, `TimeValidator`, `TaskValidator`
* **Business Logic Exceptions:** `TaskConflictException`, `InvalidTimeException`, `TaskNotFoundException`
* **System-Level Handling:** Logs errors, graceful degradation

---

## 📝 Logging

* **Levels:** INFO, WARN, ERROR, DEBUG
* **Output:** Console + `logs/application.log`

Example:

```
[2025-01-15 14:30:45] [INFO] ScheduleManager initialized
[2025-01-15 14:31:02] [INFO] Task added: Morning Exercise
[2025-01-15 14:31:15] [WARN] CONFLICT DETECTED!
```

---

## 🔄 Future Enhancements

* Database/file persistence
* Recurring tasks and categories
* Multi-timezone scheduling
* Export/import CSV or JSON
* Task dependencies, full-text search, notifications, dashboard, multi-user support

Patterns to add: Command (undo/redo), Memento (history), Chain of Responsibility (validation pipeline), Composite (task groups)

---

## 🐛 Known Limitations

* No persistence (tasks lost on restart)
* Single-day schedule only
* Console-only UI
* Not thread-safe for concurrent modifications

---

## 👤 Author

Het Virani
