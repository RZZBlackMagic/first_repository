#ifndef TOTALWEIGHT_H_INCLUDED
#define TOTALWEIGHT_H_INCLUDED
#include <iostream>
#include <exception>
#include <string.h>

using namespace std;

class Boat;
class Car;
class Boat {
public:
    Boat(float b){
        weight = b;
    }
    friend float total_weight(Car c, Boat b);
private:
    float weight;
};
class Car {
public:
    Car(float b){
        weight = b;
    }
    friend float total_weight(Car c, Boat b);
private:
    float weight;
};

float total_weight(Car c, Boat b){
   float ff =  c.weight+b.weight;
   cout<<ff<<endl;
   return ff;
}

void m_main(){
    Car * c = new Car(60.5);
    Boat * b = new Boat(60.5);
    float ff = total_weight(*c,*b);
    //cout<<(ff)<endl;
}
#endif // TOTALWEIGHT_H_INCLUDED
