package com.rafael.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.widget.Toast
import androidx.activity.viewModels
import com.rafael.businesscard.App
import com.rafael.businesscard.R
import com.rafael.businesscard.data.BusinessCard
import com.rafael.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)  }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insert()
    }

    private fun insert(){
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirmar.setOnClickListener{
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString(),
            )

            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}