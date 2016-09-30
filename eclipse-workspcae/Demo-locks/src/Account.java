
public class Account {

	int id;
	private double balanace;
	
	public void deposit(double amount) throws InterruptedException{
		double balance = this.balanace;
		Thread.sleep(600);
		balance = balance+amount;
		this.balanace = balance;
	}
	public void withdraw(double amount) throws InterruptedException{
		double balance = this.balanace;
		Thread.sleep(600);
		balance = balance-amount;
		this.balanace = balance;
	}
	public double get_balancE()
	{
		return balanace;
	}
	public int getId() {
		return id;
	}
	
}
