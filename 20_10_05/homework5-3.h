#ifndef HOMEWORK5-3_H_INCLUDED
#define HOMEWORK5-3_H_INCLUDED

#include <iostream>
#include "string"
using namespace std;

class A
{
public:
    virtual void act1(){
        cout<<"A called;"<<endl;
    }
    void act2(){
        act1();
    }
};

class B:public A
{
public:
    void act1(){
        cout<<"B called;"<<endl;
    }
};


#endif // HOMEWORK5-3_H_INCLUDED
