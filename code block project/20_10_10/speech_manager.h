#ifndef SPEECH_MANAGER_H_INCLUDED
#define SPEECH_MANAGER_H_INCLUDED
#include <iostream>
#include "map"
#include "algorithm"
#include "speech_actor.h"
#include "string"
#include "vector"
#include "math.h"
#include "fstream"

using namespace std;
 //将比赛结果从大到小排序的仿函数
    class great{
    public:
        bool operator()(const double v1,const double v2){
            return v1>v2;
        }
    };
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
        //print();
    }
    //比赛‘(rand()% (b-a+1))+ a
    void speech_context(){
        int a = 60;
        int b = 90;
        srand(11);
        vector<double> pingwei;
        pingwei.resize(10);
        map<double,int,great> temp1;//放第一组
        map<double,int,great> temp2;//放第二组
        map<double,int,great> temp_speaker;//临时容器：存放第二组的选手，用来排序
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
                m.find(v1[j])->second.s_score[0] = avg_score;
                if(v1[j]%2==0){
                    //第一组
                    temp1.insert(make_pair(avg_score,v1[j]));
                }else{
                    //第二组
                    temp2.insert(make_pair(avg_score,v1[j]));
                }
            }
            //将临时结果进行排序(map默认插入式从小到大，加个仿函数变为从大到小)
            /*
            for(map<double,int,great>::iterator it = temp1.begin();it!=temp1.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            for(map<double,int,great>::iterator it = temp2.begin();it!=temp2.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            cout<<"**************"<<endl;*/
            //排序完毕，将两组选手的前三名放入第二轮选手容器中
            map<double,int,great>::iterator it1 = temp1.begin();
            map<double,int,great>::iterator it2 = temp2.begin();
            for(int i=0;i<3;i++){
                v2.push_back(it1->second);
                v2.push_back(it2->second);
                it1++;
                it2++;
            }
            /*
            for(vector<int>::iterator it = v2.begin();it!=v2.end();it++){
                cout<<*it<<endl;
            }
            */
        }else{
            //第二轮比赛
            //给六个人打分
            for(int i=0;i<6;i++){
                for(vector<double>::iterator it = pingwei.begin();it!=pingwei.end();it++){
                    *it = ((rand() % (b-a+1))+ a);
                }
                //去掉最高分和最低分计算平均成绩
                sort(pingwei.begin(),pingwei.end());
                pingwei[0] = 0.0;
                pingwei[0] = 0.0;
                double avg_score = 0.0;
                for(vector<double>::iterator it = pingwei.begin();it!=pingwei.end();it++){
                    avg_score+=(*it);
                }
                avg_score = avg_score/(pingwei.size()-2);
                m.find(v2[i])->second.s_score[1] = avg_score;
                temp_speaker.insert(make_pair(avg_score,v2[i]));
            }
            //打印比赛结果
            map<double,int>::iterator it = temp_speaker.begin();
            for(int i=0;i<3;i++){
                victory.push_back(it->second);
                it++;
            }
            /*
            cout<<"第二轮比赛结束，比赛结果如下："<<endl;
            map<double,int,great>::iterator it =  temp_speaker.begin();
            for(int i=0;i<3;i++){
                cout<<"编号为："<<it->second<< " ";
                cout<<"姓名为："<<m.at(it->second).s_name<<" ";
                cout<<"第一轮得分："<<m.at(it->second).s_score[0]<<" ";
                cout<<"第二轮得分："<<m.at(it->second).s_score[1]<<endl;
                it++;
            }
            */
        }
    }
    //显示第一轮结果
    void show_result(){
        if(index==1){
            cout<<"第一轮比赛已经结束，结果如下："<<endl;
            for(vector<int>::iterator it = v2.begin();it!=v2.end();it++){
                cout<<"编号："<<*it<<"  ";
                cout<<"姓名为："<<m.find(*it)->second.s_name<<"  ";
                cout<<"第一轮比赛成绩为："<<m.find(*it)->second.s_score[0]<<endl;
            }
        }else{
            cout<<"第二轮比赛结束，结果如下："<<endl;
            for(vector<int>::iterator it = victory.begin();it!=victory.end();it++){
                cout<<"编号为："<<*it<<endl;
                cout<<"姓名为:s"<<m.find(*it)->second.s_name<<endl;
                cout<<"第二轮比赛成绩为："<<m.find(*it)->second.s_score[1]<<endl;
            }
        }
    }
    //保存结果
    void save_result(){
            //保存分数
            ofstream ofs;
            ofs.open("speak.csv",ios::out|ios::app);
            for(vector<int>::iterator it = victory.begin();it!=victory.end();it++){
                ofs<<"编号为："<<*it<< ",";
                ofs<<"姓名为："<<m.find(*it)->second.s_name<<",";
                ofs<<"第一轮得分："<<m.find(*it)->second.s_score[0]<<",";
                ofs<<"第二轮得分："<<m.find(*it)->second.s_score[1]<<endl;
            }
            ofs.close();
    }
    //显示第二轮结果
    void show_second(){

    }

    void print(){
        for(vector<int>::iterator it=v1.begin();it!=v1.end();it++){
            cout<<"编号："<<*it<<" ";
            cout<<"姓名："<<m.find(*it)->second.s_name<<" ";
            cout<<"第一轮分数："<<m.find(*it)->second.s_score[0]<<" ";
            cout<<"第二轮分数："<<m.find(*it)->second.s_score[1]<<endl;
        }
    }
    void print2(){
        for(vector<int>::iterator it=v2.begin();it!=v2.end();it++){
            cout<<"编号："<<*it<<" ";
            cout<<"姓名："<<m.find(*it)->second.s_name<<" ";
            cout<<"第一轮分数："<<m.find(*it)->second.s_score[0]<<" ";
            cout<<"第二轮分数："<<m.find(*it)->second.s_score[1]<<endl;
        }
    }
    void startSpeech(){
        //第一轮比赛：
        //抽签
        random_function();
        //打印抽签结果
        cout<<"第"<<this->index<<"轮抽签结果"<<endl;
        print();
        //比赛
        speech_context();
        //显示晋级结果
        show_result();
        index++;
        cout<<"第一轮比赛全部结束"<<endl;
        //第二轮比赛
        //抽签
        random_function();
        //打印抽签结果
        cout<<"第"<<this->index<<"轮抽签结果"<<endl;
        print2();
        //比赛
        speech_context();
        //显示结果
        show_result();
        //保存分数
        save_result();
    }
    //查看往届比赛选手
    void find_past_result(){
        ifstream ifs;
        ifs.open("speak.csv",ios::in);
        string str;
        while(getline(ifs,str)){
            cout<<str<<endl;
        }
        ifs.close();
    }
    void clear_result(){
        cout<<"确认清空？"<<endl;
        cout<<"1 确认"<<endl;
        cout<<"2 返回"<<endl;
        int flag ;
        cin>>flag;
        if(flag==1){
            //清空
            ofstream ofs;
            ofs.open("speak.csv",ios::trunc);
            ofs.close();
        }else if(flag==2){
            return ;
        }else{
            cout<<"您的输入有问题"<<endl;
        }
        ofstream file_writer("speak.txt", ios_base::out);
    }
};


#endif // SPEECH_MANAGER_H_INCLUDED
