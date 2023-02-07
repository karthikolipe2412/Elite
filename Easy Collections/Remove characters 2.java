import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       Scanner remove_characters=new Scanner(System.in);
        String first_letter=remove_characters.next();
        String second_letter=remove_characters.nextLine();
        ArrayList<String>list1=new ArrayList<>();
        ArrayList<String>list2=new ArrayList<>();
        for (int i=0;i<first_letter.length();i++){
            list1.add(first_letter.substring(i,i+1));
            }
        for (int i=0;i<second_letter.length();i++){
            list2.add(second_letter.substring(i,i+1));
            }
        for(String i:list2){
            if (list1.contains(i))
                list1.remove(i);
        }
        for (String i:list1){
        System.out.print(i);
        }
    }
}
