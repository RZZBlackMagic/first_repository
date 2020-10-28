#ifndef STUDENT_H_INCLUDED
#define STUDENT_H_INCLUDED
#include "ideatity.h"
#include <iostream>
#include "string"
using namespace std;

class student:public identity
{
public:
    int id;

    student(){}

    student(int id,string name,string password){
        this->m_Name = name;
        this->m_Password = password;
    }
    //菜单界面
    void operMenu(){

    }
    //申请预约
    void applyOrder(){

    }
    //查看我的预约
    void showAMyOrder(){

    }
    //查看所有预约
    void showAllOrder(){

    }
    //取消预约
    void cancelOrder(){

    }

};
#endif // STUDENT_H_INCLUDED
