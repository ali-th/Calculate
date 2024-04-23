package CalcEntity;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity
public class Calculation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int num1,num2;
	char operation;
	
	public Calculation(){}
	
	public int getid() {
		return id;
	}
	
	public int getNum1(){
		return num1;
	}
	
	public int getNum2(){
		return num2;
	}
	
	public void setNum1(int n){
		this.num1 = n;
	}
	
	public void setNum2(int n){
		this.num2 = n;
	}
	
	public void setOperation(char op){
		this.operation = op;
	}

	public char getOperation(){
		return operation;
	}

	public double calculate(int n1, int n2, char op) {
	    double result;
	    
	    switch(op) {
	    
	        case '+':
	            result = n1 + n2;
	            break;
	        case '-':
	        	result = n1 - n2;
	            break;
	        case '*':
	            result = n1 * n2;
	            break;
	        case '/':
	            if (n2 != 0) {
	                result = (double) n1 / n2;
	                
	            } else {
	                
	                result = Double.POSITIVE_INFINITY;
	            }
	            break;
	        default:
	            result = Double.NaN; 
	            break;
	    }
	    return result;
	}
}
