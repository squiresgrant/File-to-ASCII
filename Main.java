import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.lang.*;
import javax.swing.*;


public class Main{
  public static void main(String args[])throws IOException{
		ProcessBuilder pb = new ProcessBuilder("python","Main.py").inheritIO();
		//ProcessBuilder star = new ProcessBuilder("pip", "install", "opencv-python").inheritIO();
		//Process e = star.start();
		/*
				try {
				e.waitFor();
				} catch(Exception c) {
					System.out.println("Error with .mp4 to .png/.jpg");
					return;
				}
				*/
		boolean forever = true;
		while (forever == true){
		String[] pathnames;
		

    BufferedImage img = null;
    File f = null;
		int pixel;
		File f1 = new File("Completed");  
		boolean value = f1.mkdir();
		File f2 = new File("Input");  
		try {
		value = f2.mkdir();
		}
		catch(Exception jnck) {}
		String last = "no";
		pathnames = f2.list();
		String[] pathnames2 = f1.list();
		for (String pathname : pathnames) {
            
			if (pathname.endsWith(".jpg")) {
				last = "Input/" + pathname;
				File using = new File(last);
				img = ImageIO.read(using);
				boolean end = using.delete();
				//aggggghhhhhhhhhh
				break;
			} else if (pathname.endsWith(".png")) {
				last = "Input/" + pathname;
				File using = new File(last);
				img = ImageIO.read(using);
				boolean end = using.delete();
				//aggggghhhhhhhhhh
				break;

			} else if (pathname.endsWith(".jpeg")) {
				last = "Input/" + pathname;
				File using = new File(last);
				img = ImageIO.read(using);
				boolean end = using.delete();
				//aggggghhhhhhhhhh
				break;

			} else if (pathname.endsWith(".txt")) {
				last = "Input/" + pathname;
				File using = new File(last);
				using.renameTo(new File("Completed/"+pathname));
				
				break;
			}
      }
			

		
		if (last == "no"){
			System.out.println("Could not find any (more) files");
			return;
		}

    //read image
		
		Formatter file = new Formatter("output.txt");

		int n = 1;
		Boolean run = true;
		while (run == true) {
			File temp5 = new File(f1, n+".txt");
			File temp6 = new File(f1, n+".png");
			if (temp5.exists() || temp6.exists()) {
			n+=1;
		} else {
			break;
		}
		}
	
		String nn = n+".txt";
		File file2_ = new File(f1, nn);
		Formatter file2 = new Formatter(file2_);
    //get image width and height
    int width = img.getWidth();
    int height = img.getHeight();
		BufferedImage NewImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
		/*
		System.out.println("Please enter the perfered size of your photo (1 is the biggest)");
		Scanner i = new Scanner(System.in);
		int a = i.nextInt();
		*/ 

		      
		int a = 1;  
		if (width >= 300) {
			a = 2;
		}
		if (width >= 1000) {
			a = 3;						
		}  
		if (width >= 1500) {
			a = 6;
		}     
		if (width >= 2000) {
			a = 10;
		} 
		
	
		//for (int row = 0; row < height; row++) {
			for (int row = 0; row < height; row=row+a) {
			//for (int col = 0; col < width; col++) {
				for (int col = 0; col < width; col=col+a) {

			try {
			pixel = img.getRGB(col, row);
			//System.out.println(pixel);
			Color color = new Color(pixel, true);
      //Retrieving the R G B values
      int red = color.getRed();
			//if (red >= 100) {
				//MainFile.format("%s", "@");
			//} else {
			
			//}
    	int green = color.getGreen();
      int blue = color.getBlue();
			file.format("%s %s %s %s %s %s %s %s %s %s %s ", red, green, blue, "(" ,pixel, ")", "|R: ", row, "|C: ", col, "\n");
			//NewImage.setRGB(col, row, pixel);
			//ImageIO.write(NewImage, "jpg", new File("out.jpg"));
			
			String out = "_";
			
			if (red <= 240 && green <= 240 && blue <= 240) {
				out = "  ";
			}
			if (red <= 230 && green <= 230 && blue <= 230) {
				out = "-'";
			}
			if (red <= 220 && green <= 220 && blue <= 220) {
				out = "~";
			}
			if (red <= 180 && green <= 180 && blue <= 180) {
				out = "t";
			}
			if (red <= 170 && green <= 170 && blue <= 170) {
				out = "i'";
			}
			if (red <= 160 && green <= 160 && blue <= 160) {
				out = "!";
			}
			if (red <= 150 && green <= 150 && blue <= 150) {
				out = "2";
			}
			if (red <= 140 && green <= 140 && blue <= 140) {
				out = "L";
			}
			if (red <= 130 && green <= 130 && blue <= 130) {
				out = "T";
			}
			if (red <= 120 && green <= 120 && blue <= 120) {
				out = "l'";
			}
			if (red <= 110 && green <= 110 && blue <= 110) {
				out = "R";
			}
			if (red <= 100 && green <= 100 && blue <= 100) {
				out = "5";
			}
			if (red <= 90 && green <= 90 && blue <= 90) {
				out = "7";
			}
			if (red <= 80 && green <= 80 && blue <= 80) {
				out = "3";
			}
			if (red <= 70 && green <= 70 && blue <= 70) {
				out = "9";
			}
			if (red <= 60 && green <= 60 && blue <= 60) {
				out = "6";
			}
			if (red <= 50 && green <= 50 && blue <= 50) {
				out = "E";
			}
			if (red <= 40 && green <= 40 && blue <= 40) {
				out = "$";
			}
			if (red <= 30 && green <= 30 && blue <= 30) {
				out = "&";
			}
			if (red <= 20 && green <= 20 && blue <= 20) {
				out = "H";
			}
			if (red <= 10 && green <= 10 && blue <= 10) {
				out = "#";
			}
			if (red <= 0 && green <= 0 && blue <= 0) {
				out = "@";
			}
			
			file2.format("%s %s", out, " ");
			

			/*
			System.out.println("----");
			System.out.println("Row:");
			System.out.println(row);
			System.out.println("Col:");
			System.out.println(col);
			*/
			
			//System.out.println(NewImage);
			
			}catch(Exception wjdcnjj){
				break;
			}
		
			

		}
		file2.format("%s", "\n");
		int percent = row;
			System.out.print(percent + " / " + width);
			System.out.print("\n");
	}
	Process p = pb.start();
	try {
	p.waitFor();
	} catch(Exception eww) {
		System.out.println("Error with .txt to .png");
	}
	System.out.println("Completed :)\n\nSaved under "+nn+"\n------\nFor best results copy and past the .txt file into notepad++\n\n(loading number may have ended on a weird number :) it does that sometimes)");
	
	file2.close();

	}
		
}}
