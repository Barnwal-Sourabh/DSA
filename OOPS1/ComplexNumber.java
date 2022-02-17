package OOPS1;

import java.util.Scanner;

public class ComplexNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumber c1 = new ComplexNumber(real1, imaginary1);
		ComplexNumber c2 = new ComplexNumber(real2, imaginary2);

		int choice = s.nextInt();

        
        s.close();
		if(choice == 1) {
            // Add
			c1.plus(c2);
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}
	}
    int real;
     int imaginary;
    
	public ComplexNumber(int real, int imaginary ){
        this.real = real;
        this.imaginary = imaginary;
    }
    public void plus(ComplexNumber c1){
        this.real = this.real + c1.real;
        this.imaginary = this.imaginary + c1.imaginary;
    }
    public void multiply(ComplexNumber c1){
        int i,r;
        i = (this.real * c1.imaginary) + (this.imaginary * c1.real);
    	r = this.real * c1.real - this.imaginary * c1.imaginary;
        this.real = r;
        this.imaginary = i;
    }
	public void print(){
        System.out.println(real+" + i" + imaginary);
    }
}

