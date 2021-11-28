/*
Monocarp is a tutor of a group of n students. He communicates with them using a conference in a popular messenger.

Today was a busy day for Monocarp — he was asked to forward a lot of posts and announcements to his group, that's why he had to 
write a very large number of messages in the conference. Monocarp knows the students in the group he is tutoring quite well, so he understands 
which message should each student read: Monocarp wants the student i to read the message mi.

Of course, no one's going to read all the messages in the conference. That's why Monocarp decided to pin some of them. Monocarp can pin any number of messages, 
and if he wants anyone to read some message, he should pin it — otherwise it will definitely be skipped by everyone.

Unfortunately, even if a message is pinned, some students may skip it anyway. For each student i, Monocarp knows that they will read at most ki messages. 
Suppose Monocarp pins t messages; if t<=ki, then the i-th student will read all the pinned messages; but if t>ki, the i-th student will choose exactly ki
random pinned messages (all possible subsets of pinned messages of size ki are equiprobable) and read only the chosen messages.

Monocarp wants to maximize the expected number of students that read their respective messages (i.e. the number of such indices i that student i reads the message mi). 
Help him to choose how many (and which) messages should he pin!

input
4
1 1
2 2
3 3
4 4

output
3
2 3 4     
*/

#include<vector>
#include<algorithm>
#include<iostream>
#include<random>
using namespace std;

const int N=200001;
const int K=20;
vector<int>idx[N];
int msg[N], k[N];

bool frac_greater(pair<int, int>A, pair<int, int>B){
	return A.first*B.second>A.second*B.first;
}

int main(){
	int n;
	cin>>n;
	for(int i=0; i<n; ++i){
		cin>>msg[i]>>k[i];
		idx[msg[i]].push_back(i);
	}
	vector<int>cert;
	pair<int, int>ans={0, 1};
	for(int i=1; i<=K; ++i){
		vector<int>score(N);
		for(int j=0; j<n; ++j){
			score[msg[j]]+=min(i, k[j]);
		}
		vector<pair<int, int>>aux;
		for(int j=0; j<N; ++j){
			aux.push_back({score[j], j});
		}
		sort(aux.rbegin(), aux.rend());
		pair<int, int>curr_ans={0, i};
		vector<int>curr_cert;
		for(int j=0; j<i; ++j){
			curr_ans.first+=aux[j].first;
			curr_cert.push_back(aux[j].second);
		}
		if(frac_greater(curr_ans, ans)){
			ans=curr_ans;
			cert=curr_cert;
		}
	}
	cout<<cert.size()<<"\n";
	for(auto &vals: cert){
		cout<<vals<<" ";
	}
}
