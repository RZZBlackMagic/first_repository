#ifndef HOMEWORK_DATE_H_INCLUDED
#define HOMEWORK_DATE_H_INCLUDED
#include <iostream>

using namespace std;

class Date{
public:
    int year;
    int month;
    int day;
    Date(){

    }
    Date(int year,int month,int day){
        this->year=year;
        this->month=month;
        this->day=day;
    }
    void print(){
        cout<<"现在是"<<year<<"年"<<month<<"月"<<day<<"日"<<endl;
    }
    Date * add(){
        day++;
        return this;
    }
    Date * setDate(int year,int month,int day){
        Date * d = new Date(year,month,day);
        return d;
    }
};
void date(){
    Date * d = new Date(2020,9,22);
    (*d).print();
    Date * dd;
    (dd) = (*dd).setDate(2222,4,56);
    (*dd).print();
}


#endif // HOMEWORK_DATE_H_INCLUDED
