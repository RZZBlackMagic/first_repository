#ifndef EMP_MANAGER_H_INCLUDED
#define EMP_MANAGER_H_INCLUDED
#include "fstream"
#include <iostream>
using namespace std;

class employee
{
    int emp_num;//ְ�����
    char* emp_name;//ְ������
    char* emp_position;//ְ����λ
    char* emp_duty;//ְ��ְ��
    void display(){
        //��ȡ�ļ��е���Ϣ
        ifstream ifs;
        ifs.open("emp.txt",ios::in);
        if(!ifs.is_open()){
            cout<<"�ļ���ʧ��"<<endl;
            return ;
        }
        char buf[1024] = {0};
        while(ifs.getline(buf,sizeof(buf))){
            cout<<buf<<endl;
        }
    }
    //���Ա��
    void add_emp(){
        ofstream ofs;
        ofs.open("emp.txt",ios::app);
        ofs<<this->emp_num<<" "<<this->emp_name<<" "<<this->emp_position<<" "<<this->emp_duty<<endl;//��Ҫ����<<
        ofs.close();
    }
};


#endif // EMP_MANAGER_H_INCLUDED
