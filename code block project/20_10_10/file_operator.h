#ifndef FILE_OPERATOR_H_INCLUDED
#define FILE_OPERATOR_H_INCLUDED
#include "fstream"
#include <iostream>
#include <string>
using namespace std;

void test01(){
    ofstream ofs;
    ofs.open("test.txt",ios::out);
    ofs<<"任章哲创建的文件"<<endl;
    ofs<<"文件名时路欣静"<<endl;
    ofs.close();
}

void test02(){
    ifstream ifs ;
    ifs.open("test.txt",ios::in);
    if(!ifs.is_open()){
        cout<<"文件打开失败"<<endl;
        return;
    }
    //第一种
    /*
    char buf[1024] = {0};
    while(ifs>>buf){//用ifs将数据放到buf中，正常读入返回true，读到最后结束后返回false
        cout<<buf<<endl;
    }
    //ifs.close();

    //第二种

    char buf[1024] = {0};
    while(ifs.getline(buf,sizeof(buf))){
        cout<<buf<<endl;
    }
    //第三种

    string buf;
    while(getline(ifs,buf)){
        cout<<buf<<endl;
    }*/
    //第四种
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
    //1 创建对象
    ofstream  ofs;
    //2 打开文件
    ofs.open("person.txt",ios::out | ios::binary);
    person p;
    p.age = 18;
    p.name = "路欣静";
    //3 写入
    ofs.write((const char*)&p,sizeof(person));
    //4 关闭文件流
    ofs.close();
}

void test04(){
    //1 包含头文件
    //2 创建流对象
    ifstream ifs ;
    //3 打开文件 并且需要判断文件打开是否成功
    ifs.open("person.txt",ios::in|ios::binary);
    if(!ifs.is_open()){
        cout<<"文件打开失败"<<endl;
        return ;
    }
    //4 读文件
    person p ;
    ifs.read((char*)&p,sizeof(person));
    cout<<p.name<<endl;
    cout<<p.age<<endl;
    //5 关闭流对象
    ifs.close();

}
#endif // FILE_OPERATOR_H_INCLUDED
