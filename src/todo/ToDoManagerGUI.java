package todo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoManagerGUI extends JFrame {

    private ToDoManager toDoManager;

    private JPanel taskListPanel;
    private JScrollPane scrollPane;
    private JButton addTaskButton;
    private JButton removeTaskButton;

    public ToDoManagerGUI() {
        this.toDoManager = new ToDoManager();

        initComponents();
        addListeners();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        
        toDoManager.loadTasksFromFile();
        updateTaskList();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(taskListPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addTaskButton = new JButton("Add Task");
        removeTaskButton = new JButton("Remove Task");

        buttonPanel.add(addTaskButton);
        buttonPanel.add(removeTaskButton);

        add(buttonPanel, BorderLayout.SOUTH);

        
    }

    private void addListeners() {
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoManager.addTask();
                updateTaskList();
            }
        });

        removeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoManager.RemoveInput();
                updateTaskList();
            }
        });
    }

    private void updateTaskList() {
        taskListPanel.removeAll();

        for (Task task : toDoManager.getTasks()) {
            JCheckBox checkBox = new JCheckBox(task.getDescription());
            checkBox.setSelected(task.isCompleted());

            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean isSelected = checkBox.isSelected();
                    task.setCompleted(isSelected);
                    toDoManager.savetofile(); 
                }
            });

            taskListPanel.add(checkBox);
        }

        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoManagerGUI();
            }
        });
    }
}
