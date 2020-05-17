// Lab 4: Zillion, but in Java
// First Java lab!
// Andrea Smith
// CSCI 1913

class Zillion {
  private int[] array;

  public Zillion(int size) {
    array = new int[size];
  }

  public void increment() { // change all 9's to 0's, go up 1
    int i = (array.length) -1;
    while((i >= 0) && (array[i] == 9)) {
      array[i] = 0;
      i -= 1;
    }

    if(i >= 0){
      array[i] += 1;
    }
  }

  public String toString(){ // convert to string by appending array elements to a string

    String myString = "";
    for (int i = 0; i < array.length; i++){
      myString += array[i];
    }
    return myString;
  }


    }
    class Driver
    {
      public static void main(String[] args)
      {
        Zillion z = new Zillion(2);
        System.out.println(z);  //  00  2 points

        z.increment();
        System.out.println(z);  //  01  2 points

        z.increment();
        System.out.println(z);  //  02  2 points

        z.increment();
        z.increment();
        z.increment();
        z.increment();
        z.increment();
        z.increment();
        z.increment();
        z.increment();

        System.out.println(z);  //  10  2 points
        z.increment();
        System.out.println(z);  //  11  2 points

        z = new Zillion(4);
        System.out.println(z);  //  0000  2 points

        for (int j = 1; j <= 999; j += 1)
        {
          z.increment();
        }
        System.out.println(z);  //  0999  2 points

        z.increment();
        System.out.println(z);  //  1000  2 points

        for (int j = 1; j <= 999; j += 1)
        {
          z.increment();
        }
        System.out.println(z);  //  1999  2 points

        z.increment();
        System.out.println(z);  //  2000  2 points

        for (int j = 1; j <= 7999; j += 1)
        {
          z.increment();
        }
        System.out.println(z);  //  9999  2 points

        z.increment();
        System.out.println(z);  //  0000  2 points

        z.increment();
        System.out.println(z);  //  0001  1 point
      }
    }
