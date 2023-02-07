import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String text=input.next();
        LinkedHashSet<Character>temp= new LinkedHashSet();
        for (int i=0;i<text.length();i++){
            char c = text.charAt(i);
            
        
        if (!temp.contains(c)){
            temp.add(c);
        }
        }
        for (Character c:temp){
            System.out.print(c);
        }
    }
}

    

    
