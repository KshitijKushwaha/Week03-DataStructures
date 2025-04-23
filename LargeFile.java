import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class LargeFile{

	public static void fileReader(String fp) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(fp));
		long start = System.nanoTime();
		int ch;
		while((ch = br.read()) != -1){
			sb.append((char) ch);
		}
		long end = System.nanoTime();
		br.close();
		System.out.println("FileReader timetaken: "+((end-start)/1000000.0)+" ms");
	}
	
	public static void inputStream(String fp){
		try{
			long start = System.nanoTime();
			InputStreamReader isr = new InputStreamReader(new FileInputStream(fp));
			int ch;
			StringBuilder sb = new StringBuilder();
			while((ch = isr.read()) != -1){
				sb.append((char) ch);
			}
			long end = System.nanoTime();
			isr.close();
			System.out.println("InputStreamReader timetaken: "+((end-start)/1000000.0)+" ms");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] a) throws IOException{
		String filepath = "long-doc.txt";
		
		fileReader(filepath);
		inputStream(filepath);
	}
}