#include <iostream>
#include "homework6-9.h"
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
    c->zhou();   */
    Base *b = new Base("������",18,2.3);
    b->display();
    Base *b1 = new SecondDer("·����",22,99.9,"13541187190");
    b1->display();
    Base *b2 = new FirstDer("hhh ",23,99.8,"����ʡ�ظ�");
    b2->display();
    return 0;
}
