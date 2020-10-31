#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <conio.h>
int main()
{
    //函数声明
    float *area(float a1,float p ,float a[3]);
    float f(float x);
    //变量初始化
    float ar,fr;
    float a1 = 10, p = 0.01, e = 0.000001;
    float pa[3];
    area(a1,p,pa);
    a1 = pa[0];
    float a2 = pa[1];
    float a3 = pa[2];
    float f1 = f(a1);
    float f2 = f(a2);
    float f3 = f(a3);
    do{
        ar = ((a3*a3-a2*a2)*f1+(a1*a1-a3*a3)*f2+(a2*a2-a1*a1)*f3);
        ar = ar/2/((a3-a2)*f1+(a1-a3)*f2+(a2-a1)*f3);
        fr = f(ar);
        if(ar>a2){
            if(fr>f2){
                a3 = ar;
                f3 = fr;
            }else if(fr<f2){
                a1 = a2;
                f1 = f2;
                a2 = ar;
                f2 = fr;
            }else{
                a3 = ar;
                a1 = a2;
                a2 = (a1+a3)/2;
                f1 = f2;
                f3 = fr;
                f2 = f(a2);
            }
        }else if(ar<a2){
            if(fr>f2){
                a1 = ar;
                f1 = fr;
            }else if(fr<f2){
                a3 = a2 ;
                f3 = f2;
                a2 = ar;
                f2 = fr;
            }else{
                a1 = ar;
                a3 = a2;
                a2 = (a1+a3)/2;
                f1 = fr;
                f3 = f2;
                f2 = f(a2);
            }
        }
        if(fabs(a1-a3)<=e)
            break;
    }while(1);
    if(f2<fr){
        ar = a2;
        fr = f2;
    }
    printf("\nx=%f\nf(x*)=%f",ar,fr);
    return 0;

}
float * area(float a1, float p ,float a[3]){
    float f(float x);
    float a2,f2,a3,f3,temp;
    float acc = 0.00001;
    float f1 = f(a1);
    float storep = p;
    while(1){
        a2 = a1 + p;
        f2 = f(a2);
        if(f2>=f1){
            if(fabs(f2-f1)<acc){
                p = p/2;
            }else{
                p = p;
            }
        }else{
            break;
        }
    }
    while(1){
        a3 = a2 + p;
        f3 = f(a3);
        if(f2<f3){
            break;
        }
        p = 2*p;
        a1 = a2;
        f1 =f2;
        a2 =a3;
        f2 = f3;
    }
    if(a1 > a3){
        temp =a1;
        a1 =a3;
        a3 = temp;
    }
    a[0] = a1;
    a[1] =a2;
    a[2] = a3;
    return a;
}

float f (float x){
    float y = pow(fabs(x-1),1.5)+pow(fabs(x-1),2.7);
    return y;
}

