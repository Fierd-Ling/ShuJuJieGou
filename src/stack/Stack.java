package stack;

import java.util.Arrays;

/**
 * @author ZhongLingYun
 * @Title: stack.Stack
 * @Description: 自己实现一个栈
 * @date 2018/11/29:40
 */
public class Stack<E> {
    /**
     * 初始数组长度
     * */
    private int count=5;

    /**
     * 初始实际数组中存贮的数据量
     * */
    private int size=0;

    /**
     * 栈的底层数组
     * */
    private E[] array= (E[]) new Object[count];

    /**
     * 往栈里面添加一个元素
     * */
    public  void add(E e){
        // 加锁防止高并发的情况
        // TODO 锁太重，需要使用轻量级的锁
        synchronized (array){
            array[size]=e;
            judge();
        }
        size++;
    }

    /**
     * 从栈中取出数据
     * */
    public  E get(){
        // 栈遵循的是先进后出的原则
        synchronized (array){
            // 当有1和数据时，在数组中的位置实际上是0
            size--;
            judge();
            return array[size];
        }
    }

    /**
     * 判断数组是增长还是变短
     * */
    private void judge(){
        // 当实际存贮的长度超过数组的一半开始扩容
        if(size !=0 && array.length/size<2){
            // 扩大到原来数组长度的1.5
            synchronized (array){
                array= Arrays.copyOf(array, (int) (array.length*1.5));
            }
        }
        // 当实际存储的长度是定义的长度的1/3
        if (size !=0 && size !=1 && array.length/size>=3 ){
            // size长度等于0和等于1不需要缩小容量，缩小的容量是原来数组长度的1/2，防止时间复杂度震荡
            synchronized (array){
                array=Arrays.copyOf(array,array.length/2);
            }
        }
    }

    /**
     * 判断这个栈是否是空的
     * */
    public boolean isEmpty(){
        boolean flag=false;
        if (size==0){
            flag=true;
        }
        return flag;
    }

    /**
     * 栈的实际存储数据的长度
     * */
    public int size(){
        return size;
    }

    /**
     * 观察数组长度变化
     * */
    public void out(){
        System.out.println(array.length);
    }

}

/**
 * 测试栈
 * */
class TestStack{
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();
        for (int x=0;x<100;x++){
            stack.add(x);
        }
        stack.out();
        System.out.println("--------------------------------");

        for(int x=0;x<80;x++){
            stack.get();
        }
        System.out.println(stack.size());
        stack.out();

    }


}
