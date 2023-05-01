package ru.startandroid.develop.fragmentdynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var frag1: Fragment1
    private lateinit var frag2: Fragment2
    private lateinit var fTrans: FragmentTransaction
    private lateinit var chbStack: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frag1 = Fragment1()
        frag2 = Fragment2()

        chbStack = findViewById<View>(R.id.chbStack) as CheckBox
    }

    fun onClick(v: View) {
        fTrans = supportFragmentManager.beginTransaction()
        when(v.id) {
            R.id.btnAdd -> fTrans.add(R.id.frgmCont, frag1)
            R.id.btnRemove -> fTrans.remove(frag1)
            R.id.btnReplace -> fTrans.replace(R.id.frgmCont, frag2)
            else -> {}
        }
        if (chbStack.isChecked) fTrans.addToBackStack(null)
        fTrans.commit()
    }
}