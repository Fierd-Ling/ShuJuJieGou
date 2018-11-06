/**
 * @author ZhongLingYun
 * @Title: LinkedList
 * @Description:
 * @date 2018/11/622:33
 */
public class LinkedList<E> {
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
        dummyHead.next=new Node(e,dummyHead.next);
        size++;
    }

    /**
     * 在链表尾部插入
     * */
    public void addAtEnd(E e){
        Node point =dummyHead;
        for(int x=0;x<size;x++){
            point=point.next;
        }
        point.next=new Node(e);
        size++;
    }

    // TODO 随机插入

    /**
     * 从头部取出一个元素
     * */
    public E getAtHead(){
        if(size==0){
            throw  new RuntimeException("链表中没有数据");
        }
        E e=dummyHead.next.e;
        dummyHead.next=dummyHead.next.next;
        size--;
        return e;
    }

    /**
     * 从尾部取出一个数据
     * */
    public E getAtEnd(){
        if(size==0){
            throw  new RuntimeException("链表中没有数据");
        }
        Node point=dummyHead;
        for(int x=0;x<size-1;x++){
           point=point.next;
        }
        E e=point.next.e;
        point.next=null;
        size--;
        return e;
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
        for (int x=0;x<11;x++){
            Thread.sleep(100);
            System.out.println(linkedList.getAtEnd());
        }

    }
}
