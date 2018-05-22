package gs.apklib.example.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

class Application : DaggerApplication() {

    override fun applicationInjector() =
            DaggerApplication_Injector.builder()
                    .create(this)

    @Singleton
    @Component(modules = [ApplicationModule::class])
    interface Injector : AndroidInjector<Application> {

        @Component.Builder
        abstract class Builder : AndroidInjector.Builder<Application>()

    }

}
