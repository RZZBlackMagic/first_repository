#ifndef IDEATITY_H_INCLUDED
#define IDEATITY_H_INCLUDED

#include <iostream>
#include "string"
using namespace std;

class identity{
public:
    //子菜单操作
    virtual void operMenu() = 0;
    string m_Name;//用户名
    string m_Password;//密码
};

#endif // IDEATITY_H_INCLUDED
