import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments found!!!");
            return;
        }
        if(args[0].equals("a")){
            System.out.println("Loading data ...");
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
                String st = reader.readLine();
                if (st != null) {
                    String i[] = st.split(",");
                    for (String j : i) {
                        System.out.println(j.trim());
                    }
                }
                reader.close();
                System.out.println("Data Loaded.");
            }
            catch (Exception e){
                System.out.println("failed to load data!!!");
            }

        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try{
                BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
                String st = reader.readLine();
                if (st != null) {
                    String i[] = st.split(",");
                    Random random = new Random();
                    int y = random.nextInt(i.length);
                    System.out.println(i[y].trim());
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e){
                System.out.println("failed to load data!!!");
            }

        } else if (args[0].equals("+")) {
            if (args.length < 2) {
                System.out.println("Please provide a student name to add.");
                return;
            }
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
                String st = args[1];
                Date d = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss a");
                String fd = dateFormat.format(d);
                writer.write(", " + st + "\nList last updated on " + fd);
                writer.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error writing to file.");
            }

        }
        else if (args[0].equals("?")) {
            if (args.length < 2) {
                System.out.println("Please provide a name to search.");
                return;
            }
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
                String st = reader.readLine();
                if (st != null) {
                    String i[] = st.split(",");
                    boolean found = false;
                    String t = args[1];
                    for (String student : i) {
                        if (student.trim().equals(t)) {
                            System.out.println("We found it!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
                String st = reader.readLine();
                if (st != null) {
                    String i[] = st.split(",");
                    System.out.println(i.length + " word(s) found.");
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }

        }
    }
}