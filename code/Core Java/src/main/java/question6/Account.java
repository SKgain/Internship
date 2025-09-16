package question6;

public sealed class Account permits AccountFactory, CurrentAccount, SavingAccount {

    public void getName() {}
}
