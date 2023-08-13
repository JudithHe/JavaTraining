import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsTest{
    public static void main(String[] args){
        //HashSet<Account> accounts = new HashSet<Account>();
        Set<Account> accounts = new TreeSet<Account>(new AccountComparator());
        //Set<Account> accounts = new TreeSet<Account>(new AccountComparator());
        String[] names = {"a","b","c"};
        double[] balance = {4.0,2.0,3.0};
        for(int i = 0;i<3;i++){
            Account acc = new Account();
            acc.setAccountName(names[i]);
            acc.setBalance(balance[i]);
            accounts.add(acc);
        }
        //iterator
        Iterator<Account> iter = accounts.iterator();
        while(iter.hasNext()){
            Account acc = iter.next();
            System.out.println(acc.getAccountName());
            System.out.println(acc.getBalance());
            acc.addInterest();
            System.out.println(acc.getBalance());
        }
    }
}
