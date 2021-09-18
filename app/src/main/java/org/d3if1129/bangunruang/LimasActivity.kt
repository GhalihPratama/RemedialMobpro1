package org.d3if1129.bangunruang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LimasActivity : AppCompatActivity() {
    lateinit var ed_la_prisma : EditText
    lateinit var ed_tinggi_prisma : EditText

    lateinit var btn_hitung_prisma : Button
    lateinit var tv_hasil_prisma : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prisma)

        ed_la_prisma = findViewById(R.id.ed_la_prisma)
        ed_tinggi_prisma = findViewById(R.id.ed_tinggi_prisma)
        btn_hitung_prisma = findViewById(R.id.btn_hitung_prisma)
        tv_hasil_prisma = findViewById(R.id.tv_hasil_prisma)

        btn_hitung_prisma.setOnClickListener {
            var la : Int = Integer.parseInt(ed_la_prisma.text.toString())
            var tinggi : Int = Integer.parseInt(ed_tinggi_prisma.text.toString())

            if(tinggi.equals("")){
                Toast.makeText(this, "Tinggi Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
            }else if(la.equals("")){
                Toast.makeText(this, "Luas Alas Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
            }else{
                var hasil : Int = 1/3*la*tinggi

                tv_hasil_prisma.text = hasil.toString()
            }
        }
    }
}