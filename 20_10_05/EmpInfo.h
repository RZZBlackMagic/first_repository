#ifndef EMPINFO_H_INCLUDED
#define EMPINFO_H_INCLUDED

#include <iostream>
#include "string"
using namespace std;

class Employee
{
public:
    string name;
    int age;
    int job_time;
    int mNum;
    Employee(){};
    Employee(string name,int age,int job_time,int mNum){
        this->name=name;
        this->age=age;
        this->job_time=job_time;
        this->mNum=mNum;
    }
    virtual void printOn(){
        if(this==NULL){
            cout<<"����Ա�Ѿ�����"<<endl;
        }
        cout<<"����    "<<"����    "<<"����ʱ��   "<<"����   "<<endl;
        cout<<this->name<<"    "<<this->age<<"    "<<this->job_time<<"   "<<this->mNum<<endl;
    }
    virtual void retire(){
        if(this->age>55){
            ~Employee(){
                cout<<"����Ա�Ѿ�����"<<endl;
            }
        }
    }
};

class Manager:public Employee
{
public:
    string level;
    Manager(){};
    Manager(string name,int age,int job_time,int mNum,string level){
        this->name=name;
        this->age=age;
        this->job_time=job_time;
        this->mNum=mNum;
        this->level=level;
    }
    void printOn(){
        if(this==nullptr){
            cout<<"����Ա�Ѿ�����"<<endl;
        }
         cout<<"����    "<<"����    "<<"����ʱ��   "<<"����   ����  "<<endl;
        cout<<this->name<<"    "<<this->age<<"    "<<this->job_time<<"   "<<this->mNum<<"    "<<this->level<<endl;
    }
    void retire(){
         if(this->age>60){
             ~Manager(){
                  cout<<"����Ա�Ѿ�����"<<endl;
             }
        }
    }
};
#endif // EMPINFO_H_INCLUDED
