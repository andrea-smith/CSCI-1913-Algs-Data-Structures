# Lab 3
# I really don't like these number labs...
# Andrea Smith
# CSCI 1913

def Maximum(T): # Continuously compares which of the first two values are larger until it reaches the end of the list
    if len(T) == 1:
        return T[0]
    elif T[0] > T[1]:
        return Maximum((T[0],)+T[2:])
    else:
        return Maximum(T[1:])

def Remove(T,E): # Finds the first instance of E in the tuple and removes it, then returns the "modified" tuple
    if len(T) == 0:
        return T
    elif T[0] == E:
        return T[1:]
    else:
        return (T[0],) + Remove(T[1:],E)

def Sort(T): # Repeatedly removes the maximum number from the tuple and returns each maximum to the end to sort the tuple in ascending order
    if len(T) == 0:
        return T
    else:
        return Sort(Remove(T,Maximum(T))) + (Maximum(T),)


print(Maximum((1,)))                      #  1                            2 pt.
print(Maximum((-2, -1)))                  # -1                            2 pt.
print(Maximum((1, 1)))                    #  1                            2 pt.
print(Maximum((1, 2, 3)))                 #  3                            2 pt.

print(Remove((), 1))                      #  ()                           2 pt.
print(Remove((1,), 1))                    #  ()                           2 pt.
print(Remove((0, 1), 0))                  #  (1,)                         2 pt.
print(Remove((0, 1, 2, 1, 3), 1))         #  (0, 2, 1, 3)                 2 pt.
print(Remove((0, 1, 2, 1, 3), 2))         #  (0, 1, 1, 3)                 2 pt.
print(Remove((1, 2, 3), 3))               #  (1, 2)                       2 pt.

print(Sort(()))                           #  ()                           2 pt.
print(Sort((0,)))                         #  (0,)                         2 pt.
print(Sort((0, -1)))                      #  (-1, 0)                      2 pt.
print(Sort((1, 0)))                       #  (0, 1)                       2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.
print(Sort((0, -1, 0)))                   #  (-1, 0, 0)                   2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.

print(Sort((9, 8, 7, 6, 5, 4, 3, 2, 1)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 3, 4, 5, 6, 7, 8, 9)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 1, 4, 2, 5, 4, 5, 3)))  #  (1, 1, 2, 2, 3, 4, 4, 5, 5)  2 pt.
