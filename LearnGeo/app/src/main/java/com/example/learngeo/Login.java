package com.example.learngeo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    MaterialButton login, register, registerP;
    TextInputLayout mobileLay, passLay, mobilePLay, passPLay, cPassPLay, emailPLay, namePLay;
    TextInputEditText mobile, pass, mobileP, passP, cPassP, emailP, nameP;
    String MOBILE, PASS, MOBILEP, PASSP, CPASSP, EMAILP, NAMEP;
    public static String UID;
    SharedPreferences sharedPreferences;
    AlertDialog pop;
    public static String LOGIN_TYPE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        mobile = findViewById(R.id.mobileed);
        pass = findViewById(R.id.password);
        register = findViewById(R.id.register);
        mobileLay = findViewById(R.id.mobileLayout);
        passLay = findViewById(R.id.passLayout);

        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() > 9) {
                    mobileLay.setError(null);
                }
            }
        });
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() > 8) {
                    passLay.setError(null);
                }
            }
        });
        login.setOnClickListener(view -> {
            MOBILE = mobile.getText().toString();
            PASS = pass.getText().toString();
            if (MOBILE.isEmpty() || MOBILE.length() < 10) {
                mobileLay.setError("Enter mobile number");
            } else if (PASS.isEmpty() || PASS.length() < 8) {
                passLay.setError("Enter password");
            } else {
                UserLogin();
            }
        });
        register.setOnClickListener(view -> {
            View popLayout = LayoutInflater.from(Login.this).inflate(R.layout.register_layout, null);
            mobileP = popLayout.findViewById(R.id.mobile);
            mobilePLay = popLayout.findViewById(R.id.mobileLayout);
            passP = popLayout.findViewById(R.id.password);
            passPLay = popLayout.findViewById(R.id.passLayout);
            cPassP = popLayout.findViewById(R.id.Cpassword);
            cPassPLay = popLayout.findViewById(R.id.CpassLayout);
            emailP = popLayout.findViewById(R.id.email);
            emailPLay = popLayout.findViewById(R.id.emailLayout);
            nameP = popLayout.findViewById(R.id.name);
            namePLay = popLayout.findViewById(R.id.nameLayout);
            registerP = popLayout.findViewById(R.id.register);
            AlertDialog.Builder popBuilder = new AlertDialog.Builder(Login.this).setView(popLayout);
            pop = popBuilder.show();
            mobileP.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().length() > 9) {
                        mobilePLay.setError(null);
                    }
                }
            });
            passP.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    PASSP = passP.getText().toString();
                    if (editable.toString().length() > 8) {
                        passPLay.setError(null);
                    }
                }
            });
            cPassP.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable.length() > 0 && PASSP.length() > 0) {
                        if (!cPassP.getText().toString().equals(PASSP)) {
                            cPassPLay.setError("Password not match");
                        } else {
                            cPassPLay.setError(null);
                        }
                    }
                }
            });
            emailP.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().length() > 8) {
                        emailPLay.setError(null);
                    }
                }
            });
            nameP.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().length() > 8) {
                        namePLay.setError(null);
                    }
                }
            });
            registerP.setOnClickListener(view1 -> {
                MOBILEP = mobileP.getText().toString();
                PASSP = passP.getText().toString();
                CPASSP = cPassP.getText().toString();
                EMAILP = emailP.getText().toString();
                NAMEP = nameP.getText().toString();
                if (MOBILEP.length() < 9) {
                    mobilePLay.setError("Enter mobile number");
                } else if (EMAILP.isEmpty()) {
                    emailPLay.setError("Enter email");
                } else if (NAMEP.isEmpty()) {
                    namePLay.setError("Enter name");
                } else if (PASSP.length() < 7) {
                    passPLay.setError("Enter password");
                } else if (CPASSP.isEmpty()) {
                    cPassPLay.setError("Enter confirm password");
                } else if (!(CPASSP.equals(PASS)) && !(PASSP.equals(CPASSP))) {
                    cPassPLay.setError("Passwords do not match ");
                } else {
                    UserRegister();
                }
            });
        });
    }

    private void UserRegister() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, config.DATA_URL, ServerResponse -> {
            // Matching server response message to our text.
            Log.e("Register Response", ServerResponse);
            try {
                JSONObject object = new JSONObject(ServerResponse);
                String str = object.getString("message");
                switch (str) {
                    case "Account exists":
                        Toast.makeText(this, "Account exists", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, Login.class);
                        startActivity(intent);
                        break;
                    case "Registration Successful":
                        UID = object.getString("uid");
                        pop.dismiss();
                        sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("UID", UID);
                        editor.putString("TYPE", "user");
                        editor.apply();
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(this,MainActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case "An error occurred":
                        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException ignored) {

            }
        },
                volleyError -> {
                    // Showing error message if something goes wrong.
                    Toast.makeText(this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    Log.e("Error",volleyError.toString());
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<>();
                // Adding All values to Params.
                params.put("case", "register");
                params.put("mobile", MOBILEP);
                params.put("password", PASSP);
                params.put("type", "user");
                params.put("email", EMAILP);
                params.put("name", NAMEP);

                return params;
            }
        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
    }

    private void UserLogin() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, config.DATA_URL,
                ServerResponse -> {
                    // Matching server response message to our text.
                    Log.e(" Login Response ", ServerResponse);
                    try {
                        JSONObject object = new JSONObject(ServerResponse);
                        String str = object.getString("Message");

                        switch (str) {
                            case "Login Success":
                                UID = object.getString("uid");
                                LOGIN_TYPE = object.getString("type");
                                sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("UID", UID);
                                editor.putString("TYPE", LOGIN_TYPE);
                                editor.apply();
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Login.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case "Password Wrong":
                                // Showing Echo Response Message Coming From Server.
                                Toast.makeText(Login.this, "Wrong Credentials", Toast.LENGTH_LONG).show();
                                break;
                            case "Try Again":
                                // Showing Echo Response Message Coming From Server.
                                Toast.makeText(Login.this, "Account does not Exist", Toast.LENGTH_LONG).show();
                            /*Intent intent=new Intent(Login.this,MainActivity.class);
                            startActivity(intent);*/
                                break;
                            default:
                                // Showing Echo Response Message Coming From Server.
                                Toast.makeText(Login.this, ServerResponse, Toast.LENGTH_LONG).show();
                                break;
                        }

                    } catch (JSONException ignored) {

                    }

                },
                volleyError -> {
                    // Showing error message if something goes wrong.
                    Toast.makeText(Login.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    Log.e("error",volleyError.toString());
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<>();
                // Adding All values to Params.
                params.put("case", "login");
                params.put("mobile", MOBILE);
                params.put("password", PASS);
                return params;
            }
        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
    }



}