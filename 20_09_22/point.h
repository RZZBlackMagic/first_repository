#ifndef POINT_H_INCLUDED
#define POINT_H_INCLUDED
#include <iostream>
#include <math.h>
using namespace std;

class point{
public:
    double x;
    double y;
    point(){
        this->x=0;
        this->y=0;
    }
    point(int x,int y){
        this->x=x;
        this->y=y;
    }
};
double XY_distance(point &a,point &b){
        double d = (fabs(a.x-b.x))*(fabs(a.x-b.x))+fabs(a.y-b.y)*fabs(a.y-b.y);
        return sqrt(d);
    }
void m_main(){
        point *p1 = new point(1,1);
        point *p2 = new point();
        cout<<"x,y两点的距离是"<<XY_distance((*p1),(*p2))<<endl;
}


#endif // POINT_H_INCLUDED
