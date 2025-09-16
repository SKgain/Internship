package question6;

 public final class AccountFactory extends Account {

     public static Account createAccount(String type) {
         return switch (type) {
             case "Saving" -> new SavingAccount();
             case "Current" -> new CurrentAccount();
             default -> null;
         };
     }
 }
