# Lab 2: Zillion
# Counting is hard.
# Andrea Smith
# CSCI 1913

class Zillion:
    def __init__(self,digits):
        self.digits = []


        for i in digits:
            if i == " " or i == ",":
                continue
            elif i.isdigit() == False:              # check if list of digits contains at least one digit and add that bih to a new list
                raise RuntimeError
            else:
                self.digits.append(int(i))

        if len(self.digits) == 0:
            raise RuntimeError


    def increment(self):                             # If the number is 9, replace it with a zero. If it's not 9, add 1
            i = len(self.digits) -1                  # start at the end of the list, checks right to left
            while self.digits[i] == 9 and i >= 0:
                self.digits[i] = 0
                i -= 1

            if i < 0:
                self.digits.insert(0,1)
            elif self.digits[i] != 9:
                self.digits[i] += 1


    def isZero(self):                               # checks if the number is all zero(es)
        for i in self.digits:
            if i == 0:
                return True
            else:
                return False

    def toString(self):                             # converts value to a string
        convertedStr = ""
        for i in self.digits:
            convertedStr += str(i)
        return convertedStr

#
#  TESTS. Test the class Zillion for CSci 1913 Lab 2.
#
#    James Moen
#    18 Sep 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth.
#

try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.
