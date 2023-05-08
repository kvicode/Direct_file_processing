package direct_access_rep;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Records extends People {
    public static final int INTEGER_SIZE = Integer.BYTES + (3 * (Character.BYTES * 15));

    public Records() {
        this(0, "", "", "");
    }

    public Records(int id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    public void readFile(RandomAccessFile file) throws IOException {
        setID(file.readInt());
        setName(readString(file));
        setPhone(readString(file));
        setEmail(readString(file));
    }

    public void writeFile(RandomAccessFile file) throws IOException {
        file.writeInt(getID());
        writeString(file, getName());
        writeString(file, getPhone());
        writeString(file, getEmail());
    }

    private String readString(RandomAccessFile file) throws IOException {
        char[] chars = new char[15];
        for (int i = 0; i < 15; i++) {
            chars[i] = file.readChar();
        }
        return new String(chars).replace("\0", "");
    }

    private void writeString(RandomAccessFile file, String str) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        int paddingLength = 15 - builder.length();
        for (int i = 0; i < paddingLength; i++) {
            builder.append('\0');
        }
        file.writeChars(builder.toString());
    }
}
