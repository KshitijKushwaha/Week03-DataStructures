class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class Scheduler {
    private Process head = null;
    private Process tail = null;
    private int totalWaitingTime = 0;
    private int totalTurnaroundTime = 0;
    private int processCount = 0;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        processCount++;
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.print("Current Queue: ");
        do {
            System.out.print("[P" + temp.processId + ":RT=" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void roundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        Process current = head;

        while (processCount > 0) {
            if (current.remainingTime > 0) {
                System.out.println("\nExecuting P" + current.processId + " for " + Math.min(timeQuantum, current.remainingTime) + " units");
                if (current.remainingTime <= timeQuantum) {
                    currentTime += current.remainingTime;
                    current.remainingTime = 0;
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    totalWaitingTime += current.waitingTime;
                    totalTurnaroundTime += current.turnaroundTime;
                    System.out.println("Process P" + current.processId + " completed at time " + currentTime);

                    removeProcess(current.processId);
                    if (head == null) break;
                    current = current.next;
                } else {
                    current.remainingTime -= timeQuantum;
                    currentTime += timeQuantum;
                    current = current.next;
                }
                displayQueue();
            } else {
                current = current.next;
            }
        }

        System.out.println("\nAll processes completed.");
        System.out.printf("Average Waiting Time: %.2f\n", (float) totalWaitingTime / (float) (totalTurnaroundTime > 0 ? totalTurnaroundTime / timeQuantum : 1));
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTurnaroundTime / (float) processCount); 
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process curr = head;
        Process prev = tail;

        do {
            if (curr.processId == processId) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                    if (curr == tail) tail = prev;
                }
                processCount--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 6, 1);
        scheduler.addProcess(4, 8, 3);

        int timeQuantum = 4;

        scheduler.displayQueue();

        scheduler.roundRobin(timeQuantum);
    }
}

