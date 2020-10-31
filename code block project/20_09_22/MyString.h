#ifndef MYSTRING_H_INCLUDED
#define MYSTRING_H_INCLUDED
#include <iostream>
#include <string.h>
using namespace std;

class MyString{
public:
    string s;
    int n;
    void MyString(){
        cout<<"<>"<<endl;
    }
    void display(){
        cout<<"<";
        int i =0 ;
        for(i =0 ;i<n;i++){
            cout<<" ";
        }
        cout<<">"<<endl;
    }
    void display(){
        cout<<"<"<<s<<">"<<endl;
    }
};
void m_main(){
    MyString * ms = new MyString();
    ms.display();
}

#endif // MYSTRING_H_INCLUDED
