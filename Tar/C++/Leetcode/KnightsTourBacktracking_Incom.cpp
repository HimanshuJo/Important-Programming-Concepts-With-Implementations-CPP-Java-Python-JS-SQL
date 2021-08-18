#include<bits/stdc++.h>
using namespace std;

class KnightsTour {
    const int size = 8;
    public:
    bool isValidIndex(int x, int y, vector<vector<int>> board) {
        if (x >= 0 && y >= 0 && x < size && y < size && board[x][y] == -1) {
            return true;
        }
        return false;
    }

    void printChessBoardMatrix(int size, vector<vector<int>> board) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                cout << board[i][j] << " ";
            }
            cout << "\n";
        }
    }

    bool solveKnightsTourUtil(int size, vector<vector<int>> board, int currX, int currY, int moveX[], int moveY[], int stepCount) {
        // if the stepCount reaches the last board position, that means we have found a valid solution
        if (stepCount == pow(size, 2)) {
            return true;
        }
        for (int i = 0; i < size; ++i) {
            int newX = currX + moveX[i];
            int newY = currY + moveY[i];
            if (isValidIndex(newX, newY, board)) {
                board[newX][newY] = stepCount;
                if (solveKnightsTourUtil(size, board, newX, newY, moveX, moveY, stepCount + 1)) {
                    return true;
                }
                board[newX][newY] = -1;
            }
        }
        return false;
    }

    void solveKnightsTour(int size) {
        vector<vector<int>> board;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                board[i][j] = -1;
            }
        }
        int moveX[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int moveY[] = {1, 2, 2, 1, -1, -2, -2, -1};
        board[0][0] = 0;
        int stepCount = 1;
        if (!solveKnightsTourUtil(size, board, 0, 0, moveX, moveY, stepCount)) {
            cout << "Solution doesn't exist" << "\n";
        } else {
            printChessBoardMatrix(size, board);
        }
    }
};

int main() {
    KnightsTour obj;
    obj.solveKnightsTour(8);
}