// Lab 8: RunnyStack
// This lab made me crave cheese.
// Andrea Smith
// CSCI 1913

class RunnyStack<Base>
{

  // To make it run
  class Run
  {
    private Base base;
    private int length;
    private Run next;

    private Run(Base base, int length, Run next)
    {
      this.base = base;
      this.length = length;
      this.next = next;
    }
  }

  private Run top;
  private int depth = 0; // number of objects
  private int runs; // number of runs

  public RunnyStack() { }

// The value of depth
  public int depth()
  {
    return depth;
  }

// Checks if stack is empty
  public boolean isEmpty()
  {
    return top == null;
  }

// Returns the base at the top of the stack
  public Base peek()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("The stack is empty.");
    }
    else
    {
      return top.base;
    }
  }

// Yeets a base off of the stack
  public void pop()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("The stack is empty.");
    }

    if (top.length > 1)
    {
      top.length--;
    }
    else
    {
      top = top.next; // If it hits zero, remove it
      runs--;
    }
    depth--; // keep count of the depth, this must be outside of the if else statement or it screws everything, apparently
  }

// Pushes a new base to the stack
  public void push(Base base)
  {
    if (isEmpty())
    {
      top = new Run(base, 1, null); // Add a new run of one Base at the top of the stack. Null bc reasons
      runs++;
    }
    else
    {
      if (top.base == base)
      {
        top.length++;
      }
      else
      {
        top = new Run(base, 1, top); // Add a new run of one Base at top of the stack, top because we don't want to reset, want to add on top of the previous one
        runs++;
      }
    }
    depth++; // I don't know if anyone will read this but THIS LINE RIGHT HERE GAVE ME SUCH A HEADACHE!! IT WAS JUST NESTED ONE TOO DEEP AND I SPENT SO LONG DEBUGGING AAA

  }

// Keeps track of the values of the runs
  public int runs()
  {
    if (top == null)
    {
      return 0;
    }
    else
    {
      return runs;
    }
  }

}

//
//  Tests for CSci 1913 Lab 8
//  James Moen
//  20 Mar 17
//
//  The TRY-CATCH statements catch exceptions thrown by RUNNY STACK's methods,
//  so that the program can continue to run even if a method fails. We still
//  haven't talked about TRY-CATCH'es in the lectures yet.
//
//  Most tests have comments that show what they should print, and how many
//  points they are worth, for a total of 40 points.
//
//  Camembert is a soft French cheese. It may be runny. It can be stacked.
//

class Camembert
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     1 point
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }

    s.push("A");
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    System.out.println(s.isEmpty());         //  false      1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  2          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  6          1 point
    System.out.println(s.runs());            //  3          1 point
    s.pop();
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    s.pop();
    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
  }
}
