#include <stdio.h>
#include <stdlib.h>
struct student * create_Node();
struct student *create_link111(int length);
void show_link(struct student * head);
void avg();
struct student * reverse_link(struct student * head);
  struct student
  {
      int data;
      struct student *next;
  };

 int iCount=0;                                                        //����ȫ�ֱ���������볤��

 struct student *Create()
 {
     struct student *pHead = NULL;
     struct student *pNew,*pEnd;
     iCount = 0;
     pEnd = pNew = (struct student*)malloc(sizeof(struct student));
     printf("����������:");
     scanf("%d",&pNew->data);
     while(pNew->data!=0)
     {
         iCount++;
         if(iCount == 1)                                                 //�ӱ���if��俪ʼ��Ҫ��ע��ָ��Ľ�����Ŷ���Ƚ����״�
         {
             pNew->next = NULL;
             pEnd = pNew;
             pHead = pNew;
         }
         else
         {
             pNew->next = NULL;
             pEnd->next = pNew;
             pEnd = pNew;
         }
         pNew = (struct student*)malloc(sizeof(struct student));
         printf("����������:");
         scanf("%d",&pNew->data);
     }
     free(pNew);
     return pHead;
 }

 struct student *reverse(struct student *pHead)                             //�������ú���
 {
     struct student *p,*q,*t;                                              //pΪǰ��ָ�룬qΪ����ָ�룬tΪ����ָ��
     q = pHead;
     p = (q->next);
     q->next = NULL;
     while(t!=NULL)
     {
         t = p->next;
         p->next = q;
         q = p;
         if(t!=NULL) p = t;
         else;
     }
     return (p);
 }

 void showlist(struct student *pHead)                                //ָ���������
 {
     struct student *temp;
     temp = pHead;

     while(temp)
     {
         printf(" %d ",temp->data);
         temp = temp->next;
     }
     printf("\n");
 }

 int main()
 {
     //struct student *first;

     /*first = Create();
     printf("��������ǰ������:");
     showlist(first);

     first = reverse(first);

     printf("�������ú������:");
     showlist(first);

     struct student * head = create_link111(10);
     show_link(head);
     struct student * s = reverse_link(head);
     show_link(s);*/
     avg();
     return 0;
 }

struct student * create_Node(){
    struct student * p = (struct student *) malloc(sizeof(struct student));
    if(p==NULL){
        exit(0);
    }
    int a = rand()%100;
    p->data=a;
    //printf("222\n");
    return p;
}

struct student *create_link111(int length){
    struct student *head = create_Node();
    struct student * s,*p;
    s = head ;
    while(length>0){
        p = create_Node();
        s->next=p;
        s=s->next;
        length--;
    }
    s->next=NULL;
    return head;
}

void show_link(struct student * head){
    struct student * p = NULL;
    p = head;
    while(p!=NULL){
        printf("%d   ",p->data);
        p=p->next;
    }
}

struct student * reverse_link(struct student * head){
    struct student * p = NULL;
    struct student * s = NULL;
    while(head!=NULL){
        p = head ;
        head = head->next;
        p->next=s;
        s=p;
    }
    return p;
}



void avg(){
  int n = 0;
  scanf("%d",&n);
  int i=0;
  double array[n];
  double sum = 0;
  for(i=0;i<n;i++){
    scanf("%lf",&array[i]);
  }
  for(i=0;i<n;i++){
    printf("%f ",array[i]);
  }
  for(i=0;i<n;i++){
    sum = sum + array[i];
  }
  double avg = sum/n;
  printf("%.2f",avg);
}
