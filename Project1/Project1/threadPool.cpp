#include "threadPool.h"
// ���캯�������̲߳����̶߳��У�����ʱ����embrace_back()������������lambda��ʼ��Thread����
inline ThreadPool::ThreadPool(size_t threads) : stop(false) {

	for (size_t i = 0; i < threads; ++i)
		workers.emplace_back(
			[this]
	{
		for (;;)
		{
			// task��һ���������ͣ���������н�������
			std::function<void()> task;
			{
				//���������������������������ڽ������Զ�����
				std::unique_lock<std::mutex> lock(this->queue_mutex);

				//��1����������������falseʱ�������̣߳�����ʱ�Զ��ͷ�����
				//��2����������������true���ܵ�֪ͨʱ��������Ȼ�������
				this->condition.wait(lock, [this] { return this->stop || !this->tasks.empty(); });

				if (this->stop && this->tasks.empty())
					return;

				//���������ȡ��һ������
				task = std::move(this->tasks.front());
				this->tasks.pop();
			}                            // �Զ�����
			task();                      // ִ���������
		}
	}
	);
}

// ����µ������������
template<class F, class... Args>
auto ThreadPool::enqueue(F&& f, Args&&... args)
-> std::future<typename std::result_of<F(Args...)>::type>
{
	// ��ȡ��������ֵ����
	using return_type = typename std::result_of<F(Args...)>::type;

	// ����һ��ָ�������ֻ��ָ��
	auto task = std::make_shared< std::packaged_task<return_type()> >(
		std::bind(std::forward<F>(f), std::forward<Args>(args)...)
		);

	std::future<return_type> res = task->get_future();
	{
		std::unique_lock<std::mutex> lock(queue_mutex);  //����
		if (stop)
			throw std::runtime_error("enqueue on stopped ThreadPool");

		tasks.emplace([task]() { (*task)(); });          //������������
	}                                                   //�Զ�����
	condition.notify_one();                             //֪ͨ��������������һ���߳�
	return res;
}

// ����������ɾ�������߳�
inline ThreadPool::~ThreadPool()
{
	{
		std::unique_lock<std::mutex> lock(queue_mutex);
		stop = true;
	}
	condition.notify_all();
	for (std::thread &worker : workers)
		worker.join();
}