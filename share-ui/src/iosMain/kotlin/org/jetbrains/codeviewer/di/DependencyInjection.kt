package org.jetbrains.codeviewer.di


import com.russhwolf.settings.*
import org.jetbrains.codeviewer.viewmodel.ApplicationViewModel
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.dsl.module
import platform.Foundation.NSBundle
import platform.Foundation.NSUserDefaults

@OptIn(ExperimentalSettingsApi::class)
fun initKoinIos(
    userDefaults: NSUserDefaults,
    doOnStartup: () -> Unit
): KoinApplication = initKoin{
    module {
        single { BundleProvider(bundle = NSBundle.mainBundle) }
        single<ObservableSettings> { AppleSettings(delegate = userDefaults) }
        single<Settings> { NSUserDefaultsSettings(userDefaults) }
        single { doOnStartup }
    } + uiModule
}

//fun initKoinIos(
//    userDefaults: NSUserDefaults,
//    doOnStartup: () -> Unit
//): KoinApplication = initKoin{
//    module {
//        single<Settings> { NSUserDefaultsSettings(userDefaults) }
//        single { doOnStartup }
//    }
//}

// Workaround class for injecting an `NSObject` class.
// When not used, an error "KClass of Objective-C classes is not supported." is thrown.
data class BundleProvider(val bundle: NSBundle)

val Koin.applicationViewModel: ApplicationViewModel
    get() = get()
