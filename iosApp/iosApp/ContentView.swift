import UIKit
import SwiftUI
import shared
import Combine

struct ComposeView: UIViewControllerRepresentable {
    
//    @StateObject private var loadPersonPresenter = LoadPersonPresenter()
    
    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController(person: Person(name: "Ethan123", height: "12", mass: "sf", url: "123"))
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}




