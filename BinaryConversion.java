import java.io.*;

public class BinaryConversion {
    public static void main(String[] args) {
        String filePath = "long-doc.txt";
        String charset = "UTF-8";

        try (
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported encoding: " + charset);
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
