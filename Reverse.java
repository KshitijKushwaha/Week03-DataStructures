public class Reverse {
    public static void main(String[] args) {
        String original = "hello";
        StringBuilder s = new StringBuilder(original);

        String reversed = s.reverse().toString();

        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }
}