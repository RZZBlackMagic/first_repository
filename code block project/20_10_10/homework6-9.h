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
        cout<<"姓名："<<name<<"年龄："<<year<<"分数："<<score<<endl;
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
        cout<<"姓名："<<name<<"年龄："<<year<<"分数："<<score<<"地址："<<addr<<endl;
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
        cout<<"姓名："<<name<<"年龄："<<year<<"分数："<<score<<"电话："<<tel<<endl;
    }
};
#endif // HOMEWORK6-9_H_INCLUDED
