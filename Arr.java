class Arr <dataType> {

  public Object[] data;
  public Object[] data0;
  private int len =0;
 
  public Arr(int d){ 
    data = new Object[d];   
    data0 = new Object[d+1];
    len = d;
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
    data0 = new Object[data.length +1];
    for(int i =0; i<data.length; i++){
      data0[i] = data[i];
    }
  }

  public void add(int index, dataType d){
    data0[index] = d;
    for(int i=index; i<data.length;i++){
      data0[i+1] = data[i];
    }
    data = data0;
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