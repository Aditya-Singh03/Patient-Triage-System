# Java Patient Triage System

This project implements a Patient Triage System using a heap data structure in Java. The system prioritizes patients based on their medical condition and age, ensuring efficient management in emergency scenarios.

## Table of Contents

- [Features](#features)
- [Files](#files)
- [Usage](#usage)
- [Testing](#testing)
- [Customization](#customization)
- [Contributing](#contributing)

## Features

- **Priority Queue:** Utilizes a heap for efficient priority queue implementation.
- **Patient Prioritization:**
  - Prioritizes patients based on medical condition (CRITICAL, SEVERE, MILD, LIGHT).
  - Considers age as a secondary factor when conditions are the same.
- **Customizable:**
  - Easily switch between max heap (highest priority first) and min heap (lowest priority first).
  - Can be modified to prioritize based on other criteria.
- **Input Handling:**
  - Reads patient data from text files (e.g., `small_input.txt`, `large_input.txt`).
  - Parses patient information (name, last name, age, condition).
- **Testing:**
  - Includes JUnit tests (`ProjectTests.java`) to verify functionality.

## Files

- `AppMain.java`: Main application class, handles input and output.
- `Condition.java`: Enum defining patient conditions.
- `Patient.java`: Represents a patient with name, last name, age, and condition.
- `PatientAgeComparator.java`: Comparator for prioritizing patients by age.
- `PatientConditionComparator.java`: Comparator for prioritizing patients by condition and age.
- `TriageSystemParser.java`: Parses patient data from text files.
- `Heap.java`: Implementation of the heap data structure.
- `PriorityQueueADT.java`: Interface for priority queue operations.
- `QueueUnderflowException.java`: Custom exception for underflow situations.
- `ProjectTests.java`: JUnit tests for the project.

## Usage

1. **Compile:** Compile the Java files using your preferred method (e.g., `javac *.java`).
2. **Prepare Input:** Create or modify text files with patient data in the following format:

```
John
Doe
35
SEVERE
Jane
Smith
28
MILD
...
```

3. **Run:** Execute the program (`java AppMain <filename>`), replacing `<filename>` with your input file.
4. **Output:** The program will print the patients in order of priority.

## Testing

Run the `ProjectTests.java` file using JUnit to perform comprehensive testing. The tests cover essential functionality, including enqueue, dequeue, peek, isEmpty, and error handling.

## Customization

- **Comparator:** Modify or create new comparator classes to change prioritization criteria.
- **Heap Type:** Switch between max heap and min heap by changing the `isMaxHeap` flag in `AppMain.java`.
- **Input:** Adapt the `TriageSystemParser` to read from different input formats or sources.
