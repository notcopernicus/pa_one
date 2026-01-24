#### Stacks, Queues & Recursion

*Stack* is a linear data structure in which elements are organized in a LIFO  (Last in first out) or FILO (First in last out) manner.
    
    Operations & Time Complexity:
        1. Push (add an element) - O(1)
        2. Pop (remove and return top element) - O(1)
        3. Peek (returns top element) - O(1)
        4. isEmpty (returns true when no elements) - O(1)
        5. size (returns numver of elements) - O(1)

    Note: 
        Array Based Implementation and Linked List Implementation

*Queue* is a linear data structure in whcih elements are organized in a FIFO (First in, First out) manner.

 *Deque* or double ended queue allows for insertion and removal at both ends of the queue.
    
    *Operations & Time Complexity:*

        1. Enqueue (insertion) — O(1)
        2. Dequeue (deletion) - O(n)
        3. Front (get front) - O(1)
        4. Rear (get rear) - O(1)
        5. isFull (check elements < size) - O(1)
        6. isEmpty (check elements = 0) - O(1)

    *Note:* 
        Circular Array Implementation moves the front and rear using modular arithmetic and makes all operations in O(1) time complexity.

         - May waste space

        Simple Array Implementation inserts at the rear O(1) and removes from the front O(n). 
        
        If we remove from rear and add to front then inserntion becomes O(n), where n is the number of elements in our queue. 

        Linked List Implementation has a front that points to the first node or head of the queue and a rear that points to the last node or the tail of the queue.

        - Always has space

    *Examples:*

        1. Round Robin Scheduling
        2. Buffered I/O
        3. Emailing
        4. Printing




#### Important Terminology

1. Abstract Data Type - Mathematical description of a "thing" with set operations not concerned with implementation details
2. Algorithm - A high level, language-independent set of step-by-step instructions.
3. Data Structure - A specific organization of data and family of algorithms for implementing a ADT.
4. Generics - Allow you to decouple the ADT (structure) from the data (content)
5. Time Quantum - A preemptive scheduler process runs until it is placed back in the ready queue and another process is placed into the run state.
6. Recursion

#### Assignment Writeup

We are being asked to implement two data structures from scratch to solve two real world computing problems: parsing methematical expressions and scheduling CPU tasks.

We now know that stacks are perfect for nested or order-reversing problem, while queues are essential for fair, sequential processing (printer jobs etc)

#### Resources

Queue Linked List Implementation - https://www.geeksforgeeks.org/dsa/queue-linked-list-implementation/

Stack Linked List Implementation - https://www.geeksforgeeks.org/dsa/queue-linked-list-implementation/


Queue Circular Array Implementation - https://www.geeksforgeeks.org/dsa/introduction-to-circular-queue/

GenAI: Gemini was utilized for ideation and concept clarification, however all code is original.


##### Other Notes:

*01-18-26 14:05 PM -*

In this assignment, I will implement my stack using a linked list and implement my queue using a circular array. 

I chose a linked list for stack implementation because theres no fixed capacity, no overflow, efficient memory and easy operations. 

I chose a circular array for queue implementation for easy underatanding. However, linked list queue implementation doesn't have a fixed compacity, unlike array implementation in which overflow occurs when the size == capacity.

Coding Task:
    1. Implement a linked list stack (finished 01-20-26 19:06)
    2. Implement a circular queue (finished 01-20-26 19:06)

01-19-26 23:55
    Nothing to commit

01-20-26 19:06

"Linear structures can be thought of as having two ends. Sometimes these ends are referred to as the left and the right, or in some cases the front and the rear. You could also call them the top and the bottom. The names given to the ends are not significant. What distinguishes one linear structure from another is the way in which items are added and removed, in particular the location where these additions and removals occur. For example, a structure might allow new items to be added at only one end. Some structures might allow items to be removed from either end." - Problem Solving with Algorithms and Data Structures Bradley N. Miller
 

1-23-26 18:33

Assignment is due! I change my mind about the circulation it actually is actually more difficult to implement than a linked list

21:20 Recursion is simply a function that calls itself