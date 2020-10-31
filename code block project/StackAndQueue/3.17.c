#include<stdio.h>
#include<stdlib.h>
#include <string.h>

#define INIT_LENGTH 20
typedef int ElemType;
typedef struct {
    ElemType *e;
    int index;
    int listSize;
}SqlList;
int i ;
void port(long a){
    if(a<10000)
        return ;
    port(a/10);
    printf("%ld",a%10);
}

int main(){
    char s[3] = {'a','s','d'};
    printf("%d",sizeof(s));
    /*
    int i=2,j=3,y,k;
    k=i+j;
    {
        int k=8;
        printf("%d\n",&k);
    }
    printf("%d\n",&k);
    */
    //long a = 12345678;
    //port(a);
    //float a = 28.657;
    //printf("%.2f",a);
/*
        char *p,s[81] ="GOOD9day";
        for(p=s;*p;p++){
            if(*p>='a'&&*p<='z'){
                *p-=32;
            }else if(*p>='A'&&*p<='Z'){
                *p+=32;
            }
        }
        for(--p;p>=s;p--){
            putchar(*p);
        }
        */
     //printf("挥洒十八斯柯达");
    //int main# = 1;
    //int A$ = 0;
    //int i = 0;
    //printf("%d",main#);
    /*
    int i =0;
    SqlList s;
    int init = initSqlList(&s);
    printf("初始化结果：%d\n",init);
    for(i=0;i<5;i++){
        int addElem = addElemForSqlList(&s,i);
        printf("添加元素结果：%d\n",addElem);
    }

    int resultArr;
    resultArr = selectElemFromLIst(&s);
    printf("resultARR[0]:%d\n",resultArr);
*/
}
int initSqlList(SqlList *s){
    (*s).e = (ElemType *)malloc(INIT_LENGTH*sizeof(ElemType));
    if(!(*s).e){
        return 0;
    }
    (*s).index=0;
    (*s).listSize=INIT_LENGTH;
    return 1;
}
int addElemForSqlList(SqlList *s,int x){
    printf("当前线性表下标：%d\n",(*s).index);
    printf("线性表最大下标：%d\n",(*s).listSize-1);
    if((*s).index==(((*s).listSize)-1)){
        //满
        return 0;
    }else{
        ElemType *p;
        p = (((*s).e+(*s).index));
        (*s).index++;
        *p = x;
        int falg = (*s).index;
        falg--;
        printf("插入后查看插入位置的信息：%d\n",(*s).e[falg]);
        return 1;
    }

}
int selectElemFromLIst(SqlList *s){
    int resArr[(*s).index];
    int res;
    int i;
    for(i=0;i<(*s).index;i++){
        res = (*s).e[2];
    }
    return res;
}
