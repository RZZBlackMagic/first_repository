#ifndef PRIVATE_VIRTUAL_H_INCLUDED
#define PRIVATE_VIRTUAL_H_INCLUDED
#include <iostream>

using namespace std;

class Base
{
public:
    Base(){
        cout<<"Base ����"<<endl;
    }
    virtual ~Base(){
        cout<<"Base ����"<<endl;
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
        cout<<"D�Ĺ���"<<endl;
    }
    ~D(){
        cout<<"D����������"<<endl;
    }
     void fun2()
    {
        cout<<"�����private_virtual"<<endl;
    }
};


#endif // PRIVATE_VIRTUAL_H_INCLUDED
