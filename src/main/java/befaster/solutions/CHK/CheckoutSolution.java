package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int stringsize=skus.length();

        //A and B have special offers, we are going to count how many of them we are going to have.
        int countA=0;
        int CountB=0;

        // we add to this variable as we detect each sku
        int price=0;


        for (int i=0;i<stringsize;i++){
             // going to through each character of string one by one
            char x=skus.charAt(i);
            switch(x){
                case 'A':
                    // we just count how many A and b we have for now, later on we will add them to the price considering the discount
                    countA++;

                   break;
                case 'B':
                    CountB++;
                    break;
                case 'C':
                      price=price+20;
                    break;
                case 'D':
                      price=price+15;
                    break;
                default:

            }
            


        }





    }
}

