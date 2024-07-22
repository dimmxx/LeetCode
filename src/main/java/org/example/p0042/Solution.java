package org.example.p0042;

class Solution {

//    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]


    public int trap(int[] height) {

        int finalTrapped = 0;

        for(int i = 0; i < height.length; i++){
            int tempMax = height[i];
            int tempInnerWater = 0;
            for(int j = i + 1; j < height.length; j++){

                if(height[j] >= tempMax){

                    finalTrapped =+ tempInnerWater;
                    tempInnerWater = 0;
                    i = j;
                    break;


                }else{
                    tempInnerWater = tempInnerWater + height[i] - height[j];
                }

            }




        }






        return finalTrapped;
    }
}
