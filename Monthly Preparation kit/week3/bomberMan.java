import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */
 public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
        if (n < 2)  return grid;
        
        List<String> full = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < grid.get(0).length(); i++)
            sb.append('O');
        for (int i = 0; i < grid.size(); i++)
            full.add(sb.toString());
            
        if (n%2 == 0) return full;    
        List<String> first = bomb(grid);
        if ((n+1)%4 == 0) return first;
        List<String> second = bomb(first);
        if ((n-1)%4 == 0) return second;   
        return null;
    }
    
    static List<String> bomb(List<String> grid) {
        List<String> bgrid = new ArrayList<String>();        
        for (int i = 0; i < grid.size(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < grid.get(0).length(); j++) {
                if (grid.get(i).charAt(j) == '.' &&
                    (j+1 == grid.get(0).length() || grid.get(i).charAt(j+1) == '.') &&
                    (j == 0 || grid.get(i).charAt(j-1) == '.') &&
                    (i+1 == grid.size() || grid.get(i+1).charAt(j) == '.') &&
                    (i == 0 || grid.get(i-1).charAt(j) == '.')) {
                    sb.append('O');
                }    
                else {
                    sb.append('.');
                }
            }
            bgrid.add(sb.toString());
        }    
        return bgrid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
