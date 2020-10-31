#include <stdio.h>
#include <stdlib.h>

struct Node {
    Node left;
    Node right;
    int val;
};
typedef struct {
    int val;
    struct Node * next;
}QNode;
typedef struct {
    QNode *front ,* rear;
}linkNode;
int main()
{

    printf("Hello world!\n");
    return 0;
}
void init_Queue(linkNode * l){
    l->front=l->rear=(linkNode *)malloc(sizeof(linkNode));
    l->front->next=NULL;
}
void En_Queue(linkNode * l){
    int a ;
    scanf("%d",&a);
    linkNode * Node = (linkNode *)malloc(sizeof(linkNode));
    Node->val=a;
    l->rear->next=Node;
    l->rear=Node;
}
int De_Queue(linkNode * l){
    if(l->front->next==NULL){
        return 0;
    }
    linkNode * Node = l->front->next;
    int a = Node->val;
    l->front->next = Node->next;
    free(Node);
    return a;
}
void show(struct Node * root,linkNode * Q){
    init_Queue(Q);
    if(root==NULL){
        return ;
    }
    int nextLength=1;
    while(nextLength!=0){

    }
}
