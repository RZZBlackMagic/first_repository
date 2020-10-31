#ifndef THREADTEST_H_INCLUDED
#define THREADTEST_H_INCLUDED
#include "string"
#include <iostream>
#include <pthread.h>
using namespace std;
#define num 5


void* sayHello(void* threadId){
    int id = *((int*)threadId);
    cout<<"线程"<<id<<"被创建了"<<endl;
    return 0;
}

void creat_thread(){
    pthread_t t1[num];
    for(int i=0;i<num;i++){
        cout<<"main函数创建线程："<<i<<endl;
        int ret = pthread_create(&t1[i],NULL,sayHello,(void*)&i);
        if(ret!=0){
            cout<<"创建失败"<<endl;
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
    cout<<"线程"<<td->id<<"被创建了"<<endl;
    cout<<"线程"<<td->id<<"的信息："<<td->name<<endl;
    pthread_exit(NULL);
}

void creat_thread_struce()
{
    pthread_t t1[num];
    struct thread_data td[num];
    for(int i=0;i<num;i++){
        td[i].id = i;
        td[i].name = "我是线程"+to_string(i)+"啊";
        pthread_create(&t1[i],NULL,sayHello_struct,(void*)&td[i]);
    }
}


void  test01(){
    pthread_t t1 ;
}
#endif // THREADTEST_H_INCLUDED
