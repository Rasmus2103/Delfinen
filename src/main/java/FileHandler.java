import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File swimCSV = new File("src/swimlist.csv");

    public void saveToDB(ArrayList <Svømmeklub> swimList) {
        FileWriter writer;
        try {
            writer = new FileWriter(swimCSV);
            for (Svømmeklub s : swimList) {
                writer.write(s.csvToString());
                writer.write("\n");
            }
            writer.close();
            if(swimList.isEmpty()) {
                System.out.println("Ingen medlemmer blev registreret til databasen.");
            }
            if(!swimList.isEmpty()) {
                System.out.println(swimList.size() + " medlemmer blev registreret i databasen.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Svømmeklub> loadDB() {
        ArrayList<Svømmeklub> listOfMembers = new ArrayList<>();
        try {
            Scanner sc = new Scanner(swimCSV);
            while(sc.hasNextLine()) {
                String[] Strings = sc.nextLine().split(",");
                Svømmeklub s = new Svømmeklub(
                        Strings[0],
                        Strings[1],
                        Strings[2],
                        new SimpleDateFormat("dd-MM-yyyy").parse(Strings[3]),
                        Boolean.parseBoolean(Strings[4]),
                        Integer.parseInt(Strings[5]),
                        Strings[6]
                );
                listOfMembers.add(s);
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
