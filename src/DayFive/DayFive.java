package DayFive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayFive {
    public static void main(String[] args) {
        String filename = "hyperskill-dataset-119058310.txt";
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            Points[] points = new Points[10];
            int count = 0;
            double val = 0.0;

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] coords = (line.split(","));

                // x and y coordinates
                double x = Double.parseDouble(coords[0]);
                double y = Double.parseDouble(coords[1]);
                points[count] = new Points(x,y);
                count++;
            }

            Points p1 = points[0];
            System.out.println(points.length);
            System.out.println(p1.x);

            for(int current = 0 ; current < points.length ; current++){
                // you can
                // int next = (i + 1) % count;

                int next = (current + 1) % count;

//                if(k == points.length  - 1){
//                    val += (points[points.length - 1].x * p1.y) - (p1.x * points[points.length - 1].y);
//                    break;
//                }
                val += (points[current].x * points[next].y) -(points[next].x * points[current].y);
            }


            double area = Math.abs(val) / 2.0;

            System.out.printf("%.2f%n", area);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
