def dijkstra(graph, start, goal):
    # a dictionary of key(node), value(shortest distance) pair
    shortest_distance = {}
    predecessor = {}
    unseen_nodes = graph
    infinity = 9999999
    path = []
    for node in unseen_nodes:
        shortest_distance[node] = infinity
    shortest_distance[start] = 0
    print('-----')
    print('Initial distance: ', shortest_distance)
    print('-----')

    while unseen_nodes:
        min_node = None
        for node in unseen_nodes:  # just for the base case
            if min_node is None:
                min_node = node  # make 'a' the min node
            elif shortest_distance[node] < shortest_distance[min_node]:
                min_node = node

        for childNode, weight in graph[min_node].items():  # e.g. items of 'a'
            if weight + shortest_distance[min_node] < shortest_distance[childNode]:
                shortest_distance[childNode] = weight + \
                    shortest_distance[min_node]
                predecessor[childNode] = min_node
        unseen_nodes.pop(min_node)

    current_node = goal
    while current_node != start:
        try:
            path.insert(0, current_node)
            current_node = predecessor[current_node]
        except KeyError:
            print('Path not reachable')
            break
    path.insert(0, start)
    if shortest_distance[goal] != infinity:
        print('Shortest distance is ' + str(shortest_distance[goal]))
        print('And the path is ' + str(path))


def main():
    graph = {'a': {'b': 10, 'c': 3}, 'b': {'c': 1, 'd': 2}, 'c': {
        'b': 4, 'd': 8, 'e': 2}, 'd': {'e': 7}, 'e': {'d': 9}}
    dijkstra(graph, 'a', 'b')


main()
