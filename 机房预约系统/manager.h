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
    //ѡ��˵�
    virtual void operMenu(){
        cout<<"��ӭ����Ա��"<<this->m_Name<<"��¼"<<endl;
        cout<<"\t\t------------------------\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     1 ����˺�       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     2 �鿴�˺�       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     3 �鿴����       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     4 ���ԤԼ       |\n";
        cout<<"\t\t|                       |\n";
        cout<<"\t\t|     0 ע����¼       |\n";
        cout<<"\t\t------------------------\n";
        cout<<"��ѡ�����Ĳ���"<<endl;
    }
    //����˺�
    void addPerson(){
        cout<<"����������˺ŵ����ͣ�"<<endl;
        cout<<"1 ���ѧ��"<<endl;
        cout<<"2 �����ʦ"<<endl;

        string filename;
        string tip;
        string errorTip;
        ofstream ofs;
        int select = 0;
        cin>>select;
        if(select==1){
            //���ѧ��
            filename = STUDENT_FILE;
            tip = "������ѧ�ţ�";
            errorTip = "ѧ���ظ�����������д";
        }else if(select ==2 ){
            //��ӽ�ʦ
            filename = TEACHER_FILE;
            tip = "������ְ����ţ�";
            errorTip = "ְ������ظ�����������д";
        }else{
            //��������
            cout<<"������������"<<endl;
        }
        int id;
        string name;
        string pwd;
        cout<<tip<<endl;
        while(true){
            cin>>id;
            //ѧ�Ż���ְ��������󣬽����ظ�����
            bool ret = checkRepeat(id,select);
            if(ret==true){
                //�ظ�
                cout<<errorTip<<endl;
                cout<<"���������룺"<<endl;
            }else{
                break;
            }
        }
        cout<<"������������"<<endl;
        cin>>name;
        cout<<"���������룺"<<endl;
        cin>>pwd;
        ofs.open(filename,ios::out|ios::app);
        ofs<<id<<" "<<name<<" "<<pwd<<endl;
        this->initVector();
        cout<<"��ӳɹ���"<<endl;
        system("pause");
        system("cls");
        ofs.close();
    }
    //�鿴�˺�
    void printStudent(student &s){
        cout<<" ѧ�ţ�"<<s.id<<" ������"<<s.m_Name<<" ���룺"<<s.m_Password<<endl;
    }
    void printTeacher(teacher &t){
        cout<<" ���ţ�"<<t.empId<<" ������"<<t.m_Name<<" ���룺"<<t.m_Password<<endl;
    }
    void showPerson(){
        while(true){
            cout<<"��ѡ��鿴���ݣ�"<<endl;
            cout<<"1 ѧ��"<<endl;
            cout<<"2 ��ʦ"<<endl;
            int select = 0;
            cin>>select;
            if(select==1){
                //�鿴ѧ��
                for(vector<student>::iterator it = vStu.begin();it!=vStu.end();it++){
                    printStudent(*it);
                }
                break;
            }else if(select==2){
                //�鿴��ʦ
                for(vector<teacher>::iterator it = vTea.begin();it!=vTea.end();it++){
                    printTeacher(*it);
                }
                break;
            }else{
                //��������
                cout<<"��������"<<endl;
            }
        }
    }
    void printComputerRoom(computerRoom& cr){
        cout<<"������Ϊ��"<<cr.m_ComId<<" �������������Ϊ��"<<cr.m_MaxNum<<endl;
    }
    //�鿴������Ϣ
    void showComputer(){
        for(vector<computerRoom>::iterator it= vCom.begin();it!=vCom.end();it++){
            printComputerRoom(*it);
        }
    }
    //���ԤԼ��¼
    void cleanFile(){
        ofstream ofs;
        ofs.open(ORDER_FILE,ios::trunc);
        ofs.close();
        cout<<"��ճɹ�"<<endl;
        system("pause");
        system("cls");
    }
    vector<student> vStu;//ѧ������
    vector<teacher> vTea;//��ʦ����
    vector<computerRoom> vCom;//��������
    void initVector(){
        //��ʼ������
        //��ȡѧ����Ϣ
        ifstream ifs;
        ifs.open(STUDENT_FILE,ios::in);
        if(!ifs.is_open()){
            cout<<"�ļ���ȡʧ�ܣ�"<<endl;
            return;
        }
        vStu.clear();
        vTea.clear();

        student s;
        while(ifs>>s.id&&ifs>>s.m_Name&&ifs>>s.m_Password){
            vStu.push_back(s);
        }
        cout<<"��ǰѧ������Ϊ��"<<vStu.size()<<endl;
        ifs.close();
        //��ȡ��ʦ��Ϣ
        ifs.open(TEACHER_FILE,ios::in);
        teacher t ;
        while(ifs>>t.empId&&ifs>>t.m_Name&&ifs>>t.m_Password){
            vTea.push_back(t);
        }
        cout<<"��ǰ��ʦ����Ϊ��"<<vTea.size()<<endl;
        ifs.close();
        //��ʼ��������Ϣ
        ifs.open(COMPUTER_FILE,ios::in);
        computerRoom cr;
        while(ifs>>cr.m_ComId&&ifs>>cr.m_MaxNum){
            vCom.push_back(cr);
        }
        cout<<"��ǰ��������Ϊ��"<<vCom.size()<<endl;
        ifs.close();
    }
    bool checkRepeat(int id,int type){
        //id������    type��person����
        if(type==1){
            //��ѧ��
            for(vector<student>::iterator it = vStu.begin();it!=vStu.end();it++){
                if(id==it->id){
                    return true;
                }
            }
        }else if(type==2){
            //��ʦ
            for(vector<teacher>::iterator it = vTea.begin();it!=vTea.end();it++){
                if(id==it->empId){
                    return true;
                }
            }
        }else{
            //��������
            cout<<"��������"<<endl;

        }
    }
};


#endif // MANAGER_H_INCLUDED
