package tree;

import java.util.Random;
import java.util.Scanner;

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

    public Node root;

    public BST(){
        size=0;
        // 防止while出现null exception
        root=null;
    }

    public int getSize(){
        return size;
    }

    /**
     * 添加元素
     * */
    public void add(E e) {
        Node point=root;
        // 树里面没有元素
        if(size==0){
            point=new Node(e);
            root=point;
        }
        else {
            while(point!=null&&(point.left!=null||point.right!=null)){
                E pointE =point.e;
                // 当前节点数值大于需要添加节点,添加元素在当前节点的左边
                if(pointE.compareTo(e)>0){
                    // 先判断子节点是否为空
                    if(point.left==null){
                        // 当前子节点就是插入元素需要的存储位置
                        point.left=new Node(e);
                        break;
                    }else {
                        point=point.left;
                    }
                }else {
                    if(point.right==null){
                        point.right=new Node(e);
                        break;
                    }else {
                        point=point.right;
                    }
                }
            }
            E compare=point.e;
            if(compare.compareTo(e)>0){
                point.left=new Node(e);
            }else{
                point.right=new Node(e);
            }
        }
        size++;
        System.out.println(root.toString());
    }


    /**
     * 判断是否存在某一个元素
     * */
    public boolean exist(E e){
        if(size==0){
            return false;
        }
        Node point=root;
        while(point!=null&&(point.right!=null||point.left!=null)){
            if(point.e.equals(e)){
                return true;
            }
            // 存储节点元素大于比较元素
            if(point.e.compareTo(e)>0){
                if(point.left==null){
                    // 左孩子为null
                    return false;
                }
                point=point.left;
            }else{
                if(point.right==null){
                    return false;
                }
                point=point.right;
            }
        }
        if(point==null){
            // 当前指向已经null
            return false;
        }
        if(point.e.equals(e)){
            return true;
        }
        return false;
    }

    public boolean exist(Node node,E e){
        if(node==null){
            return false;
        }
        if(node.e.equals(e)){
            return true;
        }
        // 节点大于比较数据
        if(node.e.compareTo(e)>0){
            return exist(node.left,e);
        }else {
            return exist(node.right,e);
        }
    }
}

class TestBST{
    public static void main(String[] args) throws InterruptedException {
        BST<Integer> b=new BST<>();
        for(int x=0;x<10;x++){
            int z= (int) (Math.random()*60+1);
            b.add(z);
        }
    }

}
