Project 0 : Understanding Recursion

In this project, you are asked to understand the concept of recursion, and to solve some problems using recursion. 

1. Concept of Recursion 

Recursion refers to the functions that calls itself. Therefore, to understand recursion, it is necessary to understand how functions are 'called' and 'call' each other. 

1.1 Call Stack 

Call stack explains how the code is executed. For example, consider following code; 
----------------------------
def func1(a,b):
    func2(a)
    func3(b)

def func2(a):
    print(a)

def func3(b):
    print(b+1)

func1(1,2)
>> 1
3 
----------------------------

When func1 is executed, the computer reads code block inside func1 definition line by line. In this case, func2(a) and func3(b) will be executed in sequence. When func2 is executed, the computer again consults the definition of func2, and executes it. In this case, it only prints a, and returns Null. When func2 returns Null, the computer than knows execution of func2 is finished, and come back to the original function - in this case, func1 - that 'calls' func2. Afterwars, it would execute func3(b), and finish running the program. 

In order to get back to the right function, the computer needs to remember the name and order of functions. The computer uses call stack to remember that information. The basic operation is as following; 

1) When the function is called, the function and parameters are pushed to the call stack. 
2) When the function returns its result, the function is popped from the call stack. 
3) When there are no function remaining in the call stack, the program ends. 

In the given example above, call stack would behave as following. firstly, func1 is called, so call stack should only contain func1(a,b). Than, func1 called func2(a), so stack should conatin two elements [func1(a,b), func2(a)]. Ater execution of func2 is finished, func2 is popped from call stack; only func1 remains in the stack. Than the computer executes func3(b), so func3(b) is pushed to the stack. func3 and func1 is popped from stack, and the program ends.  

1.2 How Recursion Works

Now, consider follwoing code; 

-----------------------------
def func1(a):
    if a == 1:
        return 1    
    else:
        return a*func1(a-1)

func1(3)
-----------------------------

To analyze how this code works, we will simulate the call stack of the program. The call stack should behave as below; 

[func1(3)] -> [func1(3), func1(2)] -> [func1(3), func1(2), func1(1)] -> [func1(3), func1(2)] -> [func1(3)] -> []


Since func1(a) calls func1(a-1), first 2 changes in the call stack should be obvious. If not, read 1.1 again. Now, when func1(1) is called, func1(1) returns 1. Than, the result of func1(1) - which is 1 - is passed to func1(2), and 2*func1(1) is executed. The result is 2, and the result of func2(2) is passed to func1(3). 

So, recursion is nothing different when you consider how call stack works. The only difference is that the function calls itself. However, that should not be a problem except there is no base case. 

1.3 Base Case

Consider the following code; 

----------------------------
def func1(a):
    return a*func1(a-1)

func1(3)
----------------------------

It is very similar to the code in 1.2. However, the only difference is that there is no if-else statement. Now consider how this works; 

[func1(3)] -> [func1(3), func1(2)] -> [func1(3), func1(2), func1(1)] -> [func1(3), func1(2), func1(1), func1(0)] -> ... 

In this case, call stack will never stop to grow! This is because there is no base case; in the code above, a=1 was the base case. 

2. Problems 

In this part, you are asked to solve 3 problems using recursion: Tower of Hanoi, Merge Sort and Quick Sort.   

2.1 Tower of Hanoi 

There is n disks with three column. Each disks have different size, and you are now asked to move n disks from one column to other column. While moving the disks, you should keep following rules; 

1) Move one disks at a time. 
2) Larger disk should be always placed under smaller disk. Smaller disks should NOT be placed under larger disks. 

You should write a java program Hanoi.java that accepts number of disks as input paramter, and prints the sequence of disk movements in the format of 'move (disk number) from (column name) to (column name)'. The column name is fixed to a,b,c. Initially, disks are in column a, and you are asked to move disks to c. Sample input and output is suggested below; 

----------------------------
>> java Hanoi 3
move 1 from a to c 
move 2 from a to b 
move 1 from c to b
move 3 from a to c
move 1 from b to a
move 2 from b to c 
move 1 from a to c 
----------------------------

2.2 Sorting a List 

In this part, you are asked to sort a list of integers in two ways; mergesort and quicksort. 

2.2.1 Merge Sort

Merge sort is an algorithm to sort a list by following sequence; 

1) Split the list to half. 
2) Recursively sort both lists. Call sorted lists l and r.
3) Merge two sorted lists as below; 
3.1) Declare two integers i, j = 0,0 and one list res. 
3.2) Compare two integer l[i], r[j]. 
3.3) If l[i] < r[j], append l[i] to res and i++. Else, append r[j] to res and j++. 

When implementing merge sort, two functions should be implemented; mergesort itself and merge function. 

2.2.2 Quick Sort

Quick sort is an algorithm to sort a list by following sequence; 

1) Select a pivot. Call this p. 
2) Declare two lists. Call this s and b.
3) Compare all elements in the input list with pth element. If the element is smaller than the pth element, append to s. Else, append to b. 
4) Recursively sort s and b. Call the sorted list l and r respectively. 
5) Return l + pth element + r


You should write a java program MySort.java that accepts one alphabet and several integers. First alphabet should be either m or q. If the first alphabet is m, use mergesort. Elif first alphabet is q, use quicksort. Example input/output is suggested below; 

------------------------------
>> java MySort.java m 3 1 2 
1
2
3
------------------------------


