package mm.com.csstechnology.elottery.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Lera on 30.08.2017.
 */
class RetrofitBuilder private constructor() {
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    //                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    val apiService: APIService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://us-central1-myanlottery.cloudfunctions.net/")
                    .addConverterFactory(GsonConverterFactory.create(gson)) //                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
            }
            return retrofit!!.create(APIService::class.java)
        }

    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build()

    companion object {
        private var retrofit: Retrofit? = null
        var instance: RetrofitBuilder? = null
            get() {
                if (field == null) {
                    field = RetrofitBuilder()
                }
                return field
            }
            private set
    }
}