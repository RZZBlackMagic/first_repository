#ifndef SHOWMENU_H_INCLUDED
#define SHOWMENU_H_INCLUDED
#include <string>
using namespace std;

struct person{
    string name;
    char sex;
    int age;
    string phone;
    string address;
}Person;
//��ʾ�˵�
void show_menu(){
    cout<<"**********************"<<endl;
    cout<<"****1,�����ϵ��****"<<endl;
    cout<<"****2,��ʾ��ϵ��****"<<endl;
    cout<<"****3,ɾ����ϵ��****"<<endl;
    cout<<"****4,������ϵ��****"<<endl;
    cout<<"****5,�޸���ϵ��****"<<endl;
    cout<<"****6,�����ϵ��****"<<endl;
    cout<<"****0,�˳�ͨѶ¼****"<<endl;
    cout<<"**********************"<<endl;
}

#endif // SHOWMENU_H_INCLUDED
