#include <iostream>
#include "globalFile.h"
#include "ideatity.h"
#include "fstream"
#include "student.h"
#include "teacher.h"
#include "manager.h"
using namespace std;


void  studentMenu(identity* &student1){
    while(true){
        //学生菜单
        student1->operMenu();
        student* stu = (student*)student1;
        int select;
        cout<<"请输入你的选择："<<endl;
        cin>>select;
        if(select==1){
            //申请预约
            stu->applyOrder();
        }else if(select==2){
            //查看我的预约
            stu->showAMyOrder();
        }else if(select==3){
            //查看所有预约
            stu->showAllOrder();
        }else if(select==4){
            //取消预约
            stu->cancelOrder();
        }else{
            //注销登录
            cout<<"注销成功"<<endl;
            system("pause");
            system("cls");
            break;
        }
    }
}
void managerMenu(identity* &manager1){
    while(true){
        //管理员菜单
        manager1->operMenu();

        manager * man = (manager *)manager1;
        int select;
        cin>>select;
        if(select==1){
            //添加账号
            man->addPerson();
        }else if(select == 2){
            //查看账号
            man->showPerson();
        }else if(select ==3){
            //查看机房
            man->showComputer();
        }else if(select ==4){
            //清空预约
            man->cleanFile();
        }else{
            //注销功能
            delete manager1;
            cout<<"注销成功"<<endl;
            system("pause");
            system("cls");
            return ;
        }
    }
}

void loginIn(string filename,int type){//filename：操作的文件名，type:登录的身份
    identity* person = NULL;

    ifstream ifs;
    ifs.open(filename,ios::in);

    if(!ifs.is_open()){
        cout<<"文件不存在"<<endl;
        ifs.close();
        return ;
    }
    int id = 0;
    string name;
    string password;

    if(type==1){
        //学生登录
        cout<<"请输入您的学号"<<endl;
        cin>>id;
    }else if(type==2){
        cout<<"请输入您的工号"<<endl;
        cin>>id;
        //教师登录
    }else if(type==3){
        //管理员登录
        cout<<"请输入您的工号："<<endl;
        cin>>id;
    }else{
        //输入有误
        cout<<"您的输入有误"<<endl;
    }
    cout<<"请输入您的姓名："<<endl;
    cin>>name;
    cout<<"请输入您的密码："<<endl;
    cin>>password;
    int fId;
    string fName;
    string fPwd;
    if(type==1){
        //进行学生登录验证
        while(ifs>>fId&&ifs>>fName&&ifs>>fPwd){
            cout<<fId<<endl;
            cout<<fName<<endl;
            cout<<fPwd<<endl;
            if(id==fId&&name==fName&&password==fPwd){
                cout<<"学生验证登录成功！"<<endl;
                system("pause");
                system("cls");
                person = new student(fId,fName,fPwd);
                //登录成功，进入学生的子菜单
                studentMenu(person);
                return;
            }
        }
    }else if(type==2){
        //进行教师登录验证
        while(ifs>>fId&&ifs>>fName&&ifs>>fPwd){
            if(id==fId&&name==fName&&password==fPwd){
                cout<<"教师验证登录成功！"<<endl;
                system("pause");
                system("cls");
                person = new teacher(fId,fName,fPwd);
                //登录成功，进入学生的子菜单
                return;
            }
        }
    }else if(type==3){
        //进行管理员登录验证
        while(ifs>>fId&&ifs>>fName&&ifs>>fPwd){
            if(id==fId&&name==fName&&password==fPwd){
                cout<<"管理员验证登录成功！"<<endl;
                system("pause");
                system("cls");
                person = new manager(fName,fPwd);
                //登录成功，进入学生的子菜单
                managerMenu(person);
                return;
            }
        }
    }else{
        cout<<"您的输入有误"<<endl;
    }
    cout<<"验证登录失败"<<endl;
    system("pause");
    return ;
}

int main()
{
    int select = 0;
    while(true){
        cout<<"***********欢迎来到机房预约系统*************"<<endl;
        cout<<endl<<"请选择您的身份："<<endl;
        cout<< "\t\t ------------------\n";
        cout<< "\t\t|                  |\n";
        cout<<"\t\t|    1 学生代表    |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t|    2 老师        |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t|    3 管理员      |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t|    0 退出        |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t ------------------\n";
        cout<<"请输入您的选择："<<endl;
        cin>>select;
        switch(select)
        {
        case 1:
            //学生
            loginIn(STUDENT_FILE,select);
            break;
        case 2:
            //老师
            loginIn(TEACHER_FILE,select);
            break;
        case 3:
            //管理员
            loginIn(ADMIN_FILE,select);
            break;
        case 0:
            //退出
            cout<<"欢迎下次使用"<<endl;
            system("pause");
            return 0;
            break;
        default:
            cout<<"输入有误，请重新选择！"<<endl;
            system("pause");
            system("cls");
            break;
        }
    }
    return 0;
}
