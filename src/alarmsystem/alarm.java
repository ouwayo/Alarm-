package alarmsystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;



public class alarm {
	
	// class that holds alarm chosen melody/ sound.
	
	public static void playSound(String filepath) {

		try {
			File soundPath=new File(filepath); 
			if(soundPath.exists()) {
				
				AudioInputStream audioInput=AudioSystem.getAudioInputStream(soundPath); 
				Clip clip=AudioSystem.getClip();
				clip.open(audioInput);
				clip.start(); 
				JOptionPane.showMessageDialog(null,"Press OK to stop playing"); 
				
			}else {
				System.out.println("File is not there!");
			}
		}
			catch(Exception ex) {
				ex.printStackTrace(); 
			}
	}

	public static void main(String[] args) {
		
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		   // take current time 
		   
		   String currentTime=dtf.format(now); 
		   
		   // split to get hours, minutes and seconds
		   String[] hms = currentTime.split(" ");
		   
		   // after getting minutes, split it again to get minutes and hours 
		   String []  hmsa=hms[1].split(":"); 
		   String time=hmsa[0]+":"+hmsa[1]; 
		   
		   // Display current time. 
		   System.out.println("Alarm");
		   System.out.println("*******");
		   System.out.println("We are now at:"+currentTime); 
		   Scanner in = new Scanner(System.in);  
	       System.out.print("Set an Alarm, format HH:MM= "); 
	       
	       String alm = in.nextLine();
		  
		       // compare time give and current time. 
	       // Howver, for the sake of testing use exactly current time inorder to hear alarm. 
	       // if not cuurent time, it will give a message that it's not yet time. 
                 if(time.equals(alm)) {
                	 playSound("sound.wav");  
			   		   
                 } else {
                	 
                	 System.out.println("It's not yet time: wait till the time reached");
                 }
	   
		 
	}

}
