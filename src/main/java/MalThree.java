/* This malicious node only broadcasts transactions from its even numbered followees*/

import java.util.ArrayList;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class MalThree implements Node {

   Set<Transaction> pendingTransactions;

   public MalThree(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
   }

   public void setFollowees(boolean[] followees) {
      return;
   }

   public void setPendingTransaction(Set<Transaction> pendingTransactions) {
      this.pendingTransactions = pendingTransactions;
   }

   public Set<Transaction> sendToFollowers() {
      return pendingTransactions;
   }

   // accept all transactions from even followees
   public void receiveFromFollowees(Set<Candidate> candidates) {     
      for(Candidate candidate : candidates) {
         if (candidate.sender % 2 == 0) { 
            if(!this.pendingTransactions.contains(candidate.tx))
               this.pendingTransactions.add(candidate.tx);
         }  
      }
   }
}
