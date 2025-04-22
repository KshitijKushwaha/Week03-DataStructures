public class StringConcatenation {

    public static void main(String[] args) {
        String[] strings = {"Capgemini", " ", "Week", " ", "3", " ", "Java", " ", "Practice"};
        String result = concatenateStrings(strings);
        System.out.println("Concatenated String: " + result);
    }

    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
}
