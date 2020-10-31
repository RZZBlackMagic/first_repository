#ifndef CONSTRUCT_VIRTUAL_H_INCLUDED
#define CONSTRUCT_VIRTUAL_H_INCLUDED

#include <iostream>

using namespace std;

class Transaction
{
public:
    Transaction()
    {
        logTransaction();
    }
    virtual void logTransaction(){
        cout<<"这是基类的虚函数"<<endl;
    };
};

class BuyTransaction:public Transaction
{
public:
    int buyNum;
    BuyTransaction(){
        cout<<"这是BuyTransaction的虚函数"<<endl;
    }
    virtual void logTransaction()
    {
        cout<<"this is a BuylogTransaction"<<endl;
    }
};

class SellTransaction:public Transaction{
public:
    int sellNum;
    SellTransaction(){
        cout<<"这是SellTransaction的虚函数"<<endl;
    }
    virtual void logTransaction()
    {
        cout<<"vdsdvv"<<endl;
    }
};
#endif // CONSTRUCT_VIRTUAL_H_INCLUDED
