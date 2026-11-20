import java.util.Arrays;

public class Comparators {

    public static void main(String[] args){

        Integer[] arr = {4,2,1,6,9,0,7,8,5};

        Arrays.sort(arr,(Integer a,Integer b)->a -b);

        for(Integer item:arr){
            System.out.println(item);
        }
    }
}
