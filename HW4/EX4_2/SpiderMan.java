/**
 * this class starts at a URL, then finds more URLs to add to a list. from all these webpages, it stores all email addresses it finds
 * it supports custom URLS if called as 'java SpiderMan _____' using String[] args
 * @author Kyle Shepard
 */

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

public class SpiderMan{
    static Set<String> emails = new HashSet<String>();                      //string set to avoid duplicates
    static ArrayList<String> siteList = new ArrayList<String>();            
    static Map<String,Boolean> siteMap = new HashMap<String,Boolean>();
    static String urlText = "https://www.kxly.com/station/contact-kxly/171599929";
    static int count = 1;
    static int lineNum = 0;

    public static void main(String[] args) {
        try {

            if (args.length > 0)
                urlText = args[0];

            //initialize Spider for inoput processing
            URL url = new URL(urlText);
            BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));   //start reading source html
            String line;
            line = rdr.readLine();
            Pattern email = Pattern.compile("\"mailto:(.*?)\"");
            Pattern website = Pattern.compile("href=\"https://www.(.*?)\"");
            Matcher emailMatcher;
            Matcher websiteMatcher;
            
            //add first site to URL list
            siteMap.put(urlText,true);
            siteList.add(urlText);
            
            while (true) {  //only exits when a break point is reached or an exceotion occcurs
                
                emailMatcher = email.matcher(line);
                websiteMatcher = website.matcher(line);

                if (emailMatcher.find()){   // if email is found, add it

                    emails.add(emailMatcher.group(1));
                }
                else if (websiteMatcher.find()){    //if new webpage has been found, add it to List and Map
                    if (siteMap.size() < 100){
                        if(!siteMap.containsKey("https://www." + websiteMatcher.group(1))){
                            siteList.add("https://www." + websiteMatcher.group(1));
                            siteMap.put("https://www." + websiteMatcher.group(1),false);
                        }
                    }
                }
                
                line = rdr.readLine();  //peak at next line 

                if (line == null){      //end of html source reached
                    for(int i = 0; i < siteList.size(); i++){    // look through site list
                        if(!siteMap.get(siteList.get(i))){       //if site has not been visited
                            System.out.println("Reading site " + count++ + " of " + siteMap.size());

                            if(count > 100) break;               //website maximum has been reached, so exit

                            urlText = siteList.get(i);           //start up first unvisited site in list to be scanned
                            siteMap.put(urlText,true);
                            url = new URL(urlText);
                            rdr = new BufferedReader(new InputStreamReader(url.openStream()));
                            line = rdr.readLine();
                            i = siteList.size();
                        }
                    }
                }

            }

        }
        catch (Exception ex) { System.out.printf("\nFailed for %s\n", urlText);}

        //Print out results
        System.out.print("\nEmails:\n\n");
        for(String s: emails)
            System.out.println(s);

        System.out.print("\n\nSites:\n\n");
        for(int i = 0; i < siteList.size(); i++){
            String s = siteList.get(i);
            System.out.println((i + 1) + ") " + s + ": visited = " + siteMap.get(s));
        }

    }
}