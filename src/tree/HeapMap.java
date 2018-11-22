package tree;

import java.util.Arrays;

/**
 * @author ZhongLingYun
 * @Title: Heap
 * @Description: 堆实现
 * @date 2018/11/229:52
 */
public class HeapMap<E extends Comparable<E>>{
    private int cup=8;

    private int size=0;

    private E[] arrays;

    public HeapMap(){
        arrays=(E[]) new Object[cup];
    }

    /**
     * 添加一个元素
     */
    public void add(E e){
        arrays[size]=e;
        // 上浮保证堆性质
        lift(size);
        size++;
        expend();
    }

    /**
     * 查看堆中最大的元素是哪个
     * */
    public E kookMax(){
        if(size==0){
            return null;
        }
        return arrays[0];
    }

    /**
     * 从堆中取出堆顶部的元素
     * */
    public E getTop(){
        if (size==0){
            return null;
        }
        E e=kookMax();
        // 先把最后一个元素放在顶部维持树结构
        arrays[0]=arrays[size-1];
        arrays[size-1]=null;
        down(0);
    }

    private void down(int position){
        boolean flag=true;
        while(flag){



        }

    }

    /**
     * 返回左右孩子大的孩子的位置
     * */
    private int compareChild(int position){
        int left=getLeftChild(position);
        int right=getRightChild(position);
        if(left!=-1&&right==-1){
            return left;
        }
        if (left==-1&&right!=-1){
            return right;
        }
        if(left!=-1&&right!=-1){
            E leftChile=arrays[left];
            E rightChild=arrays[right];
            boolean flag=leftChile.compareTo(rightChild)>0;
            if(flag){
                return left;
            }
            return right;
        }
        // 没有孩子，已经到叶子节点了
        return position;

    }

    /**
     * 获取左孩子的位置
     * */
    private int getLeftChild(int position){
       int left=position*2+1;
       if (left>size){
           // 超过
           return -1;
       }
       return left;
    }

    /**
     * 获取右孩子的位置
     * */
    private int getRightChild(int position){
        int right=position*2+2;
        if (right>size){
            return -1;
        }
        return right;
    }


    /**
     * 进行上浮保证堆性质
     * */
    private void lift(int position){
        if(position==0){
            // root节点不能再继续上浮
            return;
        }
        boolean flag=true;
        while(position!=0&&flag){
            int fatherPosition=getFatherPosition(position);
            changeToMax(fatherPosition,position);
            position=fatherPosition;
            flag=arrays[position].compareTo(arrays[getFatherPosition(position)])>0;
        }
    }

    /**
     * 获取父节点位置
     * */
    private int getFatherPosition(int position){
        // 索引从0开始计算
        return position/2;
    }

    /**
     * 父子节点进行交换,保证父节点比子节点大
     * */
    private void changeToMax(int father,int son){
        if(arrays[son].compareTo(arrays[father])>0){
            E e=arrays[father];
            arrays[father]=arrays[son];
            arrays[son]=arrays[father];
        }
    }

    /**
     * 数组扩容
     * */
    private void expend(){
        // 当数组的长度/2小于存储数据的1/2的时候扩容
        if(arrays.length/2<size){
            arrays= Arrays.copyOf(arrays,arrays.length*2);
        }
    }

    @Override
    public String toString() {
        return "HeapMap{" +
                "cup=" + cup +
                ", size=" + size +
                ", arrays=" + Arrays.toString(arrays) +
                '}';
    }
}
