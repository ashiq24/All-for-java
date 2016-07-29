package lecture5;

/**
 * Created by USER on 11/10/2015.
 */

interface alpha{
    default void reset(){
        System.out.println("Alpha's method");
    }
}

interface beta {
    default void reset() {
        System.out.println("beta's method");
    }
}
public class multipleInheritanceTest implements alpha,beta {
    public void reset(){
        System.out.println("My Reset");
    }

}
