import java.util.HashMap;

public class NonRepeatingChar {
    public static void main(String[] args){
        System.out.println("Hello World");
        MonitorLockExample monitorLockExample = new MonitorLockExample();
        MonitorThread1Runnable runnableObj = new MonitorThread1Runnable(monitorLockExample);
        Thread t1 = new Thread(runnableObj);
        Thread t2 = new Thread(() -> monitorLockExample.task2());
        Thread t3 = new Thread(() -> monitorLockExample.task3());

        t1.start();
        t2.start();
        t3.start();
    }
//    Write a Java method that takes a string as input
//    and returns the index of its first non-repeating character.
//    If all characters repeat, return -1
//    or the string is empty, return -1
//            . Assume the string contains only lowercase English letters (a-z).
//    aabb -> -1
//    aabbccddfh -> 8
    private int nonRepeating(String string){

        int result =0;

        char[] charArr = string.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i< charArr.length;i++){
            char currChar = charArr[i];
            if(map.containsKey(currChar))
                map.put(currChar,map.get(currChar)+1);
            else
                map.put(currChar,1);
        }

        return result;
    }
}
