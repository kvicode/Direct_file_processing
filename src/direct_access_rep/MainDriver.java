package direct_access_rep;

import java.io.IOException;

public class MainDriver {

	public static void main(String[] args) 
		throws IOException{
		//Change your path Accordingly
		Database fe = new Database("C:/Users/bobb1/OneDrive/Desktop/CPP Stuff/CS4310/Direct_file_processing/Test.dat");

		      fe.insertRecord(new Records(1, "Kevin", "Vi", "kv@hotmail.com"));
		      fe.insertRecord(new Records(2, "Francisco", "Serrano", "fs@hotmail.com"));
		      fe.insertRecord(new Records(3, "Wenbo", "Li", "wl@hotmail.com"));
		      fe.insertRecord(new Records(4, "Zihe", "Zheng", "zz@hotmail.com"));
		      fe.showAllRecords();
		      fe.updateRecord(new Records(4,"Tony","Parker", "tp@somemail.com"));
		      fe.showAllRecords();
		      fe.deleteRecord(new Records(1,"Kevin","Vi","kv@hotmail.com"));
		      fe.showAllRecords();
		      fe.close();
	}

}
