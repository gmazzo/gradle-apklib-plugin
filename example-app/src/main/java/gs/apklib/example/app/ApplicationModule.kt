package gs.apklib.example.app

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class, MyServiceModule::class])
interface ApplicationModule {

    @Binds
    fun bindContext(impl: Application): Context

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}