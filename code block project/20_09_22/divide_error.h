#ifndef DIVIDE_ERROR_H_INCLUDED
#define DIVIDE_ERROR_H_INCLUDED
#include <iostream>
#include <exception>
#include <string.h>

using namespace std;
void divid(){
    int i = 0,j = 0;
    while(true){
        cout<<"��������ӣ�"<<endl;
        cin>>i;
        cout<<"�������ĸ��"<<endl;
        cin>>j;
        if(j==0){
            throw exception();
        }
        break;
    }
    cout<<"i/j="<<i/j<<endl;
}
void m_main(){
    try{
        divid();
    }catch(exception &e){
        //cout<<e.what()<<endl;
        cout<<"��׽���쳣��"<<endl;
        divid();
    }

}


#endif // DIVIDE_ERROR_H_INCLUDED
