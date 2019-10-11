package befaster.solutions.SUM;

import befaster.runner.SolutionNotImplementedException;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {

        // x and y must be between 0 and 100, I assume including 100

        if((x<=100)&&(x>=0)){
            if((y<=100)&&(y>=0)){
                return x+y;
            }
        }
        else{
            // not in the instruction, return -1 if invalid parameters are given.
            return -1;
        }



    }

}

