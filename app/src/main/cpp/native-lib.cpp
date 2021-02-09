#include <jni.h>
#include <string>
#include <android/log.h>
#include <cstring>

extern "C" JNIEXPORT jstring JNICALL
Java_id_indosw_musicplayer_app_networking_Api_stringFromJNI(JNIEnv* env, __unused jclass clazz) {
    std::string domain = "https://animemusic.us/listmusic";
    __android_log_write(ANDROID_LOG_DEBUG, "API123", "Debug Log");
    return env->NewStringUTF(domain.c_str());
}

extern "C"
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wwritable-strings"
JNIEXPORT jobjectArray JNICALL Java_id_indosw_musicplayer_app_networking_Api_stringArrayFromJNI(JNIEnv *env, __unused jclass clazz) {
    char *days[]={"bins",
                  "https://animemusic.us/jsongetid/{id}",
                  "Django",
                  "SQL",
                  "Swift",
                  "Kotlin",
                  "Springs"};
    jstring str;
    jobjectArray day;
    jsize len = 7;
    int i;
    day = env->NewObjectArray(len,env->FindClass("java/lang/String"),nullptr);
    for(i=0;i<7;i++)
    {
        str = env->NewStringUTF(days[i]);
        env->SetObjectArrayElement(day,i,str);
    }
    return day;
}
#pragma clang diagnostic pop

