package ArrayAndStrings;

public class IsUnique {

    static boolean isUnique(String testString){
        if(testString.length()>128)
            return false;
        int checker = 0;
        for(int i=0;i<testString.length();i++){
            if((checker & (1<< testString.charAt(i)-'a')) > 0){
                return false;
            }
            checker |= 1<<testString.charAt(i)-'a';
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isUnique(""));
    }
}

// test cases
// 1. empty string with "" or a whitespace " "
// 2. numbers in string
// 3. case sensitive