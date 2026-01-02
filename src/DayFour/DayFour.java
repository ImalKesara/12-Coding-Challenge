package DayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) {
        String filename = "hyperskill-dataset-119034324.txt";
        File file = new File(filename);
        int[] pick = new int[4];
        int[] release = new int[4];
        int contention = 0;

        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(",");

                String name = parts[0];
                String status = parts[1].trim();
                int id = Integer.parseInt(parts[2]);


                System.out.println(status);
                System.out.println(id);


                if(status.equals("pick")){
                    // now check if the id is in the pick array
                    for (int i = 0; i < pick.length; i++) {
                        // means it already picked - wenne value ek asamana unoth pick wela eka tiyena value ekatama pass karnw
                        if(pick[i] == id){
                            contention++;
                            System.out.println("Contention " + contention);
                            System.out.println("++++++++++++++++++++++++++++++++++++++");
                        }else{
                            // means it is new
                            if(pick[i] == 0){
                                pick[i] = id;
                                release[i] = 0;
                                break;
                            }
                        }
                    }

                } else if (status.equals("release")) {
                    for (int k = 0; k < pick.length; k++) {
                        if(pick[k] == id){
                            pick[k] = 0;
                            release[k] = id;
                        }
                    }
                }

                System.out.println("Pick " + Arrays.toString(pick));
                System.out.println("-----------------------------------------------------");
                System.out.println("Release " +  Arrays.toString(release));
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            }

            System.out.println(contention);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
