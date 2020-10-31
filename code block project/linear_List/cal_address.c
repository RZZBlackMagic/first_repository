#include "cal_address_h.h"
int* f(a, b){
    int i = 12;
    //printf("i的地址为：%d\n",&i);
    int* j = &i;
    return j;
}
void g(void){
    int k = 24;
    //printf("k的地址为：%d\n",&k);
    printf("k=%d\n",k);
}
