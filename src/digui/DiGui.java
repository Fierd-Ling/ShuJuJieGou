package digui;

/**
 * @author ZhongLingYun
 * @Title: DiGui
 * @Description: 递归计算1-1000
 * @date 2018/11/1315:08
 */
public class DiGui {

    public static int sum(int x){
        if(x<=0){
            // x等于0的时候不能继续递归
            return 0;
        }
        // 继续解析到下一层
        return x+sum(x-1);
    }

    public static void main(String[] args) {
       System.out.println(sum(10000));
    }
}
