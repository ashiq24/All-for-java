package lecture6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CallMe {
    Lock lock = new ReentrantLock();
    void call(String msg) {
        lock.lock();
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
        lock.unlock();
    }
}

class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe c, String s) {
        target = c;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
            target.call(msg);

    }
}

public class NonSynchronized {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        new Caller(target, "Hello");
        new Caller(target, "Synchronized");
        new Caller(target, "World");
    }
}
