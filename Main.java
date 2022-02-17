class Main {
  public static void main(String[] args) {
    //Integer a = ((int)(Math.random()*200)+1);
    Arr<Integer> Array = new Arr<Integer>();
    for(int i =0; i<=100 ; i++){
			Array.add(((int)(Math.random()*1800)-900));
		}
    System.out.println(Array);
		System.out.println(Array.size());
		System.out.println(Array.get(Array.size()-1));
		System.out.println(Array.remove(Array.size()-1));
		System.out.println(Array.get(Array.size()-1));
		System.out.println(Array);
		Array.save("test");
  }
}
