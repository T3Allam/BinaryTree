public class TreeNode<E>{
    E value;
    TreeNode<E> parent;
    TreeNode<E> leftChild;
    TreeNode<E> rightChild;

    public TreeNode(E value, TreeNode<E> parent) {
        this.value = value;
        this.parent = parent; //if node is root then parent=null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public E getValue() {
        return value;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public boolean hasOnlyOneChild(TreeNode<E> node) {
        if (node.getRightChild() != null && node.getLeftChild() == null || node.getRightChild()==null && node.getLeftChild() !=null) {
            return true;
        }
        return false;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public boolean isLeaf(TreeNode<E> node) {
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return true;
        }
        return false;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public void addLeftChild(E val) {
        this.leftChild = new TreeNode<E>(val, this);
    }

    public void addRightChild(E val) {
        this.rightChild = new TreeNode<E>(val, this);
    }

    public void visit(){
        System.out.println(this.value);
    }
}
