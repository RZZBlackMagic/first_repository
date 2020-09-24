#ifndef TDATE_H_INCLUDED
#define TDATE_H_INCLUDED
#include <iostream>

using namespace std;

class TDate{
private:
    int day;
    int month;
    int year;
public:
    TDate(){};
    TDate(int year,int month,int day=10){
        this->day=day;
        this->month=month;
        this->year=year;
    }
    TDate(int day){
        this->day=day;
    }

    TDate * setDate(int year,int month,int day){
        this->day=day;
        this->year=year;
        this->month=month;
    }
    friend void print(TDate &t);
};

void print(TDate &t){
    cout<<"今天是"<<t.year<<"年"<<t.month<<"月"<<t.day<<"日"<<endl;
}


void m_main(){
    TDate *t = new TDate(2020,10);
    TDate * tt = (*t).setDate(1999,9,12);
    print(*tt);
}

#endif // TDATE_H_INCLUDED
