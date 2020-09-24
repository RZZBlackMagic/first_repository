#ifndef TOTALWEIGHT_H_INCLUDED
#define TOTALWEIGHT_H_INCLUDED
#include <iostream>
#include <exception>
#include <string.h>

using namespace std;

class Boat {
public:
    Boat(float b){
        weight = b;
    }
    friend void total_weight();
private:
    float weight;
};
class Car {
public:
    Car(float b){
        weight = b;
    }
    friend void total_weight();
private:
    float weight;
};

float total_weight(Car &c,Boat &b){
   return (c).weight+(b).weight;
}

void m_main(){
    Car * c = new Car(60.5);
    Boat * b = new Boat(60.5);
    total_weight(*c,*b);
}
#endif // TOTALWEIGHT_H_INCLUDED
