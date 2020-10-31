#include <iostream>
//#include "homework6-9.h"
//#include "construct_virtual.h"
//#include "private_virtual.h"
//#include "decorator.h"
//#include "homework7-1.h"
//#include "homework7-4.h"
//#include "homework7-5.h"
//#include "operator.h"
//#include "computer.h"
//#include "file_operator.h"
//#include "emp_manager.h"
//#include "vector.h"
//#include "deque.h"
//#include "set_multiset.h"
//#include "speech.h"
#include "speech_manager.h"
using namespace std;

void test(){
    map<int,map<string,string>> m;
    map<string,string> mm;
    mm.insert(make_pair("a","b;"));
    m.insert(make_pair(1,mm));
    for(map<int,map<string,string>>::iterator it = m.begin();it!=m.end();it++){
        string s = (it->second.at("a"));
        cout<<s<<endl;
    }
}

/*
template<class T>
class MyArray
{
private:
    T * pAddress;
    int m_Capacity;
    int m_size;
public:
    MyArray(int capacity)
    {
        this->m_Capacity=capacity;
        this->m_size = 0;
        this->pAddress = new T[this->m_Capacity];
    }
    //拷贝函数
    MyArray(const MyArray & a)
    {
        this->m_Capacity = a->m_Capacity;
        this->m_size = a->m_size;
        //this->pAddress = a->pAddress;
        this->pAddress = new T[a.m_Capacity];
        for(int i=0;i<this->m_size;i++){
            this->pAddress[i] = a.pAddredd[i];
        }
    }
    ~MyArray()
    {
        if(this->pAddress!=NULL)
        {
            delete[] this->pAddress;
            this->pAddress = NULL;
        }
    }
    //perate=
    //利用下标的放肆访问数组中的元素
    T * getElementByIndex(int index)
    {

    }
    //尾插法
    //尾删法
    //获取数组容量
    //获取数组大小
    //析构
};
*/
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
    c->zhou();
    Base *b = new Base("任章哲",18,2.3);
    b->display();
    Base *b1 = new SecondDer("路欣静",22,99.9,"13541187190");
    b1->display();
    Base *b2 = new FirstDer("hhh ",23,99.8,"陕西省呢个");
    b2->display();
    BuyTransaction b;
    b.logTransaction();
    //SellTransaction s;

    Base * b = new D();
    delete b;
    coffee *c = new coffee();
    cout<<c->getName()<<"价格是："<<c->getPrice()<<endl;
    coffee *mc = new milkDecorator(*c);
    cout<<mc->getName()<<"价格是："<<mc->getPrice()<<endl;
    int m = T_min<int>(9,2,3);
    cout<<m<<endl;
    int m = T_max(4,8);
    cout<<m<<endl;
    int mm = T_max("ad","bd");
    cout<<mm<<endl;
    Sample<char> s('a');
    s++;
    s.disp();
    people  p ;
    p.age=1;
    p.score=2;
    //people * p1 = new people(2,3);
    //cout<<"P_age="<<(++p).age<<endl;
    cout<<"p_score="<<p.score<<endl;
    //people p3 = (*p)-(*p1);
    //cout<<"P_age="<<p3.age<<"  "<<"p_score="<<p3.score<<endl;
    cout<<p<<endl;
    people p2;
    p2 = p;*/
    /*
    if(p2==p)
        cout<<"相等"<<endl;
    if(p2!=p)
        cout<<"不相等"<<endl;
    cout<<p2<<endl;
    //cout<<&p<<endl;

    //cout<<&p<<endl;
    //cout<<"P_age="<<p.age<<"  "<<"p_score="<<p.score<<endl;

    CPU *cpu = new Intel_cpu();
    VideoCard *vc = new Intel_VideoCard();
    Memory *m = new Intel_Memory();
    computer *c = new computer(cpu,vc,m);
    c->cpu->caculate();
    c->vc->display();
    c->memory->storage();*/
    //test01();
    //test02();
    //test03();
    //test04();
    /*
    employee e;
    e.show_menu();
    int empNum = e.getNum();
    //employee* e_arr;//创建一个数组，数组大小就是文件中的数据的大小和要添加的员工的大小。
    while(true){
        cout<<"请选择要使用的功能："<<endl;
        int choice;
        cin>>choice;
        switch(choice){
        case 0:
            //退出系统
            return 0;
        case 1:
            //增加职工
            e.add_emp();
            cout<<"增加成功"<<endl;
            break;
        case 2:
            //显示职工
            e.display();
            break;
        case 3:
            //删除职工信息
            e.delete_emp();
            cout<<"删除成功"<<endl;
            break;
        case 4:
            //修改职工
            e.edit_emp();
            cout<<"修改成功"<<endl;
            break;
        case 5:
            //查找职工
            e.findEmpNyNum();
            break;
        case 6:
            //按照编号排序
            e.sortByNum();
            break;
        case 7:
            //清空所有文档
            e.clear_emp();
            cout<<"清空成功"<<endl;
            break;
        }
    }*/
    //test11();
    //test33();
    //menu();
    test();
    SpeechManager sp ;
    sp.show_Menu();
    //sp.print();
    int input;
    while(true){
        cout<<"请输入您的选择:"<<endl;
        cin>>input;
        switch(input){
        case 1:
            //begin_speech();
            sp.startSpeech();
            //sp.print();
            break;
        case 2:
            sp.find_past_result();
            break;
        case 3:
            sp.clear_result();
            break;
        case 0:
            sp.exit_speech();
            break;
        default:
            cout<<"您的输入有问题"<<endl;
            system("cls");
            break;
        }
    }
}
