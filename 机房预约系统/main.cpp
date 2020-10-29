#include <iostream>
#include "globalFile.h"
#include "ideatity.h"
#include "fstream"
#include "student.h"
#include "teacher.h"
#include "manager.h"
using namespace std;


void  studentMenu(identity* &student1){
    while(true){
        //ѧ���˵�
        student1->operMenu();
        student* stu = (student*)student1;
        int select;
        cout<<"���������ѡ��"<<endl;
        cin>>select;
        if(select==1){
            //����ԤԼ
            stu->applyOrder();
        }else if(select==2){
            //�鿴�ҵ�ԤԼ
            stu->showAMyOrder();
        }else if(select==3){
            //�鿴����ԤԼ
            stu->showAllOrder();
        }else if(select==4){
            //ȡ��ԤԼ
            stu->cancelOrder();
        }else{
            //ע����¼
            cout<<"ע���ɹ�"<<endl;
            system("pause");
            system("cls");
            break;
        }
    }
}
void managerMenu(identity* &manager1){
    while(true){
        //����Ա�˵�
        manager1->operMenu();

        manager * man = (manager *)manager1;
        int select;
        cin>>select;
        if(select==1){
            //����˺�
            man->addPerson();
        }else if(select == 2){
            //�鿴�˺�
            man->showPerson();
        }else if(select ==3){
            //�鿴����
            man->showComputer();
        }else if(select ==4){
            //���ԤԼ
            man->cleanFile();
        }else{
            //ע������
            delete manager1;
            cout<<"ע���ɹ�"<<endl;
            system("pause");
            system("cls");
            return ;
        }
    }
}

void loginIn(string filename,int type){//filename���������ļ�����type:��¼�����
    identity* person = NULL;

    ifstream ifs;
    ifs.open(filename,ios::in);

    if(!ifs.is_open()){
        cout<<"�ļ�������"<<endl;
        ifs.close();
        return ;
    }
    int id = 0;
    string name;
    string password;

    if(type==1){
        //ѧ����¼
        cout<<"����������ѧ��"<<endl;
        cin>>id;
    }else if(type==2){
        cout<<"���������Ĺ���"<<endl;
        cin>>id;
        //��ʦ��¼
    }else if(type==3){
        //����Ա��¼
        cout<<"���������Ĺ��ţ�"<<endl;
        cin>>id;
    }else{
        //��������
        cout<<"������������"<<endl;
    }
    cout<<"����������������"<<endl;
    cin>>name;
    cout<<"�������������룺"<<endl;
    cin>>password;
    int fId;
    string fName;
    string fPwd;
    if(type==1){
        //����ѧ����¼��֤
        while(ifs>>fId&&ifs>>fName&&ifs>>fPwd){
            cout<<fId<<endl;
            cout<<fName<<endl;
            cout<<fPwd<<endl;
            if(id==fId&&name==fName&&password==fPwd){
                cout<<"ѧ����֤��¼�ɹ���"<<endl;
                system("pause");
                system("cls");
                person = new student(fId,fName,fPwd);
                //��¼�ɹ�������ѧ�����Ӳ˵�
                studentMenu(person);
                return;
            }
        }
    }else if(type==2){
        //���н�ʦ��¼��֤
        while(ifs>>fId&&ifs>>fName&&ifs>>fPwd){
            if(id==fId&&name==fName&&password==fPwd){
                cout<<"��ʦ��֤��¼�ɹ���"<<endl;
                system("pause");
                system("cls");
                person = new teacher(fId,fName,fPwd);
                //��¼�ɹ�������ѧ�����Ӳ˵�
                return;
            }
        }
    }else if(type==3){
        //���й���Ա��¼��֤
        while(ifs>>fId&&ifs>>fName&&ifs>>fPwd){
            if(id==fId&&name==fName&&password==fPwd){
                cout<<"����Ա��֤��¼�ɹ���"<<endl;
                system("pause");
                system("cls");
                person = new manager(fName,fPwd);
                //��¼�ɹ�������ѧ�����Ӳ˵�
                managerMenu(person);
                return;
            }
        }
    }else{
        cout<<"������������"<<endl;
    }
    cout<<"��֤��¼ʧ��"<<endl;
    system("pause");
    return ;
}

int main()
{
    int select = 0;
    while(true){
        cout<<"***********��ӭ��������ԤԼϵͳ*************"<<endl;
        cout<<endl<<"��ѡ��������ݣ�"<<endl;
        cout<< "\t\t ------------------\n";
        cout<< "\t\t|                  |\n";
        cout<<"\t\t|    1 ѧ������    |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t|    2 ��ʦ        |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t|    3 ����Ա      |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t|    0 �˳�        |\n";
        cout<< "\t\t|                  |\n";
        cout<< "\t\t ------------------\n";
        cout<<"����������ѡ��"<<endl;
        cin>>select;
        switch(select)
        {
        case 1:
            //ѧ��
            loginIn(STUDENT_FILE,select);
            break;
        case 2:
            //��ʦ
            loginIn(TEACHER_FILE,select);
            break;
        case 3:
            //����Ա
            loginIn(ADMIN_FILE,select);
            break;
        case 0:
            //�˳�
            cout<<"��ӭ�´�ʹ��"<<endl;
            system("pause");
            return 0;
            break;
        default:
            cout<<"��������������ѡ��"<<endl;
            system("pause");
            system("cls");
            break;
        }
    }
    return 0;
}
