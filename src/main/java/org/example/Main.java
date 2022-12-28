package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static JSONArray addBuilding(String name, String city, String FoundationYear, JSONArray jsonArray) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("BlName", name);
        jo.put("city", city);
        jo.put("FoundationYear", FoundationYear);
        jsonArray.put(jo);
        return jsonArray;
    }
    public static void main(String[] args) throws IOException, ParseException, JSONException {
        Path filePath= Path.of("C:\\Users\\lenovo\\Downloads\\untitled1\\src\\main\\java\\org\\example\\json.json");
        String str = Files.readString(filePath) ;
        //JSONParser jsonParser = new JSONParser();
        JSONArray jsonarray = new JSONArray(str);
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("1-list buildings" +
                    "\n2-add building" +
                    "\n3- end");
            int input = in.nextInt();
            if(input==1)
            {
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String BlName = jsonobject.getString("BlName");
                    String city = jsonobject.getString("city");
                    String FoundationYear = jsonobject.getString("FoundationYear");
                    System.out.println("building " +(i+1)+ ": \n"
                    + " name: "+ BlName+
                    ",\n city: "  + city+
                     ",\n FoundationYear: "+FoundationYear+"\n" );
                }
            }
           else if(input==2)
            {
                System.out.println("Enter building name: ");
                String lName = in.nextLine();
                String BlName = in.nextLine();
                System.out.println("Enter building city: ");
                String city = in.nextLine();
                System.out.println("Enter building FoundationYear: ");
                String FoundationYear = in.nextLine();
                JSONArray arr = addBuilding(BlName,city,FoundationYear,jsonarray);
                jsonarray = arr;
                FileWriter file = new FileWriter("C:\\Users\\lenovo\\Downloads\\untitled1\\src\\main\\java\\org\\example\\json.json");
                file.write(jsonarray.toString());
                file.close();
            }
           else if(input==3)
            {
               exit(0);
            }
        }
    }
}