#ifndef COMPUTER_H_INCLUDED
#define COMPUTER_H_INCLUDED

#include <iostream>
using namespace std;

//cpu�ӿ�
class CPU{
public:
    virtual void caculate() = 0;
};
//�Կ��ӿ�
class VideoCard{
public:
    virtual void display() = 0;
};
//�ڴ�ӿ�
class Memory{
public:
    virtual void storage() = 0;
};


//Intel����
class Intel_cpu:public CPU
{
public:
    void caculate(){
        cout<<"intel��cpu��ʼ������"<<endl;
    }
};
class Intel_VideoCard:public VideoCard
{
public:
    void display(){
        cout<<"intel���Կ�������ʾ"<<endl;
    }
};
class Intel_Memory:public Memory
{
public:
    void storage(){
        cout<<"intel���ڴ������ڴ洢"<<endl;
    }
};
//lenovo����
class Lenovo_cpu:public CPU
{
public:
    void caculate(){
        cout<<"lenovo��cpu���ڼ���"<<endl;
    }
};
class Lenovo_VideoCard:public VideoCard
{
public:
    void display(){
        cout<<"lenovo���Կ�������ʾ"<<endl;
    }
};
class Lenovo_Memory:public Memory
{
public:
    void storage(){
        cout<<"lenovo���ڴ������ڴ洢"<<endl;
    }
};


class computer{
public:
    CPU* cpu;
    VideoCard* vc;
    Memory* memory;
    computer(){};
    computer(CPU *cpu,VideoCard *vc,Memory* memory){
        this->cpu = cpu;
        this->memory = memory;
        this->vc = vc;
    }
};
#endif // COMPUTER_H_INCLUDED
