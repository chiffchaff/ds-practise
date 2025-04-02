import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 380
public class RandomizedSet {
    List<Integer> integerList = new ArrayList<>();
    Map<Integer,Integer> integerMap = new HashMap<>(); // key : number , value = index of the number in list
    int counter = 0;
    public RandomizedSet() {
        integerList.clear();
        integerMap.clear();
    }

    public boolean insert(int val) {
        boolean result = false;
        if(!integerMap.containsKey(val)){
            int index = counter++;
            integerList.add(index,val);
            integerMap.put(val,index);
            result = true;
        }
        return result;
    }

    public boolean remove(int val) {
        boolean result = false;
        if(integerMap.containsKey(val)){
            int index = integerMap.get(val);
            integerList.remove(index);
            integerMap.remove(val);
            result = true;
            counter--;
        }
        return result;
    }

    public int getRandom() {
        int size = integerList.size();
        int randomIndex = (int)(Math.random() * size);
        return integerList.get(randomIndex);
    }
    @Test
    public void testing(){

        System.out.println(insert(1));
        System.out.println(remove(2));
        System.out.println(insert(2));
        System.out.println(getRandom());
        System.out.println(remove(1));
        System.out.println(insert(2));
        System.out.println(getRandom());
    }

    @Test
    public void testing1(){
        System.out.println(insert(0));
        System.out.println(insert(1));
        System.out.println(remove(0));
        System.out.println(insert(2));
        System.out.println(remove(1));
        System.out.println(getRandom());

        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        //[[],[0],[1],[0],[2],[1],[]]

    }
}
