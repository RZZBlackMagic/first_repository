#include <iostream>
//#include "homework6-9.h"
//#include "construct_virtual.h"
//#include "private_virtual.h"
#include "decorator.h"
using namespace std;

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
    Base *b = new Base("任章哲",18,2.3);
    b->display();
    Base *b1 = new SecondDer("路欣静",22,99.9,"13541187190");
    b1->display();
    Base *b2 = new FirstDer("hhh ",23,99.8,"陕西省呢个");
    b2->display();
    BuyTransaction b;
    b.logTransaction();
    //SellTransaction s;

    Base * b = new D();
    delete b;*/
    coffee *c = new coffee();
    cout<<c->getName()<<"价格是："<<c->getPrice()<<endl;
    coffee *mc = new milkDecorator(*c);
    cout<<mc->getName()<<"价格是："<<mc->getPrice()<<endl;
    return 0;
}
