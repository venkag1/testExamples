package listExample;
import java.io.*;

public class ListFiles {

    public static void parseFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (file.exists()) {
            parseFile(file);
        } else {
            throw new FileNotFoundException(file.getPath());
        }
    }

    public static void parseFile(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            for(File child : file.listFiles()) {
                parseFile(child);
            }
        } else if (file.exists()) {
            // Process file here
            System.out.println(file.getPath());
        } else {
            throw new FileNotFoundException(file.getPath()); 
        }
    }
    
    public static void main(String args[]){
    	String path = null;
    	if(args.length > 0){
	    	for (int i = 0; i < args.length; i++) {
	            System.out.println("Argument #" + i + " = " + args[i]);
	            
	        }
    	}else{
    		System.out.println("Error: Path not specified");
    	}
    	path = args[0];
    	ListFiles lf = new ListFiles();
    	try {
			lf.parseFile(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}