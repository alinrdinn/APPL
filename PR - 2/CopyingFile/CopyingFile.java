import java.io.File;
import java.util.Scanner;

public class CopyingFile {
    public static void main(String[] args) {
        System.out.print("Enter the file name with extension : ");
        Scanner input;
        File file;
		while (true) {
			try {
				input = new Scanner(System.in);
				file = new File(input.nextLine());
				input = new Scanner(file);
				break;
			} catch (Exception e){
				System.out.print("Enter another name : ");
			}
		}
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();
    }
}