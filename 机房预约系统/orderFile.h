#ifndef ORDERFILE_H_INCLUDED
#define ORDERFILE_H_INCLUDED
#include "map"
#include <iostream>
#include "string"
using namespace std;

class orderFile{
public:
    orderFile(){
        updateOrder();
    }
    //����ԤԼϵͳ
    void updateOrder(){
        //��order�ļ��е���Ϣ������
        ifstream ifs;
        ifs.open(ORDER_FILE,ios::in);
        string date;
        string interval;
        string stuId;
        string stuName;
        string roomId;
        string status;
        this->m_size =0;
        while(ifs>>date&&ifs>>interval&&ifs>>stuId&&ifs>>stuName&&ifs>>roomId&&ifs>>status){
            map<string,string> m;//�����¼�ļ�ֵ����Ϣ
            string key;
            string value;
            int pos = date.find(":");
            if(pos!=-1){
                key = date.substr(0,pos);
                value = date.substr(pos+1,date.size()-pos);
                m.insert(make_pair(key,value));
            }
            pos = interval.find(":");
            if(pos!=-1){
                key = interval.substr(0,pos);
                value = interval.substr(pos+1,interval.size()-pos);
                m.insert(make_pair(key,value));
            }
            pos = stuId.find(":");
            if(pos!=-1){
                key = stuId.substr(0,pos);
                value = stuId.substr(pos+1,stuId.size()-pos);
                m.insert(make_pair(key,value));
            }
            pos = stuName.find(":");
            if(pos!=-1){
                key = stuName.substr(0,pos);
                value = stuName.substr(pos+1,stuName.size()-pos);
                m.insert(make_pair(key,value));
            }
            pos = roomId.find(":");
            if(pos!=-1){
                key = roomId.substr(0,pos);
                value = roomId.substr(pos+1,roomId.size()-pos);
                m.insert(make_pair(key,value));
            }
            pos = status.find(":");
            if(pos!=-1){
                key = status.substr(0,pos);
                value = status.substr(pos+1,status.size()-pos);
                m.insert(make_pair(key,value));
            }
            this->m_orderData.insert(make_pair(this->m_size,m));
            this->m_size++;
        }
    }
    //��¼������ key...��¼������  value...�����¼�ļ�ֵ����Ϣ
    map<int,map<string,string>> m_orderData;

    //���Դ���
    void printMap(){
        for(map<int,map<string,string>>::iterator it = m_orderData.begin();it!=m_orderData.end();it++){
            cout<<"��һ����¼��";
            for(map<string,string>::iterator it1 = it->second.begin();it1!=it->second.end();it1++){
                cout<<it1->first<<":"<<it1->second;
            }
            cout<<endl;
        }
    }

    //ԤԼ��¼����
    int m_size;
};

#endif // ORDERFILE_H_INCLUDED
