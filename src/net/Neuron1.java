package net;

import java.util.Random;

public class Neuron1 {
		double wagi[] =new double[13];
		double prog;
		double wsp=0.1;
		
		
		
		
		public Neuron1(){
			System.out.print("new neuron1 wagi:");
			Random r =new Random();
			for (int i=0;i<wagi.length;i++){
			wagi[i]=(r.nextDouble()*2)-1;
			wagi[i]=this.round(wagi[i]);
			System.out.print(" "+wagi[i]);
			}
			prog=r.nextInt(1);
			System.out.println(" prog:"+prog);
			
		}
		
		public Neuron1(double[] w){
			System.out.println(" loading neuron1 wagi: ");
			for (int i=0;i<wagi.length-1;i++){
			wagi[i]=w[i];
			System.out.print(" "+wagi[i]);
			}
			prog=w[wagi.length];
			System.out.println(" prog:"+prog);
		}
		
		public double wylicz(double[] vect){
			double rez=0;
			
			double net=0.0;
			for(int i=0;i<wagi.length;i++){
				net+=wagi[i]*vect[i];
			}
			double y=net+prog;
			rez = 1/(1+Math.pow(Math.E,-y));	
			return this.round(rez);
		}
		
		public void uczenie(double[] vect,double blad){
			//System.out.println("Neuron "+n+" uczenie nowe wagi: ");
			for(int i=0;i<wagi.length;i++){
				wagi[i]=wagi[i]+wsp*blad*vect[i];
				wagi[i]=this.round(wagi[i]);
				//System.out.print(" "+wagi[i]);
			}
			prog=prog+wsp*blad;
			prog=this.round(prog);
			//System.out.println(" new prog"+prog);
			
		}
		
		
		
		public double round(double l){
			return l;
		}
	
}