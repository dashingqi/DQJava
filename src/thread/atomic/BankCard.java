package thread.atomic;

public class BankCard {
    private String accountName;
    private int money;

    public BankCard(String accountName, int money) {
        this.accountName = accountName;
        this.money = money;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "accountName='" + accountName + '\'' +
                ", money=" + money +
                '}';
    }
}
