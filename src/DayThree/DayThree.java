package DayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayThree {
    public static void main(String[] args) {
        String fileName = "hyperskill-dataset-119006825.txt";
        File file = new File(fileName);
        String[] passwords = new String[50];
        double maxScore = -1.0;
        String winner = "";

        int count = 0;
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String word  = sc.nextLine();
                passwords[count] = word;
                count++;
            }

            // logic for to get the best matched password
            for (int i = 0; i < passwords.length; i++) {
                double score = 0.0;

                String password = passwords[i];

                // Rule 1
                score = password.length();


                // Rule 2
//                if(!password.matches("^[a-z]+$")){
//                    score *= 0.75;
//                }
//
//                if(!password.matches("^[A-Z]+$")){
//                    score *= 0.75;
//                }
//
//                if (!password.matches("^[0-9]+$")){
//                    score *= 0.75;
//                }
//
//                if(password.matches(".*[^a-zA-Z0-9].*")){
//                    score *= 0.75;
//                }

                if (!password.matches(".*[a-z].*")) {
                    score *= 0.75;
                }

                if (!password.matches(".*[A-Z].*")) {
                    score *= 0.75;
                }

                if (!password.matches(".*[0-9].*")) {
                    score *= 0.75;
                }

                if (!password.matches(".*[!@#$%^&*].*")) {
                    score *= 0.75;
                }


                // Rule 3
                int[] counts = new int[128];

                for (int j = 0; j < password.length(); j++) {
                    counts[password.charAt(j)]++;
                }

                System.out.println(Arrays.toString(counts));
                int mostFrequentValue = 0;
                for (int j : counts) {
                    if (j > mostFrequentValue) {
                        mostFrequentValue = j;
                    }
                }

                if( (double) mostFrequentValue / password.length() * 100 > 30 ){
                    score = score - mostFrequentValue;
                }


                if(score > maxScore){
                    maxScore = score;
                    winner = password;
                }

            }

            System.out.println(winner);
            System.out.println(maxScore);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
