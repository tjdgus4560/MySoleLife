package com.example.mysolelife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.mysolelife.R
import com.example.mysolelife.contentsList.BookmarkModel
import com.example.mysolelife.databinding.ActivityBoardWriteBinding
import com.example.mysolelife.utils.FBAuth
import com.example.mysolelife.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        binding.writeBtn.setOnClickListener{
            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()

            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            Log.d(TAG, title)
            Log.d(TAG, content)


            FBRef.boardRef
                .push()
                .setValue(BoardModel(title, content, uid, time))

        }

        // board
        //  - key
        //      -boardModel(title, content, uid, time)



    }
}