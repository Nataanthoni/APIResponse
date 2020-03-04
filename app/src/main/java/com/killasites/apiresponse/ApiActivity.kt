package com.killasites.apiresponse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.killasites.apiresponse.adapter.ListingAdapter
import com.killasites.apiresponse.data.Result
import com.killasites.apiresponse.model.Listing
import kotlinx.android.synthetic.main.activity_api_calls.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_calls)

        SwapiApi.instance.getSwapiResponse()
            .enqueue(object : Callback<List<Listing>> {
                override fun onFailure(call: Call<List<Listing>>, t: Throwable) {

                    SweetAlertDialog(this@ApiActivity, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText(t.message)
                        .show()
                }

                override fun onResponse(
                    call: Call<List<Listing>>,
                    response: Response<List<Listing>>
                ) {

                    if(response.isSuccessful){
                        //Return response body

                        SweetAlertDialog(this@ApiActivity, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Successfully fetched data")
                            .show()

                            val listingsList : List<Listing> = response.body()!!

                            textView.text = listingsList.toString()


                    }
                    else{
                        SweetAlertDialog(this@ApiActivity, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Response Error")
                            .show()
                    }
                }

            })


    }
}
