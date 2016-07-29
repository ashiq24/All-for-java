package lecture9;

import java.io.*;

class FileCopyDemo 
{
  public static void main(String args[]) throws Exception 
  {
    String source="file1.txt";
    String destination="file2.txt";
    InputStream in =new FileInputStream(source);
    OutputStream out=new FileOutputStream(destination,true);
    while(true)
    {
    	int c=in.read();
    	if(c==-1) break;
    	out.write(c);
    }
    in.close();
    out.close();  
  }
}
