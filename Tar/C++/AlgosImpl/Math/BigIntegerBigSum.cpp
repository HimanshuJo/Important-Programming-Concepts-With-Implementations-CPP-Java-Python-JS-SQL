#include <bits/stdc++.h>
#include <string>
#include<time.h>
#define _POSIX_C_SOURCE 199309L
using namespace std;

int main()
{
	string biggerNum = "78451289562394325623232323232323";
	string smallerNum = "9289562394325931231231231232333";
	vector<int>arr;
	vector<int>arr_;
	for (char ch : biggerNum) {
		arr.push_back(ch - '0');
	}
	for (char ch : smallerNum) {
		arr_.push_back(ch - '0');
	}
	struct timespec start, end;
	clock_gettime(CLOCK_MONOTONIC, &start);
	//int arr[] {7, 8, 4, 5, 1, 2, 8, 9, 5, 6, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3};
	//int arr_[] {5, 6, 2, 3, 9, 5, 5, 6, 2, 3, 9, 5, 5, 6, 2, 3, 9, 5, 5, 6, 2, 3, 9, 5};
	vector<int>res;
	int n = arr.size();
	int n_ = arr_.size();
	//int n = sizeof(arr) / sizeof(arr[0]);
	//int n_ = sizeof(arr_) / sizeof(arr_[0]);
	int index = n_ - 1;
	int car = 0;
	string ans = "";
	for (int i = n - 1; i >= 0; --i) {
		int curr = arr[i] + arr_[index] + car;
		car = curr / 10;
		if (i == 0 || index == 0) {
			if (index == 0 && i != 0) {
				curr %= 10;
				res.push_back(curr);
				if (i != 0) {
					int car_ = car;
					for (int x = i - 1; x >= 0; --x) {
						int curr_ = arr[x] + car_;
						car_ = curr_ / 10;
						curr_ %= 10;
						res.push_back(curr_);
					}
					if (car_ != 0) {
						car_ *= 10;
						res.pop_back();
						res.push_back(car_);
					}
					reverse(res.begin(), res.end());
					for (auto &vals : res)
						ans += to_string(vals);
				}
			} else {
				res.push_back(curr);
				reverse(res.begin(), res.end());
				for (auto &vals : res)
					ans += to_string(vals);
			}
			break;
		} else {
			curr %= 10;
			res.push_back(curr);
			index--;
		}
	}
	cout << ans << endl;
	clock_gettime(CLOCK_MONOTONIC, &end);
	double time_taken;
	time_taken = (end.tv_sec - start.tv_sec) * 1e9;
	time_taken = (time_taken + (end.tv_nsec - start.tv_nsec)) * 1e-9;

	cout << "Time taken by program is : " << fixed
	     << time_taken << setprecision(9);
	cout << " sec" << endl;
}

