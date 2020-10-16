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
//�ӷ�����
people operator+(people &p1,people &p2){
    people * p3 =new people(p1.age+p2.age,p1.score+p2.score);
    return (*p3);
}
//��������
people operator-(people &p1,people &p2){
    people * p3 = new people(p2.age-p1.age,p2.score-p1.score);
    return (*p3);
}
//��������(δ���)
ostream& operator<<(ostream& cout,people p){
    //cout<<1213243<<endl;
    cout<<"P_age="<<p.age<<"  "<<"p_score="<<p.score<<endl;
    return cout;
}
//=����
bool operator==(people& p1,people& p2){
    if(p1.age==p2.age&&p1.score==p2.score)
        return true;
    return false;
}
//!=����
bool operator!=(people& p1,people& p2){
    if(p1.age==p2.age&&p1.score==p2.score)
        return false;
    return true;
}

#endif // OPERATOR_H_INCLUDED
