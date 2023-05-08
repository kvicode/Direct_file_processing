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
	    if (id < 1) {
	        throw new IllegalArgumentException("Invalid ID!!");
	    }

	    long position = (id - 1) * Records.INTEGER_SIZE;
	    if (position >= file.length()) {
	        throw new IllegalArgumentException("Record does not exist.");
	    }

	    Records record = new Records();
	    file.seek(position);
	    
	    // Check if there are enough bytes remaining in the file to read the record
	    if (file.length() - file.getFilePointer() >= Records.INTEGER_SIZE) {
	        record.readFile(file);
	    } else {
	        System.out.println("Record does not exist.");
	    }

	    return record;
	}

   public void insertRecord(Records record) 
		throws IOException {
	    if (record.getID() < 1) {
	        System.out.println("Cannot add new. Invalid record ID.");
	        return;
	    }

	    long position = (record.getID() - 1) * Records.INTEGER_SIZE;
	    if (position >= file.length()) {
	        file.seek(file.length());
	        record.writeFile(file);
	    } else {
	        file.seek(position);
	        Records existingRecord = new Records();
	        existingRecord.readFile(file);
	        if (existingRecord.getID() != 0) {
	            System.out.println("Cannot add new. Record already exists.");
	        } else {
	            record.writeFile(file);
	        }
	    }
	}


   public void updateRecord(Records record) 
		throws IOException {
	    if (record.getID() < 1) {
	        System.out.println("Cannot update. Invalid record ID.");
	        return;
	    }

	    long position = (record.getID() - 1) * Records.INTEGER_SIZE;
	    if (position >= file.length()) {
	        System.out.println("Cannot update. Invalid record position.");
	        return;
	    }

	    file.seek(position);
	    Records existingRecord = new Records();
	    existingRecord.readFile(file);
	    if (existingRecord.getID() == 0) {
	        System.out.println("Cannot update. Record does not exist.");
	    } else {
	        record.writeFile(file);
	    }
	}

	public void deleteRecord(Records record) 
			throws IllegalArgumentException, IOException {
	    if (getRecord(record.getID()).getID() == 0) {
	        System.out.println("Cannot delete. Record does not exist.");
	    } else {
	        long position = (record.getID() - 1) * Records.INTEGER_SIZE;
	        if (position >= file.length()) {
	            System.out.println("Cannot delete. Invalid record position.");
	        } else {
	            file.seek(position);
	            record = new Records();
	            record.writeFile(file);
	        }
	    }
	}


	public void showAllRecords() {
	    try {
	        file.seek(0);
	        long fileSize = file.length();
	        int totalRecords = (int) (fileSize / Records.RECORD_SIZE);

	        for (int i = 0; i < totalRecords; i++) {
	            Records record = new Records();
	            record.readFile(file);

	            if (record.getID() != 0) {
	                System.out.println(record.toString());
	            }
	        }
	    } catch (EOFException ex1) {
	        return;
	    } catch (IOException ex2) {
	        System.err.println("Error reading file");
	    }
	}
	}