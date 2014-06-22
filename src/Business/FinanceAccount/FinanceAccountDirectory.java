/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FinanceAccount;

import Business.FinanceAccount.FinanceAccount.FinanceAccountType;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class FinanceAccountDirectory {
     private ArrayList<FinanceAccount> FinanceAccountList=new ArrayList<>();

    public ArrayList<FinanceAccount> getFinanceAccountList() {
        return FinanceAccountList;
    }

    public void setFinanceAccountList(ArrayList<FinanceAccount> FinanceAccountList) {
        this.FinanceAccountList = FinanceAccountList;
    }

  
       public FinanceAccount createFinanceAccount(FinanceAccountType type){
        FinanceAccount financeAccount = null;
        if (type.getValue().equals(FinanceAccountType.In.getValue())){
            financeAccount = new InAccount();
            FinanceAccountList.add(financeAccount);
        }
        else if (type.getValue().equals(FinanceAccountType.Out.getValue())){
          financeAccount = new OutAccount();
            FinanceAccountList.add(financeAccount);
        }
         else if(type.getValue().equals(FinanceAccountType.TrasactionAccount.getValue())){
             financeAccount = new TrasactionAccount();
            FinanceAccountList.add(financeAccount);
        }
        else if(type.getValue().equals(FinanceAccountType.Personal.getValue())){
            financeAccount = new PersonalAccount();
            FinanceAccountList.add(financeAccount);
        }
        return financeAccount;
    }
}
