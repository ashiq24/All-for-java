package lecture4;

import java.lang.*;
import java.lang.Override;

abstract class S {
    // abstract method
     abstract void call();
    // concrete methods are still allowed in abstract classes
    void call2() {
        System.out.println("This is a concrete method");
    }
}

class T extends S {
    void call() {
        System.out.println("T's implementation of call");
    }

    @Override
    void call2() {
        super.call2();
        System.out.println("Call 2 of T");
    }
}

class AbstractDemo {
    public static void main(String args[]) {
        // S s = new S(); // S is abstract; cannot be instantiated
        T t = new T();
        t.call();
        t.call2();
    }
}
