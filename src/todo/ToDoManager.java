package todo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class ToDoManager {

    private List<Task> tasks;
    int entryCounter = 0;
    String filepath = "Task.csv";

    public ToDoManager() {
        this.tasks = new ArrayList<>();
    }
 
    public void addTask() {
        Task newTask = new Task();
        String description = JOptionPane.showInputDialog("Enter the Task Description:");
        newTask.setDescription(description);
        tasks.add(newTask);
        newTask.setCompleted(false);

    }

    public String getListAsString() {
        StringBuilder result = new StringBuilder();
        for (Task item : tasks) {
            result.append(item).append("\n");
        }
        return result.toString();
    }

    public void loadTasksFromFile() {
        try {
            Path filePath = Paths.get(filepath);
            BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) { // Assuming at least description and completion status are present
                    String description = parts[0];
                    boolean completed = parts[1].equalsIgnoreCase("true");
                    Task task = new Task(description);
                    task.setCompleted(completed);
                    tasks.add(task);
                }
            }

            br.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void deleteData(String search, String filepath) {
        try {
            Path inputPath = Paths.get(filepath);

            List<String> updatedLines = Files.lines(inputPath)
                    .filter(line -> !line.contains(search))
                    .collect(Collectors.toList());

            Files.write(inputPath, updatedLines);

            tasks.removeIf(task -> task.getDescription().equals(search));

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void RemoveInput() {
        String search = JOptionPane.showInputDialog("Enter the Task to Remove");
        deleteData(search, filepath);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int getTotalTasks() {
        return tasks.size();
    }

    public int getCompletedTasksCount() {
        return (int) tasks.stream().filter(Task::isCompleted).count();
    }

    public int getReaminingTasksCount() {
        return (int) tasks.stream().filter(Task::isCompleted).count();
    }

    public void savetofile() {
        File file = new File("Task.csv");
        try {
            if (file.createNewFile()) {
                System.out.println("File Created");
            } else {
                System.out.println("File already exists");
            }

            FileWriter outputfile = new FileWriter(file, true);

            String[] data1 = tasks.stream()
                    .map(Task::toString)
                    .toArray(String[]::new);
            if (data1.length > 0) {

                if (entryCounter > 0) {
                    outputfile.append("\n");
                }
                outputfile.write(String.join("", data1));

                entryCounter++;
            }
            outputfile.flush();
            outputfile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
