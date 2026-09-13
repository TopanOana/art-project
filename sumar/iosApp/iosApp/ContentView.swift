import SwiftUI
import SumarShared

/// The Compose app, as a SwiftUI view.
///
/// Ignoring the safe areas is deliberate: Compose reads the insets itself and lays its content out
/// inside them, the same way `enableEdgeToEdge()` does on Android.
struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea(.all)
    }
}
