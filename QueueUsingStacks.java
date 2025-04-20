public class QueueUsingStacks {
    int arr[];
    int ptr = 0;
    
    QueueUsingStacks(int size) {
        arr = new int[size];
    }

    public static void main(String[] args) {
        QueueUsingStacks enqueue = new QueueUsingStacks(5);
        QueueUsingStacks dequeue = new QueueUsingStacks(5);

        enqueue.push(56);
        enqueue.push(322);
        enqueue.push(5246);
        enqueue.push(234);
        enqueue.push(324);

        while (!enqueue.empty()) {
            dequeue.push(enqueue.pop());
        }

        while (!dequeue.empty()) {
            System.out.println(dequeue.pop());
        }
    }

    public boolean empty() {
        return ptr == 0; 
    }

    public void push(int n) {
        if (ptr == arr.length) {
            System.out.println("Stack is full");
        } else {
            arr[ptr++] = n;
        }
    }

    public int pop() {
        if (empty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int r = arr[--ptr];
            return r;
        }
    }

    public void display() {
        for (int i = 0; i < ptr; i++) {
            System.out.print(arr[i] + " <- ");
        }
        System.out.println("Start");
    }
}
