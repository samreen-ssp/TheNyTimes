package  com.newyork.nytimes.di


import com.newyork.nytimes.BuildConfig
import com.newyork.nytimes.data.remote.api.NYNewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NYTimesApiModule {
    @Singleton
    @Provides
    fun provideRetrofitService(): NYNewsService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()
        .create(NYNewsService::class.java)
}
