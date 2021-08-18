class LinkedList
{
    static ListNode head;

    static class ListNode
    {
        int data;
        ListNode next;

        ListNode(int d)
        {
            data = d;
            next = null;
        }
    }

    ListNode reverse(ListNode head)
    {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
        return head;
    }

    void printLinkedList(ListNode head)
    {
        while(head != null)
        {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(25);

        System.out.println("Given linked list");
        list.printLinkedList(head);

        head =  list.reverse(head);
        System.out.println("");
        System.out.println("Reverse Linked List");
        list.printLinkedList(head);
    }
}

