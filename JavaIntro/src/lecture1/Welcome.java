package lecture1;

import java.util.Scanner;
enum eee
{
    jak,mob,tui;
    int p;
    eee()
    {
        p=10;
    }
    void show()
    {
        System.out.println(this +" "+ p);
    }
}
class prac
{
    static void print()
    {
        System.out.println("kk");
    }
    prac()
    {
        print();
    }
}
public class Welcome {
    public static void main(String args[]) {

        eee m=eee.jak;
        eee.jak.show();
    }
}