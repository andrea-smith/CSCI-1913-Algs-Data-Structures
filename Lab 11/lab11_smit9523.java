// Lab 11: Deque
// Lecture notes were very helpful for this lab.
// Andrea Smith
// CSCI 1913

class Deque<Base>
{
  private class Node
  {
    private Base object;
    private Node right;
    private Node left;
    private Node (Base object, Node right, Node left)
    {
      this.object = object;
      this.right = right;
      this.left = left;
    }
  }
  // Head node points to head of circular linked list
  private Node head;

  public Deque()
  {
    head = new Node(null, null, null);
    head.right = head;
    head.left = head;
  }

  public void enqueueFront(Base object)
  {
    Node whereR = head;
    Node newNode = new Node(object, whereR.right, whereR);
    whereR.right.left = newNode; // From lecture
    whereR.right = newNode;
  }

  public void enqueueRear(Base object)
  {
    Node whereL = head;
    Node newNode = new Node(object, whereL, whereL.left);
    whereL.left.right = newNode;
    whereL.left = newNode;
  }

  public Base dequeueFront()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("The Deque is empty.");
    }
    else
    {
      Node where = head.right; // Get the node at the front of the Deque
      where.right.left = head;
      head.right = where.right; // Delete the node at the front
      return where.object; // Return the object

    }
  }

  public Base dequeueRear()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("The Deque is empty.");
    }
    else
    {
      Node where = head.left; // Get the node at the rear of the Deque
      where.left.right = head;
      head.left = where.left; // Delete the node at the rear
      return where.object; // Return the object
    }
  }

  public boolean isEmpty()
  {
    return head.right == head && head.left == head;
  }

}

//  OBSERVATION DEQUE. Test the class DEQUE. 40 points total.

class ObservationDeque
{

//  MAIN. Test the DEQUE on various example arguments.

  public static void main(String [] args)
  {
    Deque<String> deque = new Deque<String>();

    System.out.println(deque.isEmpty());       // true                2 points.

    try
    {
      System.out.println(deque.dequeueFront());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueFront.");  //  No dequeueFront.   2 points.
    }

    try
    {
      System.out.println(deque.dequeueRear());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueRear.");   //  No dequeueRear.    2 points.
    }

//  Enqueueing to the rear and dequeueing from the rear makes the DEQUE act
//  like a stack.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.isEmpty());       //  false              2 points.

    System.out.println(deque.dequeueRear());   //  C                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the rear and dequeueing from the front makes the DEQUE act
//  like a queue.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.dequeueFront());  //  A                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the front makes the DEQUE act
//  like a stack.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueFront());  //  C                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the rear makes the DEQUE act
//  like a queue.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueRear());   //  A                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.
  }
}
