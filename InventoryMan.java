class Inventory{
    String name,id;
    int quantity,price;
    
    Inventory next;
    Inventory(String name, String id,int quantity,int price){
        this.name=name;
        this.id=id;
        this.quantity=quantity;
        this.price=price;
        this.next=null;
    }
}

public class InventoryMan{
    Inventory head;

    public void add(int index,String name, String id,int quantity,int price){
        Inventory in=new Inventory(name, id, quantity, price);
        if(index==0){
            in.next=head;
            head=in;
            return;
        }
        Inventory temp=head;
        for(int i=0;i<index-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Out of Bounds");
            return;                 
        }
        in.next=temp.next;
        temp.next=in;
    }

    public void remove(String id){
        if(head.id==id){
            head=head.next;
            return;
        }
        Inventory temp=head;
        while(temp.next!=null&&temp.next.id!=id){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Not Found");
        return;
        }
        temp.next=temp.next.next;
    }

    public void update(String id, int newQuantity){
        Inventory temp=head;
        while(temp!=null){
            if(temp.id==id){
                temp.quantity=newQuantity;
            }
            temp=temp.next;
        }
    }

    public void search(String name, String id){
        Inventory temp=head;
        while(temp!=null){
            if(temp.name==name||temp.id==id){
                System.out.println("Item found!");
                System.out.println("Name of item is "+temp.name);
                System.out.println("ID of item is "+temp.id);
                System.out.println("Quantity of item is "+temp.quantity);
                System.out.println("Price of item is "+temp.price); 
            }
            temp=temp.next;
        }
    }

    public void total(){
        Inventory temp=head;
        int sum=0;
        while(temp!=null){
            sum+=(temp.price*temp.quantity);
            temp=temp.next;
        }
        System.out.println("Total Value of Inventory is: "+sum);
    }

    public void sort(String criteria, String order) {
        if (head == null) return;
        boolean swapped;
        Inventory temp;
        do {
            swapped = false;
            temp = head;
            while (temp != null && temp.next != null) {
                boolean condition = false;
                if (criteria.equals("name")) {
                    condition = order.equals("asc") ? temp.name.compareTo(temp.next.name) > 0 : temp.name.compareTo(temp.next.name) < 0;
                } else if (criteria.equals("price")) {
                    condition = order.equals("asc") ? temp.price > temp.next.price : temp.price < temp.next.price;
                }
                
                if (condition) {
                    String tempName = temp.name;
                    String tempId = temp.id;
                    int tempQuantity = temp.quantity;
                    int tempPrice = temp.price;

                    temp.name = temp.next.name;
                    temp.id = temp.next.id;
                    temp.quantity = temp.next.quantity;
                    temp.price = temp.next.price;

                    temp.next.name = tempName;
                    temp.next.id = tempId;
                    temp.next.quantity = tempQuantity;
                    temp.next.price = tempPrice;

                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    public void display(){
        Inventory temp=head;
        while(temp!=null){
            System.out.println("Name of item is "+temp.name);
            System.out.println("ID of item is "+temp.id);
            System.out.println("Quantity of item is "+temp.quantity);
            System.out.println("Price of item is "+temp.price);
            System.out.println();
            
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryMan inv=new InventoryMan();
        inv.add(0, "abc", "esfw", 6, 100);
        inv.add(1, "def", "sdsd", 60, 1000);
        inv.add(2, "ghi", "hjhn", 20, 1200);

        inv.display();
        inv.remove("esfw");
        inv.display();
        inv.update("sdsd", 100);
        inv.display();
        inv.search("def", null);
        inv.total();
        inv.sort("name", "asc");
        System.out.println("After sorting by price (ascending):");
        inv.display();
    }
}