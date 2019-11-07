package ArrayAndStrings;

// Test Cases
// 1. null String
// 2. Case Sensitive
// 3. aabaaccab
// 4. if lengths of input and output strings are different

public class StringCompression {

    public static int lengthOfCompressedString(String str){
        int consecutive = 0;
        int finalLength = 0;
        for(int i=0;i<str.length();i++){
            consecutive++;
            if(i+1<str.length() && str.charAt(i)!=str.charAt(i+1)){
                finalLength += 1+1; //1 for a and 1 for 2.
                consecutive=0;
            }
        }
        return finalLength;
    }

    public static String compressString(String str){
        int compressedStringLength = lengthOfCompressedString(str);
        System.out.println(compressedStringLength);
        if(compressedStringLength>=str.length())
            return str;
        else{
            StringBuilder compressedString = new StringBuilder(compressedStringLength);
            int consecutive = 0;
            for(int i=0;i<str.length();i++){
                consecutive++;
                if(i+1<str.length() && str.charAt(i)!=str.charAt(i+1)){
                    compressedString.append(str.charAt(i));
                    compressedString.append(consecutive);
                    consecutive=0;
                }
            }
            return compressedString.toString();
        }
    }

    public static void main(String[] args){
        System.out.println(compressString("aabcccccaaad"));
    }
}
