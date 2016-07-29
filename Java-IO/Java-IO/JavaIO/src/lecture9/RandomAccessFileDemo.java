package lecture9;

import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("random.txt", "rw");
        // write something in the file
        file.seek(1);
        char c=(char)file.read();
        System.out.println(c);
        System.out.println(file.getFilePointer());
        file.skipBytes(3);
        c=(char)file.read();
        System.out.println(c);
        /*file.writeUTF("ddddddddddddddd\n");

        // set the file pointer at 0 position
        file.seek(0);
        // print the line
        System.out.println(file.readLine());
        // set the file pointer at 0 position
        file.seek(0);
        // write something in the file
        file.writeUTF("World");
        // set the file pointer at 0 position
        file.seek(0);
        // print the line
        System.out.println(file.readLine());*/
        file.close();
    }
}
