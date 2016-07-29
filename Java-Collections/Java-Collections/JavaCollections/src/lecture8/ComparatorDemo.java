package lecture8;

import java.util.*;

class TestClass implements Comparable {

    String  name;
    int num;

    TestClass(String name,int num) {
        this.name=name;
        this.num = num;
    }

    @Override
    public int compareTo(Object o) {
        TestClass m = (TestClass) o;
        return this.name.compareTo(m.name);
    }
}

class ComparatorDemo {

    public static void printArrayList(ArrayList<TestClass> al) {
        for(int i=0;i<al.size();i++) {
            System.out.print(al.get(i).num+"  ");
        }
        System.out.println ();
    }

    public static void printArray(TestClass [] ia) {
        for(int i=0;i<ia.length;i++) {
            System.out.print(ia[i].num+"  ");
        }
        System.out.println ();
    }

    public static void main(String args[]) {
        ArrayList<TestClass> al = new ArrayList<>();

        al.add(new TestClass("C",10));
        al.add(new TestClass("A",20));
        al.add(new TestClass("E",30));
        al.add(new TestClass("B",40));
        al.add(new TestClass("D",50));
        al.add(new TestClass("F",60));

        TestClass ia[]=new TestClass[al.size()];
        al.toArray(ia);

        System.out.println("Collection:");
        printArrayList(al);
        Collections.sort(al,(e1,e2)-> e2.num-e1.num);
        printArrayList(al);

        System.out.println("Array:");
        printArray(ia);
        Arrays.sort(ia);
        System.out.println("After Sorting:");
        printArray(ia);
    }
}