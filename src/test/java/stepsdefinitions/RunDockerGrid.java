package stepsdefinitions;

import org.junit.Test;

public class RunDockerGrid {
	@Test
	public void stopDockerGrid() throws Exception {
		Runtime.getRuntime().exec("cmd /c stop_dockergrid.bat");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");	
	}
	
	@Test
	public void startDockerGrid() throws Exception {
		Runtime.getRuntime().exec("cmd /c start_dockergrid.bat");
		Thread.sleep(20000);
	}
}
