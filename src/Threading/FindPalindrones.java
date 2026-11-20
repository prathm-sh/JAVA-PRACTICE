package Threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPalindrones {

    public List<String> findPalindrones(List<String> list) {

        for (int i = list.size() - 1; i >= 0; i--) {

            String currentStr = list.get(i);

            System.out.println("Starting :: " + currentStr);

            char[] charArr = currentStr.toCharArray();

            int left = 0;
            int right = charArr.length - 1;

            boolean isPalindrome = true;

            while (left < right) {

                if (charArr[left] != charArr[right]) {
                    isPalindrome = false;
                    break;
                }

                left++;
                right--;
            }

            if (!isPalindrome) {
                System.out.println("Removed :: " + currentStr);
                list.remove(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(
                Arrays.asList("happy", "bab", "nanan", "dad", "addd")
        );

        FindPalindrones findPalindrones = new FindPalindrones();

        System.out.println(
                findPalindrones.findPalindrones(list)
        );
    }
}