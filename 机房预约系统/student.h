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
    //�˵�����
    void operMenu(){

    }
    //����ԤԼ
    void applyOrder(){

    }
    //�鿴�ҵ�ԤԼ
    void showAMyOrder(){

    }
    //�鿴����ԤԼ
    void showAllOrder(){

    }
    //ȡ��ԤԼ
    void cancelOrder(){

    }

};
#endif // STUDENT_H_INCLUDED
