#ifndef OPERATOR_H_INCLUDED
#define OPERATOR_H_INCLUDED

//#include "cstring"
#include <iostream>
using namespace std;

class people
{
public:
    int age;
    int score;
    people(){}
    people(int age,int score)
    {
        this->age = age;
        this->score = score;
    }
    ~people(){

    }
    friend people operator+(people &p1,people &p2);
    friend people operator-(people &p1,people &p2);
    people operator++(){
        age+=1;
        score+=1;
        return *this;
    }
    people operator++(int){
        people temp = *this;
        this->age++;
        this->score++;
        return temp;
    }
    people& operator=(people& p1){
        this->age = p1.age;
        this->score = p1.score;
        return *this;
    }
};
//加法重载
people operator+(people &p1,people &p2){
    people * p3 =new people(p1.age+p2.age,p1.score+p2.score);
    return (*p3);
}
//减法重载
people operator-(people &p1,people &p2){
    people * p3 = new people(p2.age-p1.age,p2.score-p1.score);
    return (*p3);
}
//左移重载(未完成)
ostream& operator<<(ostream& cout,people p){
    //cout<<1213243<<endl;
    cout<<"P_age="<<p.age<<"  "<<"p_score="<<p.score<<endl;
    return cout;
}
//=重载
bool operator==(people& p1,people& p2){
    if(p1.age==p2.age&&p1.score==p2.score)
        return true;
    return false;
}
//!=重载
bool operator!=(people& p1,people& p2){
    if(p1.age==p2.age&&p1.score==p2.score)
        return false;
    return true;
}

#endif // OPERATOR_H_INCLUDED
