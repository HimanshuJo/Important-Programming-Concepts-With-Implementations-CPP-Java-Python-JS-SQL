def get_first(data):  # O(1)
    return data[0]


def time_complexity_log_n(data):  # O(log n)
    for index in range(0, len(data), 3):
        print(data[index])


def binary_search(data, value):  # O(log n)
    n = len(data)
    left = 0
    right = n - 1
    while left <= right:
        middle = int((left + right) / 2)
        if value < data[middle]:
            right = middle - 1
        elif value > data[middle]:
            left = middle + 1
        else:
            return middle
    raise ValueError('Value is not in the list')


def linear_search(data, value):  # O(n)
    for index in range(len(data)):
        if value == data[index]:
            return index
    raise ValueError('Value not found in the list')


def merge_sort(data):  # O(n log n)
    if len(data) <= 1:
        return
    mid = int(len(data) / 2)
    left_data = data[:mid]
    right_data = data[mid:]
    merge_sort(left_data)
    merge_sort(right_data)
    left_index = 0
    right_index = 0
    data_index = 0
    while (left_index < len(left_data) and right_index < len(right_data)):
        if left_data[left_index] < right_data[right_index]:
            data[data_index] = left_data[left_index]
            left_index += 1
        else:
            data[data_index] = right_data[right_index]
            right_index += 1
        data_index += 1
    if left_index < len(left_data):
        del data[data_index:]
        data += left_data[left_index:]
    elif right_index < len(right_data):
        del data[data_index:]
        data += right_data[right_index:]


def bubble_sort(data):  # O(n^2)
    swapped = True
    while swapped:
        swapped = False
        for i in range(len(data) - 1):
            if data[i] > data[i + 1]:
                data[i], data[i + 1] = data[i + 1], data[i]
                swapped = True


def time_complexity_n_multiply_n(data):  # O(n^2) --> Quadratic
    for x in data:
        for y in data:
            print(x, y)


def fibonacci(n):  # O(2^n) --> another example is brute force
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)


if __name__ == '__main__':
    data = [1, 2, 9, 8, 3, 4, 7, 6, 5]
    data_2 = sorted(data)
    data_3 = [9, 1, 7, 6, 2, 8, 5, 3, 4, 0]
    data_4 = [9, 1, 7, 6, 2, 8, 5, 3, 4, 0]
    print('sorted data is ', data_2)
    print('----')
    print(get_first(data))
    print('----')
    print(time_complexity_log_n(data))
    print('----')
    print(binary_search(data_2, 8))
    print('----')
    print(linear_search(data, 7))
    print('----')
    merge_sort(data_3)
    print('after merge sort', data_3)
    print('----')
    bubble_sort(data_4)
    print('after bubble sort', data_4)
    print('----')
    # print(time_complexity_n_multiply_n(data))
