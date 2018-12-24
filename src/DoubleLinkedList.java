
public class DoubleLinkedList {

    Node firstNode, lastNode;

    boolean isEmpty() {
        return firstNode == null;
    }

    boolean hasOnlyOneItem() {
        return firstNode.n == null;
    }

//inserts
    void insertFirst(Node newNode) {
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = firstNode;
        } else {
            firstNode.p = newNode;
            newNode.n = firstNode;
            newNode.p = null;
            firstNode = newNode;
        }
    }

    void insertAfter(Node newNode, Node afterNode) {

        if (isEmpty()) {
            insertFirst(newNode);
            return;
        }

        if (hasOnlyOneItem()) {
            insertLast(newNode);
            return;
        }

        Node cur = firstNode;
        boolean isFound = false;
        while (cur.n != null && !isFound) {
            if (cur.equals(afterNode)) {
                isFound = true;
            } else {
                cur = cur.n;
            }
        }
        if (isFound) {
            Node nextNode = cur.n;
            newNode.p = cur;
            newNode.n = nextNode;
            cur.n = newNode;
            nextNode.p = newNode;
        } else {
            insertLast(newNode);
        }
    }

    void insertLast(Node newNode) {
        if (isEmpty()) {
            insertFirst(newNode);
        } else if (hasOnlyOneItem()) {
            firstNode.n = newNode;
            newNode.p = firstNode;
            lastNode = newNode;
        } else {
            lastNode.n = newNode;
            newNode.p = lastNode;
            lastNode = newNode;
        }
    }

//delete
    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        if (hasOnlyOneItem()) {
            firstNode = null;
            lastNode = null;
            return;
        }
        firstNode = firstNode.n;
        firstNode.p = null;
    }

    void delete(Node deleteNode) {
        //prefered to use a NodeWrap to wrap the thing u wanna delete off
        if (isEmpty()) {
            return;
        }

        if (firstNode.equals(deleteNode)) {
            deleteFirst();
            return;
        }
        Node cur = this.firstNode;
        // 1 2 3 (4) 5 6
        // cur 1 2 3 4
        //prev n 1 2 3 cur.p
        while (cur != null && !cur.equals(deleteNode)) {
            cur = cur.n;
        }//derefrencing the deleteNode
        cur.p.n = cur.n;
        if (cur.n != null) {
            cur.n.p = cur.p;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (hasOnlyOneItem()) {
            firstNode = null;
            lastNode = null;
            return;
        }
        lastNode = lastNode.p;
        lastNode.n = null;
    }

//sort
    void sort() {
        if (hasOnlyOneItem()) {
            return;
        }
        Node tmp;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            tmp = firstNode;
            while (tmp.n != null) {
                if (tmp.info.compareTo(tmp.n.info) > 0) {
                    tmp.swap(tmp.n);
                    isSorted = false;
                } else if (tmp.info.compareTo(tmp.n.info) == 0 && tmp.info.compareTo(tmp.n.info) > 0) {
                    tmp.swap(tmp.n);
                    isSorted = false;
                } else {
                    tmp = tmp.n;
                }
            }
        }
    }

//</editor-fold>
//small utils for getting and setting that last and first nodes
    Node getFirst(Node node) {
        if (node.p == null) {
            return node;
        }
        return getFirst(node.p);
    }

    Node getlast(Node node) {
        if (node.n == null) {
            return node;
        }
        return getFirst(node.n);
    }

    void setLast(Node node) {
        lastNode = getlast(node);
    }

    void setFirst(Node node) {
        firstNode = getFirst(node);
    }

    void print() {
        System.out.print("null" + " <=> ");
        Node tmp = this.firstNode;
        while (tmp != null) {
            System.out.print(tmp + " <=> ");
            tmp = tmp.n;
        }
        System.out.println("null");
        System.out.print("null" + " <=> ");
        tmp = this.lastNode;
        while (tmp != null) {
            System.out.print(tmp + " <=> ");
            tmp = tmp.p;
        }
        System.out.println("null");

        System.out.println("firstNode:" + firstNode);
        System.out.println("lastNode:" + lastNode);
    }
}
