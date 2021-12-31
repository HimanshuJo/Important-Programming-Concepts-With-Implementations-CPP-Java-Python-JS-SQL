# Python program for above approach
from heapq import heappush as push, heappop as pop


def solve(a, b, k):

	# Sorting array b in ascending order
	b.sort()
	n, m = len(a), len(b)

	# Checking if size(a) > size(b)

	if (n < m):

		# Otherwise swap the arrays

		return solve(b, a, k)

	heap = []

	# Tarverse all elements in array a
	for i in range(n):

		curr = a[i]

		# curr element is negative
		if (curr < 0):

			# Product with smallest value
			val = curr * b[0]

			# Pushing negative val due to max heap
			# and i as well jth index
			push(heap, (-val, i, 0))

		else:

			# Product with largest value
			val = curr * b[-1]

			# Pushing negative val due to max heap
			# and i as well jth index
			push(heap, (-val, i, m-1))

	# Subtract 1 due to zero indexing
	k = k-1

	# Remove k-1 largest items from heap
	for _ in range(k):

		val, i, j = pop(heap)
		val = -val

		# if a[i] is negative, increment ith index

		if (a[i] < 0):
			next_j = j + 1

		# if a[i] is positive, decrement jth index
		else:
			next_j = j-1

		# if index is valid
		if (0 <= next_j < m):

			new_val = a[i] * b[next_j]

			# Pushing new_val in the heap
			push(heap, (-new_val, i, next_j))

	# Finally return first val in the heap
	return -(heap[0][0])


# Driver Code
arr = [1, -2, 3]
brr = [3, -4, 0]
K = 3

# Function Call
val = solve(arr, brr, K)

# Print the result
print(val)
