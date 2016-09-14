import java.util.*;

public class packet_distribute{
	public static void main(String[] args){
		double Total_money;
		int Number;
		int cond=0;
		do{
			System.out.printf("请输入红包总金额：");
			Scanner moneyinput=new Scanner(System.in);
			Total_money=moneyinput.nextDouble();
			System.out.printf("请输入红包数：");
			Scanner numberinput=new Scanner(System.in);
			Number=numberinput.nextInt();
			if(Total_money<Number*0.01){			//钱少红包多，不能保证每个红包至少1分钱，重输
				System.out.printf("平均每个红包不足一分钱");
			}
			else
				cond=1;
		}while(cond==0);
		int i;
		int Random_sum=0;
		int[] Random=new int[Number];
		double[] packet=new double[Number];
		for(i=0;i<Number;i++){			//生成number个随机数并求和，用随机数除以总和得到的为每个红包应得的比例
			Random[i]=(int)(Math.random()*10000);
			Random_sum+=Random[i];
		}
		packet[Number-1]=Total_money;
		for(i=0;i<Number-1;i++){
			packet[i]=(Total_money-0.01*Number)*Random[i]/Random_sum+0.01;	//细节，每个红包至少一分钱
			packet[i]=packet[i]-packet[i]%0.01;		//细节，钱数只能两位小数
			packet[Number-1]-=packet[i];		//最后一个红包为剩下的钱
		}
		for(i=0;i<Number;i++)
			System.out.printf("红包%d：%.2f\n",i,packet[i]);
	}
}
