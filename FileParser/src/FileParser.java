import java.util.*;
import java.io.*;

public class FileParser {

    static Set<String> usernames = new HashSet<>();
    static ArrayList<String> passwords = new ArrayList<>();

    public static void main(String[] args) {
        readFile();
        for(String username : usernames) {
            System.out.println("Confirming that " + username + " was added.");
        }
        System.out.println(passwords);
    }

    public static void readFile() {
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("src/main/resources/credentials.txt"));
            int i = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+", 2);

                for (String a : arr)
                    usernames.add(arr[0]);
//                    System.out.println("Username: " + arr[0]);
                    passwords.add(arr[1]);
//                    System.out.println("Password: " + arr[1]);

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
