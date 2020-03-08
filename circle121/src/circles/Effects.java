package circles;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Console;






public class Effects {
	public int pat1[]=new int[] {0,11,22,33,44,55,66,77,88,99,110};
	public int pat2[]=new int[] {0,1,2,3,4,5,6,7,8,9,10};
	public int pat3[]=new int[] {0,12,22,34,44,56,66,78,88,100,110};//w
	public int pat4[]=new int[] {1,11,23,33,45,55,67,77,89,99,111};//m
	public int patDiamondlvl0[]=new int[] {59,71,61,49};
	public int patDiamondlvl1[]=new int[] {38,48,58,70,82,72,62,50};
	public int patDiamondlvl2[]=new int[] {27,39,51,63,73,83,93,81,69,57,47,37};
	public int patDiamondlvl3[]=new int[] {16,28,40,52,64,74,84,94,104,92,80,68,56,46,36,26};
	public String patternOrderString[]=new String[1000];
	public int skip[]=new int[1000];
	public int levs[]=new int[1000];
	public int sleeps[]=new int[1000];
	public Color colorSequence[]=new Color[1000];
	public int posIndex=0;
	public int skipIndex=0;
	public Graphics graphicsEffects;
	public int looptimes;

	
	public Circle circle[];
	
	public Effects(Circle c[],Graphics gg) {
		this.circle=c;
		this.graphicsEffects=gg;
	}
	
	public void storePattern(String patterns[],int skipSteps,Color c[],int l[],int sec) {
		
		for(int i=0;i<skipSteps;i++) {
			levs[posIndex]=l[i];
			colorSequence[posIndex]=c[i];
			patternOrderString[posIndex++]=patterns[i];
		}
		sleeps[skipIndex]=sec;
		skip[skipIndex++]=skipSteps;
		//yo easy ko lagi
//		for(int i=0;i<posIndex;i++) {
//			System.out.println(patternOrderString[i]+levs[i]);
//		}
//		for(int i=0;i<skipIndex;i++) {
//			System.out.println(skip[i]);
//		}
	}
	
	
	public void getEffect(String option,Color c,int level) {
		if(option=="pattern1") {
			for(int node:pat1) {
				circle[node+level].turnOn(c);
			}
		}
		if(option=="pattern2") {
			System.out.println(level);
			for(int node:pat2) {
				circle[node+level*(11)].turnOn(c);
			}
		}
		if(option=="pattern3") {
			System.out.println(level);
			for(int node:pat3) {
				circle[node+level].turnOn(c);
			}
		}
		
		if(option=="pattern4") {
			System.out.println(level);
			for(int node:pat4) {
				circle[node+level].turnOn(c);
			}
		}
		
		if(option=="pattern5") {
			
			if(level==0) {
				for(int node:patDiamondlvl0) {
					circle[node].turnOn(c);
				}
			}
			if(level==1) {
				for(int node:patDiamondlvl1) {
					circle[node].turnOn(c);
				}
			}
			
			if(level==2) {
				for(int node:patDiamondlvl2) {
					circle[node].turnOn(c);
				}
			}
			
			if(level==3) {
				for(int node:patDiamondlvl3) {
					circle[node].turnOn(c);
				}
			}
		}
			
	}
	 void circleResetFromBack() {
		 int index=0;
			for(int i=1;i<=11;i++) {
				for(int j=1;j<=11;j++) {
					try {
						circle[index++]=new Circle(index,graphicsEffects,i*40,j*40);
					}
					catch(Exception exception){
						System.out.println(exception.getMessage());
					}
						
				}
			}
		}
	
	public void visualLoop() {
			for(int j=0;j<looptimes;j++) {
				int tempPosIndex=0;
				for(int i=0;i<skipIndex;i++) {
					int skipsNeeded=skip[i];
					
					
					while(skipsNeeded!=0) {
						
						getEffect(patternOrderString[tempPosIndex],colorSequence[tempPosIndex], levs[tempPosIndex]);
						
						skipsNeeded--;
						tempPosIndex++;
					}
					try {
					Thread.sleep(sleeps[i]);
					}catch(Exception e){
						
					}
					circleResetFromBack();
					
				}
			}

			
		
	}
	
}
