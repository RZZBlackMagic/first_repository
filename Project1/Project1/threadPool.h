#pragma once
#include <vector>
#include <queue>
#include <memory>//�����ڴ���Ҫ����
#include <thread>
#include <mutex>
#include <condition_variable>
#include <future>
#include <functional>
#include <stdexcept>

class ThreadPool {

public:
	ThreadPool(size_t);                          //���캯��
	template<class F, class... Args>             //��ģ��
	auto enqueue(F&& f, Args&&... args)->std::future<typename std::result_of<F(Args...)>::type>;//�������
	~ThreadPool();                              //��������

private:
	std::vector< std::thread > workers;            //�̶߳��У�ÿ��Ԫ��Ϊһ��Thread����
	std::queue< std::function<void()> > tasks;     //������У�ÿ��Ԫ��Ϊһ����������

	std::mutex queue_mutex;                        //������
	std::condition_variable condition;             //��������
	bool stop;                                     //ֹͣ
};