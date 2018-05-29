package net;

import java.util.Random;

public class Neuron2 {

	double wagi[] =new double[4];
	double prog;
	double wsp=0.1;
	
	
	public Neuron2(){
		System.out.print("new Neuron2 wagi:");
		Random r =new Random();
		for (int i=0;i<wagi.length;i++){
		wagi[i]=(r.nextDouble()*2)-1;
		wagi[i]=this.round(wagi[i]);
		System.out.print(" "+wagi[i]);
		}
		prog=r.nextInt(1);
		System.out.println(" prog:"+prog);
	}
	
	public Neuron2(double[] w){
		System.out.println(" loading neuron1 wagi: ");
		for (int i=0;i<wagi.length-1;i++){
		wagi[i]=w[i];
		System.out.print(" "+wagi[i]);
		}
		prog=w[wagi.length];
		System.out.println(" prog:"+prog);
	}
	
	public int wylicz(double[] vect){
		int rez=0;
		
		double net=0.0;
		for(int i=0;i<wagi.length;i++){
			net+=wagi[i]*vect[i];
		}
		double y=net+prog;
		rez = y >= 0? 1 : 0;
		//rez = 1/(1+Math.pow(Math.E,-y));	
		//return this.round(rez);
		return rez;
	}
	
	public void uczenie(double[] y,double blad){
		//System.out.println("Neuron "+n+" uczenie nowe wagi: ");
		for(int i=0;i<wagi.length;i++){
			wagi[i]=wagi[i]+wsp*blad*y[i];
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