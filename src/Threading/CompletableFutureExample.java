package Threading;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args){
        //Create a Callable task that returns the sum of two numbers.

        CompletableFuture.completedFuture(10).thenApplyAsync((a)->{
            return a+20;
        }).thenAccept(result -> System.out.println("Result => "+result));


        Callable cb = ()-> {
            return 10+20;
        };

        System.out.println("Main thread is not block");

        try{
            System.out.println("Call => "+cb.call());
            Thread.sleep(5000);
        }catch (Exception e){}
    }
}
