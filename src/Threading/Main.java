package Threading;

public class Main {
    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource();

        Thread addFirstItemThread = new Thread(()->{
           sharedResource.addItem("First Item");
        });

        Thread addSecItemThread = new Thread(()->{
            sharedResource.addItem("Second Item");
        });
        Thread addThirdItemThread = new Thread(()->{
            sharedResource.addItem("Third Item");
        });

        Thread addForthItemThread = new Thread(()->{
            sharedResource.addItem("Forth Item");
        });

        Thread addFifthItemThread = new Thread(()->{
            sharedResource.addItem("Fifth Item");
        });

        Thread consumeItemThread = new Thread(sharedResource::consumeItem);
        Thread consumeItemThread2 = new Thread(sharedResource::consumeItem);


        addFirstItemThread.start();
        addSecItemThread.start();
        addThirdItemThread.start();
        addForthItemThread.start();
        consumeItemThread.start();
        addFifthItemThread.start();
        consumeItemThread2.start();
//        addItemThread.start();

        try{
            Thread.sleep(3000);
            System.out.println(SharedResource.bufferQueue);
        }catch (Exception _) {

        }
    }
}
