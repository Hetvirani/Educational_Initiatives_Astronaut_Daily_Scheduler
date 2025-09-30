# Astronaut Daily Schedule Organizer

A console-based task management application demonstrating advanced Java design patterns and SOLID principles.  
This project was created as part of an educational exercise to showcase how real-world scheduling problems can be solved with clean architecture and reusable patterns.

## Features
- Create, view, and manage daily astronaut tasks from the console.
- Automatic conflict detection and notifications.
- Flexible sorting of tasks by different criteria.
- Support for multiple time formats (12-hour and 24-hour).
- Extensible task features like reminders and notes.

## Design Patterns Implemented

### Behavioral Patterns  

#### 1. Observer Pattern – Task Conflict Notification System  
- Purpose: Automatically notify users when task conflicts occur.  
- Implementation:
  - `TaskObserver` interface  
  - `ConflictNotifier` concrete observer  
  - `TaskSubject` manages observer subscriptions  
- Location: `com.astronaut.patterns.behavioral.observer`

#### 2. Strategy Pattern – Dynamic Task Sorting  
- Purpose: Switch between different sorting algorithms at runtime.  
- Strategies:
  - `StartTimeSortStrategy` – Sort by start time  
  - `PrioritySortStrategy` – Sort by priority level  
- Location: `com.astronaut.patterns.behavioral.strategy`

### Creational Patterns  

#### 3. Singleton Pattern – Schedule Manager  
- Purpose: Ensure a single instance of the schedule manager throughout the application.  
- Features:
  - Thread-safe double-checked locking  
  - Centralized task management  
- Location: `com.astronaut.patterns.creational.singleton.ScheduleManager`

#### 4. Factory Pattern – Task Creation with Validation  
- Purpose: Encapsulate task object creation with validation logic.  
- Components:
  - `TaskFactory` – Creates validated task objects  
  - `TaskValidator` – Validates all task inputs  
- Location: `com.astronaut.patterns.creational.factory`

### Structural Patterns  

#### 5. Decorator Pattern – Enhanced Task Features  
- Purpose: Dynamically add features to tasks without modifying the base class.  
- Decorators:
  - `ReminderDecorator` – Adds reminder functionality  
  - `NotesDecorator` – Adds notes to tasks  
- Location: `com.astronaut.patterns.structural.decorator`

#### 6. Adapter Pattern – Multiple Time Format Support  
- Purpose: Convert different time formats to a standard format.  
- Adapters:
  - `MilitaryTimeAdapter` – Converts military time (0900, 1430)  
  - `StandardTimeAdapter` – Converts 12-hour format (9:00 AM)  
- Location: `com.astronaut.patterns.structural.adapter`

## Project Structure
