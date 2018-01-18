package queue;

import java.util.Scanner;
/**
 * ���нڵ�
 * @author wsz
 * @date 2018��1��18��
 */
class Data{
	String name;
	int age;
}

class CycleQueue{
	//ʵ�ʶ��п��������Ϊ3
	static int SIZE = 4;
	//ģ����нṹ
	Data[] data = new Data[SIZE];
	
	int head,tail;
	
	/**
	 * ��ʼ����ͷβ��Ϊ0
	 * @return
	 */
	CycleQueue init() {
		CycleQueue cq = new CycleQueue();
		cq.head = 0;
		cq.tail = 0;
		return cq;
	}
	
	/**
	 * ��ͷβ���ʱΪ��
	 * @param cq
	 * @return
	 */
	boolean isEmpty(CycleQueue cq) {//���Ϊ��
		if(cq.tail == cq.head)
			return true;
		return false;
	}
	
	/**
	 * �ж��Ƿ������(SIZE-1)
	 * @param cq
	 * @return
	 */
	boolean isFull(CycleQueue cq) {
		if((cq.tail+1) % SIZE == cq.head)
			return true;
		return false;
	}
	
	/**
	 * ��������:(tail+1)%SIZE ��ʵ�ʵĴ洢λ��
	 * @param cq
	 * @param data
	 * @return
	 */
	int insertCycleQueue(CycleQueue cq,Data data) {
		if(isFull(cq)) {
			System.out.println("������");
			return -1;
		}else {
			cq.data[ (cq.tail++) % SIZE] = data;
			System.out.println("�ӳ���:"+cq.lenCycleQueue(cq));
			return cq.tail;
		}
	}
	/**
	 * ������
	 * @param cq
	 * @return
	 */
	Data outCycleQueue(CycleQueue cq) {
		if(isEmpty(cq)) {
			System.out.println("�ӿ�");
			return null;
		}else {
			Data d = cq.data[ (cq.head) % SIZE];
			cq.data[ (cq.head) % SIZE] = null; //�����и�λ��Ҫ�ÿ�
			cq.head++;	//����һλ
			return d;
		}
	}
	
	/**
	 * ���г���
	 * @param cq
	 * @return
	 */
	int lenCycleQueue(CycleQueue cq) {
		return (cq.tail-cq.head +SIZE) % SIZE;
	}
	
	/**
	 * չʾȫ����������
	 * @param cq
	 */
	void showCycleQueue(CycleQueue cq){
		if(isEmpty(cq)) {
			System.out.println("�ӿ�");
		}else {
			Data[] d = cq.data;
			for(int i =0; i<d.length;i++) {
				if(d[i] != null)
					System.out.print(" "+i+":"+d[i].age+"_"+d[i].name);
			}
			System.out.println("");
		}
	}
	
}
public class CycleQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CycleQueue cq = new CycleQueue();
		CycleQueue queue = cq.init();
		
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1������� 2���ݳ��� 3չʾ���� 0�˳�");
			int select = input.nextInt();
			if(select == 1) {
				insert(cq,queue,input);
			}else if(select == 2) {
				out(cq,queue,input);
			}else if(select == 3){
				show(cq,queue);
			}else {
				break;
			}
		}while(true);
		input.close();
	}

	static void show(CycleQueue cq, CycleQueue queue) {
		cq.showCycleQueue(queue);
	}
	
	static void insert(CycleQueue cq, CycleQueue queue, Scanner input) {
		System.out.println("���");
		Data data = new Data();
		data.name = input.next();
		data.age  = input.nextInt();
		cq.insertCycleQueue(queue, data);
	}
	
	static void out(CycleQueue cq, CycleQueue queue, Scanner input) {
		System.out.println("��������");
		Data out = cq.outCycleQueue(queue);
		if(out != null)
			System.out.println(out.age+"_"+out.name+"---ʣ�೤��:"+cq.lenCycleQueue(queue));
	}
}
