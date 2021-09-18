package org.d3if1129.bangunruang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class BalokActivity : AppCompatActivity() {
    lateinit var ed_panjang_balok : EditText
    lateinit var ed_lebar_balok : EditText
    lateinit var ed_tinggi_balok : EditText

    lateinit var btn_hitung_balok : Button
    lateinit var tv_hasil_balok : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balok)

        ed_panjang_balok = findViewById(R.id.ed_panjang_balok)
        ed_lebar_balok = findViewById(R.id.ed_lebar_balok)
        ed_tinggi_balok = findViewById(R.id.ed_tinggi_balok)
        btn_hitung_balok = findViewById(R.id.btn_hitung_balok)
        tv_hasil_balok = findViewById(R.id.tv_hasil_balok)

        btn_hitung_balok.setOnClickListener {
            var lebar : Int = Integer.parseInt(ed_lebar_balok.text.toString())
            var panjang : Int = Integer.parseInt(ed_panjang_balok.text.toString())
            var tinggi : Int = Integer.parseInt(ed_tinggi_balok.text.toString())

            if(lebar.equals("")){
                Toast.makeText(this, "Lebar Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
            }else if(panjang.equals("")){
                Toast.makeText(this, "Panjang Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
            }else if(tinggi.equals("")){
                Toast.makeText(this, "Tinggi Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
            }else if(tinggi.equals("")||lebar.equals("")||panjang.equals("")){
                Toast.makeText(this, "Harap diisi semua data", Toast.LENGTH_SHORT).show();
            }else{
                var hasil : Int = panjang*lebar*tinggi

                tv_hasil_balok.text = hasil.toString()
            }
        }
    }
}