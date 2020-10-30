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
    vector<computerRoom> vCom;//��������
    map<int,map<string,string>> myApply;//�ҵ�ԤԼ����
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
    //�˵�����
    void operMenu(){
        cout<<"��ӭѧ����"<<this->m_Name<<"��¼"<<endl;
        cout<<"\t\t------------------------\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     1 ����ԤԼ        |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     2 �鿴�ҵ�ԤԼ   |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     3 �鿴����ԤԼ   |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     4 ȡ��ԤԼ       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     0 ע����¼       |\n";
        cout<<"\t\t------------------------\n";
        cout<<"��ѡ�����Ĳ���"<<endl;
    }
    //����ԤԼ
    void applyOrder(){
        //ѡ�����ڣ���һ������)
        cout<<"��������ʱ��Ϊ��һ������"<<endl;
        cout<<"����������ԤԼ��ʱ�䣺"<<endl;
        cout<<"1 ��һ"<<endl;
        cout<<"2 �ܶ�"<<endl;
        cout<<"3 ����"<<endl;
        cout<<"4 ����"<<endl;
        cout<<"5 ����"<<endl;
        int date;//���������һ���������Ϣ
        while(true){
            cin>>date;
            if(date>0&&date<6){
                break;
            }
            cout<<"������������������"<<endl;
        }
        //ѡ��ʱ�Σ���������)
        int interval;//�����������
        cout<<"����������ԤԼ��ʱ��Σ�"<<endl;
        cout<<"1 ����"<<endl;
        cout<<"2 ����"<<endl;
        while(true){
            cin>>interval;
            if(interval>0&&interval<3){
                break;
            }
            cout<<"������������������"<<endl;
        }
        //ѡ�������1,2,3��
        int room;
        cout<<"��ѡ������ţ�"<<endl;
        cout<<"1 1�Ż�������"<<vCom[0].m_MaxNum<<endl;
        cout<<"2 2�Ż�������"<<vCom[1].m_MaxNum<<endl;
        cout<<"3 3�Ż�������"<<vCom[2].m_MaxNum<<endl;
        while(true){
            cin>>room;
            if(room>0&&room<4){
                break;
            }
            cout<<"������������������"<<endl;
        }
        cout<<"ԤԼ�ɹ�������С�����"<<endl;
        //���ɶ���
        ofstream ofs;
        ofs.open(ORDER_FILE,ios::in|ios::app);
        ofs<<"date:��"<<date<<" ";
        if(interval==1){
            ofs<<"interval:"<<"����"<<" ";
        }else{
            ofs<<"interval:"<<"����"<<" ";
        }
        ofs<<"stuId:"<<this->id<<" ";
        ofs<<"stuName:"<<this->m_Name<<" ";
        ofs<<"roomId:"<<room<<"�ŷ��� ";
        ofs<<"status:"<<"�����"<<endl;
        initMyApply();
        ofs.close();
        system("pause");
        system("cls");
    }
    void printMap(){
        int i =1;
        cout<<"myApply�Ĵ�С��"<<myApply.size()<<endl;
        for(map<int,map<string,string>>::iterator it = myApply.begin();it!=myApply.end();it++){
            cout<<"��"<<it->first<<"����¼��";
            i++;
            for(map<string,string>::iterator it1 = it->second.begin();it1!=it->second.end();it1++){
                cout<<it1->first<<":"<<it1->second;
            }
            cout<<endl;
        }
    }
    //�鿴�ҵ�ԤԼ
    void showAMyOrder(){
        this->printMap();
    }
    //�鿴����ԤԼ
    void showAllOrder(){
        orderFile *of = new orderFile();
        of->printMap();
    }
    //ȡ��ԤԼ
    void cancelOrder(){
        printMap();
        cout<<"������ԤԼ������"<<endl;
        int select;
        while(true){
            cin>>select;
            if(select>myApply.size()){
                cout<<"��������������������룺"<<endl;
            }else{
                break;
            }
        }
        //ȡ��ԤԼ
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
        cout<<"orderDAta�еĵ�"<<i<<"����Ϣ��myApplyһ��"<<endl;
        //myApply.erase(select);
        //����ɾ������š�
        of->m_orderData.erase(i);
        //��order�ļ���ԤԼ��Ϣɾ��
        ofstream ofs;
        ofs.open(ORDER_FILE,ios::in|ios::trunc);
        for(map<int,map<string,string>>::iterator it = of->m_orderData.begin();it!=of->m_orderData.end();it++){
            //���ɶ���
            ofs<<"date:"<<it->second.at("date")<<" ";
            if(it->second.at("interval")==to_string(1)){
                ofs<<"interval:"<<"����"<<" ";
            }else{
                ofs<<"interval:"<<"����"<<" ";
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
