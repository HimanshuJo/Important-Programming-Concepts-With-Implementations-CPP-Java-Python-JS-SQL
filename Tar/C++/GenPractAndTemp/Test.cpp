#include<iostream>
#include<unordered_map>
#include<stack>
using namespace std;

struct Node{
	int val;
	struct Node *left, *right;
};

struct Node* createNewNode(int val){
	struct Node* node=(struct Node*)malloc(sizeof(struct Node));
	node->val=val;
	node->left=node->right=nullptr;
	return node;
}

void dispTreeTopToBottom(unordered_map<struct Node*, struct Node*>&parent, struct Node* node){
	for(auto &entries: parent){
		if(entries.second!=nullptr) cout<<entries.first->val<<" : "<<entries.second->val<<endl;
	}
	cout<<"-------\n";
	while(parent[node]){
		cout<<parent[node]->val<<" ";
		node=parent[node];
	}
	/*while(node=parent[node]){
		cout<<node->val<<" ";
	}*/
	cout<<"\n";
}

void setParent(unordered_map<struct Node*, struct Node*>&parent, struct Node* root){
	stack<struct Node*>stk;
	stk.push(root);
	while(!stk.empty()){
		struct Node* curr=stk.top();
		stk.pop();
		if(curr->right){
			// curr is the parent of curr->right
			parent[curr->right]=curr;
			stk.push(curr->right);
		}
		if(curr->left){
			// curr is the parent of curr->left
			parent[curr->left]=curr;
			stk.push(curr->left);
		}
	}
}

void findAncestors1(struct Node* root, struct Node* node){
	if(root==nullptr) return;
	unordered_map<struct Node*, struct Node*>parent;
	parent[root]=nullptr;
	setParent(parent, root);
	dispTreeTopToBottom(parent, node);
}

bool findAncestors2(struct Node* root, struct Node* node){
	if(root==nullptr) return false;
	if(root==node) return true;
	bool left=findAncestors2(root->left, node);
	bool right=false;
	if(!left){
		right=findAncestors2(root->right, node);
	}
	if(left||right){
		cout<<root->val<<" ";
	}
	return left||right;
}

int main(){
	struct Node* head=createNewNode(0);
	head->left=createNewNode(1);
	head->right=createNewNode(2);
	head->left->left=createNewNode(3);
	head->left->right=createNewNode(4);
	head->right->left=createNewNode(5);
	head->right->right=createNewNode(6);
	findAncestors1(head, head->left->right);
	cout<<"***---***\n";
	findAncestors2(head, head->left->right);
}