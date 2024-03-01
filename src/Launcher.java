import java.util.ArrayList;

//Demetre Beroshvili

public class Launcher {
    public static void main(String[] args) {
        System.out.println("----------------N1----------------");
        System.out.println(Solutions.evaluateString("5+20-8+5"));

        System.out.println("----------------N2----------------");
        System.out.println(Solutions.numberOfHappyStrings(new ArrayList<>(){
            {add("abbcc"); add("abc"); add("abcabc"); add("cabcbb");}
        }));

        System.out.println("----------------N3----------------");
        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.add(1); myList.add(2); myList.add(3); myList.add(4); myList.add(5);
        System.out.println(myList);
        LinkedList<Integer> reversedList = myList.reverseList();
        System.out.println(reversedList);

        System.out.println("----------------N4----------------");
        int[] answer = Solutions.findIntersection(new int[]{1,2,3,3,4,5}, new int[]{3,4,4,5,6,7});
        for (int i=0; i < answer.length; i++){
            System.out.print(Integer.toString(answer[i]) + ' ');
        }
        System.out.println();

        System.out.println("----------------N5----------------");
        System.out.println(Solutions.lenOfLongSubarr(new int[]{6, 2, 2, 3, 4, 1}, 8));

        System.out.println("----------------N6----------------");
        System.out.println(Solutions.isValidSequence(new int[]{5,1,22,25,6,-1,8,10}, new int[]{1,6,-1,10}));
    }
}
