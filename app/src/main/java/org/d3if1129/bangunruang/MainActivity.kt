package org.d3if1129.bangunruang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn_kubus : Button
    lateinit var btn_balok : Button
    lateinit var btn_prisma : Button
    lateinit var btn_limas : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_kubus = findViewById(R.id.btn_kubus)
        btn_balok = findViewById(R.id.btn_balok)
        btn_prisma = findViewById(R.id.btn_prisma)
        btn_limas = findViewById(R.id.btn_limas)

        btn_kubus.setOnClickListener {
            var intent = Intent(this, KubusActivity::class.java)
            startActivity(intent)
        }

        btn_balok.setOnClickListener {
            var intent = Intent(this, BalokActivity::class.java)
            startActivity(intent)
        }

        btn_prisma.setOnClickListener {
            var intent = Intent(this, PrismaActivity::class.java)
            startActivity(intent)
        }

        btn_limas.setOnClickListener {
            var intent = Intent(this, LimasActivity::class.java)
            startActivity(intent)
        }
    }
}