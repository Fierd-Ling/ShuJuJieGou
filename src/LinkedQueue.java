/**
 * @author ZhongLingYun
 * @Title: LinkedQueue
 * @Description: 链表实现队列
 * @date 2018/11/129:33
 */
public class LinkedQueue<E> {

    private class Node{
        private Node next;

        private E e;

        public Node(E e){
            this.next=null;
            this.e=e;
        }

        public Node(E e,Node next){
            this.next=next;
            this.e=e;
        }
    }

    private int size=0;

    /**
     * 链表的头和尾部
     * */
    private Node head=null,tail=null;

    public void push(E e){
        //如果为空就是表示链表为空，插入第一个数据头和尾都是指向同一个数据
        if(tail==null){
            tail=new Node(e);
            head=tail;
        }else {
            // 如果有数据，直接在尾部插入就行，尾巴下移，头不动
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }

    public int getSize(){
        return size;
    }

    public E get(){
        if(head==null){
            return null;
        }
        E e=head.e;
        // 拿数据从头拿，头下移一个
        head=head.next;
        size--;
        return e;
    }
}

class TestLinkedQueue{

    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue= new LinkedQueue<>();
        for (int x=0;x<100;x++){
            linkedQueue.push(x);
        }
        //System.out.println(linkedQueue.getSize());
        for (int x=0;x<100;x++){
            System.out.println(linkedQueue.get());
        }
    }
}
