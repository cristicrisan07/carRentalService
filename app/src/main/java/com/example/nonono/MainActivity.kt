package com.example.nonono


import android.content.Context
import android.content.Intent
import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        altbuton.setOnClickListener {


        startActivity(Intent(this,Register::class.java))
        }
     loginbtn.setOnClickListener {
         startActivity(Intent(this,LoginActivity::class.java))
     }
        }



}







