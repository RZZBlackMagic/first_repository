#ifndef IDEATITY_H_INCLUDED
#define IDEATITY_H_INCLUDED

#include <iostream>
#include "string"
using namespace std;

class identity{
public:
    //�Ӳ˵�����
    virtual void operMenu() = 0;
    string m_Name;//�û���
    string m_Password;//����
};

#endif // IDEATITY_H_INCLUDED
