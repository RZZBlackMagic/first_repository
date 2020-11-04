#include <iostream>
#include "threadpool.h"
#include  <windows.h>
#include <stdlib.h>
#include <stdio.h>

using namespace std;

void* mytask(void *arg)
{
	printf("thread %d is working on task %d\n", (int)pthread_self(), *(int*)arg);
	sleep(1);
	free(arg);
	return NULL;
}

int main() 
{
	threadpool_t pool;
	//��ʼ���̳߳أ���������߳�
	threadpool_init(&pool, 3);
	int i;
	//����ʮ������
	for (i = 0; i < 10; i++)
	{
		int *arg = (int*)malloc(sizeof(int));
		*arg = i;
		threadpool_add_task(&pool, mytask, arg);

	}
	threadpool_destroy(&pool);   
	return 0;
}