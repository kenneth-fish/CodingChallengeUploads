
import java.util.*;

import java.io.*;

import java.lang.Math;
/*
 * COMPLETE! ^_^
 */
//The problem presented here was to insert integers such that the array becomes balanced
//i.e. same number of elements and same sum in both halves
//it was required to print the number of operations and where things were placed

public class June30

{

  public static int[] minOperations(int N, int[]A)

  {

    int[] result = {0, 0, 0 ,0, 0};

    int firstHalf = 0;

    int secondHalf = 0;

    if(A.length % 2 == 0){
        for (int i = 0; i < (N / 2); i++){

            firstHalf += A[i];
      
          }
      
          //System.out.println(firstHalf);
      
          for (int i = N - 1; i >= N / 2; i--){
      
            secondHalf += A[i];
      
          }

          //System.out.println(secondHalf);

          if(firstHalf == secondHalf){
          }else if (firstHalf > secondHalf){
            result[0] = 2;
            result[1] = 0;
            result[2] = 1;
            result[3] = Math.abs(firstHalf-secondHalf);
            result[4] = A.length + 2;
          }else if(secondHalf > firstHalf){
            result[0] = 2;
            result[1] = Math.abs(firstHalf-secondHalf);
            result[2] = 1;
            result[3] = 0;
            result[4] = A.length + 2;
          }
      

    }else{
        result[0] = 1;
        //this is default OUTPUT. You can change it.

        //odd case

        

        for (int i = 0; i < (N / 2) + 1; i++){

        firstHalf += A[i];

        }

        //System.out.println(firstHalf);

        for (int i = N - 1; i >= N / 2; i--){

        secondHalf += A[i];

        }

        //System.out.println(secondHalf);

        if (firstHalf > secondHalf){

        secondHalf -= A[N/2];

        result[2] = A.length + 1;

        }else{

        firstHalf -= A[N/2];

        result[2] = 1;

        }

        result[1] = Math.abs(firstHalf-secondHalf);
    }



    //write your Logic here:





      return result;

  }

  public static void main (String[]args)

  {

    Scanner sc = new Scanner (System.in);



    //INPUT [uncomment & modify if required]

    int N = sc.nextInt ();

    int[] A = new int[N];



    for (int i = 0; i < N; i++)

    {

        A[i] = sc.nextInt ();

    }

    sc.close ();



    //OUTPUT [uncomment & modify if required]

    int[] returned = minOperations(N, A);
    if(returned[0] == 0){
        System.out.println(returned[0]);
    }else if(returned[3] == 0){
        System.out.println(returned[0] + " " + returned[1] + " " + returned[2]);
    }else{
        System.out.println(returned[0] + " " + returned[1] + " " + returned[2] + " " + returned[3] + " " + returned[4]);
    }

  }

}
