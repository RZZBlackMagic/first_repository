#ifndef MAKEDRINK_H_INCLUDED
#define MAKEDRINK_H_INCLUDED

#include <iostream>

using namespace std;

class Drink{
public:
    //�ӵ㶫��
    virtual void PutSometing() = 0;
    //��ˮ
    virtual void Boil() = 0;
    //����
    virtual void Brew() = 0;
    //���뱭��
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
        cout<<"������ˮ"<<endl;
    }
    void Brew(){
        cout<<"���ȳ���"<<endl;
    }
    void PourInCup(){
        cout<<"���ȵ��뱭��"<<endl;
    }
    void PutSometing(){
        cout<<"���ȼӵ㶫��"<<endl;
    }
};
#endif // MAKEDRINK_H_INCLUDED
