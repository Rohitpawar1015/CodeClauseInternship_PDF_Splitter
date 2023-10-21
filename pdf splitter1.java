//import java.util.*;
import java.io.*;

class Splitter
{
    public static void main(String args[])
    {
        try{      //for handling exception
            byte b[]=new byte[1000000];   //binary size...
            int x=1,j=0;
            String s="";

            InputStreamReader isr=new InputStreamReader(System.in);    //for taking input from user

            BufferedReader br=new BufferedReader(isr);  //read the file

            System.out.println("enter path of Source or original file:");

            String path=br.readLine(); //used for input...

            FileInputStream fis= new FileInputStream(path);   //path

            int read_bytes;   //count actual bytes..
            
            while(fis.available()!=0)   //check is their any data available for reading or not
            {
                j=0;
                s="";
                if(x<=9)
                {
                    s=path+".00"+x;  //no assign to each part it should be threee digit  ex.001,002
                }
                else{
                    s=path+".00"+x;        //011,012,013.......
                }
                FileOutputStream fos=new FileOutputStream(s);    //writing binary data
                while(j<=50000000 && fis.available()!=0)   //for create equal file part
                {
                    read_bytes=fis.read(b,0,1000000);
                    j=j+read_bytes;
                    fos.write(b,0,read_bytes);
                }
                System.out.println("part"+x+"Created");
                x++;
            }
            System.out.println("File splitted succesfully");     //show output
            fis.close();

        }
        catch(Exception e)  //handle exception
        {
            e.printStackTrace();
        }
    }
}
