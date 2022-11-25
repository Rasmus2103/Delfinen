import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File memberCSV = new File("src/memberlist.csv");

    public void saveToDB(ArrayList <Members> memberList) {
        FileWriter writer;
        try {
            writer = new FileWriter(memberCSV);
            for (Members s : memberList) {
                writer.write(s.csvToString());
                writer.write("\n");
            }
            writer.close();
            if(memberList.isEmpty()) {
                System.out.println("Ingen medlemmer blev registreret til databasen.");
            }
            if(!memberList.isEmpty()) {
                System.out.println(memberList.size() + " medlemmer blev registreret i databasen.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Members> loadDB() {
        ArrayList<Members> listOfMembers = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            Scanner sc = new Scanner(memberCSV);
            while(sc.hasNextLine()) {
                String[] Strings = sc.nextLine().split(",");
                Members m = new Members(
                        Strings[0],
                        Strings[1],
                        Strings[2],
                        LocalDate.parse(Strings[3], formatter),
                        Boolean.parseBoolean(Strings[4]),
                        Integer.parseInt(Strings[5]),
                        Strings[6]
                );
                listOfMembers.add(m);
            }
            sc.close();
            if (listOfMembers.isEmpty()) {
                System.out.println("Ingen medlemmer blev fundet i filen");
            }
            return listOfMembers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
