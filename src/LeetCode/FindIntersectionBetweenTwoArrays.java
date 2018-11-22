package LeetCode;
import java.util.ArrayList;
import java.util.List;
//求两个数组的交集
public class FindIntersectionBetweenTwoArrays {
	
	//时间复杂度O(n^2)，空间复杂度O(1)
	public ArrayList<Integer> getIntersection(int[] arr, int[] arr2) {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(arr == null || arr.length == 0 || arr2 == null || arr2.length == 0) {
			return res;
		}
		
		for(int i = 0;i < arr.length;i ++) {
			int temp = arr[i];
			for(int j = 0;j < arr2.length;j ++) {
				if(arr2[j] == temp && !res.contains(temp)) {
					res.add(temp);
					System.out.println(temp);
					break;
				}
			}
		}
		return res;
	}
		public static void main(String[] args) {
			int[] arr = {2,2,1};
			int[] arr2 = {2,2,1};
			FindIntersectionBetweenTwoArrays f = new FindIntersectionBetweenTwoArrays();
			List<Integer> res = f.getIntersection(arr, arr2);
			//System.out.println(res);
		

	}
}

