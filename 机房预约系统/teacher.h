#ifndef TEACHER_H_INCLUDED
#define TEACHER_H_INCLUDED

#include "ideatity.h"
#include <iostream>
#include "string"
using namespace std;

class teacher:public identity
{
public:
    int empId;

    teacher(){}

    teacher(int empId,string name,string password){
        this->m_Name = name;
        this->m_Password = password;
        this->empId = empId;
    }
    //�˵�����
    virtual void operMenu(){

    }
    //�鿴����ԤԼ
    void showAllOrder(){

    }
    //���ԤԼ
    void validOrder(){

    }

};

#endif // TEACHER_H_INCLUDED
