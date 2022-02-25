import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    //Integer a = ((int)(Math.random()*200)+1);
    /*Arr<Integer> Array = new Arr<Integer>();
    for(int i =0; i<=10000 ; i++){
			Array.add(((int)(Math.random()*1800)-900));
		}
    System.out.println(Array);
		System.out.println(Array.size());
		System.out.println(Array.get(Array.size()-1));
		System.out.println(Array.remove(Array.size()-1));
		System.out.println(Array.get(Array.size()-1));
		System.out.println(Array);
		Array.save("test");*/
		/*Arr<Integer> Array = new Arr<Integer>();
		for(int i=0; i<20;i++){
			Array.add(((int)(Math.random()*1800)-900));
		}*/
		//Array.save("test");
		Arr<String> array = new Arr<String>("./Data/test.arr");
		System.out.println(array);
  }
}


