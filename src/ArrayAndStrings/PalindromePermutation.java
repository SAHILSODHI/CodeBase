package ArrayAndStrings;

// Test Cases
// 1. Empty String
// 2. Whitespaces
// 3. Case Sensitive
// 4. Numbers of characters can be 4,5 or more and not just 2 therefore %2.
// Only number of odd characters should be less than 1 would suffice both odd and even cases.

public class PalindromePermutation {

    public static boolean isPalindromePermutation(String input){
        int counter = 0;
        input = input.toLowerCase();
        input = input.replaceAll(" ","");
        if(input.length()<=0)
            return false;
        char[] inputCharacterArray = input.toCharArray();
        for(char c: inputCharacterArray){
            if((counter & (1<<c)) >0){
                counter &= ~(1<<c);         // Revise this
            } else{
                counter |= 1<<c;
            }
        }
//        System.out.println(Integer.toBinaryString(counter));
        int countOfOddNumbers = 0;
        for(int i=0; i<26; i++){
            if((counter & (1<<i))>0){
                countOfOddNumbers++;
            }
        }
// Another way to check if only one occurrence of 1 in a number is
//        if((counter & (counter-1))==0){
//            return true;
//        }
        if(countOfOddNumbers<=1)
            return true;
        else return false;
    }

    public static void main(String[] args){
        System.out.println(isPalindromePermutation("  s a h "));
    }
}
