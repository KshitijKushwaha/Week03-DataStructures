import java.util.ArrayList;
import java.util.List;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

public class SocialMedia {
    User head; 
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.friendIds = new ArrayList<>();  
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;  
        }
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        
        if (user1 != null && user2 != null && !user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Invalid user IDs or already friends.");
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null && user1.friendIds.contains(userId2)) {
            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Friend connection does not exist.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
            mutualFriends.retainAll(user2.friendIds);  
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
        } else {
            System.out.println("Invalid user IDs.");
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    public User searchUser(String name, int userId) {
        User temp = head;
        while (temp != null) {
            if ((name != null && temp.name.equals(name)) || (userId != -1 && temp.userId == userId)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void countFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Friends: " + temp.friendIds);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMedia system = new SocialMedia();
        system.addUser(1, "Kshitij", 22);
        system.addUser(2, "Aman", 30);
        system.addUser(3, "Manoj", 28);
        system.addUser(4, "Rupan", 25);

        system.addFriendConnection(1, 2);     
        system.addFriendConnection(2, 3);
        system.addFriendConnection(1, 3);  

        system.displayFriends(1);  

        system.findMutualFriends(1, 2);  
        system.removeFriendConnection(1, 3); 
        system.displayUsers();

        system.countFriends(1); 
    }
}
