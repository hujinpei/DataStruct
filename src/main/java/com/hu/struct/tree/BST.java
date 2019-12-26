package com.hu.struct.tree;

public class BST {

    private Node root;

    public BST() {
        this.root = null;
    }

    public Node search(Node root, int key) {
        if(root==null) {
            return root;
        }

        if(key==root.getValue()) {
            return root;
        }else if(key>root.getValue()){
            return search(root.getRight(),key);
        }else {
            return search(root.getLeft(),key);
        }
    }

    public Node iterative_search(Node root,int key) {
//        if(root==null ) {
//            return root;
//        }else {
//            while(root!=null) {
//
//                if (key > root.getValue()) {
//                    root = root.getRight();
//                }else {
//                    root=root.getLeft();
//                }
//            }
//            return root;
//        }
        while(root!=null&&key!=root.getValue()) {
            if(key>root.getValue()) {
                root = root.getRight();
            }else {
                root = root.getLeft();
            }
        }
        return root;
    }

    public Node Min(Node root) {
//        if(root==null||root.getLeft()==null) {
//            return root;
//        }
//        return Min(root.getLeft());
        while(root.getLeft()!=null) {
            root = root.getLeft();
        }
        return root;
    }


    public Node Max(Node root) {
        while(root.getRight()!=null) {
            root = root.getRight();
        }
        return root;
    }

    /**
     * 后继节点
     * @param root
     * @return
     */
    public Node successor(Node root) {
        if(root.getRight()!=null) {
            return Min(root.getRight());
        }
        Node y = root.getParent() ;
        while(y!=null && root==y.getRight()) {
            root = y;
            y = y.getParent();
        }
        return y;
    }

    /**
     *
     * @param root
     * @return
     */
    public Node presuccessor(Node root) {
        if(root!=null&& root.getLeft()!=null) {
            return Max(root.getLeft());
        }
        Node y = root.getParent() ;
        while(y!=null && root==y.getLeft()) {
            root = y;
            y = y.getParent();
        }
        return y;

    }

    /**
     *
     *
     * @param key
     * @return
     */
    public void insert(Node key) {
        Node y = null;
        Node x = root;
        while(x!=null) {
            y = x;
            if(x.getValue()>key.getValue()) {
                x= x.getLeft();
            }else {
                x = x.getRight();
            }
        }

        key.setParent(y);

        if(y==null) {
            root = key;
        }else if(key.getValue()<y.getValue()) {
            y.setLeft(key);
        }else {
            y.setRight(key);
        }
    }

    /**
     * 移植
     *
     * @param u sourcee
     * @param v replace
     */
    public void transplant(Node u,Node v) {
        if(u.getParent()==null) {
            root = v;
        }else if(u==u.getParent().getLeft()) {//左节点
            u.getParent().setLeft(v);
        }else {
            u.getParent().setRight(v);
        }
        if(v!=null) {
            v.setParent(u.getParent());
        }
    }

    /**
     *只有一个孩子
     *
     * @param x
     * @return
     */

    public void delete (Node x) {
        if(x.getLeft()==null) {//只有一个左孩子
            transplant(x,x.getRight());
        }else  if(x.getRight()==null) {//只有一个右孩子
            transplant(x,x.getLeft());
        }else {//两个儿子
            Node y = successor(x);//后继节点
            if(y.getParent()!=x) {//1.如果删除节点不是后继节点的父母
                transplant(y,y.getRight());//用后继节点的右节点代码后继节点
                y.setRight(x.getRight());
                y.getRight().setParent(y);
            }
            transplant(x,y);//用后继节点代替删除节点
            y.setLeft(x.getLeft());
            y.getLeft().setParent(y);
        }
    }


    public void inorder(Node root) {
        if(root!=null) {
            inorder(root.getLeft());
            System.out.println(root.getValue());
            inorder(root.getRight());
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
//
//        bst.insert(new Node(null,null,null,15));
//        bst.insert(new Node(null,null,null,6));
//
//        bst.insert(new Node(null,null,null,18));
//        bst.insert(new Node(null,null,null,17));
//
//        bst.insert(new Node(null,null,null,20));
//        bst.insert(new Node(null,null,null,3));
//        bst.insert(new Node(null,null,null,7));
//
//        bst.insert(new Node(null,null,null,2));
//
//
//        bst.insert(new Node(null,null,null,4));
//        bst.insert(new Node(null,null,null,13));
//
//
//
//
//        bst.insert(new Node(null,null,null,9));
//
//
        bst.insert(new Node(null,null,null,30));
        bst.insert(new Node(null,null,null,15));
        bst.insert(new Node(null,null,null,10));
        bst.insert(new Node(null,null,null,8));
        bst.insert(new Node(null,null,null,13));
        bst.insert(new Node(null,null,null,11));
        bst.insert(new Node(null,null,null,12));
        bst.inorder(bst.root);

        bst.delete(bst.search(bst.root,10));

        bst.inorder(bst.root);
        //System.out.println(bst.root.getLeft().getValue());

    }

}
