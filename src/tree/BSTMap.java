package tree;

/**
 * @author ZhongLingYun
 * @Title: BSTMap
 * @Description: 二分搜索树是实现map
 * @date 2018/11/1515:47
 */
public class BSTMap<K extends Comparable<K>,V> {
    private class Node{
        public K k;
        public V v;
        public Node left;
        public Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "k=" + k +
                    ", v=" + v +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public Node(K k,V v){
            this.k=k;
            this.v=v;
            this.left=null;
            this.right=null;
        }
    }

    private int size;

    private Node root;

    public  BSTMap(){
        size=0;
        root=null;
    }

    /**
     * 私有类,递归添加
     * */
    private Node add(K k,V v,Node node){
        if(node==null){
            return new Node(k,v);
        }
        // 相等的情况直接覆盖
        if(node.k.equals(k)){
            node.v=v;
            return node;
        }
        if(node.k.compareTo(k)>0){
            node.left=add(k,v,node.left);
        }else {
            node.right=add(k,v,node.right);
        }
        return node;
    }

    /**
     * 添加元素
     * */
    public void add(K k,V v){
        root=add(k,v,root);
        //System.out.println(root.toString());
    }

    /**
     * 通过key获取值
     * */
    public V getValue(K k){
        return getValue(k,root);
    }

    /**
     * 私有类，递归查找
     * */
    private V getValue(K k,Node node){
        if (node==null){
            // 节点是空节点
            return null;
        }
        if(node.k.equals(k)){
            return node.v;
        }
        if(node.k.compareTo(k)>0){
            return getValue(k,node.left);
        }else {
            return getValue(k,node.right);
        }
    }

    public void  remove(K k){
        System.out.println(root);
        root=remove(root,k);
        System.out.println(root);
    }

    private Node remove(Node node,K k){
        if(node==null){
            return null;
        }
        if(node.k.equals(k)){
            // 删除节点是叶子
            if(node.left==null&&node.right==null){
                return null;
            }
            if(node.left!=null&&node.right==null){
                // 只有左孩子
                node=node.left;
                return node;
            }
            if(node.right!=null&&node.left==null){
                // 只有右孩子
                node=node.right;
                return node;
            }
            // 左右孩子都有
            Node point=node.right;
            while(point.left!=null){
                // 进行预判如果这个节点是叶子节点的父节点的父节点就退出
                if(point.left.left==null){
                    break;
                }
                // 找到右子树最小的节点,最小的节点只能右子树的最左边的叶子节点
                point=point.left;
            }
            node.k=point.left.k;
            node.v=point.left.v;
            // 将右子树移动到原来的最小节点的位置
            point.left=point.left.right;
            return node;
        }
        if(node.k.compareTo(k)>0){
            node.left=remove(node.left,k);
            return node;
        }else{
            node.right=remove(node.right,k);
            return node;
        }

    }




}

class TestBSTMap{
    public static void main(String[] args) {
        BSTMap<Integer,Integer> bstMap=new BSTMap<>();
        bstMap.add(50,2);
        bstMap.add(40,2);
        bstMap.add(30,2);
        bstMap.add(45,2);
        bstMap.add(41,2);
        bstMap.add(46,2);
        bstMap.add(42,2);
        bstMap.add(43,2);
        bstMap.remove(40);
    }
}
