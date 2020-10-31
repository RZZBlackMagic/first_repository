#ifndef EMP_MANAGER_H_INCLUDED
#define EMP_MANAGER_H_INCLUDED
#include "fstream"
#include <iostream>
#include "string"
using namespace std;

string position1 = "��ְͨ��";
string position2 = "����";
string position3 = "�ϰ�";
string duty1 = "��ɾ�����������";
string duty2 = "����ϰ彻�������񣬲��·������Ա��";
string duty3 = "����˾��������";


class employee
{
public:
    int emp_num;//ְ�����
    string emp_name;//ְ������
    string emp_position;//ְ����λ
    string emp_duty;//ְ��ְ��
    //employee* e_array;

    //����
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
    //��ȡ����
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

    //��ʾ�˵�
    void show_menu(){
        cout<<"****************************"<<endl;
        cout<<"******0 �˳�ְ��ϵͳ******"<<endl;
        cout<<"******1 ����ְ����Ϣ******"<<endl;
        cout<<"******2 ��ʾְ����Ϣ******"<<endl;
        cout<<"******3 ɾ����ְְ��******"<<endl;
        cout<<"******4 �޸�ְ����Ϣ******"<<endl;
        cout<<"******5 ����ְ����Ϣ******"<<endl;
        cout<<"******6 ���ձ������******"<<endl;
        cout<<"******7 ��������ĵ�******"<<endl;
        cout<<"****************************"<<endl;
    }
    //��ʾԱ��
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
        int num ;
        string name;
        string position;
        string duty;
        cout<<"������Ա����ţ�"<<endl;
        cin>>num;
        cout<<"������Ա��������"<<endl;
        cin>>name;
        cout<<"��ѡ��Ա��ְλ��"<<endl;
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
            cout<<"��������������"<<endl;
            return;
        }
        cout<<"��ѡ��Ա��ְ��"<<endl;
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
            cout<<"��������������"<<endl;
        }
        ofstream ofs;
        ofs.open("emp.txt",ios::app);
        ofs<<num<<" "<<name<<" "<<position<<" "<<duty<<endl;//��Ҫ����<<
        ofs.close();
    }
    //ɾ����ְԱ��
    void delete_emp(){
        cout<<"��������ְԱ���ı��"<<endl;
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
        //��ɾ�����Ա����ӵ��ļ�
        ofstream ofs("emp.txt",ios::out|ios::trunc);
        for(int i=0;i<arrSize-1;i++){
            //cout<<"д�ļ���"<<endl;
            ofs<<e_arr[i].emp_num<<" "<<e_arr[i].emp_name<<" "<<e_arr[i].emp_position<<" "<<e_arr[i].emp_duty<<endl;//��Ҫ����<<
        }
        ofs.close();
        delete e_arr;
    }
    //���ձ���޸�Ա����Ϣ
    void edit_emp(){
        cout<<"������Ҫ�޸ĵ�Ա���ı�ţ�"<<endl;
        int edit_num;
        cin>>edit_num;
        //��ȡ�ļ��е�������Ϣ
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
                cout<<"������Ա��������"<<endl;
                string edit_name;
                cin>>edit_name;
                e.emp_name = edit_name;
                cout<<"��ѡ��Ա��ְλ��"<<endl;
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
                    cout<<"��������������"<<endl;
                    break;
                }
                cout<<"��ѡ��Ա��ְ��"<<endl;
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
                    cout<<"��������������"<<endl;
                }
            }
            e_arr[index] = e;
            index++;
        }
        ifs.close();
        //���޸ĺ�����飬����д���ļ�
         ofstream ofs("emp.txt",ios::out|ios::trunc);
        for(int i=0;i<arrSize;i++){
            //cout<<"д�ļ���"<<endl;
            ofs<<e_arr[i].emp_num<<" "<<e_arr[i].emp_name<<" "<<e_arr[i].emp_position<<" "<<e_arr[i].emp_duty<<endl;//��Ҫ����<<
        }
        ofs.close();
        delete e_arr;
    }
    void findEmpNyNum(){
        cout<<"������Ҫ��ѯ��Ա�����"<<endl;
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
    //���ձ������
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
        //���������������������
        int i,j;
        //i�Ǵ�����Ҳ���źõĸ���;j�Ǽ�����
        for(i=1;i<arrSize;++i){
           for(j=i;j>0;--j){
               if(e_arr[j].emp_num<e_arr[j-1].emp_num){
                    Swap(e_arr[j],e_arr[j-1]);
               }else{
                    break;
               }
           }
        }
         //���޸ĺ�����飬����д���ļ�
        ofstream ofs("emp.txt",ios::out|ios::trunc);
        for(int i=0;i<arrSize;i++){
            //cout<<"д�ļ���"<<endl;
            ofs<<e_arr[i].emp_num<<" "<<e_arr[i].emp_name<<" "<<e_arr[i].emp_position<<" "<<e_arr[i].emp_duty<<endl;//��Ҫ����<<
        }
        ofs.close();
        delete e_arr;
    }
    //����ĵ�
    void clear_emp(){
        ofstream ofs("emp.txt",ios::out|ios::trunc);
        ofs.close();
    }
};


#endif // EMP_MANAGER_H_INCLUDED
