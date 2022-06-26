package OOPS1;

public class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setImaginary(int imaginary){
        this.imaginary = imaginary;
    }
    public void setReal(int real){
        this.real = real;
    }

    public int getImaginary(){
        return imaginary;
    }
    
    public int getReal(){
        return real;
    }

    public void print(){
        System.out.println(real +" + i"+imaginary);
    }

    public void add(ComplexNumber c2){
        this.real = this.real + c2.real;
        this.imaginary = this.imaginary + c2.imaginary;
    }

    public void multiply(ComplexNumber c1){
        int i,r;
        i = (this.real * c1.imaginary) + (this.imaginary * c1.real);
    	r = this.real * c1.real - this.imaginary * c1.imaginary;
        this.real = r;
        this.imaginary = i;
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2 ){
        int newReal = c1.real + c2.real;
        int newImaginary = c1.imaginary + c2.imaginary;
        ComplexNumber c = new ComplexNumber(newReal, newImaginary);
        return c;
    }
    
    public ComplexNumber conjugate(){
        int newReal = real;
        int newImaginary =- imaginary; 
        ComplexNumber c = new ComplexNumber(newReal, newImaginary);
        return c;
    }
   
}
