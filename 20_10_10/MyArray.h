#ifndef MYARRAY_H_INCLUDED
#define MYARRAY_H_INCLUDED

#include "cstring"
#include <iostream>
using namespace std;

template<class T>
class MyArray
{
private:
    T * pAddress;
    int m_Capacity;
    int m_size;
public:
    MyArray(int capacity)
    {
        this->m_Capacity=capacity;
        this->m_size = 0;
        this->pAddress = new T[this->m_Capacity];
    }
    //拷贝函数
    //perate=
    //利用下标的放肆访问数组中的元素
    //尾插法
    //尾删法
    //获取数组容量
    //获取数组大小
    //析构
};

#endif // MYARRAY_H_INCLUDED
