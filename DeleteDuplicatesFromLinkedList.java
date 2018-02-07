class DeleteDuplicatesFromLinkedList{
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	  }
	public ListNode deleteDuplicates(ListNode head) {
		ListNode f = head;
        if(head != null){
        	while(f.next != null){
        		if(f.val != f.next.val){
	        		f = f.next;
	        	} else{
	        		f.next = f.next.next;
	        	}
        	}
        }
        return head;
    }
}