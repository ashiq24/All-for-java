package lecture9;

import java.io.*;

class DataIODemo 
{
  public static void main(String args[]) throws Exception 
  {
    FileOutputStream fos =new FileOutputStream("Test.dat");
    DataOutputStream dos=new DataOutputStream(fos);
    dos.writeDouble(98.6);
    dos.writeInt(1000);
    dos.writeBoolean(true);
    dos.close();
    fos.close();
    
    FileInputStream fis =new FileInputStream("file2.txt");
    DataInputStream dis=new DataInputStream(fis);
    while( dis.available()!=0)
    {
        System.out.print((char)dis.read());
    }
     
     dis.close();
     fis.close();
    
    
  }
}
