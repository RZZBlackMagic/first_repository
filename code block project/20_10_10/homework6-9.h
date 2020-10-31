#ifndef HOMEWORK6-9_H_INCLUDED
#define HOMEWORK6-9_H_INCLUDED

#include <iostream>

using namespace std;

class Base{
public:
    string name;
    int year;
    float score;
    Base(){};
    Base(string name,int year,float score){
        this->name = name;
        this->year = year;
        this->score = score;
    }
    virtual void display(){
        cout<<"������"<<name<<"���䣺"<<year<<"������"<<score<<endl;
    }
};

class FirstDer:public Base{
private:
    string addr;
public:
    FirstDer(string name,int year,float score,string addr){
        this->name = name;
        this->year = year;
        this->score = score;
        this->addr = addr;
    }
    void display(){
        cout<<"������"<<name<<"���䣺"<<year<<"������"<<score<<"��ַ��"<<addr<<endl;
    }
};

class SecondDer:public Base{
private:
    string tel;
public:
    SecondDer(string name,int year,float score,string tel){
        this->name = name;
        this->year = year;
        this->score = score;
        this->tel = tel;
    }
    void display(){
        cout<<"������"<<name<<"���䣺"<<year<<"������"<<score<<"�绰��"<<tel<<endl;
    }
};
#endif // HOMEWORK6-9_H_INCLUDED
