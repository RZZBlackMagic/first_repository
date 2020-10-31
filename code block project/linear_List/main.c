#include <stdio.h>
#include <stdlib.h>
#include "cal_address_h.h"
//函数声明
//int gAll =1 ;
int main()
{


    int a = 13;
    printf("a的地址为：%d\n",&a);
    gAll = 1;
    int *p = f(a,gAll);
    printf("*p=%d\n",*p);
    g();
    //printf("*P=%d\n",*p);
    printf("测试输出：%d\n",2);
    return 0;
}

