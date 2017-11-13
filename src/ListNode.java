
public class ListNode<T,U> {
    // Keys that have the same hash code are placed together
    // in a linked list.  This private nested class is used
    // internally to implement linked lists.  A ListNode
    // holds a (key,value) pair.
    T key;
    U value;
    ListNode next;  // Pointer to next node in the list;
    // A null marks the end of the list.
}