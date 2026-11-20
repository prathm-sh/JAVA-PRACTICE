package Threading;


class SharedCounter{
    private int counter = 0;
    public SharedCounter(){

    }

    public void setIncrement(){
//        synchronized(this){
            counter+=1;
//        }
    }
    public int getCounter(){
        return counter;
    }
}

class Printing5000 {
    public static void main(String[] args) {
        /*System.out.println("Try clicking the Run button.");
        String s= "aabbccddfh";
        int indexNonRepeatChar = findNonRepeatChar(s);
        System.out.println("index is: "+ indexNonRepeatChar);
        */
        SharedCounter sc1 = new SharedCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                sc1.setIncrement();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                sc1.setIncrement();
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                sc1.setIncrement();
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                sc1.setIncrement();
        });
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                sc1.setIncrement();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (Exception e) {

        }
        System.out.println(sc1.getCounter());
    }
}