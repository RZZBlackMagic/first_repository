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
   int runtime;//进程运行时间
   int runtimed;//进程已运行时间
   int status;
}pcb;
int currTime=0;//当前执行时间
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
    pcb[index].status =2;//阻塞
   }
}
//判断到达的时间
//未做：判断到达进程，加入等待进程数组
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
//操作等待数组
int execute(int num){
    int i ;
    for(i=0;i<NUMBER;i++){
        if(pcb[i].status==0){
            pcb[i].runtime--;
            if(pcb[i].runtime==0){
                //执行完了
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
        //i挪到最后面，i后面的直接向前覆盖，数组长度减一
       deletePcbElem();
       break;
    }else{
       //当前执行的第i个进程，移到数组最后面
       //在创建一个等待数组，在等待数组中循环
       pcb p = pcb[i];
       for(j=i;j<NUMBER-1;j++){
            pcb[i]=pcb[i+1];
       }
       pcb[NUMBER-1] = p ;
       NUMBER--;
    }
}
