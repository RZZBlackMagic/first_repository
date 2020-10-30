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
    //�˵�����
    virtual void operMenu(){
        cout<<"��ӭѧ����"<<this->m_Name<<"��¼"<<endl;
        cout<<"\t\t------------------------\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     1 �鿴����ԤԼ   |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     2 ���ԤԼ        |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     0 ע����¼       |\n";
        cout<<"\t\t------------------------\n";
        cout<<"��ѡ�����Ĳ���"<<endl;
    }
    //�鿴����ԤԼ
    void showAllOrder(){
        orderFile* of = new orderFile();
        of->printMap();
    }
    //���ԤԼ
    void validOrder(){
        unCheck.clear();
        orderFile* of = new orderFile();
        //������˵ļ�¼��ӡ������̨
        for(map<int,map<string,string>>::iterator it = of->m_orderData.begin();it!=of->m_orderData.end();it++){
            if(it->second.at("status")=="�����"){
                unCheck.insert(*it);
            }
        }
        if(unCheck.size()==0){
            cout<<"���е����붼�Ѿ�������"<<endl;
            return;
        }
        for(map<int,map<string,string>>::iterator it = unCheck.begin();it!=unCheck.end();it++){
            cout<<"��"<<it->first<<"����¼��";
            for(map<string,string>::iterator it1 = it->second.begin();it1!=it->second.end();it1++){
                cout<<it1->first<<":"<<it1->second;
            }
            cout<<endl;
        }
        //���û�����Ҫ����Ĵ������Ϣ
        cout<<"��������Ҫ��������룺"<<endl;
        int select ;
        cin>>select;
        cout<<"�Ƿ�ͨ����"<<endl;
        cout<<"1 ͨ��"<<endl;
        cout<<"2 ��ͨ��"<<endl;
        int flag;
        cin>>flag;
        if(flag==1){
            //ͨ��
            of->m_orderData[select].at("status") = "ͨ��";
            //of->printMap();
            unCheck[select].at("status")= "ͨ��";
            of->updateOrder();
        }else if(flag==2){
            //��ͨ��
            of->m_orderData[select].at("status") = "��ͨ��";
            //of->printMap();
            unCheck[select].at("status")= "��ͨ��";
            of->updateOrder();
        }else{
            //�û�����������
            cout<<"��������������"<<endl;
            return;
        }
    }

};

#endif // TEACHER_H_INCLUDED
