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
    //菜单界面
    virtual void operMenu(){

    }
    //查看所有预约
    void showAllOrder(){

    }
    //审核预约
    void validOrder(){

    }

};

#endif // TEACHER_H_INCLUDED
