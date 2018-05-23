package gs.apklib.example.lib

import com.google.auto.service.AutoService
import dagger.Component
import javax.inject.Singleton

@AutoService(EntryPoint::class)
class EntryPointImpl : EntryPoint {
    private val injector = DaggerEntryPointImpl_Injector.create()

    override fun provideMyService() = injector.provideMyService()

    @Singleton
    @Component(modules = [EntryPointModule::class])
    interface Injector {

        fun provideMyService(): MyService

    }

}
