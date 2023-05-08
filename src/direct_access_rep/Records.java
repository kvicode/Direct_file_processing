package direct_access_rep;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Records extends People {
	
	public static final int integerSIZE = Integer.BYTES 
								+ (3*(Character.BYTES *15));
	
	public Records() {
		this(0, "", "", "");
	}
	
	public Records(int id, String name, String phone, String email) {
		super(id,name,phone,email);
	}
	
	public void readFile(RandomAccessFile file)
	      throws IOException {
	      setID(file.readInt());
	      setName(readString(file));
	      setPhone(readString(file));
	      setEmail(readString(file));
	   }

	public void writeFile(RandomAccessFile file) 
		throws IOException{
		file.writeInt(getID());
		writeString(file, getName());
		writeString(file, getPhone());
		writeString(file, getEmail());
	}
	

	private String readString(RandomAccessFile file) 
		throws IOException{
		char[] f = new char[15];
		for (int i = 0; i < f.length; i++)
			f[i] = file.readChar();
		return new String(f);
	}
	
	private void writeString(RandomAccessFile file, String f)
		throws IOException{
		StringBuffer buffer = null;
		if (f != null) {
			buffer = new StringBuffer(f);
		}
		else {
			buffer = new StringBuffer(15);
			buffer.setLength(15);
			file.writeChars(buffer.toString());
		}
	}
}
