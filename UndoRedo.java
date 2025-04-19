class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class UndoRedo {
    TextState head;       
    TextState undoPointer;  
    TextState redoPointer;  
    int historySize;
    static final int MAX_HISTORY_SIZE = 10;

    public UndoRedo() {
        this.head = null;
        this.undoPointer = null;
        this.redoPointer = null;
        this.historySize = 0;
    }

    public void addState(String text) {
        TextState newState = new TextState(text);

        if (head == null) {
            head = newState;
        } else {
            head.next = newState;
            newState.prev = head;
            head = newState;
        }

        if (historySize >= MAX_HISTORY_SIZE) {
            head.prev.prev.next = null;
            head.prev = head.prev.prev;
        } else {
            historySize++;
        }

        redoPointer = null;
        undoPointer = head;
    }

    public void undo() {
        if (undoPointer != null && undoPointer.prev != null) {
            undoPointer = undoPointer.prev;
            System.out.println("Undo: " + undoPointer.content);
        } else {
            System.out.println("No more undo actions.");
        }
    }

    public void redo() {
        if (redoPointer != null) {
            undoPointer = redoPointer;
            redoPointer = redoPointer.next;
            System.out.println("Redo: " + undoPointer.content);
        } else {
            System.out.println("No more redo actions.");
        }
    }

    public void display() {
        if (undoPointer != null) {
            System.out.println("Current State: " + undoPointer.content);
        } else {
            System.out.println("No text available.");
        }
    }

    public static void main(String[] args) {
        UndoRedo editor = new UndoRedo();
        
        editor.addState("Hello");
        editor.display();
        
        editor.addState("Hello World");
        editor.display();
        
        editor.addState("Hello World!");
        editor.display();
        
        editor.undo();
        editor.display();
        
        editor.undo();
        editor.display();
        
        editor.redo();
        editor.display();
        
        editor.redo();
        editor.display();
        
        editor.addState("New text after redo.");
        editor.display();
        
        editor.addState("Another new state.");
        editor.display();
    }
}
