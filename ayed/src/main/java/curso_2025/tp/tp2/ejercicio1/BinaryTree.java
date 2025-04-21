package tp2.ejercicio1;

import java.util.ArrayList;
import java.util.List;

import curso_2024.tp.practica2.ejercicio1y2.BinaryTree;
import curso_2025.tp.tp1.Queue;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }

    public int contarHojas() {
        if (this.isLeaf()) {
            return 1;
        }
        int count = 0;
        if (this.hasLeftChild()) {
            count += this.getLeftChild().contarHojas();
        }
        if (this.hasRightChild()) {
            count += this.getRightChild().contarHojas();
        }
        return count;
    }

    public BinaryTree<T> espejo() {
        BinaryTree<T> treeResponse = new BinaryTree<>(this.data);
        mirrorTreeWalk(treeResponse)
        return treeResponse;
    }

    private void mirrorTreeWalk(BinaryTree<T> node){
        if (this.hasRightChild()){
            node.leftChild = new BinaryTree<>(this.rightChild.data)
            mirrorTreeWalk(this.rightChild);
        }
        if (this.hasLeftChild()){
            node.rightChild = new BinaryTree<>(this.leftChild.data);
            mirrorTreeWalk(this.leftChild);
        }
    }

    // 0<=n<=m
    public void entreNiveles(int n, int m) {
        int level = 0;
        BinaryTree<T> node = this;
        Queue<BinaryTree<T>> queue = new Queue<>();
        List<BinaryTree<T>> nodesInLevel = new ArrayList<>();

        queue.enqueue(node);
        queue.enqueue(null);
        while (!queue.isEmpty() || level <= m){
            node = queue.dequeue();
            if (node == null){
                level++;
                queue.enqueue(null);
            }else{
                if (node.hasLeftChild()){
                    queue.enqueue(node.leftChild);
                    if (level >= n)
                        nodesInLevel.add(node.leftChild);
                }
                if (hasRightChild()){
                    queue.enqueue(node.rightChild);
                    if (level >= n)
                        nodesInLevel.add(node.rightChild);
                }
            }
        }
        for (BinaryTree<T> node : nodesInLevel){
            System.out.println(node.data);
        }
    }
}
