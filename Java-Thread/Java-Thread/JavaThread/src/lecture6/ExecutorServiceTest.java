package lecture6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class k implements  Runnable{

    @Override
    public void run() {
        System.out.println("Running task");
        for (int j = 5; j > 0; j--) {
            System.out.println(j);
        }
    }
}
public class ExecutorServiceTest {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.execute(new k());
            System.out.println(executorService);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }
}
