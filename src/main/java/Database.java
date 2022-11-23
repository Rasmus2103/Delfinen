public class Database {

    ArrayList<Svømmeklub> swimList = new ArrayList<>();

    public void addMember(String memberName, String activities, String memberShip, Date memberAge, boolean isStudying, int memberNumber, String eMail) {
        swimList.add(new Svømmeklub(memberName, activities, memberShip, memberAge, isStudying, memberNumber, eMail));
    }

    public void addMemberToDatabase(Svømmeklub member) {
        Database.add(member);
    }

    private static void add(Svømmeklub member) {
    }


    public ArrayList<Svømmeklub> getSwimList() {
        return swimList;
    }

    public void setSwimList(ArrayList<Svømmeklub> swimList) {
        this.swimList = swimList;
    }

    // få nummer på medlem, virker ikke rigtig så

    public String getarraylist(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("Nr. " + (i + 1) + ":");
            System.out.println(swimList.get(i));
        }
        return " ";
    }

    public String searchSvømmeklub(String searchQuery) {
        boolean isPresent = false;
        for (Svømmeklub member : swimList) {
            if (member.getmemberName().toLowerCase().contains(searchQuery.toLowerCase())) {
                System.out.println(member);
                isPresent = true;
            }
            if (!isPresent) {
                System.out.println("Intet medlem med angivet navn.");
            }
        }
        return " ";
    }


        public void printDB () {
            System.out.println("The following heroes was found:");
            for (Svømmeklub s : swimList) {
                System.out.println(s);
            }
        }

}