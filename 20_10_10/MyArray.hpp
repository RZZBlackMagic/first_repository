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
    //��������
    //perate=
    //�����±�ķ������������е�Ԫ��
    //β�巨
    //βɾ��
    //��ȡ��������
    //��ȡ�����С
    //����
};

#endif // MYARRAY_H_INCLUDED
