package tree;

import java.util.Arrays;

/**
 * @author ZhongLingYun
 * @Title: HeapMap
 * @Description: 优先队列
 * @date 2018/11/2614:37
 */
public class HeapMap<T extends Comparable<T>> {

    /**
     * @Description: 动态数组
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/11/26 15:11
     */
    class Array<E>{
        int starSize=10;

        int size=0;

        E[] array= (E[]) new Object[starSize];

        /**
         * @Description: TODO
         * @param: [e]
         * @return: void
         * @auther: ZhongLingYun
         * @date: 2018/11/26 16:53
         */
        public void add(E e){
            array[size]=e;
            change();
            size++;
        }

        /**
         * @Description: 获取数组内容
         * @param: [position]
         * @return: E
         * @auther: ZhongLingYun
         * @date: 2018/11/26 15:03
         */
        public E get(int position){
            if(0>position||position>size-1){
                throw  new RuntimeException("数组下标越界");
            }
            return array[position];
        }

        /**
         * @Description: 修改数组中的值
         * @param: [position, e]
         * @return: void
         * @auther: ZhongLingYun
         * @date: 2018/11/26 16:53
         */
        public void set(int position,E e){
            if (position<0||position>size-1){
                throw new RuntimeException("数组下标越界");
            }
            array[position]=e;
        }

        /**
         * @Description: 改变数组大小
         * @param: []
         * @return: void
         * @auther: ZhongLingYun
         * @date: 2018/11/26 14:55
         */
        private void change(){
            if (array.length<size*2){
                array= Arrays.copyOf(array,array.length*2);
                return;
            }
            if (array.length>size*4&&size>3){
                array=Arrays.copyOf(array,array.length/2);
                return;
            }
        }

        @Override
        public String toString() {
            return "Array{" +
                    "array=" + Arrays.toString(array) +
                    '}';
        }
    }

    private Array<T> array =new Array<>();

    private int size=0;

    /**
     * @Description: 给堆中添加一个元素
     * @param: [t]
     * @return: void
     * @auther: ZhongLingYun
     * @date: 2018/11/26 17:34
     */
    public void add(T t){
        array.add(t);
        lift(size);
        size++;
        System.out.println(array.toString());
    }

    public T get(){
        // 优先队列中第一个一定是最大的
        T t=array.get(0);
        size--;
        // 将最后一个元素放root，保证树的结构
        array.set(0,array.get(size));
        drop(0);
        // 最后一个置为null
        array.set(size,null);
        System.out.println(array.toString());
        return t;
    }

    /**
     * @Description: 下虑,保证堆的特性
     * @param: [position]
     * @return: void
     * @auther: ZhongLingYun
     * @date: 2018/11/27 18:28
     */
    private void drop(int position){
        int son=getChild(position);
        // 如果父节点小于最大的子节点
        boolean flag=array.get(position).compareTo(array.get(son))<0;
        while (flag){
            T t=array.get(position);
            // 子节点放置在父节点
            array.set(position,array.get(son));
            array.set(son,t);
            position=son;
            son=getChild(position);
            flag=array.get(position).compareTo(array.get(son))<0;
        }
    }

    /**
     * @Description: 上虑保持二叉堆的性质
     * @param: [position]
     * @return: void
     * @auther: ZhongLingYun
     * @date: 2018/11/26 17:26
     */
    private void lift(int position){
        int fatherStation=getFatherStation(position);
        boolean flag=array.get(position).compareTo(array.get(fatherStation))>0;
        while(flag){
            change(fatherStation,position);
            position=fatherStation;
            fatherStation=getFatherStation(position);
            flag=array.get(position).compareTo(array.get(fatherStation))>0;
        }
    }

    /**
     * @Description: 如果子节点大于父节点交换位置
     * @param: [father, son]
     * @return: void
     * @auther: ZhongLingYun
     * @date: 2018/11/26 17:23
     */
    private void change(int father,int son){
        boolean flag=array.get(son).compareTo(array.get(father))>0;
        if (flag){
            // 如果子节点大于父节点交换位置
            T t=array.get(father);
            array.set(father,array.get(son));
            array.set(son,t);
            return;
        }
    }

    /**
     * @Description: 获取父节点的位置
     * @param: [position]
     * @return: int
     * @auther: ZhongLingYun
     * @date: 2018/11/26 17:33
     */
    private int getFatherStation(int position) {
        if (position == 0) {
            return 0;
        }
        return position / 2;
    }

    /**
     * @Description: 获取两个孩子中最大的孩子的位置
     * @param: [position]
     * @return: int
     * @auther: ZhongLingYun
     * @date: 2018/11/27 18:24
     */
    private int getChild(int position){
        boolean leftChild=position*2+1<=size-1;
        boolean rightChild=position*2+2<=size-1;
        // 只有左孩子
        if (leftChild && !rightChild){
            return position*2+1;
        }
        // 只有右孩子
        if (!leftChild && rightChild){
            return position*2+2;
        }
        // 左右孩子都没有
        if (!leftChild && !rightChild){
            return position;
        }
        // 左右孩子都有
        boolean compare=array.get(position*2+1).compareTo(array.get(position*2+2))>0;
        if (compare){
            return position*2+1;
        }
        return position*2+2;
    }
}

class TestHeapMap{
    public static void main(String[] args) {
        HeapMap<Integer> heapMap= new HeapMap<>();
        for (int x=0;x<1000;x++){
            int d= (int) (Math.random()*10000);
            heapMap.add(d);
        }
        System.out.println();
        for (int x=0;x<10;x++){
            heapMap.get();
        }
    }
}
