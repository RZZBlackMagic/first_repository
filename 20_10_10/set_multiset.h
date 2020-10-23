#ifndef SET_MULTISET_H_INCLUDED
#define SET_MULTISET_H_INCLUDED
#include "fstream"
#include <iostream>
#include "algorithm"
#include "string"
using namespace std;
#include "set"
#include "vector"
#include "functional"
#include "map"
#include "numeric"

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
//ָ���Զ������͵��������
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
        cout<<"������"<<it->name<<"  ����:"<<it->age<<endl;
    }

}


void test02(){
    map<int,int> m;
    m.insert(pair<int,int>(1,10));//pair<int,int>(1,10)��һ����������
    m.insert(pair<int,int>(2,20));
    m.insert(pair<int,int>(3,30));
    m.insert(pair<int,int>(4,40));

    for(map<int,int>::iterator it=m.begin();it!=m.end();it++){
        cout<<"��Ϊ��"<<it->first<<"ֵΪ��"<<it->second<<endl;
    }

    map<int,int> m1;
    m1=m;
    for(map<int,int>::iterator it=m1.begin();it!=m1.end();it++){
        cout<<"��Ϊ��"<<it->first<<"ֵΪ��"<<it->second<<endl;
    }
}

void test03(){
    map<int,int> m;
    //���ֲ���
    m.insert(pair<int,int>(1,10));
    m.insert(make_pair(2,20));
    m.insert(map<int,int>::value_type(3,30));
    m[4] = 40;//�����飻���map����û��keyΪ5��ֵ���������m[5]ϵͳ�ᴴ��һ��[5,0]�ļ�ֵ��

    //ɾ��
    m.erase(m.begin());//ɾ����һ��

    m.erase(2);//����keyɾ��
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
    //����������ʹ��ʱ����������ͨ�����������ã������в����������з���ֵ
    myAdd ma;//ma��һ������������()����
    cout<<ma(10,10)<<endl;//20
}
//�������󳬳���ͨ�����ĸ����������������Լ���״̬
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
class GreaterFive
{
public:
    bool operator()(int v){
        if(v>5)
            return true;
        else
            return false;
    }
};
void test07(){
    //һԪν��
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    //���������� ��û�д���5����
    vector<int>::iterator it = find_if(v.begin(),v.end(),GreaterFive());
    if(it==v.end()){
        cout<<"δ�ҵ�"<<endl;
    }else{
        cout<<"����5��Ԫ���ǣ�"<<(*it)<<endl;
    }
}
class eryuanCompare{
public:
    bool operator()(int v1,int v2){
        if(v1>v2)
            return true;
        else
            return false;
    }
};
void test08(){
    vector<int> v;
    v.push_back(10);
    v.push_back(40);
    v.push_back(20);
    v.push_back(30);
    v.push_back(50);
    sort(v.begin(),v.end());
    for(vector<int>::iterator it=v.begin();it!=v.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;

    //ʹ�ú�������ı��㷨���ԣ���˳��Ϊ�Ӵ�С
    sort(v.begin(),v.end(),eryuanCompare());
    for(vector<int>::iterator it1=v.begin();it1!=v.end();it1++){
        cout<<*it1<<" ";
    }
}
void test09(){
    negate<int> n;
    int a = n(50);//��50����ȡ������
    cout<<a<<endl;//�������-50
}

void test10(){
    plus<int> p;//����ֻ��Ҫ����һ����Ĭ����������ͬ���͵�
    int a = p(10,20);//����30
    cout<<a<<endl;
}

void test11(){
    greater<int> g;
    bool b = g(10,20);
    if(b)
        cout<< 1;
    else
        cout<< 2;
}

void print01(int v){
    cout<<v<<" ";
}

class print02{
public:
    void operator()(int v){
        cout<<v<<" ";
    }
};
void test12(){
    vector<int> v;
    for(int i =0;i<10;i++){
        v.push_back(i);
    }
    for_each(v.begin(),v.end(),print02());
}

class Transform{
public:
    int operator()(int v){
        return v;
    }
};
void test13(){
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    vector<int> v1;
    v1.resize(10);//������ǰ���ٿռ�
    transform(v.begin(),v.end(),v1.begin(),Transform());
    for_each(v1.begin(),v1.end(),print02());
}

void test14(){
    //find�㷨��������������
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    //�����������Ƿ���5���Ԫ��
    vector<int>::iterator it = find(v.begin(),v.end(),5);
    if(it==v.end()){
        cout<<"û��ռ��"<<endl;
    }else{
        cout<<*it<<endl;
    }
}

class person1 {
public:
    int age;
    string name;
    person1(int age,string name){
        this->age = age;
        this->name = name;
    }
    //��Ϊfind�ײ�����==�ţ���ʹ���Զ������͵�ʱ���������==��
    bool operator==(const person1 &p1){
        if((p1.name==this->name)&&(this->age==p1.age))
            return true;
        else
            return false;

    }
};
void test15(){
    vector<person1> v;
    person1 p1(18,"aaa");
    person1 p2(20,"bbb");
    person1 p3(19,"ccc");
    person1 p4(22,"ddd");
    person1 p5(21,"eee");
    v.push_back(p1);
    v.push_back(p2);
    v.push_back(p3);
    v.push_back(p4);
    v.push_back(p5);

    vector<person1>::iterator it = find(v.begin(),v.end(),p2);
    if(it==v.end())
        cout<<"û�ҵ�"<<endl;
    else
        cout<<"p2������"<<it->name<<"p2���䣺"<<it->age<<endl;
}


void test16(){
    //������������
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }

    vector<int>::iterator it = find_if(v.begin(),v.end(),GreaterFive());//GreaterFive()���Ǻ�������
    if(it==v.end()){
        cout<<"û�ҵ�"<<endl;
    }else{
        cout<<*it<<endl;
    }

}
class Greate20{
public:
    bool operator()(person1& p){
        return p.age>20;
    }
};
void test17(){
    vector<person1> v;
    person1 p1(18,"aaa");
    person1 p2(20,"bbb");
    person1 p3(19,"ccc");
    person1 p4(22,"ddd");
    person1 p5(21,"eee");
    v.push_back(p1);
    v.push_back(p2);
    v.push_back(p3);
    v.push_back(p4);
    v.push_back(p5);

    vector<person1>::iterator it = find_if(v.begin(),v.end(),Greate20());
    if(it==v.end())
        cout<<"û����"<<endl;
    else
        cout<<"����20���˵�������"<<it->name<<"���䣺"<<it->age<<endl;
}

void test18(){
    vector<int> v;
    v.push_back(0);
    v.push_back(1);
    v.push_back(0);
    v.push_back(2);
    v.push_back(1);
    v.push_back(4);
    v.push_back(3);
    v.push_back(3);
    vector<int>::iterator it = adjacent_find(v.begin(),v.end());
    if(it==v.end())
        cout<<"û���ҵ�"<<endl;
    else
        cout<<*it<<endl;
}

void test19(){
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    bool b = binary_search(v.begin(),v.end(),5);
    if(b==true)
        cout<<"���ҵ�"<<endl;
    else
        cout<<"û�ҵ�"<<endl;
}
void test20(){
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    v.push_back(1);
    int a = count(v.begin(),v.end(),11);
    cout<<a<<endl;
}

void test21(){
    vector<person1> v;
    person1 p1(18,"aaa");
    person1 p2(20,"bbb");
    person1 p3(19,"ccc");
    person1 p4(22,"ddd");
    person1 p5(21,"eee");
    v.push_back(p1);
    v.push_back(p2);
    v.push_back(p3);
    v.push_back(p4);
    v.push_back(p5);
    int a = count(v.begin(),v.end(),p2);
    cout<<a<<endl;
}

class great20{
public:
    bool operator()(int v){
        return v>7;
    }
};
void test22(){
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    v.push_back(8);
    int a = count_if(v.begin(),v.end(),great20());
    cout<<a<<endl;
}
class personCom{
public:
    bool operator()(const person1& p){
        if(p.age>19){
            return true;
        }else{
            return false;
        }
    }
};
void test23(){
    vector<person1> v;
    person1 p1(18,"aaa");
    person1 p2(20,"bbb");
    person1 p3(19,"ccc");
    person1 p4(22,"ddd");
    person1 p5(21,"eee");
    v.push_back(p1);
    v.push_back(p2);
    v.push_back(p3);
    v.push_back(p4);
    v.push_back(p5);
    int a  = count_if(v.begin(),v.end(),personCom());
    cout<<a<<endl;
}
class compare{
public:
    bool operator()(int v,int v1){
        return v>v1;
    }
};
void  test24(){
    vector<int> v;
    v.push_back(14);
    v.push_back(22);
    v.push_back(19);
    v.push_back(23);
    v.push_back(18);
    sort(v.begin(),v.end(),compare());
    for(vector<int>::iterator it = v.begin();it!=v.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}

void test25(){
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    for(vector<int>::iterator it = v.begin();it!=v.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;

    random_shuffle(v.begin(),v.end());

    for(vector<int>::iterator it = v.begin();it!=v.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}
void test26(){
    vector<int> v;
    for(int i=0;i<10;i++){
        v.push_back(i);
    }
    vector<int> v2;
    v2.resize(10);
    copy(v.begin(),v.end(),v2.begin());
    for(vector<int>::iterator it= v2.begin();it!=v2.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}

void test27(){
    vector<int> v;
    v.push_back(10);
    v.push_back(20);
    v.push_back(30);
    v.push_back(20);
    v.push_back(50);

    replace(v.begin(),v.end(),20,2000);//�����е�20����2000

    for(vector<int>::iterator it= v.begin();it!=v.end();it++){
        cout<<*it<<" ";
    }
}
class great30{
public:
    bool operator()(int v){
        return v>20;
    }
};
void test28(){
    vector<int> v;
    v.push_back(10);
    v.push_back(20);
    v.push_back(30);
    v.push_back(20);
    v.push_back(50);

    replace_if(v.begin(),v.end(),great30(),2000);

    for(vector<int>::iterator it = v.begin();it!=v.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}

void test29(){
    vector<int> v;
    for(int i=1;i<=100;i++){
        v.push_back(i);
    }
    int total = accumulate(v.begin(),v.end(),0);
    cout<<total;
}

void test30(){
    vector<int> v;
    v.resize(30);
    fill(v.begin(),v.end(),20);
    for(vector<int>::iterator it=v.begin();it!=v.end();it++)
        cout<<*it<<" ";

}

void test31(){
    vector<int> v;
    vector<int> v2;
    vector<int> vt;
    for(int i=0;i<10;i++){
        v.push_back(i);
        v2.push_back(i+3);
    }
    vt.resize(min(v.size(),v2.size()));//�������ϵ���Сֵ
    vector<int>::iterator itend = set_intersection(v.begin(),v.end(),v2.begin(),v2.end(),vt.begin());
    for(vector<int>::iterator it = vt.begin();it!=itend;it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}

void test32(){
    vector<int> v;
    vector<int> v2;
    vector<int> vt;
    for(int i=0;i<10;i++){
        v.push_back(i);
        v2.push_back(i+3);
    }
    vt.resize(v.size()+v2.size());
    vector<int>::iterator dest = set_union(v.begin(),v.end(),v2.begin(),v2.end(),vt.begin());
    for(vector<int>::iterator it=vt.begin();it!=dest;it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}
void test33(){
    vector<int> v1;
    vector<int> v2;
    for(int i=0;i<10;i++){
        v1.push_back(i);
        v2.push_back(i+3);
    }
    vector<int> vt;
    vt.resize(max(v1.size(),v2.size()));//��v1��v2�Ĳ�������Ϊv1�ĳߴ�
    vector<int>::iterator dest = set_difference(v1.begin(),v1.end(),v2.begin(),v2.end(),vt.begin());//v1-v2
    for(vector<int>::iterator it=vt.begin();it!=dest;it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}
#endif // SET_MULTISET_H_INCLUDED
