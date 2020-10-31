#ifndef FILE_OPERATOR_H_INCLUDED
#define FILE_OPERATOR_H_INCLUDED
#include "fstream"
#include <iostream>
#include <string>
using namespace std;

void test01(){
    ofstream ofs;
    ofs.open("test.txt",ios::out);
    ofs<<"�����ܴ������ļ�"<<endl;
    ofs<<"�ļ���ʱ·����"<<endl;
    ofs.close();
}

void test02(){
    ifstream ifs ;
    ifs.open("test.txt",ios::in);
    if(!ifs.is_open()){
        cout<<"�ļ���ʧ��"<<endl;
        return;
    }
    //��һ��
    /*
    char buf[1024] = {0};
    while(ifs>>buf){//��ifs�����ݷŵ�buf�У��������뷵��true�������������󷵻�false
        cout<<buf<<endl;
    }
    //ifs.close();

    //�ڶ���

    char buf[1024] = {0};
    while(ifs.getline(buf,sizeof(buf))){
        cout<<buf<<endl;
    }
    //������

    string buf;
    while(getline(ifs,buf)){
        cout<<buf<<endl;
    }*/
    //������
    char c;
    while((c = ifs.get())!=EOF){//EOF:end of file
        cout<<c;
    }
    ifs.close();
}


class person{
public:
    char* name;
    int age;
};
void test03(){
    //1 ��������
    ofstream  ofs;
    //2 ���ļ�
    ofs.open("person.txt",ios::out | ios::binary);
    person p;
    p.age = 18;
    p.name = "·����";
    //3 д��
    ofs.write((const char*)&p,sizeof(person));
    //4 �ر��ļ���
    ofs.close();
}

void test04(){
    //1 ����ͷ�ļ�
    //2 ����������
    ifstream ifs ;
    //3 ���ļ� ������Ҫ�ж��ļ����Ƿ�ɹ�
    ifs.open("person.txt",ios::in|ios::binary);
    if(!ifs.is_open()){
        cout<<"�ļ���ʧ��"<<endl;
        return ;
    }
    //4 ���ļ�
    person p ;
    ifs.read((char*)&p,sizeof(person));
    cout<<p.name<<endl;
    cout<<p.age<<endl;
    //5 �ر�������
    ifs.close();

}
#endif // FILE_OPERATOR_H_INCLUDED
