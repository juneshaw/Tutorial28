class Machine {
	public void start() {
		System.out.println("Machine started");
	}
}

class Camera extends Machine{

	@Override
	public void start() {
		System.out.println("Camera started");
	}
	
	public void snap() {
		System.out.println("Picture taken");
	}
	
}
public class App {

	public static void main(String[] args) {

		Machine machine1 = new Machine();
		Camera camera1 = new Camera();
		
		machine1.start();
		camera1.start();
		camera1.snap();
		
		// Upcasting (inherently safe...a child is always of type of parent
		// You can use a child type anywhere you would expect the parent type.
		// (The type of the variable determines what methods you can call, BUT
		// the actual type of the object determines which of the methods (overrides) you call.)
		System.out.println("Upcasting example");
		Machine machine2 = new Camera(); // this is okay, AND also
		Machine machine4 = camera1;  // this is okay too.
		machine2.start();
		machine4.start();
		// You can't do this because a machine type does not have a snap method,
		// that is inherent to its child in this case.
		// machine4.snap();
		
		// Downcasting (inherently unsafe)
		Machine machine3 = new Camera();
		// This is illegal since a 'machine' does not have the snap method, its child does
		// machine3.snap();
		// But this is legal to downcast...you are letting the compiler that you 
		// really know what you are doing and this particular Machine actually is a Camera child
		System.out.println("Downcasting example");
		Camera camera2 = (Camera)machine3;
		camera2.start();
		camera2.snap();
		
		// Unsafe downcasting
		System.out.println("Downcasting runtime error");
		Machine machine5 = new Machine();
		Camera camera3 = (Camera)machine5;
		camera3.snap();
		
	}

}
