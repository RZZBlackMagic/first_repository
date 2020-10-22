#ifndef SET_MULTISET_H_INCLUDED
#define SET_MULTISET_H_INCLUDED
#include "fstream"
#include <iostream>
#include "algorithm"
#include "string"
using namespace std;
#include "set"
#include "map"

void PrintMap(map<int,int> &m){
    for(map<int,int>::iterator it=m.begin();it!=m.end();it++){
        cout<<"key:"<<it->first<<" value:"<<it->second<<endl;
    }
}
class person{
public:
    int age;
    string name;
    person(){}
    person(string name,int age)
    {
        this->age = age;
        this->name = name;
    }
};
//指定自定义类型的排序规则
class myCompare{
public:
    bool operator()(const person &p1,const person &p2){
        if(p1.age>p2.age)
            return true;
        else
            return false;
    }
};
void test01(){
    set<person,myCompare> s;
    person p1("liubei",24);
    person p2("gaunyu",21);
    person p3("hhhh",22);
    person p4("kkkk",23);
    person p5("llll",25);
    s.insert(p1);
    s.insert(p2);
    s.insert(p3);
    s.insert(p4);
    s.insert(p5);
    for(set<person,myCompare>::iterator it = s.begin();it!=s.end();it++){
        cout<<"姓名："<<it->name<<"  年龄:"<<it->age<<endl;
    }

}


void test02(){
    map<int,int> m;
    m.insert(pair<int,int>(1,10));//pair<int,int>(1,10)是一个匿名对组
    m.insert(pair<int,int>(2,20));
    m.insert(pair<int,int>(3,30));
    m.insert(pair<int,int>(4,40));

    for(map<int,int>::iterator it=m.begin();it!=m.end();it++){
        cout<<"键为："<<it->first<<"值为："<<it->second<<endl;
    }

    map<int,int> m1;
    m1=m;
    for(map<int,int>::iterator it=m1.begin();it!=m1.end();it++){
        cout<<"键为："<<it->first<<"值为："<<it->second<<endl;
    }
}

void test03(){
    map<int,int> m;
    //四种插入
    m.insert(pair<int,int>(1,10));
    m.insert(make_pair(2,20));
    m.insert(map<int,int>::value_type(3,30));
    m[4] = 40;//不建议；如果map里面没有key为5的值，若你输出m[5]系统会创建一个[5,0]的键值对

    //删除
    m.erase(m.begin());//删除第一个

    m.erase(2);//按照key删除
        PrintMap(m);

}

class myMapCompare{
public:
    bool operator()(int v1,int v2){
        return v1>v2;
    }
};
void test04(){
    map<int,int,myMapCompare> m;
    m.insert(make_pair(1,10));
    m.insert(make_pair(3,30));
    m.insert(make_pair(2,20));
    m.insert(make_pair(4,40));
    for(map<int,int,myMapCompare>::iterator it=m.begin();it!=m.end();it++){
        cout<<"key:"<<it->first<<" value:"<<it->second<<endl;
    }
}
class myAdd{
public:
    int operator()(int v1,int v2){
        return v1+v2;
    }
};
void test05(){
    //函数对象在使用时，可以像普通函数那样调用，可以有参数，可以有返回值
    myAdd ma;//ma是一个对象，重载了()而已
    cout<<ma(10,10)<<endl;//20
}
//函数对象超出普通函数的概念，函数对象可以有自己的状态
class MyPrint{
public:
    int count1;
    void operator()(string test){
        cout<<test<<endl;
    }
};

void test06(){
    MyPrint mp ;
    mp("hello world");
}
#endif // SET_MULTISET_H_INCLUDED
