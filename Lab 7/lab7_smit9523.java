// Lab 7: BinaryVsLinear
// I liked this one. Graphs are fun.
// Andrea Smith
// CSCI 1913

class BinaryVsLinear
{

  private static int linearSearch(int key, int[] keys)
  {
    for (int i=0; i < keys.length; i += 1)
    {

      if (keys[i] == key)
      {
        return i + 1; // i is one less than the number of comparisons, so i is the counter variable
      }
    }
    return -1; // failure case if key is not in array keys
  }

  private static int binarySearch(int key, int[] keys)
  {
    int count = 0;
    int left = 0;
    int right = keys.length -1;
    while (left <= right)
    {
      int mid = left + (right - left) / 2;
      count = count + 1;
      // If the key is the middle value, you found it already, do nothing.
      if (keys[mid] == key)
      {

        return count;
      }

      // If key is greater, ignore left half and only search right side.
      else if (keys[mid] < key)
      {
        // count = count + 1;
        left = mid + 1;
        // return count;
      }

      // If key is smaller, ignore right half and only search left side.
      else {
        right = mid - 1;
        // return count;
      }
    }

    return -1; // Failure case-- if program reaches here, keys was not in the array.
  }

  public static void main(String[] args)
  {
    for (int length = 1; length <= 30; length += 1)
    {
      int[] array = new int[length];
      for (int index = 0; index < length; index += 1)
      {
        array[index] = index;
      }

      double linearTotal = 0.0;
      double binaryTotal = 0.0;
      for (int element = 0; element < length; element += 1)
      {
        linearTotal += linearSearch(element, array);
        binaryTotal += binarySearch(element, array);
      }

      double linearAverage = linearTotal / length;
      double binaryAverage = binaryTotal / length;
      System.out.println(length + " " + linearAverage + " " + binaryAverage);

    }
  }
}
