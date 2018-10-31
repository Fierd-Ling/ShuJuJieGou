import java.util.Arrays;

/**
 * @author ZhongLingYun
 * @Title: MyList
 * @Description: list
 * @date 2018/10/319:14
 */
public class MyList {

    /**
    * 数组总容量
    * */
    private int count=5;

    /**
     * 实际存储数据量
     * */
    private int size=0;


    /**
     * 底层数组定义
     * */
    private int[] listArray= new int[count];

    /**
     * 添加数据方法
     * 添加锁可以保证并发过程数据安全，但
     * */
    public synchronized void add(int x){
        // 实现系统数组扩容
        listArray=createNewArray(listArray,size);
        listArray[size]=x;
        size++;
    }

    /**
     * 实际存储了多少的数据
     * */
    public int length(){
        return size;
    }

    /**
     * 获取某个数据
     * */
    public int get(int x){
        return listArray[x];
    }

    private int[] createNewArray(int[] array, int s){
        double x = 0;
        if(s>0){
            // 实际存储的长度/数组定义的长度，当实际存储的长度达到数组自定义的75%就扩容，每次扩容为 原来的1.5
            x=(double) s/array.length;
        }
        if(x>=0.75){
            int newLength= (int) (s*1.5);
            array =Arrays.copyOf(array,newLength);
        }
        return array;
    }
}

class d{
    public static void main(String[] args) {
        MyList  myList= new MyList();
        for (int x=0;x<2000000000;x++){
            myList.add(x);
            System.out.println(myList.length());
        }
    }
}




