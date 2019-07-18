package com.example.internshiptask;

import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> params;
     ImageView animalimage;
     RecyclerView recyclerView;
     String url = "https://qurbaniapp2.herokuapp.com/posts/getspecificanimal_4" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView=findViewById(R.id.animalRecyclerView);

         RequestQueue queue = Volley.newRequestQueue(this);


        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("qurbaniapp2.herokuapp.com")
                .appendPath("v1")
                .appendPath("posts")
                .appendPath("getspecificanimal_4/")
                .appendQueryParameter("user_id","1307")
                .appendQueryParameter("catagory","cow")
                .appendQueryParameter("version","59")
                .appendQueryParameter("page","1")
                .appendQueryParameter("city","no")
                .appendQueryParameter("weigh","no")
                .appendQueryParameter("price","no")
                .appendQueryParameter("featured","no")
                .appendQueryParameter("filter","yes");



        String myUrl = builder.build().toString();


        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("HttpClient", "success! response: " + response.toString());
                        Log.i("iamtag",response.substring(0,500));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("iamtag","That didn't work!");
                        Log.e("HttpClient", "error: " + error.toString());
                    }
                })
        {
                @Override
        protected Map<String,String> getParams(){
            params = new HashMap<String, String>();
            params.put("user_id","1307");
            params.put("catagory","cow");
            params.put("version","59");
            params.put("page","1");
            params.put("city","no");
            params.put("weigh","no");
            params.put("price","no");
            params.put("featured","no");
            params.put("qurbani","no");
            params.put("filter","yes");


            return params;
        }

    };

        queue.add(sr);

    }
}

























