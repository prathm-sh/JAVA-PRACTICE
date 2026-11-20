package Threading;

import java.util.*;
public class CommonElement {
    public static void main(String[] args){

        String str = "Hello";
        StringBuilder stringBuffer = new StringBuilder("Hello");

        str+=" World";
        stringBuffer.append(" World");

        System.out.println("str :: "+str);
        System.out.println("stringBugger");
        System.out.println("stringBugger :: "+stringBuffer);

//        int[] arr1 = {1, 5, 10, 20, 40, 80};
//        int[] arr2 = {6, 7, 20, 80, 100};
//        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
//
//        int i=0;
//        int j=0;
//        int k=0;
//        List<Integer> result = new ArrayList<>();
//        while(i < arr1.length && j < arr2.length && k < arr3.length){
//            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
//                result.add(arr1[i]);
//                i++;
//                j++;
//                k++;
//            } else if (arr1[i] < arr2[j]) {
//                i++;
//            }else if (arr2[j] < arr3[k]) {
//                j++;
//            }else{
//                k++;
//            }
//        }
//
//        System.out.println(result);
    }
}
