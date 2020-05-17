// Lab 6: Polygon
// I had to turn this one in late. :(
// Andrea Smith
// CSCI 1913

class Polygon
{
  private int[] sideLengths;

  public Polygon(int sides, int lengths)
  {
    int index = 0;
    sideLengths = new int[sides];
    for (int length: lengths)
    {
      sideLengths[index] = length;
      index += 1;
    }
  }

  public int side(int number)
  {
    return sideLengths[number];
  }

  public int perimeter()
  {
    int total = 0;
    for (int index = 0; index < sideLengths.length; index += 1)
    {
      total += side(index);
    }
    return total;
  }
}

// Begin lab
class Rectangle extends Polygon
{
  int width = 0;
  int length = 0;

  public Rectangle(int width, int length)
  {
    super(4, width, length, width, length);
    this.width = width;
    this.length = length;
  }

  public int area()
  {
    return width*length;
  }

// perimeter is inherited
}


class Square extends Rectangle
{

  private int length;

  public Square(int length)
  {
    super(length, length);
    this.length = length;
  }

  public int area()
  {
    return length*length;
  }

// perimeter is inherited here also
}

//  SHAPES. Public tests for the classes RECTANGLE and SQUARE. Comments show
//  what each test must print, and how many points it is worth.

class Shapes
{
  public static void main(String[] args)
  {
    Rectangle wreck = new Rectangle(3, 5);

    System.out.println(wreck.side(0));      //  3   1 point.
    System.out.println(wreck.side(1));      //  5   1 point.
    System.out.println(wreck.side(2));      //  3   1 point.
    System.out.println(wreck.side(3));      //  5   1 point.
    System.out.println(wreck.area());       //  15  1 point.
    System.out.println(wreck.perimeter());  //  16  1 point.

    Square nerd = new Square(7);

    System.out.println(nerd.side(0));       //  7   1 point.
    System.out.println(nerd.side(1));       //  7   1 point.
    System.out.println(nerd.side(2));       //  7   1 point.
    System.out.println(nerd.side(3));       //  7   1 point.
    System.out.println(nerd.area());        //  49  1 point.
    System.out.println(nerd.perimeter());   //  28  1 point.
  }
}
