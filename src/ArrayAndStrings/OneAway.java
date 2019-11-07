package ArrayAndStrings;

// Test Cases
// 1. Empty strings
// 2. Whitespaces
// 3. Case Sensitive
// 4. Any of the two strings can be smaller
// 5. strings of lengths with difference of more than 1
// Read: https://stackoverflow.com/questions/2965747/why-do-i-get-an-unsupportedoperationexception-when-trying-to-remove-an-element-f
// Read: https://stackoverflow.com/questions/12792423/declaring-list-l-new-arraylist-and-arraylist-al-new-arraylist
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OneAway {

    public static boolean isOneWay(String stringOne, String stringTwo){

        if(Math.abs(stringOne.length()-stringTwo.length()) > 1)
            return false;

        stringOne = stringOne.toLowerCase();
        stringTwo = stringTwo.toLowerCase();
        String[] stringOneArray = stringOne.split("");
        String[] stringTwoArray = stringTwo.split("");
        List<String> stringOneArrayList = new ArrayList<>(Arrays.asList(stringOneArray));
        List<String> stringTwoArrayList = new ArrayList<>(Arrays.asList(stringTwoArray));

        Iterator<String> iterator = stringOneArrayList.iterator();
        int differenceFound = 0;
        while(iterator.hasNext()) {
            String s = iterator.next();
            if (stringTwoArrayList.contains(s)) {
                iterator.remove();
                stringTwoArrayList.remove(s);
            } else {
                differenceFound++;
            }
        }
        if(differenceFound<=1)
            return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println(isOneWay("pale","bale"));
    }
}
