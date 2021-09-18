package org.d3if1129.bangunruang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class KubusActivity : AppCompatActivity() {
    lateinit var ed_sisi_kubus : EditText
    lateinit var btn_hitung_kubus : Button
    lateinit var tv_hasil_kubus : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kubus)

        btn_hitung_kubus = findViewById(R.id.btn_hitung_kubus)
        tv_hasil_kubus = findViewById(R.id.tv_hasil_kubus)
        ed_sisi_kubus = findViewById(R.id.ed_sisi_kubus)

        btn_hitung_kubus.setOnClickListener{
            var sisi : Int = Integer.parseInt(ed_sisi_kubus.text.toString())

            if(sisi.equals("")){
                Toast.makeText(this, "Sisi Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
            }else{
                var volume : Int = sisi*sisi*sisi

                tv_hasil_kubus.text = volume.toString()
            }
        }
    }
}