while (right != null || left != null)
{
  if (right.number <= left.number) // Choose the smaller number. Delete the int and add it to the END of sorted.
  {
    sorted.next = right;
    sorted = right;
    right = right.next;
  }
  else
  {
    sorted.next = left;
    sorted = left;
    left = left.next;
  }
}

// Deal with null case
if (right == null)
{
  sorted.next = right;
}
else
{
  sorted.next = left;
}
