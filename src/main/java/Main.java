import org.python.util.PythonInterpreter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        PythonInterpreter interpreter = new PythonInterpreter();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            try {
                interpreter.execfile("/home/pi/test.py");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //"/home/pi/test.py"
        executorService.execute(() -> {
            try {
                Process p = Runtime.getRuntime().exec("node /home/pi/Desktop/Server/index.js");
                System.out.println(p);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("fuycked");
            }
        });
    }
}
