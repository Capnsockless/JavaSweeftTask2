import java.util.Arrays;
import java.util.List;

public class Solutions {
    //N1
    public static int evaluateString(String expression){
        Integer result = 0;
        String nextnum = "";
        char prev = ' ';
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            if (curr == '+' || curr == '-'){
                if (prev == ' '){ //Init
                    result = Integer.parseInt(nextnum);
                    nextnum = "";
                    prev = curr;
                    continue;
                }

                if (prev == '+'){
                    result += Integer.parseInt(nextnum);
                }else if (prev == '-'){
                    result -= Integer.parseInt(nextnum);
                }
                nextnum = "";
                prev = curr;
            }

            if (Character.isDigit(curr)) {
                nextnum += curr;
            }
        }

        if (prev == '+'){
            result += Integer.parseInt(nextnum);
        }else if (prev == '-'){
            result -= Integer.parseInt(nextnum);
        }

        return result;
    }

    //N2
    public static int numberOfHappyStrings(List<String> strings){
        int count = 0;

        for (String st : strings) {
            if (st.isEmpty()) continue;

            boolean isHappy = true;
            char prev = st.charAt(0);
            for (int i = 1; i < st.length(); i++) {
                char curr = st.charAt(i);

                if (curr == prev){
                    isHappy = false;
                    break;
                }

                prev = curr;
            }

            if (isHappy) count++;
        }

        return count;
    }

    //N4
    public static int[] findIntersection(int[] nums1, int[] nums2){
        int result[] = new int[Math.max(nums1.length, nums2.length)];
        int i = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2){
                if (n1 == n2){
                    boolean alreadyIn = false;
                    for (int r : result){
                        if (n1 == r){
                            alreadyIn = true;
                            break;
                        }
                    }
                    if (!alreadyIn){
                        result[i] = n1;
                        i++;
                    }
                }
            }
        }

        int resized[] = new int[i];

        System.arraycopy(result, 0, resized, 0, i);

        return resized;
    }

    //N5
    public static int lenOfLongSubarr(int[] array, int k){
        int sum = 0;
        for (int val : array) {
            sum += val;
        }
        if (sum == k){
            return array.length;
        }

        int nmax = 0;
        for (int i=0; i < array.length; i++){
            int[] subArr = new int[array.length-1];
            int c = 0;
            for (int m=0; m < array.length; m++){
                if (i != m){
                    subArr[c] = array[m];
                    c++;
                }
            }

            int sublen = lenOfLongSubarr(subArr, k);
            if (sublen > nmax) nmax = sublen;
        }

        return nmax;
    }

    //N6
    public static boolean isValidSequence(int[] array, int[] sequence){
        int seqIterator = 0;
        int curr = sequence[seqIterator];
        for (int n1 : array) {
            if (n1 == curr){
                seqIterator++;
                if (seqIterator < sequence.length) {
                    curr = sequence[seqIterator];
                }
            }
        }

        return sequence.length == seqIterator;
    }
}
