#ifndef EMP_MANAGER_H_INCLUDED
#define EMP_MANAGER_H_INCLUDED
#include "fstream"
#include <iostream>
#include "string"
using namespace std;

string position1 = "普通职工";
string position2 = "经理";
string position3 = "老板";
string duty1 = "完成经理交给的任务";
string duty2 = "完成老板交给的任务，并下发任务给员工";
string duty3 = "管理公司所有事务";


class employee
{
public:
    int emp_num;//职工编号
    string emp_name;//职工姓名
    string emp_position;//职工岗位
    string emp_duty;//职工职责
    //employee* e_array;

    //交换
    void Swap(employee& e1,employee& e2){
        employee temp ;
        temp.emp_num=e1.emp_num;
        temp.emp_name=e1.emp_name;
        temp.emp_position=e1.emp_position;
        temp.emp_duty=e1.emp_duty;

        e1.emp_num=e2.emp_num;
        e1.emp_name=e2.emp_name;
        e1.emp_position=e2.emp_position;
        e1.emp_duty=e2.emp_duty;

        e2.emp_num=temp.emp_num;
        e2.emp_name=temp.emp_name;
        e2.emp_position=temp.emp_position;
        e2.emp_duty=temp.emp_duty;
    }
    //获取人数
    int getNum(){
        ifstream ifs;
        ifs.open("emp.txt",ios::in);
        int num = 0;
        string name;
        string position;
        string duty;
        while(ifs>>num&&ifs>>name&&ifs>>position&&ifs>>duty){
            num++;
        }
        return num;
    }

    //显示菜单
    void show_menu(){
        cout<<"****************************"<<endl;
        cout<<"******0 退出职工系统******"<<endl;
        cout<<"******1 增加职工信息******"<<endl;
        cout<<"******2 显示职工信息******"<<endl;
        cout<<"******3 删除离职职工******"<<endl;
        cout<<"******4 修改职工信息******"<<endl;
        cout<<"******5 查找职工信息******"<<endl;
        cout<<"******6 按照编号排序******"<<endl;
        cout<<"******7 清空所有文档******"<<endl;
        cout<<"****************************"<<endl;
    }
    //显示员工
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
        int num ;
        string name;
        string position;
        string duty;
        cout<<"请输入员工编号："<<endl;
        cin>>num;
        cout<<"请输入员工姓名："<<endl;
        cin>>name;
        cout<<"请选择员工职位："<<endl;
        cout<<1<<position1<<endl;
        cout<<2<<position2<<endl;
        cout<<3<<position1<<endl;
        int flag;
        cin>>flag;
        if(flag==1){
            position = position1;
        }else if(flag==2){
            position = position2;
        }else if(flag==3){
            position = position3;
        }else{
            cout<<"您的输入有问题"<<endl;
            return;
        }
        cout<<"请选择员工职责："<<endl;
        cout<<1<<duty1<<endl;
        cout<<2<<duty2<<endl;
        cout<<3<<duty3<<endl;
        cin>>flag;
        if(flag==1){
            duty = duty1;
        }else if(flag==2){
            duty = duty2;
        }else if(flag==3){
            duty = duty3;
        }else{
            cout<<"您的输入有问题"<<endl;
        }
        ofstream ofs;
        ofs.open("emp.txt",ios::app);
        ofs<<num<<" "<<name<<" "<<position<<" "<<duty<<endl;//需要重载<<
        ofs.close();
    }
    //删除离职员工
    void delete_emp(){
        cout<<"请输入离职员工的编号"<<endl;
        int delete_num;
        cin>>delete_num;
        ifstream ifs;
        ifs.open("emp.txt",ios::in);
        int num;
        string name;
        string position;
        string duty;
        int arrSize = getNum()-1;
        employee* e_arr = new employee[arrSize];
        int index = 0;
        while(ifs>>num&&ifs>>name&&ifs>>position&&ifs>>duty){
            if(num!=delete_num){
                employee e;
                e.emp_num = num;
                e.emp_name = name;
                e.emp_position = position;
                e.emp_duty = duty;
                e_arr[index] = e;
                index++;
                //cout<<index<<endl;
            }
        }
        ifs.close();
        //将删除后额员工添加到文件
        ofstream ofs("emp.txt",ios::out|ios::trunc);
        for(int i=0;i<arrSize-1;i++){
            //cout<<"写文件了"<<endl;
            ofs<<e_arr[i].emp_num<<" "<<e_arr[i].emp_name<<" "<<e_arr[i].emp_position<<" "<<e_arr[i].emp_duty<<endl;//需要重载<<
        }
        ofs.close();
        delete e_arr;
    }
    //按照编号修改员工信息
    void edit_emp(){
        cout<<"请输入要修改的员工的编号："<<endl;
        int edit_num;
        cin>>edit_num;
        //获取文件中的所有信息
        ifstream ifs;
        ifs.open("emp.txt",ios::in);
        int num;
        string name;
        string position;
        string duty;
        int arrSize = getNum();
        employee* e_arr = new employee[arrSize];
        int index = 0;
        while(ifs>>num&&ifs>>name&&ifs>>position&&ifs>>duty){
            employee e;
            e.emp_num = num;
            e.emp_name = name;
            e.emp_position = position;
            e.emp_duty = duty;
            cout<<index<<endl;
            if(num==edit_num){
                cout<<"请输入员工姓名："<<endl;
                string edit_name;
                cin>>edit_name;
                e.emp_name = edit_name;
                cout<<"请选择员工职位："<<endl;
                cout<<1<<position1<<endl;
                cout<<2<<position2<<endl;
                cout<<3<<position1<<endl;
                int flag;
                cin>>flag;
                if(flag==1){
                    e.emp_position = position1;
                }else if(flag==2){
                    e.emp_position = position2;
                }else if(flag==3){
                    e.emp_position = position3;
                }else{
                    cout<<"您的输入有问题"<<endl;
                    break;
                }
                cout<<"请选择员工职责："<<endl;
                cout<<1<<duty1<<endl;
                cout<<2<<duty2<<endl;
                cout<<3<<duty3<<endl;
                cin>>flag;
                string edit_duty;
                if(flag==1){
                    e.emp_duty = duty1;
                }else if(flag==2){
                    e.emp_duty = duty2;
                }else if(flag==3){
                    e.emp_duty = duty3;
                }else{
                    cout<<"您的输入有问题"<<endl;
                }
            }
            e_arr[index] = e;
            index++;
        }
        ifs.close();
        //将修改后的数组，重新写入文件
         ofstream ofs("emp.txt",ios::out|ios::trunc);
        for(int i=0;i<arrSize;i++){
            //cout<<"写文件了"<<endl;
            ofs<<e_arr[i].emp_num<<" "<<e_arr[i].emp_name<<" "<<e_arr[i].emp_position<<" "<<e_arr[i].emp_duty<<endl;//需要重载<<
        }
        ofs.close();
        delete e_arr;
    }
    void findEmpNyNum(){
        cout<<"请输入要查询的员工编号"<<endl;
        int find_num;
        cin>>find_num;
        int num;
        string name;
        string position;
        string duty;
        int arrSize = getNum();
        employee* e_arr = new employee[arrSize];
        int index = 0;
        employee e;
        ifstream ifs;
        ifs.open("emp.txt",ios::in);
        while(ifs>>num&&ifs>>name&&ifs>>position&&ifs>>duty){
            if(num==find_num){
                e.emp_num = num;
                e.emp_name = name;
                e.emp_position = position;
                e.emp_duty = duty;
            }
        }
        cout<<e.emp_num<<" "<<e.emp_name<<" "<<e.emp_position<<" "<<e.emp_duty<<endl;
    }
    //按照编号排序
    void sortByNum(){
        ifstream ifs;
        ifs.open("emp.txt",ios::in);
        int num;
        string name;
        string position;
        string duty;
        int arrSize = getNum();
        employee* e_arr = new employee[arrSize];
        int index = 0;
        while(ifs>>num&&ifs>>name&&ifs>>position&&ifs>>duty){
                employee e;
                e.emp_num = num;
                e.emp_name = name;
                e.emp_position = position;
                e.emp_duty = duty;
                e_arr[index] = e;
                index++;
                //cout<<index<<endl;
        }
        ifs.close();
        //进行排序操作，升序排列
        int i,j;
        //i是次数，也即排好的个数;j是继续排
        for(i=1;i<arrSize;++i){
           for(j=i;j>0;--j){
               if(e_arr[j].emp_num<e_arr[j-1].emp_num){
                    Swap(e_arr[j],e_arr[j-1]);
               }else{
                    break;
               }
           }
        }
         //将修改后的数组，重新写入文件
        ofstream ofs("emp.txt",ios::out|ios::trunc);
        for(int i=0;i<arrSize;i++){
            //cout<<"写文件了"<<endl;
            ofs<<e_arr[i].emp_num<<" "<<e_arr[i].emp_name<<" "<<e_arr[i].emp_position<<" "<<e_arr[i].emp_duty<<endl;//需要重载<<
        }
        ofs.close();
        delete e_arr;
    }
    //清空文档
    void clear_emp(){
        ofstream ofs("emp.txt",ios::out|ios::trunc);
        ofs.close();
    }
};


#endif // EMP_MANAGER_H_INCLUDED
