#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include "3.17.c"
#define N 20
typedef int SElemType;
typedef struct{
   SElemType stack[N];
   int top[2];
}TwsS;

int main()
{
    printf("dasdasa");

    //��ʼ��
     TwsS s;
    initStack(&s);
    printf("��ʼ����ɡ�����\n");
    //��ջ
    int pushResult = pushStack(&s,1,5);
    SElemType pop ;
    SElemType popResult =  popStack(&s,1,pop);
    printf("\telem:%d\n\tindex:%d\n",s.stack[N-1],s.top[1]);
    if(pushResult==0){
           printf("��ջʧ��\n");
    }else{
           printf("��ջ�ɹ�\n");
    }

    printf("��ջԪ�أ�%d",popResult);


}

void initStack(TwsS *ts){
    (*ts).top[0]=0;
    (*ts).top[1]=N-1;
}

//����ֵΪ0����ջʧ��
//����ֵΪ1����ջ�ɹ�
//flagΪ0����߽���flagΪ1���ұ߽�
int pushStack(TwsS *ts,int flag,SElemType elem){
    if(((*ts).top[0]+1)==((*ts).top[1])){
        //ջ��
        return 0;
    }
    if(flag==0){
        //����߽���
        (*ts).stack[(*ts).top[0]]=elem;
        (*ts).top[0]++;
        return 1;
    }else if(flag==1){
         //���ұ߽���
        (*ts).stack[(*ts).top[1]]=elem;
        (*ts).top[1]--;
        return 1;
    }else{
         return 0;
    }

}
//����ֵΪ0 ��ջʧ��
//����ֵΪ1 ��ջ�ɹ�
SElemType popStack(TwsS *ts,int flag,SElemType elem){
    //���
    if(flag==0){
        //�ж�����Ƿ�Ϊ��
        if((*ts).top[0]==0){
            //��
            return 0;
        }else{
            //�ǿ�
            (*ts).top[0]--;
            elem = (*ts).stack[(*ts).top[0]];
            return elem;
        }
    }else if(flag==1){
        //�ж��ұ��Ƿ�Ϊ��
        if((*ts).top[1]==N-1){
            //kong
            return 0;
        }else{
            (*ts).top[1]++;
            elem = (*ts).stack[(*ts).top[1]];
            return elem;
        }
    }else{
        return 0;
    }
}
    /*
    int i=0;
    int *stack;
    stack = initStack(10);
    for(i=0;i<10;i++){
        stack[i] = 1;
    }

    int x=1,y=2;
    int res = swap(x,y);
    //printf("main:\nx=%d;y=%d\n",x,y);
    //printf("swap result : %d",res);
    res = sum(x,y);
    printf("sum:%d",res);

    char stack[] = "12345";
    char sumRes = arraySum(stack);
    printf("array sum : %s",sumRes);
    int a =3;
    int b = 5;
    printf("before swap : a= %d;b=%d\n",a,b);
    int *point_a = &a;
    int *point_b = &b;
    swapPoint(point_a,point_b);
    printf("after swap : a= %d;b=%d\n",a,b);
    printf("point_a��ַ��ֵ��%d",*point_a);
    return 0;*/

/*
void swapPoint(int *point_a,int *point_b){
     int flag ;
     flag = *point_a;
     *point_a = *point_b;
     *point_b = flag;
}
void arraySum(char arr[]){
    int i=0;
    char sum[100] ="";
    while(arr[i]!='\0'){
        printf("array element : %c\n" ,arr[i]);
        //strcat(sum,arr);
        i++;
        printf("ִ�д�����%d",i);
    }
    printf("exit");
    printf("ArrayResult: %s",sum);
}
int swap(int x,int y){
  int t;
  t=x;
  x=y;
  y=t;
  printf("x=%d;y=%d",x,y);
  return x;
}

int sum(int a ,int b){
   return (a+b);
}
*/



