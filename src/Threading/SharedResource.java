package Threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SharedResource {
    boolean itemAvailable = false;

    public static Queue<String> bufferQueue = new ArrayBlockingQueue<>(3);

    public synchronized void addItem(String inputString){
        System.out.println("Thread inside add item");
        while(bufferQueue.size() >= 3){
            try{
                System.out.println("Queue is full waiting...");
                wait();
            }catch (Exception e){

            }
        }
        bufferQueue.offer(inputString);
        System.out.println("Added element in queue");
        notifyAll();
    }
    public synchronized void consumeItem(){
        System.out.println("Thread inside consumeItem");
        while(bufferQueue.isEmpty()){
            try{
                System.out.println("Queue is empty waiting....");
                wait();
            }catch (Exception e){

            }
        }
        bufferQueue.poll();
        System.out.println("Consumer thread consumed the item");
        notifyAll();
    }
}
