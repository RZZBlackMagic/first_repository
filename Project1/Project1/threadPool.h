#pragma once
#include <vector>
#include <queue>
#include <memory>//分配内存需要包含
#include <thread>
#include <mutex>
#include <condition_variable>
#include <future>
#include <functional>
#include <stdexcept>

class ThreadPool {

public:
	ThreadPool(size_t);                          //构造函数
	template<class F, class... Args>             //类模板
	auto enqueue(F&& f, Args&&... args)->std::future<typename std::result_of<F(Args...)>::type>;//任务入队
	~ThreadPool();                              //析构函数

private:
	std::vector< std::thread > workers;            //线程队列，每个元素为一个Thread对象
	std::queue< std::function<void()> > tasks;     //任务队列，每个元素为一个函数对象

	std::mutex queue_mutex;                        //互斥量
	std::condition_variable condition;             //条件变量
	bool stop;                                     //停止
};