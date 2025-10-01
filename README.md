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
## Design Patterns Implemented

### Behavioral Patterns  

#### 1. Observer Pattern – Task Conflict Notification System  

<img src="./Excercise 1/BehavioralPattern.jpg" width="400" height="400">

- **Purpose:** Automatically notify users when a newly created task conflicts with existing ones.  
- **Implementation Details:**
  - `TaskObserver` interface – defines update mechanism  
  - `ConflictNotifier` – concrete observer that receives notifications  
  - `TaskSubject` – manages observer subscriptions and broadcasts changes  
- **Benefit:** Decouples the conflict detection logic from the main task manager.  
- **Location:** `com.astronaut.patterns.behavioral.observer`

#### 2. Strategy Pattern – Dynamic Task Sorting  

- **Purpose:** Switch between different sorting algorithms at runtime without changing core logic.  
- **Strategies:**
  - `StartTimeSortStrategy` – Sorts tasks by start time.  
  - `PrioritySortStrategy` – Sorts tasks by priority level.  
- **Benefit:** Makes sorting flexible and easily extendable.  
- **Location:** `com.astronaut.patterns.behavioral.strategy`

---

### Creational Patterns  

<img src="./Excercise 1/CreationalPattern.drawio.png" width="400" height="400">

#### 3. Singleton Pattern – Schedule Manager  
- **Purpose:** Ensure only one instance of the schedule manager exists throughout the application.  
- **Features:**
  - Thread-safe double-checked locking.  
  - Centralized task management.  
- **Benefit:** Eliminates duplicate managers and ensures consistency.  
- **Location:** `com.astronaut.patterns.creational.singleton.ScheduleManager`

#### 4. Factory Pattern – Task Creation with Validation  
- **Purpose:** Encapsulate and centralize task object creation with validation logic.  
- **Components:**
  - `TaskFactory` – Creates validated task objects.  
  - `TaskValidator` – Ensures all inputs meet required rules.  
- **Benefit:** Clean separation of validation and creation logic.  
- **Location:** `com.astronaut.patterns.creational.factory`

---

### Structural Patterns  

<img src="./Excercise 1/StructuralPattern.drawio.png" width="400" height="400">

#### 5. Decorator Pattern – Enhanced Task Features  
- **Purpose:** Dynamically add features to tasks without modifying the base class.  
- **Decorators:**
  - `ReminderDecorator` – Adds reminder functionality to a task.  
  - `NotesDecorator` – Adds notes to tasks.  
- **Benefit:** Extends task functionality in an open/closed principle-friendly way.  
- **Location:** `com.astronaut.patterns.structural.decorator`

#### 6. Adapter Pattern – Multiple Time Format Support  
- **Purpose:** Convert different time formats (12-hour, military) into a standard format for consistency.  
- **Adapters:**
  - `MilitaryTimeAdapter` – Converts military time (0900, 1430).  
  - `StandardTimeAdapter` – Converts 12-hour format (9:00 AM).  
- **Benefit:** Allows the scheduler to work with multiple time formats seamlessly.  
- **Location:** `com.astronaut.patterns.structural.adapter`
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
│   ├── models/
│   │   ├── Task.java
│   │   ├── Priority.java
│   │   └── TaskStatus.java
│   ├── patterns/
│   │   ├── behavioral/
│   │   │   ├── observer/
│   │   │   │   ├── TaskObserver.java
│   │   │   │   ├── ConflictNotifier.java
│   │   │   │   └── TaskSubject.java
│   │   │   └── strategy/
│   │   │       ├── SortStrategy.java
│   │   │       ├── StartTimeSortStrategy.java
│   │   │       └── PrioritySortStrategy.java
│   │   ├── creational/
│   │   │   ├── singleton/
│   │   │   │   └── ScheduleManager.java
│   │   │   └── factory/
│   │   │       ├── TaskFactory.java
│   │   │       └── TaskValidator.java
│   │   └── structural/
│   │       ├── decorator/
│   │       │   ├── TaskDecorator.java
│   │       │   ├── ReminderDecorator.java
│   │       │   └── NotesDecorator.java
│   │       └── adapter/
│   │           ├── TimeFormatAdapter.java
│   │           ├── MilitaryTimeAdapter.java
│   │           └── StandardTimeAdapter.java
│   ├── services/
│   │   └── TaskService.java
│   ├── exceptions/
│   │   ├── TaskConflictException.java
│   │   ├── InvalidTimeException.java
│   │   └── TaskNotFoundException.java
│   ├── utils/
│   │   ├── Logger.java
│   │   ├── TimeValidator.java
│   │   └── InputValidator.java
│   └── ui/
│       ├── ConsoleUI.java
│       └── MenuHandler.java
├── logs/
│   └── application.log
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
Enter your choice: 1
Description: Morning Exercise
Start Time: 07:00
End Time: 08:00
Priority: HIGH

✅ Task added successfully!
```

### Conflict Detection

```
Enter your choice: 1
Description: Team Meeting
Start Time: 07:30
End Time: 08:30
Priority: MEDIUM

⚠️ CONFLICT DETECTED! Task 'Team Meeting' (07:30-08:30) 
   conflicts with 'Morning Exercise' (07:00-08:00)
❌ Task conflicts with existing task: Morning Exercise
```

### Viewing Tasks

```
Enter your choice: 7

========== ALL TASKS ==========
1. 07:00 - 08:00: Morning Exercise [High] (Pending)
2. 09:00 - 10:00: Team Meeting [Medium] (Pending)
3. 12:00 - 13:00: Lunch Break [Low] (Pending)
==============================
```
### Adding Task with Reminder

```
Enter your choice: 11
Description: Important Meeting
Start Time: 14:00
End Time: 15:00
Priority: CRITICAL
Reminder (minutes before): 15

✅ Task added with reminder!
   14:00 - 15:00: Important Meeting [Critical] (Pending) 
   [Reminder: 15 min before at 13:45]
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

📝 Logging Mechanism
Logging Levels

INFO: Normal operations (task added, removed, etc.)
WARN: Potential issues (conflicts detected)
ERROR: Actual errors (validation failures)
DEBUG: Detailed information for debugging

Log Output

Console: Real-time feedback to user
File: Persistent log in logs/application.log

Sample Log Entry

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
