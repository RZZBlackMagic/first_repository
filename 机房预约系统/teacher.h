#ifndef TEACHER_H_INCLUDED
#define TEACHER_H_INCLUDED

#include "ideatity.h"
#include <iostream>
#include "string"
#include "orderFile.h"
using namespace std;

class teacher:public identity
{
public:
    int empId;
    map<int,map<string,string>> unCheck;
    teacher(){}

    teacher(int empId,string name,string password){
        this->m_Name = name;
        this->m_Password = password;
        this->empId = empId;
    }
    //菜单界面
    virtual void operMenu(){
        cout<<"欢迎学生："<<this->m_Name<<"登录"<<endl;
        cout<<"\t\t------------------------\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     1 查看所有预约   |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     2 审核预约        |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     0 注销登录       |\n";
        cout<<"\t\t------------------------\n";
        cout<<"请选择您的操作"<<endl;
    }
    //查看所有预约
    void showAllOrder(){
        orderFile* of = new orderFile();
        of->printMap();
    }
    //审核预约
    void validOrder(){
        unCheck.clear();
        orderFile* of = new orderFile();
        //将待审核的记录打印到控制台
        for(map<int,map<string,string>>::iterator it = of->m_orderData.begin();it!=of->m_orderData.end();it++){
            if(it->second.at("status")=="审核中"){
                unCheck.insert(*it);
            }
        }
        if(unCheck.size()==0){
            cout<<"所有的申请都已经处理了"<<endl;
            return;
        }
        for(map<int,map<string,string>>::iterator it = unCheck.begin();it!=unCheck.end();it++){
            cout<<"第"<<it->first<<"条记录：";
            for(map<string,string>::iterator it1 = it->second.begin();it1!=it->second.end();it1++){
                cout<<it1->first<<":"<<it1->second;
            }
            cout<<endl;
        }
        //请用户输入要处理的待审核信息
        cout<<"请您输入要处理的申请："<<endl;
        int select ;
        cin>>select;
        cout<<"是否通过："<<endl;
        cout<<"1 通过"<<endl;
        cout<<"2 不通过"<<endl;
        int flag;
        cin>>flag;
        if(flag==1){
            //通过
            of->m_orderData[select].at("status") = "通过";
            //of->printMap();
            unCheck[select].at("status")= "通过";
            of->updateOrder();
        }else if(flag==2){
            //不通过
            of->m_orderData[select].at("status") = "不通过";
            //of->printMap();
            unCheck[select].at("status")= "不通过";
            of->updateOrder();
        }else{
            //用户输入有问题
            cout<<"您的输入有问题"<<endl;
            return;
        }
    }

};

#endif // TEACHER_H_INCLUDED
