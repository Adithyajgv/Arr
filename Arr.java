import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

class Arr <dataType> {

  private Object[] data;
  private Object[] data0;
  private int len =0;
	private int id;

	
 
  public Arr(int d){ 
    data = new Object[d];   
    data0 = new Object[d+1];
    len = d-1;
  }

	public Arr(String path){ 
		try{
			String temp = load(path);
			temp = temp.substring(1,temp.length()-1);
			int t =0;
			for(int i =0; i<temp.length(); i++){
				if(temp.substring(i,i+1).equals(",")){
					t =i;
					break;
				}
			}

			this.id = Integer.parseInt(temp.substring(0,t));
			temp = temp.substring(t+1);

			for(int i =0; i<temp.length(); i++){
				if(temp.substring(i,i+1).equals(">")){
					t =i;
					break;
				}
			}
			this.len  = Integer.parseInt(temp.substring(0,t));
			temp = temp.substring(t+4);
			temp = temp.substring(0,temp.length()-1);

			data = new Object[len];
			data0 = new Object[len+1];
			len = len-1;

			temp = temp.replace("}","");
			temp = temp.replace("{","");
			
			//System.out.println(temp);
			data = temp.split(",");
			data0= temp.split(",");
		}
		catch(Exception e){
			throw e;
		}
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


	private String load(String path){
		//@SuppressWarnings("unchecked")
		try{
			File file = new File(path);
			FileReader reader = new FileReader(file);

			int d;
			String out = new String();
			while ((d = reader.read()) != -1){
				char temp = (char)d;
				out+=temp;
			}
			reader.close();
			return out;

		} catch(IOException e){
			System.out.println(e);
			return "";
		}
	}

	public void save(String name){

		Path path = makeFile(name);
		File file = new File(path.toString());
		try{
			FileWriter fr = new FileWriter(file, false);
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
				/*name = name+o;
				o++;
				makeFile(name);*/
			boolean t = myArr.createNewFile();
			if(!t){
				while(!t){
					myArr = new File("./Data/" +name+o+".arr");
					o++;
					t = myArr.createNewFile();
					//System.out.println(t);
				}
				name = name+(o-1);
			}
			
		}
		catch(IOException e){
			System.out.println(e);
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
      out += "," + data[i];
    }
    out += " ]";
    return out;
  }
}