#ifndef VECTOR_H_INCLUDED
#define VECTOR_H_INCLUDED
#include "fstream"
#include <iostream>
#include "algorithm"
#include "string"
using namespace std;
#include "vector"

void myPrint(int val){
    cout<<val<<endl;
}
void test01(){
    //创建一个vector容器
    vector<int> v;
    //想容器中插入数据
    v.push_back(10);
    v.push_back(20);
    v.push_back(30);
    v.push_back(40);
    /*
    //通过迭代器访问容器中的数据
    vector<int>::iterator itBegin = v.begin();//起始迭代器：指向容器中的第一个元素（指向10）
    vector<int>::iterator itEnd = v.end();//结束迭代器：指向容器中的随后一个二元素的下一个位置（指向40的下一个位置）s

    //第一种遍历方式
    while(itBegin!=itEnd){
        cout<<*itBegin<<endl;
        itBegin++;
    }*/
    //第二种遍历方式
    /*
    for(vector<int>::iterator it=v.begin();it!=v.end();it++){
        cout<<*it<<endl;
    }*/
    //第三种遍历方式
    for_each(v.begin(),v.end(),myPrint);//需要包含algorithm头文件
}

class person{
public:
    string m_Name;
    int m_Age;
    person(string name,int age){
        m_Name = name;
        m_Age = age;
    }
};
//存放自定义类型
void test02(){
    vector<person> v;
    person* p1 =new person("aaa",10);
    person* p2 =new person("bbb",20);
    person* p3 =new person("ccc",30);
    person* p4 =new person("ddd",40);
    person* p5 =new person("eee",50);
    v.push_back(*p1);
    v.push_back(*p2);
    v.push_back(*p3);
    v.push_back(*p4);
    v.push_back(*p5);
    //遍历数据
    for(vector<person>::iterator it=v.begin();it!=v.end();it++){
        cout<<(*it).m_Name<<it->m_Age<<endl;
    }
}

//存放自定义类型：指针
void test03(){
    vector<person *> v;
    person* p1 =new person("aaa",10);
    person* p2 =new person("bbb",20);
    person* p3 =new person("ccc",30);
    person* p4 =new person("ddd",40);
    person* p5 =new person("eee",50);
    v.push_back(p1);
    v.push_back(p2);
    v.push_back(p3);
    v.push_back(p4);
    v.push_back(p5);
    //遍历数据
    for(vector<person*>::iterator it=v.begin();it!=v.end();it++){
        cout<<(**it).m_Name<<(*it)->m_Age<<endl;
    }
}

void test04(){
    vector<vector<int>> v;
    vector<int> v1;
    vector<int> v2;
    vector<int> v3;
    vector<int> v4;
    //创建小容器
    for(int i=0;i<4;i++){
        v1.push_back(i);
        v2.push_back(i+1);
        v3.push_back(i+2);
        v4.push_back(i+3);
    }
    //创建大容器
    v.push_back(v1);
    v.push_back(v2);
    v.push_back(v3);
    v.push_back(v4);
    int i=1;
    for(vector<vector<int>>::iterator it=v.begin();it!=v.end();it++){
        cout<<"第"<<i<<"个容器"<<endl;
        i++;
        for(vector<int>::iterator it1=(*it).begin();it1!=(*it).end();it1++){
            cout<<*it1<<endl;
        }
    }
}
void test05(){
    const char* cstr = "hello world";
    string str(cstr);
    string str2(str);
    cout<<str2<<endl;
}
void test06(){
    string str1 = "hhh";
    char str2 = 'k';
    string str3 = str1+str2;
    cout<<str3<<endl;
    for(int i=0;i<str3.size();i++){
        cout<<str3[i]<<endl;
    }
}
void test07(){
    //创建一个vector容器
    vector<int> v;
    //想容器中插入数据
    v.push_back(10);
    v.push_back(20);
    v.push_back(30);
    v.push_back(40);
    vector<int>v3(v.begin(),v.end());

    vector<int> v2(10,100);
    for(vector<int>::iterator it=v2.begin();it!=v2.end();it++){
        cout<<*it<<endl;
    }


}
void printVector(vector<int> v2){
    for(vector<int>::iterator it=v2.begin();it!=v2.end();it++){
        cout<<*it<<endl;
    }
}
void test08(){
    vector<int> v;
    v.push_back(10);//尾插
    v.push_back(20);
    v.push_back(30);
    v.push_back(40);
    v.pop_back();//尾删
    printVector(v);

    //插入
    v.insert(v.begin(),100);//插一个100
    v.insert(v.begin(),2,1000);//插2个1000
    //删除
    v.erase(v.begin());//删除第一个数
    v.erase(v.begin(),v.end());//删除全部元素，最后打印就剩一个换行。等于v.clear();
}
void test09(){
    vector<int> v;
    v.push_back(10);//尾插
    v.push_back(20);
    v.push_back(30);
    v.push_back(40);
    vector<int> v2;
    v2.swap(v);
    printVector(v2);
}
//巧用swap可以收缩内存空间
void test10(){
    vector<int> v;
    for(int i=0;i<100000;i++){
        v.push_back(i);
    }
    cout<<"v的容量:"<<v.capacity()<<endl;//13000
    cout<<"v的大小"<<v.size()<<endl;//10000

    v.resize(3);//，
    cout<<"v的容量："<<v.capacity()<<endl;//13000
    cout<<"v的大小："<<v.size()<<endl;//3.重新制定内存空间后,元素个数变了，但是容量没变，大量空间被浪费。

    //巧用swap收缩内存
    vector<int>(v).swap(v);//创建一个匿名对象，用v来初始化，所以值分配三个空间，再用v和该匿名对象交换，v.capacity()=3&&v.size()=3.但是匿名对象的capacity变为13000，size变为3。匿名对象这行执行结束后，内存就被释放了。

    cout<<"v的容量:"<<v.capacity()<<endl;//3
    cout<<"v的大小"<<v.size()<<endl;//3
}
void test11(){
    vector<int> v;
    v.reserve(10000);
    int num =0;
    int *p = NULL;
    for(int i=0;i<10000;i++){
        v.push_back(i);
        if(p!=&v[0]){
            p=&v[0];
            num++;
        }
    }
    cout<<num<<endl;//1:开辟了一次空间
}
#endif // VECTOR_H_INCLUDED
