#include <stdio.h>
#include <stdlib.h>
#include "cal_address_h.h"
//��������
//int gAll =1 ;
int main()
{


    int a = 13;
    printf("a�ĵ�ַΪ��%d\n",&a);
    gAll = 1;
    int *p = f(a,gAll);
    printf("*p=%d\n",*p);
    g();
    //printf("*P=%d\n",*p);
    printf("���������%d\n",2);
    return 0;
}

