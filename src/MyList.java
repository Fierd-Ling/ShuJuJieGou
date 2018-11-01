import java.util.Arrays;
import java.util.List;

/**
 * @author ZhongLingYun
 * @Title: MyList 修改为泛型数组
 * @Description: list
 * @date 2018/10/319:14
 */
public class MyList<E> {

    /**
    * 数组总容量
    * */
    private int count=5;

    /**
     * 实际存储数据量
     * */
    private int size=0;


    /**
     * 底层数组定义 Java中没有泛型数组，只能通过object数组强转
     * */
    private E[] listArray= (E[]) new Object[count];

    /**
     * 添加数据方法
     * 添加锁可以保证并发过程数据安全，但
     * */
    public synchronized void add(E x){
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
    public E get(int x){
        return listArray[x];
    }

    /**
     * 底层数组扩容
     * */
    private E[] createNewArray(E[] array, int s){
        double x = 0;
        if(s>0){
            // 实际存储的长度/数组定义的长度，当实际存储的长度达到数组自定义的75%就扩容，每次扩容为 原来的1.5
            x=(double) s/array.length;
        }
        if(x>=0.8){
            // 扩大到2倍
            array =Arrays.copyOf(array,listArray.length*2);
        }
        return array;
    }

    /**
     * 减少数组容量
     * */
    private void cutArray(){
         // 数组实际存储的数据只有目前数组长度的1/4
        if(size<=listArray.length/4){
            // 缩减到原来数组的一半，防止时间复杂度震荡
            listArray=Arrays.copyOf(listArray,listArray.length/2);
        }
    }

    /**
     * 删除某一个位置的元素
     * */
    public synchronized E remove(int x){
        E ret=listArray[x];
        for (int i=x;i<size-1;i++){
            listArray[i]=listArray[i+1];
        }
        size--;
        // 确保Java回收机制可以回收
        listArray[size]=null;
        // 删除数据之后减少数组长度
        cutArray();
        return ret;
    }
}

class d{
    public static void main(String[] args) {
        //  采用泛型数组 泛型 中不能有基本数据类型
        MyList<Integer>  myList= new MyList();
        for (int x=0;x<1000;x++){
            myList.add(x);
        }
        for(int z=0;z<myList.length();z++){
            System.out.println(myList.get(z));
        }
        System.out.println();
        for (int x=0;x<700;x++){
            myList.remove(2);
        }
        for(int z=0;z<myList.length();z++){
            System.out.println(myList.get(z));
        }
    }
}




