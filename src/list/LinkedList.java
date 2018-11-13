package list;

/**
 * @author ZhongLingYun
 * @Title: LinkedList
 * @Description:
 * @date 2018/11/622:33
 */
public class LinkedList<E> {
    /**
     * 链表中的节点
     * 链表就是一个递归的对象思想，每个对象里面包含下一个对象
     * */
    private class Node{
        private E e;

        private Node next;

        public Node(E e){
            this.e=e;
            this.next=null;
        }

        public Node(E e,Node node){
            this.next=node;
            this.e=e;
        }
    }

    private int size=0;

    /**
     * 虚拟的头结点
     * */
    private Node dummyHead=new Node(null,null);

    /**
     * 从头部插入数据
     * */
    public void addAtHead(E e){
        // 假设null,1,2,3,4在头部插入i变为null,i,1,2,3,4
        /*dummyHead.next=new Node(e,dummyHead.next);
        size++;*/
        add(e,0);
    }

    /**
     * 在链表尾部插入
     * */
    public void addAtEnd(E e){
       /* Node point =dummyHead;
        for(int x=0;x<size;x++){
            point=point.next;
        }
        point.next=new Node(e);
        size++;*/
       add(e,size);
    }

    /**
     * 随机位置插入
     * */
    public void add(E e,int position){
        if(position<0||position>size){
            throw new RuntimeException("索引越界");
        }
        Node point =dummyHead;
        for(int x=0;x<position;x++){
            point=point.next;
        }
        point.next=new Node(e,point.next);
        size++;

    }

    /**
     * 从头部取出一个元素
     * */
    public E getAtHead(){
        if(size==0){
            throw  new RuntimeException("链表中没有数据");
        }
        /*E e=dummyHead.next.e;
        dummyHead.next=dummyHead.next.next;
        size--;
        return e;*/
        return get(0);
    }

    /**
     * 从尾部取出一个数据
     * */
    public E getAtEnd(){
        if(size==0){
            throw  new RuntimeException("链表中没有数据");
        }
        /*Node point=dummyHead;
        for(int x=0;x<size-1;x++){
           point=point.next;
        }
        E e=point.next.e;
        point.next=null;
        size--;
        return e;*/
        return get(size-1);
    }

    /**
     * 获取任意位置的值
     * */
    public E get(int position){
        if(position<0||position>=size){
            throw new RuntimeException("索引越界");
        }
        Node point=dummyHead;
        for(int x=0;x<position;x++){
            point=point.next;
        }
        E e=point.next.e;
        Node retNode=point.next;
        point.next=retNode.next;
        retNode.next=null;
        size--;
        return e;
    }

    /**
     * 查询是否存在某个元素
     * */
    public boolean select(E e){
        Node point=dummyHead;
        while(point.next!=null){
            point=point.next;
            if(point.e.equals(e)){
                return true;
            }
        }
        return false;
    }


    /**
     *链表是否为空
     * */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 链表的长度
     **/
    public int getSize(){
        return size;
    }
}

class TestLinkedList{
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int x=0;x<10;x++){
            linkedList.addAtHead(x);
        }
        linkedList.get(2);
        //linkedList.add(10000,2);
       /* *//*System.out.println(linkedList.get(3));*//*
        System.out.println("--------------------------");*/
        for (int x=0;x<9;x++){
            Thread.sleep(100);
            System.out.println(linkedList.getAtHead());
        }
        //System.out.println(linkedList.select(7));
    }
}
