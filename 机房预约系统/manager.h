#ifndef MANAGER_H_INCLUDED
#define MANAGER_H_INCLUDED
#include <iostream>
#include "string"
#include "ideatity.h"
#include "vector"
#include "teacher.h"
#include "ComputerRoom.h"
using namespace std;

class manager:public identity
{
public:
    manager(){}

    manager(string name,string password){
        this->m_Name = name;
        this->m_Password = password;
        this->initVector();
    }
    //选择菜单
    virtual void operMenu(){
        cout<<"欢迎管理员："<<this->m_Name<<"登录"<<endl;
        cout<<"\t\t------------------------\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     1 添加账号       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     2 查看账号       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     3 查看机房       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     4 清空预约       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     0 注销登录       |\n";
        cout<<"\t\t------------------------\n";
        cout<<"请选择您的操作"<<endl;
    }
    //添加账号
    void addPerson(){
        cout<<"请输入添加账号的类型："<<endl;
        cout<<"1 添加学生"<<endl;
        cout<<"2 添加老师"<<endl;

        string filename;
        string tip;
        string errorTip;
        ofstream ofs;
        int select = 0;
        cin>>select;
        if(select==1){
            //添加学生
            filename = STUDENT_FILE;
            tip = "请输入学号：";
            errorTip = "学号重复，请重新填写";
        }else if(select ==2 ){
            //添加教师
            filename = TEACHER_FILE;
            tip = "请输入职工编号：";
            errorTip = "职工编号重复，请重新填写";
        }else{
            //输入有误
            cout<<"您的输入有误！"<<endl;
        }
        int id;
        string name;
        string pwd;
        cout<<tip<<endl;
        while(true){
            cin>>id;
            //学号或者职工号输入后，进行重复检验
            bool ret = checkRepeat(id,select);
            if(ret==true){
                //重复
                cout<<errorTip<<endl;
                cout<<"请重新输入："<<endl;
            }else{
                break;
            }
        }
        cout<<"请输入姓名："<<endl;
        cin>>name;
        cout<<"请输入密码："<<endl;
        cin>>pwd;
        ofs.open(filename,ios::out|ios::app);
        ofs<<id<<" "<<name<<" "<<pwd<<endl;
        this->initVector();
        cout<<"添加成功！"<<endl;
        system("pause");
        system("cls");
        ofs.close();
    }
    //查看账号
    void printStudent(student &s){
        cout<<" 学号："<<s.id<<" 姓名："<<s.m_Name<<" 密码："<<s.m_Password<<endl;
    }
    void printTeacher(teacher &t){
        cout<<" 工号："<<t.empId<<" 姓名："<<t.m_Name<<" 密码："<<t.m_Password<<endl;
    }
    void showPerson(){
        while(true){
            cout<<"请选择查看内容："<<endl;
            cout<<"1 学生"<<endl;
            cout<<"2 教师"<<endl;
            int select = 0;
            cin>>select;
            if(select==1){
                //查看学生
                for(vector<student>::iterator it = vStu.begin();it!=vStu.end();it++){
                    printStudent(*it);
                }
                break;
            }else if(select==2){
                //查看教师
                for(vector<teacher>::iterator it = vTea.begin();it!=vTea.end();it++){
                    printTeacher(*it);
                }
                break;
            }else{
                //输入有误
                cout<<"输入有误！"<<endl;
            }
        }
    }
    void printComputerRoom(computerRoom& cr){
        cout<<"机房号为："<<cr.m_ComId<<" 机房的最大容量为："<<cr.m_MaxNum<<endl;
    }
    //查看机房信息
    void showComputer(){
        for(vector<computerRoom>::iterator it= vCom.begin();it!=vCom.end();it++){
            printComputerRoom(*it);
        }
    }
    //清空预约记录
    void cleanFile(){
        ofstream ofs;
        ofs.open(ORDER_FILE,ios::trunc);
        ofs.close();
        cout<<"清空成功"<<endl;
        system("pause");
        system("cls");
    }
    vector<student> vStu;//学生容器
    vector<teacher> vTea;//教师容器
    vector<computerRoom> vCom;//机房容器
    void initVector(){
        //初始化容器
        //读取学生信息
        ifstream ifs;
        ifs.open(STUDENT_FILE,ios::in);
        if(!ifs.is_open()){
            cout<<"文件读取失败；"<<endl;
            return;
        }
        vStu.clear();
        vTea.clear();

        student s;
        while(ifs>>s.id&&ifs>>s.m_Name&&ifs>>s.m_Password){
            vStu.push_back(s);
        }
        cout<<"当前学生数量为："<<vStu.size()<<endl;
        ifs.close();
        //读取教师信息
        ifs.open(TEACHER_FILE,ios::in);
        teacher t ;
        while(ifs>>t.empId&&ifs>>t.m_Name&&ifs>>t.m_Password){
            vTea.push_back(t);
        }
        cout<<"当前教师数量为："<<vTea.size()<<endl;
        ifs.close();
        //初始化机房信息
        ifs.open(COMPUTER_FILE,ios::in);
        computerRoom cr;
        while(ifs>>cr.m_ComId&&ifs>>cr.m_MaxNum){
            vCom.push_back(cr);
        }
        cout<<"当前机房数量为："<<vCom.size()<<endl;
        ifs.close();
    }
    bool checkRepeat(int id,int type){
        //id：工号    type：person类型
        if(type==1){
            //是学生
            for(vector<student>::iterator it = vStu.begin();it!=vStu.end();it++){
                if(id==it->id){
                    return true;
                }
            }
        }else if(type==2){
            //教师
            for(vector<teacher>::iterator it = vTea.begin();it!=vTea.end();it++){
                if(id==it->empId){
                    return true;
                }
            }
        }else{
            //参数有误
            cout<<"参数有误"<<endl;

        }
    }
};


#endif // MANAGER_H_INCLUDED
