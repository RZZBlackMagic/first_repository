#ifndef HOMEWORK6-7_H_INCLUDED
#define HOMEWORK6-7_H_INCLUDED

#include <iostream>

using namespace std;

class Base{
public:
    double r;
    virtual void area()=0;
    virtual void zhou()=0;
    Base(){};
    Base(double r){
        this->r=r;
    }
};

class circle:public Base{
public:
    circle(double r){
        this->r = r;
    }
    void area(){
        cout<<"����Բ�����"<<endl;
    }
    void zhou(){
        cout<<"����Բ���ܳ�"<<endl;
    }
};

class inner_area:public Base{
public:
    inner_area(double r){
        this->r=r;
    }
    void area(){
        cout<<"�����ڽ����������"<<endl;
    }
    void zhou(){
        cout<<"�����ڽ��������ܳ�"<<endl;
    }
};

class outter_area:public Base{
public:
    outter_area(double r){
        this->r = r;
    }
    void area(){
        cout<<"����������������"<<endl;
    }
    void zhou(){
        cout<<"��������������ܳ�"<<endl;
    }
};
#endif // HOMEWORK6-7_H_INCLUDED
