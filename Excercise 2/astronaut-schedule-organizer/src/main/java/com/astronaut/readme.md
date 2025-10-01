# Astronaut Daily Schedule Organizer

A simple console application to manage daily tasks for astronauts. This project shows how to use design patterns in Java.

---

## 📁 What's Inside

### Main Folders

```

astronaut-schedule-organizer/
├── src/main/java/com/astronaut/     # All Java code is here
│   ├── Main.java                     # Start the program from here
│   ├── models/                       # Task, Priority, Status
│   ├── patterns/                     # 6 Design Patterns code
│   ├── services/                     # Business logic
│   ├── exceptions/                   # Error handling
│   ├── utils/                        # Helper tools (Logger, Validators)
│   └── ui/                          # Menu and user interface
├── logs/                             # Log files stored here
└── README.md                         # This file

````

---

## 📋 What the App Can Do

### Basic Features
- ✅ Add new tasks
- ✅ Remove tasks
- ✅ Update tasks
- ✅ View all tasks
- ✅ Mark tasks as completed
- ✅ Check if tasks overlap (conflict detection)

### Extra Features
- ✅ Add tasks with reminders
- ✅ Add tasks with notes
- ✅ Use different time formats (09:00, 0900, 9:00 AM)
- ✅ Sort by time or priority
- ✅ Filter tasks by priority level

---

## 🚀 How to Run

### Step 1: Make Sure You Have Java

Check if Java is installed:
```bash
java -version
````

You need **Java 11 or higher**. If not installed, download from: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

### Step 2: Download the Project

```bash
# Download from GitHub
git clone https://github.com/Hetvirani/Educational_Initiatives_Astronaut_Daily_Scheduler.git
cd Educational_Initiatives_Astronaut_Daily_Scheduler
```

### Step 3: Compile the Code

```bash
# This creates .class files in the 'bin' folder
javac -d bin -sourcepath src/main/java src/main/java/com/astronaut/Main.java
```

### Step 4: Run the Program

```bash
# Start the application
java -cp bin com.astronaut.Main
```

---

## 🎮 How to Use

When you run the program, you'll see a menu:

```
========== MAIN MENU ==========
1.  Add Task
2.  Add Task (Military Time)
3.  Add Task (Standard Time)
4.  Remove Task
5.  Update Task
6.  Mark Task Completed
7.  View All Tasks
8.  View Tasks by Priority
9.  Sort by Start Time
10. Sort by Priority
11. Add Task with Reminder
12. Add Task with Notes
0.  Exit
===============================
```

### Example: Adding a Task

```
Enter your choice: 1

Description: Morning Exercise
Start Time (HH:mm): 07:00
End Time (HH:mm): 08:00
Priority (LOW/MEDIUM/HIGH/CRITICAL): HIGH

✅ Task added successfully!
```

### Example: Viewing Tasks

```
Enter your choice: 7

========== ALL TASKS ==========
1. 07:00 - 08:00: Morning Exercise [High] (Pending)
2. 09:00 - 10:00: Team Meeting [Medium] (Pending)
3. 12:00 - 13:00: Lunch Break [Low] (Pending)
==============================
```

### Example: Task Conflict

```
Enter your choice: 1

Description: Training Session
Start Time: 07:30
End Time: 08:30
Priority: MEDIUM

⚠️ CONFLICT DETECTED! Task 'Training Session' (07:30-08:30) 
   conflicts with 'Morning Exercise' (07:00-08:00)

❌ Task conflicts with existing task: Morning Exercise
```

---

## 📝 Important Files Explained

### 1. **Main.java**

* The starting point of the program
* Sets everything up and starts the menu

### 2. **Task.java** (models folder)

* Stores task information: description, time, priority
* Checks if two tasks overlap

### 3. **ScheduleManager.java** (patterns/creational/singleton)

* Manages all tasks in one place
* Only one instance exists in the whole program

### 4. **TaskFactory.java** (patterns/creational/factory)

* Creates new tasks
* Checks if inputs are valid before creating

### 5. **TaskService.java** (services folder)

* Connects everything together
* Handles adding, removing, updating tasks

### 6. **MenuHandler.java** (ui folder)

* Shows the menu to user
* Gets user input and calls right functions

### 7. **Logger.java** (utils folder)

* Writes logs to file and screen
* Helps debug problems

---

## ⚠️ Error Messages

| Error                               | Meaning                                  | Example                              |
| ----------------------------------- | ---------------------------------------- | ------------------------------------ |
| "Invalid time format"               | Time not in HH:mm format                 | Entered: 25:00                       |
| "Task conflicts with..."            | Two tasks overlap                        | Task 1: 7:00-8:00, Task 2: 7:30-8:30 |
| "Task not found"                    | Trying to remove task that doesn't exist | Removing "Lunch" when it's not added |
| "Priority cannot be null"           | Forgot to enter priority                 | Left priority field empty            |
| "End time must be after start time" | End time is before start time            | Start: 10:00, End: 09:00             |

---

## 🐛 Common Problems

### Problem: "javac: command not found"

**Solution**: Java is not installed. Download and install Java 11+

### Problem: "Error: Could not find or load main class"

**Solution**: Make sure you're in the project folder and compiled correctly:

```bash
javac -d bin -sourcepath src/main/java src/main/java/com/astronaut/Main.java
java -cp bin com.astronaut.Main
```

### Problem: No log file created

**Solution**: The `logs` folder is created automatically when program runs

### Problem: Can't enter time in 12-hour format

**Solution**: Use menu option 3 (Add Task - Standard Time) instead of option 1

---

## 🎯 What I Learned

This project helped me understand:

* How to use design patterns in real code
* Why patterns make code easier to change
* How to organize large Java projects
* How to handle errors properly
* How to write clean, readable code

---

## ✅ Checklist

Before running:

* [ ] Java 11 or higher installed
* [ ] All files in correct folders
* [ ] Compiled without errors
* [ ] Can see the menu when running

---
