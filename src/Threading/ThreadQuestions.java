package Threading;
class Counter{
    public volatile static int count =1;
}

class A implements Runnable{
    @Override
     public void run() {
        while (Counter.count <= 20) {
            System.out.println("Counter.counter: " + Counter.count++ + " " + Thread.currentThread().getName());
        }
    }
}

public class ThreadQuestions {
    public static void main(String[] args) {
//        Create two threads using the Thread class. Print numbers from 1 to 10.
//        Create a thread using the Runnable interface.
//        Create a Callable task that returns the sum of two numbers.
//        Print odd and even numbers using two separate threads.
//        Print numbers from 1 to 20 using three threads.
//        Execute five tasks using ExecutorService.
//        Create a Fixed Thread Pool with 3 threads and submit 10 tasks.
//        Demonstrate the difference between start() and run().
//        Print the current thread name while executing multiple tasks.
//        Create a thread that sleeps for 2 seconds before printing a message.

        A obj = new A();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(new A());
        Thread t3 = new Thread(()-> System.out.println("Hello World from thread 3"));
        t1.start();
        t2.start();


    }
}