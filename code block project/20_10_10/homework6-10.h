#ifndef HOMEWORK6-10_H_INCLUDED
#define HOMEWORK6-10_H_INCLUDED
#include <iostream>
using namespace std;

class employee{
    string name;
    int empNum;
    int job_level;
    int money;
    virtual void pay(int qingjia_day){

    }
};

class manager:public employee{
    int ship_money;//����
    float yejixishu;
    float yeji_money(){
        return ship_money*yejixishu;
    }
    void pay(int qingjia_day){
        //�����ܶ�=��������+ҵ������
    }
};

class technician:public employee{
    int fujia_money;
    int job_day;
    float wanchengxishu;
    void pay(int qingjia_day){
        //�����ܶ�=��������+ҵ������
    }
    float yeji_money(){
        return fujia_money*job_day*wanchengxishu;
    }
};

class salesman:public employee{
    int sale_num;//���۶�
    int money_rate;//�����ȡ�ٷֱ�
    int yeji_money(){
        return sale_num*money_rate;
    }
    void pay(){
            //�����ܶ�=��������+ҵ������
    }
};

class developermanager:public manager,technician{
    void pay(){

    }
    float yeji_money(){
        //��Ϊ����ͼ�����Աҵ������֮�͵�һ����Ϊҵ������
    }
};

class salesmanager:public manager,salesman{

};

#endif // HOMEWORK6-10_H_INCLUDED
