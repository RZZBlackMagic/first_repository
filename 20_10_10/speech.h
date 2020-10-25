#ifndef SPEECH_H_INCLUDED
#define SPEECH_H_INCLUDED
#include <iostream>
#include "map"
#include "algorithm"

using namespace std;


map<int,double> m;
//m.resize(12);

void first_speech(){
    cout<<"第一轮比赛正在抽签"<<endl;
    for(int i=1;i<12;i++){
        m.insert(pair<int,double>(i+10000,0.0));
    }
    //开始抽签，打乱顺序
    random_shuffle(m.begin(),m.end());
    for(map<int,double>::iterator it = m.begin();it!=m.end();it++){
        cout<<it->first<<" "<<it->second<<endl;
    }
}

void second_speech(){

}

void third_speech(){

}
void begin_speech(){
    first_speech();
    second_speech();
    third_speech();
}

void menu(){
    cout<<"**************************"<<endl;
    cout<<"****欢迎参加演讲比赛****"<<endl;
    cout<<"****1 开始演讲比赛******"<<endl;
    cout<<"****2 查看往届记录******"<<endl;
    cout<<"****3 清空比赛记录******"<<endl;
    cout<<"****0 退出比赛程序******"<<endl;
    cout<<"**************************"<<endl;
    while(true){
        cout<<"请输入您的选择:"<<endl;
        int input;
        cin>>input;
        switch(input){
        case 1:
            begin_speech();
            break;
        case 2:
            break;
        case 3:
            break;
        case 0:
            return;
            break;

        }
    }
}


#endif // SPEECH_H_INCLUDED
