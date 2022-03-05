import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    //Integer a = ((int)(Math.random()*200)+1);
    Arr<Integer> Array = new Arr<Integer>();
    for(int i =0; i<10 ; i++){
			Array.add(((int)(Math.random()*1800)-900));
		}
		Array.save("test");
		/*Arr<Integer> Array = new Arr<Integer>();
		for(int i=0; i<20;i++){
			Array.add(((int)(Math.random()*1800)-900));
		}*/
		//Array.save("test");
		Path path = Paths.get("./Data/test.arr");
		Arr<String> array = new Arr<String>(path);
		System.out.println(array);
  }
}


