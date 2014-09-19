package org.gt.exercise;

import java.util.ArrayList;

import java.util.Collections;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

 

public class FindFigures {

 

       static int [][] inputArr = {
                                         {1, 1, 1, 1, 1, 1,0,0,1},
                                         {1, 1, 1, 0, 1, 1,0,1,0},
                                         {1, 1, 0, 1, 0, 1,0,0,0},
                                         {1, 1, 1, 0, 1, 1,0,1,0},
                                         {1, 1, 1, 1, 1, 1,0,0,0},
                                         {1, 1, 1, 1, 1, 1,0,0,1}
                                         };
       static int figureCount=0;
       static String figureArray = "";
       static Map<String, String> figureMember = new HashMap<String, String>();
       
       public static void main(String[] args) {

              for (int i=0;i<inputArr.length;i++) {
                     for (int j=0;j<inputArr[i].length;j++) {
                           if (inputArr[i][j]==1 && !(figureMember.containsKey((""+i)+(""+j)))) {
                                  figureCount = figureCount+1;
                                  findFig(i,j,figureCount);
                           }
                     }
              }
              System.out.println("Figure Count -->"+figureCount);
              List<String> valueList = new ArrayList<String>();
              valueList.addAll(figureMember.values());
              Collections.sort(valueList);
              System.out.println("Figure Members::" + valueList.toString());
              System.out.println("Figure Members -->"+figureMember.toString());

       }

 

       static void findFig(int i,int j,int figureNumber){
              figureMember.put((""+i)+(""+j),figureNumber+("-"+i)+(""+j));
              if (i-1 >= 0) {
                     if (inputArr[i-1][j]==1 && !figureMember.containsKey((""+(i-1))+(""+j))) {
                           figureMember.put((""+(i-1))+(""+j),figureNumber+("-"+(i-1))+(""+j));
                           findFig(i-1,j,figureNumber);
                     };
              }

              if(i+1 < inputArr.length){
                     if(inputArr[i+1][j]==1 && !figureMember.containsKey((""+(i+1))+(""+j))) {
                           figureMember.put((""+(i+1))+(""+j),figureNumber+("-"+(i+1))+(""+j));
                           findFig(i+1,j,figureNumber);
                     };
              }

              if (j-1 >= 0) {
                     if (inputArr[i][j-1]==1 && !figureMember.containsKey((""+(i))+(""+(j-1)))) {
                           figureMember.put((""+(i))+(""+(j-1)),figureNumber+("-"+(i))+(""+(j-1)));
                           findFig(i,j-1,figureNumber);
                     };
              }

              if ( j+1 < inputArr[i].length) {
                     if(inputArr[i][j+1]==1 && !figureMember.containsKey((""+(i))+(""+(j+1)))){ 
                           figureMember.put((""+(i))+(""+(j+1)),figureNumber+("-"+(i))+(""+(j+1)));
                           findFig(i,j+1,figureNumber);

                     };

              }

 

       }

}



