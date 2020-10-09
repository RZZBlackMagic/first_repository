#ifndef MAKEDRINK_H_INCLUDED
#define MAKEDRINK_H_INCLUDED

#include <iostream>

using namespace std;

class Drink{
public:
    //加点东西
    virtual void PutSometing() = 0;
    //煮水
    virtual void Boil() = 0;
    //冲泡
    virtual void Brew() = 0;
    //导入杯中
    virtual void PourInCup() = 0;
    void makeDrink(){
        Boil();
        Brew();
        PourInCup();
        PutSometing();
    }
};

class Coffee :public Drink{
public:
    void Boil(){
        cout<<"咖啡煮水"<<endl;
    }
    void Brew(){
        cout<<"咖啡冲泡"<<endl;
    }
    void PourInCup(){
        cout<<"咖啡导入杯中"<<endl;
    }
    void PutSometing(){
        cout<<"咖啡加点东西"<<endl;
    }
};
#endif // MAKEDRINK_H_INCLUDED
