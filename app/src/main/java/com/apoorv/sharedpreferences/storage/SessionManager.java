package com.apoorv.sharedpreferences.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Apoorv Vardhman on 26-11-2019
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  developerapoorv.xyz
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class SessionManager {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String EMAIL = "Email";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("user_sesion",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void register(String email,String password,String name)
    {
        editor.putString(NAME,name);
        editor.putString(EMAIL,email);
        editor.putString(PASSWORD,password);
        editor.apply();
    }


    public String getEmail()
    {
        return sharedPreferences.getString(EMAIL,"");
    }

    public String getPassword()
    {
        return sharedPreferences.getString(PASSWORD,"");
    }

    public String getName()
    {
        return sharedPreferences.getString(NAME,"");
    }


    public void clearData()
    {
        editor.clear();
        editor.commit();
        editor.apply();
    }

}
