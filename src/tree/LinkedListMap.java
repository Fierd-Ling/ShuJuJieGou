package tree;

/**
 * @author ZhongLingYun
 * @Title: LinkedListMap
 * @Description: 用链表实现Map
 * @date 2018/11/169:26
 */
public class LinkedListMap<K,V> {

    private class Node{
        public Node next;

        public K k;

        public V v;

        public Node(K k,V v){
            this.k=k;
            this.v=v;
            this.next=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", k=" + k +
                    ", v=" + v +
                    '}';
        }
    }

    private int size;

    private Node head;

    public LinkedListMap(){
        head=null;
        size=0;
    }

    public void add(K k,V v){
        head=add(k,v,head);
        System.out.println(head);
    }

    /**
     * 递归插入直到找到当前节点的最后末尾插入
     * */
    private Node add(K k,V v,Node node){
        // 已经到了最后的位置
        if(node==null){
            return new Node(k,v);
        }
        // 如果k相同直接覆盖
        if(node.k.equals(k)){
           node.v=v;
           return node;
        }
        // 继续递归到下一个位置
        node.next=add(k,v,node.next);
        return node;
    }
}

class TestLinkedListMap{
    public static void main(String[] args) {
        LinkedListMap<String,Integer> linkedListMap= new LinkedListMap<>();
        for(int x=0;x<4;x++){
            String str=""+x;
            linkedListMap.add(str,x);
        }
    }
}
