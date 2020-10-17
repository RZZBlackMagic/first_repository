#ifndef EMP_MANAGER_H_INCLUDED
#define EMP_MANAGER_H_INCLUDED
#include "fstream"
#include <iostream>
using namespace std;

class employee
{
    int emp_num;//职工编号
    char* emp_name;//职工姓名
    char* emp_position;//职工岗位
    char* emp_duty;//职工职责
    void display(){
        //读取文件中的信息
        ifstream ifs;
        ifs.open("emp.txt",ios::in);
        if(!ifs.is_open()){
            cout<<"文件打开失败"<<endl;
            return ;
        }
        char buf[1024] = {0};
        while(ifs.getline(buf,sizeof(buf))){
            cout<<buf<<endl;
        }
    }
    //添加员工
    void add_emp(){
        ofstream ofs;
        ofs.open("emp.txt",ios::app);
        ofs<<this->emp_num<<" "<<this->emp_name<<" "<<this->emp_position<<" "<<this->emp_duty<<endl;//需要重载<<
        ofs.close();
    }
};


#endif // EMP_MANAGER_H_INCLUDED
