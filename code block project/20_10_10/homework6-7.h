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
        cout<<"计算圆的面积"<<endl;
    }
    void zhou(){
        cout<<"计算圆的周长"<<endl;
    }
};

class inner_area:public Base{
public:
    inner_area(double r){
        this->r=r;
    }
    void area(){
        cout<<"计算内接正方形面积"<<endl;
    }
    void zhou(){
        cout<<"计算内接正方形周长"<<endl;
    }
};

class outter_area:public Base{
public:
    outter_area(double r){
        this->r = r;
    }
    void area(){
        cout<<"计算外界正方形面积"<<endl;
    }
    void zhou(){
        cout<<"计算外接正方形周长"<<endl;
    }
};
#endif // HOMEWORK6-7_H_INCLUDED
