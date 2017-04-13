/**
 * Created by Kir on 10.04.2017.
 */
public class Node<E> {

    //LINKED LIST IMPLEMENTATION?

    int data;

    Node next;
    Node prev;

    public Node() {

    }

    Node instertTail(Node head, int data, Node next) {

        Node node = new Node();
        node.data = 5;

        Node newNode = new Node(head, data + 1, head.prev);

        head.next = node;
        return head;

    }

    Node(Node prev, int element, Node next) {
        this.data = element;
        this.next = next;
        this.prev = prev;
    }
}




//I: 1->2->3->4->null
//O: 1->2->3->4->5->null


//I: 1->2->3->4->null
//O:
