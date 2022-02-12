import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

class Arr <dataType> {

  private Object[] data;
  private Object[] data0;
  private int len =0;
	private static int id =1;
 
  public Arr(int d){ 
    data = new Object[d];   
    data0 = new Object[d+1];
    len = d-1;
  }
  public Arr(){ 
    data = new Object[1];   
    data0 = new Object[1];   
  }

  public dataType get(int index){
    if(index > len){
      index = len -1;
    }   
    @SuppressWarnings("unchecked")  
    dataType out = (dataType) data[index];
    return out;
  }

  public dataType[] get(int min, int max){
    if (min<0){
      min =0;
    }

    if(max>len){
      max = len-1;
    }
    @SuppressWarnings("unchecked")
    Object[] d = new Object[len];
    for(int i=min; i<= max; i++){
      d[i] = data[i];
    }
    dataType[] out = (dataType[]) d;
    return out;
  }

	public dataType[] get(){
		@SuppressWarnings("unchecked")
		dataType[] out = (dataType[]) data;
		return out;
	}

  public void add(dataType d){
    int open = 0;
    for(int i =0; i< data0.length; i++){
      if(data0[i]==null){
        open = i;
        break;
      }
    }
    len++;
    data0[open] = d;
    data = data0;
    set0();
  }

  public void add(int index, dataType d){
    data0[index] = d;
    for(int i=index; i<data.length;i++){
      data0[i+1] = data[i];
    }
		len++;
    data = data0;
    set0();
  }

	/*
	public void read(Path path){
	}
	*/

	public void save(String name){

		Path path = makeFile(name);
		File file = new File(path.toString());
		try{
			FileWriter fr = new FileWriter(file, true);
			fr.write("<" + id+ "," + this.data.length + ">=[");
			id++;
			fr.close();
		}
		catch(IOException e){
			System.out.println("please enter a valid path");
		}
		for(int i=0;i<data.length;i++){
			try{
				FileWriter fr = new FileWriter(file, true);

				if(i != data.length-1){
					fr.write("{" + data[i]+"},");
				} else{
					fr.write("{" + data[i]+"}]");
				}
				fr.close();
			}
			catch(IOException e){
				break;
			}
		}

	}

	private Path makeFile(String name){
		@SuppressWarnings("unchecked")
		int o =1;
		File myArr;
		try{
			myArr = new File("./Data/"+ name +".arr");
			if(myArr.createNewFile()){

			}
			else{
				name = name+o;
				o++;
				makeFile(name);
			}
		}
		catch(IOException e){
			System.out.println("Error");
		}
		Path path = Paths.get("./Data/"+name+".arr");
		return path;
	}

	public String remove(int index){
		@SuppressWarnings("unchecked")
		String out = "" +data[index];
		data	= new Object[data.length-1];
		for(int i =0; i<index; i++){
			data[i] = data0[i];
		}
		for(int i= index+1; i<data.length; i++){
			data[i] = data0[i+1];
		}
		len--;
		set0();
		return out;
	}

	private void set0(){
		data0 = new Object[data.length+1];
    for(int i =0; i<data.length; i++){
      data0[i] = data[i];
    }
	}
	
	public int size(){
    return len;
  }

  public String toString(){
    String out = "[ ";
    if(data.length >0){
      out += data[0];
    }
    for(int i =1; i<data.length; i++){
      out += ", " + data[i];
    }
    out += " ]";
    return out;
  }
}