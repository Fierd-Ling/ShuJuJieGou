package LeetCode;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZhongLingYun
 * @Title: BothAndArray
 * @Description: TODO
 * @date 2018/11/199:35
 */
public class BothAndArray {
    public static void main(String[] args) {
        int [] x={1,2,2,1};
        int [] y={2};
        Solutione solutione= new Solutione();
        solutione.intersect(x,y);
    }
}

class Solutione {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i : nums1) {
            l1.add(i);
        }
        for (int i : nums2) {
            l2.add(i);
        }
         Set<Integer> list= new HashSet<>();
        for (Integer i : l1) {
            for (Integer t : l2) {
                if (i.equals(t)) {
                    list.add(t);
                    break;
                }
            }
        }
        int[] arrays=new int[list.size()];
        int e=0;
        for(Integer i:list){
            arrays[e]=i;
            e++;
        }
        return arrays;
    }
}