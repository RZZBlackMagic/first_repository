#ifndef HOMEWORK5-2_H_INCLUDED
#define HOMEWORK5-2_H_INCLUDED

#include <iostream>
#include "string"
using namespace std;
class Base
{
protected:
    int iBody;
public:
    virtual void printOn(){}
    Base(int i=0):iBody(i){}
};

class Sub1:public Base
{
public:
    int i;
    char *s;
    Sub1(int i,char * s){
        this->i=i;
        this->s=s;
    }
    void printOn(){
        string ss = s;
        cout<<i<<":"<<ss<<endl;
    }
};

class Sub2:public Base
{
public :
    int i;
    short s;
    Sub2(int i,short s){
        this->i=i;
        this->s=s;
    }
    void printOn(){
        cout<<i<<" and "<<s<<endl;
    }
};

#endif // HOMEWORK5-2_H_INCLUDED
