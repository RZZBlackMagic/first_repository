#include <iostream>
#include <D:\code block project\20_09_16x.h>
#include <D:\code block project\20_09_16y.h>
using namespace std;

#define f 3

struct student {
    char name[20];
    int age;
    char sex;
};

struct classes {
    student s ;
    int cla_num ;
};

int c ;

int main()
{
     /*
    struct student s ;
    scanf("%s\n",&s.name);
    scanf("%d\n",&s.age);
    scanf("%c",&s.sex);
    //cout<<"姓名：%s,年龄：%d,性别：%c",s.name,s.age,s.sex<<endl;
    printf("姓名：%s,年龄：%d,性别：%c",s.name,s.age,s.sex);
    struct classes cla = {s,0001} ;

    printf("姓名：%s,年龄：%d,性别：%c,班号：%d",cla.s.name,cla.s.age,cla.s.sex,cla.cla_num);

    const int a = 1;
    float b = 1.1 ;
    double c = 1.1111111;
    char d = 'a';
    cout << "Hello world!" << endl;

    string s = "aaa";
    int x = 10;
    int * px = &x;
    int *& rpx = px;
    cout << "x=" << x << endl;
    cout << "px=" << *px << endl;
    cout << "rpx="  << *rpx <<endl;

    student s = new student();
    s.age = 18;
    s.name = "ren";
    s.sex = 'm';
    printf("姓名：%s,年龄：%d,性别：%c",s.name,s.age,s.sex);

    void swap(int &,int &);
    int add(int,int);
    int i=3,j=5;
    swap(i,j);
    printf("i=%d,j=%d",i,j);
    int a = 1;
    int & b =a;
    printf("b=%d",b);
    int c = add(1,2);
    printf("c=%d",c);
    int  add1(int,int);
    int  x = add1(1,2);
    printf("x=%d",x);*/
    MyNameSpace1::Chello x;
    MyNameSpace2::Chello y;
    x.print();
    y.print();
    //cout.setf(ios::right,ios::adjustfield);
    //cout<<"jcadibviabv"<<endl<<"adfdfffd"<<endl;
    return 0;
}

void swap(int &a , int &b){
    int temp;
    temp = a;
    a = b;
    b = temp;
}

int  add(int a,int b){
    int c = a+b;
    return c;
}

int add1(int a,int b){
    c = a + b;
    return c;
}
