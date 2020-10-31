#include <stdio.h>
#include <stdlib.h>

int ElemType;
typedef struct(){
  ElemType elem;
  int length;//当前长度
  int listSize;
}SqList;


int initList(SqlList &L,int length){
   L.elem = (ElemType *)malloc(length*sizeof(Elemtype));
   if(!L.elem){
      return 0;
   }
   L.length = 0;
   L.listSize = length;
   return 1;
}
