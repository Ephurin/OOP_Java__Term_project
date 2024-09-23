import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BoBaSoPytago {
    public static String checkPytago(ArrayList<Long> arr) {
        Collections.sort(arr);
        int check = 0;
        for (int i = 0; i < arr.size(); i++) {
            long c = arr.get(i);
            int left = 0;
            int right = i - 1;

            while (left < right) {
                long a = arr.get(left);
                long b = arr.get(right);
                if (a * a + b * b == c * c) {
                    check = 1;
                    break;
                } else if (a * a + b * b < c * c){
                    left++;

                }else{
                    right--;
                }
            }
        }
        if(check == 1) return "YES";
        else return "NO";
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- >0){
            ArrayList<Long> arr = new ArrayList<>();
            int n = sc.nextInt();
            sc.nextLine();
            String lines = sc.nextLine();
            String[] line = lines.split(" ");
            for(String i : line){
                long x = Integer.parseInt(i);
                arr.add(x);
            }
            System.out.println(checkPytago(arr));
        }
    }

}
