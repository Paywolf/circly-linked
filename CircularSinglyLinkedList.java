public class CircularSinglyLinkedList {
    private SinglyNode head;

    public CircularSinglyLinkedList() {
        this.head = null;
    }
    
    public void insertInAcendingOrder(int data) {
        SinglyNode node = new SinglyNode(data);
        
        // List is Empty
        if (head == null) {
            node.setNext(node);
            head = node;

            return; // Note of RETURN
        }

        SinglyNode prev = null;
        SinglyNode curr = head;
        while (data > curr.getData()) {
            prev = curr;
            curr = curr.getNext();

            if (curr == head) {
                break;
            }
        }

        node.setNext(curr);

        // Inserting at the HEAD
        if (prev == null) {
            // Having PREV point to last item
            prev = head;
            while (prev.getNext() != head) {
                prev = prev.getNext();
            }

            head = node;
        }

        prev.setNext(node);
    }
}