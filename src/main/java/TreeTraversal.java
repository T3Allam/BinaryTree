import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal<E extends Comparable<? super E>> {
    BinaryTree<E> tree;
    public TreeTraversal(BinaryTree<E> tree){
        this.tree = tree;
    }
    //REMINDER: Create TreeTraversal Class
    //preorder traversal
    private void preOrder(TreeNode<E> node) {
        if (node != null) {
            node.visit();
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void preOrder() {
        this.preOrder(tree.root);
    }

    //postorder traversal
    private void postOrder(TreeNode<E> node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            node.visit();
        }
    }

    public void postOrder() {
        this.postOrder(tree.root);
    }

    //inorder traversal
    private void inOrder(TreeNode<E> node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            node.visit();
            inOrder(node.getRightChild());
        }
    }

    public void inOrder() {
        this.inOrder(tree.root);
    }

    //level-order traversal
    private void levelOder(TreeNode<E> node) {
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>(); //linked list implements queue
        q.add(tree.root);
        while (!q.isEmpty()) {
            if (q.element().getLeftChild() != null) {
                q.add(q.element().getLeftChild());
            }
            if (q.element().getRightChild() != null) {
                q.add(q.element().getRightChild());
            }
            q.element().visit();
            q.remove();
        }
    }

    public void levelOrder(){
        this.levelOder(tree.root);
    }
}
