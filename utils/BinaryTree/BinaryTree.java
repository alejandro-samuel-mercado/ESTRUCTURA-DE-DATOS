package utils.BinaryTree;

public class BinaryTree<ELEMENT> {
    // region Binary Tree Node Class

    @SuppressWarnings("hiding")
    protected class BTNode<ELEMENT> {

        public ELEMENT item;
        public BTNode<ELEMENT> left;
        public BTNode<ELEMENT> right;

        public BTNode() {
            this(null, null, null);
        }

        public BTNode(ELEMENT item) {
            this(item, null, null);
        }

        public BTNode(ELEMENT item, BTNode<ELEMENT> left, BTNode<ELEMENT> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return this.item.toString();
        }

        // Método para propósitos académicos
        public void visit() {
            System.out.printf("%s ", this.item.toString());
        }
    }

    protected BTNode<ELEMENT> root;

    // endregion

    // region Constructors
    public BinaryTree() {
        this.root = null;
    }

    // Métodos para propósitos académicos
    public BinaryTree(ELEMENT item) {
        this(item, null, null);
    }

    public BinaryTree(ELEMENT item, BinaryTree<ELEMENT> left, BinaryTree<ELEMENT> right) {
        this.root = new BTNode<ELEMENT>(item, null, null);

        if (left != null) {
            this.root.left = left.root;
        }
        if (right != null) {
            this.root.right = right.root;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, this.root);
        return sb.toString();
    }

    protected void toString(StringBuilder sb, BTNode<ELEMENT> root) {
        if (root != null) {
            sb.append(root.item.toString());
            if (root.left != null) {
                sb.append("(");
                toString(sb, root.left);

                if (root.right != null) {
                    sb.append(",");
                    toString(sb, root.right);
                }
                sb.append(")");

            } else {
                if (root.right != null) {
                    sb.append("(,");
                    toString(sb, root.right);
                    sb.append(",");
                    sb.append(")");
                }
            }
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    protected void preOrder(BTNode<ELEMENT> root) {

        if (root != null) {
            root.visit();
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    protected void inOrder(BTNode<ELEMENT> root) {
        if (root != null) {
            inOrder(root.left);
            root.visit();
            inOrder(root.right);
        }
    }

    public void postOrder() {
        postOrder(this.root);
    }

    protected void postOrder(BTNode<ELEMENT> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            root.visit();
        }
    }

    public void descendingOrder() {
        descendingOrder(this.root);

    }

    protected void descendingOrder(BTNode<ELEMENT> root) {
        if (root != null) {
            descendingOrder(root.right);
            root.visit();
            descendingOrder(root.left);
        }
    }

    public int nodeCount() {
        return nodeCount(this.root);

    }

    protected int nodeCount(BTNode<ELEMENT> root) {
        if (root != null) {
            return 1 + nodeCount(root.left) + nodeCount(root.right);
        }
        return 0; // Retornar 0 si root es null
    }

    public int leafCount() {
        return leafCount(this.root);

    }

    protected int leafCount(BTNode<ELEMENT> root) {
        if (root != null) {
            if ((root.left == null) && (root.right == null)) {
                return 1;
            } else {
                return leafCount(root.left) + leafCount(root.right);
            }
        }
        return 0; // Retornar 0 si root es null
    }

    public int internalCount() {
        return internalCount(this.root);

    }

    protected int internalCount(BTNode<ELEMENT> root) {
        if (root != null) {
            if ((root.left == null) && (root.right == null)) {
                return 0;
            } else {
                return 1 + internalCount(root.left) + internalCount(root.right);
            }
        }
        return 0; // Retornar 0 si root es null
    }

    public int maxLevel() {
        return maxLevel(this.root);

    }

    protected int maxLevel(BTNode<ELEMENT> root) {
        if (root != null) {
            if ((root.left != null) || (root.right != null)) {
                int leftLevel = maxLevel(root.left);
                int rightLevel = maxLevel(root.right);
                return 1 + Math.max(leftLevel, rightLevel);
            }
            return 1; // Retornar 1 si hay un nodo hoja
        }
        return 0; // Retornar 0 si root es null
    }

    public int height() {
        return maxLevel() + 1;
    }

}