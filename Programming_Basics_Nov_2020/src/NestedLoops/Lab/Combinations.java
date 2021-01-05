package NestedLoops.Lab;

import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int x = 0; x <= n; x++){
            for(int y = 0; y <= n; y++){
                for(int z = 0; z <= n; z++){
                    int result = x + y + z;
                            if(result == n){
                                count++;
                            }
                }
            }
        }

        System.out.println(count);
    }
}
