
public class Node<T extends Comparable> {

    T info;
    Node p;
    Node n;

    public Node() {
    }

    public Node(T info) {
        this.info = info;
    }

    public Node(T info, Node p, Node n) {
        this.info = info;
        this.p = p;
        this.n = n;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }

    @Override
    public boolean equals(Object o) {
        Node in = (Node) o;
        return this.info.equals(in.info);
    }

    void swap(Node b) {
        //swapping info
        T tmp = this.info;
        this.info = (T) b.info;
        b.info = tmp;
    }

}
