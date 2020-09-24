#ifndef PEOPLE_H_INCLUDED
#define PEOPLE_H_INCLUDED
#include <iostream>
#include <string.h>

using namespace std;

class Date{
public:
    class birthday;
    birthday *b;
    Date(birthday *b){
        this->b=b;
    }
};


class Date::birthday{
public:
    int year;
    int month;
    int day;
    birthday(){};
    birthday(int year,int month,int day)
    {
        this->day=day;
        this->month=month;
        this->year=year;
    }
    void print_birth()
    {
        cout<< (this->year);
        cout<< "-";
        cout<< (this->month);
        cout << "-";
        cout<< (this->day) <<endl;
    }
};




class people{
public:
    int number;
    char sex;
    class Date::birthday b;
    string id;
    people(){};
    people(int number,char sex, Date::birthday  b,string id){
        this->id=id;
        this->number=number;
        this->sex=sex;
        this->b=b;
    }
    people * setInfo(int number,char sex,Date::birthday & b,string id)
    {
        people *p = new people(number,sex,b,id);
        cout<<">>>>"<<(*p).id<<endl;
        return p;
    }
    void showInfo()
    {
        Date::birthday p = this->b;
        cout<<"学号："<<this->number<<endl;
        cout<<"id:"<<this->id<<endl;
        cout<<"性别："<<this->sex<<endl;
        cout<<"生日：";
        p.print_birth();
    }
};


#endif // PEOPLE_H_INCLUDED
