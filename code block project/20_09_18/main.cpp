#include <iostream>
#include <string>
#include "y.h"
#include "20_09_21.h"
using namespace std;
struct student {
    string name;
    int age;
    int score;

};

struct LNode{
    int val;
    struct LNode *next;
};

class Person{
    private : int age;
    public :
        Person(int n){
            age=n;
        }
        void setAge(int n){
            age = n;
        }
        int getAge(){
            return age;
        }
};

class A {
public:
    A(){
        cout<<"A�Ĺ���"<<endl;
    }
    void destory(){
        cout<<"delete A"<<endl;
        delete this;
    }
private :
    ~A(){
        cout<<"A������"<<endl;
    }

};

void print_student(struct student *);
void m_main();
int main()
{
    m_main();
/*
    struct student s = {"������",18,99};
    struct student * p = &s;
    print_student(p);
    D * d = new D();

    A* a = new A();//new�����Ķ����ڶ�����
    (*a).destory();
    A b;
    //b.destory();

    cout.setf(ios::right,ios::adjustfield);
    cout << "Hello world!" << endl<<"sadafa"<<endl;
    float f = 3.1415;
    cout<<f<<endl;
    cout.precision(2);
    cout<<f<<endl;

    char c;
    cin>>c;
    cout<<cin.rdstate()<<endl;
    if(cin.rdstate()==ios::goodbit){
        cout<<"������ȷ"<<endl;
    }else{
        cout<<"�������"<<endl;
    }
    string s ="dasfasf";
    cout<<s<<endl;
    string str ;
    cin>>str;
    cout<<str.size()<<endl;
    cout<<str.length()<<endl;
    int * p = new (nothrow) int[10];
    cout<<"p="<<*p<<endl;
    delete []p;
    struct student s;
    cin>>s.age;
    cin>>s.name;
    cin>>s.score;
    s.add_age(s);
    cout<<s.name<<"�����ڵ������ǣ�"<<s.age<<endl;
    int a = 1;
    int &b = a;
    cout<<b<<endl;
    Person  s(1);
    cout<<(s).getAge()<<endl;
    Person p = s;
    (p).setAge(13);
    int p_age= (p).getAge();
    Person pp = p;
    cout<<pp.getAge()<<endl;
    cout<<"p�ĵ�ַ"<<&p<<endl;
    cout<<"pp�ĵ�ַ"<<&pp<<endl;
    cout<<pp.getAge()<<endl;*/
    return 0;
}

void print_student(struct student *s ){
    cout<<"����"<<(*s).name<<"����"<<(*s)>.age<<"����"<<(*s)>.score<<endl;
}

