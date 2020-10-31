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
    int ship_money;//奖金
    float yejixishu;
    float yeji_money(){
        return ship_money*yejixishu;
    }
    void pay(int qingjia_day){
        //工资总额=基本工资+业绩工资
    }
};

class technician:public employee{
    int fujia_money;
    int job_day;
    float wanchengxishu;
    void pay(int qingjia_day){
        //工资总额=基本工资+业绩工资
    }
    float yeji_money(){
        return fujia_money*job_day*wanchengxishu;
    }
};

class salesman:public employee{
    int sale_num;//销售额
    int money_rate;//酬金提取百分比
    int yeji_money(){
        return sale_num*money_rate;
    }
    void pay(){
            //工资总额=基本工资+业绩工资
    }
};

class developermanager:public manager,technician{
    void pay(){

    }
    float yeji_money(){
        //作为经理和技术人员业绩工资之和的一半作为业绩工资
    }
};

class salesmanager:public manager,salesman{

};

#endif // HOMEWORK6-10_H_INCLUDED
