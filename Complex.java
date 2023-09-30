package complexmatrix;

public class Complex implements Comparable<Complex> {
	private double real;
	private double imaginary;

	Complex() {
		this.real = 0;
		this.imaginary = 0;
	}
	
	Complex(double a) {
		this.real = a;
		this.imaginary = 0;
	}
	
	Complex(double a, double b) {
		this.real = a;
		this.imaginary = b;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginary() {
		return imaginary;
	}

	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}

	@Override
	public String toString() {
		String img_operation = this.getImaginary() < 0 ? " - " : " + ";
		return "(" + this.getReal() + img_operation + "i" + Math.abs(this.getImaginary()) + ")";
	}

	public double getMagnitude() {
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
	}

	public Complex add(Complex c) {
		return new Complex(this.getReal() + c.getReal(), this.getImaginary() + c.getImaginary());
	}

	public Complex subtract(Complex c) {
		return new Complex(this.getReal() - c.getReal(), this.getImaginary() - c.getImaginary());
	}

	public Complex multiply(Complex c) {
		double newReal = (this.getReal() * c.getReal() - this.getImaginary() * c.getImaginary());
		double newImaginary = (this.getReal() * c.getImaginary() + this.getImaginary() * c.getReal());
		return new Complex(newReal, newImaginary);
	}

	public Complex divide(Complex c) {
		double newReal = (
				this.getReal() * c.getReal() + this.getImaginary() * c.getImaginary()
				) / (Math.pow(c.getReal(), 2) + Math.pow(c.getImaginary(), 2));
		double newImaginary = (
				this.getImaginary() * c.getReal() - this.getReal() * c.getImaginary()
				) / (Math.pow(c.getReal(), 2) + Math.pow(c.getImaginary(), 2));
		return new Complex(newReal, newImaginary);
	}

	@Override
	public int compareTo(Complex o) {
		if(this.getMagnitude() < o.getMagnitude()) {
			return -1;
		} else if(this.getMagnitude() > o.getMagnitude()) {
			return 1;
		} else {
			return 0;
		}
	}
}
