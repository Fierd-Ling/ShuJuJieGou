package queue;

import java.util.Arrays;

/**
 * @author ZhongLingYun
 * @Title: queue.MyQueue
 * @Description: queue的底层实现
 * @date 2018/11/59:34
 */
public class MyQueue<E> {

    private int count=5;
    private E[] array=(E[]) new Object[count];
    private int size=0;

    /**
     * 队列里面添加一个元素
     * */
    public void push(E e){
        array[size]=e;
        size++;
        createNewArray();
    }

    /**
     * 获取队列的长度
     * */
    public int length(){
        return size;
    }

    /**
     * 队列是否为空
     * */
    public boolean isEmpty(){
        return size<=0;
    }

    /**
     * 获取队列第一个元素
     * */
    public E enQueue(){
        E e=array[0];
        size--;// 假如数组中只有三个个元素，目前size是等于3，实际索引是2，拿走一个
        // 索引是2，需要前移一个,0位置等于1位置1位置等于2位置
        for (int x=0;x<size;x++){
            array[x]=array[x+1];
        }
        return e;
    }

    private void createNewArray(){
        // 实际存储的长度超过数组长度一半扩容
        if(count/size<2 && size !=0 && size !=1){
            array= Arrays.copyOf(array,array.length*2);
        }
        // 数组的实际存储的数据小于数组的长度的1/4缩小容量
        if(count/size>4 && size !=0 && size !=1){
            array=Arrays.copyOf(array,array.length/2);
        }
    }
}

class TestMyQueue{
    public static void main(String[] args) {
        MyQueue<Integer> myQueue= new MyQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x=0;x<20;x++){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    myQueue.push(x);
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int x=0;x<20;x++){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(myQueue.enQueue());
                }
            }
        }).start();
    }
}
