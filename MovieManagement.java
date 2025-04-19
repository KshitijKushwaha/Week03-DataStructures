class Movie{
    String title, director;
    int yor,rating;
    Movie next;
    Movie prev;

    Movie(String title,String director,int yor, int rating){
        this.title=title;
        this.director=director;
        this.yor=yor;
        this.rating=rating;
        this.next=null;
        this.prev=null;
    }
    
}

public class MovieManagement {
    Movie head;
    public void add(int index, String title,String director,int yor, int rating){
        Movie newMovie=new Movie(title, director, yor, rating);
        if(index==0){
            newMovie.next=head;
            if (head != null) {
                head.prev = newMovie;
            }
            head = newMovie;
            return;
        }     
        Movie temp=head;   
        for(int i=0;i<index-1 && temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("out of bounds");
            return;
        }
        newMovie.next=temp.next;
        if (temp.next != null) {
            temp.next.prev = newMovie; 
        }
        temp.next=newMovie;
        newMovie.prev=temp;
    }

    public void search(String director,int rating){
        Movie temp=head;
        while(temp!=null){
            if(temp.director==director||temp.rating==rating){
                System.out.println("Movie Found!");
                System.out.println("Movie Title is "+temp.title);
                System.out.println("Movie Director is "+temp.director);
                System.out.println("Movie Year of Release is "+temp.yor);
                System.out.println("Movie Rating is "+temp.rating);
                System.out.println();            
            }

            temp=temp.next;
        }
    }

    public void displayForRev(){
        Movie temp=head;
        Movie last=temp;
        System.out.println("Forward order of movies!"); 
        while(temp!=null){
            System.out.println("Movie Title is "+temp.title);
            System.out.println("Movie Director is "+temp.director);
            System.out.println("Movie Year of Release is "+temp.yor);
            System.out.println("Movie Rating is "+temp.rating);
            System.out.println();   
            if(temp.next!=null){
                last=temp.next;
            }        
            temp=temp.next;            
        }

        System.out.println("Reverse order of movies:");
        while (last != null) {
            System.out.println("Movie Title: " + last.title);
            System.out.println("Movie Director: " + last.director);
            System.out.println("Movie Year of Release: " + last.yor);
            System.out.println("Movie Rating: " + last.rating);
            System.out.println();
            last = last.prev;
        }
    }

    public void update(String title,int rating){
        Movie temp=head;
        while(temp!=null){
            if(temp.title==title){
                temp.rating=rating;
            }
            temp=temp.next;
        }
    }

    public void display(){
        Movie temp=head;
        while(temp!=null){         
            System.out.println("Movie Title is "+temp.title);
            System.out.println("Movie Director is "+temp.director);
            System.out.println("Movie Year of Release is "+temp.yor);
            System.out.println("Movie Rating is "+temp.rating);
            System.out.println();            

            temp=temp.next;            
        }
    }

    public static void main(String[] args) {
        MovieManagement m=new MovieManagement();
        m.add(0, "Pushpa 2", "Sukmar", 2025, 6);
        m.add(1, "The Dark Knight", "Christopher Nolan", 2008, 8);
        m.add(2, "E.T. the Extra-Terrestrial", "Steven Spielberg", 1982, 9);
        m.add(3, "The Empire Strikes Back", "Irvin Kershner", 1980, 7);
        m.add(4, "Schindler's List", "Steven Spielberg", 1993, 7);
        m.add(5, "Boyhood", "Richard Linklater", 2014, 8);

        m.display();
        m.search("Sukmar", 0);
        m.displayForRev();
        m.update("Pushpa 2", 8);
        m.display();
    }
}
