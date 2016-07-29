package lecture2;

/**
 * Created by rifat on 28/09/15.
 */
public class test {
    public static void main(String[] args) {
        byte b = 50;
        System.out.println(b);
        b *= 2;                  //  Error
        System.out.println(b);
        byte c = (byte)(b*2);           //  Ok
        System.out.println(c);
        byte d = (byte) (b*1);      // Ok
        System.out.println(d);

    }
}
