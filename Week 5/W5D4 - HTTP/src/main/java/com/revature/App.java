package com.revature;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class App 
{

    public static OkHttpClient client = new OkHttpClient();
    public static void main( String[] args )
    {
        try {
            // attempt to get information from the API
            // asking for, from the list of pokemon, get reference to one pokemon
            String result = run("https://pokeapi.co/api/v2/pokemon?limit=1");

            System.out.println(result);

            // askeing for the specific pokemon's information (it's a lot!)
            String result2= run("https://pokeapi.co/api/v2/pokemon/1/");

            System.out.println(result2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    

    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
