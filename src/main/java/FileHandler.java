import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File memberCSV = new File("src/memberlist.csv");
    FileWriter writer;

    public void saveToDB(ArrayList <Member> memberList) {
        try {
            writer = new FileWriter(memberCSV);
            for (Member s : memberList) {
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

    public ArrayList<Member> loadDB() {
        ArrayList<Member> listOfMembers = new ArrayList<>();
        try {
            Scanner sc = new Scanner(memberCSV);
            while(sc.hasNextLine()) {
                String[] Strings = sc.nextLine().split(";");
                Member m = new Member(
                        Strings[0],
                        Boolean.parseBoolean(Strings[1]),
                        Strings[2],
                        loadSwimDisciplines(Strings),
                        Integer.parseInt(Strings[4]),
                        Boolean.parseBoolean(Strings[5]),
                        Integer.parseInt(Strings[6]),
                        Strings[7],
                        LocalDate.parse(Strings[8])
                        /*Integer.parseInt(Strings[7])*/
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

    public ArrayList<String> loadSwimDisciplines(String[] strings){
        ArrayList<String> swimDisciplines = new ArrayList<>();
        for (SwimDisciplines enumDiscipline: SwimDisciplines.values()) {
            if(strings[3].contains(enumDiscipline.toString())) {
                swimDisciplines.add(enumDiscipline.toString());
            }
        }
        return swimDisciplines;
    }

}
