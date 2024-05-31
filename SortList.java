public class SortList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("ll is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node sortListt(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        Node left_side = sortListt(head);
        Node right_side = sortListt(slow);
        return merge(left_side, right_side);
    }

    public Node merge(Node l1, Node l2) {
        Node sorted_temp = new Node(0);
        Node curr_node = sorted_temp;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr_node.next = l1;
                l1 = l1.next;
            } else {
                curr_node.next = l2;
                l2 = l2.next;
            }
            curr_node = curr_node.next;
        }
        if (l1 != null) {
            curr_node.next = l1;
            l1 = l1.next;
        } else {
            curr_node.next = l2;
            l2 = l2.next;
        }
        return sorted_temp.next;
    }

    public static void main(String[] args) {
        SortList ll = new SortList();
        ll.addFirst(3);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(4);
        ll.print();
        Node sort = ll.sortListt(head);
        Node temp = sort;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
