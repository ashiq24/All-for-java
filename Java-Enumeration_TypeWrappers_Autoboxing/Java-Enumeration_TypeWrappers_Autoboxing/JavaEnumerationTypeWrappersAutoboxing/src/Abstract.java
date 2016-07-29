/**
 * Created by USER on 1/22/2016.
 */

abstract class A{
      int x = 5;
     int getX()
    {
        return x;
    }
}
public class Abstract extends A{

    public static void main(String[] args) {
        String s = String.valueOf(6);
        int n = Integer.parseInt(s);
        Abstract a = new Abstract();
        System.out.println(a.getX());
    }
}
