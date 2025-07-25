package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ConstantTimeDataStructure {



    List<Integer> arr = new ArrayList<>();
    Map<Integer , Integer> hashMap = new HashMap<>();

    public void insert(int x){
        if(!hashMap.containsKey(x)){
            arr.add(x);
            hashMap.put(x , arr.size()-1);
        }
    }

    public void remove(int x){
        if(hashMap.containsKey(x)){
            int index = hashMap.get(x);
            int len = arr.size();
            int temp = arr.get(len-1);
            arr.set(arr.size()-1 , x);
            arr.set(index , temp);
            arr.remove(index);
            hashMap.remove(x);
        }
    }

    public int search(int x){
        return hashMap.getOrDefault(x , -1);
    }

    public int getRandom(){
        Random random = new Random();
        int nextInt = random.nextInt(arr.size());
        return arr.get(nextInt);
    }
}
