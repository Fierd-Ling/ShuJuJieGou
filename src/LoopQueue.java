
/**
 * @author ZhongLingYun
 * @Title: LoopQueue
 * @Description: 循环队列
 * @date 2018/11/511:07
 */
public class LoopQueue<E> {

    private int begin=0,end=0,size=0;

    /**
     * 环形队列人为的浪费一个空间，便于队列的判断
     * */
    private E[] array= (E[]) new Object[5+1];

    /**
     *队列中插入数据
     */
    public void add (E e){
        createNewArray();
        // 环形队列在逻辑上是环形, 只要保证结束的指针%数组的长度的值有空位就行
        array[end % array.length]=e;
        // 结束指针后移
        end++;
        size++;
    }

    /**
     * 取出队列中的第一数
     * */
    public E get(){
        createNewArray();
        // 环形队列指到的地7个数是在数组的第一个位置
        E e=array[begin % array.length];
        // 起始指针后移
        begin++;
        size--;
        return e;
    }

    /**
     * 数组扩容和缩容
     * */
    private void createNewArray(){
        // 数组差一个位置就满了,进行扩容
        if((end+1) % array.length == begin % array.length){
             // 减一是为了为了保证数组的长度刚好为原来长度的2倍同时刚好有一个可以浪费
            E[] newArray=(E[]) new Object[array.length*2-1];
            for(int x=0;x<array.length-1;x++){
                newArray[x]=array[begin % array.length];
                begin++;
            }
            // 拷贝完成begin和end归位
            begin=0;
            end=array.length-1;
            array=newArray;
        }
        // 实际存储的数据量是数组的1/4，进行缩容变为原来长度的1/2
        if(size!=0 && array.length/size>4 && size!=1){
            // 保证刚好多一个空位
            E[] newArray = (E[]) new Object[(array.length-1)/2+1];
            for(int x=0;x<size;x++){
                newArray[x]=array[begin % array.length];
                begin++;
            }
            // 拷贝完成begin和end归位
            begin=0;
            end=size-1;
            array=newArray;
        }
    }
}

