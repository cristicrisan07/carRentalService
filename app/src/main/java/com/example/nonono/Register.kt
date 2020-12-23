 package com.example.nonono

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONArray
import org.json.JSONObject

 class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        reg_btn.setOnClickListener{

            val username="Cristi"
            val password="Crisan"
            val address="str. mea"
            val lastname="Alexandru"
            val firstname="Ciubaca"
            val email="acasalamamasitata@yahoo.com"
            val pic="1234567891234"
            val dled="2028/12/12"
            val reg_url="http://34.107.31.239/register.php"
            val stringRequest:StringRequest= object:StringRequest(Method.POST,
                    reg_url,
                    { response->
                        val jsonarr=JSONArray(response)
                        val jsonobj=jsonarr.getJSONObject(0)
                        val code=jsonobj.getString("code")
                        val msg=jsonobj.getString("message")
                  Toast.makeText(this, "$code $msg",Toast.LENGTH_LONG).show()
                    },
                    { error->


                    }){

                override fun getParams(): MutableMap<String, String> {
                 val params=HashMap<String,String>()
                    params.put("Last_name",lastname)
                    params.put("First_name",firstname)
                    params.put("Address",address)
                    params.put("Dled",dled)
                    params.put("Password",password)
                    params.put("Email",email)
                    params.put("User_name",username)
                    params.put("Pic",pic)
                    return params
                }

                }
              MySingleton.getInstance(this).addToRequestQueue(stringRequest)
            }

            }




        }



