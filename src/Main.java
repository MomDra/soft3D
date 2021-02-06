
public class Main {

	public static void main(String[] args) {
		Display display = new Display(800, 800, "Software Rendering");
		RenderContext target = display.GetFrameBuffer();
		Stars3D stars = new Stars3D(4096, 64.0f, 20.0f);
		
		long previousTime = System.nanoTime();
;		
		while(true) {
			long currentTime = System.nanoTime();
			float delta = (float)((currentTime - previousTime)/1000000000.0f);
			previousTime = currentTime;
			
			//stars.UpdateAndRender(target, delta);
			target.Clear((byte)0x00);
			
			for(int j = 100; j<200; j++) {
				target.DrawScanBuffer(j, 300-j, 300+j);
			}
			
			target.FillShape(100, 200);
			
			display.SwapBuffers();
		}
	}

}
