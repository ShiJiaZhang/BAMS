package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_Test {
	public static void main(String[] args) {
		//创建集合
		ArrayList<Account> stuarr = new ArrayList<>();
		int longin = -1;
		while(true){
			System.out.println("---------欢迎使用中国张行银行自助系统---------");
			System.out.println("请输入相对应的序号,进行业务办理:");
			System.out.println("1 账户开户\t\t2 用户登录");
			System.out.println("3 用户存款\t\t4 用户取款");
			System.out.println("5 查询余额\t\t6 退出登录");
			System.out.println("7 退出系统");
			//创建键盘录入对象
			Scanner sc = new Scanner(System.in);
			int nummber = sc.nextInt();
			switch (nummber) {
			case 1:
				//账户开户
				dredge(stuarr);
				break;
			case 2:
				//用户登录
				longin = login(stuarr);
				break;
			case 3:
				//用户存款
				deposit(stuarr,longin);
				break;
			case 4:
				//用户取款
				getMoney(stuarr,longin);
				break;
			case 5:
				//查询余额
				search(stuarr,longin);
				break;
			case 6:
				//退出登录
				System.out.println("成功退出中国张行银行自助系统,欢迎再次使用! ! !");
				longin = -1;
				break;
			case 7:
				//退出系统
			default:
				System.exit(0);
				break;
			}
		}
	}

	//账户开户
	public static int dredge(ArrayList<Account> stuarr){
		//创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		
		int id;
		while(true){
			System.out.println("请输入你想开通的账号:");
			id = sc.nextInt();
			if(index(stuarr,id)!=-1){
				System.out.println("账号被占用,请重新输入:");
			}else{
				break;
			}
		}
		
		int password;
		while(true){
			System.out.println("请输入你的密码(6位数字):");
			password = sc.nextInt();
			if(password < 100000 || password > 999999){
				System.out.println("密码不符合要求,请重新输入...");
				continue;
			}
			
			System.out.println("请重新输入确认密码:");
			int passwd = sc.nextInt();
			
			
			if(password != passwd){
				System.out.println("密码不一致,将返回重新输入:");
			}else{
				System.out.println("密码验证通过");
				break;
			}
			
		}
		
		System.out.println("请输入您的姓名:");
		String name = sc.nextLine();
		name = sc.nextLine();
		
		String personId;
		while(true){
			System.out.println("请输入您的身份证号码:");
			personId = sc.nextLine();
			
			if(personId.length()!=18){
				System.out.println("你输入的身份证格式不正确,请重新输入.");
			}else{
				break;
			}
		}
		
		int type;
		while(true){
			System.out.println("温馨提示:(0的时候表示储蓄账户,1的时候表示信用账户)");
			System.out.println("请输入账户类型:");
			type = sc.nextInt();
			
			if(type==0 || type==1){
				break;
			}else{
				System.out.println("你输入账户类型不正确,请重新输入");
			}
		}
		Account acc = new Account(id,password,name,personId,0,type);
		stuarr.add(acc);
		return id;
	}

	//id身份验证
	public static int index (ArrayList<Account> stuarr,int id){
		for (int i = 0; i < stuarr.size(); i++) {
			Account acc = stuarr.get(i);
			if(acc.getId()==id){
				return i;
			}
		}
		return -1;
	}

	//用户登录
	public static int login (ArrayList<Account> stuarr){
		//创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入账户名:");
			int id = sc.nextInt();
			
			int index = index(stuarr,id);
			if(index==-1){
				System.out.println("您输入的账户名错误,请重新输入");
				return -1;
			}
			
			
			int passwd = stuarr.get(index).getPassword();
			for (int i = 3; i > 0; i--) {
				System.out.println("请输入密码:");
				int password = sc.nextInt();
				
				if(passwd==password){
					System.out.println("登录成功");
					return index;
				}else{
					if(i==1){
						System.out.println("密码输入错误次数太多,强制退出! ! !");
						System.exit(1);
					}else{
						System.out.println("密码输入错误,你还有"+(i-1)+"次机会! ! !");
					}
				}
			}
		}
	}

	//用户存款操作
	public static void deposit(ArrayList<Account> stuarr,int index){
		if(index==-1){
			System.out.println("请先进行登录操作,谢谢配合! ! !");
			return;
		}
		
		System.out.println("请输入存款金额:");
		//创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		System.out.println("成功存入"+money+"元钱");
		money += stuarr.get(index).getBalance();
		stuarr.get(index).setBalance(money);
	}
	
	//用户取款操作
	public static void getMoney(ArrayList<Account> stuarr,int index){
		if(index==-1){
			System.out.println("请先进行登录操作,谢谢配合! ! !");
			return;
		}
		
		System.out.println("请输入取款金额:");
		//创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		money = stuarr.get(index).getBalance()-money;
		if(stuarr.get(index).getType()==0){
			if(money>=0){
				stuarr.get(index).setBalance(money);
			}else{
				System.out.println("对不起,您的卡型是储蓄卡,无法进行透支操作! ! !");
				return;
			}
		}else if(stuarr.get(index).getType()==1){
			if(money>=-10000){
				stuarr.get(index).setBalance(money);
			}else{
				System.out.println("对不起,您的卡最多透支10000元");
				return;
			}
		}
		System.out.println("您的账户余额为"+money+"元");
	}
	
	//用户查询余额操作
	public static void search (ArrayList<Account> stuarr,int index){
		if(index==-1){
			System.out.println("请先进行登录操作,谢谢配合! ! !");
			return;
		}
		double money = stuarr.get(index).getBalance();
		System.out.println("您的账户余额为"+money+"元"); 
	}
}
