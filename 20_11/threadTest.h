#ifndef THREADTEST_H_INCLUDED
#define THREADTEST_H_INCLUDED
#include "string"
#include "mutex"
#include <iostream>
#include <pthread.h>
#include "thread"
#include <condition_variable>
using namespace std;
#define num 5

mutex mtx;
condition_variable cv;
bool ready =false ;

void* sayHello(void* threadId){
    int id = *((int*)threadId);
    cout<<"�߳�"<<id<<"��������"<<endl;
    return 0;
}

void creat_thread(){
    pthread_t t1[num];
    for(int i=0;i<num;i++){
        cout<<"main���������̣߳�"<<i<<endl;
        int ret = pthread_create(&t1[i],NULL,sayHello,(void*)&i);
        if(ret!=0){
            cout<<"����ʧ��"<<endl;
        }
    }
    pthread_exit(NULL);
}

struct thread_data{
    int id;
    string name;
};

void* sayHello_struct(void* td1)
{

    thread_data* td = (thread_data*)td1;
    cout<<"�߳�"<<td->id<<"��������"<<endl;
    cout<<"�߳�"<<td->id<<"����Ϣ��"<<td->name<<endl;
    pthread_exit(NULL);
}

void creat_thread_struce()
{
    pthread_t t1[num];
    struct thread_data td[num];
    for(int i=0;i<num;i++){
        td[i].id = i;
        td[i].name = "�����߳�"+to_string(i)+"��";
        pthread_create(&t1[i],NULL,sayHello_struct,(void*)&td[i]);
    }
}

void func(){
    for(int i=0;i<20;i++){
        cout<<"�������߳�"<<endl;
    }
}

void  test01(){
    thread t1(func) ;
    cout<<"�������߳�"<<endl;
    t1.detach();
    cout<<"���߳̽�����"<<endl;
}
void do_print(int id){
    std::unique_lock <std::mutex> lck(mtx);
    while(!ready){
        cv.wait(lck);
    }
    cout<<"�̣߳�"<<id<<endl;
}

void go(){
    std::unique_lock <std::mutex> lck(mtx);
    ready = true;
    cv.notify_all();
}
#endif // THREADTEST_H_INCLUDED
