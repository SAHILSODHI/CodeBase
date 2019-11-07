package ArrayAndStrings;

import java.util.ArrayList;

public class URLify {

    public static String urlify(String s){
        char[] input = s.toCharArray();
        ArrayList<Character> output = new ArrayList<>();
        for(int i=0;i<input.length;i++){
            if(input[i]==' '){
                output.add('%');
                output.add('2');
                output.add('0');
            }
            else{
                output.add(input[i]);
            }
        }
        String result = new String();
        for(int i=0;i<output.size();i++){
            result += output.get(i);
        }
        return result;
    }

    public static void main(String[] args){
        String s= "Mr John Smith";
        System.out.println(urlify(s));
    }
}
