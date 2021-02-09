package id.indosw.musicplayer.app.networking

object Api {

    init {
        System.loadLibrary("native-lib")
    }

    private external fun stringFromJNI(): String
    private external fun stringArrayFromJNI(): Array<String>
    private val api2 = stringArrayFromJNI()
    val ListMusic = stringFromJNI()
    val DetailMusic = api2[1]
}