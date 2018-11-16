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
     * 私有类。递归添加
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
        System.out.println(root.toString());
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


    /**
     * 私有类，递归调用查找value
     * */
    private  V remove(K k,Node node){
        // 节点为空表示已经到了尽头
        if(node==null){
            return null;
        }
        if(node.k.equals(k)){
            V removeV=node.v;


            return removeV;
        }
        if (node.k.compareTo(k)>0){
            return remove(k,node.left);
        }else {
            return remove(k,node.right);
        }
    }
}

class TestBSTMap{
    public static void main(String[] args) {
        BSTMap<String,Integer> bstMap=new BSTMap<>();
        bstMap.add("3",3);
        bstMap.add("0",7);
        bstMap.add("1",1);
        bstMap.add("2",2);
        System.out.println(bstMap.getValue(""));
    }
}
