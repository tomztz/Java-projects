import java.util.*;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data:
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 *
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
        // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;


        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode)
        {
            data = theData;
            prev = prevNode;
            next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    private int size=0;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList()
    {
        head = null;
        tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  one operation.
     */
    public boolean isEmpty()
    {
        return head==null;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  O(1)running time if the node is empty, inserting at the start or at the end of the DLL,
     *  as there are no looping required,however,inserting a node at the middle costs worst case
     *  O(N)running time as assuming we insert at a DLL of n elements at n-1 position, it takes
     *  O(N-1)running time and approxiamate to O(N)
     */
    public void insertBefore( int pos, T data )
    {
        if(size==0){
            DLLNode newNode=new DLLNode(data,null,null);
            head=newNode;
            tail=newNode;
        }
        else if(pos<=0){
            DLLNode newNode=new DLLNode(data,null,head);
            head.prev=newNode;
            head=newNode;
        }
        else if(pos>=size){
            DLLNode newNode=new DLLNode(data,tail,null);
            tail.next=newNode;
            tail=newNode;
        }
        else{
          DLLNode temp=head;
          for(int i=0;i<pos-1;i++){
              temp=temp.next;
          }
            DLLNode newNode=new DLLNode(data,temp,temp.next);
          temp.next=newNode;
          newNode.next=temp.next.next;

        }
           size++;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  if the pos is not minus or greater than the DLL size, it will cost O(N) for a
     *  n elements DLL to find the last element in the DLL.
     *
     *
     */
    public T get(int pos)
    {
        if(pos>=0&&pos<size){
            DLLNode temp=head;
        for(int i=0;i<pos;i++){
            temp=temp.next;
        }
        return temp.data;}

        //TODO
        return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  same explaination as inserting
     */
    public boolean deleteAt(int pos)
    {
        if(pos<0){
            return false;
        }
        else if(pos>=size){
            return false;
        }

        else if(size==1){
            head=tail=null;

        }
        else if(pos==0){

            head.next.prev=null;
            head=head.next;
        }
        else if(pos==size-1){

            tail.prev.next=null;
            tail=tail.prev;
        }
        else{
            DLLNode removedNode=head;
            for(int i=0;i<pos;i++){
                removedNode=removedNode.next;
            }
            removedNode.prev.next=removedNode.next;
            removedNode.next.prev=removedNode.prev;
        }
        size--;
        return true;

    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: O(N^2)
     *
     * Justification:
     *  looping from the current DLL with n elements from tail to head costs O(N) running time,
     *  while inserting to a new DLL also cost a worst case of O(N) as explained before,but the
     *  insert is inside the while loop which means the insertion runs for worst case of N times,
     *  therefore the running time is N*N O(N^2)
     */
    public void reverse()
    {
        DLLNode temp=tail;
        int i=0;
        DoublyLinkedList<T>tempDLL=new DoublyLinkedList<T>();
        while(temp!=null){
            tempDLL.insertBefore(i,temp.data);
            temp=temp.prev;
            i++;
        }
        head=tempDLL.head;
        tail=tempDLL.tail;



    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(N^2)
     *
     * Justification:
     *  two while loops
     */
    public void makeUnique()
    {
        if(head == null) {
            return;
        }
        else{
        DLLNode n=head;
        while(n!=null){
            DLLNode current=n.next;
            while(current!=null){
                if(n.data == current.data) {

                    DLLNode temp = current;

                    current.prev.next = current.next;
                    if(current.next != null){
                        current.next.prev = current.prev;}
                    else {
                        tail=tail.prev;
                    }

                    temp = null;
                    size--;
                }

                    current=current.next;

            }
            n=n.next;
        }
        }
    }


    /*----------------------- STACK API
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  as explained above insertion has a worst case running time O(N).
     */
    public void push(T item)
    {
       insertBefore(0,item);

    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  if the size of the DLL is not 0,for a n elements DLL, it will take worst case N times
     *  to get to the correct array(if the correct node is at the end of the DLL),and then takes
     *  O(N)to delete the node,therefore,it costs O(2N)running time which approxiamate to
     *  O(N);
     */
    public T pop()
    {
        if(size!=0){
            T dataPop=get(0);
            deleteAt(0);
            return dataPop;
        }
        return null;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  see explaination for push
     */
    public void enqueue(T item)
    {
        insertBefore(size,item);

    }

    /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  see pop
     */
    public T dequeue()
    {
        if(size!=0){
           return pop();
        }
        return null;
    }


    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        boolean isFirst = true;

        // iterate over the list, starting from the head
        for (DLLNode iter = head; iter != null; iter = iter.next)
        {
            if (!isFirst)
            {
                s.append(",");
            } else {
                isFirst = false;
            }
            s.append(iter.data.toString());
        }

        return s.toString();
    }


}
