/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Note {
    // initalize vars
    private String title;
    private String contents;

    public Note(){
        title = "";
        contents = "";
    }
    
    public Note(String t, String c){
        this.title = t;
        this.contents = c;
    }

    public String[] viewNote(String path) throws IOException {
        String[] endString = new String[2];
        
        // Read from the file when viewing 
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        // initalize and fill vars
        String nTitle = br.readLine();
        String nContent = "";
        String nextLine = "";

        while((nextLine = br.readLine()) != null) {
            nContent += nextLine + "<br>";
        }
        
        // set the attributes for the string array and send it down
        endString[0] = nTitle;
        endString[1] = nContent;
       
        // Return the formatted endString
        return endString;
    }

    public void editNote(String path, String givenTitle, String givenContents) throws IOException{
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        String writeToFile = givenTitle += "\n" + givenContents;

        // Write Formatted String to File 
        pw.write(writeToFile);

        // close after use
        pw.close();

    }

    // getters
    public String getTitle() { return title; }
    public String getContents() { return contents; }

    // setters 
    public void setTitle(String t) { title = t; }
    public void setContents(String c) { contents = c; }

}
