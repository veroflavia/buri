package ch06.ejb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FibNum {
	private int n;
	private int f;

	public FibNum() {

	}
    @Id
	public int getN() {
		return n;
	}
	public void setN(int n){
		this.n = n;
	}
	
	public int getF() {
		return n;
	}
	public void setF(int f){
		this.f = f;
	}

}
