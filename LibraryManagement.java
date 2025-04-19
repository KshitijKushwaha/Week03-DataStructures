class Book{
    String title,author,genre,availability;
    int id;
    Book next;
    Book prev;
    Book(String title,String author,String genre,String availability,int id){
    this.title=title;
    this.author=author;
    this.genre=genre;
    this.availability=availability;
    this.id=id;
    this.next=null;
    this.prev=null;
    }
}

public class LibraryManagement {
    Book head;
    public void add(int index,String title,String author,String genre,String availability,int id){
        Book book=new Book(title, author, genre, availability, id);
        
        if(index==0){
           book.next=head;
           if(head!=null){
            head.prev=book;
           }
           head=book;
           return;
        }
        Book temp=head;
        for(int i=0;i<index-1&&temp.next!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Out of Bounds!"); 
            return;           
        }
        book.next=temp.next;
        if(temp.next!=null){
            temp.next.prev=book;
        }
        temp.next=book;
        book.prev=temp;
        
    }

    public void remove(int id){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if(head.id==id){
            head=head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } 
                else {
                    head = temp.next;
                }
                
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void search(String title,String author){
        Book temp=head;
        while(temp!=null){
            if(temp.title==title||temp.author==author){
                System.out.println("Book Found");
                System.out.println("Book Title is "+temp.title);
                System.out.println("Book ID is "+temp.id);            
                System.out.println("Book Author is "+temp.author);
                System.out.println("Book Genre is "+temp.genre);
                System.out.println();
            }
            temp=temp.next;
        }
    }

    public void update(String title,String availability){
        Book temp=head;
        while(temp!=null){
            if(temp.title==title){
                temp.availability=availability;
            }
            temp=temp.next;
        }
    }

    public void displayForRev(){
        Book temp=head;
        Book last=temp;
        System.out.println("Forward order of movies!"); 
        while(temp!=null){
            System.out.println("Book Title is "+temp.title);
            System.out.println("Book ID is "+temp.id);            
            System.out.println("Book Author is "+temp.author);
            System.out.println("Book Genre is "+temp.genre);
            System.out.println("Book Availability is "+temp.availability);
            System.out.println();               
            if(temp.next!=null){
                last=temp.next;
            }        
            temp=temp.next;            
        }

        System.out.println("Reverse order of movies:");
        while (last != null) {
            System.out.println("Book Title is "+last.title);
            System.out.println("Book ID is "+last.id);            
            System.out.println("Book Author is "+last.author);
            System.out.println("Book Genre is "+last.genre);
            System.out.println("Book Availability is "+last.availability);
            System.out.println();            
            last = last.prev;
        }
    }

    public void count(){
        Book temp=head;
        int c=0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        System.out.println("Total Books are "+c);
    }

    public void display(){
        Book temp=head;
        while(temp!=null){         
            System.out.println("Book Title is "+temp.title);
            System.out.println("Book ID is "+temp.id);            
            System.out.println("Book Author is "+temp.author);
            System.out.println("Book Genre is "+temp.genre);
            System.out.println("Book Availability is "+temp.availability);
            System.out.println();            

            temp=temp.next;            
        }
    }

    public static void main(String[] args) {
        LibraryManagement lib=new LibraryManagement();
        lib.add(0, "The Great Gatsby", "F. Scott Fitzgerald", "Novel", "Available", 101);
        lib.add(1, "1984", "George Orwell", "Dystopian", "Checked Out", 102);
        lib.add(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", "Available", 103);
        lib.add(3, "Moby Dick", "Herman Melville", "Adventure", "Checked Out", 104);
        lib.add(4, "Pride and Prejudice", "Jane Austen", "Romance", "Available", 105);
        
        lib.display();   
        lib.remove(102);
        lib.search("1984", null);
        lib.update("1984", "Available");
        lib.displayForRev();
        lib.display();
        lib.count();
    }
}
