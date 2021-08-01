package com.example.week4assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myArrayList: ArrayList<Contact>
    private lateinit var newRecyclerView: RecyclerView
    lateinit var myImage: Array<Int>
    lateinit var myText: Array<String>
    lateinit var contact: Array<String>
    lateinit var phoneNumber: Array<String>

    lateinit var adapter: AdapterRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        myImage= arrayOf(
            R.drawable.fernandes,
            R.drawable.paugba,
            R.drawable.greenwood,
            R.drawable.greenwood2,
            R.drawable.ronaldo,
            R.drawable.ronaldo2,
            R.drawable.ozil2,
            R.drawable.ozil2,
            R.drawable.ronaldo2,
            R.drawable.greenwood2,
            R.drawable.greenwood2,
            R.drawable.greenwood2

        )

        myText = arrayOf(
            "Bruno Fernandes",
            "Paul Labile Paugba",
            "Mason Greenwood",
            "Mason Greenwood",
            "Cristiano Ronaldo",
            "Cristiano Ronaldo",
            "Mesuit Ozil",
            "Paul Labile Paugba",
            "cristiano Ronaldo",
            "Mason Greenwood",
            "greenwood",
            "greenwood"

        )


        contact = arrayOf(
            getString(R.string.bruno),
            getString(R.string.paugba),
            getString(R.string.greenwood),
            getString(R.string.greenwood),
            getString(R.string.cr7),
            getString(R.string.cr7),
            getString(R.string.ozil),
            getString(R.string.paugba),
            getString(R.string.cr7),
            getString(R.string.greenwood),
            getString(R.string.greenwood),
            getString(R.string.greenwood),




        )

        phoneNumber = arrayOf(
            getString(R.string.phone),
            getString(R.string.phoneNumber),
            getString(R.string.phoneNumber1),
            getString(R.string.phoneNumber2),
            getString(R.string.phoneNumber3),
            getString(R.string.phoneNumber4),
            getString(R.string.phoneNumber5),
            getString(R.string.phoneNumber6),
            getString(R.string.phoneNumber7),
            getString(R.string.phoneNumber8),
            getString(R.string.phoneNumber9),
            getString(R.string.phoneNumber10),

        )

        newRecyclerView = findViewById(R.id.recyclerview)
       newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        myArrayList= ArrayList()
        userContact()



    }

    fun userContact(){
        for(i in myImage.indices){
            val newContact = Contact(myImage[i],myText[i])
            myArrayList.add(newContact)
        }

        val adapter = AdapterRecycler(myArrayList)
      newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : AdapterRecycler.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MainActivity,"you clicked on item no. $postion",Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("image",myArrayList[position].image)
                intent.putExtra("contactList", myArrayList[position].contactList)
                intent.putExtra("contact", contact[position])
                intent.putExtra("getPhoneNumber",phoneNumber[position])
                startActivity(intent)

            }


        })
    }

}