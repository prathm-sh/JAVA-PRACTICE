public class MonitorLockExample {
    public synchronized void task1(){
        System.out.println("Task 1 Started");
        try{
            Thread.sleep(1000);
            System.out.println("Task 1 1000 mili second completed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void task2(){
        System.out.println("Task 2 started");
        synchronized (this){
            System.out.println("Task 2 Inside synchronized");
        }
    }

    public void task3(){
        System.out.println("Task 3");
    }
}
