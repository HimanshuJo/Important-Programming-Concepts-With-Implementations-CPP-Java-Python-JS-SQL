
package com.essenbazar.medianDataStream295;

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

                Because if the heap is sorted, then the left part are the smaller elements
                    and the right part are the larger elements

                So if we get the max. element from the smaller part, and
                    get the min. value from the larger part, we can quickly get their mean

            Configuration of two heaps:

                One heap can be in ascending order, we get its peek and then its max. value

                Other heap is in descending order, we get its peek and then its min. value

            minHeap  --> save large values
                we can also use another variable to record its size (e.g. minSize)

            maxHeap  --> save smaller values
                we can also use another variables to record its size (e.g. maxSize)

            Cases: addNum(int num)

                0: minSize == 0  (first number)

                    add num to minHeap

                1: maxSize == 0 (second number)

                    if num < minHeap.peek()

                        maxHeap.offer(num)

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
import java.util.PriorityQueue;

public class Solution {

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	int minSize;
	int maxSize;

	public Solution() {
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
		minSize = 0;
		maxSize = 0;
	}

	public void addNum(int num) {
		if (minSize == 0) {
			minHeap.offer(num);
			minSize++;
			return;
		}

		if (maxSize == 0) {
			if (num < minHeap.peek()) {
				maxHeap.offer(num);
			} else {
				maxHeap.offer(minHeap.poll());
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

	private void balance() {
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
