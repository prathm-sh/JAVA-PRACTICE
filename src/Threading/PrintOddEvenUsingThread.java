package Threading;

//        Print odd and even numbers using two separate threads.

class CounterVariable{
    public static int conter = 1;
}

class PrintOddEven{

    public synchronized void printOdd(){
        while(CounterVariable.conter < 10){
            while(CounterVariable.conter%2 == 0) {
                try {
                    wait();
                } catch (Exception e) {

                }
            }

            if(CounterVariable.conter%2 != 0){
                System.out.println(CounterVariable.conter+ "This number is Odd "+Thread.currentThread().getName());
                CounterVariable.conter++;
                notifyAll();

            }
        }
    }

    public synchronized void printEven(){
        while(CounterVariable.conter < 10){
            while(CounterVariable.conter%2 != 0) {
                try {
                    wait();
                } catch (Exception e) {

                }
            }

            if(CounterVariable.conter%2 == 0){
                System.out.println(CounterVariable.conter+ "This number is Even "+Thread.currentThread().getName());
                CounterVariable.conter++;
                notifyAll();

            }
        }
    }
}

public class PrintOddEvenUsingThread {
    public static void main(String[] args){
        PrintOddEven printOddEven = new PrintOddEven();
        Thread evenThread = new Thread(()->{
            printOddEven.printEven();
        },"EvemThread");

        Thread oddThread = new Thread(()->{
            printOddEven.printOdd();
        },"OddThread");

        evenThread.start();
        oddThread.start();
    }
}