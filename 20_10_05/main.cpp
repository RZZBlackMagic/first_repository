#include <iostream>

#include "makeDrink.h"
/*
#include "test.h"
#include "homework5-2.h"
#include "homework5-3.h"

#include "EmpInfo.h"
*/
#include "homework6-5.h"
#include "string"
using namespace std;
class Animal{
public:
    virtual void doSpeak() = 0;
};

class Dog:public Animal{
public:
    void doSpeak(){
        cout<<"小狗在说话"<<endl;
    }
};

void test01(Animal &a){
    a.doSpeak();
}
void doWork(Drink *d){

}
int main()
{
    Dog a;
    test01(a);
    //Animal *a = new Dog();
    //a->doSpeak();
    //Drink &d = new Coffee();
    //d.makeDrink();
    //B b;
    //b.act2();
    //string s = "afafaf";
    //char * c ;
    //cout<<c<<endl;
    /*
    Sub1 s1(1000,"this is an object of Sub1");
    Sub2 s2(2000,10);
    s1.printOn();
    s2.printOn();
    B b;
    b.act2();
    Employee *e = new Employee("renzhangz",56,2,3424324);
    e->printOn();
    e->retire();
    e->printOn();
    //Manager *m = new Manager("路欣静",22,1,54656,"学生");

    BC *p;
    for(int i=0;i<4;i++)
    switch(i)
    {
        case 1:p=new BC;break;
        case 2:p=new DC1;break;
        case 3:p=new DC2;break;
    }
    p->run();
    p->sayhi();
    delete p;
     */
    return 0;
}
