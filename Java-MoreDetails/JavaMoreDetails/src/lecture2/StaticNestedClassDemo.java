package lecture2;

class OuterStaticInner {
    private static int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }
    // this is a static nested class
    static class Inner {
        void display() {
            System.out.println(outer_x);
        }
    }
}

public class StaticNestedClassDemo {
    public static void main(String[] args) {
        OuterStaticInner outer = new OuterStaticInner();
        outer.test();
    }
}