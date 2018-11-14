package tree;

/**
 * @author ZhongLingYun
 * @Title: BST
 * @Description: 二分搜索树
 * @date 2018/11/1316:52
 */
public class BST<E extends Comparable<E>> {

    private class Node{

        public E e;

        public Node left,right;

        public Node(E e){
            this.e=e;
            this.left=null;
            this.right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                      '}';
        }
    }

    private int size;

    private Node root;

    public BST(){
        size=0;
        // 防止while出现null exception
        root=new Node(null);
    }

    public int getSize(){
        return size;
    }

    public void systemOut(){
        Node point=root;
        while (point.right!=null||point.left!=null){
            System.out.println(point.toString());
            point=point.left;
        }
        System.out.println(point.toString());
    }


    public void add(E e) {
        Node point=root;
        // 有子节点
        while(point!=null&&(point.left!=null||point.right!=null)){
            E compare=point.e;
            if(compare.compareTo(e)>0){
                point=point.left;
            }else {
                point=point.right;
            }
        }
        if(point==null){
            if(size==0){
                point.e=e;
                root=point;
            }else {
                point=new Node(e);
            }
        }else{
            if(size==0){
                point.e=e;
                root=point;
            }else {
                E compare =point.e;
                if(compare.compareTo(e)>0){
                    point.left=new Node(e);
                }else {
                    point.right=new Node(e);
                }
            }
        }
        System.out.println(point.toString());
    size++;
    }
}

class TestBST{
    public static void main(String[] args) throws InterruptedException {
        BST<Integer> b=new BST<>();
       /* for (int x=1;x<11;x++){
            if(x!=5&&x!=8){
                b.add(x);
            }
        }*/
        System.out.println();

        b.add(8);
        b.add(6);
        b.add(10);
        b.add(0);
        b.add(140);
        // TODO 待解决逻辑问题

    }

}
