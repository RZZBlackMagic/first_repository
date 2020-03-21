#include <stdio.h>
#include <stdlib.h>

int main()
{
    //stringDodeal();
    //cal_juzhenzhuduijaioxian();
    //cal_agv();
    //cal_area();
    //cal_wucifang();
    //turn_low();
    //delete_letter();
    link_reverse();
    return 0;
}
void stringDodeal()
{
    printf("please input a String :\n");
    char string[100];
    char *sp = string;
    gets(sp);
    char string2[100];
    int length = strlen(string);
    //printf("%d",length);
    //处理第一个字母前的*
    int i = 0;
    int j = length-1;
    while(*(sp+i)=='*'){
        string2[i]=string[i];
        i++;
    }
    //处理最后一个字母后面的*
    while(*(sp+j)=='*'){
        j--;
    }
    int k = i;
    while(i<j){
        if(*(sp+i)!='*'){
            string2[k]=string[i];
            k++;
        }
        i++;

    }
    while(i<length){
        string2[k]=string[i];
        i++;
        k++;
    }
    string2[k]='\0';
    puts(string2);
    //puts(sp);
}

void cal_juzhenzhuduijaioxian()
{
    int index[3][3];
    int i = 0,j=0;
    for(i=0;i<3;i++){
        for(j=0;j<3;j++){
            printf("index[%d][%d]=\n",i,j);
            scanf("%d",&index[i][j]);
        }
    }
    int sum =0;
    sum = index[0][0]+index[1][1]+index[2][2];
    printf("\nsum=%d\n",sum);
}
void cal_agv()
{
    int n;
    scanf("%d\n",&n);
    double index[n];
    int i = 0;
    double sum=0;
    for(i=0;i<n;i++){
        scanf("%lf",&index[i]);
    }
    for(i=0;i<n;i++){
        sum+=index[i];
    }
    double agv = sum/(double)n;
    printf("\n%0.2f",agv);
}
void cal_area()
{
    double r;
    scanf("%lf",&r);
    double pi = 3.1515926;
    double area = pi*r*r;
    printf("%.4f",area);
}
void cal_wucifang()
{
    int n;
    scanf("%d",&n);
    if(n<2||n>8){
        return 0;
    }
    long s = n*n*n*n*n;
    int ge = s%10;
    int shi = (s/10)%10;
    int bai = (s/100)%10;
    int sum = ge + shi + bai;
    printf("%ld  %d",s,sum);
}

void turn_low()
{
    char string[100];
    char *s = string;
    gets(s);
    int length = strlen(string);
    int i = 0;
    for(i=0;i<length;i++){
        if((i%2==0)&&(string[i]>64&&string[i]<91)){
            string[i] = string[i] + 32;
        }
    }
    puts(string);
}

void delete_letter()
{
    int n ;
    scanf("%d",&n);
    int i =0;
    int index[n];
    char string[n][100];
    char *s =string;
    for(i=0;i<n;i++){
        scanf("%d",&index[i]);
        //gets(string+i);
        scanf("%s",&index[i]);
    }
    int j = 0;
    int k = 0;
    for(j=0;j<n;j++){
        k = index[j];
        while(k<strlen(s+j)){
            string[j][k] = string[j][k+1];
            k++;
            string[j][k]='\0';
        }
    }
    for(i=0;i<n;i++){
        puts(s+i);
        //printf("%s",index[i]);

    }

}

typedef struct Node
{
    int data ;

}
void link_reverse(){

}
