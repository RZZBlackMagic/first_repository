#ifndef STUDENT_H_INCLUDED
#define STUDENT_H_INCLUDED
#include "ideatity.h"
#include <iostream>
#include "string"
#include "vector"
#include "orderFile.h"
#include "ComputerRoom.h"
#include "fstream"
using namespace std;

class student:public identity
{
public:
    int id;
    vector<computerRoom> vCom;//机房容器
    map<int,map<string,string>> myApply;//我的预约容器
    vector<int> index;
    student(){}

    student(int id,string name,string password){
        this->id = id;
        this->m_Name = name;
        this->m_Password = password;
        initComVector();
        initMyApply();
    }
    void initMyApply(){
        myApply.clear();
        orderFile *of = new orderFile();
        int i = 1;
        for(map<int,map<string,string>>::iterator it = of->m_orderData.begin();it!=of->m_orderData.end();it++){
            if(it->second.at("stuId")==to_string(this->id)){
                myApply.insert(make_pair(i,it->second));
                i++;
            }
        }
    }
    void initComVector(){
        ifstream ifs;
        ifs.open(COMPUTER_FILE,ios::in);
        computerRoom cr;
        while(ifs>>cr.m_ComId&&ifs>>cr.m_MaxNum){
            vCom.push_back(cr);
        }
        ifs.close();
    }
    //菜单界面
    void operMenu(){
        cout<<"欢迎学生："<<this->m_Name<<"登录"<<endl;
        cout<<"\t\t------------------------\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     1 申请预约        |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     2 查看我的预约   |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     3 查看所有预约   |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     4 取消预约       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     0 注销登录       |\n";
        cout<<"\t\t------------------------\n";
        cout<<"请选择您的操作"<<endl;
    }
    //申请预约
    void applyOrder(){
        //选择日期（周一到周五)
        cout<<"机房开放时间为周一到周五"<<endl;
        cout<<"请输入申请预约的时间："<<endl;
        cout<<"1 周一"<<endl;
        cout<<"2 周二"<<endl;
        cout<<"3 周三"<<endl;
        cout<<"4 周四"<<endl;
        cout<<"5 周五"<<endl;
        int date;//用来存放周一到周五的信息
        while(true){
            cin>>date;
            if(date>0&&date<6){
                break;
            }
            cout<<"输入有误，请重新输入"<<endl;
        }
        //选择时段（上午下午)
        int interval;//存放上午下午
        cout<<"请输入申请预约的时间段："<<endl;
        cout<<"1 上午"<<endl;
        cout<<"2 下午"<<endl;
        while(true){
            cin>>interval;
            if(interval>0&&interval<3){
                break;
            }
            cout<<"输入有误，请重新输入"<<endl;
        }
        //选择机房（1,2,3）
        int room;
        cout<<"请选择机房号："<<endl;
        cout<<"1 1号机房容量"<<vCom[0].m_MaxNum<<endl;
        cout<<"2 2号机房容量"<<vCom[1].m_MaxNum<<endl;
        cout<<"3 3号机房容量"<<vCom[2].m_MaxNum<<endl;
        while(true){
            cin>>room;
            if(room>0&&room<4){
                break;
            }
            cout<<"输入有误，请重新输入"<<endl;
        }
        cout<<"预约成功，审核中。。。"<<endl;
        //生成订单
        ofstream ofs;
        ofs.open(ORDER_FILE,ios::in|ios::app);
        ofs<<"date:周"<<date<<" ";
        if(interval==1){
            ofs<<"interval:"<<"上午"<<" ";
        }else{
            ofs<<"interval:"<<"下午"<<" ";
        }
        ofs<<"stuId:"<<this->id<<" ";
        ofs<<"stuName:"<<this->m_Name<<" ";
        ofs<<"roomId:"<<room<<"号房间 ";
        ofs<<"status:"<<"审核中"<<endl;
        initMyApply();
        ofs.close();
        system("pause");
        system("cls");
    }
    void printMap(){
        int i =1;
        cout<<"myApply的大小："<<myApply.size()<<endl;
        for(map<int,map<string,string>>::iterator it = myApply.begin();it!=myApply.end();it++){
            cout<<"第"<<it->first<<"条记录：";
            i++;
            for(map<string,string>::iterator it1 = it->second.begin();it1!=it->second.end();it1++){
                cout<<it1->first<<":"<<it1->second;
            }
            cout<<endl;
        }
    }
    //查看我的预约
    void showAMyOrder(){
        this->printMap();
    }
    //查看所有预约
    void showAllOrder(){
        orderFile *of = new orderFile();
        of->printMap();
    }
    //取消预约
    void cancelOrder(){
        printMap();
        cout<<"请输入预约条数："<<endl;
        int select;
        while(true){
            cin>>select;
            if(select>myApply.size()){
                cout<<"你的输入有误，请重新输入："<<endl;
            }else{
                break;
            }
        }
        //取消预约
        int i = 1;
        orderFile *of = new orderFile();
        cout<<myApply[select]["date"]<<endl;
        cout<<myApply[select]["interval"]<<endl;;
        cout<<myApply[select]["stuId"]<<endl;;
        cout<<myApply[select]["stuName"]<<endl;;
        cout<<myApply[select]["roomId"]<<endl;;
        for(map<int,map<string,string>>::iterator it = of->m_orderData.begin();it!=of->m_orderData.end();it++)
        {
            if(it->second == myApply[select]){
                break;
            }else{
                i++;
            }
        }
        cout<<"orderDAta中的第"<<i<<"条消息和myApply一样"<<endl;
        //myApply.erase(select);
        //调整删除后序号‘
        of->m_orderData.erase(i);
        //将order文件的预约信息删掉
        ofstream ofs;
        ofs.open(ORDER_FILE,ios::in|ios::trunc);
        for(map<int,map<string,string>>::iterator it = of->m_orderData.begin();it!=of->m_orderData.end();it++){
            //生成订单
            ofs<<"date:"<<it->second.at("date")<<" ";
            if(it->second.at("interval")==to_string(1)){
                ofs<<"interval:"<<"上午"<<" ";
            }else{
                ofs<<"interval:"<<"下午"<<" ";
            }
            ofs<<"stuId:"<<it->second.at("stuId")<<" ";
            ofs<<"stuName:"<<it->second.at("stuName")<<" ";
            ofs<<"roomId:"<<it->second.at("roomId")<<" ";
            ofs<<"status:"<<it->second.at("status")<<endl;
        }
        ofs.close();
        initMyApply();
    }

};
#endif // STUDENT_H_INCLUDED
