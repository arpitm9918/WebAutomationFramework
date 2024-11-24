package org.WebAutomationFrameWork.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    // Read the browser = Chrome -> give to DriverManager
    //This PropertyReader class is designed to fetch the value of a key from a data.properties
    // file located in the src/main/resources directory of the project.

//    public PropertyReader() {// default constructor
//    }

    public static String readKey(String key) {
        //variable declaration
        FileInputStream fileInputStream = null;
        Properties p = null;
        try {
            // /Users/promode/IdeaProjects/ATB7xWebAutomationFramework
            //FileInputStream:Opens the data.properties file for reading.
            //basically here we reading the data.properties file
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
            p = new Properties();//create new instance of properties class
            //he Properties class in Java is a utility designed specifically to handle key-value pairs
            //This object (p) will store all the key-value pairs loaded from the properties file
            p.load(fileInputStream);
            //Reads data from the file specified by fileInputStream(here data properties file is specified by the fileinputstram).
            //The load() method parses the file content and stores the key-value pairs
            // into the Properties object (p).
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(key);//Fetches the value for a key
    }
}
