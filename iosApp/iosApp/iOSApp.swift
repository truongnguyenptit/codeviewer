import SwiftUI

@main
struct iOSApp: App {
    
    init(){
        KoinApplication.start()
    #if DEBUG
            //        NapierInit().doInit()
    #else
            println("I'm running in a non-DEBUG mode")
    #endif
    }
        
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
