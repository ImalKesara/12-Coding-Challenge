package DayTwo;

import java.io.*;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {
        String fileName = "hyperskill-dataset-118995395.txt";

        System.out.println(fileName.charAt(0));

        File file = new File(fileName);
        try {
            int targetAvg = 0;
            int[] arrNumbers;
            int distance = 0;
            Scanner sc = new Scanner(file);
            if(sc.hasNextLine()){
                String value = sc.nextLine();
                targetAvg = Integer.parseInt(value);
            }
            if(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] arr = line.split(",");
                arrNumbers = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    arrNumbers[i] = Integer.parseInt(arr[i]);
                }

                int left = 0;
                int right = arrNumbers.length - 1;

                while(left < right){
                    int currentAvg = ((arrNumbers[left] + arrNumbers[right]) / 2);
                    if(currentAvg < targetAvg){
                        left++;
                    } else if (currentAvg > targetAvg) {
                        right--;
                    }else{
                        System.out.println(arrNumbers[left] + " " + arrNumbers[right]);
                        System.out.println(Math.round((arrNumbers[left] + arrNumbers[right])/2.0));
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}