
/*

Median is the middle value in an ordered integer list.
If the size of the list is even, there is no middle value.
So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

*/

/*

Points to note:

    we don't know the size of the data stream
    so for every given number, we need to add it to our let's say list,
        and find the median value of this list

Simple Solution:

    We can use a data structure, and every time we add a number, we put that integer to our list
        and when we call findMedian() method, we can just sort that list.

    Finally we chose the Median value

    Solution is not efficient:
        as we do not use the information of the previous calls

Good Solution:

    This is a sort problem, but we don't know the whole array

    We can use some data structure that already has this ordering information

    We can use Heap in Java

        If we only use one heap, there is no major difference from using a list and sort it again
            sort the list every time to get the middle value

        Therefore we can use two heaps (split the heap into two parts)

            Why:

                If we use just one ordered heap, we needed to get just one middle value

                If we use two heaps, we can get 2 peeks from these two heaps

            So
                for the max. value for one heap (or one part) = maxHeap.peek()

                for the min. value for another heap (or another part) = minHeap.peek()

            Why we can use two heaps: [2, 5, 6, 7, 8, 9] --> [2, 5, 6], [7, 8, 9]

                while putting them in the queue is should be like this
                    maxHeap -> 6, 5, 2  --> maxHeap.peek()  --> will give us the max ele

                    minHeap -> 7, 8, 9  --> minHeap.peek()  --> will give us the min ele

                Because if the heap is sorted, then the left part are the smaller elements
                    and the right part are the larger elements

                So if we get 

                    the max. element from the smaller part, and

                    get the min. value from the larger part, we can quickly get their mean

            Configuration of two heaps:

                One heap can be in ascending order, we get its peek and then its max. value

                Other heap is in descending order, we get its peek and then its min. value
                    (the heap with max values in it)

            -------

            minHeap  --> save large values (minHeap because we have to get the min ele from here)
                we can also use another variable to record its size (e.g. minSize)

            -------

            maxHeap  --> save smaller values (maxHeap because we have to get the max ele from here)
                we can also use another variables to record its size (e.g. maxSize)

            -------

            Cases: addNum(int num)

                0: minSize == 0  (first number)

                    add num to minHeap

                1: maxSize == 0 (second number)

                    if num < minHeap.peek()

                        maxHeap.offer(num)  // as it is storing smaller numbers

                    else

                        swap

                2: num < minHeap.peek() (any further number)

                    save num --> maxHeap  (as all the numbers in minHeap > num)

                    all elements in minHeap are > num

                3: save num --> minHeap

    We should also call every time a balance method

        because we should always make sure that the difference of any two heap sizes
            should be less or equal to 1

            private void balance() {
                if |minSize - maxSize| <= 1 return;

                if maxSize > minSize
                    offer 1 element from maxHeap to minHeap

                else
                    offer 1 element from minHeap to maxHeap
            }
*/

import java.util.*;

class MedianFinder {
    
    // stores the MIN values (have to take out the max value)
    // custom sorting order
        // we have to load initially the bigger entries and then the smaller entries
        // descending sorting order
    PriorityQueue<Integer> leftHeap;

    // stores the MAX values (have to take out the min value)
    // therefore we put the min elements first and max later
        // we can just peek later and get the min value
        // default sorting order
    PriorityQueue<Integer> rightHeap;
    
    int leftSize;  // size of the list with smaller elements
    int rightSize;  // size of the list with larger values
    
    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a, b) -> b - a);
        rightHeap = new PriorityQueue<>();

        leftSize = 0;  // size of the left Heap
        rightSize = 0;  // size of the right Heap
    }
    
    public void addNum(int num) {
        
        // the very initial number can be in the list with the bigger numbers
        if (rightSize == 0) {
            rightHeap.offer(num);
            rightSize++;
            return;
        }
        
        if (leftSize == 0) {
            if (num < rightHeap.peek()) {
                leftHeap.offer(num);
            } else {  // the num has to be in the list with bigger numbers
                      // take out one number from the bigger list and put it in the smaller list
                leftHeap.offer(rightHeap.poll());
                // we don't have to increase the size, as we have removed one ele before
                rightHeap.offer(num); 
            }
            leftSize++;
            return;
        }
        
        if (num < rightHeap.peek()) {
            leftHeap.offer(num);
            leftSize++;
        } else {
            rightHeap.offer(num);
            rightSize++;
        }
        
        balance();
        
    }
    
    public void balance() {
        if (Math.abs(leftSize - rightSize) <= 1) {
            return;
        }
        
        if (leftSize > rightSize) {
            rightHeap.offer(leftHeap.poll());
            leftSize--;
            rightSize++;
        } else {
            leftHeap.offer(rightHeap.poll());
            rightSize--;
            leftSize++;
        }
    }
    
    public double findMedian() {
        if (leftSize > rightSize) {
            return leftHeap.peek();
        }
        
        if (rightSize > leftSize) {
            return rightHeap.peek();
        }
        
        return (leftHeap.peek() + rightHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


import java.util.*;

class MedianFinder2 {
    
    // stores the MAX values (have to take out the min value)
        // therefore we put the min elements first and max later
        // we can just peek later and get the min value
        // default sorting order
    PriorityQueue<Integer> minHeap;
    
    // stores the MIN values  (have to take out the max value)
    // custom sorting order
        // we have to load initially the bigger entries and then the smaller entries
        // descending sorting order
    PriorityQueue<Integer> maxHeap;
    
    int maxSize;  // size of the list with smaller elements
    int minSize;  // size of the list with larger values
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minSize = 0;  // size of the min Heap
        maxSize = 0;  // size of the max Heap
    }
    
    public void addNum(int num) {
        
        // the very initial number can be in the list with the bigger numbers
        if (minSize == 0) {
            minHeap.offer(num);
            minSize++;
            return;
        }
        
        if (maxSize == 0) {
            if (num < minHeap.peek()) {
                maxHeap.offer(num);
            } else {  // the num has to be in the list with bigger numbers
                      // take out one number from the bigger list and put it in the smaller list
                maxHeap.offer(minHeap.poll());
                // we don't have to increase the size, as we have removed one ele before
                minHeap.offer(num); 
            }
            maxSize++;
            return;
        }
        
        if (num < minHeap.peek()) {
            maxHeap.offer(num);
            maxSize++;
        } else {
            minHeap.offer(num);
            minSize++;
        }
        
        balance();
        
    }
    
    public void balance() {
        if (Math.abs(minSize - maxSize) <= 1) {
            return;
        }
        
        if (maxSize > minSize) {
            minHeap.offer(maxHeap.poll());
            maxSize--;
            minSize++;
        } else {
            maxHeap.offer(minHeap.poll());
            minSize--;
            maxSize++;
        }
    }
    
    public double findMedian() {
        if (maxSize > minSize) {
            return maxHeap.peek();
        }
        
        if (minSize > maxSize) {
            return minHeap.peek();
        }
        
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */