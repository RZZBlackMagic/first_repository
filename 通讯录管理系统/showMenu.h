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
//显示菜单
void show_menu(){
    cout<<"**********************"<<endl;
    cout<<"****1,添加联系人****"<<endl;
    cout<<"****2,显示联系人****"<<endl;
    cout<<"****3,删除联系人****"<<endl;
    cout<<"****4,查找联系人****"<<endl;
    cout<<"****5,修改联系人****"<<endl;
    cout<<"****6,清空联系人****"<<endl;
    cout<<"****0,退出通讯录****"<<endl;
    cout<<"**********************"<<endl;
}

#endif // SHOWMENU_H_INCLUDED
