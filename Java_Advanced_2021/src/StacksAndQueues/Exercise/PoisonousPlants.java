package StacksAndQueues.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;


public class PoisonousPlants {
    private static void reverse(ArrayDeque<Integer> queue)
    {
        ArrayDeque<Integer> s = new ArrayDeque();  //create a stack

        //while the queue is not empty
        while(!queue.isEmpty())
        {  //add the elements of the queue onto a stack
            s.push(queue.poll());
        }

        //while the stack is not empty
        while(!s.isEmpty())
        { //add the elements in the stack back to the queue
            queue.offer(s.pop());
        }

    }

    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPlants = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> pesticidePerPlant = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        reverse(pesticidePerPlant);
        boolean areDying = true;
        int days = 0;
        while (areDying){
            int currentSize = pesticidePerPlant.size();
            for (int i = 0; i < currentSize - 1; i++) {
                int currentIndex = pesticidePerPlant.peek();
                if(pesticidePerPlant.poll() <= pesticidePerPlant.peek()){
                    pesticidePerPlant.offer(currentIndex);
                }
            }

            if(pesticidePerPlant.size() > 2)pesticidePerPlant.offer(pesticidePerPlant.poll());

            if(currentSize - pesticidePerPlant.size() == 0) {
                areDying = false;
                continue;
            }else {
                days++;
            }
        }

        System.out.println(days);

        //solution 3
//        int[] days = new int[numberOfPlants];
//        ArrayDeque<Integer> indices = new ArrayDeque<>();
//        indices.push(0);
//        for (int i = 1; i < numberOfPlants; i++) {
//            int maxDays = 0;
//            while (!indices.isEmpty()) {
//                if (Integer.parseInt(pesticidePerPlant[indices.peek()]) >= Integer.parseInt(pesticidePerPlant[i])) {
//                    maxDays = Math.max(maxDays, days[indices.pop()]);
//                } else {
//                    days[i] = maxDays + 1;
//                    break;
//                }
//            }
//            indices.push(i);
//        }
//
//        System.out.println(getMax(days));
    }

// solution 2
//        int days = 0;
//        boolean areDying = true;
//        ArrayDeque<String> ignoredIndices = new ArrayDeque<>();
//
//        while (areDying) {
//            int deadPlants = 0;
//            ignoredIndices.push("placehodler");
//            for (int i = numberOfPlants - 1; i > 0; i--) {
//                if (!ignoredIndices.isEmpty() && !ignoredIndices.contains(String.valueOf(i))) {
//                    for (int j = i - 1; j >= 0; j--) {
//                        if (!ignoredIndices.contains(String.valueOf(j)) && Integer.parseInt(pesticidePerPlant[i]) > Integer.parseInt(pesticidePerPlant[j])) {
//                            ignoredIndices.push(String.valueOf(i));
//                            deadPlants++;
//                            break;
//                        } else if (!ignoredIndices.contains(String.valueOf(j))) {
//                            break;
//                        }
//                    }
//                }
//            }
//
//            if (deadPlants == 0) {
//                areDying = false;
//                continue;
//            }
//
//            days++;
//        }
//
//        System.out.println(days);

// solution 1
//        int days = 0;
//        ArrayDeque<Integer> indices = new ArrayDeque<>();
//        boolean areDying = true;
//
//        while (areDying) {
//            int deadPlants = 0;
//            List<Integer> newList = new ArrayList<>();
//            newList.add(pesticidePerPlant[0]);
//            for (int i = 0; i < pesticidePerPlant.length - 1; i++) {
//                if (pesticidePerPlant[i + 1] <= pesticidePerPlant[i]) {
//                    newList.add(pesticidePerPlant[i + 1]);
//                } else {
//                    deadPlants++;
//                }
//            }
//
//            if(deadPlants == 0) {
//                areDying = false;
//                continue;
//            }
//
//            pesticidePerPlant = newList.stream().mapToInt(x -> x).toArray();
//            days++;
//
//        }
//
//
//        System.out.println(days);

// solution 0
    //        int numberOfPlants = Integer.parseInt(scanner.nextLine());
//        List<Integer> pesticidePerPlant = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        int days = 0;
//        boolean areDying = true;
//
//        while (areDying){
//            List<Integer> removedIndexes = new ArrayList<>();
//            for (int i = 0; i < pesticidePerPlant.size() - 1; i++) {
//                if (pesticidePerPlant.get(i + 1) > pesticidePerPlant.get(i)){
//                    removedIndexes.add(i + 1);
//                }
//            }
//            if (removedIndexes.isEmpty()){
//                areDying = false;
//                continue;
//            }else {
//                List<Integer> newList = new ArrayList<>();
//                for (int i = 0; i < pesticidePerPlant.size(); i++) {
//                    if(!removedIndexes.contains(i)){
//                        newList.add(pesticidePerPlant.get(i));
//                    }
//                }
//                pesticidePerPlant.clear();
//                removedIndexes.clear();
//                pesticidePerPlant = newList;
//            }
//
//            days++;
//        }
//
    // solution 3 extension
//        System.out.println(days);
//    public static Integer getMax(int[] array) {
//        int max = Integer.MIN_VALUE;
//        for (int num : array) {
//            if (num > max) {
//                max = num;
//            }
//        }
//        return max;
//    }
}


