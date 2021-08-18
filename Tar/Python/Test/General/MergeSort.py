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
        print("left index less")
        print(data)
        del data[data_index:]
        data += left_data[left_index:]
    elif right_index < len(right_data):
        print("right index less")
        print(data)
        del data[data_index:]
        data += right_data[right_index:]

if __name__ == '__main__':
    data = [-22, 1, 0, 1, 4, 2, 0, 0, 5, 65]
    merge_sort(data)
    #print(data)
