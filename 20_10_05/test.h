#ifndef TEST_H_INCLUDED
#define TEST_H_INCLUDED

#include <iostream>
using namespace std;

class A
{
public:
    virtual void act1()
    {
        cout<<"A��act1����"<<endl;
    }
    void act2()
    {
        act1();
    }
};

class B:public A
{
public:
    void act1(){
            cout<<"B��act1"<<endl;
    }
};

#endif // TEST_H_INCLUDED
