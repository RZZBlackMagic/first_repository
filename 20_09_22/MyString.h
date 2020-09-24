#ifndef MYSTRING_H_INCLUDED
#define MYSTRING_H_INCLUDED
#include <iostream>
#include <string.h>
using namespace std;

class MyString{
public:
    string s;
    void display(){
        if(typeid(this).name()=="int"){
            cout<<"int"<<endl;
        }
    }
};
void m_main(){
    MyString * ms = new MyString();
    ms.display();
}

#endif // MYSTRING_H_INCLUDED
