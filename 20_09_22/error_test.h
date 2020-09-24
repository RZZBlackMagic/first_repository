#ifndef ERROR_TEST_H_INCLUDED
#define ERROR_TEST_H_INCLUDED
#include <iostream>

using namespace std;

class A{
public :
    A *p;
    A(){
        cout<<"A的构造"<<endl;
        p = this;
    }
    ~A(){
        cout<<"A的析构"<<endl;
        if(p!=NULL){
            delete p;
            p=NULL;
        }
    }
};

void test(){
    A a;
}

#endif // ERROR_TEST_H_INCLUDED
