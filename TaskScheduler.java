import java.util.Date;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    Date dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, Date dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    TaskNode head;
    TaskNode currentTask;

    public TaskScheduler() {
        this.head = null;
        this.currentTask = null;
    }

    public void addTask(int index, int taskId, String taskName, int priority, Date dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            TaskNode temp = head;
            if (index == 0) {
                newTask.next = head;
                head = newTask;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head;
            } else {
                for (int i = 0; i < index - 1 && temp.next != head; i++) {
                    temp = temp.next;
                }
                newTask.next = temp.next;
                temp.next = newTask;
            }
        }
    }

    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }
        TaskNode temp = head;
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            System.out.println("Task with ID " + taskId + " removed.");
            return;
        }
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Task with ID " + taskId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task with ID " + taskId + " removed.");
        }
    }

    public void viewNextTask() {
        if (currentTask == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + currentTask.taskName);
        currentTask = currentTask.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId);
            System.out.println("Task Name: " + temp.taskName);
            System.out.println("Priority: " + temp.priority);
            System.out.println("Due Date: " + temp.dueDate);
            System.out.println();
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task found:");
                System.out.println("Task ID: " + temp.taskId);
                System.out.println("Task Name: " + temp.taskName);
                System.out.println("Priority: " + temp.priority);
                System.out.println("Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    public void startTaskScheduler() {
        if (head != null) {
            currentTask = head;
        } else {
            System.out.println("No tasks available.");
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Date now = new Date();
        
        scheduler.addTask(0, 1, "Finish Homework", 3, now);
        scheduler.addTask(1, 2, "Attend Meeting", 1, now);
        scheduler.addTask(2, 3, "Buy Groceries", 2, now);
        
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        scheduler.removeTask(2);
        scheduler.displayAllTasks();

        scheduler.startTaskScheduler();
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        scheduler.searchByPriority(3);

        scheduler.removeTask(2);
    }
}
