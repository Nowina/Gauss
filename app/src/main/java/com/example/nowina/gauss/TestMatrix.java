package com.example.nowina.gauss;

public class TestMatrix {

	public static void main(String[] args) {
		/*
		 Solving two variable linear equation system
		  3x + y = 6
		 -2x + y = 3
		*/
		
		// arrays representing equations
		double[][] lhsArray = { { 4, 3, 2}, { 5, 4, 1 }, { 2, 2, 3 }};	// left hand side
		double[] rhsArray = { 16, 16, 15 };					// right hand side
		
		// matrix object left hand side
		Matrix A = new Matrix(lhsArray);
		A.show();
		System.out.println();
		
		// matrix object right hand side
		Matrix B = new Matrix(rhsArray);
		B.show();
		System.out.println();
		
		// Calculate Solved Matrix x
		Matrix x = A.solve(B);
		
		x.show();
		
		// Print Answers
		for (int i = 0; i < x.rows(); i++)
			System.out.printf("x%d = %f\n", i+1, x.get(i, 0));
	}

}
