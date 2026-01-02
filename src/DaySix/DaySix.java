package DaySix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DaySix {
    public static void main(String[] args) {
        String fileName = "src/DaySix/hyperskill-dataset-119088272.txt";
        File file = new File(fileName);

        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distances = new HashMap<>();


        try {
            Scanner sc = new Scanner(file);
            String firstNode = sc.nextLine().trim();

            // put "Skate" as the first to graph
            graph.put(firstNode,new ArrayList<>());


            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] relationships = line.split(",");
                String left = relationships[0].trim();
                String right =relationships[1].trim();

                if(!graph.containsKey(left)){
                    graph.put(left,new ArrayList<>());
                }
                if(!graph.containsKey(right)){
                    graph.put(right,new ArrayList<>());
                }
                graph.get(left).add(right);
                graph.get(right).add(left);
            }

            //
            int distance = 0;

            // put "Skate" as the first to queue
            queue.add(firstNode);
            distances.put(firstNode,distance);


            while (!queue.isEmpty()){
                String currentNode = queue.poll();
                for(String neighbor : graph.get(currentNode)){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        distances.put(neighbor,distances.get(currentNode) + 1);
                        queue.add(neighbor);
                    }else{
                        continue;
                    }
                }


            }

            System.out.println(distances);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
