package ArrayAndStrings;

public class CheckPermutation {

    static String sortString(String str){
        char[] strCharArray = str.toCharArray();
        java.util.Arrays.sort(strCharArray);
        // return strCharArray.toString(); This will get different results.
        return new String(strCharArray);
    }

    public static void main(String[] args){
        String stringOne = "sahil";
        String stringTwo = "sodhi";
        if(stringOne.length()!= stringTwo.length())
            System.out.println("false");
        else {
            System.out.println(sortString("sahil").equals(sortString("lihas")));
        }
    }
}


//test cases
// 1. case sensitive
// 2. white spaces