#ifndef PRIVATE_VIRTUAL_H_INCLUDED
#define PRIVATE_VIRTUAL_H_INCLUDED
#include <iostream>

using namespace std;

class Base
{
public:
    Base(){
        cout<<"Base 构造"<<endl;
    }
    virtual ~Base(){
        cout<<"Base 析构"<<endl;
    }
    void fun1(){fun2();}
     void fun2(){
        cout<<"private_virtual"<<endl;
    }
};

class D : public Base
{
public  :
    D(){
        cout<<"D的构造"<<endl;
    }
    ~D(){
        cout<<"D的析构函数"<<endl;
    }
     void fun2()
    {
        cout<<"子类的private_virtual"<<endl;
    }
};


#endif // PRIVATE_VIRTUAL_H_INCLUDED
