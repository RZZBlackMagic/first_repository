#ifndef DEQUE_H_INCLUDED
#define DEQUE_H_INCLUDED
#include "fstream"
#include <iostream>
#include "algorithm"
#include "string"
#include "list"
using namespace std;
#include "deque"
#include "set"

void PrintSet(set<int> &s){
    for(set<int>::iterator it=s.begin();it!=s.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}
void myPrintDeque(const deque<int>&d){
    for(deque<int>::const_iterator it=d.begin();it!=d.end();it++){
        cout<<*it<<endl;
    }
}
void PrintList(list<int> &l){
    for(list<int>::iterator it = l.begin();it!=l.end();it++){
        cout<<*it<<endl;
    }
}
void test01(){
    deque<int> d;
    for(int i=0;i<10;i++){
        d.push_back(i);
    }
    myPrintDeque(d);

    deque<int> d2(d.begin(),d.end());
    myPrintDeque(d2);

    deque<int> d3(10,100);
    myPrintDeque(d3);
}
void test02(){
    deque<int> d;
    for(int i=0;i<10;i++){
        d.push_back(i);
    }
    myPrintDeque(d);
    //重载operator=赋值
    deque<int> d2;
    d2=d;
    myPrintDeque(d2);
    //assign赋值
    deque<int> d3;
    d3.assign(d.begin(),d.end());
    myPrintDeque(d3);

    deque<int> d4;
    d4.assign(10,100);
    myPrintDeque(d4);
}
void test03(){
    deque<int> d;
    for(int i=0;i<10;i++){
        d.push_back(i);
    }
    myPrintDeque(d);

    d.resize(11,1111);
    myPrintDeque(d);
    if(!d.empty())
        cout<<d.size()<<endl;
}
void test04(){
    deque<int> d;
    d.push_back(100);
    d.push_back(20000);
    d.push_back(1);
    deque<int>::iterator it = d.begin();
    deque<int>::iterator it2 = d.end();
    sort(it,it2);
    myPrintDeque(d);
}

void test05(){
    list<int> l;
    for(int i=0;i<10;i++){
        l.push_back(i);
    }
    PrintList(l);

    list<int> l1(l.begin(),l.end());
    PrintList(l1);

    list<int> l2(10,1000);
    PrintList(l2);

    list<int> l3(l);
    PrintList(l3);
}

void test06(){
    list<int> l;
    for(int i=0;i<10;i++){
        l.push_back(i);
    }

    list<int> l1 ;
    l1.assign(l.begin(),l.end());
    PrintList(l1);

    list<int> l2;
    l2=l;
    PrintList(l2);

    list<int> l3;
    l3.assign(10,1000);
    PrintList(l3);
}

void test07(){
    list<int> l;
    for(int i=0;i<10;i++){
        l.push_back(i);
    }
    list<int> l2;
    for(int i=0;i<10;i++){
        l2.push_back(1);
    }
    PrintList(l);
    PrintList(l2);
    cout<<"******"<<endl;
    l.swap(l2);
    PrintList(l);
    PrintList(l2);
}

void test08(){
    list<int> l;
    for(int i=0;i<10;i++){
        l.push_back(i);
    }
    //PrintList(l);
    l.reverse();
    //PrintList(l);

    list<int> l3;
    l3.push_back(100);
    l3.push_back(20000);
    l3.push_back(1);
    PrintList(l3);
    l3.sort();
    PrintList(l3);
}

void test09(){
    set<int> st;
    for(int i=0;i<10;i++){
        st.insert(i);
    }
    PrintSet(st);

    set<int> s1;
    s1=st;
    PrintSet(s1);
}

void test10(){
    set<int> st;
    pair<set<int>::iterator,bool>ret = st.insert(1);//返回为_Pairib = pair<iterator,bool>;
    pair<set<int>::iterator,bool>ret1 = st.insert(1);
    if(ret.second){//ret的第二个属性
        cout<<"第一次插入成功"<<endl;
    }else{
        cout<<"第一次插入失败"<<endl;
    }
    if(ret1.second){
        cout<<"第二次插入成功"<<endl;
    }else{
        cout<<"第二次插入失败"<<endl;
    }

}

void test11(){
    pair<string ,int> p("tom",20);
    cout<<p.first<<endl;//打印出来tom
    cout<<p.second<<endl;//打印出来20

    pair<string,int> p2 = make_pair("hhh",30);
    cout<<p2.first<<endl;
    cout<<p2.second<<endl;
}

class myCompare{
public:
    bool operator()(int a,int b)
    {
        return a>b;
    }
};

void test12(){
    set<int,myCompare> st;
    st.insert(100);
    st.insert(10);
    st.insert(1000);
    //PrintSet(st);//10,100,1000
    for(set<int,myCompare>::iterator it=st.begin();it!=st.end();it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}
#endif // DEQUE_H_INCLUDED
