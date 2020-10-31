#ifndef NESTEDCLASS_H_INCLUDED
#define NESTEDCLASS_H_INCLUDED
#include <iostream>

using namespace std;

class A{

    static void fun1(){
        cout<<"fun1()"<<endl;
    }
public:
    class B;
    void fun2(){

        cout<<"fun2()"<<endl;
    }
    void fun5(){
       // b.fun3();
        //b.fun4
        //fun4();
        //fun1();
    }
};

class A::B{
public :
    void fun4(){
        cout<<"fun4()"<<endl;
        //fun3();
    }
private:
    void fun3(){
        cout<<"fun3()"<<endl;
    }
};

m_main(){
     A a;
    a.fun2();
    A::B b;
    //b.fun4();
    cout << "Hello world!" << endl;
}

#endif // NESTEDCLASS_H_INCLUDED
