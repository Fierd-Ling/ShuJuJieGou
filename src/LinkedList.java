/**
 * @author ZhongLingYun
 * @Title: LinkedList
 * @Description: 链表
 * @date 2018/11/69:53
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this.e=e;
            this.next=null;
        }
    }

    private int size;

    private Node head;

    /**
     * 头部添加
     * */
    public void add(E e){
        // 在头部添加只要把原来头部的node作当前node下一个节点就可以
        /*Node node= new Node(e);
        node.next=head;
        head=node;*/
        head =new Node(e,head);
        size++;
    }

    /**
     * 任意索引位置添加
     * */
    public void add(E e,int position){
        if(position==0){
            add(e);
        }else {
            Node point=head;
            for(int x=0;x<position-1;x++){
                point=point.next;
            }
            // 在1234567中的3的位置插入i,2的后面就是i，i的后面就是3其余的不变
           /* Node node= new Node(e);
            point.next=node;
            node.next=point.next;*/
            //Node node=new Node(e,point.next);
            //point.next=node;
            point.next=new Node(e,point.next);
            size++;
        }
    }

    /**
     * 获取链头元素
     * */
    public E get(){
        E e= head.e;
        head=head.next;
        size--;
        return e;
    }

    /**
     * 获取任意位置的元素
     * */
    public E get(int position){
        if(position<0||position>=size){
            throw new RuntimeException("索引越界");
        }
        Node point=head;
        for (int x=0;x<position-1;x++){
            point=point.next;
        }
        E e=point.next.e;
        // 如果被取出来的是最后一个就没有下一个节点，下一个节点就是null
        if(point.next.next==null){
            point.next=null;
        }else {
            point.next=point.next.next;
        }
        return e;
    }

    /**
     * 当前链表的实际数据量
     * */
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}

class TestLinkedList{
    public static void main(String[] args) {
        LinkedList<Integer> linkedList= new LinkedList<>();
        for (int x=0;x<30;x++){
            linkedList.add(x);
        }
        System.out.println(linkedList.get(4));
        System.out.println("-----------");
        linkedList.add(100,20);
        for(int x=0;x<30;x++){
            System.out.println(linkedList.get());
        }

    }
}
