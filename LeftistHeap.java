import javax.xml.transform.Templates;

public class LeftistHeap<E extends Comparable> {
    private Node<E> root;

    public LeftistHeap() {
        root = null;
    }
    
    public E getMin() {
        return root.value;
    }

    public E deleteMin() {
        E min = root.value;
        root = merge(root.left, root.right);
        return min;
    }

    public void insert(E value) {
        root = merge(root, new Node(value));
    }

    private void swapChildren(Node<E> node) {
        Node<E> temp = node.right;
        node.right = node.left;
        node.left = temp;
    }

    public void merge(LeftistHeap<E> other) {
        if (this == other) return;
        root = merge(this.root, other.root);
        other.root = null;
    }

    private Node<E> merge(Node<E> r1, Node<E> r2) {
        if (r1 == null) return r2;
        if (r2 == null) return r1;
        if (r1.compareTo(r2) == -1) return merge1(r1, r2);
        else return merge1(r2, r1);
    }

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
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());

    }
}
