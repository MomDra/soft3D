
public class Main {

	public static void main(String[] args) {
		Display display = new Display(800, 800, "Software Rendering");
		RenderContext target = display.GetFrameBuffer();
		Stars3D stars = new Stars3D(4096, 64.0f, 20.0f);
		
		Vertex minYVert = new Vertex(100, 100);
		Vertex midYVert = new Vertex(150, 200);
		Vertex maxYVert = new Vertex(80, 300);
		
		long previousTime = System.nanoTime();
;		
		while(true) {
			long currentTime = System.nanoTime();
			float delta = (float)((currentTime - previousTime)/1000000000.0f);
			previousTime = currentTime;
			
			//stars.UpdateAndRender(target, delta);
			target.Clear((byte)0x00);
			
			/*
			for(int j = 100; j<200; j++) {
				target.DrawScanBuffer(j, 300-j, 300+j);
			}*/
			
			target.ScanfConvertTriangle(minYVert, midYVert, maxYVert, 0);
			target.FillShape(100, 300);
			
			display.SwapBuffers();
		}
	}

}
