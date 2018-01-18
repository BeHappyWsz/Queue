package queue;

import java.util.Scanner;
/**
 * ���нڵ�
 * @author wsz
 * @date 2018��1��18��
 */
class Node{
	String name;
	int age;
}
/**
 * ����
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
			System.out.println(SIZE+"��������");
			return -1;
		}else {
			q.queue[q.tail++] = data;
			return q.tail;
		}
	}
	
	Node outQueue(Queue q) {
		if(q.head == q.tail) {
			System.out.println("�����ѿ�");	
			return null;
		}else {
			return q.queue[q.head++];//ÿ�γ��ӣ�ͷ������
		}
	}
	
	Node peekQueue(Queue q){
		if(isEmpty(q)) {
			System.out.println("�ն���");
			return null;
		}else {
			return q.queue[q.head];//ֻ���ͷ���ڵ�
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
		System.out.println("���(����0 0 �˳�)");
		do {
			Node data = new Node();
			data.name = input.next();
			data.age  = input.nextInt();
			if("0".equals(data.name))
				break;
			queue.insertQueue(q, data);
		}while(true);
		
		System.out.println("�����У��������0�����г����в���");
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
