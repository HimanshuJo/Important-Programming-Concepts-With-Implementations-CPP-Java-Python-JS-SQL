#include<vector>
#include<iostream>
#include<cmath>
using namespace std;

int max(int x, int y, int z){
	return max(max(x, y), z);
}

int minVal(vector<int>&hist, int i, int j){
	if(i==-1) return j;
	if(j==-1) return i;
	return (hist[i]<hist[j])?i:j;
}

int getMid(int s, int e){
	return (s+(e-s)/2);
}

int RMQUtil(vector<int>&hist, vector<int>&st, int ss, int se, int qs, int qe, int sidx){
	if(se<qs||ss>qe) return -1;
	if(ss>=qs&&se<=qe) return st[sidx];
	int mid=getMid(ss, se);
	return (minVal(hist, RMQUtil(hist, st, ss, mid, qs, qe, sidx*2+1), 
		                 RMQUtil(hist, st, mid+1, se, qs, qe, sidx*2+2)));
}

int RMQ(vector<int>&hist, vector<int>&st, int n, int qs, int qe){
	if(qs<0||qe>n-1||qs>qe){
		cout<<"Invalid Input"<<endl;
		return -1;
	}
	int ss=0, se=n-1, sidx=0;
	return RMQUtil(hist, st, ss, se, qs, qe, sidx);
}

int constructStUtil(vector<int>&hist, vector<int>&st, int ss, int se, int sidx){
	if(ss==se){
		return (st[sidx]=ss);
	}
	int mid=getMid(ss, se);
	st[sidx]=minVal(hist, constructStUtil(hist, st, ss, mid, sidx*2+1),
		                  constructStUtil(hist, st, mid+1, se, sidx*2+2));
	return st[sidx];
}

vector<int> constructSt(vector<int>&hist, int n){
	int x=(int)(ceil(log2(n)));
	int maxSz=2*(int)pow(2, x)-1;
	vector<int>st(maxSz);
	int ss=0, se=n-1, sidx=0;
	constructStUtil(hist, st, ss, se, sidx);
	return st;
}

int getMaxAreaUtil(vector<int>&hist, vector<int>&st, int n, int l, int r){
	if(l>r) return INT_MIN;
	if(l==r) return hist[l];
	int minVal=RMQ(hist, st, n, l, r);
	return (max(getMaxAreaUtil(hist, st, n, l, minVal-1),
		        getMaxAreaUtil(hist, st, n, minVal+1, r),
		        (r-l+1)*hist[minVal]));
}

int getMaxArea(vector<int>&hist, int n){
	vector<int>st=constructSt(hist, n);
	int l=0, r=n-1;
	return getMaxAreaUtil(hist, st, n, l, r);
}

int main(){
	vector<int>hist{6, 1, 5, 4, 5, 2, 6};
	int n=hist.size();
	cout<<getMaxArea(hist, n);
	return 0;
}
