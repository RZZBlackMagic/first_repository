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
�ṩ�˵��������û�����
���ݽ��������̽��п���
���ļ��Ķ�д����
*/
class SpeechManager{
public:
    SpeechManager(){
        initSpeech();
        createSpeaker();
    }
    ~SpeechManager(){

    }
    //�˵�����
    void show_Menu(){
        cout<<"**************************"<<endl;
        cout<<"****��ӭ�μ��ݽ�����****"<<endl;
        cout<<"****1 ��ʼ�ݽ�����******"<<endl;
        cout<<"****2 �鿴�����¼******"<<endl;
        cout<<"****3 ��ձ�����¼******"<<endl;
        cout<<"****0 �˳���������******"<<endl;
        cout<<"**************************"<<endl;
    }
    //�˳�����
    void exit_speech(){
        cout<<"��ӭ�´�ʹ��"<<endl;
        system("pause");//����
        exit(0);
    }
    vector<int> v1;//��һ��ѡ������
    vector<int> v2;//�ڶ���ѡ������
    vector<int> victory;//ʤ��ѡ������
    int index;//��¼��������
    map<int,Speaker> m;//��ű�ż���Ӧ��ѡ��

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
            string name = "ѡ��";
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
    //��ǩ
    void random_function(){
        cout<<"��"<<this->index<<"�ֱ�����ǩ������"<<endl;
        if(index==1){
            cout<<"*****************"<<endl;
            random_shuffle(v1.begin(),v1.end());
        }else{
            cout<<"*****************"<<endl;
            random_shuffle(v2.begin(),v2.end());
        }
    }
    //������(rand()% (b-a+1))+ a
    void speech_context(){
        int a = 60;
        int b = 90;
        srand(11);
        vector<double> pingwei;
        pingwei.resize(10);
        map<double,int> temp1;//�ŵ�һ��
        map<double,int> temp2;//�ŵڶ���
        if(index==1){
            //��һ�ֱ���
            for(int j=0;j<12;j++){
                for(vector<double>::iterator it=pingwei.begin();it!=pingwei.end();it++){
                    *it = ((rand() % (b-a+1))+ a);
                }
                //�ҵ����ֵ����Сֵ
                sort(pingwei.begin(),pingwei.end());
                //ȥ�����ֵ����Сֵ
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
                    //��һ��
                    temp1.insert(make_pair(avg_score,v1[j]));
                }else{
                    //�ڶ���
                    temp2.insert(make_pair(avg_score,v1[j]));
                }
            }
            //����ʱ�����������(mapĬ�ϲ���ʽ��С���󣬼Ӹ��º�����Ϊ�Ӵ�С)
            for(map<double,int>::iterator it = temp1.begin();it!=temp1.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            for(map<double,int>::iterator it = temp2.begin();it!=temp2.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            //�����ϣ���12���˷�Ϊ6��
        }else{
            //�ڶ��ֱ���

        }

    }
    void startSpeech(){
        //��һ�ֱ�����
        //��ǩ
        random_function();
        //print();
        //����
        speech_context();
        //��ʾ�������

        //�ڶ��ֱ���

        //��ǩ

        //����

        //��ʾ���ս��

        //�������
    }
    void print(){

        for(vector<int>::iterator it=v1.begin();it!=v1.end();it++){
            cout<<"��ţ�"<<*it<<endl;
            cout<<"������"<<m.find(*it)->second.s_name<<endl;
            cout<<"��һ�ַ�����"<<m.find(*it)->second.s_score[0]<<endl;
            cout<<"�ڶ��ַ�����"<<m.find(*it)->second.s_score[1]<<endl;
        }
    }
};


#endif // SPEECH_MANAGER_H_INCLUDED
