#ifndef DECORATOR_H_INCLUDED
#define DECORATOR_H_INCLUDED
#include <iostream>

using namespace std;

class coffee
{
public:
    int price = 10;
    virtual int getPrice(){
        return price;
    };
    virtual string getName(){
        return "ԭζ����";
    };
};

class decorator:public coffee{
public:
    coffee c;
    decorator(coffee c){
        this->c = c;
    };
};

class milkDecorator:public decorator
{
public:
    milkDecorator(coffee c):decorator(c)
    {

    }
    int getPrice(){
        return c.price+10;
    }
    string getName(){
        return "��ţ�̺�";
    }
};
#endif // DECORATOR_H_INCLUDED
