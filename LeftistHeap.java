public class LeftistHeap<E extends Comparable> {
    // Constructors
    private Node<E> root;
    public LeftistHeap() {
        root = null;
    }
    
    /**
     * Method to get the min value of the heap.
     * @return the root value without taking it out of the heap
     */
    public E getMin() {
        if (root == null) return null;
        return root.value;
    }

    /**
     * Method to delete the min value of the heap.
     * @return the min value and take it off the heap.
     */
    public E deleteMin() {
        if (root == null) return null;
        E min = root.value;
        root = merge(root.left, root.right);
        return min;
    }

    /**
     * Create a new node with the provided value and merge the node with the existing heap.
     * @param value 
     */
    public void insert(E value) {
        root = merge(root, new Node(value));
    }

    public boolean isEmpty() {
        if (root == null) return true;
        return false;
    }

    /**
     * Swap the right and left children of a povided node.
     * @param node
     */
    private void swapChildren(Node<E> node) {
        Node<E> temp = node.right;
        node.right = node.left;
        node.left = temp;
    }

    /**
     * Merge the other heap with this heap.
     * @param other
     */
    public void merge(LeftistHeap<E> other) {
        if (this == other) return;
        root = merge(this.root, other.root);
        other.root = null;
    }

    /**
     * Internal method to order two roots and deal with null values.
     * Reorders the values to keep r1 as the smaller.
     * @param r1
     * @param r2
     * @return the merged root.
     */
    private Node<E> merge(Node<E> r1, Node<E> r2) {
        if (r1 == null) return r2;
        if (r2 == null) return r1;
        if (r1.compareTo(r2) == -1) 
            return merge1(r1, r2);
        else 
            return merge1(r2, r1);
    }

    /**
     * Internal method to merge two heaps together. This method assumes that r1 is the smaller value.
     * @param r1 smaller of the roots.
     * @param r2 bigger of the roots.
     * @return the root of the merged heap.
     */
    private Node<E> merge1(Node<E> r1, Node<E> r2) {
        if (r1.left == null) r1.left = r2;
        else {
            r1.right = merge(r1.right, r2);
            if (r1.left.npl < r1.right.npl) swapChildren(r1);
            r1.npl = Math.min(r1.left.npl, r1.right.npl) + 1;
        }
        return r1; 
    }

    private static class Node<E extends Comparable> {
        E value;
        Node<E> left;
        Node<E> right;
        int npl; // min(left npl, right npl) + 1
        
        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.npl = 0;
        }

        Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.npl = 0;
        }

        public int compareTo(Node<E> other) {
            return this.value.compareTo(other.value);
        }
    }

    public static void main(String[] args) {
        LeftistHeap<Integer> heap = new LeftistHeap<Integer>();
        heap.insert(12);
        heap.insert(13);
        heap.insert(14);
        heap.insert(14);
        heap.insert(9);
        heap.insert(20);
        heap.insert(4);
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());

    }
}
