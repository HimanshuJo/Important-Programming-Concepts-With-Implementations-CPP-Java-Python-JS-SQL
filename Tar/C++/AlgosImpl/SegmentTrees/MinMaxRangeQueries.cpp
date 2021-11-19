// C++ program to find minimum and maximum using segment tree
#include <bits/stdc++.h>
using namespace std;

// Node for storing minimum nd maximum value of given range
struct Node
{
    int minimum;
    int maximum;
};

// A utility function to get the middle index from corner indexes.
int getMid(int s, int e) { return s + (e - s) / 2; }

/* A recursive function to get the minimum and maximum value in
    a given range of array indexes. The following are parameters
    for this function.

    st    --> Pointer to segment tree
    index --> Index of current Node in the segment tree.
              Initially 0 is passed as root is always at index 0
    ss & se --> Starting and ending indexes of the segment
                represented by current Node, i.e., st[index]
    qs & qe --> Starting and ending indexes of query range */

struct Node MaxMinUntill(struct Node *st, int ss, int se, int qs, int qe, int index)
{
    // If segment of this Node is a part of given range, then return
    // the minimum and maximum Node of the segment
    struct Node tmp, left, right;
    if (qs <= ss && qe >= se)
        return st[index];

    // If segment of this Node is outside the given range
    if (se < qs || ss > qe)
    {
        tmp.minimum = INT_MAX;
        tmp.maximum = INT_MIN;
        return tmp;
    }

    // If a part of this segment overlaps with the given range
    int mid = getMid(ss, se);
    left = MaxMinUntill(st, ss, mid, qs, qe, 2 * index + 1);
    right = MaxMinUntill(st, mid + 1, se, qs, qe, 2 * index + 2);
    tmp.minimum = min(left.minimum, right.minimum);
    tmp.maximum = max(left.maximum, right.maximum);
    return tmp;
}

// Return minimum and maximum of elements in range from index
// qs (quey start) to qe (query end). It mainly uses
// MaxMinUtill()
struct Node MaxMin(struct Node *st, int n, int qs, int qe)
{
    struct Node tmp;

    // Check for erroneous input values
    if (qs < 0 || qe > n - 1 || qs > qe)
    {
        printf("Invalid Input");
        tmp.minimum = INT_MIN;
        tmp.minimum = INT_MAX;
        return tmp;
    }

    return MaxMinUntill(st, 0, n - 1, qs, qe, 0);
}

// A recursive function that constructs Segment Tree for array[ss..se].
// si is index of current Node in segment tree st
void constructSTUtil(int arr[], int ss, int se, struct Node *st, int si)
{
    // If there is one element in array, store it in current Node of
    // segment tree and return
    if (ss == se)
    {
        st[si].minimum = arr[ss];
        st[si].maximum = arr[ss];
        return;
    }

    // If there are more than one elements, then recur for left and
    // right subtrees and store the minimum and maximum of two values
    // in this Node
    int mid = getMid(ss, se);
    constructSTUtil(arr, ss, mid, st, si * 2 + 1);
    constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);

    st[si].minimum = min(st[si * 2 + 1].minimum, st[si * 2 + 2].minimum);
    st[si].maximum = max(st[si * 2 + 1].maximum, st[si * 2 + 2].maximum);
}

/* Function to construct segment tree from given array. This function
allocates memory for segment tree and calls constructSTUtil() to
fill the allocated memory */
struct Node *constructST(int arr[], int n)
{
    // Allocate memory for segment tree

    // Height of segment tree
    int x = (int)(ceil(log2(n)));

    // Maximum size of segment tree
    int max_size = 2 * (int)pow(2, x) - 1;

    struct Node *st = (struct Node*)malloc(max_size * sizeof(struct Node));
    //struct Node *st = new struct Node[max_size];

    // Fill the allocated memory st
    constructSTUtil(arr, 0, n - 1, st, 0);

    // Return the constructed segment tree
    return st;
}

// Driver program to test above functions
int main()
{
    int arr[] = {87, 68, 91, 86, 58, 63, 43, 98, 6, 40};
    int n = sizeof(arr) / sizeof(arr[0]);

    // Build segment tree from given array
    struct Node *st = constructST(arr, n);

    int qs = 6; // Starting index of query range
    int qe = 7; // Ending index of query range
    struct Node result = MaxMin(st, n, qs, qe);

    // Print minimum and maximum value in arr[qs..qe]
    printf("Minimum = %d and Maximum = %d ", result.minimum, result.maximum);

    return 0;
}