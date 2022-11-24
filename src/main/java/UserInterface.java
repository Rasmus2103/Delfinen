import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {

    Scanner sc = new Scanner(System.in);

    Controller controller = new Controller();

    public void start() {
        System.out.println("Velkommen til Delfinens administrative system");
        System.out.println("Vælg om du er enten Formand eller Træner");

        while(true) {
            System.out.println("""
                    1. Formand
                    2. Træner
                    9. Forlad programmet
                    """);
            switch(readInt()) {
                case 1:
                    formand();
                    break;
                case 9:
                    System.out.println("Lukker for systemet");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt. Indtast det");
                    break;
            }
        }
    }

    public void formand() {
        System.out.println("Velkommen Formand, vælg en af følgende muligheder her");

        controller.loadDB();

        while(true) {
            System.out.println("""
                1. Registrer et medlem
                2. Se alle medlemmer
                3. Ændrer oplysninger om et medlem
                4. Slet et medlem
                5. Gem alle medlemmer
                9. Tilbage til hovedmenuen
                """);
            switch (readInt()) {
                case 1:
                    addMemberToDatabase();
                    break;
                case 2:
                    controller.printDB();
                    break;
                case 3:
                    editMember();
                    break;
                case 4:
                    removeMember();
                    break;
                case 5:
                    controller.saveToDB();
                    break;
                case 9:
                    start();
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, indtast et af de følgende tal");
                    break;
            }
        }
    }

    public void addMemberToDatabase() {

        try {
            System.out.println(" ");
            System.out.println("Du ønsker at registrer et medlem i klubben \nStart med at skrive navnet på medlemmet");
            String memberName = sc.nextLine();
            System.out.println("Du har registreret følgende navn: " + memberName);
            System.out.println(" ");

            int memberNumber = sc.nextInt();
            System.out.println("Du har registreret at medlemmets har medlems nr.: " + memberNumber);
            System.out.println(" ");

            /*System.out.println("Vælg hvad for en aktivitetsform medlemmet ønsker \nMedlemmet kan enten være Motionist eller Konkurrencesvømmer");
            String motionist = "Motionistsvømmer";
            String competition = "Konkurrencesvømmer";
            System.out.println("""
                    1. Motionistsvømmer
                    2. Konkurrencesvømmer
                    """);
            switch (readInt()) {
                case 1:
                    System.out.println("Du registreret at medlemmet er: " + motionist);
                    break;
                case 2:
                    System.out.println("Du har registreret at medlemmet er " + competition);
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, indtast enten 1 eller 2");
                    break;

            }*/
            System.out.println(" ");

            sc.nextLine();

            System.out.println("Vælg hvad for en medlemskab medlemmet ønsker \n");
            String membership = sc.nextLine();
            System.out.println("Du registreret at medlemmet har et: " + membership);
            System.out.println(" ");

            System.out.println("Indtast medlemmets fødselsdags dato");
            String memberAge = sc.nextLine();
            System.out.println("Du har registreret medlemmets fødselsdato er: " + memberAge);
            System.out.println(" ");


            System.out.println("Erklær om medlemmet er studerende eller ej \nTast 1 for studerende \nTast 2 for ikke studerende");
            boolean isStudying = true;
            switch (readInt()) {
                case 1:
                    isStudying = true;
                    System.out.println("Du har erklæret at du er studerende");
                    System.out.println(" ");
                    break;
                case 2:
                    isStudying = false;
                    System.out.println("Du har erklæret at du ikke er studerende");
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, Skriv enten 1 eller 2");
                    System.out.println(" ");
                    break;
            }

            System.out.println("Indtast medlemmets email adresse");
            String eMail = sc.nextLine();
            System.out.println("Du har registreret at medlemmets email adresse er: " + eMail);
            System.out.println(" ");

            //controller.addMember(memberName, activity, membership, memberAge, isStudying, memberNumber, eMail);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void editMember() {
        try {
            System.out.println("Vælg et medlem du ønsker at redigere i (Vælg ved at indtaste deres medlemsnummer): ");
            for (int i = 0; i < controller.getSwimList().size(); i++) {
                System.out.println(i + 1 + ":" + controller.getSwimList().get(i));
            }
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            sc.nextLine();

            Svømmeklub editMember = controller.getSwimList().get(number - 1);
            System.out.println("Du er igang med at redigere i " + editMember);

            //Ændring af medlemmets navn
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.getmemberName());
            String memberNewName = sc.nextLine();
            if (!memberNewName.isEmpty())
                editMember.setmemberName(memberNewName);

            //Ændring af medlemmets aktivitetsform
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.getActivities());
            String memberNewActivity = sc.nextLine();
            if (!memberNewActivity.isEmpty())
                editMember.setActivities(memberNewActivity);

            //Ændring af medlemmets medlemsskab
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.getMembership());
            String memberNewMembership = sc.nextLine();
            if (!memberNewMembership.trim().isEmpty())
                editMember.setMembership(memberNewMembership);

            //Ændring om medlemmet studerer eller ej
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere om medlemmet er studerende eller ikke studerende: " +
                    "\nTast 1 og tryk ENTER hvis medlemmet er studerende. " +
                    "\nTast 2 og tryk ENTER hvis medlemmet ikke er studerende" +
                    "\nTast 3 og tryk ENTER hvis der ikke skal redigeres");
            int memberStudyingOrNot = readInt();
            if (memberStudyingOrNot == 1) {
                editMember.setisStudying(true);
            } else if (memberStudyingOrNot == 2) {
                editMember.setisStudying(false);
            } else if (memberStudyingOrNot == 3) {
                System.out.println("Ingen videre ændring");
            } else {
                System.out.println("Input ikke gyldigt, der er ikke sket en ændring");
            }

            //Ændring af medlemmets email adresse
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.geteMail());
            String memberNewEmail = sc.nextLine();
            if (!memberNewEmail.trim().isEmpty())
                editMember.seteMail(memberNewEmail);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Der findes ikke et medlem med det nummer");
            editMember();
        }
    }

    public void removeMember() {
        try {
            for (int i = 0; i < controller.getSwimList().size(); i++) {
                System.out.println(i + ":" + controller.showSwimList().get(i));
            }
            System.out.println("Vælg det medlem du ønsker at slette ud fra deres medlemsnummer");
            int number = readInt();

            controller.removeMember(number);

            System.out.println("Du har slettet medlem nr. " + number + " fra databasen");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Der er ingen medlemmer med dette nummer \n Vender tilbage til hovedmenuen");
        }
    }

    private int readInt() {

        boolean validateInt = true;
        int integer = 0;

        do {
            try {
                integer = sc.nextInt();
                validateInt = false;
                sc.nextLine();

            } catch (Exception e) {
                System.out.println("Din input er ikke gyldig \nVær sød at prøve igen.");
                sc.nextLine();
            }
        }
        while (validateInt);
        return integer;
    }

}
