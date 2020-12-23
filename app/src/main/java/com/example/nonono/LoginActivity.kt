package com.example.nonono

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONArray

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        lgn.setOnClickListener {

            val username="Cristi"
            val password="Crisan"


            val log_url="http://34.107.31.239/login.php"
            val stringRequest: StringRequest = object: StringRequest(Method.POST,
                    log_url,
                    { response->
                        val jsonarr= JSONArray(response)
                        val jsonobj=jsonarr.getJSONObject(0)
                        val code=jsonobj.getString("code")
                        val msg=jsonobj.getString("message")
                        Toast.makeText(this, "$code $msg", Toast.LENGTH_LONG).show()
                    },
                    { error->


                    }){

                override fun getParams(): MutableMap<String, String> {
                    val params=HashMap<String,String>()
                    params.put("Username",username)
                    params.put("Password",password)


                    return params
                }

            }
            MySingleton.getInstance(this).addToRequestQueue(stringRequest)
        }

    }
}