ToDoManager is a Java-based GUI application designed to help users manage their tasks efficiently. 
It allows users to add, remove, and view tasks, and it saves tasks to a CSV file. The application includes a login system for added security.

**Features**

Add Task: Allows users to add new tasks with descriptions.
Remove Task: Enables users to remove tasks by description.
Task Persistence: Saves tasks to a CSV file and loads them from the file upon startup.
Task Completion: Users can mark tasks as completed.
Login System: Basic login system to secure task management.



**Usage**


Login:
Open the application.
Enter the username and password (manager for both) to login.

Add a Task:
Click on the "Add Task" button.
Enter the task description in the input dialog.

Remove a Task:
Click on the "Remove Task" button.
Enter the description of the task to remove in the input dialog.

Mark a Task as Completed:
Check the checkbox next to a task to mark it as completed.
The task status will be saved automatically.


**Classes**

ToDo:
Entry point of the application. It initializes the login window.
Task:
Represents a task with a description and a completion status.
ToDoManager:
Manages the list of tasks, including adding, removing, loading from file, and saving to file.
Login:
Implements a basic login window using JFrame.
Verifies username and password and opens the main task management GUI upon successful login.
ToDoManagerGUI:
Implements the main task management GUI using JFrame.
Allows users to add and remove tasks and mark tasks as completed.


**CSV File (Task.csv)**
The Task.csv file stores tasks with their descriptions and completion statuses.
Each task is stored in a new line with the format: description,completed.
