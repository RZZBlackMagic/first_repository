#include <iostream>
//#include "homework6-9.h"
//#include "construct_virtual.h"
//#include "private_virtual.h"
//#include "decorator.h"
//#include "homework7-1.h"
//#include "homework7-4.h"
//#include "homework7-5.h"
#include "operator.h"
using namespace std;

/*
template<class T>
class MyArray
{
private:
    T * pAddress;
    int m_Capacity;
    int m_size;
public:
    MyArray(int capacity)
    {
        this->m_Capacity=capacity;
        this->m_size = 0;
        this->pAddress = new T[this->m_Capacity];
    }
    //��������
    MyArray(const MyArray & a)
    {
        this->m_Capacity = a->m_Capacity;
        this->m_size = a->m_size;
        //this->pAddress = a->pAddress;
        this->pAddress = new T[a.m_Capacity];
        for(int i=0;i<this->m_size;i++){
            this->pAddress[i] = a.pAddredd[i];
        }
    }
    ~MyArray()
    {
        if(this->pAddress!=NULL)
        {
            delete[] this->pAddress;
            this->pAddress = NULL;
        }
    }
    //perate=
    //�����±�ķ������������е�Ԫ��
    T * getElementByIndex(int index)
    {

    }
    //β�巨
    //βɾ��
    //��ȡ��������
    //��ȡ�����С
    //����
};
*/
int main()
{
    /*
    Base *b1 = new circle(3.2);
    b1->area();
    b1->zhou();
    Base *b2 = new inner_area(3.3);
    b2->area();
    b2->zhou();
    Base *b3 = new outter_area(3.4);
    b3->area();
    b3->zhou();
    cout << "Hello world!" << endl;

    inner_area *c = new inner_area(3.3);
    c->area();
    c->zhou();
    Base *b = new Base("������",18,2.3);
    b->display();
    Base *b1 = new SecondDer("·����",22,99.9,"13541187190");
    b1->display();
    Base *b2 = new FirstDer("hhh ",23,99.8,"����ʡ�ظ�");
    b2->display();
    BuyTransaction b;
    b.logTransaction();
    //SellTransaction s;

    Base * b = new D();
    delete b;
    coffee *c = new coffee();
    cout<<c->getName()<<"�۸��ǣ�"<<c->getPrice()<<endl;
    coffee *mc = new milkDecorator(*c);
    cout<<mc->getName()<<"�۸��ǣ�"<<mc->getPrice()<<endl;
    int m = T_min<int>(9,2,3);
    cout<<m<<endl;
    int m = T_max(4,8);
    cout<<m<<endl;
    int mm = T_max("ad","bd");
    cout<<mm<<endl;
    Sample<char> s('a');
    s++;
    s.disp();    */
    people  p ;
    p.age=1;
    p.score=2;
    //people * p1 = new people(2,3);
    //cout<<"P_age="<<(++p).age<<endl;
    cout<<"p_score="<<p.score<<endl;
    //people p3 = (*p)-(*p1);
    //cout<<"P_age="<<p3.age<<"  "<<"p_score="<<p3.score<<endl;
    cout<<p<<endl;
    people p2;
    p2 = p;
    /*
    if(p2==p)
        cout<<"���"<<endl;
    if(p2!=p)
        cout<<"�����"<<endl;
    cout<<p2<<endl;*/
    //cout<<&p<<endl;

    //cout<<&p<<endl;
    //cout<<"P_age="<<p.age<<"  "<<"p_score="<<p.score<<endl;
    return 0;
}
