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
    //����һ��vector����
    vector<int> v;
    //�������в�������
    v.push_back(10);
    v.push_back(20);
    v.push_back(30);
    v.push_back(40);
    /*
    //ͨ�����������������е�����
    vector<int>::iterator itBegin = v.begin();//��ʼ��������ָ�������еĵ�һ��Ԫ�أ�ָ��10��
    vector<int>::iterator itEnd = v.end();//������������ָ�������е����һ����Ԫ�ص���һ��λ�ã�ָ��40����һ��λ�ã�s

    //��һ�ֱ�����ʽ
    while(itBegin!=itEnd){
        cout<<*itBegin<<endl;
        itBegin++;
    }*/
    //�ڶ��ֱ�����ʽ
    /*
    for(vector<int>::iterator it=v.begin();it!=v.end();it++){
        cout<<*it<<endl;
    }*/
    //�����ֱ�����ʽ
    for_each(v.begin(),v.end(),myPrint);//��Ҫ����algorithmͷ�ļ�
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
//����Զ�������
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
    //��������
    for(vector<person>::iterator it=v.begin();it!=v.end();it++){
        cout<<(*it).m_Name<<it->m_Age<<endl;
    }
}

//����Զ������ͣ�ָ��
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
    //��������
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
    //����С����
    for(int i=0;i<4;i++){
        v1.push_back(i);
        v2.push_back(i+1);
        v3.push_back(i+2);
        v4.push_back(i+3);
    }
    //����������
    v.push_back(v1);
    v.push_back(v2);
    v.push_back(v3);
    v.push_back(v4);
    int i=1;
    for(vector<vector<int>>::iterator it=v.begin();it!=v.end();it++){
        cout<<"��"<<i<<"������"<<endl;
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
    //����һ��vector����
    vector<int> v;
    //�������в�������
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
    v.push_back(10);//β��
    v.push_back(20);
    v.push_back(30);
    v.push_back(40);
    v.pop_back();//βɾ
    printVector(v);

    //����
    v.insert(v.begin(),100);//��һ��100
    v.insert(v.begin(),2,1000);//��2��1000
    //ɾ��
    v.erase(v.begin());//ɾ����һ����
    v.erase(v.begin(),v.end());//ɾ��ȫ��Ԫ�أ�����ӡ��ʣһ�����С�����v.clear();
}
void test09(){
    vector<int> v;
    v.push_back(10);//β��
    v.push_back(20);
    v.push_back(30);
    v.push_back(40);
    vector<int> v2;
    v2.swap(v);
    printVector(v2);
}
//����swap���������ڴ�ռ�
void test10(){
    vector<int> v;
    for(int i=0;i<100000;i++){
        v.push_back(i);
    }
    cout<<"v������:"<<v.capacity()<<endl;//13000
    cout<<"v�Ĵ�С"<<v.size()<<endl;//10000

    v.resize(3);//��
    cout<<"v��������"<<v.capacity()<<endl;//13000
    cout<<"v�Ĵ�С��"<<v.size()<<endl;//3.�����ƶ��ڴ�ռ��,Ԫ�ظ������ˣ���������û�䣬�����ռ䱻�˷ѡ�

    //����swap�����ڴ�
    vector<int>(v).swap(v);//����һ������������v����ʼ��������ֵ���������ռ䣬����v�͸��������󽻻���v.capacity()=3&&v.size()=3.�������������capacity��Ϊ13000��size��Ϊ3��������������ִ�н������ڴ�ͱ��ͷ��ˡ�

    cout<<"v������:"<<v.capacity()<<endl;//3
    cout<<"v�Ĵ�С"<<v.size()<<endl;//3
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
    cout<<num<<endl;//1:������һ�οռ�
}
#endif // VECTOR_H_INCLUDED
