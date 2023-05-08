package direct_access_rep;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Database extends Records {
	RandomAccessFile file;

	public Database(String fileString)
	         throws IOException {
	      file = new RandomAccessFile(fileString, "rw");
	   }
	
   public void close() throws IOException {
	   if (file != null)
		   file.close();
	   }

   public Records getRecord(int id) throws IOException {
	      Records record = new Records();
	      if (id < 1)
	         throw new IllegalArgumentException("invalid ID!!");
	         file.seek((id - 1) * Records.integerSIZE);
	         record.readFile(file);
	         return record;
	   }
	   public void insertRecord(Records record)
	         throws IllegalArgumentException, IOException {
	      if (getRecord(record.getID()).getID() != 0)
	         System.out.println("Cannot add new. Record already exists.");
	      else {
	         file.seek((record.getID() - 1) * Records.integerSIZE);
	         record.writeFile(file);
	      }
	   }

	   public void updateRecord(Records record)
	         throws IllegalArgumentException, IOException {
	      if (getRecord(record.getID()).getID() == 0)
	         System.out.println("Cannot update. Record does not exist.");
	      else {
	         file.seek((record.getID() - 1) * Records.integerSIZE);
	         record.writeFile(file);
	      }
	   }

	   public void deleteRecord(Records record)
	         throws IllegalArgumentException, IOException {
	      if (getRecord(record.getID()).getID() == 0)
	         System.out.println("Cannot delete. Record does not exist.");
	      else {
	         file.seek((record.getID() - 1) * Records.integerSIZE);
	         record = new Records();
	         record.writeFile(file);
	      }
	   }

	   public void showAllRecords() {
	      Records record = new Records();
	      try {
	         file.seek(0);
	         while (true) {
	            do {
	               record.readFile(file);
	            } while (record.getID() == 0);
	            System.out.println(record.toString());
	         }
	      } catch (EOFException ex1) {
	         return;
	      } catch (IOException ex2) {
	         System.err.println("error reading file");
	      }
	   }
	}