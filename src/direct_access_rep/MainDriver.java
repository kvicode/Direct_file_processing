package direct_access_rep;

import java.io.IOException;

public class MainDriver {

    public static void main(String[] args) throws IOException {
        // Change your path accordingly
        Database fe = new Database("C:/Users/bobb1/OneDrive/Desktop/CPP Stuff/CS4310/Direct_file_processing/power.dat");

        fe.insertRecord(new Records(1, "Kevin", "123", "kv@hotmail.com"));
        fe.insertRecord(new Records(2, "Francisco", "234", "fs@hotmail.com"));
        fe.insertRecord(new Records(3, "Wenbo", "345", "wl@hotmail.com"));
        fe.insertRecord(new Records(4, "Zihe", "456", "zz@hotmail.com"));

        System.out.println("All Records:");
        fe.showAllRecords();

        System.out.println("\nUpdating Record:");
        fe.updateRecord(new Records(4, "Tony", "567", "tp@somemail.com"));
        fe.showAllRecords();

        System.out.println("\nDeleting Record:");
        fe.deleteRecord(new Records(1, "Kevin", "123", "kv@hotmail.com"));
        fe.showAllRecords();

        fe.close();
    }

}
