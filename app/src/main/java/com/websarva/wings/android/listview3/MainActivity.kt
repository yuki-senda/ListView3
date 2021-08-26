package com.websarva.wings.android.listview3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.websarva.wings.android.listview3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var menuArrayList:ArrayList<Menu>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.karaage_bento,R.drawable.hamburger_set,R.drawable.mix_piza,
            R.drawable.kaisendon,R.drawable.yakiniku_bento)

        val name = arrayListOf(
            "唐揚げ弁当","チーズバーガーセット","ミックスピザ","海鮮丼","焼肉弁当")

        val menuPrice = arrayListOf(
            "800円","900円","1000円","1100円","1200円",)

        menuArrayList = ArrayList()

//        val dataList = arrayListOf<Data>().apply {
//            var data = Data()
//            for (i in 0..32) {
//                data.icon = "${i} 番目のアイコン"
//                data.title = "${i} 番目のタイトル"
//                data.text = "${i} 番目のテキスト"
//                this.add(data)
//            }
//        }
//        print(dataList)

//        val datalist = arrayListOf<Menu>().apply {
//            var data = Menu()
//            for (i in 0..32){
//                data.menuName = "${i}"
//                data.menuPrice = "${i}"
//                menuArrayList.add(data)
//            }
//        }
//        print(datalist)

        for (i in 0 until 20){
            for(i in name.indices){
                val menu = Menu(name[i],menuPrice[i],imageId[i])
                menuArrayList.add(menu)
            }
        }

        binding.listView.isClickable = true
        binding.listView.adapter = CustomAdapter(this,menuArrayList)
        binding.listView.setOnItemClickListener {parent, view, position,id ->

            val name = name[position]
            val imageId = imageId[position]
            val menuPrice = menuPrice[position]

            val i = Intent(this,MenuActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("menuPrice",menuPrice)
            i.putExtra("imageId",imageId)

            startActivity(i)
        }
    }
}