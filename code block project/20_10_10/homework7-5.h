#ifndef HOMEWORK7-5_H_INCLUDED
#define HOMEWORK7-5_H_INCLUDED

#include "cstring"
#include <iostream>
using namespace std;

template<class T>
class Sample
{
    T n;
public:
    Sample(T i)
    {
        n = i;
    }
    void operator++();
    void disp()
    {
        cout<<"n="<<n<<endl;
    }
};

template<class T>
void Sample<T>::operator++()
{
    n+=1;
}



#endif // HOMEWORK7-5_H_INCLUDED
