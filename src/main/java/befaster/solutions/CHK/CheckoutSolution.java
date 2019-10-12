package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int stringsize=skus.length();

        //A and B have special offers, we are going to count how many of them we are going to have.
        int countA=0;
        int countB=0;

        //need to count E
        int countE=0;

        //need to count F
        int countF=0;

        // we add to this variable as we detect each sku
        int price=0;
        boolean illegalinput=false; //illegal input any letter other than skus,



        for (int i=0;i<stringsize;i++){
             // going to through each character of string one by one
            char x=skus.charAt(i);
            switch(x){
                case 'A':
                    // we just count how many A and b we have for now, later on we will add them to the price considering the discount
                    countA++;

                   break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                      price=price+20;
                    break;
                case 'D':
                      price=price+15;
                    break;
                case 'E':
                     price=price+40;
                     countE++;
                     break;

                case 'F':

                    countF++;
                    break;

                default:
                    illegalinput=true;

            }



        }

        //3A =150 , now 5A is for 200
        int fdiscountsA=countA/5;  // this many of *200, discount when there is 5

        countA = countA % 5; // after we have taken away all sets of five

        int discountsA= countA/3; // with discount for 3 A

        int singleA=countA%3; // without discount

        price=price+(fdiscountsA*200)+(discountsA*130)+(singleA*50);

        int numberof2Es=countE/2; // for example countE=10; we have 5 2Es so we need to reduce 5 from countB


        countB=countB-numberof2Es;
        if(countB<0){
            countB=0;
        }


        int discountsB= countB/2; // with discount
        int singleB=countB%2; // without discount
        price=price+(discountsB*45)+(singleB*30);

        // pricing of F
        // 2 F get one free
        // we always need to have 3 in the basket
        if(countF>3){
              int extraF=countF-3; // we need to keep at least 3 in the basket
              price=price+(3*10);

              int number_free_F=extraF/2;

              extraF=extraF-number_free_F;

             price=price+(extraF*10);
        }

        else {
            price = price + (countF * 10);
        }

        if(illegalinput==false) {
            return price;
        }else{
            return -1;

        }



    }
}

