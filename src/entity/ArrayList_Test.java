package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_Test {
	public static void main(String[] args) {
		//��������
		ArrayList<Account> stuarr = new ArrayList<>();
		int longin = -1;
		while(true){
			System.out.println("---------��ӭʹ���й�������������ϵͳ---------");
			System.out.println("���������Ӧ�����,����ҵ�����:");
			System.out.println("1 �˻�����\t\t2 �û���¼");
			System.out.println("3 �û����\t\t4 �û�ȡ��");
			System.out.println("5 ��ѯ���\t\t6 �˳���¼");
			System.out.println("7 �˳�ϵͳ");
			//��������¼�����
			Scanner sc = new Scanner(System.in);
			int nummber = sc.nextInt();
			switch (nummber) {
			case 1:
				//�˻�����
				dredge(stuarr);
				break;
			case 2:
				//�û���¼
				longin = login(stuarr);
				break;
			case 3:
				//�û����
				deposit(stuarr,longin);
				break;
			case 4:
				//�û�ȡ��
				getMoney(stuarr,longin);
				break;
			case 5:
				//��ѯ���
				search(stuarr,longin);
				break;
			case 6:
				//�˳���¼
				System.out.println("�ɹ��˳��й�������������ϵͳ,��ӭ�ٴ�ʹ��! ! !");
				longin = -1;
				break;
			case 7:
				//�˳�ϵͳ
			default:
				System.exit(0);
				break;
			}
		}
	}

	//�˻�����
	public static int dredge(ArrayList<Account> stuarr){
		//��������¼�����
		Scanner sc = new Scanner(System.in);
		
		int id;
		while(true){
			System.out.println("���������뿪ͨ���˺�:");
			id = sc.nextInt();
			if(index(stuarr,id)!=-1){
				System.out.println("�˺ű�ռ��,����������:");
			}else{
				break;
			}
		}
		
		int password;
		while(true){
			System.out.println("�������������(6λ����):");
			password = sc.nextInt();
			if(password < 100000 || password > 999999){
				System.out.println("���벻����Ҫ��,����������...");
				continue;
			}
			
			System.out.println("����������ȷ������:");
			int passwd = sc.nextInt();
			
			
			if(password != passwd){
				System.out.println("���벻һ��,��������������:");
			}else{
				System.out.println("������֤ͨ��");
				break;
			}
			
		}
		
		System.out.println("��������������:");
		String name = sc.nextLine();
		name = sc.nextLine();
		
		String personId;
		while(true){
			System.out.println("�������������֤����:");
			personId = sc.nextLine();
			
			if(personId.length()!=18){
				System.out.println("����������֤��ʽ����ȷ,����������.");
			}else{
				break;
			}
		}
		
		int type;
		while(true){
			System.out.println("��ܰ��ʾ:(0��ʱ���ʾ�����˻�,1��ʱ���ʾ�����˻�)");
			System.out.println("�������˻�����:");
			type = sc.nextInt();
			
			if(type==0 || type==1){
				break;
			}else{
				System.out.println("�������˻����Ͳ���ȷ,����������");
			}
		}
		Account acc = new Account(id,password,name,personId,0,type);
		stuarr.add(acc);
		return id;
	}

	//id�����֤
	public static int index (ArrayList<Account> stuarr,int id){
		for (int i = 0; i < stuarr.size(); i++) {
			Account acc = stuarr.get(i);
			if(acc.getId()==id){
				return i;
			}
		}
		return -1;
	}

	//�û���¼
	public static int login (ArrayList<Account> stuarr){
		//��������¼�����
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("�������˻���:");
			int id = sc.nextInt();
			
			int index = index(stuarr,id);
			if(index==-1){
				System.out.println("��������˻�������,����������");
				return -1;
			}
			
			
			int passwd = stuarr.get(index).getPassword();
			for (int i = 3; i > 0; i--) {
				System.out.println("����������:");
				int password = sc.nextInt();
				
				if(passwd==password){
					System.out.println("��¼�ɹ�");
					return index;
				}else{
					if(i==1){
						System.out.println("��������������̫��,ǿ���˳�! ! !");
						System.exit(1);
					}else{
						System.out.println("�����������,�㻹��"+(i-1)+"�λ���! ! !");
					}
				}
			}
		}
	}

	//�û�������
	public static void deposit(ArrayList<Account> stuarr,int index){
		if(index==-1){
			System.out.println("���Ƚ��е�¼����,лл���! ! !");
			return;
		}
		
		System.out.println("����������:");
		//��������¼�����
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		System.out.println("�ɹ�����"+money+"ԪǮ");
		money += stuarr.get(index).getBalance();
		stuarr.get(index).setBalance(money);
	}
	
	//�û�ȡ�����
	public static void getMoney(ArrayList<Account> stuarr,int index){
		if(index==-1){
			System.out.println("���Ƚ��е�¼����,лл���! ! !");
			return;
		}
		
		System.out.println("������ȡ����:");
		//��������¼�����
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		money = stuarr.get(index).getBalance()-money;
		if(stuarr.get(index).getType()==0){
			if(money>=0){
				stuarr.get(index).setBalance(money);
			}else{
				System.out.println("�Բ���,���Ŀ����Ǵ��,�޷�����͸֧����! ! !");
				return;
			}
		}else if(stuarr.get(index).getType()==1){
			if(money>=-10000){
				stuarr.get(index).setBalance(money);
			}else{
				System.out.println("�Բ���,���Ŀ����͸֧10000Ԫ");
				return;
			}
		}
		System.out.println("�����˻����Ϊ"+money+"Ԫ");
	}
	
	//�û���ѯ������
	public static void search (ArrayList<Account> stuarr,int index){
		if(index==-1){
			System.out.println("���Ƚ��е�¼����,лл���! ! !");
			return;
		}
		double money = stuarr.get(index).getBalance();
		System.out.println("�����˻����Ϊ"+money+"Ԫ"); 
	}
}
