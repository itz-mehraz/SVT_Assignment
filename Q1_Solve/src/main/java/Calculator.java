public class Calculator {

    public Integer add(Integer a, Integer b){

       if(a==null || b==null){
            return null;
       }

        return a+b;
    }


    public Integer divide(Integer a, Integer b){
        if(a==null || b==null){
            return null;
        }

        return a/b;
    }


    private final int[] sharedArray = {1, 2, 3};

    public int[] getArray(){

        return sharedArray;
    }

    public String getString(String str){
        return str;
    }


    public void getException() throws Exception{
        throw new Exception("Exception");

    }


}
