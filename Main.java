class Main {
  public static void main(String[] args) {
    Integer a = 10;
    Arr<Integer> Array = new Arr<Integer>();
    for(int i =0; i<= ((int)(Math.random()*200)+1); i++){
			Array.add(((int)(Math.random()*1800)-900));
		}
    System.out.println(Array);
  }
}
