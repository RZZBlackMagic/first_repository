#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>

void *producter_f(void *arg);
void *consumer_f(void *arg);

int semaphore;
int empty;
int full;
int running  = 1;
int apple_num = 0;

void *producter_f(void *arg){
    printf(" producter thread:\n");
    int flag = 0;
    while(flag<20){
        flag++;
        sem_wait(&empty);
        apple_num++;
        printf(" productor product %d   apple\n",apple_num);
        sem_post(&full);
        usleep(1);
    }
}
void *consumer_f(void * arg){
    printf("  consumer thread\n");
    printf("  consumer running:%d\n",*(int*)arg);
    int flag = 0;
    int consumer_apple= 0;
    while(flag<20){
        consumer_apple++;
        flag++;
        sem_wait(&full);
        printf("  consumer consume %d apple \n",consumer_apple);
        sem_post(&empty);
        usleep(10000);
    }
}
int main(){
    printf(" let us go ");
    pthread_t consume_t;
    pthread_t product_t;
    sem_init(&empty,0,5);
    sem_init(&full,0,0);
    pthread_create(&consume_t,NULL,consumer_f,(void *)&running);
    pthread_create(&product_t,NULL,producter_f,(void *)&running);


    pthread_join(consume_t,NULL);
    pthread_join(product_t,NULL);
    sem_destroy(&empty);
    sem_destroy(&full);
    return 0;
}
