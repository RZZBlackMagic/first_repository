#ifndef HOMEWORK6-5_H_INCLUDED
#define HOMEWORK6-5_H_INCLUDED
#include <iostream>
#include "string"
using namespace std;

class BC
{
public:
    virtual void sayhi(){
        cout<<"just hi"<<endl;
    }
    void run(){cout<<"Base::run "<<endl;}
};

class DC1:public BC
{
public:
    virtual void sayhi(){
        cout<<"tinker."<<endl;
    }
    void run(){
        cout<<"in tinker::run"<<endl;
    }
};

class DC2:public BC
{

public:
    void sayhi(){
        cout<<"Tailor"<<endl;
    }
    void run(){
        cout<<"in tailor::run"<<endl;
    }
};
#endif // HOMEWORK6-5_H_INCLUDED
