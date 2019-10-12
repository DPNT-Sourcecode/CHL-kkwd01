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

        //challenge 4 , the ones with discount need count.
        int countH=0;
        int countK=0;
        int countN=0;
        int countP=0;
        int countQ=0;
        int countR=0;
        int countU=0;
        int countV=0;
        int countM=0;


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
                case 'G':
                    price=price+20;
                    break;
                case 'H':
                    countH++;
                    break;
                case 'I':
                    price=price+35;
                    break;
                case 'J':
                    price=price+60;
                    break;
                case 'K':
                    countK++;
                    break;
                case 'L':
                    price=price+90;
                    break;
                case 'M':
                    countM++;
                    //price=price+15;
                    break;
                case 'N':
                    price=price+40;
                    countN++;
                    break;
                case 'O':
                    price=price+10;
                    break;
                case 'P':
                    countP++;
                    break;
                case 'Q':
                    countQ++;
                    break;
                case 'R':
                    price=price+50;
                    countR++;
                    break;
                case 'S':
                    price=price+30;
                    break;
                case 'T':
                    price=price+20;
                    break;
                case 'U':
                    countU++;
                    break;
                case 'V':
                    countV++;
                    break;
                case 'W':
                    price=price+20;
                    break;
                case 'X':
                    price=price+90;
                    break;
                case 'Y':
                    price=price+10;
                    break;
                case 'Z':
                    price=price+50;
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
        if(countF>2){
               // now i undestand the question, each time we have 3 fs it will become 2.
               int pair_3f=countF/3;

               countF=countF-pair_3f;

               price = price + (countF * 10);


        }

        else {
            price = price + (countF * 10);
        }
        //challenge 4 , the rest of the table
        //I can re-use variables, but I want my code to be really readable.
        int number_Hdiscount_ten= countH/10;
        //10H is for 80
        price=price+ (number_Hdiscount_ten*80);
        // the rest

        countH = countH % 10;
        if(countH>0) {
            int number_Hdiscount_fives= countH/5;
            price=price+ (number_Hdiscount_fives*45);
            // the rest again
            countH = countH % 5;
            if(countH>0){
                price=price+(10*countH);
            }
        }

       //K
        int number_kdiscount_two=countK/2;
        price=price+(number_kdiscount_two*150);
        countK=countK%2;
        price=price+(countK*80);

        //N
        int number_free_M=countN/3;

        //M
        if (countM>number_free_M){
            countM=countM-number_free_M;
        }
        else{
            countM=0;
        }
        price=price+(countM*15);

        //P
        int number_discount_p=countP/5;
        countP=countP%5;

        price=price+(countP*50)+(number_discount_p*200);

        //R should be above Q, so we know how many countQ we are going to have
          int reduce_from_Q=countR/3;
          if(countQ>reduce_from_Q){
              countQ=countQ-reduce_from_Q;

          }
          else{
              countQ=0;
          }

        //Q
        if(countQ>0) { // we dont need this if, but is readable
            int number_discount_Q = countQ / 3;
            countQ = countQ % 3;

            price = price + (countQ * 30) + (number_discount_Q * 80);
        }
        //U
        int freeU=countU/3;
        countU=countU-freeU;
        price=price+(countU*40);




















        if(illegalinput==false) {
            return price;
        }else{
            return -1;

        }



    }
}





