import com.beust.ah.A;
import org.junit.Test;

import java.util.*;

//leetcode 347
public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        Map<Integer, List<Integer>> keyFrequencyGroup = new HashMap();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            keyFrequencyGroup.computeIfAbsent(entry.getValue(), i -> new ArrayList<>()).add(entry.getKey());
        }
        List<Integer> output = new ArrayList<>();
        for (int frequency : keyFrequencyGroup.keySet()) {
            if (frequency >= k) {
                output.addAll(keyFrequencyGroup.get(frequency));
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }


        int[] output = new int[k];
        int counter = 0;
        boolean breakFlag = false;
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (int j : buckets[i]) {
                    output[counter++] = j;
                    if (counter >= k) {
                        breakFlag = true;
                        break;
                    }
                }
            }
            if (breakFlag)
                break;
        }

        return output;
    }

    @Test
    public void testing() {
//        int [] input = {1,1,1,5,5,7};
        int [] input = {-1,-1,-1,5,5,-10};
//        int [] input = {1,2,1};
        int k = 2;
//        int [] input = {1,1,1,2,2,3};
//        int[] input = {1};
//        k=1;
        int[] output = topKFrequent3(input, k);
        System.out.println("Output::" + Arrays.toString(output));
    }


    public int[] topKFrequent2(int[] nums, int k) {
        //Step 1: Create frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int no : nums) {
            frequencyMap.put(no, frequencyMap.getOrDefault(no, 0) + 1);
        }

        //Step 2: Sort and store top k elements in max heap
        PriorityQueue<Node> pq = new PriorityQueue<>(k,(i,j)->j.frequency - i.frequency);
        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet()){
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }
        //Step 3: Create output from k max Heap
        int output[] = new int[k];
        for(int i=0;i<k;i++){
            output[i]=pq.poll().number;
        }
        return output;
    }





    public int[] topKFrequent3(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        int[] freq = new int[max - min + 1];

        for (int n : nums) {
            freq[n - min]++;
        }

        ArrayList<Integer>[] freqArr = new ArrayList[nums.length+1];

        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (freqArr[freq[i]] == null) {
                    freqArr[freq[i]] = new ArrayList<Integer>();
                }
                freqArr[freq[i]].add(i + min);
            }
        }

        int[] res = new int[k];

        int kk = 0;
        for (int i=freqArr.length-1; i>=0; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size(); j++) {
                    res[kk] = freqArr[i].get(j);
                    kk++;

                    if (kk >= k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }



}

class Node{
    int number;
    int frequency;
    public Node(int number,int frequency){
        this.frequency = frequency;
        this.number =number;
    }
}
