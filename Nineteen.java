public class Nineteen {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode slow = dummy;
            ListNode fast = dummy;

            
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            
            slow.next = slow.next.next;

            return dummy.next;
        }
    }

    
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        Solution sol = new Solution();

        head = sol.removeNthFromEnd(head, n);

        printList(head);
    }
}