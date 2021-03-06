// Lab 10: AssociationList
// I kept getting lost between methods while writing this because they all are kind of the same.
// Andrea Smith
// CSCI 1913

class AssociationList<Key, Value>
{
  private class Node
  {
    Key key;
    Value value;
    Node next;
// Constructor shtuff. Does anyone read these?
    private Node(Key key, Value value, Node next)
    {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private Node head = null;

// Create the head node
  public AssociationList()
  {
    head = new Node(null, null, null); // initalize head
  }

// DELETE: Deletes a node in AssociationList using the "left right" method from lecture
  public void delete(Key key)
  {
    Node left = head; // Node being visited
    Node right = left.next;

    while(right != null)
    {
      if(isEqual(right.key, key))
      {
        left.next = right.next;
        break;
      }
      else
      {
        left = right;
        right = right.next;
      }
    }
  }

  // GET: Returns the value of the key if the key is found in the given Node
  public Value get(Key key)
  {
    Node right = head.next;

    while(right != null)
    {
      if(isEqual(right.key, key))
      {
        return right.value;
      }
      else
      {
        right = right.next;
      }
    }
    throw new IllegalArgumentException(); // Will only get here if while loop requirement isn't fulfilled.
  }

// ISEQUAL: Checks if keys are equal
  private boolean isEqual(Key leftKey, Key rightKey)
  {
    if (leftKey == null || rightKey == null)
    {
      return (leftKey == rightKey);
    }
    else
    {
    return (leftKey.equals(rightKey));
    }
  }

// ISIN: Checks if key is in the given node
  public boolean isIn(Key key)
  {
    Node right = head.next;

    while (right != null)
    {
      if (isEqual(right.key, key))
      {
        return true;
      }
      else
      {
        right = right.next;
      }
    }
    return false; // Will only get here if while loop requirement isn't fulfilled.
  }

// PUT: Adds a new node if the key isn't in the given Node
  public void put(Key key, Value value)
  {

    Node right = head.next;

    while (right != null)
    {
      if (isEqual(right.key, key))
      {
        right.value = value;
        break;
      }
      else
      {
        right = right.next;
      }
    }
    // If no such node exists, add a new node immediately after the head node
    Node newNode = head.next;
    head.next = new Node(key, value, newNode);
  }

}

//
//  Tests for CSci 1913 Lab 10
//  James Moen
//  08 Apr 19
//
//  The TRY-CATCH statements catch exceptions thrown by ASSOCIATION LIST's
//  methods, so that the program can continue to run even if a method fails.
//
//  Each test has a comment that shows what it should print and how many points
//  it is worth, for a total of 40 points.

//  HOGWARTS. The Hogwarts dating service.

class Hogwarts
{

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

  public static void main(String[] args)
  {
    AssociationList<String,String> list = new AssociationList<String,String>();

    System.out.println(list.isIn(null));         //  false         2 points.

    try
    {
      System.out.println(list.get(null));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No null");             //  No null       2 points.
    }

    list.put(null,        "Wormtail");
    list.put("Ron",       "Lavender");
    list.put("Voldemort", null);
    list.put("Dean",      "Ginny");

    System.out.println(list.isIn("Dean"));       //  true          2 points.
    System.out.println(list.isIn("Ginny"));      //  false         2 points.
    System.out.println(list.isIn("Ron"));        //  true          2 points.
    System.out.println(list.isIn("Voldemort"));  //  true          2 points.
    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.isIn("Joanne"));     //  false         2 points.

    System.out.println(list.get("Ron"));         //  Lavender      2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Voldemort"));   //  null          2 points.
    System.out.println(list.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(list.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");           //  No Joanne     2 points.
    }

    list.delete(null);

    System.out.println(list.isIn(null));         //  false         2 points.

    list.put(null,    null);
    list.put("Harry", "Ginny");
    list.put("Ron",   "Hermione");

    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.get(null));          //  null          2 points.
    System.out.println(list.get("Harry"));       //  Ginny         2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Ron"));         //  Hermione      2 points.

    list.delete("Dean");

    try
    {
      System.out.println(list.get("Dean"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Dean");             //  No Dean       2 points.
    }
  }
}
