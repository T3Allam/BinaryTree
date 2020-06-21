public class BinaryTree<E extends Comparable<? super E>> {
    TreeNode<E> root;

    public BinaryTree(TreeNode<E> root) {
        this.root = root;
    }

    //Searching Tree
    public boolean contains(E toFind) {
        TreeNode<E> curr = root;
        int x;
        while (curr != null) {
            x = toFind.compareTo(curr.getValue());
            if (x ==0) {
                return true;
            } else if (x>0) {
                curr = curr.getRightChild();
            } else if (x<0) {
                curr = curr.getLeftChild();
            }
        }
        return false;
    }

    public boolean insert(E toInsert){
        TreeNode<E> curr = root;
        int x;
        x = toInsert.compareTo(curr.getValue());
        while(x < 0 && curr.getLeftChild() != null || x > 0 && curr.getRightChild() != null) {
            if (x>0) {
                curr = curr.getRightChild();
            } else {
                curr = curr.getLeftChild();
            }
            x = toInsert.compareTo(curr.getValue());
        }
        if (x>0) {
            curr.addRightChild(toInsert);
        } else if (x<0) {
            curr.addLeftChild(toInsert);
        } else { //if you found value already existing in tree. in that case x=0 and you exit from while loop
            return false;
        }
        return true;
    }

    //Searching Tree
    public TreeNode<E> locate(E toLocate) {
        TreeNode<E> curr = root;
        int x;
        while (curr != null) {
            x = toLocate.compareTo(curr.getValue());
            if (x ==0) {
                return curr;
            } else if (x>0) {
                curr = curr.getRightChild();
            } else if (x<0) {
                curr = curr.getLeftChild();
            }
        }
        return null;
    }

    public boolean delete(E toDelete) {
        TreeNode<E> deleteNode = locate(toDelete);
        int x;
        //node does not exist
        if (deleteNode == null) {
            return false;
        //node exists
        } else {
            if (deleteNode.isLeaf(deleteNode)) { //node is a leaf
                x = deleteNode.getValue().compareTo(deleteNode.getParent().getValue());
                //check if node is right_child or left_child from parent
                if (x>0) {
                    deleteNode.getParent().setRightChild(null);
                } else {
                    deleteNode.getParent().setLeftChild(null);
                }
            } else if (deleteNode.hasOnlyOneChild(deleteNode)) { //node only one child - make parent of node point to child - GC takes care of deleted node
                // if node has right child only
                if (deleteNode.getRightChild() != null) {
                    deleteNode.getRightChild().setParent(deleteNode.getParent());
                    deleteNode.getParent().setRightChild(deleteNode.getRightChild());
                    deleteNode.setParent(null);
                    deleteNode.setRightChild(null);
                } else {
                    //if node has left child only
                    deleteNode.getLeftChild().setParent(deleteNode.getLeftChild());
                    deleteNode.getParent().setLeftChild(deleteNode.getLeftChild());
                    deleteNode.setParent(null);
                    deleteNode.setLeftChild(null);
                }
            } else { //case where node has two children
                //find smallest value in right subtree
                TreeNode<E> curr = deleteNode.getRightChild();
                while (curr.getLeftChild()!=null) {
                    curr = curr.getLeftChild();
                }
                //set value of node = value of smallest value in right subtree
                deleteNode.setValue(curr.getValue());
                //disconnect smallest value of right subtree from tree
                curr.getParent().setLeftChild(null);
                curr.setParent(null);
            }
            return true;
        }
    }
}
