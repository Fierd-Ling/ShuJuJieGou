/**
 * @author ZhongLingYun
 * @Title: Main
 * @Description: 测试环形队列和普通队列的性能优势
 * @date 2018/11/517:09
 */
public class Main {
    public static void main(String[] args) {
        int size=100000000;
        Long begin=System.currentTimeMillis();
        LoopQueue<Integer> loopQueue= new LoopQueue<>();
        for(int x=0;x<size;x++){
            loopQueue.add(x);
        }
        for (int x=0;x<size;x++){
            loopQueue.get();
        }
        System.out.println(System.currentTimeMillis()-begin);
    }
}
