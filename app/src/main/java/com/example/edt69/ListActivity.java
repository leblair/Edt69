package com.example.edt69;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {


    List<Anime> animes = new ArrayList();
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }


    private void getAnimes() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                //1. method get post
                Request.Method.GET,
                //2. Json file
                Constants.IP, //PONER LA URL DE ANIMES PARA PEDIR EL ARRAY DE JSON
                //3. if there is petition
                null,
                //4. in case response ok
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Fill my arraylist with json data
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Anime anime = new Anime();
                                anime.setName(jsonObject.getString("name"));
                                anime.setType(jsonObject.getString("type"));
                                anime.setDescription(jsonObject.getString("description"));
                                anime.setYear(jsonObject.getInt("year"));
                                anime.setImageurl(jsonObject.getString("image"));
                                /*Anime peak = new Peak();
                                peak.setName(jsonObject.getString("name"));
                                peak.setHeight(jsonObject.getString("height"));
                                peak.setProminence(jsonObject.getString("prominence"));
                                peak.setZone(jsonObject.getString("zone"));
                                peak.setUrl(jsonObject.getString("url"));
                                peak.setCountry(jsonObject.getString("country"));*/
                                animes.add(anime);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        //RecyclerView
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        myAdapter = new MyAdapter(getApplicationContext(), animes);
                        recyclerView.setAdapter(myAdapter);
                    }
                },
                //5. in case of Error
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ListActivity.this, "Error reading data", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsonArrayRequest);
    }
}