package com.example.Mandelbrot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class MandelbrotApplication {
	public static void main(String[] args) {
//		SpringApplication.run(MandelbrotApplication.class, args);

		FractalExplorer displayExplorer = new FractalExplorer(400);
		displayExplorer.createAndShowGUI();
		displayExplorer.drawFractal();

	}

}
