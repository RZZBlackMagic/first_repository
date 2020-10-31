#include <iostream>
#include "showMenu.h"
#include <string>
using namespace std;

#define MAX 1000
#define M 2
int index = 0;

void manage(){
    struct person personArray[MAX];
    struct person p [M]={{"任章哲",'M',18,"13541187190","陕西省"},{"章哲",'M',8,"13541187190","陕西省"}};
    int select = 0;
    show_menu();
    cout<<p[index].name<<endl;
    while(true){
        cout<<"请选择你的服务"<<endl;
        cin>>select;
        int i =0 ;
        string delete_name;
        string find_name;
        string edit_name;
    switch(select)
    {
    case 1://添加联系人
        cout<<"请输入姓名:"<<endl;
        cin>>personArray[index].name;
        //cout<<"...."<<personArray[0].name<<endl;
        cout<<"请输入性别:"<<endl;
        cin>>personArray[index].sex;
        cout<<"请输入年龄:"<<endl;
        cin>>personArray[index].age;
        //scanf("%d",&(personArray[index].age));
        cout<<"请输入电话:"<<endl;
        //personArray[index].phone='\n';
        personArray[index].phone="\n";
        getline(cin,personArray[index].phone);//清除cin缓存
        getline(cin,personArray[index].phone);
        //cin>>personArray[index].phone;
        //scanf("%s",&(personArray[index].phone));
        cout<<"请输入地址:"<<endl;
        //cin>>personArray[index].address;
        //personArray[index].address='\n';
        //personArray[index].address="\n";
        getline(cin,personArray[index].address);
        //scanf("%s",&(personArray[index].address));
        index++;
        cout<<"保存成功"<<endl;
        //cout<<"地址是："<<personArray[0].address<<endl;
        break;
    case 2://显示联系人
        cout<<"姓名       性别        年龄         电话            地址"<<endl;
        while(i<index){
            cout<<personArray[i].name<<"      "<<personArray[i].sex<<"       "<<personArray[i].age<<"         "<<personArray[i].phone<<"       "<<personArray[i].address<<endl;
            i++;
        }
        break;
    case 3://删除联系人
        cout<<"请输入要删除的联系人姓名："<<endl;
        cin>>delete_name;
        for(i=0;i<index;i++){
            if(delete_name==personArray[i].name){
                personArray[i].name=personArray[index-1].name;
                personArray[i].sex=personArray[index-1].sex;
                personArray[i].age=personArray[index-1].age;
                personArray[i].phone=personArray[index-1].phone;
                personArray[i].address=personArray[index-1].address;
                index--;
                continue;
            }
        }
        cout<<"删除成功"<<endl;
        break;
    case 4://查找联系人
        cout<<"请输入查找联系人的姓名："<<endl;
        cin>>find_name;
        for(i=0;i<index;i++){
            if(find_name==personArray[i].name){
                    cout<<personArray[i].name<<"      "<<personArray[i].sex<<"       "<<personArray[i].age<<"         "<<personArray[i].phone<<"       "<<personArray[i].address<<endl;
                    continue;
            }
        }
        break;
    case 5://修改联系人
        cout<<"请输入要修改联系人的姓名："<<endl;
        cin>>edit_name;
        for(i=0;i<index;i++){
            if(edit_name==personArray[i].name){
                cout<<"请输入要修改的姓名"<<endl;
                cin>>personArray[i].name;
                cout<<"请输入要修改的性别"<<endl;
                cin>>personArray[i].sex;
                cout<<"请输入要修改的年龄"<<endl;
                cin>>personArray[i].age;
                cout<<"请输入要修改的手机号"<<endl;
                cin>>personArray[i].phone;
                cout<<"请输入要修改的地址"<<endl;
                cin>>personArray[i].address;
                break;
            }
        }
        cout<<"修改完成"<<endl;
        break;
    case 6://清空联系人
        index=0;
        cout<<"清空完成"<<endl;
        break;
    case 0://退出通讯录
        cout<<"欢迎下次使用"<<endl;
        exit(0);
    default:
        break;
    }
    }

    //cout << "Hello world!" << endl;
}

class A{
private:
    static A *a;
    A(){
        cout<<"构造"<<endl;
    };
    A(A *a){
        cout<<"复制构造函数"<<endl;
    };

public :
    static A *getSingle(){
        if(NULL==a){
            a = new A();
        }
        return a;
    }
    static A getInstance(){
        return *getSingle();
    }
    void show(){
        cout<<"这是一个单例模式"<<endl;
    }
};
A * A::a=NULL;
void single(){
    A objA = A::getInstance();
    A  *a1 = A::getSingle();
    A  *a2 = A::getSingle();
    if(&a1==&a2){
        cout<<"a1和a2是统一对象"<<endl;
    }
    (*a1).show();
    objA.show();
}

int main()
{
    single();
    return 0;
}

