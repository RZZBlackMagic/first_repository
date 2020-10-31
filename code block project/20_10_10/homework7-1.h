#ifndef HOMEWORK7-1_H_INCLUDED
#define HOMEWORK7-1_H_INCLUDED
#include "cstring"
#include <iostream>
using namespace std;
//求几个数的最小值
template<class T>
T T_min(const T t1,const T t2,const T t3){
        T t_min = t1;
        if(t2<t_min){
            t_min = t2;
        }
        if(t3<t_min){
            t_min = t3;
        }
        return t_min;
    }
//求几个数的最大值，包括字符串
template<class T>
int T_max(const T t1,const T t2){
    T T_max = t1;
    if(t2>T_max){
        T_max = t2;
    }
    return T_max;
}
template <>
int T_max<const char*>(const char* t1,const char* t2){
    return strcmp(t1,t2);
}
template<class T,int T1=0>
class c{};
template <class e>class List;
#endif // HOMEWORK7-1_H_INCLUDED
