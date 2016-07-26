import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;


public class PlayYoutubeVideo 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		  try {
			Thread.sleep(2000);
			Screen s = new Screen();
			s.find("recycle.png"); //identify pause button
			//s.click("recycle.png"); //click pause button
			s.doubleClick();
			System.out.println("recycle bin open");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}

	}
}
