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
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            char c = file.readChar();
            if (c != '\0') {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private void writeString(RandomAccessFile file, String f) throws IOException {
        StringBuilder buffer;
        if (f != null) {
            buffer = new StringBuilder(f);
        } else {
            buffer = new StringBuilder(15);
        }
        buffer.setLength(15);
        file.writeChars(buffer.toString());
    }
}
