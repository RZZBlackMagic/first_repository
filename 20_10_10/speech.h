#ifndef SPEECH_H_INCLUDED
#define SPEECH_H_INCLUDED
#include <iostream>
#include "map"
#include "algorithm"

using namespace std;


map<int,double> m;
//m.resize(12);

void first_speech(){
    cout<<"��һ�ֱ������ڳ�ǩ"<<endl;
    for(int i=1;i<12;i++){
        m.insert(pair<int,double>(i+10000,0.0));
    }
    //��ʼ��ǩ������˳��
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
    cout<<"****��ӭ�μ��ݽ�����****"<<endl;
    cout<<"****1 ��ʼ�ݽ�����******"<<endl;
    cout<<"****2 �鿴�����¼******"<<endl;
    cout<<"****3 ��ձ�����¼******"<<endl;
    cout<<"****0 �˳���������******"<<endl;
    cout<<"**************************"<<endl;
    while(true){
        cout<<"����������ѡ��:"<<endl;
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
