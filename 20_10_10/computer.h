#ifndef COMPUTER_H_INCLUDED
#define COMPUTER_H_INCLUDED

#include <iostream>
using namespace std;

//cpu接口
class CPU{
public:
    virtual void caculate() = 0;
};
//显卡接口
class VideoCard{
public:
    virtual void display() = 0;
};
//内存接口
class Memory{
public:
    virtual void storage() = 0;
};


//Intel厂商
class Intel_cpu:public CPU
{
public:
    void caculate(){
        cout<<"intel的cpu开始计算了"<<endl;
    }
};
class Intel_VideoCard:public VideoCard
{
public:
    void display(){
        cout<<"intel的显卡正在显示"<<endl;
    }
};
class Intel_Memory:public Memory
{
public:
    void storage(){
        cout<<"intel的内存条正在存储"<<endl;
    }
};
//lenovo厂商
class Lenovo_cpu:public CPU
{
public:
    void caculate(){
        cout<<"lenovo的cpu正在计算"<<endl;
    }
};
class Lenovo_VideoCard:public VideoCard
{
public:
    void display(){
        cout<<"lenovo的显卡正在显示"<<endl;
    }
};
class Lenovo_Memory:public Memory
{
public:
    void storage(){
        cout<<"lenovo的内存条正在存储"<<endl;
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
