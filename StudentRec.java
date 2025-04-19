class Student {

    int rollno,age;
    char grade;
    String name;
    Student next;
    public Student(String name,int age,int rollno, char grade){
        this.age=age;
        this.name=name;
        this.rollno=rollno;
        this.grade=grade;
        this.next=null;
    }
}

public class StudentRec{
    Student head;
    public void insert(int index,String name,int age,int rollno, char grade){
        Student newStudent= new Student(name, age, rollno, grade);
        if(index==0){
            newStudent.next=head;
            head=newStudent;
            return;
        }
        Student temp=head;
        for(int i=0;i<index-1 && temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("out of bounds");
            return;
        }
        newStudent.next=temp.next;
        temp.next=newStudent;
    }

    public void delete(int rollno){
        Student temp=head;
        if(head.rollno==rollno){
            head=head.next;
            return;
        }
        while(temp.next!=null&&temp.next.rollno!=rollno){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Not Found");
        return;
        }
        temp.next=temp.next.next;
    }

    public void search(int rollno){
        Student temp=head;
        while(temp!=null){
            if(temp.rollno==rollno){
                System.out.println("Student Found");
                System.out.println("Name -> "+temp.name);               
            }
            temp=temp.next;
        }
    }
    
    public void update(int rollno, char newGrade){
        Student temp=head;
        while(temp!=null){
            if(temp.rollno==rollno){
                temp.grade=newGrade;               
            }
            temp=temp.next;
        }
    }

    public void display(){
        if(head==null){
            System.out.println("List is empty");
            return;            
        }
        Student temp=head;
        while(temp!=null){
            System.out.println("Name of Student is -> "+temp.name);
            System.out.println("Age of Student is -> "+temp.age);
            System.out.println("Roll Number of Student is -> "+temp.rollno);
            System.out.println("Grade of Student is -> "+temp.grade);
            System.out.println();
            
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRec s=new StudentRec();
        s.insert(0, "abcd", 10, 1, 'A');
        s.insert(1, "sf", 12, 2, 'B');
        s.insert(2, "ty", 14, 3, 'C');
        s.insert(3, "tyhy", 16, 4, 'D');
        s.insert(4, "rtg", 18, 5, 'E');
        s.insert(5, "erg", 19, 6, 'A');
        s.insert(6, "frer", 20, 7, 'C');

        // s.display();
        // s.delete(3);
        // s.display();
        // s.search(2);
        s.update(3, 'A');
        s.display();
    }
}