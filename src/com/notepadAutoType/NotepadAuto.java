package com.notepadAutoType;

import org.sikuli.script.Screen;

public class NotepadAuto {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
			Screen s = new Screen();
			s.find("notepad.png"); //identify pause button
			//s.click("recycle.png"); //click pause button
			s.doubleClick();
			System.out.println("notepad open");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}
	}

}
