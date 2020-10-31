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
 //����������Ӵ�С����ķº���
    class great{
    public:
        bool operator()(const double v1,const double v2){
            return v1>v2;
        }
    };
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
        //print();
    }
    //������(rand()% (b-a+1))+ a
    void speech_context(){
        int a = 60;
        int b = 90;
        srand(11);
        vector<double> pingwei;
        pingwei.resize(10);
        map<double,int,great> temp1;//�ŵ�һ��
        map<double,int,great> temp2;//�ŵڶ���
        map<double,int,great> temp_speaker;//��ʱ��������ŵڶ����ѡ�֣���������
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
                m.find(v1[j])->second.s_score[0] = avg_score;
                if(v1[j]%2==0){
                    //��һ��
                    temp1.insert(make_pair(avg_score,v1[j]));
                }else{
                    //�ڶ���
                    temp2.insert(make_pair(avg_score,v1[j]));
                }
            }
            //����ʱ�����������(mapĬ�ϲ���ʽ��С���󣬼Ӹ��º�����Ϊ�Ӵ�С)
            /*
            for(map<double,int,great>::iterator it = temp1.begin();it!=temp1.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            for(map<double,int,great>::iterator it = temp2.begin();it!=temp2.end();it++){
                cout<<it->first<<"******"<<it->second<<endl;
            }
            cout<<"**************"<<endl;*/
            //������ϣ�������ѡ�ֵ�ǰ��������ڶ���ѡ��������
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
            //�ڶ��ֱ���
            //�������˴��
            for(int i=0;i<6;i++){
                for(vector<double>::iterator it = pingwei.begin();it!=pingwei.end();it++){
                    *it = ((rand() % (b-a+1))+ a);
                }
                //ȥ����߷ֺ���ͷּ���ƽ���ɼ�
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
            //��ӡ�������
            map<double,int>::iterator it = temp_speaker.begin();
            for(int i=0;i<3;i++){
                victory.push_back(it->second);
                it++;
            }
            /*
            cout<<"�ڶ��ֱ�������������������£�"<<endl;
            map<double,int,great>::iterator it =  temp_speaker.begin();
            for(int i=0;i<3;i++){
                cout<<"���Ϊ��"<<it->second<< " ";
                cout<<"����Ϊ��"<<m.at(it->second).s_name<<" ";
                cout<<"��һ�ֵ÷֣�"<<m.at(it->second).s_score[0]<<" ";
                cout<<"�ڶ��ֵ÷֣�"<<m.at(it->second).s_score[1]<<endl;
                it++;
            }
            */
        }
    }
    //��ʾ��һ�ֽ��
    void show_result(){
        if(index==1){
            cout<<"��һ�ֱ����Ѿ�������������£�"<<endl;
            for(vector<int>::iterator it = v2.begin();it!=v2.end();it++){
                cout<<"��ţ�"<<*it<<"  ";
                cout<<"����Ϊ��"<<m.find(*it)->second.s_name<<"  ";
                cout<<"��һ�ֱ����ɼ�Ϊ��"<<m.find(*it)->second.s_score[0]<<endl;
            }
        }else{
            cout<<"�ڶ��ֱ���������������£�"<<endl;
            for(vector<int>::iterator it = victory.begin();it!=victory.end();it++){
                cout<<"���Ϊ��"<<*it<<endl;
                cout<<"����Ϊ:s"<<m.find(*it)->second.s_name<<endl;
                cout<<"�ڶ��ֱ����ɼ�Ϊ��"<<m.find(*it)->second.s_score[1]<<endl;
            }
        }
    }
    //������
    void save_result(){
            //�������
            ofstream ofs;
            ofs.open("speak.csv",ios::out|ios::app);
            for(vector<int>::iterator it = victory.begin();it!=victory.end();it++){
                ofs<<"���Ϊ��"<<*it<< ",";
                ofs<<"����Ϊ��"<<m.find(*it)->second.s_name<<",";
                ofs<<"��һ�ֵ÷֣�"<<m.find(*it)->second.s_score[0]<<",";
                ofs<<"�ڶ��ֵ÷֣�"<<m.find(*it)->second.s_score[1]<<endl;
            }
            ofs.close();
    }
    //��ʾ�ڶ��ֽ��
    void show_second(){

    }

    void print(){
        for(vector<int>::iterator it=v1.begin();it!=v1.end();it++){
            cout<<"��ţ�"<<*it<<" ";
            cout<<"������"<<m.find(*it)->second.s_name<<" ";
            cout<<"��һ�ַ�����"<<m.find(*it)->second.s_score[0]<<" ";
            cout<<"�ڶ��ַ�����"<<m.find(*it)->second.s_score[1]<<endl;
        }
    }
    void print2(){
        for(vector<int>::iterator it=v2.begin();it!=v2.end();it++){
            cout<<"��ţ�"<<*it<<" ";
            cout<<"������"<<m.find(*it)->second.s_name<<" ";
            cout<<"��һ�ַ�����"<<m.find(*it)->second.s_score[0]<<" ";
            cout<<"�ڶ��ַ�����"<<m.find(*it)->second.s_score[1]<<endl;
        }
    }
    void startSpeech(){
        //��һ�ֱ�����
        //��ǩ
        random_function();
        //��ӡ��ǩ���
        cout<<"��"<<this->index<<"�ֳ�ǩ���"<<endl;
        print();
        //����
        speech_context();
        //��ʾ�������
        show_result();
        index++;
        cout<<"��һ�ֱ���ȫ������"<<endl;
        //�ڶ��ֱ���
        //��ǩ
        random_function();
        //��ӡ��ǩ���
        cout<<"��"<<this->index<<"�ֳ�ǩ���"<<endl;
        print2();
        //����
        speech_context();
        //��ʾ���
        show_result();
        //�������
        save_result();
    }
    //�鿴�������ѡ��
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
        cout<<"ȷ����գ�"<<endl;
        cout<<"1 ȷ��"<<endl;
        cout<<"2 ����"<<endl;
        int flag ;
        cin>>flag;
        if(flag==1){
            //���
            ofstream ofs;
            ofs.open("speak.csv",ios::trunc);
            ofs.close();
        }else if(flag==2){
            return ;
        }else{
            cout<<"��������������"<<endl;
        }
        ofstream file_writer("speak.txt", ios_base::out);
    }
};


#endif // SPEECH_MANAGER_H_INCLUDED
