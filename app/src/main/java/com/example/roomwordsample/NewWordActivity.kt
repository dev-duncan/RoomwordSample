package com.example.roomwordsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_new_word.*

class NewWordActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editWordView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        button_save.setOnClickListener(this)
    }



    override fun onClick(p0: View?) {
      when(p0?.id){
          R.id.button_save->{
              val replyIntent = Intent()
              if (TextUtils.isEmpty(editWordView.text)) {
                  setResult(Activity.RESULT_CANCELED, replyIntent)
              } else {
                  val word = editWordView.text.toString()
                  replyIntent.putExtra(EXTRA_REPLY, word)
                  setResult(Activity.RESULT_OK, replyIntent)
              }
              finish()
          }
      }

    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}