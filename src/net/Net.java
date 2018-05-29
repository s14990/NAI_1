package net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Net {

	
	HashMap<Integer,int[]> keys=new HashMap<>();
	int key1[]={1,0};
	int key2[]={0,1};
	int key3[]={1,1};
	Neuron1 n1;
	Neuron1 n2;
	Neuron1 n3;
	Neuron1 n4;
	Neuron2 n5;
	Neuron2 n6;
    List<Neuron1> warstwa1;
    List<Neuron2> warstwa2;
	
	//Load net from file
	public Net(String filename){
		
	}
	//New Net
	public Net(){
		//warstwa1
		n1=new Neuron1();
		n2=new Neuron1();
		n3=new Neuron1();
		n4=new Neuron1();
		warstwa1=new ArrayList<>();
		warstwa1.add(n1);
		warstwa1.add(n2);
		warstwa1.add(n3);
		warstwa1.add(n4);
		//Warstwa2
		n5=new Neuron2();
		n6=new Neuron2();
		warstwa2=new ArrayList<>();
		warstwa2.add(n5);
		warstwa2.add(n6);
		
		keys.put(1, key1);
		keys.put(1, key1);
		keys.put(1, key1);
	}
	//Lista z wagami kazdego i prog na koniec
	public Net(ArrayList<double[]> l){
		n1=new Neuron1(l.get(0));
		n2=new Neuron1(l.get(1));
		n3=new Neuron1(l.get(2));
		n4=new Neuron1(l.get(3));
		warstwa1=new ArrayList<>();
		warstwa1.add(n1);
		warstwa1.add(n2);
		warstwa1.add(n3);
		warstwa1.add(n4);
		n5=new Neuron2(l.get(4));
		n6=new Neuron2(l.get(5));
		warstwa2=new ArrayList<>();
		warstwa2.add(n5);
		warstwa2.add(n6);
	}
	
	
	public int wylicz(double[] v){
		double net1[]=new double[warstwa1.size()];
		int tmp=0;
		for(Neuron1 n: warstwa1){
			net1[tmp]=n.wylicz(v);
			tmp+=1;
		}
		int net2[]=new int[warstwa2.size()];
		tmp=0;
		for(Neuron2 n: warstwa2){
			net2[tmp]=n.wylicz(v);
			tmp+=1;
		}
		if(net2[0]==1 && net2[1]==0)
			return 1;
		else if(net2[0]==0 && net2[1]==1)
			return 2;
		else if(net2[0]==1 && net2[1]==1)
			return 3;
		else return 0;
	}
	
	public void ucz(double[] v,int[] target){
		double net1[]=new double[warstwa1.size()];
		int tmp=0;
		for(Neuron1 n: warstwa1){
			net1[tmp]=n.wylicz(v);
			tmp+=1;
		}
		int net2[]=new int[warstwa2.size()];
		tmp=0;
		for(Neuron2 n: warstwa2){
			net2[tmp]=n.wylicz(v);
			tmp+=1;
		}
		
		double[] blad2=new double[warstwa2.size()];
		for(int a=0;a<blad2.length;a++){
			blad2[a]=net2[a]*(1-net2[a])*(target[a]-net2[a]);
		}

		tmp=0;
		for(Neuron2 n: warstwa2){
			n.uczenie(net1, blad2[tmp]);
			tmp+=1;
		}
		tmp=0;
		double[] blad1=new double[warstwa1.size()];
		for(Neuron1 n: warstwa1){
		blad1[tmp]=(net1[tmp]*(1-net1[tmp]))*n5.wagi[tmp]*blad2[0]+n6.wagi[0]*blad2[1];
		n.uczenie(v, blad1[tmp]);
		}

	}
	public void uczenie(){
		//HashSet<> s=new HashSet();
		
	}
	public void log(String s){
		System.out.println(s);
	}
}
