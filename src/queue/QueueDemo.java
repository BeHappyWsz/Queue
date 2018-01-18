package queue;

import java.util.Scanner;
/**
 * 队列节点
 * @author wsz
 * @date 2018年1月18日
 */
class Node{
	String name;
	int age;
}
/**
 * 队列
 * @author wsz
 */
class Queue{
	static final int SIZE = 4;
	Node[] queue = new Node[SIZE];
	
	int head;
	int tail;
	
	Queue init() {
		Queue q = new Queue();
		q.head = 0;
		q.tail = 0;
		return q;
	}
	
	boolean isEmpty(Queue q) {
		boolean temp = false;
		if(q.head == q.tail)
			temp = true;
		return temp;
	}
	
	boolean isFull(Queue q) {
		if(q.tail == SIZE)
			return true;
		return false;
	}
	
	void clearQueue(Queue q) {
		q.head = 0;
		q.tail = 0;
	}
	
	void feeeQueue(Queue q) {
		q = null;  
	}
	
	int insertQueue(Queue q,Node data) {
		if(q.tail == SIZE) {
			System.out.println(SIZE+"队列已满");
			return -1;
		}else {
			q.queue[q.tail++] = data;
			return q.tail;
		}
	}
	
	Node outQueue(Queue q) {
		if(q.head == q.tail) {
			System.out.println("队列已空");	
			return null;
		}else {
			return q.queue[q.head++];//每次出队，头部后移
		}
	}
	
	Node peekQueue(Queue q){
		if(isEmpty(q)) {
			System.out.println("空队列");
			return null;
		}else {
			return q.queue[q.head];//只输出头部节点
		}
	}
	
	int lenQueqe(Queue q) {
		return q.tail - q.head;
	}
}
public class QueueDemo {

	public static void main(String[] args) {
		Queue queue = new Queue();
		Queue q = queue.init();
		
		Scanner input = new Scanner(System.in);
		System.out.println("入队(输入0 0 退出)");
		do {
			Node data = new Node();
			data.name = input.next();
			data.age  = input.nextInt();
			if("0".equals(data.name))
				break;
			queue.insertQueue(q, data);
		}while(true);
		
		System.out.println("出队列：按任意非0键进行出队列操作");
		String temp = input.next();
		while(!"0".equals(temp)) {
			Node out = queue.outQueue(q);
			if(out == null)
				break;
			System.out.println(out.name+"_"+out.age);
			temp = input.next();
		}
		queue.feeeQueue(q);
		
		input.close();
	}

}
