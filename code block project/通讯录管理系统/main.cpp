#include <iostream>
#include "showMenu.h"
#include <string>
using namespace std;

#define MAX 1000
#define M 2
int index = 0;

void manage(){
    struct person personArray[MAX];
    struct person p [M]={{"������",'M',18,"13541187190","����ʡ"},{"����",'M',8,"13541187190","����ʡ"}};
    int select = 0;
    show_menu();
    cout<<p[index].name<<endl;
    while(true){
        cout<<"��ѡ����ķ���"<<endl;
        cin>>select;
        int i =0 ;
        string delete_name;
        string find_name;
        string edit_name;
    switch(select)
    {
    case 1://�����ϵ��
        cout<<"����������:"<<endl;
        cin>>personArray[index].name;
        //cout<<"...."<<personArray[0].name<<endl;
        cout<<"�������Ա�:"<<endl;
        cin>>personArray[index].sex;
        cout<<"����������:"<<endl;
        cin>>personArray[index].age;
        //scanf("%d",&(personArray[index].age));
        cout<<"������绰:"<<endl;
        //personArray[index].phone='\n';
        personArray[index].phone="\n";
        getline(cin,personArray[index].phone);//���cin����
        getline(cin,personArray[index].phone);
        //cin>>personArray[index].phone;
        //scanf("%s",&(personArray[index].phone));
        cout<<"�������ַ:"<<endl;
        //cin>>personArray[index].address;
        //personArray[index].address='\n';
        //personArray[index].address="\n";
        getline(cin,personArray[index].address);
        //scanf("%s",&(personArray[index].address));
        index++;
        cout<<"����ɹ�"<<endl;
        //cout<<"��ַ�ǣ�"<<personArray[0].address<<endl;
        break;
    case 2://��ʾ��ϵ��
        cout<<"����       �Ա�        ����         �绰            ��ַ"<<endl;
        while(i<index){
            cout<<personArray[i].name<<"      "<<personArray[i].sex<<"       "<<personArray[i].age<<"         "<<personArray[i].phone<<"       "<<personArray[i].address<<endl;
            i++;
        }
        break;
    case 3://ɾ����ϵ��
        cout<<"������Ҫɾ������ϵ��������"<<endl;
        cin>>delete_name;
        for(i=0;i<index;i++){
            if(delete_name==personArray[i].name){
                personArray[i].name=personArray[index-1].name;
                personArray[i].sex=personArray[index-1].sex;
                personArray[i].age=personArray[index-1].age;
                personArray[i].phone=personArray[index-1].phone;
                personArray[i].address=personArray[index-1].address;
                index--;
                continue;
            }
        }
        cout<<"ɾ���ɹ�"<<endl;
        break;
    case 4://������ϵ��
        cout<<"�����������ϵ�˵�������"<<endl;
        cin>>find_name;
        for(i=0;i<index;i++){
            if(find_name==personArray[i].name){
                    cout<<personArray[i].name<<"      "<<personArray[i].sex<<"       "<<personArray[i].age<<"         "<<personArray[i].phone<<"       "<<personArray[i].address<<endl;
                    continue;
            }
        }
        break;
    case 5://�޸���ϵ��
        cout<<"������Ҫ�޸���ϵ�˵�������"<<endl;
        cin>>edit_name;
        for(i=0;i<index;i++){
            if(edit_name==personArray[i].name){
                cout<<"������Ҫ�޸ĵ�����"<<endl;
                cin>>personArray[i].name;
                cout<<"������Ҫ�޸ĵ��Ա�"<<endl;
                cin>>personArray[i].sex;
                cout<<"������Ҫ�޸ĵ�����"<<endl;
                cin>>personArray[i].age;
                cout<<"������Ҫ�޸ĵ��ֻ���"<<endl;
                cin>>personArray[i].phone;
                cout<<"������Ҫ�޸ĵĵ�ַ"<<endl;
                cin>>personArray[i].address;
                break;
            }
        }
        cout<<"�޸����"<<endl;
        break;
    case 6://�����ϵ��
        index=0;
        cout<<"������"<<endl;
        break;
    case 0://�˳�ͨѶ¼
        cout<<"��ӭ�´�ʹ��"<<endl;
        exit(0);
    default:
        break;
    }
    }

    //cout << "Hello world!" << endl;
}

class A{
private:
    static A *a;
    A(){
        cout<<"����"<<endl;
    };
    A(A *a){
        cout<<"���ƹ��캯��"<<endl;
    };

public :
    static A *getSingle(){
        if(NULL==a){
            a = new A();
        }
        return a;
    }
    static A getInstance(){
        return *getSingle();
    }
    void show(){
        cout<<"����һ������ģʽ"<<endl;
    }
};
A * A::a=NULL;
void single(){
    A objA = A::getInstance();
    A  *a1 = A::getSingle();
    A  *a2 = A::getSingle();
    if(&a1==&a2){
        cout<<"a1��a2��ͳһ����"<<endl;
    }
    (*a1).show();
    objA.show();
}

int main()
{
    single();
    return 0;
}

