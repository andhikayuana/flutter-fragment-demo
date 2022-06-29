package id.yuana.flutter_play

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class App : Application() {

    lateinit var flutterEngine: FlutterEngine

    override fun onCreate() {
        super.onCreate()
        setupFlutterEngineCache()
    }

    private fun setupFlutterEngineCache() {
        FlutterEngine(this).apply {
            dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
        }.let {
            flutterEngine = it
            FlutterEngineCache
                .getInstance()
                .put("my_engine_id", it)
        }

    }
}