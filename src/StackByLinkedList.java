import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ZhongLingYun
 * @Title: StackByLinkedList
 * @Description: 通过链表实现栈
 * @date 2018/11/99:35
 */
public class StackByLinkedList<E> {
    private class  Node{

        private Node next;

        private E e;

        public Node(E e){
            this.e=e;
            this.next=null;
        }

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
    }

    private int size=0;

    private Node dummyHead=new Node(null,null);

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 加入一个元素到堆栈,只对头部操作
     * */
    public void push(E e){
        dummyHead.next=new Node(e,dummyHead.next);
        size++;
    }

    /**
     * 从堆栈里面拿出一个元素，只对头部操作
     * */
    public E get(){
        if(size==0){
            throw new RuntimeException("堆栈已经为空");
        }
        Node re=dummyHead.next;
        dummyHead.next=re.next;
        size--;
        return re.e;
    }
}

class TestStackByLinkedList{

    public static void main(String[] args) throws InterruptedException {
       /* StackByLinkedList<Integer> stackByLinkedList=new StackByLinkedList<>();
        for(int x=0;x<100;x++){
            stackByLinkedList.push(x);
        }
        System.out.println(stackByLinkedList.getSize());

        for (int x=0;x<stackByLinkedList.getSize();x++) {
            Thread.sleep(300);
            System.out.println(stackByLinkedList.get());
        }*/
      /*  Stack<Integer> stack= new Stack<>();
       for(int x=0;x<100;x++){
           stack.add(x);
       }
       for (int x=0;x<stack.size();x++){
           System.out.println(stack.pop());
       }
*/

        List<Integer> list= new ArrayList<>();
        for (int x=0;x<100;x++){
            list.add(x);
        }

        for (int x=0;x<100;x++){
            System.out.println(list.remove(0));
        }
    }

}
