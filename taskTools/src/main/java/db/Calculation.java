package db;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Calculation
 *
 */
@Entity

public class Calculation {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    private double number1;
    private double number2;
    private String operation;
   
    public Calculation()
    {

    }
     
	public double getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public double getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
}
   
   

}
