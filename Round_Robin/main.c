#include <stdio.h>
#include <stdlib.h>
#define TAKING 0
#define RUN 1
#define WAIT 2
#define FINISH 3
int NUMBER = 5;
typedef struct pcb {
   char processName[20];
   int arrivalTime;
   int startTime;
   int runtime;//��������ʱ��
   int runtimed;//����������ʱ��
   int status;
}pcb;
int currTime=0;//��ǰִ��ʱ��
pcb pcbs[NUMBER];
int main()
{
    printf("Hello world!\n");
    initPcbs();
    int arrivaled_process_num=arrivaled_process_num();
    return 0;
}
int clock = 1;
int time_slicing = 5;
void initPcbs(){
   int index =0;
   for(index=0;index<NUMBER;index++){
    scanf("%s",pcb[index].processName);
    scanf("%d",&pcb[index].arrivalTime);
    scanf("%d",&pcb[index].runtime);
    pcb[index].runtimed=0;
    pcb[index].status =2;//����
   }
}
//�жϵ����ʱ��
//δ�����жϵ�����̣�����ȴ���������
int arrivaled_Num(){
    int num;
    int i;
    for(i=0;i<NUMBER;i++){
        if(pcb[i].startTime<currTime){
            num++;
            pcb.status=0;
        }
    }
    return num;
}
//�����ȴ�����
int execute(int num){
    int i ;
    for(i=0;i<NUMBER;i++){
        if(pcb[i].status==0){
            pcb[i].runtime--;
            if(pcb[i].runtime==0){
                //ִ������
                pcb.status=3;
            }
            sleep(1000);
            break;
        }
    }
    return i;
}
void movePcb(int i){
    int j ;
    if(pcb[i].status==3){
        //iŲ������棬i�����ֱ����ǰ���ǣ����鳤�ȼ�һ
       deletePcbElem();
       break;
    }else{
       //��ǰִ�еĵ�i�����̣��Ƶ����������
       //�ڴ���һ���ȴ����飬�ڵȴ�������ѭ��
       pcb p = pcb[i];
       for(j=i;j<NUMBER-1;j++){
            pcb[i]=pcb[i+1];
       }
       pcb[NUMBER-1] = p ;
       NUMBER--;
    }
}
