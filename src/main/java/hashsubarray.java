import java.util.*;

public class hashsubarray {
    public static int Totalsubarray(ArrayList<Integer> arr,int K){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int i=0;i<arr.size();i++){
            sum += arr.get(i);
            if (map.containsKey(sum-K)){
                ans += map.get(sum-K);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }
            else{
                map.put(sum,1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> prefarr = new ArrayList<>();
        arr.add(10);
        arr.add(2);
        arr.add(-2);
        arr.add(-20);
        arr.add(10);
        int K = -10;
        K = Totalsubarray(arr,K);
        System.out.println(K);
    }
}
