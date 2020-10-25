#ifndef SPEECH_MANAGER_H_INCLUDED
#define SPEECH_MANAGER_H_INCLUDED
#include <iostream>
#include "map"
#include "algorithm"
#include "speech_actor.h"
#include "string"
#include "vector"
#include "math.h"
using namespace std;
/*
提供菜单界面与用户交互
对演讲比赛流程进行控制
与文件的读写交互
*/
class SpeechManager{
public:
    SpeechManager(){
        initSpeech();
        createSpeaker();
    }
    ~SpeechManager(){

    }
    //菜单功能
    void show_Menu(){
        cout<<"**************************"<<endl;
        cout<<"****欢迎参加演讲比赛****"<<endl;
        cout<<"****1 开始演讲比赛******"<<endl;
        cout<<"****2 查看往届记录******"<<endl;
        cout<<"****3 清空比赛记录******"<<endl;
        cout<<"****0 退出比赛程序******"<<endl;
        cout<<"**************************"<<endl;
    }
    //退出功能
    void exit_speech(){
        cout<<"欢迎下次使用"<<endl;
        system("pause");//清屏
        exit(0);
    }
    vector<int> v1;//第一轮选手容器
    vector<int> v2;//第二轮选手容器
    vector<int> victory;//胜利选手容器
    int index;//记录比赛轮数
    map<int,Speaker> m;//存放编号及对应的选手

    void initSpeech(){
        this->v1.clear();
        this->v2.clear();
        this->victory.clear();
        this->index=1;
        this->m.clear();
    }
    void createSpeaker(){
        string nameSeed = "ABCDEFGHIJKL";
        for(int i=0;i<12;i++){
            string name = "选手";
            name = name + nameSeed[i];
            Speaker sp;
            sp.s_name = name;
            for(int j=0;j<2;j++){
                sp.s_score[j] = 0;
            }
            v1.push_back(i+10000);
            m.insert(make_pair((i+10000),sp));
        }
    }
    //抽签
    void random_function(){
        cout<<"第"<<this->index<<"轮比赛抽签。。。"<<endl;
        if(index==1){
            cout<<"*****************"<<endl;
            random_shuffle(v1.begin(),v1.end());
        }else{
            cout<<"*****************"<<endl;
            random_shuffle(v2.begin(),v2.end());
        }
    }
    //比赛‘(rand()% (b-a+1))+ a
    void speech_context(){
        int a = 60;
        int b = 90;
        srand(11);
        vector<double> pingwei;
        pingwei.resize(10);
        map<double,int> temp1;//放第一组
        map<double,int> temp2;//放第二组
        if(index==1){
            //第一轮比赛
            for(int j=0;j<12;j++){
                for(vector<double>::iterator it=pingwei.begin();it!=pingwei.end();it++){
                    *it = ((rand() % (b-a+1))+ a);
                }
                //找到最大值和最小值
                sort(pingwei.begin(),pingwei.end());
                //去掉最大值和最小值
                pingwei[0] = 0;
                pingwei[pingwei.size()-1] = 0;
                double avg_score = 0.0;
                for(int i=0;i<10;i++){
                    avg_score+=pingwei[i];
                }
                avg_score = avg_score/(pingwei.size()-2);
                //m[] =(double)avg_score;
                m.at(v1[j]).s_score[0] = avg_score;
                if(v1[j]%2==0){
                    //第一组
                    temp1.insert(make_pair(avg_score,v1[j]));
                }else{
                    //第二组
                    temp2.insert(make_pair(avg_score,v1[j]));
                }
            }
            //将临时结果进行排序(map默认插入式从小到大，加个仿函数变为从大到小)
            for(map<double,int>::iterator it = temp1.begin();it!=temp1.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            for(map<double,int>::iterator it = temp2.begin();it!=temp2.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            //打分完毕，将12个人分为6组
        }else{
            //第二轮比赛

        }

    }
    void startSpeech(){
        //第一轮比赛：
        //抽签
        random_function();
        //print();
        //比赛
        speech_context();
        //显示晋级结果

        //第二轮比赛

        //抽签

        //比赛

        //显示最终结果

        //保存分数
    }
    void print(){

        for(vector<int>::iterator it=v1.begin();it!=v1.end();it++){
            cout<<"编号："<<*it<<endl;
            cout<<"姓名："<<m.find(*it)->second.s_name<<endl;
            cout<<"第一轮分数："<<m.find(*it)->second.s_score[0]<<endl;
            cout<<"第二轮分数："<<m.find(*it)->second.s_score[1]<<endl;
        }
    }
};


#endif // SPEECH_MANAGER_H_INCLUDED
