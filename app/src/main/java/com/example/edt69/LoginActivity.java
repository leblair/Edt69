package com.example.edt69;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private Button signup, signin;
    private TextInputLayout email;
    private TextInputLayout pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = findViewById(R.id.signuplogin);
        email = findViewById(R.id.emailogin);
        pass = findViewById(R.id.passwordlogin);

        signup.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        signin.setOnClickListener(v -> {
            login(email.getEditText().getText().toString(), pass.getEditText().getText().toString());
        });
    }

    private void login(String email, String pass) {
        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject object = new JSONObject(
                Request.Method.GET,
                Constants.IP + Constants.HTDOCS + Constants.LOGINUSER + "?email=" + email + "&password=" + pass,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            response.getString("name");
                        } catch (Exception e) {

                        }
                    },/*new Response.ErrorListener()

                    {
                        @Override
                        public void onErrorResponse (VolleyError error){
                        Log.d("tag", "onErrorResponse:" + error.getMessage());
                    }
                    }*/

        );
                }


            /*    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
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
                        try {
                            response.getString(jso)
                            response.setName(jsonObject.getString("name"));
                            anime.setType(jsonObject.getString("type"));
                            anime.setDescription(jsonObject.getString("description"));
                            anime.setYear(jsonObject.getInt("year"));
                            anime.setImageurl(jsonObject.getString("image"));
                                *//*Anime peak = new Peak();
                                peak.setName(jsonObject.getString("name"));
                                peak.setHeight(jsonObject.getString("height"));
                                peak.setProminence(jsonObject.getString("prominence"));
                                peak.setZone(jsonObject.getString("zone"));
                                peak.setUrl(jsonObject.getString("url"));
                                peak.setCountry(jsonObject.getString("country"));*//*
                            animes.add(anime);

                        } catch (JSONException e) {
                            e.printStackTrace();
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
                        Toast.makeText(SignupActivity.this, "Error reading data", Toast.LENGTH_SHORT).show();
                    }
                });*/
                //  queue.add(jsonArrayRequest);
                //}
    }